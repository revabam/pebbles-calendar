/*
merge data into the status lookup table
*/
merge into status (id, status)
values(1, 'planned');
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 53fbc7d3f73a3e9d02fd94c10b27391c0888d5c7

merge into status (id, status)
values(2, 'complete');

merge into status (id, status)
values(3, 'cancelled');

merge into status (id, status)
<<<<<<< HEAD
=======

merge into status (id, status)

values(1, 'inactive');

values(2, 'complete');


merge into status (id, status)
values(3, 'cancelled');

merge into status (id, status)
>>>>>>> 1d53405c2ab44ea173142febcbd4d1f0c3712271
=======

>>>>>>> 53fbc7d3f73a3e9d02fd94c10b27391c0888d5c7
values(4, 'missed');
/*
merge mock data into the calendar_event table
*/
merge into calendar_event (id, title, description, status_id, start_date_time, end_date_time, trainer_id, batch_id, subtopic_id, flagged_id)
values(1, 'Interfaces event', 'This is Interfaces event from the Interfaces subtopic in the Core Java topic', 1, {ts '2018-09-19 18:45:00.00'}, {ts '2018-09-19 19:45:00.00'}, 1, 1, 1, 1);
merge into calendar_event (id, title, description, status_id, start_date_time, end_date_time, trainer_id, batch_id, subtopic_id, flagged_id)
<<<<<<< HEAD
<<<<<<< HEAD
values(2, 'Inheritance event', 'This is Inheritance event from the Inheritance subtopic in the Core Java topic', 1, {ts '2018-09-19 19:45:00.00'}, {ts '2018-09-19 20:45:00.00'}, 1, 2, 2, 1);
=======
values(2, 'Inheritance event', 'This is Inheritance event from the Inheritance subtopic in the Core Java topic', 1, {ts '2018-09-19 19:45:00.00'}, {ts '2018-09-19 20:45:00.00'}, 1, 2, 2, 1);
>>>>>>> 1d53405c2ab44ea173142febcbd4d1f0c3712271
=======
values(2, 'Inheritance event', 'This is Inheritance event from the Inheritance subtopic in the Core Java topic', 1, {ts '2018-09-19 19:45:00.00'}, {ts '2018-09-19 20:45:00.00'}, 1, 2, 2, 1);
>>>>>>> 53fbc7d3f73a3e9d02fd94c10b27391c0888d5c7
