import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatInputModule } from '@angular/material/input';
import { MatCardModule } from '@angular/material/card';
import {
  FormControl,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { InputImagePickerComponent } from '../../input-image-picker/input-image-picker.component';
import { MatButtonModule } from '@angular/material/button';
import { MemberService, Member } from '../../../services/member/member.service';
import { CardComponent } from '../../member/card/card.component';

@Component({
  selector: 'app-admin-member',
  standalone: true,
  imports: [
    CommonModule,
    MatInputModule,
    MatCardModule,
    ReactiveFormsModule,
    InputImagePickerComponent,
    MatButtonModule,
    CardComponent,
  ],
  providers: [MemberService],
  templateUrl: './admin-member.component.html',
  styleUrl: './admin-member.component.scss',
})
export class AdminMemberComponent {
  memberForm!: FormGroup;
  imagePath: string = '';
  members!: Member[];

  constructor(private memberService: MemberService) {
    this.memberForm = new FormGroup({
      name: new FormControl('', [Validators.required]),
      description: new FormControl('', [Validators.required]),
    });
    this.updateMembers();
  }

  submit() {
    if (this.memberForm.valid && this.imagePath) {
      const { name, description } = this.memberForm.value;
      const member = new Member(name, description, this.imagePath);
      this.memberService.newMember(member).subscribe({
        next: () => {
          this.updateMembers();
        },
      });
    }
  }

  updateMembers() {
    this.memberService.listMembers().subscribe({
      next: (members) => {
        this.members = members;
      },
    });
  }

  uploadImagePath(path: string) {
    this.imagePath = path;
  }
}
