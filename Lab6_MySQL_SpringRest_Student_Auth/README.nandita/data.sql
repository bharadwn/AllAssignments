-- User username/password = Nandita/nandita
INSERT INTO users (username, password, enabled)
  values ('Nandita',
    '$2a$12$i0Sj5JdmExqI8SEJQulkVu4DLdEHxKRu0F6I2bXs0m2K/Zgz7WUFq',
    1);
INSERT INTO users (username, password, enabled)
values ('Pooja',
'$2a$12$9O0IaFGBRYO1EIcblWDtKeN2NJxYTvoipCRqeG5Sg3yvaP6uLOL2S',
1);

INSERT INTO authorities (username, authority)
  values ('Nandita', 'ADMIN');
INSERT INTO authorities (username, authority)
  values ('Pooja', 'USER');

INSERT INTO USERS_ROLES(user_id,role_id) VALUES(1,1);
INSERT INTO USERS_ROLES(user_id,role_id) VALUES(2,2);
  
-- Insert Data into STUDENT Table
INSERT INTO STUDENT(FIRSTNAME,LASTNAME,COURSE,COUNTRY) VALUES('Suresh','Reddy','B.Tech','India');
INSERT INTO STUDENT(FIRSTNAME,LASTNAME,COURSE,COUNTRY) VALUES( 'Murali','Mohan','B.Arch','Canada');
INSERT INTO STUDENT(FIRSTNAME,LASTNAME,COURSE,COUNTRY) VALUES( 'Daniel','Denson','B.Tech','New Zealand');
INSERT INTO STUDENT(FIRSTNAME,LASTNAME,COURSE,COUNTRY) VALUES('Tanya','Gupta','B.com','USA');