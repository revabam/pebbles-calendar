FROM java:8
ADD ./pebbles-calendar.jar .
EXPOSE 9994
CMD java -jar -Xmx512M pebbles-calendar.jar