CREATE SEQUENCE candidate_sq;
CREATE TABLE candidate (
	id	integer PRIMARY KEY DEFAULT nextval('candidate_sq'),
	name 	varchar(255),
	address	varchar(255),
	phone	varchar(12),
	email	varchar(255)
);

CREATE SEQUENCE organisation_sq;
CREATE TABLE organisation (
	id	integer PRIMARY KEY DEFAULT nextval('organisation_sq'),
	name 	varchar(255),
	address	varchar(255),
	phone	varchar(12),
	fax	varchar(255),
	email	varchar(255)
);

CREATE SEQUENCE skill_sq;
CREATE TABLE skill (
	id	integer PRIMARY KEY DEFAULT nextval('skill_sq'),
	name 	varchar(255)
);

CREATE SEQUENCE employment_sq;
CREATE TABLE employment (
	id		integer PRIMARY KEY DEFAULT nextval('employment_sq'),
	candidate_id	foriegn_key REFERENCES candidate,
	organisation_id	foriegn_key REFERENCES organisation,
	jobtitle	varchar(255),
	start_date	datetime,
	end_date	datetime
);

CREATE SEQUENCE employment_skill_sq;
CREATE TABLE employment_skill (
	id		integer PRIMARY KEY DEFAULT nextval('employment_skill_sq'),
	employment_id	foriegn_key REFERENCES employment,
	skill_id	foriegn_key REFERENCES skill
	
);

--Insert test data
--Insert Candadidates
INSERT INTO candidate (name, address, phone, email) VALUES ('Jeffrey Williams', '59/1 Braybrooke St Bruce 2567', '0246478710', 'jeff@text.com');
INSERT INTO candidate (name, address, phone, email) VALUES ('Liegh Gordon', '1/2 The Grassmarket Edinburgh EH1 2GQ', '0746478710', 'liegh@text.com');
INSERT INTO candidate (name, address, phone, email) VALUES ('Richard Friend', '1/2 London Ave London EH1 2GQ', '0746471111', 'richard@text.com');
--Insert Organisations
INSERT INTO organisation (name, address, phone, fax, email) VALUES ('IBM', '1 IBM Street Canberra 2567', '0298765433', '0298765401', 'enquires@ibm.com.au' );
INSERT INTO organisation (name, address, phone, fax, email) VALUES ('Sun Microsystems', '1 Sun Street Canberra 2567', '0268765433', '0268765401', 'enquires@sun.com.au' );
INSERT INTO organisation (name, address, phone, fax, email) VALUES ('Canberra University', '1 haydron Drive Canberra 2567', '0268765502', '0268765501', 'enquires@sun.com.au' );
--Insert Skills
INSERT INTO skill (name) VALUES ('Java');
INSERT INTO skill (name) VALUES ('J2EE');
INSERT INTO skill (name) VALUES ('Hibernate');
INSERT INTO skill (name) VALUES ('Spring Core');
INSERT INTO skill (name) VALUES ('EJB');
INSERT INTO skill (name) VALUES ('AJAX');
INSERT INTO skill (name) VALUES ('Web Services');
INSERT INTO skill (name) VALUES ('Flex');
INSERT INTO skill (name) VALUES ('Project Management');
--Insert employments
INSERT INTO employment (candidate_id, organisation_id, jobtitle, start_date, end_date) VALUES (1,1,'Junior Developer', '2003-08-01', '2004-09-01');
INSERT INTO employment (candidate_id, organisation_id, jobtitle, start_date, end_date) VALUES (1,2,'Developer', '2004-10-01', '2005-09-01');
INSERT INTO employment (candidate_id, organisation_id, jobtitle, start_date, end_date) VALUES (1,3,'Senior Developer', '2005-11-01', '2007-12-12');
INSERT INTO employment (candidate_id, organisation_id, jobtitle, start_date, end_date) VALUES (2,1,'Team Lead', '2003-08-01', '2007-09-01');
INSERT INTO employment (candidate_id, organisation_id, jobtitle, start_date, end_date) VALUES (2,3,'Systems Architect', '2007-11-01', null);
INSERT INTO employment (candidate_id, organisation_id, jobtitle, start_date, end_date) VALUES (3,3,'Senior Developer', '2001-08-01', '2007-12-23');
INSERT INTO employment (candidate_id, organisation_id, jobtitle, start_date, end_date) VALUES (3,2,'Project Lead', '2008-11-01', null);
--Insert employment_skills
INSERT INTO employment_skill (skill_id, employment_id) VALUES (1,1);
INSERT INTO employment_skill (skill_id, employment_id) VALUES (1,2);
INSERT INTO employment_skill (skill_id, employment_id) VALUES (1,3);
INSERT INTO employment_skill (skill_id, employment_id) VALUES (1,5);
INSERT INTO employment_skill (skill_id, employment_id) VALUES (1,8);
INSERT INTO employment_skill (skill_id, employment_id) VALUES (2,2);
INSERT INTO employment_skill (skill_id, employment_id) VALUES (2,4);
INSERT INTO employment_skill (skill_id, employment_id) VALUES (2,6);
INSERT INTO employment_skill (skill_id, employment_id) VALUES (2,8);
INSERT INTO employment_skill (skill_id, employment_id) VALUES (3,1);
INSERT INTO employment_skill (skill_id, employment_id) VALUES (3,6);
INSERT INTO employment_skill (skill_id, employment_id) VALUES (3,3);
INSERT INTO employment_skill (skill_id, employment_id) VALUES (4,8);
INSERT INTO employment_skill (skill_id, employment_id) VALUES (4,5);
INSERT INTO employment_skill (skill_id, employment_id) VALUES (4,4);
INSERT INTO employment_skill (skill_id, employment_id) VALUES (4,3);
INSERT INTO employment_skill (skill_id, employment_id) VALUES (4,2);
INSERT INTO employment_skill (skill_id, employment_id) VALUES (4,8);
INSERT INTO employment_skill (skill_id, employment_id) VALUES (4,5);
INSERT INTO employment_skill (skill_id, employment_id) VALUES (5,2);
INSERT INTO employment_skill (skill_id, employment_id) VALUES (5,1);
INSERT INTO employment_skill (skill_id, employment_id) VALUES (5,5);
INSERT INTO employment_skill (skill_id, employment_id) VALUES (6,8);
INSERT INTO employment_skill (skill_id, employment_id) VALUES (6,7);
INSERT INTO employment_skill (skill_id, employment_id) VALUES (6,6);
INSERT INTO employment_skill (skill_id, employment_id) VALUES (6,5);
INSERT INTO employment_skill (skill_id, employment_id) VALUES (7,2);
INSERT INTO employment_skill (skill_id, employment_id) VALUES (7,4);
INSERT INTO employment_skill (skill_id, employment_id) VALUES (7,1);


