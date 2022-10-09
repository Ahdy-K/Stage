import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class OfferService {

  constructor(private http: HttpClient) {

  }


  makeOffer(form: any): Observable<any> {
    let httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json','Accept':'application/json', 'Authorization': `Bearer ${window.localStorage.getItem('token')}` })
    };
    console.log(window.localStorage.getItem('token'))

    return this.http.post('http://localhost:8081/api-entreprise/makeoffer', form)

  }
}
