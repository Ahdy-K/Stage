import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ListofferComponent } from './components/listoffer/listoffer.component';



@NgModule({
  declarations: [
    ListofferComponent
  ],
  imports: [
    CommonModule
  ],
  exports :[

    ListofferComponent

  ],
 
})
export class OffreModule { }
