import { Component, OnInit, TemplateRef } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { OfferService } from '../offer.service';


@Component({
  selector: 'app-requests',
  templateUrl: './requests.component.html',
  styleUrls: ['./requests.component.css']
})
export class RequestsComponent implements OnInit {
  listRequest: any;
  id: any;

  constructor(private offerservice: OfferService, private activatedRoute: ActivatedRoute) { }


  ngOnInit(): void {
    this.getRequestPerOffer()

  }
  getRequestPerOffer() {
    this.activatedRoute.paramMap.subscribe({
      next: (p: ParamMap) => {
        this.id = p.get('id');
        return this.offerservice.getrequestPerOffer(this.id).subscribe({
          next: (data) => {
            
            this.listRequest = data;
            for(let l of this.listRequest ){
              this.offerservice.getUser(l.user_id).subscribe({
                next:(data)=>{
                  l.user=data
                }
              })
            }
            
            console.log(this.listRequest);
          },
          error: (error) => {
            console.log(error)

            {

            }
          },
        })
      }
    })
  }


}