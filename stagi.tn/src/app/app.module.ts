import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FooterComponent } from './shared/components/footer/footer.component';
import { HeaderComponent } from './shared/components/header/header.component';
import {
  HttpClient,
  HttpClientModule,
  HTTP_INTERCEPTORS,
} from '@angular/common/http';
import { SignupComponent } from './user/components/signup/signup.component';
import { FormsModule } from '@angular/forms';
import { CvComponent } from './user/components/cv/cv.component';
//import { UserprofileComponent } from './user/userprofile/userprofile.component';

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
import { DashboardComponent } from './user/components/dashboard/dashboard.component';
import { RequestsComponent } from './entreprise/components/requests/requests.component';

import { UserprofileComponent } from './user/components/userprofile/userprofile.component';
import { NgxExtendedPdfViewerModule } from 'ngx-extended-pdf-viewer';

import { ResumeComponent } from './resume/resume.component';


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
    DetailsOfferComponent,
    ListEntreprisesComponent,
    DetailsOfferComponent,
    DetailsComponent,
    DashboardComponent,
    CvComponent,
    UserprofileComponent,
    ListofferComponent,
    RequestsComponent,



    CvComponent,
    UserprofileComponent,
    ResumeComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgxMatSelectSearchModule,
    BrowserAnimationsModule,
    MatDialogModule,
    NgxExtendedPdfViewerModule,
    




  ],

  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true,
    },
   
  ],
  bootstrap: [AppComponent],
})
export class AppModule { }
