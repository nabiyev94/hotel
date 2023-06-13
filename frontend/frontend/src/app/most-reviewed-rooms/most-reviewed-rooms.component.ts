import { Component } from '@angular/core';
import { MostReviewedRooms } from '../mostRoomReviewed';
import { ReviewingRoomService } from '../reviewing-room.service';
import { NgForm } from '@angular/forms';


@Component({
  selector: 'app-most-reviewed-rooms',
  templateUrl: './most-reviewed-rooms.component.html',
  styleUrls: ['./most-reviewed-rooms.component.css']
})
export class MostReviewedRoomsComponent {
  

  mostReviewedRooms : any;
  constructor(private reviewingRoomService : ReviewingRoomService){}

  /*
  ngOnInit(){
    let resp = this.reviewingRoomService.getMostReviewRooms();
    resp.subscribe((data) => this.mostReviewedRooms=data);
  }*/

  getMostRooms(mostReviewedRoomsr : NgForm){
    let resp = this.reviewingRoomService.getMostReviewRooms(mostReviewedRoomsr.value.age);
    resp.subscribe((data) => this.mostReviewedRooms=data);

  }






}

