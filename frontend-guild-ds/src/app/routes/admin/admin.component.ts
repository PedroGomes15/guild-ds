import { Component } from '@angular/core';
import { AdminMemberComponent } from '../../components/forms/admin-member/admin-member.component';

@Component({
  selector: 'app-admin',
  standalone: true,
  imports: [AdminMemberComponent],
  templateUrl: './admin.component.html',
  styleUrl: './admin.component.scss',
})
export class AdminComponent {}
