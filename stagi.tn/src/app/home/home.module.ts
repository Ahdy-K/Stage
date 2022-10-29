import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { IndexComponent } from './components/index/index.component';
import { ListofferComponent } from '../offre/components/listoffer/listoffer.component';



@NgModule({
  declarations: [
    IndexComponent,
    ListofferComponent



  ],
  imports: [
    CommonModule,
    ListofferComponent



  ]
})
export class HomeModule { }
