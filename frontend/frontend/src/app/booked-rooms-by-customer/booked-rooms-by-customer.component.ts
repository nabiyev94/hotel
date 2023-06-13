import { Component } from '@angular/core';
import { ReviewingRoomService } from '../reviewing-room.service';

@Component({
  selector: 'app-booked-rooms-by-customer',
  templateUrl: './booked-rooms-by-customer.component.html',
  styleUrls: ['./booked-rooms-by-customer.component.css']
})
export class BookedRoomsByCustomerComponent {

  bookedRoomsByCustomer : any

  constructor(private reviewingRoomService : ReviewingRoomService){

  }

  
  ngOnInit(user : any){
    let resp = this.reviewingRoomService.getBookedRoomsByCustomer(user.customerID);
    resp.subscribe((data) => this.bookedRoomsByCustomer=data);
  }

}
