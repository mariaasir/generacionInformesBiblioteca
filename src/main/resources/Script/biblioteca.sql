-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-01-2025 a las 22:47:39
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `biblioteca`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ejemplar`
--

CREATE TABLE `ejemplar` (
  `id` int(11) NOT NULL,
  `isbn` varchar(20) NOT NULL,
  `estado` enum('Disponible','Prestado','Dañado') DEFAULT 'Disponible'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ejemplar`
--

INSERT INTO `ejemplar` (`id`, `isbn`, `estado`) VALUES
(14, '9780747532743', 'Disponible'),
(16, '9780439064873', 'Disponible'),
(17, '9780385490818', 'Disponible'),
(19, '9780439136365', 'Disponible'),
(20, '9780747546245', 'Disponible'),
(21, '9780439358071', 'Prestado'),
(22, '9780545010221', 'Dañado'),
(23, '9780545139700', 'Disponible'),
(25, '9780007117116', 'Disponible'),
(26, '9780261103573', 'Prestado'),
(29, '9780486415871', 'Disponible'),
(32, '9780679783272', 'Prestado'),
(39, '9780099518471', 'Disponible'),
(47, '9780747581083', 'Prestado'),
(48, '9780006479888', 'Disponible'),
(49, '9780553108033', 'Disponible'),
(50, '9780553582024', 'Prestado'),
(55, '9780439023528', 'Disponible'),
(57, '9780307277671', 'Disponible'),
(59, '9780307269997', 'Prestado'),
(64, '9780747532743', 'Disponible'),
(66, '9780439064873', 'Disponible'),
(67, '9780385490818', 'Disponible'),
(69, '9780439136365', 'Disponible'),
(70, '9780747546245', 'Disponible'),
(71, '9780439358071', 'Prestado'),
(72, '9780545010221', 'Dañado'),
(73, '9780545139700', 'Disponible'),
(75, '9780007117116', 'Disponible'),
(76, '9780261103573', 'Prestado'),
(79, '9780486415871', 'Disponible'),
(82, '9780679783272', 'Prestado'),
(89, '9780099518471', 'Disponible'),
(97, '9780747581083', 'Prestado'),
(98, '9780006479888', 'Disponible'),
(99, '9780553108033', 'Disponible'),
(100, '9780553582024', 'Prestado'),
(105, '9780439023528', 'Disponible'),
(107, '9780307277671', 'Disponible'),
(109, '9780307269997', 'Prestado'),
(181, '9781501928035', 'Disponible'),
(182, '9781501928035', 'Prestado'),
(183, '9781501928035', 'Dañado'),
(223, '9780747581083', 'Disponible'),
(224, '9780747581083', 'Prestado'),
(225, '9780747581083', 'Dañado'),
(226, '9780747546245', 'Disponible'),
(227, '9780747546245', 'Prestado'),
(228, '9780747546245', 'Dañado'),
(229, '9780747532743', 'Disponible'),
(230, '9780747532743', 'Prestado'),
(231, '9780747532743', 'Dañado'),
(235, '9780679783272', 'Disponible'),
(236, '9780679783272', 'Prestado'),
(237, '9780679783272', 'Dañado'),
(238, '9780554801477', 'Disponible'),
(239, '9780554801477', 'Prestado'),
(240, '9780554801477', 'Dañado'),
(247, '9780553582024', 'Disponible'),
(248, '9780553582024', 'Prestado'),
(249, '9780553582024', 'Dañado'),
(253, '9780315545965', 'Disponible');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro`
--

CREATE TABLE `libro` (
  `isbn` varchar(20) NOT NULL,
  `titulo` varchar(200) NOT NULL,
  `autor` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `libro`
--

INSERT INTO `libro` (`isbn`, `titulo`, `autor`) VALUES
('9710345339683', 'The Shining', 'Stephen King'),
('9728431058517', 'La Española Inglesa', 'Miguel de Cervantes'),
('9780006479888', 'A Clash of Kings', 'George R.R. Martin'),
('9780007117116', 'The Lord of the Rings', 'J.R.R. Tolkien'),
('9780060578973', 'The Devil and Miss Prym', 'Paulo Coelho'),
('9780061122415', 'The Valkyries', 'Paulo Coelho'),
('9780061122416', 'By the River Piedra I Sat Down and Wept', 'Paulo Coelho'),
('9780061122417', 'Veronika Decides to Die', 'Paulo Coelho'),
('9780061122418', 'The Zahir', 'Paulo Coelho'),
('9780061122419', 'Aleph', 'Paulo Coelho'),
('9780061122420', 'Manuscript Found in Accra', 'Paulo Coelho'),
('9780061122421', 'The Archer', 'Paulo Coelho'),
('9780099518471', '1984', 'George Orwell'),
('9780140447223', 'The Iliad and The Odyssey', 'Homer'),
('9780141183061', 'Keep the Aspidistra Flying', 'George Orwell'),
('9780141190175', 'The Road to Wigan Pier', 'George Orwell'),
('9780156262255', 'Down and Out in Paris and London', 'George Orwell'),
('9780195076267', 'The Odyssey (Oxford World\'s Classics)', 'Homer'),
('9780261103573', 'The Hobbit', 'J.R.R. Tolkien'),
('9780307269997', 'The Girl Who Kicked the Hornet\'s Nest', 'Stieg Larsson'),
('9780307277671', 'The Girl with the Dragon Tattoo', 'Stieg Larsson'),
('9780307454553', 'The Girl Who Lived', 'Stieg Larsson'),
('9780307589894', 'The Girl Who Takes an Eye for an Eye', 'Stieg Larsson'),
('9780307595536', 'The Girl in the Spider\'s Web', 'Stieg Larsson'),
('9780307950486', 'The Girl Who Played with Fire', 'Stieg Larsson'),
('9780315545965', 'La Regenta', 'Leopoldo Alas'),
('9780316228534', 'The Casual Vacancy', 'J.K. Rowling'),
('9780316334707', 'The Cuckoo\'s Calling', 'J.K. Rowling'),
('9780316498683', 'Career of Evil', 'J.K. Rowling'),
('9780345527434', 'A Knight of the Seven Kingdoms', 'George R.R. Martin'),
('9780345527441', 'The Hedge Knight', 'George R.R. Martin'),
('9780345528912', 'The Princess and the Queen', 'George R.R. Martin'),
('9780385490818', 'The Alchemist', 'Paulo Coelho'),
('9780385496819', 'Enduring Love', 'Ian McEwan'),
('9780385496987', 'Amsterdam', 'Ian McEwan'),
('9780385504044', 'Saturday', 'Ian McEwan'),
('9780385536293', 'The Children Act', 'Ian McEwan'),
('9780385537580', 'On Chesil Beach', 'Ian McEwan'),
('9780385549520', 'Nutshell', 'Ian McEwan'),
('9780422295297', 'Atonement', 'Ian McEwan'),
('9780439023511', 'The Hunger Games: Mockingjay', 'Suzanne Collins'),
('9780439023528', 'Catching Fire', 'Suzanne Collins'),
('9780439064873', 'Harry Potter and the Chamber of Secrets', 'J.K. Rowling'),
('9780439136365', 'Harry Potter and the Prisoner of Azkaban', 'J.K. Rowling'),
('9780439358071', 'Harry Potter and the Order of the Phoenix', 'J.K. Rowling'),
('9780451530763', 'Homage to Catalonia', 'George Orwell'),
('9780451531678', 'The Essential Homer', 'Homer'),
('9780452284215', 'Coming Up for Air', 'George Orwell'),
('9780452289517', 'The Collected Essays, Journalism, and Letters of George Orwell', 'George Orwell'),
('9780486415871', 'The Odyssey', 'Homer'),
('9780545010221', 'Harry Potter and the Half-Blood Prince', 'J.K. Rowling'),
('9780545139700', 'Harry Potter and the Deathly Hallows', 'J.K. Rowling'),
('9780545766127', 'The Ballad of Songbirds and Snakes', 'Suzanne Collins'),
('9780553108033', 'A Storm of Swords', 'George R.R. Martin'),
('9780553381689', 'The Winds of Winter', 'George R.R. Martin'),
('9780553562262', 'The Sworn Sword', 'George R.R. Martin'),
('9780553582024', 'A Feast for Crows', 'George R.R. Martin'),
('9780554801477', 'A Dance with Dragons', 'George R.R. Martin'),
('9780674993117', 'The Homeric Hymns', 'Homer'),
('9780679783272', 'Animal Farm', 'George Orwell'),
('9780747532743', 'Harry Potter and the Philosopher\'s Stone', 'J.K. Rowling'),
('9780747546245', 'Harry Potter and the Goblet of Fire', 'J.K. Rowling'),
('9780747581083', 'A Game of Thrones', 'George R.R. Martin'),
('9780747590344', 'The Tales of Beedle the Bard', 'J.K. Rowling'),
('9780872200188', 'The Battle of Frogs and Mice', 'Homer'),
('9780872204360', 'The Shield of Heracles', 'Homer'),
('9781101966331', 'Fire & Blood', 'George R.R. Martin'),
('9781408889036', 'The Silkworm', 'J.K. Rowling'),
('9781408897161', 'The Ickabog', 'J.K. Rowling'),
('9781501928035', 'It', 'Stephen King'),
('9788422632901', 'La Tía Tula', 'Leopoldo Alas'),
('9788430601549', 'Novelas ejemplares', 'Miguel de Cervantes'),
('9788431704974', 'La tía fingida', 'Miguel de Cervantes'),
('9788431705254', 'El licenciado Vidriera', 'Miguel de Cervantes'),
('9788432204853', 'La Galatea - Updated', 'Miguel de Cervantes'),
('9788433968773', 'El corazón helado', 'Almudena Grandes'),
('9788433970806', 'La madre de Frankenstein', 'Almudena Grandes'),
('9788433970850', 'El largo pétalo de mar', 'Almudena Grandes'),
('9788433971383', 'Querida Jane, querida Charlotte', 'Almudena Grandes'),
('9788433972915', 'Los cien sonetos de amor', 'Almudena Grandes'),
('9788433972953', 'Las tres bodas de Manolita', 'Almudena Grandes'),
('9788433973066', 'El final del verano', 'Almudena Grandes'),
('9788433973128', 'Castillos de cartón', 'Almudena Grandes'),
('9788433973271', 'Historia de un abrigo', 'Almudena Grandes'),
('9788433974941', 'Las edades de Lulú', 'Almudena Grandes'),
('9788433975085', 'La voz de su amo', 'Almudena Grandes'),
('9788433975146', 'Los besos en el pan', 'Almudena Grandes'),
('9788433976815', 'Te daré la tierra', 'Almudena Grandes'),
('9788433978017', 'Los pacientes del doctor García', 'Almudena Grandes'),
('9788437603069', 'El romancero gitano y otros poemas', 'Federico García Lorca'),
('9788437603076', 'El maleficio de la mariposa', 'Federico García Lorca'),
('9788437603083', 'La sombrera de tres picos', 'Federico García Lorca'),
('9788437603090', 'La zapatera prodigiosa', 'Federico García Lorca'),
('9788437603106', 'Diván del Tamarit', 'Federico García Lorca'),
('9788437603113', 'Lamentaciones de un primer amor', 'Federico García Lorca'),
('9788437603120', 'El público', 'Federico García Lorca'),
('9788437603137', 'Oda a Salvador Dalí', 'Federico García Lorca'),
('9788437603144', 'Canciones', 'Federico García Lorca'),
('9788437603151', 'Romancero gitano', 'Federico García Lorca'),
('9788437603168', 'Poeta en Nueva York', 'Federico García Lorca'),
('9788437603175', 'La casa de Bernarda Alba', 'Federico García Lorca'),
('9788437603182', 'Yerma', 'Federico García Lorca'),
('9788437603199', 'Bodas de sangre', 'Federico García Lorca'),
('9788437604924', 'Soledades, galerías y otros poemas', 'Antonio Machado'),
('9788437604931', 'Campos de Castilla', 'Antonio Machado'),
('9788437604948', 'Nuevas canciones', 'Antonio Machado'),
('9788437604955', 'Poesías completas', 'Antonio Machado'),
('9788437604962', 'La guerra', 'Antonio Machado'),
('9788437604979', 'La oración del poeta', 'Antonio Machado'),
('9788437604986', 'La vida', 'Antonio Machado'),
('9788437604993', 'Proverbios y cantares', 'Antonio Machado'),
('9788437605006', 'Rimas', 'Antonio Machado'),
('9788437605013', 'El viaje a la muerte', 'Antonio Machado'),
('9788437605020', 'El sentimiento trágico de la vida', 'Antonio Machado'),
('9788437605257', 'El Buscón', 'Francisco de Quevedo'),
('9788437605264', 'Los sueños', 'Francisco de Quevedo'),
('9788437605298', 'Tratados filosóficos', 'Francisco de Quevedo'),
('9788437605387', 'Poesías completas', 'Francisco de Quevedo'),
('9788437605486', 'Visiones y opiniones', 'Francisco de Quevedo'),
('9788437626025', 'El mundo', 'Francisco de Quevedo'),
('9788437646733', 'Los sueños y las visiones', 'Francisco de Quevedo'),
('9788478440796', 'Los enigmas de la corte', 'Francisco de Quevedo'),
('9788483038366', 'Cartas', 'Francisco de Quevedo'),
('9788483075255', 'La caverna', 'Francisco de Quevedo'),
('9788483831415', 'La Numancia', 'Miguel de Cervantes'),
('9788484267025', 'El retablo de las maravillas', 'Miguel de Cervantes'),
('9788484274054', 'El coloquio de los perros', 'Miguel de Cervantes'),
('9788484325689', 'El diablo', 'Francisco de Quevedo'),
('9788486548752', 'La vida del Buscón llamado Don Pablos', 'Francisco de Quevedo'),
('9788491039820', 'La cueva de Salamanca', 'Miguel de Cervantes'),
('9788491040632', 'El viaje del Parnaso', 'Miguel de Cervantes'),
('9788491058507', 'Don Quijote de la Mancha', 'Miguel de Cervantes'),
('9788491058514', 'El ingenioso hidalgo Don Quijote de la Mancha (Vol. 2)', 'Miguel de Cervantes'),
('9788493771107', 'El Espectador', 'Leopoldo Alas'),
('9788493794342', 'Los Trabajos de Persiles y Sigismunda', 'Leopoldo Alas'),
('9788496426332', 'Doña Perfecta', 'Leopoldo Alas'),
('9788499400301', 'Los trabajos de Persiles y Sigismunda', 'Miguel de Cervantes');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamo`
--

