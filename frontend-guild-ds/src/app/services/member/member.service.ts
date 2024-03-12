import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable, Optional } from '@angular/core';
import { Observable } from 'rxjs';

export class Member {
  id: string | undefined;
  name: string;
  description: string;
  img: string;

  constructor(name: string, description: string, img: string, id?: string) {
    this.name = name;
    this.description = description;
    this.img = img;
    this.id = id;
  }
}

@Injectable({
  providedIn: 'root',
})
export class MemberService {
  private endPointUrl = 'http://localhost:8080/members';

  constructor(private http: HttpClient) {}

  listMembers(): Observable<Member[]> {
    return this.http.get<Member[]>(this.endPointUrl);
  }

  newMember(member: Member): Observable<String> {
    console.log('new Member ', member);
    return this.http.post(this.endPointUrl, member, {
      responseType: 'text',
    });
  }

  deleteMember(id: string): Observable<Object> {
    const options = {
      params: new HttpParams().set('id', id),
    };
    return this.http.delete(this.endPointUrl, options);
  }
}
