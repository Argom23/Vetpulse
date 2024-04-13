DROP SCHEMA IF EXISTS vetpulse;
DROP USER IF EXISTS 'nombre_usuario'@'%';

CREATE SCHEMA vetpulse;

CREATE USER 'nombre_usuario'@'%' IDENTIFIED BY 'password';

GRANT ALL PRIVILEGES ON vetpulse.* TO 'nombre_usuario'@'%';
FLUSH PRIVILEGES;

USE vetpulse;

-- Tabla de Clientes
CREATE TABLE Clientes (
    id_cliente INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    apellido VARCHAR(100),
    direccion VARCHAR(255),
    telefono VARCHAR(20),
    correo_electronico VARCHAR(100),
    activo BOOLEAN,
    username VARCHAR(50),
    password VARCHAR(100),
    ruta_imagen VARCHAR(1024)
) ENGINE=InnoDB DEFAULT CHARACTER SET=utf8mb4;

-- Tabla de Mascotas
CREATE TABLE Mascotas (
    id_mascota INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    especie VARCHAR(100),
    raza VARCHAR(100),
    edad INT,
    id_cliente INT,
    activo BOOLEAN,
    ruta_imagen VARCHAR(1024)
) ENGINE=InnoDB DEFAULT CHARACTER SET=utf8mb4;

-- Tabla de Visitas
CREATE TABLE Visitas (
    id_visita INT PRIMARY KEY AUTO_INCREMENT,
    fecha_hora DATETIME,
    id_mascota INT,
    razon_visita VARCHAR(255),
    tratamiento_realizado VARCHAR(255),
    activo BOOLEAN
) ENGINE=InnoDB DEFAULT CHARACTER SET=utf8mb4;

-- Tabla de MedicosVeterinarios
CREATE TABLE MedicosVeterinarios (
    id_veterinario INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    especialidad VARCHAR(100),
    telefono VARCHAR(20),
    correo_electronico VARCHAR(100),
    activo BOOLEAN
) ENGINE=InnoDB DEFAULT CHARACTER SET=utf8mb4;

-- Tabla de Medicamentos
CREATE TABLE Medicamentos (
    id_medicamento INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    descripcion VARCHAR(255),
    dosificacion VARCHAR(100),
    precio DECIMAL(10, 2),
    activo BOOLEAN,
    ruta_imagen VARCHAR(1024)
) ENGINE=InnoDB DEFAULT CHARACTER SET=utf8mb4;

-- Tabla de HistorialesMedicos
CREATE TABLE HistorialesMedicos (
    id_historial INT PRIMARY KEY AUTO_INCREMENT,
    id_mascota INT,
    diagnostico VARCHAR(255),
    tratamiento VARCHAR(255),
    fecha_historial DATETIME,
    activo BOOLEAN
) ENGINE=InnoDB DEFAULT CHARACTER SET=utf8mb4;

CREATE TABLE Rol (
    id_rol INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    id_cliente INT,
    FOREIGN KEY (id_cliente) REFERENCES Clientes(id_cliente)
) ENGINE=InnoDB DEFAULT CHARACTER SET=utf8mb4;

-- INSERT INTO Clientes
INSERT INTO Clientes (nombre, apellido, direccion, telefono, correo_electronico, activo, username,password, ruta_imagen) 
VALUES 
    ('Sofía', 'López', 'Calle 456, Colonia Nueva', '5555-5555', 'sofia@example.com', TRUE, 'sofialopez', '$2a$10$YHbdK97RlbpjSkkpOKPIhOW82nhdzUEq2oxgZcjgugM0Gs7YvFJsG', 'https://thumbs.dreamstime.com/b/icono-de-la-silueta-del-esquema-vector-persona-masculina-96275622.jpg'),
    ('Carlos', 'Rodríguez', 'Avenida 789, Barrio Viejo', '5556-6666', 'carlos@example.com', TRUE, 'carlosrodriguez', '$2a$10$YHbdK97RlbpjSkkpOKPIhOW82nhdzUEq2oxgZcjgugM0Gs7YvFJsG', 'https://thumbs.dreamstime.com/b/icono-de-la-silueta-del-esquema-vector-persona-masculina-96275622.jpg'),
    ('Laura', 'Martínez', 'Calle 012, Pueblo Nuevo', '5557-7777', 'laura@example.com', TRUE, 'lauramartinez', '$2a$10$YHbdK97RlbpjSkkpOKPIhOW82nhdzUEq2oxgZcjgugM0Gs7YvFJsG', 'https://thumbs.dreamstime.com/b/icono-de-la-silueta-del-esquema-vector-persona-masculina-96275622.jpg'),
    ('Pablo', 'Gómez', 'Avenida 123, Villa Nueva', '5558-8888', 'pablo@example.com', TRUE, 'pablogomez', '$2a$10$YHbdK97RlbpjSkkpOKPIhOW82nhdzUEq2oxgZcjgugM0Gs7YvFJsG', 'https://thumbs.dreamstime.com/b/icono-de-la-silueta-del-esquema-vector-persona-masculina-96275622.jpg'),
    ('Mónica', 'Pérez', 'Calle 345, Ciudad Vieja', '5559-9999', 'monica@example.com', TRUE, 'monicaperez', '$2a$10$YHbdK97RlbpjSkkpOKPIhOW82nhdzUEq2oxgZcjgugM0Gs7YvFJsG', 'https://thumbs.dreamstime.com/b/icono-de-la-silueta-del-esquema-vector-persona-masculina-96275622.jpg');

