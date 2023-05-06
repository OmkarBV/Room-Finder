import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TenantService {
  url: string = 'http://localhost:8080'
  constructor(private http: HttpClient) { }

  tenantLogin(owner: any) {
    return this.http.post(this.url + '/tenantlogin', owner)
  }

  tenantRegister(obj: any) {
    return this.http.post(this.url + '/tenantregister', obj)
  }
  getTenant(username: any) {
    return this.http.get(this.url + '/gettenant/' + username)
  }

}
