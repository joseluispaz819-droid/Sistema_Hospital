create database bd_hospital;
--  roles
CREATE TABLE usu_rol(
    usu_rol_id INT NOT NULL PRIMARY KEY,
    usu_rol_nombre VARCHAR(50)
);

-- tabla de usuarios
CREATE TABLE usuario(
    usu_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    usu_rol_id INT NOT NULL,
    usu_nombre VARCHAR(50) NOT NULL,
    usu_login VARCHAR(50) NOT NULL,
    usu_password VARCHAR(50) NOT NULL,
    FOREIGN KEY (usu_rol_id) REFERENCES usu_rol(usu_rol_id)
);

-- especialidades 
CREATE TABLE med_especialidades (
    med_esp_id INT PRIMARY KEY AUTO_INCREMENT,
    med_esp_nombre VARCHAR(50) NOT NULL,
    med_esp_descripcion VARCHAR(255)
);

--  medicos 
CREATE TABLE medico (
    med_id INT PRIMARY KEY AUTO_INCREMENT,
    med_nombre VARCHAR(50) NOT NULL,
    med_apellido VARCHAR(50) NOT NULL,
    med_dni VARCHAR(15) UNIQUE NOT NULL,
    med_especialidad_id INT NOT NULL,
    med_contacto VARCHAR(50),
    med_cupo_diario INT DEFAULT 0,
    FOREIGN KEY (med_especialidad_id) REFERENCES med_especialidades(med_esp_id)
);

--  obras sociales
CREATE TABLE obras_sociales (
    obra_id INT PRIMARY KEY AUTO_INCREMENT,
    obra_nombre VARCHAR(50) NOT NULL
);

--  pacientes 
CREATE TABLE pacientes (
    pac_id INT PRIMARY KEY AUTO_INCREMENT,
    pac_dni VARCHAR(15) UNIQUE NOT NULL,
    pac_nombre VARCHAR(50) NOT NULL,
    pac_apellido VARCHAR(50) NOT NULL,
    pac_fecha_nac DATE NOT NULL,
    pac_obra_social_id INT,
    pac_contacto VARCHAR(50),
    FOREIGN KEY (pac_obra_social_id) REFERENCES obras_sociales(obra_id)
);

--  enfermeros
CREATE TABLE enfermeros (
    enf_id INT PRIMARY KEY AUTO_INCREMENT,
    enf_nombre VARCHAR(50) NOT NULL,
    enf_apellido VARCHAR(50) NOT NULL,
    enf_dni VARCHAR(15) UNIQUE NOT NULL,
    enf_contacto VARCHAR(50)
);

-- turnos
CREATE TABLE turnos (
    turno_id INT PRIMARY KEY AUTO_INCREMENT,
    turno_paciente_id INT NOT NULL,
    turno_medico_id INT NOT NULL,
    turno_fecha DATE NOT NULL,
    turno_hora TIME NOT NULL,
    turno_estado VARCHAR(20) DEFAULT 'pendiente',
    turno_operador_id INT,
    FOREIGN KEY (turno_paciente_id) REFERENCES pacientes(pac_id),
    FOREIGN KEY (turno_medico_id) REFERENCES medico(med_id),
    FOREIGN KEY (turno_operador_id) REFERENCES usuario(usu_id)
);

-- historia clinica
CREATE TABLE historia_clinica (
    hc_id INT PRIMARY KEY AUTO_INCREMENT,
    hc_paciente_id INT NOT NULL,
    hc_fecha DATETIME NOT NULL,
    hc_observaciones TEXT,
    hc_diagnostico TEXT,
    FOREIGN KEY (hc_paciente_id) REFERENCES pacientes(pac_id)
);

-- prescripciones
CREATE TABLE prescripciones (
    presc_id INT PRIMARY KEY AUTO_INCREMENT,
    presc_turno_id INT NOT NULL,
    presc_medicamento VARCHAR(100) NOT NULL,
    presc_dosis VARCHAR(50),
    presc_indicaciones TEXT,
    FOREIGN KEY (presc_turno_id) REFERENCES turnos(turno_id)
);
--  guardiaas
CREATE TABLE guardias (
    guardia_id INT PRIMARY KEY AUTO_INCREMENT,
    guardia_enfermero_id INT NOT NULL,
    guardia_fecha DATE NOT NULL,
    guardia_turno VARCHAR(20) NOT NULL,   
    FOREIGN KEY (guardia_enfermero_id) REFERENCES enfermeros(enf_id)
);