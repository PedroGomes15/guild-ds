import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class FileUploaderService {
  private endPointUrl = 'http://localhost:8080/files/upload';

  constructor(private http: HttpClient) {}

  sendData(file: File): Observable<String> {
    const form = new FormData();
    form.append('file', file);

    return this.http.post(this.endPointUrl, form, {
      responseType: 'text',
    });
  }
}
