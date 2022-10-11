import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OffreService {

  constructor(private http:HttpClient) {

  }

  getoffers():Observable<any>
  {

   return this.http.get('http://localhost:9099/offers/alloffers')

  }
  getEntrepriseById(id:number):Observable<any>
  {

   return this.http.get('http://localhost:8081/api-entreprise/get-entreprise-by-id'+id)

  }
  getEntreprises():Observable<any>
  {

   return this.http.get('http://localhost:9090/api-user/getEntreprises')

  }
}
