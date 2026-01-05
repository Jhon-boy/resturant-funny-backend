-- Datos de prueba para la tabla TROL en H2
-- Este archivo se ejecuta automáticamente al iniciar la aplicación

INSERT INTO TROL (CODIGO, NOMBRE, OBSERVACION, ESTADO, USUARIOINGRESO, USERMODIFICACION, FCREACION, FMODIFICACION) 
VALUES 
    ('ADM', 'Administrador', 'Rol con permisos completos', 'ACT', 'system', NULL, CURRENT_TIMESTAMP, NULL),
    ('USR', 'Usuario', 'Rol para usuarios normales', 'ACT', 'system', NULL, CURRENT_TIMESTAMP, NULL),
    ('GES', 'Gestor', 'Rol para gestores de contenido', 'ACT', 'system', NULL, CURRENT_TIMESTAMP, NULL),
    ('VIS', 'Visitante', 'Rol para visitantes', 'INA', 'system', NULL, CURRENT_TIMESTAMP, NULL);

