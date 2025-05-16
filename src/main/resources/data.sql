INSERT INTO department (id, name, status) 
VALUES ('11111111-1111-1111-1111-111111111111', 'Sistemas', 'A');

INSERT INTO department (id, name, status) 
VALUES ('22222222-2222-2222-2222-222222222222', 'Contabilidad', 'A');

INSERT INTO department (id, name, status) 
VALUES ('33333333-3333-3333-3333-333333333333', 'RRHH', 'I');

INSERT INTO department (id, name, status) 
VALUES ('44444444-4444-4444-4444-444444444444', 'People', 'A');

INSERT INTO employees (id, first_name, last_name, age, role, salary, start_date, end_date, status, department_id) 
VALUES ('aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa', 'Luis', 'Pérez', 22, 'Developer', 500.0, '2021-02-10', NULL, 'A', '11111111-1111-1111-1111-111111111111');

INSERT INTO employees (id, first_name, last_name, age, role, salary, start_date, end_date, status, department_id) 
VALUES ('bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb', 'Maria', 'Gonzalez', 25, 'Analista', 600.0, '2020-03-11', NULL, 'A', '11111111-1111-1111-1111-111111111111');

INSERT INTO employees (id, first_name, last_name, age, role, salary, start_date, end_date, status, department_id) 
VALUES ('cccccccc-cccc-cccc-cccc-cccccccccccc', 'Pedro', 'Gómez', 30, 'Contador', 700.0, '2020-03-11', '2024-05-20', 'I', '22222222-2222-2222-2222-222222222222');

INSERT INTO employees (id, first_name, last_name, age, role, salary, start_date, end_date, status, department_id) 
VALUES ('dddddddd-dddd-dddd-dddd-dddddddddddd', 'José', 'López', 20, 'Auxiliar', 400.0, '2022-01-01', NULL, 'A', '22222222-2222-2222-2222-222222222222');
