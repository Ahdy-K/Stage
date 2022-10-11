import { Component, OnInit } from '@angular/core';
import { UserService } from '../user/services/user.service';
import { ActivatedRoute, ParamMap, Params, Router } from '@angular/router';

@Component({
  selector: 'app-userprofile',
  templateUrl: './userprofile.component.html',
  styleUrls: ['./userprofile.component.css'],
})
export class UserprofileComponent implements OnInit {
  userId: any;
  user: any;
  constructor(
    private userService: UserService,
    router: Router,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe({
      next: (p: ParamMap) => {
        this.userId = p.get('id');
        this.user = this.userService.getUser(p.get('id'));
        console.log(this.user);
      },
    });
  }
  onSubmit(valueForm:any) {
    valueForm.keywords = valueForm.keywords.split(',');
    this.userService.updateUser(valueForm, this.userId).subscribe(
      (data) => {
        console.log(data);
      },
      (err) => {
        console.log(err);
      }
    );
    //this.router.navigateByUrl('/');
  }
}
