-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: vapor
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
  `download` varchar(255) DEFAULT NULL,
  `info` varchar(1000) DEFAULT NULL,
  `genero` varchar(60) NOT NULL,
  `caminhoImagem` varchar(255) DEFAULT NULL,
  `precoDesconto` float DEFAULT NULL,
  PRIMARY KEY (`idGame`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `games`
--

LOCK TABLES `games` WRITE;
/*!40000 ALTER TABLE `games` DISABLE KEYS */;
INSERT INTO `games` VALUES (25,'Contra-Terrorista 2','Valvula Distribuidora','Valvula',19.99,'2023-10-30',_binary '\0','C:\\Vapor\\Arquivos\\Contra-Terrorista 2.txt','Nesse jogo de tiro você pode aliar-se aos terroristas ou aos contra-terroristas.\nCada um com seu próprio desafio e armas especiais.','Tiro','C:\\Vapor\\Game Picture\\Contra-Terrorista 2.jpg',0),(26,'Fortaleza de Times 2','Valvula Distribuidora','Valvula',5.99,'2023-10-30',_binary '\0','C:\\Vapor\\Arquivos\\Fortaleza de Times 2.txt','Mais um dos famosos jogos da Valvula Entretenimento! Overwatch\ncopiou a gente e ainda conseguiu ficar pior!','Tiro','C:\\Vapor\\Game Picture\\Fortaleza de Times 2.jpg',0),(27,'Modulo do Gerson','Valvula Distribuidora','Valvula',59.99,'2023-10-30',_binary '','C:\\Vapor\\Arquivos\\Modulo do Gerson.txt','Divirta-se nesse Sandbox do Gerson, com ou sem seu amigos\n(provavelmente sem amigos, nós sabemos que você não tem).','Sandbox','C:\\Vapor\\Game Picture\\Modulo do Gerson.jpg',19.99),(28,'Nathancraft','JoMang Games','JoMang',249.99,'2023-10-30',_binary '\0','C:\\Vapor\\Arquivos\\Nathancraft.txt','Tem alguém que não conhece esse jogo? Tipo, sério mesmo, é muito\nbom pô, compra ai.','Sandbox','C:\\Vapor\\Game Picture\\Nathancraft.jpg',0);
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
INSERT INTO `possui` VALUES (13,28,'2023-10-30',249.99),(13,25,'2023-10-30',19.99),(13,27,'2023-10-30',19.99);
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
  `profile_picture` varchar(255) DEFAULT NULL,
  `isDev` int DEFAULT NULL,
  PRIMARY KEY (`idUser`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'batatinha123','GersonUsuarios',42,'gerson@gmail.com','C:\\Vapor\\Profile Picture\\GersonUsuarios.png',1),(11,'valvula@games','Valvula',25,'valvula@enterprise.com.us','C:\\Vapor\\Profile Picture\\Valvula.jpeg',1),(12,'jomang2012','JoMang',18,'jomang@games.com.jk','C:\\Vapor\\Profile Picture\\JoMang.jpg',1),(13,'sofisenha','SofiUser',6,'sofi@email.com','C:\\Vapor\\Profile Picture\\SofiUser.png',0);
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

-- Dump completed on 2023-10-30 11:52:08
