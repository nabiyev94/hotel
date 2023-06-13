import { Component } from '@angular/core';
import { ReviewingRoomService } from '../reviewing-room.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  constructor(private reviewRoomService:ReviewingRoomService){}


  fillNowDataBase(){

    this.reviewRoomService.fillDataBase().subscribe (
      (resp) => {
        console.log(resp)
      },
      (err) => {
        console.log(err)
      }
    );

  }

  deleteNowDataBase(){
    this.reviewRoomService.deleteDataBase().subscribe (
      (resp) => {
        console.log(resp)
      },
      (err) => {
        console.log(err)
      }
    );

  }


  deleteMongoDbCollections(){
    this.reviewRoomService.deleteMongoDb().subscribe (
      (resp) => {
        console.log(resp)
      },
      (err) => {
        console.log(err)
      }
    );

  }

  migrateMongo(){
    this.reviewRoomService.migrateDataB().subscribe (
      (resp) => {
        console.log(resp)
      },
      (err) => {
        console.log(err)
      }
    );

  }
  

}
