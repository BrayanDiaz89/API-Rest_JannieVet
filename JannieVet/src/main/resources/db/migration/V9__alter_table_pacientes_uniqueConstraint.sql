ALTER TABLE pacientes
ADD CONSTRAINT unique_mascota_real
UNIQUE (nombre_paciente, fecha_nacimiento, color, especie, id_cliente_amo);
