INSERT INTO user (firstName,lastName,password,email,account) VALUES ('Evan','Tyrone','123','sagittis@sed.org','125'),
('Brian','Barclay','hrtrgs5','a.purus@auctorvelit.org','54'),
('Jelani','Tanek','fch65yhr6','imperdiet.dictum.magna@Suspendisseeleifend.ca','0'),
('Alexander','Drew','t5ytryg56y','non.nisi@facilisisnon.co.uk','0'),
('Fletcher','Hedley','5r5eyhy','sit.amet.massa@egestasadui.co.uk','0'),
('Hakeem','Ray','65yruduj','ridiculus.mus.Donec@sempereratin.com','0'),
('Victor','Noble','5ehyry669','endrerit.a.arcu@Proin.ca','0'),
('Ali','Caesar','yyfty77ytu87','libero.est.congue@arcuimperdiet.ca','50.0'),
('Basil','Kirk','kljilj9io','sapien@lectusNullam.co.uk','0'),
('Josiah','Steel','mghjft54ty5y','Cum.sociis@adipiscinglacusUt.org','0');

INSERT INTO userRole (userId, roles) VALUES ('1','USER'), ('2','USER'),
  ('3','USER'), ('4','USER'), ('5','USER'), ('6','USER'), ('7','USER'),
  ('8','USER'), ('9','USER'), ('10','USER');

INSERT INTO movieImage(image) VALUES(FILE_READ('classpath:\images\inception.jpg')),
(FILE_READ('classpath:\images\interstellar.jpg')),
(FILE_READ('classpath:\images\martian.jpg'));

INSERT INTO movie (secondaryKey,name,imageId,actors,duration,description,rating,genre,producer,productionYear,premiereDate) VALUES ('inception','Inception',
'1','Leonardo DiCaprio, Joseph Gordon-Levitt, Ellen Page', '148',
'A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.',
'8.8', 'Action, Adventure', 'Christopher Nolan', '2010','2020-06-13'),
('interstellar','Interstellar','2','Matthew McConaughey, Anne Hathaway, Jessica Chastain', '169',
'A team of explorers travel through a wormhole in space in an attempt to ensure humanity survival.',
'8.6', 'Adventure, Drama', 'Christopher Nolan', '2014','2020-06-14'),
('martian','The Martian','3','Matt Damon, Jessica Chastain, Kristen Wiig', '144',
'An astronaut becomes stranded on Mars after his team assume him dead, and must rely on his ingenuity to find a way to signal to Earth that he is alive..',
'8.0', ' Adventure, Drama, Sci-Fi', ' Ridley Scott', '2015','2020-07-25');

INSERT INTO cinemaHall (id, rowsAmount, rowsTypes, hallName) VALUES ('1','10','1,3,3,3,3,3,3,3,3,3','2D');
INSERT INTO cinemaHall (id, rowsAmount, rowsTypes, hallName) VALUES ('2','10','1,1,1,3,3,3,3,3,3,3','Relax');

INSERT INTO movieSession (dateSession,timeSession,cost,cinemaHallId,movieId) VALUES ('2020-07-22','11:30','50.0','1','1'),
('2020-07-22','18:00','50.0','2','1'),
('2020-07-22','15:00','50.0','1','2'),
('2020-07-22','17:30','50.0','1','2');

INSERT INTO reservation (userId, rowId, place, isPaid, sessionId) VALUES ('1','1','6','false','2');
INSERT INTO reservation (userId, rowId, place, isPaid, sessionId) VALUES ('2','1','7','false','2');
INSERT INTO reservation (userId, rowId, place, isPaid, sessionId) VALUES ('3','2','6','false','2');
INSERT INTO reservation (userId, rowId, place, isPaid, sessionId) VALUES ('4','5','2','false','2');
INSERT INTO reservation (userId, rowId, place, isPaid, sessionId) VALUES ('5','5','3','false','2');
INSERT INTO reservation (userId, rowId, place, isPaid, sessionId) VALUES ('6','5','4','false','2');

INSERT INTO rowCinemaHall (id, seatsAmount) VALUES ('1','7');
INSERT INTO rowCinemaHall (id, seatsAmount) VALUES ('2','8');
INSERT INTO rowCinemaHall (id, seatsAmount) VALUES ('3','10');