-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: bookstore
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (2,'sacred geometry','Fibonacci in the nature',1,2,1,'2020-11-11'),(3,'LOTR','last war for middle earth',1,2,1,NULL),(25,'DAVINCIfefsfes','DAVINCI KILLS THE DEMONfesafesa',1,NULL,NULL,NULL),(28,'DAVINCIfefsfes','DAVINCI KILLS THE DEMONfesafesa',NULL,NULL,NULL,'2010-11-11'),(29,'DAVINCIfefsfes','DAVINCI KILLS THE DEMONfesafesa',NULL,NULL,NULL,'2010-11-11'),(30,'DAVINCIfefsfes','DAVINCI KILLS THE DEMONfesafesa',NULL,NULL,NULL,'2010-11-11'),(31,'DAVINCIfefsfes','DAVINCI KILLS THE DEMONfesafesa',NULL,NULL,NULL,'2010-11-11'),(32,'Alice in Wonderland','trips',1,NULL,NULL,'2008-11-10'),(33,'Alice in Wonderland','trips',1,NULL,NULL,NULL),(34,'Alice in Wonderland','trips',1,NULL,NULL,'2020-11-11'),(35,'Alice in Wonderland','trips',1,NULL,NULL,'2020-11-11'),(36,'Alice in Wonderland','trips',1,2,1,NULL),(37,'Alice in Wonderland','trips',1,2,1,'2021-10-02'),(54,'harrypotter','magic stories',1,1,2,NULL),(34321,'DAVINCI','bio of davinci',1,2,1,NULL);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-22 19:33:23
