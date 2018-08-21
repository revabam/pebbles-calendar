CREATE TABLE calendar_curriculum
(id INTEGER NOT NULL,
curriculum_id INTEGER NOT NULL,
batch_id INTEGER UNIQUE NOT NULL,
PRIMARY KEY (id));

CREATE TABLE calendar_subtopic
(id INTEGER NOT NULL,
subtopic_id INTEGER NOT NULL,
calendar_curriculum_id INTEGER NOT NULL,
PRIMARY KEY (id),
foreign key (calendar_curriculum_id) references calendar_curriculum(id));

CREATE TABLE status
(id INTEGER NOT NULL,
status VARCHAR(25) UNIQUE,
PRIMARY KEY (id));

CREATE TABLE calendar_event
(id INTEGER NOT NULL,
title VARCHAR(50) NOT NULL,
description VARCHAR(250) NOT NULL,
status_id INTEGER,
start_date_time TIMESTAMP,
end_date_time TIMESTAMP,
calendar_subtopic_id INTEGER NOT NULL,
PRIMARY KEY (id),
foreign key (calendar_subtopic_id) references calendar_subtopic(id),
foreign key (status_id) references status(id));

CREATE SEQUENCE calendar_curriculum_seq START WITH 3;
CREATE SEQUENCE calendar_event_seq START WITH 3;
CREATE SEQUENCE calendar_subtopic_seq START WITH 3;
