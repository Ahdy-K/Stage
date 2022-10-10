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
    return this.http.post('http://localhost:8081/api-entreprise/makeoffer', form)

  }
  getOffers(): Observable<any> {

    return this.http.get('http://localhost:8081/api-entreprise/offers')

  }
}
