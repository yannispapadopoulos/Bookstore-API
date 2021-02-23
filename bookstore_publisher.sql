-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: bookstore
-- ------------------------------------------------------
-- Server version	8.0.22

--
-- Table structure for table `publisher`
--

DROP TABLE IF EXISTS `publisher`;
CREATE TABLE `publisher` (
  `id` int NOT NULL,
  `name` varchar(45) NOT NULL,
  `telephone` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


--
-- Dumping data for table `publisher`
--

LOCK TABLES `publisher` WRITE;

INSERT INTO `publisher` VALUES (1,'ALEX','543054654','MAROUSI'),(2,'BD','5454322','GLUFADA'),(11,'kwstas','213','irakleio'),(12,'NICK','4325432','');

UNLOCK TABLES;