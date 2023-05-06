import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OwnerService } from 'src/app/utility/owner.service';

@Component({
  selector: 'app-ownerregister',
  templateUrl: './ownerregister.component.html',
  styleUrls: ['./ownerregister.component.css']
})
export class OwnerregisterComponent implements OnInit {
  res = {
    success: false,
    message: ''
  }
  sms = ''
  constructor(private service: OwnerService, private router: Router) { }


  ngOnInit(): void {
  }
  onRegister(name: string, email: string, number: string, password: string) {
    let obj = {
      name: name,
      email: email,
      number: number,
      password: password
    }
    this.service.ownerRegister(obj).
      subscribe((responce: any) => {
        this.res = responce
        if (this.res.success === true) {
          this.sms = this.res.message
          this.router.navigate(['/ownerlogin'])
        } else {
          this.sms = this.res.message
        }

      }, (error) => {
        console.log(error)
        this.router.navigate(['/errorpage'])
      }
      )
  }
}
