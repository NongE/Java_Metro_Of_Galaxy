DELIMITER //
CREATE TRIGGER insert_column BEFORE INSERT ON station_detail_users
FOR EACH ROW
BEGIN
  DECLARE tmp_line_number varchar(10);
  DECLARE tmp_station_name varchar(15);
  DECLARE tmp_check_in_time int;
  SET tmp_line_number = NEW.line_number;
  SET tmp_station_name = NEW.station_name;
  SET tmp_check_in_time = NEW.check_in_time;

  IF NOT (EXISTS(SELECT 1 FROM station_users WHERE line_number = NEW.line_number and station_name = NEW.station_name)) THEN
    INSERT INTO station_users(line_number, station_name) VALUES (NEW.line_number, NEW.station_name);
  END IF;
END //
DELIMITER;


DELIMITER //
CREATE TRIGGER update_users_after_insert AFTER INSERT ON station_detail_users
FOR EACH ROW
BEGIN
  DECLARE tmp_line_number varchar(10);
  DECLARE tmp_station_name varchar(15);
  DECLARE tmp_check_in_time int;
  SET tmp_line_number = NEW.line_number;
  SET tmp_station_name = NEW.station_name;
  SET tmp_check_in_time = NEW.check_in_time;

  
IF NEW.check_in_time = 0 THEN
   UPDATE station_users AS su SET su.time_0 = NEW.cabin_1 + NEW.cabin_2 + NEW.cabin_3 + NEW.cabin_4 + NEW.cabin_5 + NEW.cabin_6 + NEW.cabin_7 + NEW.cabin_8 where su.line_number = NEW.line_number AND su.station_name = NEW.station_name;

  ELSEIF NEW.check_in_time = 1 THEN
   UPDATE station_users AS su SET su.time_1 = NEW.cabin_1 + NEW.cabin_2 + NEW.cabin_3 + NEW.cabin_4 + NEW.cabin_5 + NEW.cabin_6 + NEW.cabin_7 + NEW.cabin_8 where su.line_number = NEW.line_number AND su.station_name = NEW.station_name;

  ELSEIF NEW.check_in_time = 2 THEN
   UPDATE station_users AS su SET su.time_2 = NEW.cabin_1 + NEW.cabin_2 + NEW.cabin_3 + NEW.cabin_4 + NEW.cabin_5 + NEW.cabin_6 + NEW.cabin_7 + NEW.cabin_8 where su.line_number = NEW.line_number AND su.station_name = NEW.station_name;

  ELSEIF NEW.check_in_time = 3 THEN
   UPDATE station_users AS su SET su.time_3 = NEW.cabin_1 + NEW.cabin_2 + NEW.cabin_3 + NEW.cabin_4 + NEW.cabin_5 + NEW.cabin_6 + NEW.cabin_7 + NEW.cabin_8 where su.line_number = NEW.line_number AND su.station_name = NEW.station_name;

  ELSEIF NEW.check_in_time = 4 THEN
   UPDATE station_users AS su SET su.time_4 = NEW.cabin_1 + NEW.cabin_2 + NEW.cabin_3 + NEW.cabin_4 + NEW.cabin_5 + NEW.cabin_6 + NEW.cabin_7 + NEW.cabin_8 where su.line_number = NEW.line_number AND su.station_name = NEW.station_name;

  ELSEIF NEW.check_in_time = 5 THEN
   UPDATE station_users AS su SET su.time_6 = NEW.cabin_1 + NEW.cabin_2 + NEW.cabin_3 + NEW.cabin_4 + NEW.cabin_5 + NEW.cabin_6 + NEW.cabin_7 + NEW.cabin_8 where su.line_number = NEW.line_number AND su.station_name = NEW.station_name;

  ELSEIF NEW.check_in_time = 7 THEN
   UPDATE station_users AS su SET su.time_7 = NEW.cabin_1 + NEW.cabin_2 + NEW.cabin_3 + NEW.cabin_4 + NEW.cabin_5 + NEW.cabin_6 + NEW.cabin_7 + NEW.cabin_8 where su.line_number = NEW.line_number AND su.station_name = NEW.station_name;

  ELSEIF NEW.check_in_time = 8 THEN
   UPDATE station_users AS su SET su.time_8 = NEW.cabin_1 + NEW.cabin_2 + NEW.cabin_3 + NEW.cabin_4 + NEW.cabin_5 + NEW.cabin_6 + NEW.cabin_7 + NEW.cabin_8 where su.line_number = NEW.line_number AND su.station_name = NEW.station_name;

  ELSEIF NEW.check_in_time = 9 THEN
   UPDATE station_users AS su SET su.time_9 = NEW.cabin_1 + NEW.cabin_2 + NEW.cabin_3 + NEW.cabin_4 + NEW.cabin_5 + NEW.cabin_6 + NEW.cabin_7 + NEW.cabin_8 where su.line_number = NEW.line_number AND su.station_name = NEW.station_name;

  ELSEIF NEW.check_in_time = 10 THEN
   UPDATE station_users AS su SET su.time_10 = NEW.cabin_1 + NEW.cabin_2 + NEW.cabin_3 + NEW.cabin_4 + NEW.cabin_5 + NEW.cabin_6 + NEW.cabin_7 + NEW.cabin_8 where su.line_number = NEW.line_number AND su.station_name = NEW.station_name;

  ELSEIF NEW.check_in_time = 11 THEN
   UPDATE station_users AS su SET su.time_11 = NEW.cabin_1 + NEW.cabin_2 + NEW.cabin_3 + NEW.cabin_4 + NEW.cabin_5 + NEW.cabin_6 + NEW.cabin_7 + NEW.cabin_8 where su.line_number = NEW.line_number AND su.station_name = NEW.station_name;

  ELSEIF NEW.check_in_time = 12 THEN
   UPDATE station_users AS su SET su.time_12 = NEW.cabin_1 + NEW.cabin_2 + NEW.cabin_3 + NEW.cabin_4 + NEW.cabin_5 + NEW.cabin_6 + NEW.cabin_7 + NEW.cabin_8 where su.line_number = NEW.line_number AND su.station_name = NEW.station_name;

  ELSEIF NEW.check_in_time = 13 THEN
   UPDATE station_users AS su SET su.time_13 = NEW.cabin_1 + NEW.cabin_2 + NEW.cabin_3 + NEW.cabin_4 + NEW.cabin_5 + NEW.cabin_6 + NEW.cabin_7 + NEW.cabin_8 where su.line_number = NEW.line_number AND su.station_name = NEW.station_name;

  ELSEIF NEW.check_in_time = 14 THEN
   UPDATE station_users AS su SET su.time_14 = NEW.cabin_1 + NEW.cabin_2 + NEW.cabin_3 + NEW.cabin_4 + NEW.cabin_5 + NEW.cabin_6 + NEW.cabin_7 + NEW.cabin_8 where su.line_number = NEW.line_number AND su.station_name = NEW.station_name;

  ELSEIF NEW.check_in_time = 15 THEN
   UPDATE station_users AS su SET su.time_15 = NEW.cabin_1 + NEW.cabin_2 + NEW.cabin_3 + NEW.cabin_4 + NEW.cabin_5 + NEW.cabin_6 + NEW.cabin_7 + NEW.cabin_8 where su.line_number = NEW.line_number AND su.station_name = NEW.station_name;

  ELSEIF NEW.check_in_time = 16 THEN
   UPDATE station_users AS su SET su.time_16 = NEW.cabin_1 + NEW.cabin_2 + NEW.cabin_3 + NEW.cabin_4 + NEW.cabin_5 + NEW.cabin_6 + NEW.cabin_7 + NEW.cabin_8 where su.line_number = NEW.line_number AND su.station_name = NEW.station_name;

  ELSEIF NEW.check_in_time = 17 THEN
   UPDATE station_users AS su SET su.time_17 = NEW.cabin_1 + NEW.cabin_2 + NEW.cabin_3 + NEW.cabin_4 + NEW.cabin_5 + NEW.cabin_6 + NEW.cabin_7 + NEW.cabin_8 where su.line_number = NEW.line_number AND su.station_name = NEW.station_name;

  ELSEIF NEW.check_in_time = 18 THEN
   UPDATE station_users AS su SET su.time_18 = NEW.cabin_1 + NEW.cabin_2 + NEW.cabin_3 + NEW.cabin_4 + NEW.cabin_5 + NEW.cabin_6 + NEW.cabin_7 + NEW.cabin_8 where su.line_number = NEW.line_number AND su.station_name = NEW.station_name;

  ELSEIF NEW.check_in_time = 19 THEN
   UPDATE station_users AS su SET su.time_19 = NEW.cabin_1 + NEW.cabin_2 + NEW.cabin_3 + NEW.cabin_4 + NEW.cabin_5 + NEW.cabin_6 + NEW.cabin_7 + NEW.cabin_8 where su.line_number = NEW.line_number AND su.station_name = NEW.station_name;

  ELSEIF NEW.check_in_time = 20 THEN
   UPDATE station_users AS su SET su.time_20 = NEW.cabin_1 + NEW.cabin_2 + NEW.cabin_3 + NEW.cabin_4 + NEW.cabin_5 + NEW.cabin_6 + NEW.cabin_7 + NEW.cabin_8 where su.line_number = NEW.line_number AND su.station_name = NEW.station_name;

  ELSEIF NEW.check_in_time = 21 THEN
   UPDATE station_users AS su SET su.time_21 = NEW.cabin_1 + NEW.cabin_2 + NEW.cabin_3 + NEW.cabin_4 + NEW.cabin_5 + NEW.cabin_6 + NEW.cabin_7 + NEW.cabin_8 where su.line_number = NEW.line_number AND su.station_name = NEW.station_name;

  ELSEIF NEW.check_in_time = 22 THEN
   UPDATE station_users AS su SET su.time_22 = NEW.cabin_1 + NEW.cabin_2 + NEW.cabin_3 + NEW.cabin_4 + NEW.cabin_5 + NEW.cabin_6 + NEW.cabin_7 + NEW.cabin_8 where su.line_number = NEW.line_number AND su.station_name = NEW.station_name;

  ELSEIF NEW.check_in_time = 23 THEN
   UPDATE station_users AS su SET su.time_23 = NEW.cabin_1 + NEW.cabin_2 + NEW.cabin_3 + NEW.cabin_4 + NEW.cabin_5 + NEW.cabin_6 + NEW.cabin_7 + NEW.cabin_8 where su.line_number = NEW.line_number AND su.station_name = NEW.station_name;
  END IF;
