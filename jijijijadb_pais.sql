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
-- Table structure for table `pais`
--

DROP TABLE IF EXISTS `pais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pais` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(80) NOT NULL,
  `iso` char(2) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `iso_UNIQUE` (`iso`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=241 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pais`
--

LOCK TABLES `pais` WRITE;
/*!40000 ALTER TABLE `pais` DISABLE KEYS */;
INSERT INTO `pais` VALUES (1,'Afganistán','AF'),(2,'Islas Gland','AX'),(3,'Albania','AL'),(4,'Alemania','DE'),(5,'Andorra','AD'),(6,'Angola','AO'),(7,'Anguilla','AI'),(8,'Antártida','AQ'),(9,'Antigua y Barbuda','AG'),(10,'Antillas Holandesas','AN'),(11,'Arabia Saudí','SA'),(12,'Argelia','DZ'),(13,'Argentina','AR'),(14,'Armenia','AM'),(15,'Aruba','AW'),(16,'Australia','AU'),(17,'Austria','AT'),(18,'Azerbaiyán','AZ'),(19,'Bahamas','BS'),(20,'Bahréin','BH'),(21,'Bangladesh','BD'),(22,'Barbados','BB'),(23,'Bielorrusia','BY'),(24,'Bélgica','BE'),(25,'Belice','BZ'),(26,'Benin','BJ'),(27,'Bermudas','BM'),(28,'Bhután','BT'),(29,'Bolivia','BO'),(30,'Bosnia y Herzegovina','BA'),(31,'Botsuana','BW'),(32,'Isla Bouvet','BV'),(33,'Brasil','BR'),(34,'Brunéi','BN'),(35,'Bulgaria','BG'),(36,'Burkina Faso','BF'),(37,'Burundi','BI'),(38,'Cabo Verde','CV'),(39,'Islas Caimán','KY'),(40,'Camboya','KH'),(41,'Camerún','CM'),(42,'Canadá','CA'),(43,'República Centroafricana','CF'),(44,'Chad','TD'),(45,'República Checa','CZ'),(46,'Chile','CL'),(47,'China','CN'),(48,'Chipre','CY'),(49,'Isla de Navidad','CX'),(50,'Ciudad del Vaticano','VA'),(51,'Islas Cocos','CC'),(52,'Colombia','CO'),(53,'Comoras','KM'),(54,'República Democrática del Congo','CD'),(55,'Congo','CG'),(56,'Islas Cook','CK'),(57,'Corea del Norte','KP'),(58,'Corea del Sur','KR'),(59,'Costa de Marfil','CI'),(60,'Costa Rica','CR'),(61,'Croacia','HR'),(62,'Cuba','CU'),(63,'Dinamarca','DK'),(64,'Dominica','DM'),(65,'República Dominicana','DO'),(66,'Ecuador','EC'),(67,'Egipto','EG'),(68,'El Salvador','SV'),(69,'Emiratos Árabes Unidos','AE'),(70,'Eritrea','ER'),(71,'Eslovaquia','SK'),(72,'Eslovenia','SI'),(73,'España','ES'),(74,'Islas ultramarinas de Estados Unidos','UM'),(75,'Estados Unidos','US'),(76,'Estonia','EE'),(77,'Etiopía','ET'),(78,'Islas Feroe','FO'),(79,'Filipinas','PH'),(80,'Finlandia','FI'),(81,'Fiyi','FJ'),(82,'Francia','FR'),(83,'Gabón','GA'),(84,'Gambia','GM'),(85,'Georgia','GE'),(86,'Islas Georgias del Sur y Sandwich del Sur','GS'),(87,'Ghana','GH'),(88,'Gibraltar','GI'),(89,'Granada','GD'),(90,'Grecia','GR'),(91,'Groenlandia','GL'),(92,'Guadalupe','GP'),(93,'Guam','GU'),(94,'Guatemala','GT'),(95,'Guayana Francesa','GF'),(96,'Guinea','GN'),(97,'Guinea Ecuatorial','GQ'),(98,'Guinea-Bissau','GW'),(99,'Guyana','GY'),(100,'Haití','HT'),(101,'Islas Heard y McDonald','HM'),(102,'Honduras','HN'),(103,'Hong Kong','HK'),(104,'Hungría','HU'),(105,'India','IN'),(106,'Indonesia','ID'),(107,'Irán','IR'),(108,'Iraq','IQ'),(109,'Irlanda','IE'),(110,'Islandia','IS'),(111,'Israel','IL'),(112,'Italia','IT'),(113,'Jamaica','JM'),(114,'Japón','JP'),(115,'Jordania','JO'),(116,'Kazajstán','KZ'),(117,'Kenia','KE'),(118,'Kirguistán','KG'),(119,'Kiribati','KI'),(120,'Kuwait','KW'),(121,'Laos','LA'),(122,'Lesotho','LS'),(123,'Letonia','LV'),(124,'Líbano','LB'),(125,'Liberia','LR'),(126,'Libia','LY'),(127,'Liechtenstein','LI'),(128,'Lituania','LT'),(129,'Luxemburgo','LU'),(130,'Macao','MO'),(131,'ARY Macedonia','MK'),(132,'Madagascar','MG'),(133,'Malasia','MY'),(134,'Malawi','MW'),(135,'Maldivas','MV'),(136,'Malí','ML'),(137,'Malta','MT'),(138,'Islas Malvinas','FK'),(139,'Islas Marianas del Norte','MP'),(140,'Marruecos','MA'),(141,'Islas Marshall','MH'),(142,'Martinica','MQ'),(143,'Mauricio','MU'),(144,'Mauritania','MR'),(145,'Mayotte','YT'),(146,'México','MX'),(147,'Micronesia','FM'),(148,'Moldavia','MD'),(149,'Mónaco','MC'),(150,'Mongolia','MN'),(151,'Montserrat','MS'),(152,'Mozambique','MZ'),(153,'Myanmar','MM'),(154,'Namibia','NA'),(155,'Nauru','NR'),(156,'Nepal','NP'),(157,'Nicaragua','NI'),(158,'Níger','NE'),(159,'Nigeria','NG'),(160,'Niue','NU'),(161,'Isla Norfolk','NF'),(162,'Noruega','NO'),(163,'Nueva Caledonia','NC'),(164,'Nueva Zelanda','NZ'),(165,'Omán','OM'),(166,'Países Bajos','NL'),(167,'Pakistán','PK'),(168,'Palau','PW'),(169,'Palestina','PS'),(170,'Panamá','PA'),(171,'Papúa Nueva Guinea','PG'),(172,'Paraguay','PY'),(173,'Perú','PE'),(174,'Islas Pitcairn','PN'),(175,'Polinesia Francesa','PF'),(176,'Polonia','PL'),(177,'Portugal','PT'),(178,'Puerto Rico','PR'),(179,'Qatar','QA'),(180,'Reino Unido','GB'),(181,'Reunión','RE'),(182,'Ruanda','RW'),(183,'Rumania','RO'),(184,'Rusia','RU'),(185,'Sahara Occidental','EH'),(186,'Islas Salomón','SB'),(187,'Samoa','WS'),(188,'Samoa Americana','AS'),(189,'San Cristóbal y Nevis','KN'),(190,'San Marino','SM'),(191,'San Pedro y Miquelón','PM'),(192,'San Vicente y las Granadinas','VC'),(193,'Santa Helena','SH'),(194,'Santa Lucía','LC'),(195,'Santo Tomé y Príncipe','ST'),(196,'Senegal','SN'),(197,'Serbia y Montenegro','CS'),(198,'Seychelles','SC'),(199,'Sierra Leona','SL'),(200,'Singapur','SG'),(201,'Siria','SY'),(202,'Somalia','SO'),(203,'Sri Lanka','LK'),(204,'Suazilandia','SZ'),(205,'Sudáfrica','ZA'),(206,'Sudán','SD'),(207,'Suecia','SE'),(208,'Suiza','CH'),(209,'Surinam','SR'),(210,'Svalbard y Jan Mayen','SJ'),(211,'Tailandia','TH'),(212,'Taiwán','TW'),(213,'Tanzania','TZ'),(214,'Tayikistán','TJ'),(215,'Territorio Británico del Océano Índico','IO'),(216,'Territorios Australes Franceses','TF'),(217,'Timor Oriental','TL'),(218,'Togo','TG'),(219,'Tokelau','TK'),(220,'Tonga','TO'),(221,'Trinidad y Tobago','TT'),(222,'Túnez','TN'),(223,'Islas Turcas y Caicos','TC'),(224,'Turkmenistán','TM'),(225,'Turquía','TR'),(226,'Tuvalu','TV'),(227,'Ucrania','UA'),(228,'Uganda','UG'),(229,'Uruguay','UY'),(230,'Uzbekistán','UZ'),(231,'Vanuatu','VU'),(232,'Venezuela','VE'),(233,'Vietnam','VN'),(234,'Islas Vírgenes Británicas','VG'),(235,'Islas Vírgenes de los Estados Unidos','VI'),(236,'Wallis y Futuna','WF'),(237,'Yemen','YE'),(238,'Yibuti','DJ'),(239,'Zambia','ZM'),(240,'Zimbabue','ZW');
/*!40000 ALTER TABLE `pais` ENABLE KEYS */;
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
