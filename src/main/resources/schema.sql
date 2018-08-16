CREATE TABLE calendar_subtopic
(id INTEGER NOT NULL,
subtopic_id INTEGER UNIQUE,
PRIMARY KEY (id));

CREATE TABLE calendar_curriculum
(id INTEGER NOT NULL,
curriculum_id INTEGER UNIQUE,
batch_id INTEGER UNIQUE,
PRIMARY KEY (id));

CREATE TABLE status
(id INTEGER NOT NULL,
status VARCHAR(25) UNIQUE,
PRIMARY KEY (id));

CREATE TABLE calendar_event
(id INTEGER NOT NULL,
title VARCHAR(50) NOT NULL,
description VARCHAR(250) NOT NULL,
status_id INTEGER UNIQUE,
start_date_time TIMESTAMP,
end_date_time TIMESTAMP,
calendar_subtopic_id INTEGER UNIQUE,
foreign key (calendar_subtopic_id) references calendar_subtopic(id),
foreign key (status_id) references status(id));

CREATE SEQUENCE calendar_seq START WITH 3;
