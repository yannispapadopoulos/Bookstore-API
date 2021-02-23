-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: bookstore
-- ------------------------------------------------------
-- Server version	8.0.22

-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `isbn` int unsigned NOT NULL,
  `title` varchar(45) NOT NULL,
  `descr` varchar(60) DEFAULT NULL,
  `visible` tinyint DEFAULT NULL,
  `author_id` int DEFAULT NULL,
  `publisher_id` int DEFAULT NULL,
  `date_creation` date DEFAULT NULL,
  PRIMARY KEY (`isbn`),
  UNIQUE KEY `id_UNIQUE` (`isbn`),
  KEY `fk_authorid_idx` (`author_id`) /*!80000 INVISIBLE */,
  KEY `fk_publisherid_idx` (`publisher_id`) /*!80000 INVISIBLE */,
  CONSTRAINT `fk_author_id` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`),
  CONSTRAINT `fk_publisher_id` FOREIGN KEY (`publisher_id`) REFERENCES `publisher` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;

INSERT INTO `book` VALUES (2,'sacred geometry','Fibonacci in the nature',1,2,1,'2020-11-11'),(3,'LOTR','last war for middle earth',1,2,1,NULL),(25,'DAVINCIfefsfes','DAVINCI KILLS THE DEMONfesafesa',1,NULL,NULL,NULL),(28,'DAVINCIfefsfes','DAVINCI KILLS THE DEMONfesafesa',NULL,NULL,NULL,'2010-11-11'),(29,'DAVINCIfefsfes','DAVINCI KILLS THE DEMONfesafesa',NULL,NULL,NULL,'2010-11-11'),(30,'DAVINCIfefsfes','DAVINCI KILLS THE DEMONfesafesa',NULL,NULL,NULL,'2010-11-11'),(31,'DAVINCIfefsfes','DAVINCI KILLS THE DEMONfesafesa',NULL,NULL,NULL,'2010-11-11'),(32,'Alice in Wonderland','trips',1,NULL,NULL,'2008-11-10'),(33,'Alice in Wonderland','trips',1,NULL,NULL,NULL),(34,'Alice in Wonderland','trips',1,NULL,NULL,'2020-11-11'),(35,'Alice in Wonderland','trips',1,NULL,NULL,'2020-11-11'),(36,'Alice in Wonderland','trips',1,2,1,NULL),(37,'Alice in Wonderland','trips',1,2,1,'2021-10-02'),(54,'harrypotter','magic stories',1,1,2,NULL),(34321,'DAVINCI','bio of davinci',1,2,1,NULL);

UNLOCK TABLES;