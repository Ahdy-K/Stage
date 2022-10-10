import { Component, OnInit } from '@angular/core';
import { OffreService } from '../../services/offre.service';

@Component({
  selector: 'app-listoffer',
  templateUrl: './listoffer.component.html',
  styleUrls: ['./listoffer.component.css']
})
export class ListofferComponent implements OnInit {

  constructor(private offreService:OffreService) { }

  ngOnInit(): void {

    this.getoffers()
  }

  getoffers():void
  {
   this.offreService.getoffers().subscribe(
    data =>{console.log(data);
    },
    error => {
      console.log(error)
    }
   )


  }


}
