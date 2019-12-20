import { Injectable } from '@angular/core';
import { Movie } from 'src/app/shared/movie';
import { Observable, of} from 'rxjs';
import { delay, catchError } from 'rxjs/operators';

import { map } from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { baseURL } from '../shared/base-url';
import { Header } from '../shared/header';


@Injectable({
  providedIn: 'root'
})
export class MoviesService {

  

  constructor(
    private http: HttpClient,
    private header: Header
    ) { }

  getMovies(): Observable<Movie[]> {
    return this.http.get<Movie[]>(baseURL + 'movie', this.header.options);
  }


  getMovie(id: string): Observable<Movie> {
    return this.http.get<Movie>(baseURL + 'movie/' + id, this.header.options);
  }

}
