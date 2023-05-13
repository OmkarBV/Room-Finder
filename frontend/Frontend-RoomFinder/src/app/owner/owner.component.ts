import { Component, OnInit } from '@angular/core';
import { OwnerService } from '../utility/owner.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-owner',
  templateUrl: './owner.component.html',
  styleUrls: ['./owner.component.css']
})
export class OwnerComponent implements OnInit {

  owner = {
    email: '',
    name: '',
    number: '',
    properties: [{
      location: '',
      rent: 0.0,
      type: ''
    }]
  }

  username = ''
  constructor(private service: OwnerService, private router: ActivatedRoute) { }

  ngOnInit(): void {
    this.getUserName()
    this.getOwner()
  }
  getUserName() {
    this.router.paramMap.subscribe((param) => {
      this.username = param.get('username') as string
    })
  }
  getOwner() {
    this.service.getOwner(this.username).
      subscribe((responce: any) => {
        this.owner = responce
      })
  }
}