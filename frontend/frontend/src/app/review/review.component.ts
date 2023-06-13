import { Component } from '@angular/core';
import { CustomerService } from '../customer.service';
import { ReviewingRoomService } from '../reviewing-room.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.css']
})
export class ReviewComponent {

  
  constructor(private reviewRoomService:ReviewingRoomService){}

  reviewRoom(reviewRoomForm:NgForm){
    this.reviewRoomService.reviewRoomNow(reviewRoomForm.value).subscribe (
      (resp) => {
        console.log(resp)
        reviewRoomForm.reset();
      },
      (err) => {
        console.log(err)
      }
    );
    

  }


  
  bookedRoomsByCustomer(user : any){
    this.reviewRoomService.getBookedRoomsByCustomer(user.customerID).subscribe (
      (resp) => {
        console.log(resp)
      },
      (err) => {
        console.log(err)
      }
    );

  }

}
