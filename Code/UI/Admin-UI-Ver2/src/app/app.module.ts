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
import { AdminHomeComponent } from './layout/admin/admin-home/admin-home.component';
import { AdminHeaderComponent } from './shared/admin/admin-header/admin-header.component';
import { AdminFooterComponent } from './shared/admin/admin-footer/admin-footer.component';
import { LoginComponent } from './layout/login/login.component';
import { AdminCategoryComponent } from './layout/admin/admin-category/admin-category.component';
import { AdminUserComponent } from './layout/admin/admin-user/admin-user.component';
import { UserAddEditComponent } from './layout/admin/admin-user/user-add-edit/user-add-edit.component';
import { NotFoundComponent } from './layout/not-found/not-found.component';
import { UserDeleteConfirmationComponent } from './layout/admin/admin-user/user-delete-confirmation/user-delete-confirmation.component';
import { AdminCardComponent } from './shared/admin/admin-card/admin-card.component';
import { AdminSideNavBarComponent } from './shared/admin/admin-side-nav-bar/admin-side-nav-bar.component';
import { UserDashboardComponent } from './layout/admin/admin-user/user-dashboard/user-dashboard.component';
import { UserDetailsComponent } from './layout/admin/admin-user/user-details/user-details.component';
import { CategoryAddEditComponent } from './layout/admin/admin-category/category-add-edit/category-add-edit.component';
import { CategoryDasboardComponent } from './layout/admin/admin-category/category-dasboard/category-dasboard.component';
import { CategoryDeleteConfirmationComponent } from './layout/admin/admin-category/category-delete-confirmation/category-delete-confirmation.component';
import { VndPipePipe } from './shared/pipes/vnd-pipe.pipe';
import { MAT_MOMENT_DATE_FORMATS, MomentDateAdapter, MomentDateModule } from '@angular/material-moment-adapter';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { AdminCityComponent } from './layout/admin/admin-city/admin-city.component';
import { AdminCinemaComponent } from './layout/admin/admin-cinema/admin-cinema.component';
import { AdminCinemaRoomComponent } from './layout/admin/admin-cinema-room/admin-cinema-room.component';
import { CityAddEditComponent } from './layout/admin/admin-city/city-add-edit/city-add-edit.component';
import { CityDashboardComponent } from './layout/admin/admin-city/city-dashboard/city-dashboard.component';
import { CityDeleteCofimationComponent } from './layout/admin/admin-city/city-delete-cofimation/city-delete-cofimation.component';

@NgModule({
  declarations: [
    AppComponent,
    AdminHomeComponent,
    AdminHeaderComponent,
    AdminFooterComponent,
    LoginComponent,
    AdminCategoryComponent,
    AdminUserComponent,
    UserAddEditComponent,
    NotFoundComponent,
    UserDeleteConfirmationComponent,
    AdminCardComponent,
    AdminSideNavBarComponent,
    UserDashboardComponent,
    UserDetailsComponent,
    CategoryAddEditComponent,
    CategoryDasboardComponent,
    CategoryDeleteConfirmationComponent,
    VndPipePipe,
    AdminCityComponent,
    AdminCinemaComponent,
    AdminCinemaRoomComponent,
    CityAddEditComponent,
    CityDashboardComponent,
    CityDeleteCofimationComponent,
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
    provideAnimationsAsync()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
