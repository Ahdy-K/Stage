import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SignupComponent } from './components/signup/signup.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { ListofferComponent } from '../offre/components/listoffer/listoffer.component';





@NgModule({
  declarations: [

    SignupComponent,
    DashboardComponent

  ],
  imports: [
    CommonModule,
    
   
})
export class UserModule { }
