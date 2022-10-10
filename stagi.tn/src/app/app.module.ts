import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FooterComponent } from './shared/components/footer/footer.component';
import { HeaderComponent } from './shared/components/header/header.component';
import { HttpClient, HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { SignupComponent } from './user/components/signup/signup.component';
import { FormsModule } from '@angular/forms';
import { CvComponent } from './cv/cv.component';
import { UserprofileComponent } from './userprofile/userprofile.component';



@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    SignupComponent,
    CvComponent,
    UserprofileComponent
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
     
    
    
    
    
  ],
  
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
