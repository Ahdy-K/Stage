import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { LoginComponent } from './components/login/login.component';




@NgModule({
  declarations: [
    
  
    HeaderComponent,
            FooterComponent,
            LoginComponent
  ],
  imports: [
    CommonModule
  ]
  
})
export class SharedModule { }
