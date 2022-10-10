import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-list-user',
  templateUrl: './list-user.component.html',
  styleUrls: ['./list-user.component.css']
})
export class ListUserComponent implements OnInit {
  ListUser: any;

  constructor(private userservice: UserService) { }

  ngOnInit(): void {
    this.getAll()
  }

  getAll(): void {
    this.userservice.allUsers().subscribe(
      data => {
        console.log(data)
        this.ListUser = data;
        console.log(this.ListUser)
      },
      error => {

      }
    );
  }
}
