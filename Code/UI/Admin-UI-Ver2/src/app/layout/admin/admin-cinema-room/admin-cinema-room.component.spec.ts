import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminCinemaRoomComponent } from './admin-cinema-room.component';

describe('AdminCinemaRoomComponent', () => {
  let component: AdminCinemaRoomComponent;
  let fixture: ComponentFixture<AdminCinemaRoomComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AdminCinemaRoomComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AdminCinemaRoomComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
