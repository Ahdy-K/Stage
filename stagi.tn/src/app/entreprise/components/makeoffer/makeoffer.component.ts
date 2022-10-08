import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-makeoffer',
  templateUrl: './makeoffer.component.html',
  styleUrls: ['./makeoffer.component.css']
})
export class MakeofferComponent implements OnInit {
  ListTechnologies=["Spring Boot","Angular","Django","Python","Java","Spring",".Net","C","c#","C++","Machine Learning", "Hibernate","ORM","MySQL","PostgreSql"]

  constructor() { }

  ngOnInit(): void {
  }
  items = [
    {id: 1, name: 'Python'},
    {id: 2, name: 'Node Js'},
    {id: 3, name: 'Java'},
    {id: 4, name: 'PHP', disabled: true},
    {id: 5, name: 'Django'},
    {id: 6, name: 'Angular'},
    {id: 7, name: 'Vue'},
    {id: 8, name: 'ReactJs'},
  ];
  selected = [
    {id: 2, name: 'Node Js'},
    {id: 8, name: 'ReactJs'}
  ];
 
}
