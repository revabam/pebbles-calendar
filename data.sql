/*
insert mock data into the calendar_event table
*/
insert into calendar_event (id, title, description, status_id, start_date_time, end_date_time, calendar_subtopic_id)
values((SELECT calendar_event_seq.nextVal FROM dual), 'Interfaces event', 'This is Interfaces event from the Interfaces subtopic in the Core Java topic', 1, {ts '2018-09-19 18:45:00.00'}, {ts '2018-09-19 19:45:00.00'}, 1);
insert into calendar_event (id, title, description, status_id, start_date_time, end_date_time, calendar_subtopic_id)
values((SELECT calendar_event_seq.nextVal FROM dual), 'Inheritance event', 'This is Inheritance event from the Inheritance subtopic in the Core Java topic', 1, {ts '2018-09-19 19:45:00.00'}, {ts '2018-09-19 20:45:00.00'}, 2);

/*
insert mock data into the calendar_subtopic table
*/
insert into calendar_subtopic (id, subtopic_id)
values((SELECT calendar_subtopic.seq.nextVal FROM dual), 1);
insert into calendar_subtopic (id, subtopic_id)
values((SELECT calendar_subtopic.seq.nextVal FROM dual), 2);

/*
insert mock data into the calendar_curriculum table
*/
insert into calendar_curriculum (id, curriculum_id, batch_id)
values((SELECT calendar_subtopic.seq.nextVal FROM dual), 1, 1);
insert into calendar_curriculum (id, curriculum_id, batch_id)
values((SELECT calendar_subtopic.seq.nextVal FROM dual), 1, 2);

/*
create the status lookup table
*/
CREATE TABLE status
(id INTEGER NOT NULL,
status VARCHAR(25) UNIQUE,
PRIMARY KEY (id))

insert into status (id, role)
values(1, 'active');

insert into status (id, role)
values(2, 'inactive');
