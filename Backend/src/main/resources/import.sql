INSERT INTO cinemahall (name, row_count, column_count) VALUES ('hall1', 15, 30);
INSERT INTO cinemahall (name, row_count, column_count) VALUES ('hall2', 10, 20);
INSERT INTO cinemahall (name, row_count, column_count) VALUES ('hall3', 12, 24);
INSERT INTO cinemahall (name, row_count, column_count) VALUES ('hall4', 20, 20);

INSERT INTO movie (title, director, synopsis, duration, poster_path, upload_date) VALUES ('movie1', 'director1', 'asd', '1:30:00', 'path1', '2019-11-05');
INSERT INTO movie (title, director, synopsis, duration, poster_path, upload_date) VALUES ('movie2', 'director2', 'sdf', '2:30:00', 'path2', '2019-11-06');
INSERT INTO movie (title, director, synopsis, duration, poster_path, upload_date) VALUES ('movie3', 'director3', 'dfg', '2:00:00', 'path3', '2019-11-07');

INSERT INTO seat (row_number, column_number, status) VALUES (1, 2, 'FREE');
INSERT INTO seat (row_number, column_number, status) VALUES (10, 20, 'RESERVED');
INSERT INTO seat (row_number, column_number, status) VALUES (15, 25, 'SOLD');

INSERT INTO showtime (start_time) VALUES ('2019-11-07 20:30:00');
INSERT INTO showtime (start_time) VALUES ('2019-11-07 21:30:00');
INSERT INTO showtime (start_time) VALUES ('2019-11-07 19:30:00');

INSERT INTO user (user_name, password, first_name, last_name, email_address, phone_number, role) VALUES ('admin', '$2a$04$YDiv9c./ytEGZQopFfExoOgGlJL6/o0er0K.hiGb5TGKHUL8Ebn..', 'hello', 'bello', 'admin@admin.com', '123123', 'ADMIN');
INSERT INTO user (user_name, password, first_name, last_name, email_address, phone_number, role) VALUES ('employee1', '$2a$04$YDiv9c./ytEGZQopFfExoOgGlJL6/o0er0K.hiGb5TGKHUL8Ebn..', 'anyuci', 'apuci', 'emp@gmail.com', '456456', 'EMPLOYEE');
INSERT INTO user (user_name, password, first_name, last_name, email_address, phone_number, role) VALUES ('boomer123', '$2a$04$YDiv9c./ytEGZQopFfExoOgGlJL6/o0er0K.hiGb5TGKHUL8Ebn..', 'old lady', 'i am', 'iwannadie@gmail.com', '789789', 'USER');

