CREATE TABLE people(
    id serial PRIMARY KEY,
    name VARCHAR(100),
    CPF VARCHAR(11)
);

CREATE TABLE dependent(
    id serial PRIMARY KEY,
    name VARCHAR(11),
    birthDate DATE
);

CREATE TABLE people_dependent(
   id_people INT,
   id_dependent INT,
   FOREIGN KEY (id_people) REFERENCES people(id) ON DELETE CASCADE,
   FOREIGN KEY (id_dependent) REFERENCES dependent(id) ON DELETE CASCADE,
   PRIMARY KEY(id_people,id_dependent)
);

