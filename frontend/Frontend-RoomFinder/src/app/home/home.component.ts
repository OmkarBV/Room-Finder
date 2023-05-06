import { Component, OnInit } from '@angular/core';
import { HomeService } from '../utility/home.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  isowner?: string
  username?: string
  owner = {
    name: '',
    email: '',
    number: '',
  };

  property = [{
    location: '',
    rent: 0.0,
    type: '',
    owner: this.owner
  }];

  constructor(private service: HomeService, private router: Router, private arouter: ActivatedRoute) { }

  ngOnInit(): void {
    this.getAllProperty()
    this.getUserName()
  }
  getUserName() {
    this.arouter.paramMap.
      subscribe((param) => {
        this.username = param.get('username') as string
        this.isowner = param.get('isowner') as string
      })
  }

  getAllProperty() {
    this.service.getAllProperty().
      subscribe((responce: any) => {
        this.property = responce
      }, (error) => {
        console.log(error)
        this.router.navigate(['/errorpage'])
      })
  }

  seachByLocation(loc: any) {
    this.service.seachByLocation(loc).
      subscribe((responce: any) => {
        this.property = responce
      }, (error) => {
        console.log(error)
        this.router.navigate(['/errorpage'])
      }
      )
  }
  searchByRent(rent: any) {
    this.service.searchByRent(rent).
      subscribe((responce: any) => {
        this.property = responce
      }, (error) => {
        console.log(error)
        this.router.navigate(['/errorpage'])
      }
      )
  }
  seachByType(type: any) {
    this.service.seachByType(type.target.value).
      subscribe((responce: any) => {
        this.property = responce
      }, (error) => {
        console.log(error)
        this.router.navigate(['/errorpage'])
      })
  }

  sortByRent(sort: any) {
    if (sort.target.value === 'lh') {
      this.service.sortByRentLowToHigh().
        subscribe((responce: any) => {
          this.property = responce
        }, (error) => {
          console.log(error)
          this.router.navigate(['/errorpage'])
        })
    } else {
      this.service.sortByRentHighToLow().
        subscribe((responce: any) => {
          this.property = responce
        }, (error) => {
          console.log(error)
          this.router.navigate(['/errorpage'])
        })
    }
  }
}
