import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  
  constructor(private userService:UserService) { }

  ngOnInit(): void {
  }

  addUser(form:any):void
  {
   this.userService.addUser(form).subscribe(
    data =>{console.log(form);
    },
    error => {
      console.log(error)
    }
   )


  }

}
