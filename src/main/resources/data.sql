/*
insert mock data into the calendar_event table
*/
insert into calendar_event (id, title, description, status_id, start_date_time, end_date_time, calendar_subtopic_id)
values(1, 'Interfaces event', 'This is Interfaces event from the Interfaces subtopic in the Core Java topic', 1, {ts '2018-09-19 18:45:00.00'}, {ts '2018-09-19 19:45:00.00'}, 1);
insert into calendar_event (id, title, description, status_id, start_date_time, end_date_time, calendar_subtopic_id)
values(2, 'Inheritance event', 'This is Inheritance event from the Inheritance subtopic in the Core Java topic', 1, {ts '2018-09-19 19:45:00.00'}, {ts '2018-09-19 20:45:00.00'}, 2);

/*
insert mock data into the calendar_subtopic table
*/
insert into calendar_subtopic (id, subtopic_id)
values(1, 1);
insert into calendar_subtopic (id, subtopic_id)
values(2, 2);

/*
insert mock data into the calendar_curriculum table
*/
insert into calendar_curriculum (id, curriculum_id, batch_id)
values(1, 1, 1);
insert into calendar_curriculum (id, curriculum_id, batch_id)
values(2, 1, 2);

/*
insert data into the status lookup table
*/
insert into status (id, role)
values(1, 'active');

insert into status (id, role)
values(2, 'inactive');
