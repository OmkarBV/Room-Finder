import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TenantService } from 'src/app/utility/tenant.service';

@Component({
  selector: 'app-tenantregister',
  templateUrl: './tenantregister.component.html',
  styleUrls: ['./tenantregister.component.css']
})
export class TenantregisterComponent implements OnInit {
  res = {
    success: false,
    message: ''
  }
  sms = ''
  constructor(private service: TenantService, private router: Router) { }

  onRegister(name: string, email: string, number: string, password: string) {
    let obj = {
      name: name,
      email: email,
      number: number,
      password: password
    }
    this.service.tenantRegister(obj).
      subscribe((responce: any) => {
        this.res = responce
        if (this.res.success === true) {
          this.sms = this.res.message
          this.router.navigate(['/tenantlogin'])
        } else {
          this.sms = this.res.message
        }

      }, (error) => {
        console.log(error)
        this.router.navigate(['/errorpage'])
      }
      )
  }
  ngOnInit(): void {
  }

}
