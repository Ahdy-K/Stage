import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SignupComponent } from './user/components/signup/signup.component';
import { SignupComponent as EnSignupComponent } from './entreprise/components/signup/signup.component';
import { IndexComponent } from './home/components/index/index.component';
import { LoginComponent } from './shared/components/login/login.component';
import { MyoffersComponent } from './entreprise/components/myoffers/myoffers.component';


const routes: Routes = [

  {path: 'us-signup', component: SignupComponent},
  {path: 'en-signup', component: EnSignupComponent},
  {path: 'log-in', component: LoginComponent},
  {path: '', component: IndexComponent},
  {path: 'myoffers', component: MyoffersComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
