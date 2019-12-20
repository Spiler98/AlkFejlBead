INSERT INTO cinemahall (name, row_count, column_count) VALUES ('hall1', 15, 30);
INSERT INTO cinemahall (name, row_count, column_count) VALUES ('hall2', 10, 20);
INSERT INTO cinemahall (name, row_count, column_count) VALUES ('hall3', 12, 24);


INSERT INTO movie (title, director, synopsis, duration, poster_path, upload_date) VALUES ('Joker', 'director1', 'In Gotham City, mentally troubled comedian Arthur Fleck is disregarded and mistreated by society. He then embarks on a downward spiral of revolution and bloody crime. This path brings him face-to-face with his alter-ego: the Joker.', '2:00:00', 'assets/images/Joker.jpg', '2019-11-05');
INSERT INTO movie (title, director, synopsis, duration, poster_path, upload_date) VALUES ('Doctor Strange', 'director2', 'While on a journey of physical and spiritual healing, a brilliant neurosurgeon is drawn into the world of the mystic arts.', '2:30:00', 'assets/images/DoctorStrange.jpg', '2019-11-06');
INSERT INTO movie (title, director, synopsis, duration, poster_path, upload_date) VALUES ('No Time to Die', 'director3', 'Bond has left active service. His peace is short-lived when his old friend Felix Leiter from the CIA turns up asking for help, leading Bond onto the trail of a mysterious villain armed with dangerous new technology.', '2:00:00', 'assets/images/NoTimeToDie.jpg', '2019-11-07');

INSERT INTO seat (row_number, column_number, status) VALUES (1, 2, 'FREE');
INSERT INTO seat (row_number, column_number, status) VALUES (10, 20, 'RESERVED');
INSERT INTO seat (row_number, column_number, status) VALUES (15, 25, 'SOLD');

INSERT INTO showtime (start_time, movie_id) VALUES ('2019-11-07 20:30:00', 1);
INSERT INTO showtime (start_time, movie_id) VALUES ('2019-11-07 21:30:00', 1);
INSERT INTO showtime (start_time) VALUES ('2019-11-07 19:30:00');

INSERT INTO user (user_name, password, first_name, last_name, email_address, phone_number, role) VALUES ('admin', '$2a$04$YDiv9c./ytEGZQopFfExoOgGlJL6/o0er0K.hiGb5TGKHUL8Ebn..', 'hello', 'bello', 'admin@admin.com', '123123', 'ADMIN');
INSERT INTO user (user_name, password, first_name, last_name, email_address, phone_number, role) VALUES ('employee1', '$2a$04$YDiv9c./ytEGZQopFfExoOgGlJL6/o0er0K.hiGb5TGKHUL8Ebn..', 'anyuci', 'apuci', 'emp@gmail.com', '456456', 'EMPLOYEE');
INSERT INTO user (user_name, password, first_name, last_name, email_address, phone_number, role) VALUES ('boomer123', '$2a$04$YDiv9c./ytEGZQopFfExoOgGlJL6/o0er0K.hiGb5TGKHUL8Ebn..', 'old lady', 'i am', 'iwannadie@gmail.com', '789789', 'USER');


INSERT INTO cinemahall_show_times (cinema_halls_id, show_times_id) VALUES (1, 1);
INSERT INTO cinemahall_show_times (cinema_halls_id, show_times_id) VALUES (1, 2);