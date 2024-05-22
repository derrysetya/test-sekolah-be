-- MySQL dump 10.13  Distrib 5.5.62, for Win64 (AMD64)
--
-- Host: localhost    Database: db_sekolah
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.32-MariaDB

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
-- Table structure for table `dat_nilai`
--

DROP TABLE IF EXISTS `dat_nilai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dat_nilai` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_siswa` bigint(20) NOT NULL,
  `id_mapel` bigint(20) NOT NULL,
  `uts` int(11) DEFAULT NULL,
  `uas` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dat_nilai`
--

LOCK TABLES `dat_nilai` WRITE;
/*!40000 ALTER TABLE `dat_nilai` DISABLE KEYS */;
INSERT INTO `dat_nilai` VALUES (1,1,1,80,90),(3,3,1,70,80),(4,2,1,77,90),(5,7,1,79,88);
/*!40000 ALTER TABLE `dat_nilai` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mst_guru`
--

DROP TABLE IF EXISTS `mst_guru`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mst_guru` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nama` varchar(100) DEFAULT NULL,
  `alamat` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mst_guru`
--

LOCK TABLES `mst_guru` WRITE;
/*!40000 ALTER TABLE `mst_guru` DISABLE KEYS */;
INSERT INTO `mst_guru` VALUES (1,'Agus','Riau'),(2,'Deki','Bogor');
/*!40000 ALTER TABLE `mst_guru` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mst_mapel`
--

DROP TABLE IF EXISTS `mst_mapel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mst_mapel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nama` varchar(100) DEFAULT NULL,
  `kkm` int(11) DEFAULT NULL,
  `id_guru` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mst_mapel`
--

LOCK TABLES `mst_mapel` WRITE;
/*!40000 ALTER TABLE `mst_mapel` DISABLE KEYS */;
INSERT INTO `mst_mapel` VALUES (1,'Matematika',75,1),(3,'Biologi',77,2);
/*!40000 ALTER TABLE `mst_mapel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mst_siswa`
--

DROP TABLE IF EXISTS `mst_siswa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mst_siswa` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nama` varchar(100) DEFAULT NULL,
  `alamat` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mst_siswa`
--

LOCK TABLES `mst_siswa` WRITE;
/*!40000 ALTER TABLE `mst_siswa` DISABLE KEYS */;
INSERT INTO `mst_siswa` VALUES (1,'Derry Prasetya','Tebet'),(2,'Zahir Faturahman','Bogor'),(3,'Kevin','Petamburan'),(7,'Bachtiyar','Cibubur');
/*!40000 ALTER TABLE `mst_siswa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'db_sekolah'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-22 16:43:06
