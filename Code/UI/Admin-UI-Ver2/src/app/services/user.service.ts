import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { User, UserModel } from '../models/user';
import { ErrorMessage, SERVER_ADMIN_URL, SERVER_NO_AUTH_URL, headers } from '../shared/basedUrls';
import { Observable, catchError, throwError } from 'rxjs';
import { AuthService } from './auth.service';

// khai báo các kiểu dữ liệu cần sử dụng
type ResponseObject = {
  data: User,
  status: string
}

type ResponseObjectWithHeaderAndWithoutData = {
  status: string,
  headers: string
}

type ResponseObjectWithHeader = {
  data: User,
  status: string,
  headers: string
}

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private router: Router, private httpClient: HttpClient, private authService: AuthService) { }

  private errorMessages: Array<ErrorMessage> = new Array<ErrorMessage>();

  public createUser(user: any, avatar: File): Observable<any> {
    if (this.authService.isUserAdmin()) {
      const userModel: UserModel = new UserModel(user.username, user.password, user.email, user.fullName, user.birthday, user.gender, user.phoneNumber, user.address);
      const userFormData = new FormData();
      userFormData.append('avatar', avatar);
      return this.httpClient.post<ResponseObjectWithHeader>
            (`${SERVER_ADMIN_URL}/um/create`, userModel, { headers })
            .pipe(
              catchError(error => {
                console.log('Error activating user: ', error);
                return throwError(() => error);
              })
            );
    }
    return this.httpClient.get<any>(`${SERVER_NO_AUTH_URL}/not-found`);
  }

  public getAllUsers(): Observable<any> {

    // kiểm tra người dùng hiện tại có phải admin không
    // mới được thực hiện lấy data user
    if(this.authService.isUserAdmin()){
      return this.httpClient.get<ResponseObjectWithHeaderAndWithoutData>
            (`${SERVER_ADMIN_URL}/um/get-all`, { headers })
            .pipe(
              catchError(error => {
                console.log('Error activating user: ', error);
                return throwError(() => error);
              })
            );
    }
    return this.httpClient.get<any>(`${SERVER_NO_AUTH_URL}/not-found`);
  }

  public updateUser(user: any, avatar: File, userId: number): Observable<any> {
    if (this.authService.isUserAdmin()) {
      const userModel: UserModel = new UserModel(user.username, user.password, user.email, user.fullName, user.birthday, user.gender, user.phoneNumber, user.address);
      const userFormData = new FormData();
      userFormData.append('avatar', avatar);
      return this.httpClient.post<ResponseObjectWithHeader>
            (`${SERVER_ADMIN_URL}/um/edit/${userId}`, userModel, { headers })
            .pipe(
              catchError(error => {
                console.log('Error activating user: ', error);
                return throwError(() => error);
              })
            );
    }
    return this.httpClient.get<any>(`${SERVER_NO_AUTH_URL}/not-found`);
  }

  public deleteUserById(userId: number): Observable<any>{
    if(this.authService.isUserAdmin()){
      return this.httpClient.delete<ResponseObjectWithHeaderAndWithoutData>
          (`${SERVER_ADMIN_URL}/um/delete/${userId}`, { headers })
          .pipe(
            catchError(error => {
              console.log('Error activating user: ', error);
              return throwError(() => error);
            })
          );  
    }
    return this.httpClient.get<any>(`${SERVER_NO_AUTH_URL}/not-found`);
  }

  public deactiveUserById(userId: number): Observable<any>{
    if(this.authService.isUserAdmin()){
      return this.httpClient.get<ResponseObjectWithHeaderAndWithoutData>
            (`${SERVER_ADMIN_URL}/um/deActivate/${userId}`, { headers })
            .pipe(
              catchError(error => {
                console.log('Error activating user: ', error);
                return throwError(() => error);
              })
            );
    }
    return this.httpClient.get<any>(`${SERVER_NO_AUTH_URL}/not-found`);
  }

  public activateUserById(userId: number): Observable<any>{
    if(this.authService.isUserAdmin()){
      return this.httpClient.get<ResponseObjectWithHeaderAndWithoutData>
            (`${SERVER_ADMIN_URL}/um/activate/${userId}`, { headers })
            .pipe(
              catchError(error => {
                console.log('Error activating user: ', error);
                return throwError(() => error);
              })
            );
    }
    return this.httpClient.get<any>(`${SERVER_NO_AUTH_URL}/not-found`);
  }

  public exportData(exportChoice: number): Observable<any>{
    if(this.authService.isUserAdmin()){
      const currentUserId = Number(sessionStorage.getItem('id'));
      if(!isNaN(currentUserId)){
        return this.httpClient.get<ResponseObjectWithHeaderAndWithoutData>
              (`${SERVER_ADMIN_URL}/um/export/${exportChoice}/${currentUserId}`, { headers })
              .pipe(
                catchError(error => {
                  console.log('Error activating user: ', error);
                  return throwError(() => error);
                })
              );
      }
    }
    return this.httpClient.get<any>(`${SERVER_NO_AUTH_URL}/not-found`);
  }

  


}
