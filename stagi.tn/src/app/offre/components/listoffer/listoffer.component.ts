import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OffreService } from '../../services/offre.service';

@Component({
  selector: 'app-listoffer',
  templateUrl: './listoffer.component.html',
  styleUrls: ['./listoffer.component.css']
})
export class ListofferComponent implements OnInit {

  constructor(private offreService: OffreService,private router: Router) { }

  ngOnInit(): void {
    this.getoffers()
    this.getentreprises()
  }

  ListOffers: any
  ListEntreprises:any

  //get All Offers
  getoffers(): void {
    this.offreService.getoffers().subscribe(
      data => {
        this.ListOffers = data
        console.log(data)
      },
      error => {
        console.log(error)
      }
    )


  }
  //get entreprises by Id
  getentreprise(id: number): void {
    this.offreService.getEntrepriseById(id).subscribe(
      data => {
        console.log(data);

      },
      error => {
        console.log(error)
      }
    )


  }
  //get all entreprisese
  getentreprises(): void {
    this.offreService.getEntreprises().subscribe(
      data => {
        this.ListEntreprises=data

      },
      error => {
        console.log(error)
      }
    )


  }
  //get offer details
  getOffersdetails(id:number):void{
   
        this.router.navigate(["detailsOffer/",id])
   

  }



}
