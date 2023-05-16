import { Component, OnInit } from '@angular/core';
import { OwnerService } from '../utility/owner.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-owner',
  templateUrl: './owner.component.html',
  styleUrls: ['./owner.component.css']
})
export class OwnerComponent implements OnInit {
  isInserted?: boolean
  // sms?: string
  stleins = {}
  owner = {
    id: 0,
    email: '',
    name: '',
    number: '',
    properties: [{
      id: 0,
      location: '',
      rent: 0.0,
      type: ''
    }]
  }

  username = ''
  constructor(private service: OwnerService, private r: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.getUserName()
    this.getOwner()
  }
  getUserName() {
    this.r.paramMap.subscribe((param) => {
      this.username = param.get('username') as string
    })
  }
  getOwner() {
    this.service.getOwner(this.username).
      subscribe((responce: any) => {
        this.owner = responce
      })
  }

  insertproperty(loc: any, rent: any, type: any) {
    let property = {
      location: loc,
      rent: rent,
      type: type,
      owner: {
        id: this.owner.id
      }
    }
    this.service.insertProperty(property).
      subscribe((responce: any) => {
        this.isInserted = responce

      }, (error) => {
        this.isInserted = false
        console.log(error);

      })
    this.stleins = {
      'display': 'block'
    }
  }


  updateProperty(id: any, location: any, rent: any, type: any) {
    let editprop = {
      id: id
      , location: location,
      rent: rent,
      type: type,
      owner: {
        id: this.owner.id,
      }
    }
    this.service.updateProperty(editprop).subscribe((responce) => {
      if (responce as boolean) {
        alert("Updated SuccessFul")
      //  this.ngOnInit();
      }
    }, (error) => {
      console.log();
    })
  }
  deleteProperty(id: any) {
    this.service.deleteProperty(id).subscribe((response) => {
      if (response as boolean) {
        this.ngOnInit()
        alert('delete Successfuly')
      }
    }, (error) => {
      console.log(error);
      //this.router.navigate(['/error'])
    })
  }
}
