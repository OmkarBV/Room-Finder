import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class OwnerService {

  url: string = 'http://localhost:8080'
  constructor(private http: HttpClient) { }

  ownerLogin(owner: any) {
    return this.http.post(this.url + '/ownerlogin', owner)
  }

  ownerRegister(obj: any) {
    return this.http.post(this.url + '/ownerregister', obj)
  }
  getOwner(username: any) {
    return this.http.get(this.url + '/getowner/' + username)
  }
 
}
