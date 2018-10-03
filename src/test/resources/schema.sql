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
<<<<<<< HEAD
<<<<<<< HEAD
trainer_id INTEGER NOT NULL,
=======
trainer_id VARCHAR(200) NOT NULL,
>>>>>>> 1d53405c2ab44ea173142febcbd4d1f0c3712271
=======
trainer_id VARCHAR(200) NOT NULL,
>>>>>>> 53fbc7d3f73a3e9d02fd94c10b27391c0888d5c7
batch_id INTEGER NOT NULL,
subtopic_id INTEGER NOT NULL,
flagged_id INTEGER NOT NULL,
PRIMARY KEY (id),
foreign key (status_id) references status(id));

DROP SEQUENCE IF EXISTS calendar_event_seq;
CREATE SEQUENCE IF NOT EXISTS calendar_event_seq START WITH 3;

