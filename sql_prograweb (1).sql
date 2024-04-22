

CREATE SCHEMA vetpulse;

CREATE USER 'nombre_usuario'@'%' IDENTIFIED BY 'password';

CREATE USER 'nuevo_usuario'@'localhost' IDENTIFIED BY 'admin';
GRANT ALL PRIVILEGES ON *.* TO 'nuevo_usuario'@'localhost' WITH GRANT OPTION;


ALTER TABLE clientes
ADD COLUMN apellido VARCHAR(255) NOT NULL;



GRANT ALL PRIVILEGES ON vetpulse.* TO 'nombre_usuario'@'%';
FLUSH PRIVILEGES;

USE vetpulse;

-- Tabla de Clientes
CREATE TABLE Clientes (
    id_cliente INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    direccion VARCHAR(255),
    telefono VARCHAR(20),
    correo_electronico VARCHAR(100)
) ENGINE=InnoDB DEFAULT CHARACTER SET=utf8mb4;

-- Tabla de Mascotas
CREATE TABLE Mascotas (
    id_mascota INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    especie VARCHAR(100),
    raza VARCHAR(100),
    edad INT,
    id_cliente INT,
    FOREIGN KEY (id_cliente) REFERENCES Clientes(id_cliente)
) ENGINE=InnoDB DEFAULT CHARACTER SET=utf8mb4;

-- Tabla de Visitas
CREATE TABLE Visitas (
    id_visita INT PRIMARY KEY AUTO_INCREMENT,
    fecha_hora DATETIME,
    id_mascota INT,
    razon_visita VARCHAR(255),
    tratamiento_realizado VARCHAR(255),
    FOREIGN KEY (id_mascota) REFERENCES Mascotas(id_mascota)
) ENGINE=InnoDB DEFAULT CHARACTER SET=utf8mb4;

-- Tabla de MedicosVeterinarios
CREATE TABLE MedicosVeterinarios (
    id_veterinario INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    especialidad VARCHAR(100),
    telefono VARCHAR(20),
    correo_electronico VARCHAR(100)
) ENGINE=InnoDB DEFAULT CHARACTER SET=utf8mb4;

-- Tabla de Medicamentos
CREATE TABLE Medicamentos (
    id_medicamento INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    descripcion VARCHAR(255),
    dosificacion VARCHAR(100),
    precio DECIMAL(10, 2)
) ENGINE=InnoDB DEFAULT CHARACTER SET=utf8mb4;

-- Tabla de HistorialesMedicos
CREATE TABLE HistorialesMedicos (
    id_historial INT PRIMARY KEY AUTO_INCREMENT,
    id_mascota INT,
    diagnostico VARCHAR(255),
    tratamiento VARCHAR(255),
    fecha_historial DATETIME,
    FOREIGN KEY (id_mascota) REFERENCES Mascotas(id_mascota)
) ENGINE=InnoDB DEFAULT CHARACTER SET=utf8mb4;

-- INSERT INTO Clientes
INSERT INTO Clientes (nombre, direccion, telefono, correo_electronico) 
VALUES 
    ('Sofía López', 'Calle 456, Colonia Nueva', '5555-5555', 'sofia@example.com'),
    ('Carlos Rodríguez', 'Avenida 789, Barrio Viejo', '5556-6666', 'carlos@example.com'),
    ('Laura Martínez', 'Calle 012, Pueblo Nuevo', '5557-7777', 'laura@example.com'),
    ('Pablo Gómez', 'Avenida 123, Villa Nueva', '5558-8888', 'pablo@example.com'),
    ('Mónica Pérez', 'Calle 345, Ciudad Vieja', '5559-9999', 'monica@example.com');

-- INSERT INTO MedicosVeterinarios
INSERT INTO MedicosVeterinarios (nombre, especialidad, telefono, correo_electronico) 
VALUES 
    ('Dra. González', 'Animales pequeños', '555-111-2222', 'gonzalez@example.com'),
    ('Dr. Ramírez', 'Cirugía veterinaria', '555-333-4444', 'ramirez@example.com'),
    ('Dra. Flores', 'Dermatología veterinaria', '555-555-6666', 'flores@example.com'),
    ('Dr. Torres', 'Oncología veterinaria', '555-777-8888', 'torres@example.com'),
    ('Dra. Soto', 'Cardiología veterinaria', '555-999-0000', 'soto@example.com');

-- INSERT INTO Medicamentos
INSERT INTO Medicamentos (nombre, descripcion, dosificacion, precio) 
VALUES 
    ('Antiparasitario', 'Tratamiento para parásitos intestinales', 'Según peso del animal', 25.00),
    ('Analgésico', 'Alivio del dolor moderado a severo', '1 comprimido cada 12 horas', 15.00),
    ('Antihistamínico', 'Alivio de alergias y picaduras de insectos', '1 comprimido cada 24 horas', 20.00),
    ('Antipirético', 'Reducción de fiebre', 'Según peso del animal', 10.00),
    ('Antiinflamatorio', 'Tratamiento de inflamaciones y dolor', '1 comprimido cada 24 horas', 30.00),
    ('Vitamina C', 'Suplemento para fortalecimiento del sistema inmunológico', 'Según peso del animal', 12.00),
    ('Antibiótico tópico', 'Tratamiento de infecciones de la piel', 'Aplicar sobre la zona afectada', 18.00),
    ('Laxante', 'Alivio del estreñimiento', 'Según peso del animal', 14.00),
    ('Suplemento de calcio', 'Para fortalecimiento de huesos y dientes', '1 comprimido cada 12 horas', 22.00);


