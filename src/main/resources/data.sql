INSERT INTO department (id, name, status)
VALUES 
    ('a1b2c3d4-e5f6-7890-1234-567890abcdef', 'Sistemas', 'A'),
    ('f9e8d7c6-b5a4-3210-fedc-ba9876543210', 'Contabilidad', 'A'),
    ('01234567-89ab-cdef-0123-456789abcdef', 'RRHH', 'I'), -- Último segmento corregido
    ('bacdef01-2345-6789-abcd-ef0123456789', 'People', 'A');

INSERT INTO employees (id, first_name, last_name, age, role, salary, start_date, end_date, status, department_id)
VALUES 
    ('1a2b3c4d-5e6f-7a8b-9c0d-e1f2a3b4c5d6', 'Luis', 'Pérez', 22, 'Developer', 500.0, '2021-02-10', NULL, 'A', 'a1b2c3d4-e5f6-7890-1234-567890abcdef'),
    ('6d5c4b3a-f2e1-d0c9-b8a7-56d4c3b2a1f0', 'Maria', 'Gonzalez', 25, 'Analista', 600.0, '2020-03-11', NULL, 'A', 'a1b2c3d4-e5f6-7890-1234-567890abcdef'),
    ('f0e9d8c7-b6a5-9432-10fe-dcba98765432', 'Pedro', 'Gómez', 30, 'Contador', 700.0, '2020-04-11', '2024-05-20', 'I', 'f9e8d7c6-b5a4-3210-fedc-ba9876543210'),
    ('23456789-abcd-ef01-2345-6789abcdef01', 'José', 'López', 20, 'Auxiliar', 400.0, '2022-04-01', NULL, 'A', 'f9e8d7c6-b5a4-3210-fedc-ba9876543210'); -- UUID corregido