-- INSERT INTO Mascotas
INSERT INTO Mascotas (nombre, especie, raza, edad, id_cliente, activo, ruta_imagen) 
VALUES 
    ('Toby', 'Perro', 'Beagle', 2, 2, TRUE, 'https://static.vecteezy.com/system/resources/previews/022/984/235/original/cartoon-dog-transparent-free-png.png'),
    ('Lucky', 'Perro', 'Pastor Alemán', 3, 3, TRUE, 'https://static.vecteezy.com/system/resources/previews/022/984/235/original/cartoon-dog-transparent-free-png.png'),
    ('Whiskers', 'Gato', 'Persa', 1, 4, TRUE, 'https://static.vecteezy.com/system/resources/previews/022/984/235/original/cartoon-dog-transparent-free-png.png'),
    ('Bella', 'Gato', 'Siamés', 2, 5, TRUE, 'https://static.vecteezy.com/system/resources/previews/022/984/235/original/cartoon-dog-transparent-free-png.png'),
    ('Rocko', 'Perro', 'Bulldog Francés', 4, 1, TRUE, 'https://static.vecteezy.com/system/resources/previews/022/984/235/original/cartoon-dog-transparent-free-png.png');
    
-- INSERT INTO MedicosVeterinarios
INSERT INTO MedicosVeterinarios (nombre, especialidad, telefono, correo_electronico, activo) 
VALUES 
    ('Dra. González', 'Animales pequeños', '555-111-2222', 'gonzalez@example.com', TRUE),
    ('Dr. Ramírez', 'Cirugía veterinaria', '555-333-4444', 'ramirez@example.com', TRUE),
    ('Dra. Flores', 'Dermatología veterinaria', '555-555-6666', 'flores@example.com', TRUE),
    ('Dr. Torres', 'Oncología veterinaria', '555-777-8888', 'torres@example.com', TRUE),
    ('Dra. Soto', 'Cardiología veterinaria', '555-999-0000', 'soto@example.com', TRUE);