-- INSERT INTO Mascotas
INSERT INTO Mascotas (nombre, especie, raza, edad, id_cliente) 
VALUES 
    ('Toby', 'Perro', 'Beagle', 2, 2),
    ('Lucky', 'Perro', 'Pastor Alemán', 3, 3),
    ('Whiskers', 'Gato', 'Persa', 1, 4),
    ('Bella', 'Gato', 'Siamés', 2, 5),
    ('Rocko', 'Perro', 'Bulldog Francés', 4, 1);
    
    
-- INSERT INTO Visitas
INSERT INTO Visitas (fecha_hora, id_mascota, razon_visita, tratamiento_realizado) 
VALUES 
    ('2024-03-11 08:30:00', 1, 'Dolor de estómago', 'Análisis de sangre'),
    ('2024-03-12 10:15:00', 2, 'Control de rutina', 'Vacunación anual'),
    ('2024-03-13 11:45:00', 3, 'Dolor en las patas', 'Radiografía'),
    ('2024-03-14 13:30:00', 4, 'Herida en la cola', 'Limpieza y curación'),
    ('2024-03-15 14:20:00', 5, 'Diarrea', 'Tratamiento para la diarrea'),
    ('2024-03-16 15:10:00', 1, 'Revisión de cirugía', 'Retirada de puntos'),
    ('2024-03-17 16:00:00', 2, 'Vacunación de refuerzo', 'Refuerzo de vacunación'),
    ('2024-03-18 17:00:00', 3, 'Control de peso', 'Plan de alimentación especial');



-- INSERT INTO HistorialesMedicos
INSERT INTO HistorialesMedicos (id_mascota, diagnostico, tratamiento, fecha_historial) 
VALUES 
    (1, 'Dolor de estómago leve', 'Administración de dieta suave', '2024-03-11 09:00:00'),
    (2, 'Control de salud regular', 'Revisión y vacunación', '2024-03-12 10:30:00'),
    (3, 'Fractura en la pata trasera', 'Inmovilización y tratamiento con analgésicos', '2024-03-13 12:00:00'),
    (4, 'Herida superficial en la cola', 'Limpieza y aplicación de vendaje', '2024-03-14 13:45:00'),
    (5, 'Diarrea aguda', 'Reposo y dieta blanda', '2024-03-15 14:35:00'),
    (1, 'Revisión de cirugía previa', 'Retirada de puntos y evaluación', '2024-03-16 15:20:00'),
    (2, 'Reacción alérgica a vacuna', 'Tratamiento antihistamínico', '2024-03-17 16:15:00'),
    (3, 'Control de peso y alimentación', 'Revisión y plan nutricional', '2024-03-18 17:30:00');


ALTER TABLE Clientes
ADD COLUMN activo BOOLEAN DEFAULT TRUE;

ALTER TABLE Mascotas
ADD COLUMN activo BOOLEAN DEFAULT TRUE;

ALTER TABLE Visitas
ADD COLUMN activo BOOLEAN DEFAULT TRUE;

ALTER TABLE MedicosVeterinarios
ADD COLUMN activo BOOLEAN DEFAULT TRUE;

ALTER TABLE Medicamentos
ADD COLUMN activo BOOLEAN DEFAULT TRUE;

ALTER TABLE HistorialesMedicos
ADD COLUMN activo BOOLEAN DEFAULT TRUE;

ALTER TABLE Clientes
ADD COLUMN psword INT DEFAULT 123456;

ALTER TABLE Mascotas
ADD COLUMN ruta_imagen VARCHAR(1024) DEFAULT "https://static.vecteezy.com/system/resources/previews/022/984/235/original/cartoon-dog-transparent-free-png.png";

ALTER TABLE Medicamentos
ADD COLUMN ruta_imagen VARCHAR(1024) DEFAULT "https://www.gaceta.unam.mx/wp-content/uploads/2021/10/211011-aca21-des-f1-antibioticos.jpg";

ALTER TABLE Clientes
ADD COLUMN password INT DEFAULT 123456;

SELECT password FROM usuarios WHERE nombre_usuario = 'sofialopez';

CREATE TABLE usuarios (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre_usuario VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);

INSERT INTO usuarios (nombre_usuario, password) 
VALUES ('sofialopez', '123456');


USE vetpulse;

-- Agregar columna 'apellido' a la tabla 'Clientes'
ALTER TABLE Clientes
ADD COLUMN apellido VARCHAR(255) NOT NULL;

-- Modificar el nombre de usuario en la tabla 'usuarios'
UPDATE usuarios
SET nombre_usuario = 'Sofía López'
WHERE nombre_usuario = 'sofialopez';

-- Modificar la contraseña en la tabla 'usuarios'
UPDATE usuarios
SET password = '123'
WHERE nombre_usuario = 'Sofía López';

-- Consulta para verificar la contraseña de un usuario
SELECT password
FROM usuarios
WHERE nombre_usuario = 'Sofía López';
