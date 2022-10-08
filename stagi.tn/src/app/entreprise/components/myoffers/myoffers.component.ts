import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { MakeofferComponent } from '../makeoffer/makeoffer.component';

@Component({
  selector: 'app-myoffers',
  templateUrl: './myoffers.component.html',
  styleUrls: ['./myoffers.component.css']
})
export class MyoffersComponent implements OnInit {

  constructor(public dialog: MatDialog) { }
  ngOnInit(): void {

  }
  openDialog(enterAnimationDuration: string, exitAnimationDuration: string): void {
    this.dialog.open(MakeofferComponent, { width: "50" ,height:"50"});


  }
}
