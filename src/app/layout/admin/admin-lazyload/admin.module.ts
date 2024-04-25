import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminHomeComponent } from '../admin-home/admin-home.component';
import { AdminCategoryComponent } from '../admin-category/admin-category.component';
import { RouterModule, Routes } from '@angular/router';
import { UserDashboardComponent } from '../admin-user/user-dashboard/user-dashboard.component';
import { CategoryDasboardComponent } from '../admin-category/category-dasboard/category-dasboard.component';

const routes: Routes = [
  { path: '', component: UserDashboardComponent },
  { path: 'cate', component: CategoryDasboardComponent },
  { path: 'user', component: UserDashboardComponent }
];

@NgModule({
  declarations: [],
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminModule { }
