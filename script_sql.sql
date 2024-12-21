-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               11.5.2-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.8.0.6908
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for demo1
CREATE DATABASE IF NOT EXISTS `demo1` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;
USE `demo1`;

-- Dumping structure for table demo1.cua_hang
CREATE TABLE IF NOT EXISTS `cua_hang` (
  `ma_cua_hang` int(11) NOT NULL AUTO_INCREMENT,
  `ten` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ma_cua_hang`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table demo1.cua_hang: ~0 rows (approximately)
INSERT INTO `cua_hang` (`ma_cua_hang`, `ten`) VALUES
	(1, 'Cửa Hàng A'),
	(2, 'Cửa Hàng B');

-- Dumping structure for table demo1.don_hang
CREATE TABLE IF NOT EXISTS `don_hang` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `ma_don_hang` varchar(255) DEFAULT NULL,
  `ngay_dat_hang` date DEFAULT NULL,
  `ten_khach_hang` varchar(50) NOT NULL,
  `tensp` varchar(255) DEFAULT NULL,
  `trang_thai` bit(1) NOT NULL,
  `ma_cua_hang` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4kymaakagxjkbm99g5vlrilih` (`ma_cua_hang`),
  CONSTRAINT `FK4kymaakagxjkbm99g5vlrilih` FOREIGN KEY (`ma_cua_hang`) REFERENCES `cua_hang` (`ma_cua_hang`)
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table demo1.don_hang: ~0 rows (approximately)
INSERT INTO `don_hang` (`id`, `email`, `ma_don_hang`, `ngay_dat_hang`, `ten_khach_hang`, `tensp`, `trang_thai`, `ma_cua_hang`) VALUES
	(2, 'tranthib@gmail.com', 'DH002', '2024-06-18', 'Tran Thi B', 'Sản Phẩm Y', b'0', 2),
	(3, 'levanc@gmail.com', '20241220202624', '2025-01-31', 'Le Van B', 'Sản Phẩm Z', b'1', 1),
	(4, 'phamthid@gmail.com', 'DH004', '2024-06-16', 'Pham Thi D', 'Sản Phẩm W', b'1', 2);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
