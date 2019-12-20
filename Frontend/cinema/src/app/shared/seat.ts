import { User } from './user';
import { CinemaHall } from './cinema-hall';
import { ShowTime } from './show-time';

export class Seat {
    id: number;
    rowNumber: number;
    columnNumber: number;
    status: string;
    owner: User;
    showTimes: ShowTime[];
}
