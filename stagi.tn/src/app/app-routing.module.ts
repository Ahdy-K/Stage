import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SignupComponent } from './user/components/signup/signup.component';
import { SignupComponent as EnSignupComponent } from './entreprise/components/signup/signup.component';
import { IndexComponent } from './home/components/index/index.component';
import { LoginComponent } from './shared/components/login/login.component';
import { ListofferComponent } from './offre/components/listoffer/listoffer.component';
import { DashboardComponent } from './user/components/dashboard/dashboard.component';


const routes: Routes = [

  {path: 'us-signup', component: SignupComponent},
  {path: 'en-signup', component: EnSignupComponent},
  {path: 'log-in', component: LoginComponent},
  {path: 'offerlist', component: ListofferComponent},
  {path: 'dashboard', component: DashboardComponent},
  {path: '', component: IndexComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
