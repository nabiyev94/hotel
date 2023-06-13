import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';
import { LoginComponent } from './login/login.component';
import { FormsModule } from '@angular/forms';
import { ReviewComponent } from './review/review.component';
import {HttpClientModule} from '@angular/common/http';
import { MostReviewedRoomsComponent } from './most-reviewed-rooms/most-reviewed-rooms.component';
import { BookedRoomsByCustomerComponent } from './booked-rooms-by-customer/booked-rooms-by-customer.component';
import { UserComponent } from './user/user.component';
import { UserNosqlComponent } from './user-nosql/user-nosql.component';
import { MostReviewedRoomsNosqlComponent } from './most-reviewed-rooms-nosql/most-reviewed-rooms-nosql.component';



@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    LoginComponent,
    ReviewComponent,
    ReviewComponent,
    MostReviewedRoomsComponent,
    BookedRoomsByCustomerComponent,
    UserComponent,
    UserNosqlComponent,
    MostReviewedRoomsNosqlComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
