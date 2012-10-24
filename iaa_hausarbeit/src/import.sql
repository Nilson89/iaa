/* Manipel */
INSERT INTO Manipel (studienrichtung, jahrgang) VALUES ('I', 2007);
INSERT INTO Manipel (studienrichtung, jahrgang) VALUES ('I', 2008);
INSERT INTO Manipel (studienrichtung, jahrgang) VALUES ('I', 2009);
INSERT INTO Manipel (studienrichtung, jahrgang) VALUES ('I', 2010);
INSERT INTO Manipel (studienrichtung, jahrgang) VALUES ('I', 2011);
INSERT INTO Manipel (studienrichtung, jahrgang) VALUES ('B', 2007);
INSERT INTO Manipel (studienrichtung, jahrgang) VALUES ('B', 2008);
INSERT INTO Manipel (studienrichtung, jahrgang) VALUES ('B', 2009);
INSERT INTO Manipel (studienrichtung, jahrgang) VALUES ('B', 2010);
INSERT INTO Manipel (studienrichtung, jahrgang) VALUES ('B', 2011);
INSERT INTO Manipel (studienrichtung, jahrgang) VALUES ('W', 2007);
INSERT INTO Manipel (studienrichtung, jahrgang) VALUES ('W', 2008);
INSERT INTO Manipel (studienrichtung, jahrgang) VALUES ('W', 2009);
INSERT INTO Manipel (studienrichtung, jahrgang) VALUES ('W', 2010);
INSERT INTO Manipel (studienrichtung, jahrgang) VALUES ('W', 2011);

/* Prüfungsfach */
INSERT INTO Pruefungsfach (id, manipelstudienrichtung, manipeljahrgang, titel, beschreibung) VALUES (1, 'I', 2007, 'Mathematik 2', 'Prüfungsfach für das Modul Mathematik 2');
INSERT INTO Pruefungsfach (id, manipelstudienrichtung, manipeljahrgang, titel, beschreibung) VALUES (2, 'I', 2007, 'Softwareproduktion', 'Prüfungsfach für das Modul Softwareproduktion');
INSERT INTO Pruefungsfach (id, manipelstudienrichtung, manipeljahrgang, titel, beschreibung) VALUES (3, 'I', 2007, 'Rechnungswesen I', 'Prüfungsfach für das Modul Rechnungswesen I');
INSERT INTO Pruefungsfach (id, manipelstudienrichtung, manipeljahrgang, titel, beschreibung) VALUES (4, 'I', 2007, 'Rechnungswesen II', 'Prüfungsfach für das Modul Rechnungswesen II');
INSERT INTO Pruefungsfach (id, manipelstudienrichtung, manipeljahrgang, titel, beschreibung) VALUES (5, 'I', 2007, 'Mathematik', 'Prüfungsfach für das Modul Mathematik');
INSERT INTO Pruefungsfach (id, manipelstudienrichtung, manipeljahrgang, titel, beschreibung) VALUES (6, 'I', 2007, 'Algorithmen & Datenstrukturen', 'Prüfungsfach für das Modul Algorithmen & Datenstrukturen');
INSERT INTO Pruefungsfach (id, manipelstudienrichtung, manipeljahrgang, titel, beschreibung) VALUES (7, 'I', 2007, 'Datenbanksysteme', 'Prüfungsfach für das Modul Datenbanksysteme');

/* Person */
INSERT INTO Person (id, vorname, name) VALUES (1, 'Albert', 'Rolf');
INSERT INTO Person (id, vorname, name) VALUES (2, 'Zimmermann', 'Frank');
INSERT INTO Person (id, vorname, name) VALUES (3, 'Kesten', 'Ralf');

/* Dozent */
INSERT INTO Dozent (personid) VALUES (1);
INSERT INTO Dozent (personid) VALUES (2);
INSERT INTO Dozent (personid) VALUES (3);

/* Prüfung */
INSERT INTO Pruefung (id, dozentid, pruefungsfachid, datum) VALUES (1, 1, 1, '2012-06-20');