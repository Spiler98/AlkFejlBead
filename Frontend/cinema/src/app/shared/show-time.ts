import { Seat } from './seat';
import { User } from './user';
import { CinemaHall } from './cinema-hall';

export class ShowTime {
    id: number;
    startTime: Date;
    cinemaHalls: CinemaHall[];
    seats: Seat[];
    viewers: User[];
}
