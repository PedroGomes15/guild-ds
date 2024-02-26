import { Component, AfterViewInit, ElementRef, ViewChild } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';
import { FileUploaderService } from '../../services/file-uploader.service';

@Component({
  selector: 'input-image-picker',
  standalone: true,
  imports: [MatCardModule, MatIconModule],
  providers: [FileUploaderService],
  templateUrl: './input-image-picker.component.html',
  styleUrl: './input-image-picker.component.scss',
})
export class InputImagePickerComponent implements AfterViewInit {
  imageUploaded: String = '';

  @ViewChild('inputImage') inputElement: ElementRef | undefined;

  constructor(private fileUploaderService: FileUploaderService) {}

  HandleUpload() {
    this.inputElement?.nativeElement.click();
  }

  ngAfterViewInit(): void {
    if (this.inputElement) {
      this.inputElement.nativeElement.addEventListener(
        'change',
        (event: Event) => {
          const fileInput = event.target as HTMLInputElement;

          if (fileInput.files![0]) {
            console.log('Arquivo selecionado:', fileInput.files![0]);
            this.uploadFile(fileInput.files![0]);
          } else {
            console.log('Nenhum arquivo selecionado');
          }
        }
      );
    }
  }

  uploadFile(file: File) {
    this.fileUploaderService.sendData(file).subscribe({
      next: (path: String) => {
        console.log('Finalizaou o upload no path ', path);
        this.imageUploaded = path;
      },
      error: (error) => {
        console.error('Erro ao fazer upload do arquivo:', error);
        // Trate os erros aqui
      },
    });
  }
}
