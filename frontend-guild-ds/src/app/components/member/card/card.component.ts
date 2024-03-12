import { Component, Input, Output, EventEmitter } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { MemberService } from '../../../services/member/member.service';

@Component({
  selector: 'app-card',
  standalone: true,
  imports: [MatCardModule],
  providers: [MemberService],
  templateUrl: './card.component.html',
  styleUrl: './card.component.scss',
})
export class CardComponent {
  @Input({ required: true }) name!: string;
  @Input({ required: true }) description!: string;
  @Input({ required: true }) img!: string;
  @Input() id!: string;
  @Output() onDelete: EventEmitter<any> = new EventEmitter();

  constructor(private memberService: MemberService) {}

  handleDelete() {
    this.memberService.deleteMember(this.id).subscribe({
      next: (t) => {
        this.onDelete.emit();
      },
    });
  }
}
