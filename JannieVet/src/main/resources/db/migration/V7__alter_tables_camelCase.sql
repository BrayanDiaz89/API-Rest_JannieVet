ALTER TABLE veterinarios
CHANGE COLUMN nombreCompleto nombre_completo VARCHAR(120) NOT NULL;

ALTER TABLE veterinarios
CHANGE COLUMN numeroTelefonico numero_telefonico VARCHAR(10) NOT NULL;

ALTER TABLE clientes
CHANGE COLUMN nombreCompleto nombre_completo VARCHAR(120) NOT NULL;

ALTER TABLE clientes
CHANGE COLUMN numeroTelefonico numero_telefonico VARCHAR(10) NOT NULL;

ALTER TABLE pacientes
CHANGE COLUMN nombrePaciente nombre_paciente VARCHAR(100) NOT NULL;

ALTER TABLE pacientes
CHANGE COLUMN fechaNacimiento fecha_nacimiento datetime NOT NULL;

ALTER TABLE pagos
CHANGE COLUMN tipoDePago tipo_de_pago VARCHAR(25) NOT NULL;

ALTER TABLE consultas
CHANGE COLUMN motivoCancelamiento motivo_cancelamiento VARCHAR(100) NOT NULL;

ALTER TABLE consultas
CHANGE COLUMN motivoConsulta motivo_consulta VARCHAR(500) NOT NULL;






