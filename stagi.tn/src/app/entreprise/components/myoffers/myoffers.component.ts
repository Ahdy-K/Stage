import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { MakeofferComponent } from '../makeoffer/makeoffer.component';
import { OfferService } from '../offer.service';

@Component({
  selector: 'app-myoffers',
  templateUrl: './myoffers.component.html',
  styleUrls: ['./myoffers.component.css']
})
export class MyoffersComponent implements OnInit {

  constructor(public dialog: MatDialog,private offerservice:OfferService ) { }
  ngOnInit(): void {
    this.getOffers()

  }
  openDialog(enterAnimationDuration: string, exitAnimationDuration: string): void {
    this.dialog.open(MakeofferComponent, { width: "50" ,height:"50"});


  }
  ListOffers:any
  getOffers() {

    return this.offerservice.getOffers().subscribe(
      data => {
        console.log(data);
        this.ListOffers=data;
      },
      error => {

        {

        }
      }
    )
  }
}
