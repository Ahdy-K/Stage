import { Component, OnInit } from '@angular/core';
import { UserService } from '../user/services/user.service';

@Component({
  selector: 'app-resume',
  templateUrl: './resume.component.html',
  styleUrls: ['./resume.component.css']
})
export class ResumeComponent implements OnInit {
  resume:any;

  constructor(private userservice: UserService) { }

  ngOnInit(): void {

    this.getdetailsResume('English_cv.pdf')
  }


  getdetailsResume(path: string) {
    console.log("heeeeeey")
    return this.userservice.getDetailresume(path).subscribe({
      next: (data) => { console.log("heey")
      console.log(data)
      this.resume=JSON.parse(data)}
      ,
      error: (err) => console.log(err)
    })
  }

}
