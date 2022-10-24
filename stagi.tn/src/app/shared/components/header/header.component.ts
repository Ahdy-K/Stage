import { Component, OnInit } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { UserService } from 'src/app/user/services/user.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  Account: any;
  User: any;
  CurrentUser: any
  ImageUrl: any;
  Imagename:any;

  constructor(private userservice: UserService,public sanitizer: DomSanitizer) { }

  ngOnInit(): void {

    this.Accountchange()
    console.log(this.Account)
    this.User = window.localStorage.getItem('USER')
    this.getUser();

  }
  logout() {
    window.localStorage.clear()
    window.location.reload();

  }
  Accountchange() {
    console.log(window.localStorage.getItem('ACCOUNT'))
    if (window.localStorage.getItem('ACCOUNT') == "Student") {
      this.Account = "STUDENT"
    }
    if (window.localStorage.getItem('ACCOUNT') == "Entreprise") {
      this.Account = "ENTREPRISE"
    }

    if (window.localStorage.getItem('ACCOUNT') == null) {
      this.Account = "VISITOR"
    }
  }
  getUser() {
    this.userservice.getUserByEmail(this.User).subscribe({
      next: (data) => {
        this.CurrentUser = data;
        console.log(data)
        this.ImageUrl = this.CurrentUser.image;
        this.Imagename=this.ImageUrl.split('\\');
      
        this.ImageUrl="assets\\img\\pdp\\"+this.Imagename[12];

        console.log(this.ImageUrl)
      },
      error: (err) => {
        console.log(err)
      }
    })
  }

}
