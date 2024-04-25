import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CategoryDasboardComponent } from './category-dasboard.component';

describe('CategoryDasboardComponent', () => {
  let component: CategoryDasboardComponent;
  let fixture: ComponentFixture<CategoryDasboardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CategoryDasboardComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CategoryDasboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
