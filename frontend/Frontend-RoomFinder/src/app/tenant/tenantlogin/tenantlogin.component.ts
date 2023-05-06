import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TenantService } from 'src/app/utility/tenant.service';

@Component({
  selector: 'app-tenantlogin',
  templateUrl: './tenantlogin.component.html',
  styleUrls: ['./tenantlogin.component.css']
})
export class TenantloginComponent implements OnInit {
  res = {
    success: false,
    message: ''
  }
  sms = ''
  constructor(private service: TenantService, private router: Router, private prouter: ActivatedRoute) { }


  ngOnInit(): void {
  }
  onLogin(user?: string, pass?: string) {
    let owner = {
      email: user,
      password: pass
    }
    this.service.tenantLogin(owner).
      subscribe((responce: any) => {
        this.res = responce
        if (this.res.success === true) {
          this.router.navigate(['/home', owner.email, false])
        } else {
          this.sms = this.res.message
        }
      }, (error) => {
        console.log(error)
        this.router.navigate(['/errorpage'])
      })
  }
}
