-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 31-01-2021 a las 20:48:09
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
-- Base de datos: `damas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `movimiento`
--

CREATE TABLE `movimiento` (
  `idMovimiento` int(11) NOT NULL,
  `columnaOrigen` int(11) NOT NULL,
  `columnaDestino` int(11) NOT NULL,
  `filaOrigen` int(11) NOT NULL,
  `filaDestino` int(11) NOT NULL,
  `idPartida` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `movimiento`
--

INSERT INTO `movimiento` (`idMovimiento`, `columnaOrigen`, `columnaDestino`, `filaOrigen`, `filaDestino`, `idPartida`) VALUES
(1, 5, 4, 5, 4, 19),
(2, 4, 3, 2, 3, 19),
(3, 4, 3, 4, 3, 19),
(4, 5, 4, 1, 2, 19),
(5, 3, 4, 3, 2, 19),
(6, 6, 5, 0, 1, 19),
(7, 4, 5, 2, 1, 19),
(8, 6, 5, 2, 3, 19),
(9, 5, 6, 1, 0, 19),
(10, 5, 4, 5, 4, 20),
(11, 4, 3, 2, 3, 20),
(12, 4, 3, 4, 3, 20),
(13, 5, 4, 1, 2, 20),
(14, 3, 4, 3, 2, 20),
(15, 6, 5, 0, 1, 20),
(16, 4, 5, 2, 1, 20),
(17, 6, 7, 2, 3, 20),
(18, 5, 4, 1, 0, 20),
(19, 3, 4, 5, 4, 22),
(20, 4, 3, 2, 3, 22),
(21, 4, 3, 4, 3, 22),
(22, 5, 4, 1, 2, 22),
(23, 3, 4, 3, 2, 22),
(24, 6, 5, 0, 1, 22),
(25, 4, 5, 2, 1, 22),
(26, 3, 4, 1, 2, 22),
(27, 5, 6, 1, 0, 22),
(28, 3, 4, 5, 4, 25),
(29, 4, 3, 2, 3, 25),
(30, 4, 3, 4, 3, 25),
(31, 5, 4, 1, 2, 25),
(32, 3, 4, 3, 2, 25),
(33, 4, 5, 0, 1, 25),
(34, 4, 3, 2, 1, 25),
(35, 5, 4, 1, 2, 25),
(36, 3, 4, 1, 0, 25),
(37, 3, 4, 5, 4, 26),
(38, 4, 3, 2, 3, 26),
(39, 4, 3, 4, 3, 26),
(40, 2, 1, 2, 3, 26),
(41, 3, 2, 3, 2, 26),
(42, 1, 2, 3, 4, 26),
(43, 2, 3, 2, 1, 26),
(44, 2, 1, 4, 5, 26),
(45, 3, 4, 1, 0, 26),
(46, 3, 4, 5, 4, 27),
(47, 2, 1, 2, 3, 27),
(48, 5, 6, 5, 4, 27),
(49, 3, 2, 1, 2, 27),
(50, 4, 5, 6, 5, 27),
(51, 2, 3, 0, 1, 27),
(52, 2, 3, 6, 5, 27),
(53, 4, 3, 2, 3, 27),
(54, 4, 5, 4, 3, 27),
(55, 5, 4, 1, 2, 27),
(56, 1, 2, 7, 6, 27),
(57, 4, 5, 0, 1, 27),
(58, 5, 4, 7, 6, 27),
(59, 6, 5, 2, 3, 27),
(60, 5, 4, 5, 4, 27),
(61, 5, 6, 3, 4, 27),
(62, 7, 6, 5, 4, 27),
(63, 5, 6, 1, 2, 27),
(64, 4, 5, 6, 5, 27),
(65, 3, 4, 3, 4, 27),
(66, 5, 4, 5, 4, 27),
(67, 6, 5, 0, 1, 27),
(68, 6, 5, 6, 5, 27),
(69, 2, 3, 2, 3, 27),
(70, 7, 6, 7, 6, 27),
(71, 1, 2, 1, 2, 27),
(72, 3, 4, 7, 6, 27),
(73, 0, 1, 0, 1, 27),
(74, 1, 2, 5, 4, 27),
(75, 3, 2, 3, 4, 27),
(76, 0, 1, 6, 5, 27),
(77, 2, 3, 4, 5, 27),
(78, 2, 3, 6, 5, 27),
(79, 1, 2, 3, 4, 27),
(80, 1, 2, 5, 4, 27),
(81, 2, 1, 2, 3, 27),
(82, 2, 1, 4, 3, 27),
(83, 0, 1, 2, 3, 27),
(84, 4, 5, 4, 3, 27),
(85, 1, 0, 3, 4, 27),
(86, 3, 4, 5, 4, 27),
(87, 0, 1, 4, 5, 27),
(88, 5, 4, 3, 2, 27),
(89, 1, 2, 5, 6, 27),
(90, 4, 5, 2, 1, 27),
(91, 2, 3, 6, 7, 27),
(92, 3, 4, 5, 4, 28),
(93, 2, 1, 2, 3, 28),
(94, 4, 5, 4, 3, 28),
(95, 6, 5, 2, 3, 28),
(96, 5, 6, 5, 4, 28),
(97, 5, 6, 3, 4, 28),
(98, 7, 6, 5, 4, 28),
(99, 7, 6, 1, 2, 28),
(100, 6, 7, 6, 5, 28),
(101, 4, 5, 2, 3, 28),
(102, 4, 5, 6, 5, 28),
(103, 5, 6, 3, 4, 28),
(104, 5, 6, 5, 4, 28),
(105, 5, 4, 1, 2, 28),
(106, 6, 7, 4, 3, 28),
(107, 6, 7, 2, 3, 28),
(108, 2, 3, 6, 5, 28),
(109, 4, 5, 2, 3, 28),
(110, 3, 4, 5, 4, 28),
(111, 5, 4, 3, 4, 28),
(112, 1, 2, 5, 4, 28),
(113, 1, 2, 3, 4, 28),
(114, 0, 1, 6, 5, 28),
(115, 2, 1, 4, 5, 28),
(116, 1, 0, 7, 6, 28),
(117, 1, 0, 5, 6, 28),
(118, 3, 2, 7, 6, 28),
(119, 0, 1, 6, 7, 28);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `partida`
--

CREATE TABLE `partida` (
  `idPartida` int(11) NOT NULL,
  `ganador` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `partida`
--

INSERT INTO `partida` (`idPartida`, `ganador`) VALUES
(19, 'O'),
(20, 'O'),
(21, '?'),
(22, 'O'),
(23, '?'),
(24, '?'),
(25, 'O'),
(26, 'O'),
(27, 'X'),
(28, 'X');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `movimiento`
--
ALTER TABLE `movimiento`
  ADD PRIMARY KEY (`idMovimiento`),
  ADD KEY `idPartida` (`idPartida`);

--
-- Indices de la tabla `partida`
--
ALTER TABLE `partida`
  ADD PRIMARY KEY (`idPartida`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `movimiento`
--
ALTER TABLE `movimiento`
  MODIFY `idMovimiento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=120;

--
-- AUTO_INCREMENT de la tabla `partida`
--
ALTER TABLE `partida`
  MODIFY `idPartida` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `movimiento`
--
ALTER TABLE `movimiento`
  ADD CONSTRAINT `movimiento_ibfk_1` FOREIGN KEY (`idPartida`) REFERENCES `partida` (`idPartida`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
