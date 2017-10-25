-- phpMyAdmin SQL Dump
-- version 3.3.2deb1
-- http://www.phpmyadmin.net
--
-- Serveur: localhost
-- Généré le : Ven 06 Janvier 2012 à 20:32
-- Version du serveur: 5.1.41
-- Version de PHP: 5.3.2-1ubuntu4.11

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `ferme`
--
CREATE DATABASE IF NOT EXISTS `ferme` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `ferme`;
-- --------------------------------------------------------

--
-- Structure de la table `animal`
--

DROP TABLE IF EXISTS `animal`;
CREATE TABLE IF NOT EXISTS `animal` (
  `idAnimal` tinyint(4) NOT NULL AUTO_INCREMENT,
  `codeAnimal` varchar(20) DEFAULT NULL,
  `nom` varchar(20) DEFAULT NULL,
  `age` tinyint(4) DEFAULT NULL,
  `poids` float DEFAULT NULL,
  `x` int(3) NOT NULL,
  `y` int(3) NOT NULL,
  PRIMARY KEY (`idAnimal`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `animal`
--

INSERT INTO `animal` (`idAnimal`, `codeAnimal`, `nom`, `age`, `poids`, `x`, `y`) VALUES
(1, 'Chien', 'medor', 1, 0.2, 300, 200),
(2, 'Chat', 'felix', 5, 2.2, 250, 400),
(3, 'Chat', 'tom', 5, 2.2, 250, 400),
(4, 'Renard', 'goupil', 4, 38, 500, 480);
