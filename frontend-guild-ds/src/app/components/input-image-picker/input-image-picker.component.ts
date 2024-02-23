import { Component } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';

@Component({
  selector: 'input-image-picker',
  standalone: true,
  imports: [MatCardModule, MatIconModule],
  templateUrl: './input-image-picker.component.html',
  styleUrl: './input-image-picker.component.scss',
})
export class InputImagePickerComponent {
  HandleUpload() {
    console.log('upalod');
  }
}
