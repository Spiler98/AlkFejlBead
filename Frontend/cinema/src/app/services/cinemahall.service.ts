import { Injectable } from '@angular/core';

import { Observable, of} from 'rxjs';

import { HttpClient, HttpHeaders } from '@angular/common/http';

import { CinemaHall } from '../shared/cinema-hall';
import { baseURL } from '../shared/base-url';
import { Header } from '../shared/header';

@Injectable({
  providedIn: 'root'
})
export class CinemahallService {

  
  constructor(
    private http: HttpClient,
    private header: Header
    ) { }

  getCinemaHalls(): Observable<CinemaHall[]> {
    return this.http.get<CinemaHall[]>(baseURL + 'cinemahall', this.header.options);
  }


  getCinemaHall(id: string): Observable<CinemaHall> {
    return this.http.get<CinemaHall>(baseURL + 'cinemahall/' + id, this.header.options);
  }
}
