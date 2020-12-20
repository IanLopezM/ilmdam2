-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-12-2020 a las 16:23:44
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `m06_uf2_act1`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnes`
--

CREATE TABLE `alumnes` (
  `nom` varchar(18) NOT NULL,
  `dni` varchar(9) NOT NULL,
  `datanaixament` date NOT NULL,
  `adrecapostal` varchar(70) NOT NULL,
  `sexe` varchar(1) NOT NULL,
  `codipostal` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `poblacions`
--

CREATE TABLE `poblacions` (
  `codipostal` int(5) NOT NULL,
  `poblacio` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumnes`
--
ALTER TABLE `alumnes`
  ADD PRIMARY KEY (`dni`),
  ADD KEY `codipostal` (`codipostal`);

--
-- Indices de la tabla `poblacions`
--
ALTER TABLE `poblacions`
  ADD PRIMARY KEY (`codipostal`),
  ADD KEY `codipostal` (`codipostal`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `alumnes`
--
ALTER TABLE `alumnes`
  ADD CONSTRAINT `alumnes_ibfk_1` FOREIGN KEY (`codipostal`) REFERENCES `poblacions` (`codipostal`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
