import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserNosqlComponent } from './user-nosql.component';

describe('UserNosqlComponent', () => {
  let component: UserNosqlComponent;
  let fixture: ComponentFixture<UserNosqlComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserNosqlComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserNosqlComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
