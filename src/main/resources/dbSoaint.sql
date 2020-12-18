-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: db
-- Tiempo de generación: 18-12-2020 a las 07:59:25
-- Versión del servidor: 8.0.20
-- Versión de PHP: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `dbSoaint`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Cliente`
--

CREATE TABLE `Cliente` (
  `idCliente` bigint NOT NULL,
  `apellido` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `dni` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nombre` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `telefono` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `Cliente`
--

INSERT INTO `Cliente` (`idCliente`, `apellido`, `dni`, `email`, `nombre`, `telefono`) VALUES
(1, 'galarza', '44441111', 'micorreo@email.com', 'ernesto', '9999999');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `DetalleVenta`
--

CREATE TABLE `DetalleVenta` (
  `idDetalleVenta` bigint NOT NULL,
  `idProducto` bigint DEFAULT NULL,
  `idVenta` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `DetalleVenta`
--

INSERT INTO `DetalleVenta` (`idDetalleVenta`, `idProducto`, `idVenta`) VALUES
(1, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Producto`
--

CREATE TABLE `Producto` (
  `idProducto` bigint NOT NULL,
  `nombre` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `precio` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `Producto`
--

INSERT INTO `Producto` (`idProducto`, `nombre`, `precio`) VALUES
(1, 'televisor', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Venta`
--

CREATE TABLE `Venta` (
  `idVenta` bigint NOT NULL,
  `fecha` datetime(6) DEFAULT NULL,
  `idCliente` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `Venta`
--

INSERT INTO `Venta` (`idVenta`, `fecha`, `idCliente`) VALUES
(1, '2020-12-18 07:28:32.166000', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `Cliente`
--
ALTER TABLE `Cliente`
  ADD PRIMARY KEY (`idCliente`);

--
-- Indices de la tabla `DetalleVenta`
--
ALTER TABLE `DetalleVenta`
  ADD PRIMARY KEY (`idDetalleVenta`),
  ADD KEY `FKt2r9d0l86i3vvj7f62nr3msrd` (`idProducto`),
  ADD KEY `FKn0mebbiemaoe3f3s8n5gniiuw` (`idVenta`);

--
-- Indices de la tabla `Producto`
--
ALTER TABLE `Producto`
  ADD PRIMARY KEY (`idProducto`);

--
-- Indices de la tabla `Venta`
--
ALTER TABLE `Venta`
  ADD PRIMARY KEY (`idVenta`),
  ADD KEY `FKaitd51op0l1bfb9ruro7ul8ru` (`idCliente`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `Cliente`
--
ALTER TABLE `Cliente`
  MODIFY `idCliente` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `DetalleVenta`
--
ALTER TABLE `DetalleVenta`
  MODIFY `idDetalleVenta` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `Producto`
--
ALTER TABLE `Producto`
  MODIFY `idProducto` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `Venta`
--
ALTER TABLE `Venta`
  MODIFY `idVenta` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `DetalleVenta`
--
ALTER TABLE `DetalleVenta`
  ADD CONSTRAINT `FKn0mebbiemaoe3f3s8n5gniiuw` FOREIGN KEY (`idVenta`) REFERENCES `Venta` (`idVenta`),
  ADD CONSTRAINT `FKt2r9d0l86i3vvj7f62nr3msrd` FOREIGN KEY (`idProducto`) REFERENCES `Producto` (`idProducto`);

--
-- Filtros para la tabla `Venta`
--
ALTER TABLE `Venta`
  ADD CONSTRAINT `FKaitd51op0l1bfb9ruro7ul8ru` FOREIGN KEY (`idCliente`) REFERENCES `Cliente` (`idCliente`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
