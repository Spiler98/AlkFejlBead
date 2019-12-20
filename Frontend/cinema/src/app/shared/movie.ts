import { ShowTime } from './show-time';

export class Movie {
    id: number;
    title: string;
    director: string;
    synopsis: string;
    duration: number;
    posterPath: string;
    uploadDate: string;
    showTimes: ShowTime[];
}
