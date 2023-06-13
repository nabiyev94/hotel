import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MostReviewedRoomsNosqlComponent } from './most-reviewed-rooms-nosql.component';

describe('MostReviewedRoomsNosqlComponent', () => {
  let component: MostReviewedRoomsNosqlComponent;
  let fixture: ComponentFixture<MostReviewedRoomsNosqlComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MostReviewedRoomsNosqlComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MostReviewedRoomsNosqlComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
