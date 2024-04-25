import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CityDeleteCofimationComponent } from './city-delete-cofimation.component';

describe('CityDeleteCofimationComponent', () => {
  let component: CityDeleteCofimationComponent;
  let fixture: ComponentFixture<CityDeleteCofimationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CityDeleteCofimationComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CityDeleteCofimationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
