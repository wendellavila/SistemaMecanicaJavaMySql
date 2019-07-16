-- MariaDB dump 10.17  Distrib 10.4.6-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: mecanica
-- ------------------------------------------------------
-- Server version	10.4.6-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `atendimento`
--

DROP TABLE IF EXISTS `atendimento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `atendimento` (
  `id_atendimento` int(11) NOT NULL,
  `horario_atendimento` varchar(5) DEFAULT '09:00',
  `data_atendimento` date DEFAULT '2019-07-14',
  `descricao_atendimento` varchar(45) DEFAULT 'Sem descricao',
  `id_oficina` int(11) DEFAULT NULL,
  `placa_carro` varchar(7) NOT NULL,
  PRIMARY KEY (`id_atendimento`),
  KEY `fk_atendimento_1_idx` (`id_oficina`),
  KEY `fk_atendimento_2` (`placa_carro`),
  CONSTRAINT `fk_atendimento_1` FOREIGN KEY (`id_oficina`) REFERENCES `oficina` (`id_oficina`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `fk_atendimento_2` FOREIGN KEY (`placa_carro`) REFERENCES `carro` (`placa`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atendimento`
--

LOCK TABLES `atendimento` WRITE;
/*!40000 ALTER TABLE `atendimento` DISABLE KEYS */;
INSERT INTO `atendimento` VALUES (1,'09:40','2019-07-14','Problema no tanque de combustivel',3,'HDS9594'),(2,'14:30','2019-07-12','Problema na parte eletrica',1,'JPF7109'),(3,'14:00','2019-06-29','Suspensao apresentando defeito',2,'MUO1886'),(4,'11:20','2019-07-16','Batida Frontal',2,'NEI6379'),(5,'15:45','2019-07-16','Instalacao de Alarme e som',1,'HTK4152'),(6,'16:15','2019-07-14','Freio apresentando defeito',2,'MUO1886'),(7,'17:00','2019-07-15','Direcao instavel',1,'JYI6472'),(8,'13:00','2019-07-10','Radiador apresentando defeito',1,'MQI8117');
/*!40000 ALTER TABLE `atendimento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `atendimento_servico`
--

DROP TABLE IF EXISTS `atendimento_servico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `atendimento_servico` (
  `id_atendimento` int(11) NOT NULL,
  `id_servico` int(11) NOT NULL,
  PRIMARY KEY (`id_atendimento`,`id_servico`),
  KEY `fk_atendimento_servico_2_idx` (`id_servico`),
  CONSTRAINT `fk_atendimento_servico_2` FOREIGN KEY (`id_servico`) REFERENCES `servico` (`id_servico`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atendimento_servico`
--

LOCK TABLES `atendimento_servico` WRITE;
/*!40000 ALTER TABLE `atendimento_servico` DISABLE KEYS */;
INSERT INTO `atendimento_servico` VALUES (2,2),(2,3),(3,4),(4,5),(4,6),(4,7),(4,14),(5,8),(5,9),(6,10),(7,11),(7,12),(8,13);
/*!40000 ALTER TABLE `atendimento_servico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carro`
--

DROP TABLE IF EXISTS `carro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `carro` (
  `chassi` varchar(17) DEFAULT NULL,
  `ano` varchar(4) DEFAULT NULL,
  `placa` varchar(7) NOT NULL,
  `modelo` varchar(45) DEFAULT NULL,
  `marca` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`placa`),
  UNIQUE KEY `placa_UNIQUE` (`placa`),
  UNIQUE KEY `chassi_UNIQUE` (`chassi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carro`
--

LOCK TABLES `carro` WRITE;
/*!40000 ALTER TABLE `carro` DISABLE KEYS */;
INSERT INTO `carro` VALUES ('23563634654843655','2016','AKB4600','Focus','Ford'),('26746774623453673','2017','HDS9594','Cruze','Chevrolet'),('57586453665754675','2011','HTK4152','HB20','Hyundai'),('46758454242523234','2010','JPF7109','Gol','Volkswagen'),('44658595763453433','2012','JYI6472','Civic','Honda'),('75235345324435345','2008','MQI8117','Palio','Fiat'),('34373453453635366','2018','MUO1886','Toro','Fiat'),('54754645635364343','2015','NEI6379','Voyage','Volkswagen');
/*!40000 ALTER TABLE `carro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `cpf_cliente` varchar(11) NOT NULL,
  `nome_cliente` varchar(45) DEFAULT NULL,
  `rua_cliente` varchar(45) DEFAULT NULL,
  `bairro_cliente` varchar(45) DEFAULT NULL,
  `num_casa_cliente` varchar(45) DEFAULT NULL,
  `cidade_cliente` varchar(45) DEFAULT NULL,
  `estado_cliente` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cpf_cliente`),
  UNIQUE KEY `cpf_cliente_UNIQUE` (`cpf_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES ('24873840694','Carlos Moreira','Rua Professor João','Jardim Aeroporto','259','Alfenas','MG'),('31533298009','Henrique Santos','Avenida Perimetral','Vila da Folha','2140','Sao Paulo','SP'),('37217380049','Pedro Fonseca','Rua Minas Gerais','Residencial das Flores','120','Alfenas','MG'),('40558820093','Maria Neves','Rua do Comércio','Centro','148','Sao Paulo','SP'),('58887839000','Arthur Ramos','Rua 15 de Novembro','Jardim Planalto','345','Areado','MG'),('79042343001','João Souza','Avenida Principal','Centro','1134','Alfenas','MG'),('80135375010','Joana Aparecida','Praca 7 de Setembro','Parque do Sol','17','Alfenas','MG');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente_carros`
--

DROP TABLE IF EXISTS `cliente_carros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente_carros` (
  `cpf_cliente` varchar(11) NOT NULL,
  `placa_carro` varchar(7) NOT NULL,
  PRIMARY KEY (`cpf_cliente`,`placa_carro`),
  KEY `fk_cliente_carros_2` (`placa_carro`),
  CONSTRAINT `fk_cliente_carros_1` FOREIGN KEY (`cpf_cliente`) REFERENCES `cliente` (`cpf_cliente`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_cliente_carros_2` FOREIGN KEY (`placa_carro`) REFERENCES `carro` (`placa`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente_carros`
--

LOCK TABLES `cliente_carros` WRITE;
/*!40000 ALTER TABLE `cliente_carros` DISABLE KEYS */;
INSERT INTO `cliente_carros` VALUES ('31533298009','MUO1886'),('37217380049','MQI8117'),('40558820093','NEI6379'),('58887839000','HDS9594'),('58887839000','JYI6472'),('79042343001','JPF7109'),('80135375010','AKB4600'),('80135375010','HTK4152');
/*!40000 ALTER TABLE `cliente_carros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `entregas_semana_30`
--

DROP TABLE IF EXISTS `entregas_semana_30`;
/*!50001 DROP VIEW IF EXISTS `entregas_semana_30`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `entregas_semana_30` (
  `placa_carro` tinyint NOT NULL,
  `data_atendimento` tinyint NOT NULL,
  `tempo_est_total` tinyint NOT NULL,
  `data_entrega` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `entregas_semana_7`
--

DROP TABLE IF EXISTS `entregas_semana_7`;
/*!50001 DROP VIEW IF EXISTS `entregas_semana_7`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `entregas_semana_7` (
  `placa_carro` tinyint NOT NULL,
  `data_atendimento` tinyint NOT NULL,
  `tempo_est_total` tinyint NOT NULL,
  `data_entrega` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funcionario` (
  `cpf_funcionario` varchar(11) NOT NULL,
  `nome_funcionario` varchar(45) DEFAULT NULL,
  `id_oficina` int(11) DEFAULT NULL,
  PRIMARY KEY (`cpf_funcionario`),
  UNIQUE KEY `cpf_funcionario_UNIQUE` (`cpf_funcionario`),
  KEY `fk_funcionario_1_idx` (`id_oficina`),
  CONSTRAINT `fk_funcionario_1` FOREIGN KEY (`id_oficina`) REFERENCES `oficina` (`id_oficina`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES ('24724313099','Paulo Lopes',1),('25685856091','Julio Andrade',2),('38730498058','Felipe Menezes',1),('44570702031','Marcelo Dias',1),('64566813088','Marcos Peres',2);
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario_atendimento`
--

DROP TABLE IF EXISTS `funcionario_atendimento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funcionario_atendimento` (
  `cpf_funcionario` varchar(11) NOT NULL,
  `id_atendimento` int(11) NOT NULL,
  PRIMARY KEY (`cpf_funcionario`,`id_atendimento`),
  CONSTRAINT `fk_funcionario_atendimento_1` FOREIGN KEY (`cpf_funcionario`) REFERENCES `funcionario` (`cpf_funcionario`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario_atendimento`
--

LOCK TABLES `funcionario_atendimento` WRITE;
/*!40000 ALTER TABLE `funcionario_atendimento` DISABLE KEYS */;
INSERT INTO `funcionario_atendimento` VALUES ('24724313099',1),('24724313099',7),('25685856091',3),('38730498058',2),('38730498058',8),('44570702031',5),('64566813088',4),('64566813088',6);
/*!40000 ALTER TABLE `funcionario_atendimento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario_servico`
--

DROP TABLE IF EXISTS `funcionario_servico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funcionario_servico` (
  `cpf_funcionario` varchar(11) NOT NULL,
  `id_servico` int(11) NOT NULL,
  PRIMARY KEY (`cpf_funcionario`,`id_servico`),
  KEY `fk_funcionario_servico_2_idx` (`id_servico`),
  CONSTRAINT `fk_funcionario_servico_1` FOREIGN KEY (`cpf_funcionario`) REFERENCES `funcionario` (`cpf_funcionario`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_funcionario_servico_2` FOREIGN KEY (`id_servico`) REFERENCES `servico` (`id_servico`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario_servico`
--

LOCK TABLES `funcionario_servico` WRITE;
/*!40000 ALTER TABLE `funcionario_servico` DISABLE KEYS */;
INSERT INTO `funcionario_servico` VALUES ('24724313099',11),('24724313099',12),('24724313099',13),('25685856091',4),('25685856091',5),('25685856091',6),('38730498058',2),('38730498058',3),('38730498058',13),('44570702031',8),('44570702031',9),('44570702031',11),('64566813088',5),('64566813088',6),('64566813088',7),('64566813088',10);
/*!40000 ALTER TABLE `funcionario_servico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oficina`
--

DROP TABLE IF EXISTS `oficina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `oficina` (
  `id_oficina` int(11) NOT NULL AUTO_INCREMENT,
  `rua_oficina` varchar(45) DEFAULT NULL,
  `bairro_oficina` varchar(45) DEFAULT NULL,
  `num_casa_oficina` varchar(45) DEFAULT NULL,
  `cidade_oficina` varchar(45) DEFAULT NULL,
  `estado_oficina` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_oficina`),
  UNIQUE KEY `id_oficina_UNIQUE` (`id_oficina`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oficina`
--

LOCK TABLES `oficina` WRITE;
/*!40000 ALTER TABLE `oficina` DISABLE KEYS */;
INSERT INTO `oficina` VALUES (1,'Avenida Central','Centro','1470','Alfenas','MG'),(2,'Rua dos Operarios','Parque Industrial','2345','Sao Paulo','SP'),(3,'Avenida Dona Floriana','Centro','2876','Guaxupe','MG');
/*!40000 ALTER TABLE `oficina` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER deleteOficina_funcionario
AFTER DELETE ON oficina
FOR EACH ROW
	UPDATE funcionario
    SET id_oficina = 1
    WHERE id_oficina = OLD.id_oficina */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER deleteOficina_atendimento
