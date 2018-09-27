-- DROP TABLE IF EXISTS calendar_curriculum CASCADE;
-- CREATE TABLE IF NOT EXISTS calendar_curriculum
-- (id INTEGER NOT NULL,
-- curriculum_id INTEGER NOT NULL,
-- batch_id INTEGER UNIQUE NOT NULL,
-- PRIMARY KEY (id));

-- DROP TABLE IF EXISTS calendar_subtopic CASCADE;
-- CREATE TABLE IF NOT EXISTS calendar_subtopic
-- (id INTEGER NOT NULL,
-- subtopic_id INTEGER NOT NULL,
-- calendar_curriculum_id INTEGER NOT NULL,
-- PRIMARY KEY (id),
-- foreign key (calendar_curriculum_id) references calendar_curriculum(id));

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
PRIMARY KEY (id),
-- foreign key (calendar_subtopic_id) references calendar_subtopic(id),
foreign key (status_id) references status(id));

DROP SEQUENCE IF EXISTS calendar_curriculum_seq;
CREATE SEQUENCE IF NOT EXISTS calendar_curriculum_seq START WITH 3;

DROP SEQUENCE IF EXISTS calendar_event_seq;
CREATE SEQUENCE IF NOT EXISTS calendar_event_seq START WITH 3;

DROP SEQUENCE IF EXISTS calendar_subtopic_seq;
CREATE SEQUENCE IF NOT EXISTS calendar_subtopic_seq START WITH 3;
