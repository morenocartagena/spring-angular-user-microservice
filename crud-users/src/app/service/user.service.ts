import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserModel } from '../model/user-model';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient: HttpClient) { 

  }

  getUsers(): Observable<UserModel[]>{
    return this.httpClient.get<UserModel[]>('http://localhost:9000/api/v1/user' + '/list').pipe(map(res => res));
  }

  saveUser(request: any): Observable<any>{
    return this.httpClient.post<any>('http://localhost:9000/api/v1/user' + '/save', request).pipe(map(res => res));
  }

  updateUser(request: any): Observable<any>{
    return this.httpClient.post<any>('http://localhost:9000/api/v1/user' + '/update', request).pipe(map(res => res));
  }

  deleteUser(id: number): Observable<any>{
    return this.httpClient.get<any>('http://localhost:9000/api/v1/user' + '/delete/' + id).pipe(map(res => res));
  }

}
