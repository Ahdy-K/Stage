import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  Account: any;
  User: any;

  constructor() { }

  ngOnInit(): void {
    
    this.Accountchange()
    console.log(this.Account)
    this.User = window.localStorage.getItem('USER')
    
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

}
