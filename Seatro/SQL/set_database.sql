DROP TABLE IF EXISTS subway_stations;
DROP TABLE IF EXISTS station_detail_users;
DROP TABLE IF EXISTS station_users;
DROP TABLE IF EXISTS surround_stations;


CREATE TABLE subway_stations(
 line_number varchar(10),
 station_name varchar(15),
 PRIMARY KEY(line_number, station_name)
);

INSERT INTO subway_stations VALUES ("7호선", "건대입구");
INSERT INTO subway_stations VALUES ("2호선", "건대입구");


CREATE TABLE surround_stations(
 line_number varchar(10),
 station_name varchar(15),
 direction int,
 surround_station varchar(15),
 PRIMARY KEY(line_number, station_name, direction)
);

INSERT INTO surround_stations VALUES ("7호선", "건대입구", 0, "어린이대공원");
INSERT INTO surround_stations VALUES ("7호선", "건대입구", 1, "뚝섬 유원지");
INSERT INTO surround_stations VALUES ("2호선", "건대입구", 0, "성수");
INSERT INTO surround_stations VALUES ("2호선", "건대입구", 1, "구의");


CREATE TABLE station_detail_users(
 line_number varchar(10),
 station_name varchar(15),
 direction int,
 check_in_time int,
 cabin_1 int,
 cabin_2 int,
 cabin_3 int,
 cabin_4 int,
 cabin_5 int,
 cabin_6 int,
 cabin_7 int,
 cabin_8 int,
 PRIMARY KEY(line_number, station_name, direction, check_in_time)
);

INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 0, 0, 3, 10, 10, 10, 10, 10, 10, 10);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 0, 1, 10, 10, 10, 10, 10, 10, 10, 10);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 0, 2, 5, 10, 10, 10, 10, 10, 10, 10);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 0, 3, 3, 10, 10, 10, 10, 10, 10, 10);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 0, 4, 10, 10, 10, 10, 10, 10, 10, 10);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 0, 5, 5, 10, 10, 10, 10, 10, 10, 10);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 0, 6, 3, 10, 10, 10, 10, 10, 10, 10);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 0, 7, 10, 10, 10, 10, 10, 10, 10, 10);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 0, 8, 5, 10, 10, 10, 10, 10, 10, 10);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 0, 9, 3, 10, 10, 10, 10, 10, 10, 10);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 0, 10, 10, 10, 10, 10, 10, 10, 10, 10);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 0, 11, 5, 10, 10, 10, 10, 10, 10, 10);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 0, 12, 3, 10, 10, 10, 10, 10, 10, 10);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 0, 13, 10, 10, 10, 10, 10, 10, 10, 10);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 0, 14, 5, 10, 10, 10, 10, 10, 10, 10);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 0, 15, 10, 10, 10, 10, 10, 10, 10, 10);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 0, 16, 5, 10, 10, 10, 10, 10, 10, 10);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 0, 17, 3, 10, 10, 10, 10, 10, 10, 10);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 0, 18, 10, 10, 10, 10, 10, 10, 10, 10);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 0, 19, 5, 10, 10, 10, 10, 10, 10, 10);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 0, 20, 10, 10, 10, 10, 10, 10, 10, 10);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 0, 21, 5, 10, 10, 10, 10, 10, 10, 10);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 0, 22, 3, 10, 10, 10, 10, 10, 10, 10);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 0, 23, 3, 10, 10, 10, 10, 10, 10, 10);

INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 1, 0, 3, 30, 30, 30, 30, 3, 3, 3);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 1, 1, 3, 19, 19, 19, 19, 19, 19, 19);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 1, 2, 5, 19, 11, 11, 11, 11, 19, 19);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 1, 3, 3, 19, 19, 19, 19, 19, 19, 19);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 1, 4, 3, 3, 3, 3, 3, 3, 3, 3);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 1, 5, 5, 3, 3, 3, 3, 3, 3, 3);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 1, 6, 3, 3, 50, 50, 50, 50, 50, 3);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 1, 7, 3, 3, 3, 3, 3, 3, 3, 3);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 1, 8, 5, 3, 3, 3, 3, 3, 3, 3);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 1, 9, 3, 3, 3, 2, 2, 2, 2, 2);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 1, 10, 3, 3, 3, 2, 2, 2, 2, 2);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 1, 11, 5, 2, 2, 2, 2, 2, 2, 2);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 1, 12, 3, 2, 2, 2, 2, 10, 10, 10);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 1, 13, 10, 10, 1, 1, 1, 1, 1, 1);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 1, 14, 5, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 1, 15, 1, 1, 11, 11, 11, 11, 11, 11);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 1, 16, 5, 11, 11, 11, 11, 11, 11, 11);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 1, 17, 3, 11, 11, 11, 11, 11, 11, 11);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 1, 18, 11, 11, 11, 1, 1, 1, 1, 1);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 1, 19, 5, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 1, 20, 1, 1, 1, 1, 1, 13, 13, 13);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 1, 21, 5, 13, 13, 13, 13, 13, 13, 13);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 1, 22, 3, 13, 13, 13, 13, 13, 13, 13);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 1, 23, 3, 13, 13, 13, 13, 10, 10, 10);

