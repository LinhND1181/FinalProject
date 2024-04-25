import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Category } from '../../../../models/category';
import { CategoryService } from '../../../../services/category.service';
import { CoreService } from './../../../../core/core.service';
import { Component, Inject, OnDestroy, OnInit } from '@angular/core';

@Component({
  selector: 'app-category-delete-confirmation',
  templateUrl: './category-delete-confirmation.component.html',
  styleUrl: './category-delete-confirmation.component.scss'
})
export class CategoryDeleteConfirmationComponent implements OnInit, OnDestroy {

  constructor(private categoryService: CategoryService, 
              private coreService: CoreService, 
              @Inject(MAT_DIALOG_DATA) public data: any) { }

  ngOnInit(): void {
    
  }

  ngOnDestroy(): void {

  }

  // xóa người dùng theo id
  deleteCategoryById() {
    if(this.data !== null){
      this.categoryService.deleteCategoryyId(this.data.id).subscribe({
        next: (res) => {
          // hiển thị snackbar sau khi xóa thành công và lấy lại danh sách người dùng
          this.coreService.openSnackBar('Danh mục ' + this.data.name + ' đã được xoá', 'Thành công');
          this.categoryService.getAllCategories();
        },
        error: console.log
      })
    }
  }

}
