import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})

export class SignupComponent implements OnInit {
  userexist:boolean=false;
  
  
  constructor(private userService:UserService) { }

  ngOnInit(): void {
  }

  addUser(form:any):void
  {
   this.userService.addUser(form).subscribe(
    data =>{console.log(form);
    },
    error => {
      if(error.error=="User Exist In DB ")
    {
      this.userexist=true;
    }
    }
   )


  }

}