--

INSERT INTO station_detail_users VALUES ("2호선", "건대입구", 0, 0, 3, 13, 13, 13, 13, 13, 13, 13);
INSERT INTO station_detail_users VALUES ("2호선", "건대입구", 0, 1, 13, 13, 13, 13, 13, 13, 13, 13);
INSERT INTO station_detail_users VALUES ("2호선", "건대입구", 0, 2, 5, 13, 13, 13, 13, 13, 13, 13);
INSERT INTO station_detail_users VALUES ("2호선", "건대입구", 0, 3, 3, 13, 13, 13, 13, 13, 13, 13);
INSERT INTO station_detail_users VALUES ("2호선", "건대입구", 0, 4, 13, 13, 13, 13, 13, 13, 13, 13);
INSERT INTO station_detail_users VALUES ("2호선", "건대입구", 0, 5, 5, 14, 14, 14, 14, 14, 14, 14);
INSERT INTO station_detail_users VALUES ("2호선", "건대입구", 0, 6, 3, 14, 14, 14, 14, 14, 14, 14);
INSERT INTO station_detail_users VALUES ("2호선", "건대입구", 0, 7, 14, 14, 14, 14, 14, 14, 14, 14);
INSERT INTO station_detail_users VALUES ("2호선", "건대입구", 0, 8, 5, 14, 14, 14, 14, 14, 14, 14);
INSERT INTO station_detail_users VALUES ("2호선", "건대입구", 0, 9, 3, 14, 14, 14, 14, 14, 14, 14);
INSERT INTO station_detail_users VALUES ("2호선", "건대입구", 0, 10, 14, 14, 14, 14, 14, 14, 14, 14);
INSERT INTO station_detail_users VALUES ("2호선", "건대입구", 0, 11, 5, 14, 14, 14, 9, 9, 9, 9);
INSERT INTO station_detail_users VALUES ("2호선", "건대입구", 0, 12, 3, 9, 9, 9, 9, 9, 9, 9);
INSERT INTO station_detail_users VALUES ("2호선", "건대입구", 0, 13, 9, 9, 9, 9, 9, 9, 9, 9);
INSERT INTO station_detail_users VALUES ("2호선", "건대입구", 0, 14, 5, 9, 9, 9, 9, 9, 9, 9);
INSERT INTO station_detail_users VALUES ("2호선", "건대입구", 0, 15, 9, 9, 9, 9, 9, 9, 9, 9);
INSERT INTO station_detail_users VALUES ("2호선", "건대입구", 0, 16, 5, 9, 9, 9, 9, 9, 9, 9);
INSERT INTO station_detail_users VALUES ("2호선", "건대입구", 0, 17, 3, 9, 9, 10, 10, 10, 10, 10);
INSERT INTO station_detail_users VALUES ("2호선", "건대입구", 0, 18, 10, 8, 8, 8, 8, 8, 8, 8);
INSERT INTO station_detail_users VALUES ("2호선", "건대입구", 0, 19, 5, 8, 8, 8, 8, 8, 8, 8);
INSERT INTO station_detail_users VALUES ("2호선", "건대입구", 0, 20, 8, 8, 8, 8, 8, 8, 8, 8);
INSERT INTO station_detail_users VALUES ("2호선", "건대입구", 0, 21, 5, 8, 8, 8, 8, 8, 8, 8);
INSERT INTO station_detail_users VALUES ("2호선", "건대입구", 0, 22, 3, 8, 8, 8, 8, 8, 8, 8);
INSERT INTO station_detail_users VALUES ("2호선", "건대입구", 0, 23, 3, 8, 8, 8, 10, 10, 10, 10);

