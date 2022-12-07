-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: jijijijadb
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `divisa`
--

DROP TABLE IF EXISTS `divisa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `divisa` (
  `idDivisa` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `abreviacion` varchar(3) NOT NULL,
  `simbolo` varchar(10) NOT NULL,
  `precioEnUsd` decimal(6,5) unsigned DEFAULT NULL,
  PRIMARY KEY (`idDivisa`),
  UNIQUE KEY `abreviacion_UNIQUE` (`abreviacion`)
) ENGINE=InnoDB AUTO_INCREMENT=118 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `divisa`
--

LOCK TABLES `divisa` WRITE;
/*!40000 ALTER TABLE `divisa` DISABLE KEYS */;
INSERT INTO `divisa` VALUES (6,'Leke','ALL','Lek',NULL),(7,'Dollars','USD','$',NULL),(8,'Afghanis','AFN','؋',NULL),(9,'Pesos','ARS','$',NULL),(10,'Guilders','AWG','ƒ',NULL),(11,'Dollars','AUD','$',NULL),(12,'New Manats','AZN','ман',NULL),(13,'Dollars','BSD','$',NULL),(14,'Dollars','BBD','$',NULL),(15,'Rubles','BYR','p.',NULL),(16,'Euro','EUR','€',NULL),(17,'Dollars','BZD','BZ$',NULL),(18,'Dollars','BMD','$',NULL),(19,'Bolivianos','BOB','$b',NULL),(20,'Convertible Marka','BAM','KM',NULL),(21,'Pula','BWP','P',NULL),(22,'Leva','BGN','лв',NULL),(23,'Reais','BRL','R$',NULL),(24,'Pounds','GBP','£',NULL),(25,'Dollars','BND','$',NULL),(26,'Riels','KHR','៛',NULL),(27,'Dollars','CAD','$',NULL),(28,'Dollars','KYD','$',NULL),(29,'Pesos','CLP','$',NULL),(30,'Yuan Renminbi','CNY','¥',NULL),(31,'Pesos','COP','$',NULL),(32,'Colón','CRC','₡',NULL),(33,'Kuna','HRK','kn',NULL),(34,'Pesos','CUP','₱',NULL),(35,'Koruny','CZK','Kč',NULL),(36,'Kroner','DKK','kr',NULL),(37,'Pesos','DOP','RD$',NULL),(38,'Dollars','XCD','$',NULL),(39,'Pounds','EGP','£',NULL),(40,'Colones','SVC','$',NULL),(41,'Pounds','FKP','£',NULL),(42,'Dollars','FJD','$',NULL),(43,'Cedis','GHC','¢',NULL),(44,'Pounds','GIP','£',NULL),(45,'Quetzales','GTQ','Q',NULL),(46,'Pounds','GGP','£',NULL),(47,'Dollars','GYD','$',NULL),(48,'Lempiras','HNL','L',NULL),(49,'Dollars','HKD','$',NULL),(50,'Forint','HUF','Ft',NULL),(51,'Kronur','ISK','kr',NULL),(52,'Rupees','INR','Rp',NULL),(53,'Rupiahs','IDR','Rp',NULL),(54,'Rials','IRR','﷼',NULL),(55,'Pounds','IMP','£',NULL),(56,'New Shekels','ILS','₪',NULL),(57,'Dollars','JMD','J$',NULL),(58,'Yen','JPY','¥',NULL),(59,'Pounds','JEP','£',NULL),(60,'Tenge','KZT','лв',NULL),(61,'Won','KPW','₩',NULL),(62,'Won','KRW','₩',NULL),(63,'Soms','KGS','лв',NULL),(64,'Kips','LAK','₭',NULL),(65,'Lati','LVL','Ls',NULL),(66,'Pounds','LBP','£',NULL),(67,'Dollars','LRD','$',NULL),(68,'Switzerland Francs','CHF','CHF',NULL),(69,'Litai','LTL','Lt',NULL),(70,'Denars','MKD','ден',NULL),(71,'Ringgits','MYR','RM',NULL),(72,'Rupees','MUR','₨',NULL),(73,'Pesos','MXN','$',NULL),(74,'Tugriks','MNT','₮',NULL),(75,'Meticais','MZN','MT',NULL),(76,'Dollars','NAD','$',NULL),(77,'Rupees','NPR','₨',NULL),(78,'Guilders','ANG','ƒ',NULL),(79,'Dollars','NZD','$',NULL),(80,'Cordobas','NIO','C$',NULL),(81,'Nairas','NGN','₦',NULL),(82,'Krone','NOK','kr',NULL),(83,'Rials','OMR','﷼',NULL),(84,'Rupees','PKR','₨',NULL),(85,'Balboa','PAB','B/.',NULL),(86,'Guarani','PYG','Gs',NULL),(87,'Nuevos Soles','PEN','S/.',NULL),(88,'Pesos','PHP','Php',NULL),(89,'Zlotych','PLN','zł',NULL),(90,'Rials','QAR','﷼',NULL),(91,'New Lei','RON','lei',NULL),(92,'Rubles','RUB','руб',NULL),(93,'Pounds','SHP','£',NULL),(94,'Riyals','SAR','﷼',NULL),(95,'Dinars','RSD','Дин.',NULL),(96,'Rupees','SCR','₨',NULL),(97,'Dollars','SGD','$',NULL),(98,'Dollars','SBD','$',NULL),(99,'Shillings','SOS','S',NULL),(100,'Rand','ZAR','R',NULL),(101,'Rupees','LKR','₨',NULL),(102,'Kronor','SEK','kr',NULL),(103,'Dollars','SRD','$',NULL),(104,'Pounds','SYP','£',NULL),(105,'New Dollars','TWD','NT$',NULL),(106,'Baht','THB','฿',NULL),(107,'Dollars','TTD','TT$',NULL),(108,'Lira','TRY','TL',NULL),(109,'Liras','TRL','£',NULL),(110,'Dollars','TVD','$',NULL),(111,'Hryvnia','UAH','₴',NULL),(112,'Pesos','UYU','$U',NULL),(113,'Sums','UZS','лв',NULL),(114,'Bolivares Fuertes','VEF','Bs',NULL),(115,'Dong','VND','₫',NULL),(116,'Rials','YER','﷼',NULL),(117,'Zimbabwe Dollars','ZWD','Z$',NULL);
/*!40000 ALTER TABLE `divisa` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-07 13:07:24
