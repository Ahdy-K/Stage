import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SignupComponent } from './components/signup/signup.component';
import { MyoffersComponent } from './components/myoffers/myoffers.component';
import { MakeofferComponent } from './components/makeoffer/makeoffer.component';




@NgModule({
  declarations: [
    SignupComponent,
    MakeofferComponent
  ],
  imports: [
    CommonModule,

  ]
})
export class EntrepriseModule { }
