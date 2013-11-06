-- phpMyAdmin SQL Dump
-- version 4.0.6deb1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 06-11-2013 a las 10:11:38
-- Versión del servidor: 5.5.34-0ubuntu0.13.10.1
-- Versión de PHP: 5.5.3-1ubuntu2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `biblioteca`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `autor`
--

CREATE TABLE IF NOT EXISTS `autor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `apellidos` varchar(45) DEFAULT NULL,
  `pais` varchar(45) DEFAULT NULL,
  `fechaNacimiento` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ejemplar`
--

CREATE TABLE IF NOT EXISTS `ejemplar` (
  `id` int(11) NOT NULL,
  `localizacion` varchar(45) DEFAULT NULL,
  `anno` int(4) DEFAULT NULL,
  `estado` int(1) DEFAULT NULL,
  `libros_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ejemplares_libros1` (`libros_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro`
--

CREATE TABLE IF NOT EXISTS `libro` (
  `id` int(11) NOT NULL,
  `isbn` varchar(45) DEFAULT NULL,
  `titulo` varchar(45) DEFAULT NULL,
  `editorial` varchar(45) DEFAULT NULL,
  `numeropag` int(11) DEFAULT NULL,
  `autor_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_libro_autor1_idx` (`autor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `multa`
--

CREATE TABLE IF NOT EXISTS `multa` (
  `id` int(11) NOT NULL,
  `monto` double(10,2) DEFAULT NULL,
  `diasTarde` int(2) DEFAULT NULL,
  `prestamos_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_multas_prestamos1` (`prestamos_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamo`
--

CREATE TABLE IF NOT EXISTS `prestamo` (
  `id` int(11) NOT NULL,
  `montoMulta` double(7,2) DEFAULT NULL,
  `fechaInicio` date DEFAULT NULL,
  `fechaFin` date DEFAULT NULL,
  `fechaDevolucion` date DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `publicacion_id` int(11) DEFAULT NULL,
  `ejemplar_id` int(11) DEFAULT NULL,
  `usuario_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_prestamos_publicacion1` (`publicacion_id`),
  KEY `fk_prestamo_ejemplar1` (`ejemplar_id`),
  KEY `fk_prestamo_usuario1_idx` (`usuario_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `publicacion`
--

CREATE TABLE IF NOT EXISTS `publicacion` (
  `id` int(11) NOT NULL,
  `titulo` varchar(45) DEFAULT NULL,
  `subtitulo` varchar(45) DEFAULT NULL,
  `editor` varchar(45) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `fechaEdicion` date DEFAULT NULL,
  `tipopublicacion_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_publicacion_tipopublicacion1` (`tipopublicacion_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

CREATE TABLE IF NOT EXISTS `reserva` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fechaInicio` date DEFAULT NULL,
  `fechaCaducidad` date DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `usuario_id` int(11) NOT NULL,
  `ejemplar_id` int(11) DEFAULT NULL,
  `publicacion_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_reserva_usuario1_idx` (`usuario_id`),
  KEY `fk_reserva_ejemplar1_idx` (`ejemplar_id`),
  KEY `fk_reserva_publicacion1_idx` (`publicacion_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipopublicacion`
--

CREATE TABLE IF NOT EXISTS `tipopublicacion` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipousuario`
--

CREATE TABLE IF NOT EXISTS `tipousuario` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(11) NOT NULL,
  `dni` varchar(8) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `nombres` varchar(45) DEFAULT NULL,
  `apellidos` varchar(45) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `tipousuario_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `dni_UNIQUE` (`dni`),
  KEY `fk_usuario_tipousuario1_idx` (`tipousuario_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `ejemplar`
--
ALTER TABLE `ejemplar`
  ADD CONSTRAINT `fk_ejemplares_libros1` FOREIGN KEY (`libros_id`) REFERENCES `libro` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `libro`
--
ALTER TABLE `libro`
  ADD CONSTRAINT `fk_libro_autor1` FOREIGN KEY (`autor_id`) REFERENCES `autor` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `multa`
--
ALTER TABLE `multa`
  ADD CONSTRAINT `fk_multas_prestamos1` FOREIGN KEY (`prestamos_id`) REFERENCES `prestamo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `prestamo`
--
ALTER TABLE `prestamo`
  ADD CONSTRAINT `fk_prestamos_publicacion1` FOREIGN KEY (`publicacion_id`) REFERENCES `publicacion` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_prestamo_ejemplar1` FOREIGN KEY (`ejemplar_id`) REFERENCES `ejemplar` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_prestamo_usuario1` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `publicacion`
--
ALTER TABLE `publicacion`
  ADD CONSTRAINT `fk_publicacion_tipopublicacion1` FOREIGN KEY (`tipopublicacion_id`) REFERENCES `tipopublicacion` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `fk_reserva_usuario1` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_reserva_ejemplar1` FOREIGN KEY (`ejemplar_id`) REFERENCES `ejemplar` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_reserva_publicacion1` FOREIGN KEY (`publicacion_id`) REFERENCES `publicacion` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `fk_usuario_tipousuario1` FOREIGN KEY (`tipousuario_id`) REFERENCES `tipousuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