CREATE TABLE `prestamo` (
  `id` int(11) NOT NULL,
  `usuario_id` int(11) NOT NULL,
  `ejemplar_id` int(11) NOT NULL,
  `fechaInicio` date NOT NULL,
  `fechaDevolucion` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `prestamo`
--

INSERT INTO `prestamo` (`id`, `usuario_id`, `ejemplar_id`, `fechaInicio`, `fechaDevolucion`) VALUES
(70, 470, 14, '2025-01-18', NULL),
(72, 472, 16, '2025-01-22', '2025-02-10'),
(73, 473, 17, '2025-01-24', NULL),
(75, 475, 19, '2025-01-28', NULL),
(76, 476, 20, '2025-01-30', '2025-02-12'),
(77, 477, 21, '2025-01-02', '2025-01-15'),
(78, 478, 22, '2025-01-05', '2025-01-20'),
(79, 479, 23, '2025-01-08', '2025-01-25'),
(81, 481, 25, '2025-01-22', '2025-02-10'),
(82, 482, 26, '2025-01-24', NULL),
(85, 485, 29, '2025-01-30', NULL),
(88, 488, 32, '2025-01-08', '2025-01-25'),
(95, 495, 39, '2025-01-28', '2025-01-30'),
(103, 503, 47, '2025-01-22', '2025-02-15'),
(104, 504, 48, '2025-01-24', '2025-02-12'),
(105, 505, 49, '2025-01-26', NULL),
(106, 506, 50, '2025-01-28', '2025-01-30'),
(111, 511, 55, '2025-01-15', NULL),
(113, 513, 57, '2025-01-20', '2025-02-10'),
(116, 470, 14, '2025-01-15', '2025-02-10');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `dni` varchar(15) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(255) NOT NULL,
  `tipo` enum('normal','administrador') NOT NULL,
  `penalizacionHasta` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `dni`, `nombre`, `email`, `password`, `tipo`, `penalizacionHasta`) VALUES
