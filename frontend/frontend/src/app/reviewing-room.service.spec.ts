import { TestBed } from '@angular/core/testing';

import { ReviewingRoomService } from './reviewing-room.service';

describe('ReviewingRoomService', () => {
  let service: ReviewingRoomService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ReviewingRoomService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
