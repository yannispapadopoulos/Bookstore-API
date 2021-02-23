-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: bookstore
-- ------------------------------------------------------
-- Server version	8.0.22

-- Table structure for table `author`
--

DROP TABLE IF EXISTS `author`;
CREATE TABLE `author` (
  `id` int NOT NULL,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  `firstdame` varchar(255) DEFAULT NULL,
  `lastdame` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`) /*!80000 INVISIBLE */
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `author`
--

LOCK TABLES `author` WRITE;
INSERT INTO `author` VALUES (1,'nick','manitaras','gges@mail.com','2008-11-11',NULL,NULL),(2,'george','konstantaras','George@yahoo.com','1994-03-02',NULL,NULL),(5,'nick','fefes',NULL,'2020-12-11',NULL,NULL);

UNLOCK TABLES;
