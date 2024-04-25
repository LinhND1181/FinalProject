import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatMenuModule } from '@angular/material/menu';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { FormsModule } from '@angular/forms'; 
import { MatCard, MatCardModule } from '@angular/material/card';
import { ReactiveFormsModule } from '@angular/forms';
import { MatHint } from '@angular/material/input';
import { MatError } from '@angular/material/input';
import { FlexLayoutModule } from '@angular/flex-layout';
import { MatBadgeModule } from '@angular/material/badge';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatList, MatListModule } from '@angular/material/list';
import { MatTableModule } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort, MatSortModule } from '@angular/material/sort';
import { MatDialogModule } from '@angular/material/dialog';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { DateAdapter, MAT_DATE_FORMATS, MAT_DATE_LOCALE, MatNativeDateModule } from '@angular/material/core';
import { MatRadioModule } from '@angular/material/radio';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatTabsModule } from '@angular/material/tabs';

import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HomeComponent } from './layout/user/home/home.component';
import { AdminHomeComponent } from './layout/admin/admin-home/admin-home.component';
import { AdminHeaderComponent } from './shared/admin/admin-header/admin-header.component';
import { AdminFooterComponent } from './shared/admin/admin-footer/admin-footer.component';
import { HeaderComponent } from './shared/user/header/header.component';
import { FooterComponent } from './shared/user/footer/footer.component';
import { LoginComponent } from './layout/login/login.component';
import { RegisterComponent } from './layout/user/register/register.component';
import { AdminCategoryComponent } from './layout/admin/admin-category/admin-category.component';
import { AdminUserComponent } from './layout/admin/admin-user/admin-user.component';
import { UserAddEditComponent } from './layout/admin/admin-user/user-add-edit/user-add-edit.component';
import { NotFoundComponent } from './layout/not-found/not-found.component';
import { UserDeleteConfirmationComponent } from './layout/admin/admin-user/user-delete-confirmation/user-delete-confirmation.component';
import { AdminCardComponent } from './shared/admin/admin-card/admin-card.component';
import { AdminMenubarComponent } from './shared/admin/admin-menubar/admin-menubar.component';
import { UserDashboardComponent } from './layout/admin/admin-user/user-dashboard/user-dashboard.component';
import { UserDetailsComponent } from './layout/admin/admin-user/user-details/user-details.component';
import { CategoryAddEditComponent } from './layout/admin/admin-category/category-add-edit/category-add-edit.component';
import { CategoryDasboardComponent } from './layout/admin/admin-category/category-dasboard/category-dasboard.component';
import { CategoryDeleteConfirmationComponent } from './layout/admin/admin-category/category-delete-confirmation/category-delete-confirmation.component';
import { VndPipePipe } from './shared/pipes/vnd-pipe.pipe';
import { MAT_MOMENT_DATE_FORMATS, MomentDateAdapter, MomentDateModule } from '@angular/material-moment-adapter';



@NgModule({
  declarations: [
    AppComponent,
    AdminHomeComponent,
    HomeComponent,
    AdminHeaderComponent,
    AdminFooterComponent,
    HeaderComponent,
    FooterComponent,
    LoginComponent,
    RegisterComponent,
    AdminCategoryComponent,
    AdminUserComponent,
    UserAddEditComponent,
    NotFoundComponent,
    UserDeleteConfirmationComponent,
    AdminCardComponent,
    AdminMenubarComponent,
    UserDashboardComponent,
    UserDetailsComponent,
    CategoryAddEditComponent,
    CategoryDasboardComponent,
    CategoryDeleteConfirmationComponent,
    VndPipePipe,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatInputModule,
    MatSelectModule,
    MatAutocompleteModule,
    MatToolbarModule,
    MatMenuModule,
    MatIconModule,
    MatButtonModule,
    FormsModule,
    MatCardModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatHint,
    MatError,
    FlexLayoutModule,
    MatBadgeModule,
    MatSidenavModule,
    MatListModule,
    MatTableModule,
    MatPaginator,
    MatSortModule,
    MatDialogModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatRadioModule,
    MatTableModule,
    MatSort,
    MatSnackBarModule,
    MatCheckboxModule,
    MatTabsModule,
    MatCard,
    MatList,
    MomentDateModule
  ],
  providers: [
    { provide: MAT_DATE_LOCALE, useValue: 'en-GB' }, // Thay đổi ngôn ngữ tại đây nếu cần
    { provide: MAT_DATE_FORMATS, useValue: MAT_MOMENT_DATE_FORMATS },
    { provide: DateAdapter, useClass: MomentDateAdapter }
  ],
  bootstrap: [AppComponent],
})


export class AppModule { }