-- INSERT INTO Medicamentos
INSERT INTO Medicamentos (nombre, descripcion, dosificacion, precio, activo, ruta_imagen) 
VALUES 
    ('Antiparasitario', 'Tratamiento para parásitos intestinales', 'Según peso del animal', 25.00, TRUE, 'https://www.gaceta.unam.mx/wp-content/uploads/2021/10/211011-aca21-des-f1-antibioticos.jpg'),
    ('Analgésico', 'Alivio del dolor moderado a severo', '1 comprimido cada 12 horas', 15.00, TRUE, 'https://www.gaceta.unam.mx/wp-content/uploads/2021/10/211011-aca21-des-f1-antibioticos.jpg'),
    ('Antihistamínico', 'Alivio de alergias y picaduras de insectos', '1 comprimido cada 24 horas', 20.00, TRUE, 'https://www.gaceta.unam.mx/wp-content/uploads/2021/10/211011-aca21-des-f1-antibioticos.jpg'),
    ('Antipirético', 'Reducción de fiebre', 'Según peso del animal', 10.00, TRUE, 'https://www.gaceta.unam.mx/wp-content/uploads/2021/10/211011-aca21-des-f1-antibioticos.jpg'),
    ('Antiinflamatorio', 'Tratamiento de inflamaciones y dolor', '1 comprimido cada 24 horas', 30.00, TRUE, 'https://www.gaceta.unam.mx/wp-content/uploads/2021/10/211011-aca21-des-f1-antibioticos.jpg'),
    ('Vitamina C', 'Suplemento para fortalecimiento del sistema inmunológico', 'Según peso del animal', 12.00, TRUE, 'https://www.gaceta.unam.mx/wp-content/uploads/2021/10/211011-aca21-des-f1-antibioticos.jpg'),
    ('Antibiótico tópico', 'Tratamiento de infecciones de la piel', 'Aplicar sobre la zona afectada', 18.00, TRUE, 'https://www.gaceta.unam.mx/wp-content/uploads/2021/10/211011-aca21-des-f1-antibioticos.jpg'),
    ('Laxante', 'Alivio del estreñimiento', 'Según peso del animal', 14.00, TRUE, 'https://www.gaceta.unam.mx/wp-content/uploads/2021/10/211011-aca21-des-f1-antibioticos.jpg'),
    ('Suplemento de calcio', 'Para fortalecimiento de huesos y dientes', '1 comprimido cada 12 horas', 22.00, TRUE, 'https://www.gaceta.unam.mx/wp-content/uploads/2021/10/211011-aca21-des-f1-antibioticos.jpg');

-- INSERT INTO Visitas
INSERT INTO Visitas (fecha_hora, id_mascota, razon_visita, tratamiento_realizado, activo) 
VALUES 
    ('2024-03-11 08:30:00', 1, 'Dolor de estómago', 'Análisis de sangre', TRUE),
    ('2024-03-12 10:15:00', 2, 'Control de rutina', 'Vacunación anual', TRUE),
    ('2024-03-13 11:45:00', 3, 'Dolor en las patas', 'Radiografía', TRUE),
    ('2024-03-14 13:30:00', 4, 'Herida en la cola', 'Limpieza y curación', TRUE),
    ('2024-03-15 14:20:00', 5, 'Diarrea', 'Tratamiento para la diarrea', TRUE),
    ('2024-03-16 15:10:00', 1, 'Revisión de cirugía', 'Retirada de puntos', TRUE),
    ('2024-03-17 16:00:00', 2, 'Vacunación de refuerzo', 'Refuerzo de vacunación', TRUE),
    ('2024-03-18 17:00:00', 3, 'Control de peso', 'Plan de alimentación especial', TRUE);

-- INSERT INTO HistorialesMedicos
INSERT INTO HistorialesMedicos (id_mascota, diagnostico, tratamiento, fecha_historial, activo) 
VALUES 
    (1, 'Dolor de estómago leve', 'Administración de dieta suave', '2024-03-11 09:00:00', TRUE),
    (2, 'Control de salud regular', 'Revisión y vacunación', '2024-03-12 10:30:00', TRUE),
    (3, 'Fractura en la pata trasera', 'Inmovilización y tratamiento con analgésicos', '2024-03-13 12:00:00', TRUE),
    (4, 'Herida superficial en la cola', 'Limpieza y aplicación de vendaje', '2024-03-14 13:45:00', TRUE),
    (5, 'Diarrea aguda', 'Reposo y dieta blanda', '2024-03-15 14:35:00', TRUE),
    (1, 'Revisión de cirugía previa', 'Retirada de puntos y evaluación', '2024-03-16 15:20:00', TRUE),
    (2, 'Reacción alérgica a vacuna', 'Tratamiento antihistamínico', '2024-03-17 16:15:00', TRUE),
    (3, 'Control de peso y alimentación', 'Revisión y plan nutricional', '2024-03-18 17:30:00', TRUE);

-- INSERT INTO Rol para todos los clientes
INSERT INTO Rol (nombre, id_cliente) 
VALUES 
    ('ROLE_ADMIN', 1),
    ('ROLE_VENDEDOR', 1),
    ('ROLE_USER', 1),
    ('ROLE_ADMIN', 2),
    ('ROLE_VENDEDOR', 2),
    ('ROLE_USER', 2),
    ('ROLE_VENDEDOR', 3),
    ('ROLE_USER', 3),
    ('ROLE_USER', 4),
    ('ROLE_USER', 5);
