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

import { ListofferComponent } from './offre/components/listoffer/listoffer.component';

import { LoginComponent } from './shared/components/login/login.component';
import { MyoffersComponent } from './entreprise/components/myoffers/myoffers.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatDialogModule } from '@angular/material/dialog';
import { MakeofferComponent } from './entreprise/components/makeoffer/makeoffer.component';
import { NgxMatSelectSearchModule } from 'ngx-mat-select-search';
import { AuthInterceptor } from './auth.intercepter';
import { ListUserComponent } from './user/components/list-user/list-user.component';
import { DetailsOfferComponent } from './entreprise/components/details-offer/details-offer.component';
import { ListEntreprisesComponent } from './entreprise/components/list-entreprises/list-entreprises.component';
import { DetailsComponent } from './offre/components/details/details.component';



@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    SignupComponent,

    LoginComponent,
    MyoffersComponent,
    MakeofferComponent,
    ListUserComponent,
    ListofferComponent,
    DetailsOfferComponent,
    ListEntreprisesComponent,
    DetailsOfferComponent,
    DetailsComponent
    
    

    CvComponent,
    UserprofileComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    
    
     

    NgxMatSelectSearchModule,

    
   
    BrowserAnimationsModule,MatDialogModule



  ],

  providers: [
   {
    provide:HTTP_INTERCEPTORS,
    useClass:AuthInterceptor,
    multi:true
   }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
