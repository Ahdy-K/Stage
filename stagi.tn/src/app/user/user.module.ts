import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SignupComponent } from './components/signup/signup.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { ListofferComponent } from '../offre/components/listoffer/listoffer.component';
import { ListUserComponent } from './components/list-user/list-user.component';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';





@NgModule({
  declarations: [
    DashboardComponent,
    ListUserComponent

  ],
  imports: [
    CommonModule,
    FormsModule
  
  ]




})
export class UserModule { }
