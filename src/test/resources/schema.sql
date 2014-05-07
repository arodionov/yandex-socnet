CREATE TABLE Student(
    id IDENTITY,
    name varchar(30),
    year int
);

CREATE TABLE Groups(
    id IDENTITY,
    name varchar(30)
);

CREATE TABLE student_groups_junction(
  student_id int,
  group_id int,
  CONSTRAINT student_cat_pk PRIMARY KEY (student_id, group_id)  
);