INSERT INTO station_detail_users VALUES ("2호선", "건대입구", 1, 0, 3, 30, 30, 30, 30, 3, 3, 3);
INSERT INTO station_detail_users VALUES ("2호선", "건대입구", 1, 1, 3, 15, 15, 15, 15, 19, 19, 19);
INSERT INTO station_detail_users VALUES ("2호선", "건대입구", 1, 2, 5, 19, 11, 11, 11, 11, 19, 19);
INSERT INTO station_detail_users VALUES ("2호선", "건대입구", 1, 3, 3, 19, 19, 11, 11, 11, 19, 19);
INSERT INTO station_detail_users VALUES ("2호선", "건대입구", 1, 4, 3, 3, 3, 3, 3, 3, 3, 3);
INSERT INTO station_detail_users VALUES ("2호선", "건대입구", 1, 5, 5, 3, 3, 3, 3, 3, 3, 3);
INSERT INTO station_detail_users VALUES ("2호선", "건대입구", 1, 6, 3, 3, 50, 45, 45, 45, 50, 3);
INSERT INTO station_detail_users VALUES ("2호선", "건대입구", 1, 7, 3, 3, 3, 3, 3, 3, 3, 3);
INSERT INTO station_detail_users VALUES ("2호선", "건대입구", 1, 8, 5, 3, 3, 3, 3, 3, 3, 3);
INSERT INTO station_detail_users VALUES ("2호선", "건대입구", 1, 9, 3, 3, 3, 2, 2, 2, 2, 2);
INSERT INTO station_detail_users VALUES ("2호선", "건대입구", 1, 10, 2, 2, 2, 7, 7, 7, 7, 2);
INSERT INTO station_detail_users VALUES ("2호선", "건대입구", 1, 11, 5, 2, 2, 2, 2, 2, 2, 2);
INSERT INTO station_detail_users VALUES ("2호선", "건대입구", 1, 12, 3, 6, 6, 2, 2, 10, 10, 10);
INSERT INTO station_detail_users VALUES ("2호선", "건대입구", 1, 13, 10, 10, 1, 1, 1, 1, 1, 1);
INSERT INTO station_detail_users VALUES ("2호선", "건대입구", 1, 14, 5, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO station_detail_users VALUES ("2호선", "건대입구", 1, 15, 1, 1, 11, 13, 13, 13, 13, 13);
INSERT INTO station_detail_users VALUES ("2호선", "건대입구", 1, 16, 5, 13, 13, 13, 13, 11, 11, 11);
INSERT INTO station_detail_users VALUES ("2호선", "건대입구", 1, 17, 3, 11, 11, 11, 11, 11, 11, 11);
INSERT INTO station_detail_users VALUES ("2호선", "건대입구", 1, 18, 11, 11, 11, 5, 5, 5, 5, 1);
INSERT INTO station_detail_users VALUES ("2호선", "건대입구", 1, 19, 5, 1, 9, 9, 9, 9, 9, 1);
INSERT INTO station_detail_users VALUES ("2호선", "건대입구", 1, 20, 1, 1, 1, 1, 1, 13, 13, 13);
INSERT INTO station_detail_users VALUES ("2호선", "건대입구", 1, 21, 5, 13, 16, 16, 16, 16, 16, 16);
INSERT INTO station_detail_users VALUES ("2호선", "건대입구", 1, 22, 3, 16, 16, 16, 16, 16, 16, 16);
INSERT INTO station_detail_users VALUES ("2호선", "건대입구", 1, 23, 3, 16, 13, 13, 13, 10, 10, 10);


CREATE TABLE station_users(
 line_number varchar(10),
 station_name varchar(15),
 direction int,
 check_in_time int,
 people int,
 PRIMARY KEY(line_number, station_name, direction, check_in_time)
);

select * from subway_stations;
select * from station_detail_users;
select * from station_users;
select * from surround_stations;

select * from station_detail_users as sdu left join surround_stations as ss on sdu.direction = ss.direction;

select max(people) from station_users where check_in_time = 3;

update station_detail_users set cabin_1 = 100 where cabin_1 = 3 and direction = 0 and check_in_time = 0 cabin_2 = 13;