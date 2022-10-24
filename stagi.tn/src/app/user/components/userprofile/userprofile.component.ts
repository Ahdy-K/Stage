import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';
import { ActivatedRoute, ParamMap, Params, Router } from '@angular/router';

@Component({
  selector: 'app-userprofile',
  templateUrl: './userprofile.component.html',
  styleUrls: ['./userprofile.component.css'],
})
export class UserprofileComponent implements OnInit {
  userId: any;
  user: any;
  form: any;

  constructor(
    private userService: UserService,
    router: Router,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe({
      next: (p: ParamMap) => {
        this.userId = p.get('id');
        this.userService.getUser(p.get('id')).subscribe(
          (data: any) => {
            this.user = data;
            console.log('USER///', this.user);
            console.log('data///', data);
          },
          (err: any) => {
            console.log(err);
          }
        );
      },
    });
  }
  onSubmit(valueForm:any) {
    valueForm.keywords = valueForm.keywords.split(',');
    this.userService.updateUser(valueForm, this.userId).subscribe(
      (data: any) => {
        console.log('SUBMIT DATA///', data);
      },
      (err: any) => {
        console.log(err);
      }
    );
    //this.router.navigateByUrl('/');
  }
  //populateForm(form: any) {}
}
