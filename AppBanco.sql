--
-- Host: localhost    Database: dbinfnet
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `TContaBancaria`
--

DROP TABLE IF EXISTS `TContaBancaria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TContaBancaria` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `agencia` varchar(45) NOT NULL,
  `numConta` varchar(45) NOT NULL,
  `saldo` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TContaBancaria`
--

LOCK TABLES `TContaBancaria` WRITE;
/*!40000 ALTER TABLE `TContaBancaria` DISABLE KEYS */;
INSERT INTO `TContaBancaria` VALUES (4,'1','1','1.0'),(5,'1','1','1.0'),(57,'9001','82349-1','549.21'),(58,'8992','45281-3','901.43'),(59,'3214','54218-2','2500.0'),(60,'7732','223445','300.0'),(61,'9982','433921','500.0'),(62,'8718','002251','500.0'),(63,'8192','22315','500.0'),(64,'9123','45688-6','250.0'),(65,'8345','58600-1','8790.21'),(66,'9821-2','44581-2','300.0'),(67,'33','33','333.0'),(68,'0022-1','43912-1','450.0'),(69,'0022-1','89992-1','8753.21'),(70,'0022-1','77122812-33','25894.45');
/*!40000 ALTER TABLE `TContaBancaria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TContaCorrente`
--

DROP TABLE IF EXISTS `TContaCorrente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TContaCorrente` (
  `idContaBancaria` int(11) NOT NULL,
  `contraCheque` float NOT NULL,
  `chequeEspecial` tinyint(4) NOT NULL,
  `valorChequeEspecial` float NOT NULL,
  `financiamento` tinyint(4) NOT NULL,
  `valorFinanciamento` float NOT NULL,
  PRIMARY KEY (`idContaBancaria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TContaCorrente`
--

LOCK TABLES `TContaCorrente` WRITE;
/*!40000 ALTER TABLE `TContaCorrente` DISABLE KEYS */;
INSERT INTO `TContaCorrente` VALUES (67,33333,1,13333.2,1,16666.5),(68,22354.6,1,8941.82,1,11177.3);
/*!40000 ALTER TABLE `TContaCorrente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TContaPoupanca`
--

DROP TABLE IF EXISTS `TContaPoupanca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TContaPoupanca` (
  `idContaBancaria` int(11) NOT NULL,
  `rendimentos` float NOT NULL,
  `resgate` float NOT NULL,
  `depositoInicial` varchar(45) NOT NULL,
  `total` float NOT NULL,
  PRIMARY KEY (`idContaBancaria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TContaPoupanca`
--

LOCK TABLES `TContaPoupanca` WRITE;
/*!40000 ALTER TABLE `TContaPoupanca` DISABLE KEYS */;
INSERT INTO `TContaPoupanca` VALUES (6,333,123,'12/09/1990',0),(23,69009,69009,'6/9/2009',0),(30,2000,43,'01/03/2001',0),(55,98,100,'20/04/2015',0),(58,60.32,85,'01/09/2011',0),(63,6.5,100,'11/02/2002',432.5),(65,6.5,250,'01/03/2007',9111.57),(69,6.5,128.99,'21/09/2018',9193.18);
/*!40000 ALTER TABLE `TContaPoupanca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TDocumentacao`
--

DROP TABLE IF EXISTS `TDocumentacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TDocumentacao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rg` varchar(45) NOT NULL,
  `cpf` varchar(45) NOT NULL,
  `endereco` varchar(45) NOT NULL,
  `cep` varchar(45) NOT NULL,
  `telefone` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TDocumentacao`
--

LOCK TABLES `TDocumentacao` WRITE;
/*!40000 ALTER TABLE `TDocumentacao` DISABLE KEYS */;
INSERT INTO `TDocumentacao` VALUES (15,'12384592-2','901.345.869-90','Rua sei la, 100','43091-290','(99)99999-9999'),(16,'44931092-4','981722567-44','Rua blabla, 111','66924-138','(99)99999-9999'),(17,'45819541-3','589.100.605-90','Rua pupupu, 1, apto 4','89019-493','(39)40194-2881'),(18,'22453908-9','888.201.285-56','Rua ..., 01','49331-409','(22)49582=3019'),(19,'54821992-0','483901338-03','Rua do RosÃ¡rio, 10','89128-282','(72');
/*!40000 ALTER TABLE `TDocumentacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TInvestimento`
--

DROP TABLE IF EXISTS `TInvestimento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TInvestimento` (
  `idContaBancaria` int(11) NOT NULL,
  `tipo` varchar(45) NOT NULL,
  `resgateInv` float NOT NULL,
  `quantiaInicialInv` float NOT NULL,
  `impostoResgateInv` float NOT NULL,
  `taxaRendimentoInv` float NOT NULL,
  `rendimentosInv` float NOT NULL,
  `quantiaFinalInv` float NOT NULL,
  PRIMARY KEY (`idContaBancaria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TInvestimento`
--

LOCK TABLES `TInvestimento` WRITE;
/*!40000 ALTER TABLE `TInvestimento` DISABLE KEYS */;
INSERT INTO `TInvestimento` VALUES (21,'CDB',98,300000,13,8,24000,0),(22,'CDB-DI',88.88,20000,27,9,1800,0),(38,'LFT',8,800000,27,7.5,60000,0),(48,'CDB-DI',2000,150000,27,9,13500,0),(54,'CDB-DI',2600,339000,27,9,30510,0),(59,'LFT',320,50000,27,7.5,3750,0),(61,'CDB-DI',4000,32281.2,27,9,2905.31,30106.5),(70,'CDB-DI',980,20000,27,9,1800,20555.4);
/*!40000 ALTER TABLE `TInvestimento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TTitular`
--

DROP TABLE IF EXISTS `TTitular`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TTitular` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `nomeBanco` varchar(45) NOT NULL,
  `dataAberturaConta` varchar(45) NOT NULL,
  `idDocumentacao` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TTitular`
--

LOCK TABLES `TTitular` WRITE;
/*!40000 ALTER TABLE `TTitular` DISABLE KEYS */;
INSERT INTO `TTitular` VALUES (1,'Paulo','BB','10/03/2019','15'),(3,'Vanessa','Itaú','03/02/2001',NULL),(5,'Pedro','CityBank','09/05/2001',NULL),(9,'Guilhermino','Banco da AmazÃ´nia','31/10/2008','18'),(10,'Matheus','Banco do Brasil','19/11/2003',NULL),(11,'Rebeca','Bradesco','03/03/1993','16');
/*!40000 ALTER TABLE `TTitular` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TTitularCB`
--

DROP TABLE IF EXISTS `TTitularCB`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TTitularCB` (
  `idTitular` int(11) NOT NULL,
  `idContaBancaria` int(11) NOT NULL,
  PRIMARY KEY (`idContaBancaria`,`idTitular`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TTitularCB`
--

LOCK TABLES `TTitularCB` WRITE;
/*!40000 ALTER TABLE `TTitularCB` DISABLE KEYS */;
INSERT INTO `TTitularCB` VALUES (1,65);
/*!40000 ALTER TABLE `TTitularCB` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TUsuario`
--

DROP TABLE IF EXISTS `TUsuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TUsuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TUsuario`
--

LOCK TABLES `TUsuario` WRITE;
/*!40000 ALTER TABLE `TUsuario` DISABLE KEYS */;
INSERT INTO `TUsuario` VALUES (1,'aluno','aluno@aluno.com','a');
/*!40000 ALTER TABLE `TUsuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'dbinfnet'
--

--
-- Dumping routines for database 'dbinfnet'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-03 10:04:39
