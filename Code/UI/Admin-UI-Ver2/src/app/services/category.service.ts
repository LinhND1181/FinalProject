import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { ErrorMessage, SERVER_ADMIN_URL, SERVER_NO_AUTH_URL, headers } from '../shared/basedUrls';
import { Observable, catchError, throwError } from 'rxjs';
import { AuthService } from './auth.service';
import { Category, CategoryModel } from '../models/category';

// khai báo các kiểu dữ liệu cần sử dụng
type ResponseObject = {
  data: Category,
  status: string
}

type ResponseObjectWithHeaderAndWithoutData = {
  status: string,
  headers: string
}

type ResponseObjectWithHeader = {
  data: Category,
  status: string,
  headers: string
}

type ResponseObjectWithStatus = {
  status: string;
}

@Injectable({
  providedIn: 'root'
})



export class CategoryService {
  

  constructor(private router: Router, private httpClient: HttpClient, private authService: AuthService) { }

  private errorMessage: Array<ErrorMessage> = new Array<ErrorMessage>();

  public getAllCategories(): Observable<any> {
    
    return this.httpClient.get<ResponseObjectWithStatus>
          (`${SERVER_NO_AUTH_URL}/cate-mn/get-all`)
          .pipe(
            catchError(error => {
              console.log('Error activating category: ', error);
              return throwError(() => error);
            })
          );
  }

  
  public getAllParentCategories(): Observable<any> {
    
    return this.httpClient.get<ResponseObjectWithStatus>
          (`${SERVER_NO_AUTH_URL}/cate-mn/get-all-parent`)
          .pipe(
            catchError(error => {
              console.log('Error activating category: ', error);
              return throwError(() => error);
            })
          );
  }

  public getAllChildrenCateggories(): Observable<any> {

    return this.httpClient.get<ResponseObjectWithStatus>
          (`${SERVER_NO_AUTH_URL}/cate-mn/get-all-children`)
          .pipe(
            catchError(error => {
              console.log('Error activating category: ', error);
              return throwError(() => error);
            })
          ); 

  }

  public createCategory(category: any): Observable<any> {

    if(this.authService.isUserAdmin()){
      const categoryModel: CategoryModel = new CategoryModel(category.id, category.name, category.parentCategoryId);

      return this.httpClient.post<ResponseObjectWithHeader>
            (`${SERVER_ADMIN_URL}/cate-mn/create`, categoryModel, { headers })
            .pipe(
              catchError(error => {
                console.log('Error activating category: ', error);
                return throwError(() => error)
              })
            );
    }
    return this.httpClient.get<any>(`${SERVER_NO_AUTH_URL}/not-found`);

  }

  public updateCategory(category: any, categoryId: number): Observable<any>{
    if(this.authService.isUserAdmin()){
      const categoryModel: CategoryModel = new CategoryModel(category.id, category.name, category.parentCategoryId);
        return this.httpClient.post<ResponseObjectWithHeader>
        (`${SERVER_ADMIN_URL}/cate-mn/edit/${categoryId}`, categoryModel, { headers })
        .pipe(
          catchError(error => {
            console.log('Error activating category: ', error);
            return throwError(() => error);
          })
        );
    }
    return this.httpClient.get<any>(`${SERVER_NO_AUTH_URL}/not-found`);
  }

  public deleteCategoryyId(categoryId: number): Observable<any>{
    if(this.authService.isUserAdmin()){
      return this.httpClient.delete<ResponseObjectWithHeaderAndWithoutData>
          (`${SERVER_ADMIN_URL}/cate-mn/delete/${categoryId}`, { headers })
          .pipe(
            catchError(error => {
              console.log('Error activating category: ', error);
              return throwError(() => error);
            })
          );  
    }
    return this.httpClient.get<any>(`${SERVER_NO_AUTH_URL}/not-found`);
  }

  public deactiveCategoryById(categoryId: number): Observable<any>{
    if(this.authService.isUserAdmin()){
      return this.httpClient.get<ResponseObjectWithHeaderAndWithoutData>
            (`${SERVER_ADMIN_URL}/cate-mn/deActivate/${categoryId}`, { headers })
            .pipe(
              catchError(error => {
                console.log('Error activating category: ', error);
                return throwError(() => error);
              })
            );
    }
    return this.httpClient.get<any>(`${SERVER_NO_AUTH_URL}/not-found`);
  }

  public activateCategoryById(categoryId: number): Observable<any>{
    if(this.authService.isUserAdmin()){
      return this.httpClient.get<ResponseObjectWithHeaderAndWithoutData>
            (`${SERVER_ADMIN_URL}/cate-mn/activate/${categoryId}`, { headers })
            .pipe(
              catchError(error => {
                console.log('Error activating category: ', error);
                return throwError(() => error);
              })
            );
    }
    return this.httpClient.get<any>(`${SERVER_NO_AUTH_URL}/not-found`);
  }

}
