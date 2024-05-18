-- MySQL dump 10.13  Distrib 8.0.30, for Linux (x86_64)
--
-- Host: localhost    Database: wsd
-- ------------------------------------------------------
-- Server version	8.0.30-0ubuntu0.22.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE = @@TIME_ZONE */;
/*!40103 SET TIME_ZONE = '+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer`
(
    `id`          int          NOT NULL AUTO_INCREMENT,
    `name`        varchar(300) NOT NULL,
    `customer_id` varchar(100) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 4
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer`
    DISABLE KEYS */;
INSERT INTO `customer`
VALUES (1, 'John Doe', 'CUST001'),
       (2, 'Alice Smith', 'CUST002'),
       (3, 'Bob Johnson', 'CUST003');
/*!40000 ALTER TABLE `customer`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product`
(
    `id`    int          NOT NULL AUTO_INCREMENT,
    `name`  varchar(100) NOT NULL,
    `price` decimal(10, 0) DEFAULT NULL,
    `sku`   varchar(100)   DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 11
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product`
    DISABLE KEYS */;
INSERT INTO `product`
VALUES (1, 'Laptop', 1000, 'SKU001'),
       (2, 'Smartphone', 899, 'SKU002'),
       (3, 'Headphones', 24, 'SKU003'),
       (4, 'Tablet', 300, 'SKU004'),
       (5, 'Camera', 1200, 'SKU005');
/*!40000 ALTER TABLE `product`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sales_record`
--

DROP TABLE IF EXISTS `sales_record`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sales_record`
(
    `id`          int       NOT NULL AUTO_INCREMENT,
    `customer_id` int       NOT NULL,
    `sales_date`  timestamp NOT NULL,
    `product_id`  int       NOT NULL,
    `quantity`    double DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 119
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales_record`
--

LOCK TABLES `sales_record` WRITE;
/*!40000 ALTER TABLE `sales_record`
    DISABLE KEYS */;
INSERT INTO `sales_record`
VALUES (63, 1, '2024-05-01 00:00:00', 1, 3),
       (64, 2, '2024-05-02 00:00:00', 2, 2),
       (65, 3, '2024-05-03 00:00:00', 3, 4),
       (66, 1, '2024-05-04 00:00:00', 4, 1),
       (67, 2, '2024-05-05 00:00:00', 5, 5),
       (68, 3, '2024-05-06 00:00:00', 1, 2),
       (69, 1, '2024-05-07 00:00:00', 2, 4),
       (70, 2, '2024-05-01 00:00:00', 3, 3),
       (71, 3, '2024-05-02 00:00:00', 4, 1),
       (72, 1, '2024-05-03 00:00:00', 5, 2),
       (73, 2, '2024-05-04 00:00:00', 1, 3),
       (74, 3, '2024-05-05 00:00:00', 2, 1),
       (75, 1, '2024-05-06 00:00:00', 3, 2),
       (76, 2, '2024-05-07 00:00:00', 4, 3),
       (77, 3, '2024-05-01 00:00:00', 5, 1),
       (78, 1, '2024-05-02 00:00:00', 1, 4),
       (79, 2, '2024-05-03 00:00:00', 2, 3),
       (80, 3, '2024-05-04 00:00:00', 3, 2),
       (81, 1, '2024-05-05 00:00:00', 4, 1),
       (82, 2, '2024-05-06 00:00:00', 5, 5),
       (83, 3, '2024-05-07 00:00:00', 1, 3),
       (84, 1, '2024-05-01 00:00:00', 2, 2),
       (85, 2, '2024-05-02 00:00:00', 3, 4),
       (86, 3, '2024-05-03 00:00:00', 4, 1),
       (87, 1, '2024-05-04 00:00:00', 5, 5),
       (88, 2, '2024-05-05 00:00:00', 1, 2),
       (89, 3, '2024-05-06 00:00:00', 2, 4),
       (90, 1, '2024-05-07 00:00:00', 3, 3),
       (91, 2, '2024-05-01 00:00:00', 4, 1),
       (92, 3, '2024-05-02 00:00:00', 5, 2),
       (93, 1, '2024-05-03 00:00:00', 1, 3),
       (94, 2, '2024-05-04 00:00:00', 2, 1),
       (95, 3, '2024-05-05 00:00:00', 3, 2),
       (96, 1, '2024-05-06 00:00:00', 4, 3),
       (97, 2, '2024-05-07 00:00:00', 5, 1),
       (98, 3, '2024-05-01 00:00:00', 1, 4),
       (99, 1, '2024-05-02 00:00:00', 2, 3),
       (100, 2, '2024-05-03 00:00:00', 3, 2),
       (101, 3, '2024-05-04 00:00:00', 4, 1),
       (102, 1, '2024-05-05 00:00:00', 5, 5),
       (103, 2, '2024-05-06 00:00:00', 1, 3),
       (104, 3, '2024-05-07 00:00:00', 2, 2),
       (105, 1, '2024-05-01 00:00:00', 3, 4),
       (106, 2, '2024-05-02 00:00:00', 4, 1),
       (107, 3, '2024-05-03 00:00:00', 5, 5),
       (108, 1, '2024-05-04 00:00:00', 1, 2),
       (109, 2, '2024-05-05 00:00:00', 2, 4),
       (110, 3, '2024-05-06 00:00:00', 3, 3),
       (111, 1, '2024-05-07 00:00:00', 4, 1),
       (112, 2, '2024-05-01 00:00:00', 5, 2),
       (113, 3, '2024-05-02 00:00:00', 1, 3),
       (114, 1, '2024-05-03 00:00:00', 2, 1),
       (115, 2, '2024-05-04 00:00:00', 3, 2),
       (116, 3, '2024-05-05 00:00:00', 4, 3),
       (117, 1, '2024-05-06 00:00:00', 5, 1),
       (118, 2, '2024-05-07 00:00:00', 1, 4);
/*!40000 ALTER TABLE `sales_record`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wishlist`
--

DROP TABLE IF EXISTS `wishlist`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wishlist`
(
    `id`          int NOT NULL AUTO_INCREMENT,
    `customer_id` int          DEFAULT NULL,
    `product_id`  int          DEFAULT NULL,
    `quantity`    varchar(100) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 21
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wishlist`
--

LOCK TABLES `wishlist` WRITE;
/*!40000 ALTER TABLE `wishlist`
    DISABLE KEYS */;
INSERT INTO `wishlist`
VALUES (1, 1, 1, '2'),
       (2, 2, 1, '2'),
       (3, 3, 1, '1'),
       (4, 1, 1, '3'),
       (5, 1, 2, '2'),
       (6, 2, 2, '2'),
       (7, 3, 2, '2'),
       (8, 1, 2, '2'),
       (9, 1, 3, '1'),
       (10, 2, 3, '3'),
       (11, 3, 3, '2'),
       (12, 1, 3, '2'),
       (13, 1, 4, '1'),
       (14, 2, 4, '2'),
       (15, 3, 4, '3'),
       (16, 1, 4, '2'),
       (17, 1, 5, '2'),
       (18, 2, 5, '3'),
       (19, 3, 5, '1'),
       (20, 1, 5, '2');
/*!40000 ALTER TABLE `wishlist`
    ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE = @OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;

