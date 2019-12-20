import { Injectable } from '@angular/core';
import { Seat } from 'src/app/shared/seat';
import { Observable, of} from 'rxjs';
import { delay, catchError } from 'rxjs/operators';

import { map } from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { baseURL } from '../shared/base-url';
import { Header } from '../shared/header';

@Injectable({
  providedIn: 'root'
})
export class SeatService {

  constructor(
    private http: HttpClient,
    private header: Header
    ) { }

  getSeats(): Observable<Seat[]> {
    return this.http.get<Seat[]>(baseURL + 'seat', this.header.options);
  }

  getSeatsByCinemaHall(id: string): Observable<Seat[]> {
    return this.http.get<Seat[]>(baseURL + 'seat/cinemahall/' + id, this.header.options);
  }

  putSeat(seat: Seat): Observable<Seat> {
    return this.http.put<Seat>(baseURL + 'seat/' + seat.id, seat, this.header.options);
  }

}
