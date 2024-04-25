import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CategoryDasboardComponent as CategoryDashboardComponent } from '../../admin-category/category-dasboard/category-dasboard.component';

const routes: Routes = [
  { path: '', component: CategoryDashboardComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CategoryManagementRoutingModule { }
