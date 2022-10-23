import { Component, OnInit } from '@angular/core';
import { CVService } from 'src/app/cv/cv.service';
import { UserService } from '../../services/user.service';
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css'],
})
export class SignupComponent implements OnInit {
  userexist: boolean = false;
  myFile: any;
  fileInput: any;

  constructor(private userService: UserService, private cvservice: CVService) {}

  ngOnInit(): void {}
  //
  imageChange(element: any) {
    console.log(element);
    this.myFile = element.target.files[0];
    this.fileInput = this.myFile.name;
    console.log(this.myFile);
  }
  // chain 3 observables : ADD_IMG then ADD_CV then ADD_USER.
  cvChange(element: any) {
    console.log(element);
    this.myFile = element.target.files[0];
    this.fileInput = this.myFile.name;
    console.log(this.myFile);
  }
  //

  //

  addUser(form: any): void {
    let image = new FormData();
    image.append('file', this.myFile);

    // Save image
    this.cvservice.addCv(image, 'image').subscribe({
      next: (data: any) => {
        console.log('DATA:::', data);
        console.log('FILEINPut//:', this.fileInput);
        // add image url to form to load it in the database
        form.image = data.fileName;
        form.file = data.fileName;
        this.userService.addUser(form).subscribe(
          (data) => {
            console.log(form);
          },
          (error) => {
            if (error.error == 'User Exist In DB ') {
              this.userexist = true;
            }
          }
        );
      },
      error: (err: any) => {
        console.log(err);
      },
    }); //
  }
}

// addUser(form: any): void {
//   let image = new FormData();
//   image.append('file', this.myFile);
//   form.image = image;

//   this.userService.addUser(form).subscribe(
//     (data) => {
//       console.log(form);
//     },
//     (error) => {
//       if (error.error == 'User Exist In DB ') {
//         this.userexist = true;
//       }
//     }
//   );
// }
