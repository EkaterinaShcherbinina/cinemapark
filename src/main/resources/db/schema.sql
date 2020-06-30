CREATE TABLE user (
    id mediumint(8) unsigned NOT NULL auto_increment,
    firstName varchar(255) default NULL,
    lastName varchar(255) default NULL,
    password varchar(100) default NULL,
    email varchar(255) default NULL,
    account double default NULL,
    PRIMARY KEY (id)
  );

  CREATE TABLE movie (
    id mediumint(8) unsigned NOT NULL auto_increment,
    secondaryKey varchar(255) default NULL,
    name varchar(255) default NULL,
    image_url varchar(100) default NULL,
    actors varchar(255) default NULL,
    duration mediumint default NULL,
    description varchar(255) default NULL,
    rating double default NULL,
    genre varchar(255) default NULL,
    producer varchar(255) default NULL,
    productionYear varchar(255) default NULL,
    premiereDate DATE default NULL,
    PRIMARY KEY (id)
  );

  CREATE TABLE cinemaHall (
     id mediumint(8) unsigned NOT NULL,
     rowsAmount mediumint default NULL,
     rowsTypes varchar(255) default NULL,
     PRIMARY KEY (id)
  );

   CREATE TABLE movieSession (
      id mediumint(8) unsigned NOT NULL auto_increment,
      movieId mediumint default NULL,
      dateSession DATE default NULL,
      timeSession TIME default null,
      cost double default NULL,
      cinemaHallId mediumint default NULL,
      PRIMARY KEY (id),
      CONSTRAINT cinemaHallForeignKey FOREIGN KEY (cinemaHallId) REFERENCES cinemaHall (id)
   );

   CREATE TABLE reservation (
       id mediumint(8) unsigned NOT NULL auto_increment,
       userId mediumint default NULL,
       rowId mediumint default NULL,
       place mediumint default NULL,
       sessionId mediumint default NULL,
       PRIMARY KEY (id),
       CONSTRAINT movieSessionForeignKey FOREIGN KEY (sessionId) REFERENCES movieSession (id),
       CONSTRAINT userForeignKey FOREIGN KEY (userId) REFERENCES user (id)
   );

   CREATE TABLE rowCinemaHall (
        id mediumint(8) unsigned NOT NULL,
        seatsAmount mediumint default NULL,
        PRIMARY KEY (id)
   );