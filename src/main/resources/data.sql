/*
merge mock data into the calendar_curriculum table
*/
merge into calendar_curriculum (id, curriculum_id, batch_id)
values(1, 1, 1);
merge into calendar_curriculum (id, curriculum_id, batch_id)
values(2, 2, 2);

/*
merge mock data into the calendar_subtopic table
*/
merge into calendar_subtopic (id, subtopic_id, calendar_curriculum_id)
values(1, 1, 1);
merge into calendar_subtopic (id, subtopic_id, calendar_curriculum_id)
values(2, 2, 1);

/*
merge data into the status lookup table
*/
merge into status (id, status)
values(1, 'active');

merge into status (id, status)
values(2, 'inactive');

/*
merge mock data into the calendar_event table
*/
merge into calendar_event (id, title, description, status_id, start_date_time, end_date_time, calendar_subtopic_id)
values(1, 'Interfaces event', 'This is Interfaces event from the Interfaces subtopic in the Core Java topic', 1, {ts '2018-09-19 18:45:00.00'}, {ts '2018-09-19 19:45:00.00'}, 1);
merge into calendar_event (id, title, description, status_id, start_date_time, end_date_time, calendar_subtopic_id)
values(2, 'Inheritance event', 'This is Inheritance event from the Inheritance subtopic in the Core Java topic', 1, {ts '2018-09-19 19:45:00.00'}, {ts '2018-09-19 20:45:00.00'}, 2);


