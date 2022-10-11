import { HttpEventType, HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { CVService } from './cv.service';

@Component({
  selector: 'app-cv',
  templateUrl: './cv.component.html',
  styleUrls: ['./cv.component.css'],
})
export class CvComponent implements OnInit {
  constructor(private cvservice: CVService) {}
  ngOnInit(): void {
    
  }

  /*addcv(cv: any): void {
    let formData = new FormData();
    formData.append('file', cv.file);
    if (formData) {
      this.cvservice.addCv(formData).subscribe(
        (datacv:any) => {
          console.log('dataCV:::', datacv);
        },
        (err:any) => {
          console.log(err);
        }
      );
    }
  }*/

  // selectedFiles?: FileList;
  // currentFile?: File;
  // progress = 0;
  // message = '';
  // fileInfos?: Observable<any>;
  // constructor(private uploadService: UploadFileService) {}
  // ngOnInit(): void {
  //   this.fileInfos = this.uploadService.getFiles();
  // }
  // selectFile(event:any) {
  //   this.selectedFiles = event.target.files;
  // }

  // upload() {
  //   this.progress = 0;
  //   this.currentFile = this.selectedFiles.item(0);
  //   this.uploadService.upload(this.currentFile).subscribe(
  //     (event) => {
  //       if (event.type === HttpEventType.UploadProgress) {
  //         this.progress = Math.round((100 * event.loaded) / event.total);
  //       } else if (event instanceof HttpResponse) {
  //         this.message = event.body.message;
  //         this.fileInfos = this.uploadService.getFiles();
  //       }
  //     },
  //     (err:any) => {
  //       this.progress = 0;
  //       this.message = 'Could not upload the file!';
  //       this.currentFile = undefined;
  //     }
  //   );

  //   this.selectedFiles = undefined;
  // }
}
