-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-01-2021 a las 03:32:21
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `parqueaderocolombia`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `parqueadero`
--

CREATE TABLE `parqueadero` (
  `idCliente` int(11) NOT NULL,
  `parCedula` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `parNombre` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `parPlaca` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `parTiempo` int(11) NOT NULL,
  `parCostoTotal` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `parqueadero`
--

INSERT INTO `parqueadero` (`idCliente`, `parCedula`, `parNombre`, `parPlaca`, `parTiempo`, `parCostoTotal`) VALUES
(1, '11', 'oscar', 'KDSA1', 30, 5000),
(4, '134', 'juanes', 'KSA12', 120, 2000),
(5, '451', 'camila', 'XDAD', 120, 0),
(7, '55', 'camilo', 'PPO21', 240, 4000),
(8, '9011', 'Fabian', 'KSP901', 60, 0),
(9, '900', 'Andres', 'POO12', 60, 1000);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `parqueadero`
--
ALTER TABLE `parqueadero`
  ADD PRIMARY KEY (`idCliente`),
  ADD UNIQUE KEY `parPlaca` (`parPlaca`),
  ADD UNIQUE KEY `parCedula` (`parCedula`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `parqueadero`
--
ALTER TABLE `parqueadero`
  MODIFY `idCliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
