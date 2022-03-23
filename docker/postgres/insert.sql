INSERT INTO people (name, cpf) VALUES ('Patrick','11111111111');
INSERT INTO people (name, cpf) VALUES ('Allyson','22222222222');
INSERT INTO people (name, cpf) VALUES ('Ricardo','33333333333');

INSERT INTO dependent (name, dataDeNascimento) VALUES ('José','1995-03-12');
INSERT INTO dependent (name, dataDeNascimento) VALUES ('Maria','2000-17-19');
INSERT INTO dependent (name, dataDeNascimento) VALUES ('Antônio','1997-07-18');

INSERT INTO pessoa_dependente (id_people,id_dependent) VALUES (1, 1);
INSERT INTO pessoa_dependente (id_people,id_dependent) VALUES (2, 2);
INSERT INTO pessoa_dependente (id_people,id_dependent) VALUES (3, 3);