import { CoreService } from './../../../../core/core.service';
import { Component, Inject, OnDestroy, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MyErrorStateMatcher } from '../../../login/login.component';
import { CategoryService } from '../../../../services/category.service';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { Category } from '../../../../models/category';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-category-add-edit',
  templateUrl: './category-add-edit.component.html',
  styleUrl: './category-add-edit.component.scss'
})
export class CategoryAddEditComponent implements OnInit, OnDestroy {
  selected: string = "";
  
  parentCategories: any;

  categoryForm: FormGroup;

  matcher: MyErrorStateMatcher = new MyErrorStateMatcher;

  constructor(private _fb: FormBuilder,
    private categoryService: CategoryService,
    private _dialogRef: MatDialogRef<CategoryAddEditComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private coreSerivce: CoreService
  ){

    // khởi tạo các input cho form
    this.categoryForm = this._fb.group({
      name: ['', [Validators.required, Validators.minLength(3)]],
      parentCategoryId: ['', [Validators.required, Validators.minLength(3)]]
    })

    this.categoryService.getAllParentCategories().subscribe({
      next: (res) => {
        this.parentCategories = res.data;
      },
      error: console.log
    })

  }

  ngOnInit(): void {
    if (this.data !== null) {

      this.categoryForm.patchValue({name: this.data.name, parentCategoryId: this.data.parentCategory.id});

    }
  }

  ngOnDestroy(): void {
      
  }

  onFormSubmit() {
    if(this.categoryForm.valid){

      // form chưa có data sẽ là form add
      if(!this.data){
        this.categoryService.createCategory(this.categoryForm.value).subscribe({
          next: (val: any) => {
            this.coreSerivce.openSnackBar('Category Added successfully', 'Done');
            this._dialogRef.close(true);
          },
          error: (err: any) => {
            console.log(err);
          }
        });
      }

      // form đã có data sẽ là form cập nhật
      else{
          this.categoryService.updateCategory(this.categoryForm.value, this.data.id).subscribe({
            next: (val: any) => {
              this.coreSerivce.openSnackBar('Category Updated Successfully', 'Done');
              this._dialogRef.close(true);
            },
            error: (err: any) => {
              console.log(err);
            }
          });
      }
    }
  
  }

}
