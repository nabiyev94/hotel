import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ReviewingRoomService } from '../reviewing-room.service';

@Component({
  selector: 'app-most-reviewed-rooms-nosql',
  templateUrl: './most-reviewed-rooms-nosql.component.html',
  styleUrls: ['./most-reviewed-rooms-nosql.component.css']
})
export class MostReviewedRoomsNosqlComponent {

  mostReviewedRooms : any;
  constructor(private reviewingRoomService : ReviewingRoomService){}

  getMostRooms(mostReviewedRoomsr : NgForm){
    let resp = this.reviewingRoomService.getMostReviewRoomsMongo(mostReviewedRoomsr.value.age);
    resp.subscribe((data) => this.mostReviewedRooms=data);

  }

}
