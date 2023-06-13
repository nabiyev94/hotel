import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ReviewingRoomService } from '../reviewing-room.service';

@Component({
  selector: 'app-user-nosql',
  templateUrl: './user-nosql.component.html',
  styleUrls: ['./user-nosql.component.css']
})
export class UserNosqlComponent {
  user : any;
  bookedRoomsByCustomer : any;
  constructor(private reviewingRoomService : ReviewingRoomService){}


  getBookedRooms(user : NgForm){
    let resp = this.reviewingRoomService.getBookedRoomsMongoByCustomer(user.value.customerId);
    resp.subscribe((data) => this.user=data);

  }

  reviewRoom(reviewRoomForm:NgForm){
    this.reviewingRoomService.reviewRoomNowMongo(reviewRoomForm.value).subscribe (
      (resp) => {
        console.log(resp)
        reviewRoomForm.reset();
      },
      (err) => {
        console.log(err)
      }
    );
    

  }



}
