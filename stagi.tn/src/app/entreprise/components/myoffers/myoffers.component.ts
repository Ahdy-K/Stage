import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig, MatDialogRef } from '@angular/material/dialog';
import { DetailsOfferComponent } from '../details-offer/details-offer.component';
import { MakeofferComponent } from '../makeoffer/makeoffer.component';
import { OfferService } from '../offer.service';

@Component({
  selector: 'app-myoffers',
  templateUrl: './myoffers.component.html',
  styleUrls: ['./myoffers.component.css']
})
export class MyoffersComponent implements OnInit {

  constructor(public dialog: MatDialog, private offerservice: OfferService) { }
  ngOnInit(): void {
    this.getOffers()

  }
  openDialog(enterAnimationDuration: string, exitAnimationDuration: string): void {
    this.dialog.open(MakeofferComponent, { width: "50", height: "50" });


  }
  openUpdateDialog(enterAnimationDuration: string, exitAnimationDuration: string, id: number): void {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.data = { "id": id };
    dialogConfig.width = "50";
    dialogConfig.height = "50";

    this.dialog.open(DetailsOfferComponent, dialogConfig);


  }
  ListOffers: any
  getOffers() {

    return this.offerservice.getOffers().subscribe(
      data => {
        console.log(data);
        this.ListOffers = data;
      },
      error => {

        {

        }
      }
    )
  }
}
