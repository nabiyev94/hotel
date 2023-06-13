import { Component } from '@angular/core';
import { ReviewingRoomService } from '../reviewing-room.service';
import { BookedRoomsByCustomerComponent } from '../booked-rooms-by-customer/booked-rooms-by-customer.component';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent {

  user : any;
  bookedRoomsByCustomer : any;
  constructor(private reviewingRoomService : ReviewingRoomService){}

  /*
  ngOnInit(){
    let resp = this.reviewingRoomService.getAllUsers();
    resp.subscribe((data) => this.user=data);
    
  }*/
  

  getBookedRooms(user : NgForm){
    let resp = this.reviewingRoomService.getBookedRoomsByCustomer(user.value.customerId);
    resp.subscribe((data) => this.user=data);

  }

  reviewRoom(reviewRoomForm:NgForm){
    this.reviewingRoomService.reviewRoomNow(reviewRoomForm.value).subscribe (
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
