import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BookedRoomsByCustomerComponent } from './booked-rooms-by-customer.component';

describe('BookedRoomsByCustomerComponent', () => {
  let component: BookedRoomsByCustomerComponent;
  let fixture: ComponentFixture<BookedRoomsByCustomerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BookedRoomsByCustomerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BookedRoomsByCustomerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
