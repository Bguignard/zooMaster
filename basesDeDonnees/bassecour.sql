-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Dim 19 Avril 2015 à 17:35
-- Version du serveur: 5.5.41-0ubuntu0.14.04.1
-- Version de PHP: 5.5.9-1ubuntu4.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `bassecour`
--

-- --------------------------------------------------------

--
-- Structure de la table `animal`
--
CREATE DATABASE IF NOT EXISTS `bassecour` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `bassecour`;

DROP TABLE IF EXISTS `animal`;
CREATE TABLE IF NOT EXISTS `animal` (
  `idAnimal` tinyint(4) NOT NULL AUTO_INCREMENT,
  `codeAnimal` varchar(40) DEFAULT NULL,
  `nom` varchar(20) DEFAULT NULL,
  `age` tinyint(4) DEFAULT NULL,
  `poids` float DEFAULT NULL,
  `x` int(3) NOT NULL,
  `y` int(3) NOT NULL,
  PRIMARY KEY (`idAnimal`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Vider la table avant d'insérer `animal`
--

TRUNCATE TABLE `animal`;
--
-- Contenu de la table `animal`
--

INSERT INTO `animal` (`idAnimal`, `codeAnimal`, `nom`, `age`, `poids`, `x`, `y`) VALUES
(1, 'Canard', 'saturnin', 1, 0.2, 700, 100),
(2, 'Poule', 'pepee', 5, 2.2, 750, 350),
(3, 'Canard', 'alfred', 4, 38, 650, 480);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
