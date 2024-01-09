--
-- Base de datos: `pagoclientes_db`
--
DROP DATABASE IF EXISTS pagoclientes_db;
CREATE DATABASE pagoclientes_db;
USE pagoclientes_db;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `cliente_id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `cliente_nombre` varchar(45) NOT NULL,
  `cliente_apellido` varchar(45) NOT NULL,
  `cliente_email` varchar(65) NOT NULL,
  `cliente_telefono` varchar(10) NOT NULL,
  `cliente_saldo` double(6,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO clientes 
(cliente_id, cliente_nombre, cliente_apellido, cliente_email, cliente_telefono, cliente_saldo) 
VALUES (NULL, 'Fernando', 'Cuatro', 'fernandocuatro@mail.com', '64229837', '250.25'), (NULL, 'Melissa', 'Alexandra', 'melissaalexandra@mail.com', '64229837', '50.10');
