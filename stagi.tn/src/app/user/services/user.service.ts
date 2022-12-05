import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  constructor(private http: HttpClient) { }




  addUser(form: any): Observable<any> {

    return this.http.post('http://localhost:9090/api-user/add/user', form)

  }

  allUsers(): Observable<any> {
    return this.http.get("http://localhost:9090/api-user/all")
  }




  addCv(form: any): Observable<any> {
    return this.http.post('http://localhost:9090/api-user/cv/upload', form);
  }



  getUser(id: any): Observable<any> {
    return this.http.get('http://localhost:9090/api-user/get/' + id);
  }
  updateUser(form: any, id: any): Observable<any> {
    return this.http.put(
      'http://localhost:9090/api-user/update/' + id,

      form
    );
  }

  getUserByEmail(email: string): Observable<any> {
    return this.http.get('http://localhost:9090/api-user/get-user/' + email);
  }


  getDetailresume(path: String): Observable<any> {
    return this.http.get('http://127.0.0.1:8000/detail/' + path)
  }
}
