import { Component } from '@angular/core';
import { AdminMemberComponent } from '../../components/forms/admin-member/admin-member.component';
import { MatTabsModule } from '@angular/material/tabs';

@Component({
  selector: 'app-admin',
  standalone: true,
  imports: [AdminMemberComponent, MatTabsModule],
  templateUrl: './admin.component.html',
  styleUrl: './admin.component.scss',
})
export class AdminComponent {}
