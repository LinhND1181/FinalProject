import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './layout/login/login.component';
import { AdminHomeComponent } from './layout/admin/admin-home/admin-home.component';
import { AdminCardComponent } from './shared/admin/admin-card/admin-card.component';
import { NotFoundComponent } from './layout/not-found/not-found.component';
import { AuthGuardService } from './services/auth-guard.service';

const routes: Routes = [
  { path: 'login', component: LoginComponent},
  { path: 'ad',
    loadChildren: () => import('./layout/admin//admin-lazyload/admin.module').then(m => m.AdminModule),
    component: AdminHomeComponent, canActivate: [AuthGuardService]
  },
  { path: 'card', component: AdminCardComponent, canActivate: [AuthGuardService]},
  { path: 'not-found', component: NotFoundComponent}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
