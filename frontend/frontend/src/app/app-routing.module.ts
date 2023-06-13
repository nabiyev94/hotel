import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { ReviewComponent } from './review/review.component';
import { MostReviewedRoomsComponent } from './most-reviewed-rooms/most-reviewed-rooms.component';
import { BookedRoomsByCustomerComponent } from './booked-rooms-by-customer/booked-rooms-by-customer.component';
import { UserComponent } from './user/user.component';
import { UserNosqlComponent } from './user-nosql/user-nosql.component';
import { MostReviewedRoomsNosqlComponent } from './most-reviewed-rooms-nosql/most-reviewed-rooms-nosql.component';


const routes: Routes = [
  {path:'login', component:LoginComponent},
  {path:'home', component:HomeComponent},
  {path:'review', component:ReviewComponent},
  {path: 'mostReviewedRooms', component:MostReviewedRoomsComponent},
  {path: 'bookedRoomsByCustomer', component:BookedRoomsByCustomerComponent},
  {path: 'user', component:UserComponent},
  {path: 'userNosql', component:UserNosqlComponent },
  {path: 'mostReviewedRoomsNosql', component:MostReviewedRoomsNosqlComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