AFTER DELETE ON oficina
FOR EACH ROW
	UPDATE atendimento
    SET id_oficina = 1
    WHERE id_oficina = OLD.id_oficina */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER deleteOficina_servico
AFTER DELETE ON oficina
FOR EACH ROW
	UPDATE servico
    SET id_oficina = 1
    WHERE id_oficina = OLD.id_oficina */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `peca`
--

DROP TABLE IF EXISTS `peca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `peca` (
  `id_peca` int(11) NOT NULL AUTO_INCREMENT,
  `nome_peca` varchar(45) DEFAULT NULL,
  `preco_peca` float DEFAULT 0,
  PRIMARY KEY (`id_peca`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `peca`
--

LOCK TABLES `peca` WRITE;
/*!40000 ALTER TABLE `peca` DISABLE KEYS */;
INSERT INTO `peca` VALUES (1,'Bateria',229.5),(2,'Amortecedor Dianteiro',380),(3,'Radiador',550),(4,'Disco de Freio',50.5),(5,'Amortecedor Traseiro',272.5),(6,'Para-choque',240),(7,'Kit Farois',329.5),(8,'Boia de combustivel',79.5),(9,'Espelho Retrovisor',119.5),(10,'Alarme',250),(11,'Pneu',180),(12,'Kit de Som Automotivo',740),(13,'Insulfilm',50);
/*!40000 ALTER TABLE `peca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `preco_total_pecas`
--

