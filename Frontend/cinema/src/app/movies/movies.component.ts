import { Component, OnInit } from '@angular/core';
import { Movie } from "src/app/shared/movie";
import { ShowTime } from "src/app/shared/show-time";

import { MatDialog, MatDialogRef } from '@angular/material';
import { ReservationComponent } from '../reservation/reservation.component';

import {  MoviesService } from '../services/movie.service';
import {  ShowtimesService } from '../services/showtime.service';

@Component({
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.scss']
})
export class MoviesComponent implements OnInit {

  movies: Movie[];
  showTimes: ShowTime[];

  constructor(
    public dialog: MatDialog,
    private moviesService: MoviesService,
    private showTimesService: ShowtimesService
    ) { }

  ngOnInit() {

    this.showTimesService.getShowTimes()
    . subscribe((showTimes) => {
        this.showTimes = showTimes;
    });

    this.moviesService.getMovies()
      .subscribe((movies) => {
        this.movies = movies;
    });
      
  }

  returnShowTime(id: number): Date {
    return this.showTimes.filter((showTime) => showTime.id = id)[0].startTime;
  }

  openReservationForm(id: number) {
    this.dialog.open(ReservationComponent, {width: '750px', height: '520px',data:{
      showtimeId: id
    }});
  }

}
