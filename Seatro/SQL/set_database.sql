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
INSERT INTO subway_stations VALUES ("5호선", "군자");


CREATE TABLE station_detail_users(
 line_number varchar(10),
 station_name varchar(15),
 check_in_time int,
 cabin_1 int,
 cabin_2 int,
 cabin_3 int,
 cabin_4 int,
 cabin_5 int,
 cabin_6 int,
 cabin_7 int,
 cabin_8 int,
 PRIMARY KEY(line_number, station_name, check_in_time)
);

INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 0, 3, 10, 10, 10, 10, 10, 10, 10);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 1, 10, 10, 10, 10, 10, 10, 10, 10);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 2, 5, 10, 10, 10, 10, 10, 10, 10);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 3, 3, 10, 10, 10, 10, 10, 10, 10);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 4, 10, 10, 10, 10, 10, 10, 10, 10);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 5, 5, 10, 10, 10, 10, 10, 10, 10);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 6, 3, 10, 10, 10, 10, 10, 10, 10);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 7, 10, 10, 10, 10, 10, 10, 10, 10);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 8, 5, 10, 10, 10, 10, 10, 10, 10);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 9, 3, 10, 10, 10, 10, 10, 10, 10);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 10, 10, 10, 10, 10, 10, 10, 10, 10);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 11, 5, 10, 10, 10, 10, 10, 10, 10);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 12, 3, 10, 10, 10, 10, 10, 10, 10);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 13, 10, 10, 10, 10, 10, 10, 10, 10);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 14, 5, 10, 10, 10, 10, 10, 10, 10);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 15, 10, 10, 10, 10, 10, 10, 10, 10);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 16, 5, 10, 10, 10, 10, 10, 10, 10);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 17, 3, 10, 10, 10, 10, 10, 10, 10);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 18, 10, 10, 10, 10, 10, 10, 10, 10);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 19, 5, 10, 10, 10, 10, 10, 10, 10);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 20, 10, 10, 10, 10, 10, 10, 10, 10);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 21, 5, 10, 10, 10, 10, 10, 10, 10);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 22, 3, 10, 10, 10, 10, 10, 10, 10);
INSERT INTO station_detail_users VALUES ("7호선", "건대입구", 23, 3, 10, 10, 10, 10, 10, 10, 10);

CREATE TABLE station_users(
 line_number varchar(10),
 station_name varchar(15),
 time_0 int,
 time_1 int,
 time_2 int,
 time_3 int,
 time_4 int,
 time_5 int,
 time_6 int,
 time_7 int,
 time_8 int,
 time_9 int,
 time_10 int,
 time_11 int,
 time_12 int,
 time_13 int,
 time_14 int,
 time_15 int,
 time_16 int,
 time_17 int,
 time_18 int,
 time_19 int,
 time_20 int,
 time_21 int,
 time_22 int,
 time_23 int,
 PRIMARY KEY(line_number, station_name)
);


CREATE TABLE surround_stations(
 line_number varchar(10),
 station_name varchar(15),
 right_station varchar(15),
 left_station varchar(15),
 PRIMARY KEY(line_number, station_name, right_station, left_station)
);

INSERT INTO surround_stations VALUES ("7호선", "건대입구", "어린이대공원", "뚝섬 유원지");
INSERT INTO surround_stations VALUES ("2호선", "건대입구", "성수", "구의");
INSERT INTO surround_stations VALUES ("5호선", "군자", "장한평", "아차산");



select * from station_detail_users;
select * from station_users;