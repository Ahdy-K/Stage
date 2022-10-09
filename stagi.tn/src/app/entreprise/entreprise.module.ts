import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SignupComponent } from './components/signup/signup.component';

import { FormsModule } from '@angular/forms';
import { NgxMatSelectSearchModule } from 'ngx-mat-select-search';





@NgModule({
  declarations: [
    SignupComponent,
  ],
  imports: [
    CommonModule,
    FormsModule,
    NgxMatSelectSearchModule,
   
    

  ]
})
export class EntrepriseModule { }
