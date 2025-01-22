ALTER TABLE veterinarios CHANGE nombreCompleto nombre_completo VARCHAR(120) NOT NULL;
ALTER TABLE veterinarios CHANGE numeroTelefonico numero_telefonico VARCHAR(10) NOT NULL;

ALTER TABLE clientes CHANGE nombreCompleto nombre_completo VARCHAR(120) NOT NULL;
ALTER TABLE clientes CHANGE numeroTelefonico numero_telefonico VARCHAR(10) NOT NULL;
