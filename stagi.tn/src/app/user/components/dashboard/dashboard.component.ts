import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css'],
})
export class DashboardComponent implements OnInit {
  userId: any;
  user: any;

  constructor(
    private userService: UserService,
    private router: Router,
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

    //this.router.navigateByUrl('/');
  }
  backToHome(): void {
    this.router.navigateByUrl('/');
  }
}
