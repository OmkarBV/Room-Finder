import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OwnerService } from 'src/app/utility/owner.service';

@Component({
  selector: 'app-ownerlogin',
  templateUrl: './ownerlogin.component.html',
  styleUrls: ['./ownerlogin.component.css']
})
export class OwnerloginComponent implements OnInit {
  res = {
    success: false,
    message: ''
  }
  sms = ''

  constructor(private service: OwnerService, private router: Router) { }

  ngOnInit(): void {
  }
  onLogin(user?: string, pass?: string) {
    let owner = {
      email: user,
      password: pass
    }
    this.service.ownerLogin(owner).
      subscribe((responce: any) => {
        this.res = responce
        if (this.res.success === true) {
          this.router.navigate(['/home', owner.email, true])
        } else {
          this.sms = this.res.message
        }
      }, (error) => console.log(error)
      )

  }
}
