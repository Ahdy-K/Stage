import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  constructor(private http: HttpClient) {}


  constructor(private http:HttpClient) {

   }

   addUser(form:any):Observable<any>
   {

    return this.http.post('http://localhost:9090/api-user/add/user',form)

   }

   allUsers():Observable<any>{
    return this.http.get("http://localhost:9090/api-user/all")
   }

  addUser(form: any): Observable<any> {
    return this.http.post('http://localhost:9090/api-user/add/user', form);
  }
  getUser(id: any): Observable<any> {
    return this.http.get('http://localhost:9090/api-user/add/user/' + id);
  }
  updateUser(form: any, id: any): Observable<any> {
    return this.http.get('http://localhost:9090/api-user/add/' + id, form);
  }

}
