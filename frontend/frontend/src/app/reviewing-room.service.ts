import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ReviewingRoomService {

  constructor(private http:HttpClient) { }

  API = 'http://localhost:8080';

  
  public reviewRoomNow(reviewingRoomData:any){

    return this.http.put(this.API + '/reviewRoom', reviewingRoomData);
  }

  public reviewRoomNowMongo(reviewingRoomData:any){

    return this.http.put(this.API + '/addReview', reviewingRoomData);
  }


  public getMostReviewRooms(age : any){
    return this.http.get(this.API + '/most/' + age);
  }

  public getMostReviewRoomsMongo(age : any){
    return this.http.get(this.API + '/mostReviews/' + age);
  }

  public fillDataBase(){
    return this.http.get(this.API + '/fillTesting');
  }

  public deleteDataBase(){
    return this.http.get(this.API + '/deleteDataBase');
  }

  public getBookedRoomsByCustomer(customerID : any){
    return this.http.get(this.API + '/findby/' + customerID);
  }

  public getBookedRoomsMongoByCustomer(customerID : any){
    return this.http.get(this.API + '/findRooms/' + customerID);
  }

  public getAllUsers(){
    return this.http.get(this.API + '/getListOfCustomers');
  }


  public deleteMongoDb(){
    return this.http.delete(this.API + '/deleteMongoDb');
  }

  public migrateDataB(){
    return this.http.get(this.API + '/migrateData');
  }








}