(1, '12345678A', 'Juan Pérez', 'juan.perez@example.com', 'password123', 'normal', '2024-12-26'),
(2, '87654321B', 'Ana García', 'ana.garcia@example.com', 'password123', 'normal', '2025-01-25'),
(3, '11223344C', 'Luis López', 'luis.lopez@example.com', 'adminpass123', 'administrador', '2025-02-05'),
(469, '12345678B', 'Carlos Martínez', 'carlos.martinez@example.com', 'password123', 'normal', '2025-02-01'),
(470, '87654322A', 'Lucía Fernández', 'lucia.fernandez@example.com', 'password123', 'normal', '2025-02-05'),
(471, '11223345D', 'Miguel Torres', 'miguel.torres@example.com', 'password123', 'administrador', NULL),
(472, '23456789C', 'Sofía Pérez', 'sofia.perez@example.com', 'password123', 'normal', '2024-12-30'),
(473, '99887766B', 'Andrés López', 'andres.lopez@example.com', 'password123', 'normal', '2025-02-05'),
(474, '22334455D', 'Laura Sánchez', 'laura.sanchez@example.com', 'password123', 'administrador', NULL),
(475, '66778899A', 'Pablo Díaz', 'pablo.diaz@example.com', 'password123', 'normal', '2025-02-05'),
(476, '33445566C', 'Elena Gómez', 'elena.gomez@example.com', 'password123', 'normal', '2025-04-12'),
(477, '55367788B', 'Javier Morales', 'javier.morales@example.com', 'password123', 'administrador', NULL),
(478, '77889900D', 'Natalia Ruiz', 'natalia.ruiz@example.com', 'password123', 'normal', '2025-03-22'),
(479, '44556677C', 'Sergio Ortiz', 'sergio.ortiz@example.com', 'password123', 'normal', '2025-06-30'),
(480, '88990011A', 'Isabel Ramírez', 'isabel.ramirez@example.com', 'password123', 'administrador', '2025-02-05'),
(481, '55443322B', 'Héctor Castro', 'hector.castro@example.com', 'password123', 'normal', '2025-02-14'),
(482, '66778899D', 'María Vargas', 'maria.vargas@example.com', 'password123', 'normal', '2025-02-05'),
(483, '33445577A', 'Raúl Herrera', 'raul.herrera@example.com', 'password123', 'administrador', NULL),
(484, '11223345C', 'Patricia Reyes', 'patricia.reyes@example.com', 'password123', 'normal', '2025-08-15'),
(485, '22334455B', 'Fernando Gil', 'fernando.gil@example.com', 'password123', 'normal', '2025-02-05'),
(486, '77889910C', 'Carmen Aguilar', 'carmen.aguilar@example.com', 'password123', 'administrador', NULL),
(487, '99887766D', 'Emilio León', 'emilio.leon@example.com', 'password123', 'normal', '2025-04-20'),
(488, '44556677B', 'Adriana Méndez', 'adriana.mendez@example.com', 'password123', 'normal', '2025-05-25'),
(489, '51667788C', 'Rafael Molina', 'rafael.molina@example.com', 'password123', 'administrador', '2025-02-05'),
(490, '22334455A', 'Clara Ramos', 'clara.ramos@example.com', 'password123', 'normal', '2025-06-10'),
(491, '88990011D', 'Diego Peña', 'diego.pena@example.com', 'password123', 'normal', '2025-02-18'),
(492, '77889900A', 'Irene Romero', 'irene.romero@example.com', 'password123', 'administrador', NULL),
(493, '33445566B', 'Óscar Marín', 'oscar.marin@example.com', 'password123', 'normal', '2025-08-05'),
(494, '11223344D', 'Silvia Campos', 'silvia.campos@example.com', 'password123', 'normal', '2025-02-05'),
(495, '66778899C', 'Mario Navarro', 'mario.navarro@example.com', 'password123', 'administrador', NULL),
(496, '99887766A', 'Alicia Suárez', 'alicia.suarez@example.com', 'password123', 'normal', '2025-07-25'),
(497, '44556677A', 'Luis Delgado', 'luis.delgado@example.com', 'password123', 'normal', '2025-02-05'),
(498, '22334455C', 'Cristina Vega', 'cristina.vega@example.com', 'password123', 'administrador', NULL),
(499, '77889900B', 'Álvaro Solís', 'alvaro.solis@example.com', 'password123', 'normal', '2025-05-17'),
(500, '33445577D', 'Marta Carrillo', 'marta.carrillo@example.com', 'password123', 'normal', '2025-02-05'),
(501, '55667788A', 'David Campos', 'david.campos@example.com', 'password123', 'administrador', NULL),
(502, '11223344B', 'Lorena Méndez', 'lorena.mendez@example.com', 'password123', 'normal', '2025-01-12'),
(503, '88990011C', 'Víctor Jiménez', 'victor.jimenez@example.com', 'password123', 'normal', '2025-08-18'),
(504, '99887766C', 'Paula Cabrera', 'paula.cabrera@example.com', 'password123', 'administrador', NULL),
(505, '44556677D', 'Manuel Serrano', 'manuel.serrano@example.com', 'password123', 'normal', '2025-02-05'),
(506, '66778899B', 'Ángela Paredes', 'angela.paredes@example.com', 'password123', 'normal', '2025-05-12'),
(507, '33445566D', 'Gonzalo Rivera', 'gonzalo.rivera@example.com', 'password123', 'administrador', NULL),
(508, '77889100D', 'Inés Peña', 'ines.pena@example.com', 'password123', 'normal', '2025-02-05'),
(509, '22314455D', 'Tomás Guzmán', 'tomas.guzman@example.com', 'password123', 'normal', '2025-06-20'),
(510, '55667788B', 'Teresa Blanco', 'teresa.blanco@example.com', 'password123', 'administrador', NULL),
(511, '11223344A', 'Pedro Álvarez', 'pedro.alvarez@example.com', 'password123', 'normal', '2025-02-05'),
(512, '66778299D', 'Marina Cano', 'marina.cano@example.com', 'password123', 'normal', '2025-07-14'),
(513, '77889700C', 'Francisco Gómez', 'francisco.gomez@example.com', 'password123', 'administrador', NULL),
(514, '33445577C', 'Estela Lozano', 'estela.lozano@example.com', 'password123', 'normal', '2025-08-30'),
(515, '49201910A', 'María López Patón', 'maria.l.paton@gmail.com', '1234abcd', 'administrador', NULL),
(516, '49123019C', 'Unai Nieto', 'unainieto@gmail.com', '1234abcd', 'administrador', NULL),
(525, '11111111Z', 'Pepe', 'pepe@gmail.com', '1234', 'administrador', '2025-11-10');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `ejemplar`
--
ALTER TABLE `ejemplar`
  ADD PRIMARY KEY (`id`),
  ADD KEY `isbn` (`isbn`);

--
-- Indices de la tabla `libro`
--
ALTER TABLE `libro`
  ADD PRIMARY KEY (`isbn`);

--
-- Indices de la tabla `prestamo`
--
ALTER TABLE `prestamo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `usuario_id` (`usuario_id`),
  ADD KEY `ejemplar_id` (`ejemplar_id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `dni` (`dni`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `ejemplar`
--
ALTER TABLE `ejemplar`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=255;

--
-- AUTO_INCREMENT de la tabla `prestamo`
--
ALTER TABLE `prestamo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=117;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=526;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `ejemplar`
--
ALTER TABLE `ejemplar`
  ADD CONSTRAINT `ejemplar_ibfk_1` FOREIGN KEY (`isbn`) REFERENCES `libro` (`isbn`) ON DELETE CASCADE;

--
-- Filtros para la tabla `prestamo`
--
ALTER TABLE `prestamo`
  ADD CONSTRAINT `prestamo_ibfk_1` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `prestamo_ibfk_2` FOREIGN KEY (`ejemplar_id`) REFERENCES `ejemplar` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
