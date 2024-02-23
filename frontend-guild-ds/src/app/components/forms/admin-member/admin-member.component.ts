import { Component } from '@angular/core';
import { MatInputModule } from '@angular/material/input';
import { MatCardModule } from '@angular/material/card';
import {
  FormControl,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { InputImagePickerComponent } from '../../input-image-picker/input-image-picker.component';

@Component({
  selector: 'app-admin-member',
  standalone: true,
  imports: [
    MatInputModule,
    MatCardModule,
    ReactiveFormsModule,
    InputImagePickerComponent,
  ],
  templateUrl: './admin-member.component.html',
  styleUrl: './admin-member.component.scss',
})
export class AdminMemberComponent {
  memberForm!: FormGroup;

  constructor() {
    this.memberForm = new FormGroup({
      name: new FormControl('', [Validators.required]),
      description: new FormControl('', [Validators.required]),
    });
  }
}