END //
DELIMITER;


DELIMITER //
CREATE TRIGGER update_users AFTER UPDATE ON station_detail_users
FOR EACH ROW
BEGIN
  DECLARE tmp_line_number varchar(10);
  DECLARE tmp_station_name varchar(15);
  SET tmp_line_number = OLD.line_number;
  SET tmp_station_name = OLD.station_name;

  IF OLD.check_in_time = 0 THEN
   UPDATE station_users AS su SET su.time_0 = NEW.cabin_1 + NEW.cabin_2 + NEW.cabin_3 + NEW.cabin_4 + NEW.cabin_5 + NEW.cabin_6 + NEW.cabin_7 + NEW.cabin_8 where su.line_number = OLD.line_number AND su.station_name = OLD.station_name;

  ELSEIF OLD.check_in_time = 1 THEN
   UPDATE station_users AS su SET su.time_1 = NEW.cabin_1 + NEW.cabin_2 + NEW.cabin_3 + NEW.cabin_4 + NEW.cabin_5 + NEW.cabin_6 + NEW.cabin_7 + NEW.cabin_8 where su.line_number = OLD.line_number AND su.station_name = OLD.station_name;

  ELSEIF OLD.check_in_time = 2 THEN
   UPDATE station_users AS su SET su.time_2 = NEW.cabin_1 + NEW.cabin_2 + NEW.cabin_3 + NEW.cabin_4 + NEW.cabin_5 + NEW.cabin_6 + NEW.cabin_7 + NEW.cabin_8 where su.line_number = OLD.line_number AND su.station_name = OLD.station_name;

  ELSEIF OLD.check_in_time = 3 THEN
   UPDATE station_users AS su SET su.time_3 = NEW.cabin_1 + NEW.cabin_2 + NEW.cabin_3 + NEW.cabin_4 + NEW.cabin_5 + NEW.cabin_6 + NEW.cabin_7 + NEW.cabin_8 where su.line_number = OLD.line_number AND su.station_name = OLD.station_name;

  ELSEIF OLD.check_in_time = 4 THEN
   UPDATE station_users AS su SET su.time_4 = NEW.cabin_1 + NEW.cabin_2 + NEW.cabin_3 + NEW.cabin_4 + NEW.cabin_5 + NEW.cabin_6 + NEW.cabin_7 + NEW.cabin_8 where su.line_number = OLD.line_number AND su.station_name = OLD.station_name;

  ELSEIF OLD.check_in_time = 5 THEN
   UPDATE station_users AS su SET su.time_6 = NEW.cabin_1 + NEW.cabin_2 + NEW.cabin_3 + NEW.cabin_4 + NEW.cabin_5 + NEW.cabin_6 + NEW.cabin_7 + NEW.cabin_8 where su.line_number = OLD.line_number AND su.station_name = OLD.station_name;

  ELSEIF OLD.check_in_time = 7 THEN
   UPDATE station_users AS su SET su.time_7 = NEW.cabin_1 + NEW.cabin_2 + NEW.cabin_3 + NEW.cabin_4 + NEW.cabin_5 + NEW.cabin_6 + NEW.cabin_7 + NEW.cabin_8 where su.line_number = OLD.line_number AND su.station_name = OLD.station_name;

  ELSEIF OLD.check_in_time = 8 THEN
   UPDATE station_users AS su SET su.time_8 = NEW.cabin_1 + NEW.cabin_2 + NEW.cabin_3 + NEW.cabin_4 + NEW.cabin_5 + NEW.cabin_6 + NEW.cabin_7 + NEW.cabin_8 where su.line_number = OLD.line_number AND su.station_name = OLD.station_name;

  ELSEIF OLD.check_in_time = 9 THEN
   UPDATE station_users AS su SET su.time_9 = NEW.cabin_1 + NEW.cabin_2 + NEW.cabin_3 + NEW.cabin_4 + NEW.cabin_5 + NEW.cabin_6 + NEW.cabin_7 + NEW.cabin_8 where su.line_number = OLD.line_number AND su.station_name = OLD.station_name;

  ELSEIF OLD.check_in_time = 10 THEN
   UPDATE station_users AS su SET su.time_10 = NEW.cabin_1 + NEW.cabin_2 + NEW.cabin_3 + NEW.cabin_4 + NEW.cabin_5 + NEW.cabin_6 + NEW.cabin_7 + NEW.cabin_8 where su.line_number = OLD.line_number AND su.station_name = OLD.station_name;

  ELSEIF OLD.check_in_time = 11 THEN
   UPDATE station_users AS su SET su.time_11 = NEW.cabin_1 + NEW.cabin_2 + NEW.cabin_3 + NEW.cabin_4 + NEW.cabin_5 + NEW.cabin_6 + NEW.cabin_7 + NEW.cabin_8 where su.line_number = OLD.line_number AND su.station_name = OLD.station_name;

  ELSEIF OLD.check_in_time = 12 THEN
   UPDATE station_users AS su SET su.time_12 = NEW.cabin_1 + NEW.cabin_2 + NEW.cabin_3 + NEW.cabin_4 + NEW.cabin_5 + NEW.cabin_6 + NEW.cabin_7 + NEW.cabin_8 where su.line_number = OLD.line_number AND su.station_name = OLD.station_name;

  ELSEIF OLD.check_in_time = 13 THEN
   UPDATE station_users AS su SET su.time_13 = NEW.cabin_1 + NEW.cabin_2 + NEW.cabin_3 + NEW.cabin_4 + NEW.cabin_5 + NEW.cabin_6 + NEW.cabin_7 + NEW.cabin_8 where su.line_number = OLD.line_number AND su.station_name = OLD.station_name;

  ELSEIF OLD.check_in_time = 14 THEN
   UPDATE station_users AS su SET su.time_14 = NEW.cabin_1 + NEW.cabin_2 + NEW.cabin_3 + NEW.cabin_4 + NEW.cabin_5 + NEW.cabin_6 + NEW.cabin_7 + NEW.cabin_8 where su.line_number = OLD.line_number AND su.station_name = OLD.station_name;

  ELSEIF OLD.check_in_time = 15 THEN
   UPDATE station_users AS su SET su.time_15 = NEW.cabin_1 + NEW.cabin_2 + NEW.cabin_3 + NEW.cabin_4 + NEW.cabin_5 + NEW.cabin_6 + NEW.cabin_7 + NEW.cabin_8 where su.line_number = OLD.line_number AND su.station_name = OLD.station_name;

  ELSEIF OLD.check_in_time = 16 THEN
   UPDATE station_users AS su SET su.time_16 = NEW.cabin_1 + NEW.cabin_2 + NEW.cabin_3 + NEW.cabin_4 + NEW.cabin_5 + NEW.cabin_6 + NEW.cabin_7 + NEW.cabin_8 where su.line_number = OLD.line_number AND su.station_name = OLD.station_name;

  ELSEIF OLD.check_in_time = 17 THEN
   UPDATE station_users AS su SET su.time_17 = NEW.cabin_1 + NEW.cabin_2 + NEW.cabin_3 + NEW.cabin_4 + NEW.cabin_5 + NEW.cabin_6 + NEW.cabin_7 + NEW.cabin_8 where su.line_number = OLD.line_number AND su.station_name = OLD.station_name;

  ELSEIF OLD.check_in_time = 18 THEN
   UPDATE station_users AS su SET su.time_18 = NEW.cabin_1 + NEW.cabin_2 + NEW.cabin_3 + NEW.cabin_4 + NEW.cabin_5 + NEW.cabin_6 + NEW.cabin_7 + NEW.cabin_8 where su.line_number = OLD.line_number AND su.station_name = OLD.station_name;

  ELSEIF OLD.check_in_time = 19 THEN
   UPDATE station_users AS su SET su.time_19 = NEW.cabin_1 + NEW.cabin_2 + NEW.cabin_3 + NEW.cabin_4 + NEW.cabin_5 + NEW.cabin_6 + NEW.cabin_7 + NEW.cabin_8 where su.line_number = OLD.line_number AND su.station_name = OLD.station_name;

  ELSEIF OLD.check_in_time = 20 THEN
   UPDATE station_users AS su SET su.time_20 = NEW.cabin_1 + NEW.cabin_2 + NEW.cabin_3 + NEW.cabin_4 + NEW.cabin_5 + NEW.cabin_6 + NEW.cabin_7 + NEW.cabin_8 where su.line_number = OLD.line_number AND su.station_name = OLD.station_name;

  ELSEIF OLD.check_in_time = 21 THEN
   UPDATE station_users AS su SET su.time_21 = NEW.cabin_1 + NEW.cabin_2 + NEW.cabin_3 + NEW.cabin_4 + NEW.cabin_5 + NEW.cabin_6 + NEW.cabin_7 + NEW.cabin_8 where su.line_number = OLD.line_number AND su.station_name = OLD.station_name;

  ELSEIF OLD.check_in_time = 22 THEN
   UPDATE station_users AS su SET su.time_22 = NEW.cabin_1 + NEW.cabin_2 + NEW.cabin_3 + NEW.cabin_4 + NEW.cabin_5 + NEW.cabin_6 + NEW.cabin_7 + NEW.cabin_8 where su.line_number = OLD.line_number AND su.station_name = OLD.station_name;

  ELSEIF OLD.check_in_time = 23 THEN
   UPDATE station_users AS su SET su.time_23 = NEW.cabin_1 + NEW.cabin_2 + NEW.cabin_3 + NEW.cabin_4 + NEW.cabin_5 + NEW.cabin_6 + NEW.cabin_7 + NEW.cabin_8 where su.line_number = OLD.line_number AND su.station_name = OLD.station_name;

  END IF;
END //
DELIMITER;