import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MostReviewedRoomsComponent } from './most-reviewed-rooms.component';

describe('MostReviewedRoomsComponent', () => {
  let component: MostReviewedRoomsComponent;
  let fixture: ComponentFixture<MostReviewedRoomsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MostReviewedRoomsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MostReviewedRoomsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
