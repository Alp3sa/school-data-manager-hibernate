-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 03-06-2018 a las 22:29:10
-- Versión del servidor: 10.1.21-MariaDB
-- Versión de PHP: 7.0.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gestor`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnos`
--

CREATE TABLE `alumnos` (
  `codigo` int(11) NOT NULL,
  `dni` varchar(9) COLLATE latin1_spanish_ci NOT NULL,
  `nombre` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `apellido1` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `apellido2` varchar(11) COLLATE latin1_spanish_ci NOT NULL,
  `codigo_grupo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci ROW_FORMAT=COMPACT;

--
-- Volcado de datos para la tabla `alumnos`
--

INSERT INTO `alumnos` (`codigo`, `dni`, `nombre`, `apellido1`, `apellido2`, `codigo_grupo`) VALUES
(14, '11111114C', 'Albert', 'Pérez', 'Pérez', 8),
(20, '11111113C', 'Albert', 'Pérez', 'Pérez', 8),
(22, '11111119C', 'Albert', 'Pérez', 'Pérez', 8),
(23, '11111122C', 'Albert', 'Pérez', 'Pérez', 8),
(24, '11111111C', 'Albert', 'Pérez', 'Pérez', 8),
(25, '11111110C', 'AlbertE', 'Pérez', 'Pérez', 8);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asignacion_aulas`
--

CREATE TABLE `asignacion_aulas` (
  `codigo` int(11) NOT NULL,
  `codigo_aula` int(11) NOT NULL,
  `codigo_grupo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `asignacion_aulas`
--

INSERT INTO `asignacion_aulas` (`codigo`, `codigo_aula`, `codigo_grupo`) VALUES
(6, 2, 1),
(9, 2, 8),
(13, 2, 8),
(15, 12, 112);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asignaturas`
--

CREATE TABLE `asignaturas` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `codigo_profesor` int(11) NOT NULL,
  `codigo_curso` int(11) NOT NULL,
  `codigo_grupo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `asignaturas`
--

INSERT INTO `asignaturas` (`codigo`, `nombre`, `codigo_profesor`, `codigo_curso`, `codigo_grupo`) VALUES
(1, 'Lengua', 2, 1, 1),
(2, 'Mates', 2, 3, 1),
(3, 'Inglés', 2, 3, 1),
(4, 'Historia', 2, 3, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aulas`
--

CREATE TABLE `aulas` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(50) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `aulas`
--

INSERT INTO `aulas` (`codigo`, `nombre`) VALUES
(2, 'f'),
(4, 'r'),
(12, 'r'),
(13, 'r');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cursos`
--

CREATE TABLE `cursos` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(50) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `cursos`
--

INSERT INTO `cursos` (`codigo`, `nombre`) VALUES
(1, '1º DAM'),
(3, '2º DAM'),
(4, '3º DAM'),
(30, '4º DAM');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `departamentos`
--

CREATE TABLE `departamentos` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `codigo_director` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `departamentos`
--

INSERT INTO `departamentos` (`codigo`, `nombre`, `codigo_director`) VALUES
(1, 'Matemáticas', NULL),
(23, 'Educación Física', 15),
(30, 'Historia', 2),
(45, 'Biología', NULL),
(46, 'Biología2', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `grupos`
--

CREATE TABLE `grupos` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `codigo_curso` int(11) NOT NULL,
  `codigo_tutor` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `grupos`
--

INSERT INTO `grupos` (`codigo`, `nombre`, `codigo_curso`, `codigo_tutor`) VALUES
(1, 'a', 1, 2),
(8, 'Alberto', 1, NULL),
(112, 'Alberto', 1, NULL),
(113, 'Alberto', 1, NULL),
(114, 'Alberto', 1, NULL),
(115, 'Alberto', 1, NULL),
(116, 'Alberto', 1, NULL),
(118, 'Alberto', 1, NULL),
(119, 'Alberto', 1, NULL),
(122, 'Alberto', 1, NULL),
(123, 'Alberto', 1, NULL),
(124, 'Alberto', 1, NULL),
(125, 'Alberto', 1, NULL),
(126, 'Alberto', 1, NULL),
(127, 'Alberto', 1, NULL),
(128, 'Alberto', 1, NULL),
(129, 'Alberto', 1, NULL),
(130, 'Alberto', 1, NULL),
(132, 'aas', 1, 15),
(133, 'assdasd', 1, NULL),
(134, 'a', 1, 2),
(135, 'asd', 1, NULL),
(136, 'ad', 1, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `horarios`
--

CREATE TABLE `horarios` (
  `codigo` int(11) NOT NULL,
  `dia` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `comienzo` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `fin` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `codigo_asignatura` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `horarios`
--

INSERT INTO `horarios` (`codigo`, `dia`, `comienzo`, `fin`, `codigo_asignatura`) VALUES
(5, 'Lunes', '08:00', '11:30', 1),
(7, 'Lunes', '08:00', '11:30', 3),
(22, 'Lunes', '08:00', '11:30', 2),
(23, 'Lunes', '08:00', '11:30', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `matriculas`
--

CREATE TABLE `matriculas` (
  `codigo_curso` int(11) NOT NULL,
  `codigo_alumno` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesores`
--

CREATE TABLE `profesores` (
  `codigo` int(11) NOT NULL,
  `dni` varchar(9) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido1` varchar(50) NOT NULL,
  `apellido2` varchar(50) NOT NULL,
  `codigo_departamento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `profesores`
--

INSERT INTO `profesores` (`codigo`, `dni`, `nombre`, `apellido1`, `apellido2`, `codigo_departamento`) VALUES
(2, '11111111c', 'h', 'j', 'j', 1),
(15, '11111112c', 'Juan', 'Pérez', 'Pérez', 23),
(25, '11111113c', 'Juan', 'Pérez', 'Pérez', 30),
(26, '11111117c', 'Juand', 'Pérez', 'Pérez', 45);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tutorias`
--

CREATE TABLE `tutorias` (
  `codigo` int(11) NOT NULL,
  `dia` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `comienzo` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `fin` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `codigo_profesor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `tutorias`
--

INSERT INTO `tutorias` (`codigo`, `dia`, `comienzo`, `fin`, `codigo_profesor`) VALUES
(10, 'Lunes', '10:00', '12:00', 25),
(14, 'Lunes', '09:00', '11:00', 2),
(16, 'Lunes', '10:00', '14:30', 25);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `codigo` int(11) NOT NULL,
  `usuario` varchar(20) NOT NULL,
  `password` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`codigo`, `usuario`, `password`) VALUES
(1, 'root', 'ry2sVD9dXQcyHpKZm0aigw==');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  ADD PRIMARY KEY (`codigo`),
  ADD UNIQUE KEY `dni` (`dni`),
  ADD KEY `fk_alumnos-codigo_grupo` (`codigo_grupo`);

--
-- Indices de la tabla `asignacion_aulas`
--
ALTER TABLE `asignacion_aulas`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `fk_asignacion_aulas-codigo_grupo` (`codigo_grupo`),
  ADD KEY `fk_asignacion_aulas-codigo_aula` (`codigo_aula`);

--
-- Indices de la tabla `asignaturas`
--
ALTER TABLE `asignaturas`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `fk_asignaturas-codigo_profesor` (`codigo_profesor`);

--
-- Indices de la tabla `aulas`
--
ALTER TABLE `aulas`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `cursos`
--
ALTER TABLE `cursos`
  ADD PRIMARY KEY (`codigo`),
  ADD UNIQUE KEY `nombre` (`nombre`);

--
-- Indices de la tabla `departamentos`
--
ALTER TABLE `departamentos`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `fk_departamentos-codigo_director` (`codigo_director`);

--
-- Indices de la tabla `grupos`
--
ALTER TABLE `grupos`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `fk_grupos-codigo_tutor` (`codigo_tutor`),
  ADD KEY `fk_grupos-codigo_curso` (`codigo_curso`);

--
-- Indices de la tabla `horarios`
--
ALTER TABLE `horarios`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `fk_horarios_codigo_asignatura` (`codigo_asignatura`);

--
-- Indices de la tabla `matriculas`
--
ALTER TABLE `matriculas`
  ADD KEY `fk_matriculas-codigo_alumno` (`codigo_alumno`),
  ADD KEY `fk_matriculas-codigo_asignatura` (`codigo_curso`);

--
-- Indices de la tabla `profesores`
--
ALTER TABLE `profesores`
  ADD PRIMARY KEY (`codigo`),
  ADD UNIQUE KEY `dni` (`dni`),
  ADD KEY `fk_departamentos-codigo_departamento` (`codigo_departamento`);

--
-- Indices de la tabla `tutorias`
--
ALTER TABLE `tutorias`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `fk_tutorias_codigo_profesor` (`codigo_profesor`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`codigo`),
  ADD UNIQUE KEY `usuario` (`usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
--
-- AUTO_INCREMENT de la tabla `asignacion_aulas`
--
ALTER TABLE `asignacion_aulas`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT de la tabla `asignaturas`
--
ALTER TABLE `asignaturas`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `aulas`
--
ALTER TABLE `aulas`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT de la tabla `cursos`
--
ALTER TABLE `cursos`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
--
-- AUTO_INCREMENT de la tabla `departamentos`
--
ALTER TABLE `departamentos`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;
--
-- AUTO_INCREMENT de la tabla `grupos`
--
ALTER TABLE `grupos`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=137;
--
-- AUTO_INCREMENT de la tabla `horarios`
--
ALTER TABLE `horarios`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
--
-- AUTO_INCREMENT de la tabla `profesores`
--
ALTER TABLE `profesores`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;
--
-- AUTO_INCREMENT de la tabla `tutorias`
--
ALTER TABLE `tutorias`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `alumnos`
--
ALTER TABLE `alumnos`
  ADD CONSTRAINT `fk_alumnos-codigo_grupo` FOREIGN KEY (`codigo_grupo`) REFERENCES `grupos` (`codigo`);

--
-- Filtros para la tabla `asignacion_aulas`
--
ALTER TABLE `asignacion_aulas`
  ADD CONSTRAINT `fk_asignacion_aulas-codigo_aula` FOREIGN KEY (`codigo_aula`) REFERENCES `aulas` (`codigo`),
  ADD CONSTRAINT `fk_asignacion_aulas-codigo_grupo` FOREIGN KEY (`codigo_grupo`) REFERENCES `grupos` (`codigo`);

--
-- Filtros para la tabla `asignaturas`
--
ALTER TABLE `asignaturas`
  ADD CONSTRAINT `fk_asignaturas-codigo_profesor` FOREIGN KEY (`codigo_profesor`) REFERENCES `profesores` (`codigo`);

--
-- Filtros para la tabla `departamentos`
--
ALTER TABLE `departamentos`
  ADD CONSTRAINT `fk_departamentos-codigo_director` FOREIGN KEY (`codigo_director`) REFERENCES `profesores` (`codigo`);

--
-- Filtros para la tabla `grupos`
--
ALTER TABLE `grupos`
  ADD CONSTRAINT `fk_grupos-codigo_curso` FOREIGN KEY (`codigo_curso`) REFERENCES `cursos` (`codigo`);

--
-- Filtros para la tabla `horarios`
--
ALTER TABLE `horarios`
  ADD CONSTRAINT `fk_horarios_codigo_asignatura` FOREIGN KEY (`codigo_asignatura`) REFERENCES `asignaturas` (`codigo`);

--
-- Filtros para la tabla `matriculas`
--
ALTER TABLE `matriculas`
  ADD CONSTRAINT `fk_matriculas-codigo_alumno` FOREIGN KEY (`codigo_alumno`) REFERENCES `alumnos` (`codigo`),
  ADD CONSTRAINT `fk_matriculas-codigo_asignatura` FOREIGN KEY (`codigo_curso`) REFERENCES `asignaturas` (`codigo`);

--
-- Filtros para la tabla `profesores`
--
ALTER TABLE `profesores`
  ADD CONSTRAINT `fk_departamentos-codigo_departamento` FOREIGN KEY (`codigo_departamento`) REFERENCES `departamentos` (`codigo`);

--
-- Filtros para la tabla `tutorias`
--
ALTER TABLE `tutorias`
  ADD CONSTRAINT `fk_tutorias_codigo_profesor` FOREIGN KEY (`codigo_profesor`) REFERENCES `profesores` (`codigo`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
