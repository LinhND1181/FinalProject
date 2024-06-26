import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminCinemaComponent } from './admin-cinema.component';

describe('AdminCinemaComponent', () => {
  let component: AdminCinemaComponent;
  let fixture: ComponentFixture<AdminCinemaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AdminCinemaComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AdminCinemaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
