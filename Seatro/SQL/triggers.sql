drop trigger insert_column;
drop trigger update_users_after_insert;
drop trigger update_users;

DELIMITER //
CREATE TRIGGER insert_column BEFORE INSERT ON station_detail_users
FOR EACH ROW
BEGIN
  IF NOT (EXISTS(SELECT 1 FROM station_users WHERE line_number = NEW.line_number and station_name = NEW.station_name and check_in_time = NEW.check_in_time and direction = NEW.direction)) THEN
    INSERT INTO station_users(line_number, station_name, check_in_time, direction) VALUES (NEW.line_number, NEW.station_name, NEW.check_in_time, NEW.direction);
  END IF;
END //s
DELIMITER;


DELIMITER //
CREATE TRIGGER update_users_after_insert AFTER INSERT ON station_detail_users
FOR EACH ROW
BEGIN

  UPDATE station_users AS su SET su.people = NEW.cabin_1 + NEW.cabin_2 + NEW.cabin_3 + NEW.cabin_4 + NEW.cabin_5 + NEW.cabin_6 + NEW.cabin_7 + NEW.cabin_8 
  where su.line_number = NEW.line_number AND su.station_name = NEW.station_name AND su.check_in_time = NEW.check_in_time AND su.direction = NEW.direction;

END //
DELIMITER;


DELIMITER //
CREATE TRIGGER update_users AFTER UPDATE ON station_detail_users
FOR EACH ROW
BEGIN

  UPDATE station_users AS su SET su.people = NEW.cabin_1 + NEW.cabin_2 + NEW.cabin_3 + NEW.cabin_4 + NEW.cabin_5 + NEW.cabin_6 + NEW.cabin_7 + NEW.cabin_8 
  where su.line_number = NEW.line_number AND su.station_name = NEW.station_name AND su.check_in_time = NEW.check_in_time AND su.direction = NEW.direction;

END //
DELIMITER;