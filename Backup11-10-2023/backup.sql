-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: vapor
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `games`
--

DROP TABLE IF EXISTS `games`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `games` (
  `idGame` int NOT NULL AUTO_INCREMENT,
  `nomeGame` varchar(60) NOT NULL,
  `nomeDistribuidora` varchar(60) NOT NULL,
  `nomeDev` varchar(60) NOT NULL,
  `preco` float NOT NULL,
  `lancamento` date DEFAULT NULL,
  `isDesconto` bit(1) DEFAULT NULL,
  `download` blob,
  `info` varchar(1000) DEFAULT NULL,
  `genero` varchar(60) NOT NULL,
  `caminhoImagem` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idGame`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `games`
--

LOCK TABLES `games` WRITE;
/*!40000 ALTER TABLE `games` DISABLE KEYS */;
INSERT INTO `games` VALUES (1,'Ataque Contra-Terrorist','Valvula','Valvula Entretenimento',20,'2003-04-10',_binary '\0',NULL,'Ataque terroristas e seja terrorista nesse jogo de tiro','tiro','C:/Users/italo/eclipse-workspace/vapor/imgs/AtaqueContra-Terrorist.jpeg');
/*!40000 ALTER TABLE `games` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `possui`
--

DROP TABLE IF EXISTS `possui`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `possui` (
  `idUser` int NOT NULL,
  `idGame` int NOT NULL,
  `dataCompra` date DEFAULT NULL,
  `valorCompra` float NOT NULL,
  KEY `userConstraint` (`idUser`),
  KEY `gameConstraint` (`idGame`),
  CONSTRAINT `gameConstraint` FOREIGN KEY (`idGame`) REFERENCES `games` (`idGame`),
  CONSTRAINT `userConstraint` FOREIGN KEY (`idUser`) REFERENCES `users` (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `possui`
--

LOCK TABLES `possui` WRITE;
/*!40000 ALTER TABLE `possui` DISABLE KEYS */;
INSERT INTO `possui` VALUES (1,1,'2023-10-11',20),(7,1,'2023-10-20',20);
/*!40000 ALTER TABLE `possui` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `idUser` int NOT NULL AUTO_INCREMENT,
  `senha` varchar(255) NOT NULL,
  `nickname` varchar(60) NOT NULL,
  `idade` int DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `profile_picture` blob,
  `isDev` bit(1) DEFAULT NULL,
  PRIMARY KEY (`idUser`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'batatinha123','GersonUsuarios',42,'gerson@gmail.com',NULL,_binary '\0'),(4,'12345','GustavoGames',NULL,'gustavo@gmail.com',NULL,NULL),(5,'12345','GersonUsuarios2',NULL,'gerson@gmail.com',NULL,NULL),(6,'senha123','italo',NULL,'italo@gmail.com',NULL,NULL),(7,'pipoca123','pipoca',NULL,'pipoca@gmail.com',NULL,NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-20 17:59:57
