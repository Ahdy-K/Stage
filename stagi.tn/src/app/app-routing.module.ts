import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SignupComponent } from './user/components/signup/signup.component';
import { SignupComponent as EnSignupComponent } from './entreprise/components/signup/signup.component';
import { IndexComponent } from './home/components/index/index.component';
import { LoginComponent } from './shared/components/login/login.component';
import { ListofferComponent } from './offre/components/listoffer/listoffer.component';
import { DashboardComponent } from './user/components/dashboard/dashboard.component';

import { MyoffersComponent } from './entreprise/components/myoffers/myoffers.component';
import { ListUserComponent } from './user/components/list-user/list-user.component';
import { DetailsOfferComponent } from './entreprise/components/details-offer/details-offer.component';


const routes: Routes = [

  {path: 'us-signup', component: SignupComponent},
  {path: 'en-signup', component: EnSignupComponent},
  {path: 'log-in', component: LoginComponent},
  {path: 'offerlist', component: ListofferComponent},
  {path: 'dashboard', component: DashboardComponent},
  {path: '', component: IndexComponent},
  
  {path: 'myoffers', component: MyoffersComponent},
  {path: 'listUser', component: ListUserComponent},
  {path: 'details', component: DetailsOfferComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
