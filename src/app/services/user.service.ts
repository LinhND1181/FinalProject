import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { User, UserModel } from '../models/user';
import { ErrorMessage, SERVER_ADMIN_URL, SERVER_NO_AUTH_URL, headers } from '../shared/basedUrls';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';

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
      return this.httpClient.post<ResponseObjectWithHeader>(`${SERVER_ADMIN_URL}/um/create`, userModel, { headers });
    }
    return this.httpClient.get<any>(`$S{SERVER_NO_AUTH_URL}/not-found`);
  }

  public getAllUsers(): Observable<any> {
    if(this.authService.isUserAdmin()){
      return this.httpClient.get<ResponseObjectWithHeaderAndWithoutData>(`${SERVER_ADMIN_URL}/um/get-all`, { headers });
    }
    return this.httpClient.get<any>(`$S{SERVER_NO_AUTH_URL}/not-found`);
  }

  public updateUser(user: any, avatar: File, userId: number): Observable<any> {
    if (this.authService.isUserAdmin()) {
      const userModel: UserModel = new UserModel(user.username, user.password, user.email, user.fullName, user.birthday, user.gender, user.phoneNumber, user.address);
      const userFormData = new FormData();
      userFormData.append('avatar', avatar);
      return this.httpClient.post<ResponseObjectWithHeader>(`${SERVER_ADMIN_URL}/um/edit/${userId}`, userModel, { headers });
    }
    return this.httpClient.get<any>(`$S{SERVER_NO_AUTH_URL}/not-found`);
  }

  public deleteUserById(userId: number): Observable<any>{
    if(this.authService.isUserAdmin()){
      return this.httpClient.post<ResponseObjectWithHeaderAndWithoutData>(`${SERVER_ADMIN_URL}/um/delete/${userId}`,{}, { headers });
    }
    return this.httpClient.get<any>(`$S{SERVER_NO_AUTH_URL}/not-found`);
  }


}
