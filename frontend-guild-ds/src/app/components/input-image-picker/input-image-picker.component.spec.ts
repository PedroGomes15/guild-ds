import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InputImagePickerComponent } from './input-image-picker.component';

describe('InputImagePickerComponent', () => {
  let component: InputImagePickerComponent;
  let fixture: ComponentFixture<InputImagePickerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [InputImagePickerComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(InputImagePickerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
