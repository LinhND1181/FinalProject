import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { UserAddEditComponent } from '../admin-user/user-add-edit/user-add-edit.component';
import { UserService } from '../../../services/user.service';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatSort, MatSortModule } from '@angular/material/sort';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { UserModel } from '../../../models/user';
import { CoreService } from '../../../core/core.service';
import { MatDrawer } from '@angular/material/sidenav';

@Component({
  selector: 'app-admin-home',
  templateUrl: './admin-home.component.html',
  styleUrl: './admin-home.component.scss'
})
export class AdminHomeComponent implements OnInit {

  isBadgeVisible: boolean = false;
  
  badgeVisibility() {
    this.isBadgeVisible = true;
  }

  displayedColumns: string[] = ['id', 'username', 'email', 'gender', 'actions'];
  dataSource!: MatTableDataSource<any>;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private _dialog: MatDialog, private userService: UserService, private coreService: CoreService) { }

  ngOnInit(): void {
    this.getUserList();
  }

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

  getUserList() {
    this.userService.getAllUsers().subscribe({
      next: (res) => {
        this.dataSource = new MatTableDataSource(res.data);
        this.dataSource.sort = this.sort;
        this.dataSource.paginator = this.paginator;
      },
      error: console.log,
    });
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  deleteUserById(userId: number) {
    this.userService.deleteUserById(userId).subscribe({
      next: (res) => {
        this.coreService.openSnackBar('Employee ' + userId + ' has been deleted', 'Done');
        this.getUserList();
      },
      error: console.log,
    })
  }

  openEditUserForm(data: any) {
    const dialogRef = this._dialog.open(UserAddEditComponent, {
      data,
    });
    dialogRef.afterClosed().subscribe({
      next: (val) => {
        if (val) {
          this.getUserList();
        }
      }
    })
  }

}
