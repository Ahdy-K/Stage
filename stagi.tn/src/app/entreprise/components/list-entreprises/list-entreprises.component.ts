import { Component, OnInit } from '@angular/core';
import { OffreService } from 'src/app/offre/services/offre.service';


@Component({
  selector: 'app-list-entreprises',
  templateUrl: './list-entreprises.component.html',
  styleUrls: ['./list-entreprises.component.css']
})
export class ListEntreprisesComponent implements OnInit {

  constructor(private offerservice: OffreService) { }

  ngOnInit(): void {
    this.getentreprises()
  }

  ListEntreprises: any
  //get all entreprisese
  getentreprises(): void {
    this.offerservice.getEntreprises().subscribe(
      data => {
        this.ListEntreprises = data
        console.log(data)

      },
      error => {
        console.log(error)
      }
    )

  }
}
