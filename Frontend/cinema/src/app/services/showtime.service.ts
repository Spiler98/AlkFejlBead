import { Injectable } from '@angular/core';
import { ShowTime } from 'src/app/shared/show-time';
import { Observable, of} from 'rxjs';
import { delay, catchError } from 'rxjs/operators';

import { map } from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { baseURL } from '../shared/base-url';
import { Header } from '../shared/header';

@Injectable({
  providedIn: 'root'
})
export class ShowtimesService {

  constructor(
  private http: HttpClient,
  private header: Header
  ) { }

  getShowTimes(): Observable<ShowTime[]> {
    return this.http.get<ShowTime[]>(baseURL + 'showtime', this.header.options);
  }


  getShowTime(id: string): Observable<ShowTime> {
    return this.http.get<ShowTime>(baseURL + 'showtime/' + id, this.header.options);
  }
}
