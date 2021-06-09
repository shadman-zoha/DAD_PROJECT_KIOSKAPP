-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jun 08, 2021 at 09:17 PM
-- Server version: 5.7.33
-- PHP Version: 7.4.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kioskappdb_dev`
--
CREATE DATABASE IF NOT EXISTS `kioskappdb_dev` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `kioskappdb_dev`;

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

CREATE TABLE `item` (
  `Item` int(11) NOT NULL,
  `Name` varchar(300) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Price` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `item`
--

INSERT INTO `item` (`Item`, `Name`, `Price`) VALUES
(1, 'Chicken	', 8.1),
(2, 'Ayam Goreng Spicy (2pcs)	', 11.9),
(3, 'Ayam Goreng Spicy (5pcs)', 30.2),
(4, 'Spicy Chicken Deluxe', 11.9),
(5, 'Chicken Nuggets (6pcs)', 9.4),
(6, 'Double Cheeseburger	', 9.45),
(7, 'Big Mac	', 10.4),
(8, 'Filet-O-Fish	', 8.45),
(9, 'Chicken Meal (Medium)', 13.2),
(10, 'Chicken Nuggets 6pcs Meal (Medium)', 13.2),
(11, 'Filet-O-Fish Meal (Medium)', 13),
(13, 'Strawberry Sundae', 4.15),
(14, 'Chocolate Sundae', 4.15);

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

CREATE TABLE `order` (
  `OrderId` int(11) NOT NULL,
  `TotalAmount` float NOT NULL,
  `OrderReferenceNumber` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `ordereditem`
--

CREATE TABLE `ordereditem` (
  `OrderedItemId` int(11) NOT NULL,
  `Item` int(11) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `SubTotalAmount` float NOT NULL,
  `Order` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `ordertransaction`
--

CREATE TABLE `ordertransaction` (
  `OrderTransactionId` int(11) NOT NULL,
  `TransactionDate` datetime NOT NULL,
  `Order` int(11) NOT NULL,
  `AmountCharged` float NOT NULL,
  `TransactionStatus` int(11) NOT NULL DEFAULT '0',
  `Last4Digits` int(11) NOT NULL,
  `OrderMode` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'Eat-In'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`Item`);

--
-- Indexes for table `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`OrderId`);

--
-- Indexes for table `ordereditem`
--
ALTER TABLE `ordereditem`
  ADD PRIMARY KEY (`OrderedItemId`),
  ADD KEY `OrderedItem_ItemProduct_FK_idx` (`Item`),
  ADD KEY `OrderedItem_Order_FK_idx` (`Order`);

--
-- Indexes for table `ordertransaction`
--
ALTER TABLE `ordertransaction`
  ADD PRIMARY KEY (`OrderTransactionId`),
  ADD KEY `OrderTransaction_Order_FK_idx` (`Order`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `item`
--
ALTER TABLE `item`
  MODIFY `Item` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `order`
--
ALTER TABLE `order`
  MODIFY `OrderId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `ordereditem`
--
ALTER TABLE `ordereditem`
  MODIFY `OrderedItemId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `ordertransaction`
--
ALTER TABLE `ordertransaction`
  MODIFY `OrderTransactionId` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `ordereditem`
--
ALTER TABLE `ordereditem`
  ADD CONSTRAINT `OrderedItem_ItemProduct_FK` FOREIGN KEY (`Item`) REFERENCES `item` (`Item`) ON UPDATE CASCADE,
  ADD CONSTRAINT `OrderedItem_Order_FK` FOREIGN KEY (`Order`) REFERENCES `order` (`OrderId`) ON UPDATE CASCADE;

--
-- Constraints for table `ordertransaction`
--
ALTER TABLE `ordertransaction`
  ADD CONSTRAINT `OrderTransaction_Order_FK` FOREIGN KEY (`Order`) REFERENCES `order` (`OrderId`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
