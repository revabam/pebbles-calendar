# pebbles-calendar
Calendar Service application for the Pebbles Microservice Ecosystem

# Sprint 2 Final Thoughts - 10/05/18
- Alicia Douglas | Spark1806-USF-Java | Steven Kelsey
- Obosa Nosa-Igiebor | Spark1806-USF-Java | Steven Kelsey
- Marcin Salamon | Spark1806-USF-Java | Steven Kelsey
- Joshua Maciejewski | Spark1806-USF-Java | Steven Kelsey

The models in this service where updated so they now only include the calendar_event and status models. The endpoints were adjusted to match what was required for the client-side calendar component and the client-side application is now communicating with the server-side. Aop logging was implemented using Splunk. Junit and REST Assured were used to test endpoints.

There is still currently no inner-service communication with other microservices. REST-Template, fallback, circuit breaking, and messaging queues will need to be implemented in future sprints. 

# Sprint 1 Final Thoughts - 8/24/18
- Brandon Scoggins | 1806-Jun-USF-Java | Wezley Singleton

This service contains basic CRUD functionality for it's models. More complex methods can be created as needed to meet client-side requirements after this microservice environment is hosted, and communication with a client-side application is established. 

Currently, there is no inter-service communication with other services in this microservice environment. REST-Template, fallback, and circuit break implementations will need to be added in future sprints.