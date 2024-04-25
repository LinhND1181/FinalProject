import { Component, OnInit, ViewChild } from '@angular/core';
import { UserAddEditComponent } from '../user-add-edit/user-add-edit.component';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { UserService } from '../../../../services/user.service';
import { CoreService } from '../../../../core/core.service';

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrl: './user-dashboard.component.scss'
})
export class UserDashboardComponent implements OnInit {

  isBadgeVisible: boolean = false;

  badgeVisibility() {
    this.isBadgeVisible = true;
  }

  displayedColumns: string[] = ['id','username', 'role', 'fullName', 'email','phoneNumber', 'status', 'actions'];
  dataSource!: MatTableDataSource<any>;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private _dialog: MatDialog, private userService: UserService, private coreService: CoreService) { }

  ngOnInit(): void {
    this.getUserList();
  }

  // mở form add và edit người dùng
  openAddEditUserForm() {
    const dialogRef = this._dialog.open(UserAddEditComponent);
    dialogRef.afterClosed().subscribe({
      next: (val) => {
        if (val) {
          this.getUserList();
        }
      }
    })
  }

  // lấy danh sách người dùng và áp dụng chúng vào data của mat table
  getUserList() {
    this.userService.getAllUsers().subscribe({
      next: (res) => {
        this.dataSource = new MatTableDataSource(res.data);
        this.dataSource.sort = this.sort;
        this.dataSource.paginator = this.paginator;
      },
      error: console.log
    });
  }

  // phân trang
  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  // xóa người dùng theo id
  deleteUserById(userId: number) {
    this.userService.deleteUserById(userId).subscribe({
      next: (res) => {
        // hiển thị snackbar sau khi xóa thành công và lấy lại danh sách người dùng
        this.coreService.openSnackBar('User ' + userId + ' has been deleted', 'Done');
        this.getUserList();
      },
      error: console.log
    })
  }

  // kích hoạt người dùng theo id
  activateUserById(userId: number){
    this.userService.activateUserById(userId).subscribe({
      next: (res) => {
        this.coreService.openSnackBar('User ' + userId + ' has been activated', 'Done');
        this.getUserList();
      },
      error: console.log
    })
  }

  // khoá người dùng theo id
  deActivateUserById(userId: number){
    this.userService.deactiveUserById(userId).subscribe({
      next: (res) => {
        this.coreService.openSnackBar('user ' + userId + ' has been deactivated', 'Done');
        this.getUserList();
      },
      error: console.log
    })
  }

  // mở form sửa thông tin người dùng
  openEditUserForm(data: any) {
    const dialogRef = this._dialog.open(UserAddEditComponent, {
      data,
    });
    dialogRef.afterClosed().subscribe({
      next: (val) => {
        if (val) {
          this.getUserList();
        }
      },
      error: console.log
    })
  }

  // xuất báo cáo
  exportData(exportChoice: number){
    this.userService.exportData(exportChoice).subscribe({
      next: (res) => {
        this.coreService.openSnackBar('Data has been exported');
      },
      error: console.log
    })
  }

}