DROP TABLE IF EXISTS `preco_total_pecas`;
/*!50001 DROP VIEW IF EXISTS `preco_total_pecas`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `preco_total_pecas` (
  `id_atendimento` tinyint NOT NULL,
  `placa_carro` tinyint NOT NULL,
  `preco_total_pecas` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `servico`
--

DROP TABLE IF EXISTS `servico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `servico` (
  `id_servico` int(11) NOT NULL AUTO_INCREMENT,
  `preco_servico` float DEFAULT 0,
  `tempo_est_dias` int(11) DEFAULT 1,
  `descricao_servico` varchar(45) DEFAULT NULL,
  `id_oficina` int(11) DEFAULT NULL,
  `placa_carro` varchar(7) NOT NULL,
  PRIMARY KEY (`id_servico`),
  KEY `fk_servico_1_idx` (`id_oficina`),
  KEY `fk_servico_2_idx` (`placa_carro`),
  CONSTRAINT `fk_servico_1` FOREIGN KEY (`id_oficina`) REFERENCES `oficina` (`id_oficina`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `fk_servico_2` FOREIGN KEY (`placa_carro`) REFERENCES `carro` (`placa`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servico`
--

LOCK TABLES `servico` WRITE;
/*!40000 ALTER TABLE `servico` DISABLE KEYS */;
INSERT INTO `servico` VALUES (1,120,2,'Trocar boia de combustivel',3,'HDS9594'),(2,245,1,'Trocar bateria',1,'JPF7109'),(3,75,4,'Reparar fiação',1,'JPF7109'),(4,780,2,'Trocar amortecedor dianteiro',2,'MUO1886'),(5,1500,7,'Funilaria',2,'NEI6379'),(6,300,3,'Pintura',2,'NEI6379'),(7,845,2,'Trocar para-choque, farois e retrovisores',2,'NEI6379'),(8,300,1,'Instalação de alarme',1,'HTK4152'),(9,800,1,'Instalação de kit de som automotivo',1,'HTK4152'),(10,160,1,'Trocar discos de freio traseiros',2,'MUO1886'),(11,210,2,'Reparar suspensão traseira',1,'JYI6472'),(12,340,1,'Alinhamento e balanceamento',1,'JYI6472'),(13,670,2,'Trocar radiador',1,'MQI8117'),(14,950,1,'Trocar bateria, radiador',2,'NEI6379');
/*!40000 ALTER TABLE `servico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servico_peca`
--

DROP TABLE IF EXISTS `servico_peca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `servico_peca` (
  `id_servico` int(11) NOT NULL,
  `id_peca` int(11) NOT NULL,
  `quantidade` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_servico`,`id_peca`),
  KEY `fk_servico_peca_2_idx` (`id_peca`),
  CONSTRAINT `fk_servico_peca_1` FOREIGN KEY (`id_servico`) REFERENCES `servico` (`id_servico`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_servico_peca_2` FOREIGN KEY (`id_peca`) REFERENCES `peca` (`id_peca`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servico_peca`
--

LOCK TABLES `servico_peca` WRITE;
/*!40000 ALTER TABLE `servico_peca` DISABLE KEYS */;
INSERT INTO `servico_peca` VALUES (2,1,1),(4,2,2),(7,6,1),(7,7,1),(7,9,1),(8,10,1),(9,12,1),(10,4,2),(13,3,1),(14,1,1),(14,3,1);
/*!40000 ALTER TABLE `servico_peca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'mecanica'
--

--
-- Dumping routines for database 'mecanica'
--
/*!50003 DROP PROCEDURE IF EXISTS `aumentar_precos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `aumentar_precos`(IN porc int(11))
BEGIN
	UPDATE servico ss SET preco_servico = preco_servico + preco_servico * porc / 100
	WHERE id_servico IN (
		SELECT * FROM (
		SELECT s.id_servico, s.preco_servico, a.data_atendimento
		FROM servico s
		JOIN atendimento_servico ats ON s.id_servico = ats.id_servico JOIN atendimento a ON a.id_atendimento = ats.id_atendimento
		GROUP BY ats.id_atendimento) spreco
		WHERE DATEDIFF(spreco.data_atendimento, CURRENT_DATE) >= 0
	);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `calcular_preco_total` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `calcular_preco_total`(IN id_at int(11), OUT preco float)
BEGIN
	SELECT precos.preco_total_servico INTO preco FROM (
		SELECT ats.id_atendimento, s.preco_servico + preco_total_pecas AS preco_total_servico
		FROM servico s JOIN (
			SELECT sp.id_servico, sp.quantidade * p.preco_peca AS preco_total_pecas
			FROM servico_peca sp JOIN peca p ON sp.id_peca = p.id_peca
			GROUP BY sp.id_servico
		) spp ON s.id_servico = spp.id_servico JOIN atendimento_servico ats ON s.id_servico = ats.id_servico
		GROUP BY ats.id_atendimento
	) precos WHERE precos.id_atendimento = id_at;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `desconto` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `desconto`(IN id_at int(11))
BEGIN
	UPDATE servico SET preco_servico = preco_servico - preco_servico * 20 / 100
	WHERE id_servico IN (
		SELECT id_servico FROM atendimento_servico ats
		WHERE ats.id_atendimento = id_at
	);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `simpleproc` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `simpleproc`(OUT param1 INT)
BEGIN
  SELECT COUNT(*) INTO param1 FROM servico;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `entregas_semana_30`
--

/*!50001 DROP TABLE IF EXISTS `entregas_semana_30`*/;
/*!50001 DROP VIEW IF EXISTS `entregas_semana_30`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `entregas_semana_30` AS select `atd`.`placa_carro` AS `placa_carro`,`atd`.`data_atendimento` AS `data_atendimento`,`st`.`tempo_est_total` AS `tempo_est_total`,`atd`.`data_atendimento` + interval `st`.`tempo_est_total` day AS `data_entrega` from (`mecanica`.`atendimento` `atd` join (select sum(`s`.`tempo_est_dias`) AS `tempo_est_total`,`a`.`id_atendimento` AS `id_atendimento` from (`mecanica`.`servico` `s` join `mecanica`.`atendimento_servico` `a` on(`s`.`id_servico` = `a`.`id_servico`)) group by `a`.`id_atendimento`) `st` on(`atd`.`id_atendimento` = `st`.`id_atendimento`)) where to_days(curdate() + interval 30 day) - to_days(`atd`.`data_atendimento` + interval `st`.`tempo_est_total` day) < 30 */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `entregas_semana_7`
--

