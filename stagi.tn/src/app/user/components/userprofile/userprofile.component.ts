import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';
import { ActivatedRoute, ParamMap, Params, Router } from '@angular/router';
import { CVService } from '../cv/cv.service';

@Component({
  selector: 'app-userprofile',
  templateUrl: './userprofile.component.html',
  styleUrls: ['./userprofile.component.css'],
})
export class UserprofileComponent implements OnInit {
  userId: any;
  user?: any;
  form: any;
  myFile: any;
  fileInput: any;
  myCV: any;
  myCVINput: any;
  completeProfile:any
  constructor(
    private cvservice: CVService,
    private userService: UserService,
    router: Router,
    private activatedRoute: ActivatedRoute
  ) {}
completeProfileBtn() {
    this.completeProfile = !this.completeProfile;
  }
  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe({
      next: (p: ParamMap) => {
        this.userId = p.get('id');
        this.userService.getUser(p.get('id')).subscribe(
          (data: any) => {
            this.user = data;
            console.log('USER///', this.user);
            console.log('data///', data);
            this.myCV = data.cv;
            this.myFile = data.image;
            console.log('myCV///', this.myCV, 'Image', this.myFile);
          },
          (err: any) => {
            console.log(err);
          }
        );
      },
    });
  }
  imageChange(element: any) {
    console.log(element);
    this.myFile = element.target.files[0];
    this.fileInput = this.myFile.name;
    console.log(this.myFile);
  }
  // chain 3 observables : ADD_IMG then ADD_CV then ADD_USER.
  cvChange(element: any) {
    console.log(element);
    this.myCV = element.target.files[0];
    this.myCVINput = this.myCV.name;
    console.log(this.myCV);
  }
  onSubmit(form: any) {
    //form.keywords = form.keywords.split(',');

    ///////////////////////
    let image = new FormData();
    image.append('file', this.myFile);
    let cv = new FormData();
    cv.append('file', this.myCV);
    // Save image
    this.cvservice.addCv(image, 'image').subscribe({
      next: (data: any) => {
        console.log('DATA:::', data);
        console.log('FILEINPut//:', this.fileInput);
        // add image url to form to load it in the database
        form.image = data.fileName;
        form.file = data.fileName;

        console.log('FORM:::', form);
        // Save cv
        this.cvservice.addCv(cv, 'usercv').subscribe({
          next: (data: any) => {
            console.log('dataafterIMG:::', data);
            form.cv = data.fileName;
            this.userService.updateUser(form, this.userId).subscribe(
              (data: any) => {
                console.log('SUBMIT DATA///', data);
              },
              (err: any) => {
                console.log(err);
              }
            );
          },
          error: (err: any) => {
            console.log(err);
          },
        });
      },
      error: (err: any) => {
        console.log(err);
      },
      complete: () => {
        console.log(' SAVED');
      },
    }); //

    //this.router.navigateByUrl('/');
  }
  //populateForm(form: any) {}
}
