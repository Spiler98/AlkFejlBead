import { Seat } from './seat';
import { ShowTime } from './show-time';

export class CinemaHall {
    id: number;
    name: string;
    rowCount: number;
    columnCount: number;
    seats: Seat[];
    showTimes: ShowTime[];
}