/*!50001 DROP TABLE IF EXISTS `entregas_semana_7`*/;
/*!50001 DROP VIEW IF EXISTS `entregas_semana_7`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `entregas_semana_7` AS select `atd`.`placa_carro` AS `placa_carro`,`atd`.`data_atendimento` AS `data_atendimento`,`st`.`tempo_est_total` AS `tempo_est_total`,`atd`.`data_atendimento` + interval `st`.`tempo_est_total` day AS `data_entrega` from (`mecanica`.`atendimento` `atd` join (select sum(`s`.`tempo_est_dias`) AS `tempo_est_total`,`a`.`id_atendimento` AS `id_atendimento` from (`mecanica`.`servico` `s` join `mecanica`.`atendimento_servico` `a` on(`s`.`id_servico` = `a`.`id_servico`)) group by `a`.`id_atendimento`) `st` on(`atd`.`id_atendimento` = `st`.`id_atendimento`)) where to_days(curdate() + interval 7 day) - to_days(`atd`.`data_atendimento` + interval `st`.`tempo_est_total` day) < 7 */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `preco_total_pecas`
--

/*!50001 DROP TABLE IF EXISTS `preco_total_pecas`*/;
/*!50001 DROP VIEW IF EXISTS `preco_total_pecas`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `preco_total_pecas` AS select `a`.`id_atendimento` AS `id_atendimento`,`a`.`placa_carro` AS `placa_carro`,sum(`p`.`preco_peca`) AS `preco_total_pecas` from (((`peca` `p` join `servico_peca` `sp` on(`p`.`id_peca` = `sp`.`id_peca`)) join `atendimento_servico` `ats` on(`sp`.`id_servico` = `ats`.`id_servico`)) join `atendimento` `a` on(`a`.`id_atendimento` = `ats`.`id_atendimento`)) group by `a`.`id_atendimento` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-16 15:53:33
