import { Component, ViewChild } from '@angular/core';
import { CategoryAddEditComponent } from '../category-add-edit/category-add-edit.component';
import { MatTableDataSource } from '@angular/material/table';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { CoreService } from '../../../../core/core.service';
import { CategoryService } from '../../../../services/category.service';
import { CategoryDeleteConfirmationComponent } from '../category-delete-confirmation/category-delete-confirmation.component';
import { Category } from '../../../../models/category';

@Component({
  selector: 'app-category-dasboard',
  templateUrl: './category-dasboard.component.html',
  styleUrl: './category-dasboard.component.scss'
})
export class CategoryDasboardComponent {
  isBadgeVisible: boolean = false;

  badgeVisibility() {
    this.isBadgeVisible = true;
  }

  displayedColumns: string[] = ['code', 'name', 'parentCategory', 'createdAt', 'createdBy', 'updatedAt', 'updatedBy', 'status', 'actions'];
  dataSource!: MatTableDataSource<any>;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private _dialog: MatDialog, private categoryService: CategoryService, private coreService: CoreService) { }

  ngOnInit(): void {
    this.getCategoryList();
  }

  // mở form add và edit người dùng
  openAddEditCategoryForm() {
    const dialogRef = this._dialog.open(CategoryAddEditComponent);
    dialogRef.afterClosed().subscribe({
      next: (val: any) => {
        if (val) {
          this.getCategoryList();
        }
      }
    })
  }

  // lấy danh sách người dùng và áp dụng chúng vào data của mat table
  getCategoryList() {
    this.categoryService.getAllCategories().subscribe({
      next: (res: { data: any; }) => {
        this.dataSource = new MatTableDataSource(res.data);
        this.dataSource.sort = this.sort;
        this.dataSource.paginator = this.paginator;
      },
      error: console.log,
    });
  }

  // lọc và phân trang
  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  // kích hoạt người dùng theo id
  activateCategoryById(categoryId: number){
    this.categoryService.activateCategoryById(categoryId).subscribe({
      next: (res) => {
        this.coreService.openSnackBar('Category ' + categoryId + ' has been activated', 'Done');
        this.getCategoryList();
      },
      error: console.log
    })
  }

  // khoá người dùng theo id
  deActivateCategoryById(categoryId: number){
    this.categoryService.deactiveCategoryById(categoryId).subscribe({
      next: (res) => {
        this.coreService.openSnackBar('category ' + categoryId + ' has been deactivated', 'Done');
        this.getCategoryList();
      },
      error: console.log
    })
  }

  // mở form sửa thông tin người dùng
  openEditCategoryForm(data: any) {
    const dialogRef = this._dialog.open(CategoryAddEditComponent, {
      data,
    });
    dialogRef.afterClosed().subscribe({
      next: (val) => {
        if (val) {
          this.getCategoryList();
        }
      },
      error: console.log
    })
  }

   // mở modal xác nhận xoá
   openDeleteConfirmationForm(data: any){
    const dialogRef = this._dialog.open(CategoryDeleteConfirmationComponent, {
      data,
    });
    dialogRef.afterClosed().subscribe({
      next: (val) => {
        if (val) {
          this.getCategoryList();
        }
      },
      error: console.log
    })
  }
}
