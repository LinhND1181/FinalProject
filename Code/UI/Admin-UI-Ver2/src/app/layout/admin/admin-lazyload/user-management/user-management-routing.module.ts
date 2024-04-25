import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserDashboardComponent } from '../../admin-user/user-dashboard/user-dashboard.component';
import { UserDetailsComponent } from '../../admin-user/user-details/user-details.component';

const routes: Routes = [
  { path: '', component: UserDashboardComponent},
  { path: '/:id', component: UserDetailsComponent}

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserManagementRoutingModule { }
