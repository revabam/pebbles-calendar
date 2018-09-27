
DROP TABLE IF EXISTS status CASCADE;
CREATE TABLE IF NOT EXISTS status
(id INTEGER NOT NULL,
status VARCHAR(25) UNIQUE,
PRIMARY KEY (id));

DROP TABLE IF EXISTS calendar_event CASCADE;
CREATE TABLE IF NOT EXISTS calendar_event
(id INTEGER NOT NULL,
title VARCHAR(50) NOT NULL,
description VARCHAR(250) NOT NULL,
status_id INTEGER,
start_date_time TIMESTAMP,
end_date_time TIMESTAMP,
trainer_id INTEGER NOT NULL,
subtopic_id INTEGER NOT NULL,
flagged_id INTEGER,
PRIMARY KEY (id),
foreign key (status_id) references status(id));


DROP SEQUENCE IF EXISTS calendar_event_seq;
CREATE SEQUENCE IF NOT EXISTS calendar_event_seq START WITH 3;

