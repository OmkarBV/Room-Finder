import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HomeService {
  url: string = 'http://localhost:8080'
  constructor(private http: HttpClient) { }

  getAllProperty() {
    return this.http.get(this.url + '/getallproperty')
  }
  seachByLocation(loc: any) {
    return this.http.get(this.url + '/seachbylocation/' + loc)
  }
  searchByRent(rent: any) {
    return this.http.get(`${this.url}/searchbyrent/${rent}`)
  }
  seachByType(type: any) {
    return this.http.get(this.url + '/seachbytype/' + type)
  }
  sortByRentLowToHigh() {
    return this.http.get(this.url + '/sortbyrentlowtohigh')
  }
  sortByRentHighToLow() {
    return this.http.get(this.url + '/sortbyrenthightolow')
  }
}
