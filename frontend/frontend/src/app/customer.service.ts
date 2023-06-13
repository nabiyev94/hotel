import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  API = 'http://localhost:9191';

  constructor(private http : HttpClient) { }



  public getListOfBookedRooms(customerID:any){

    return this.http.get(this.API + "/findby" + customerID)

  }


}
