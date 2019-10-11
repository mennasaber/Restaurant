-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 08, 2019 at 10:05 PM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `restaurant`
--

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

CREATE TABLE `bill` (
  `bill_id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `bill_date` date NOT NULL,
  `delivery_charges` float NOT NULL,
  `total` float NOT NULL,
  `promotion_id` int(11) NOT NULL,
  `discount_percentage` int(11) NOT NULL,
  `total_after_discount` float NOT NULL,
  `customer_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bill`
--

INSERT INTO `bill` (`bill_id`, `order_id`, `bill_date`, `delivery_charges`, `total`, `promotion_id`, `discount_percentage`, `total_after_discount`, `customer_id`) VALUES
(1, 1038, '2019-05-06', 10, 30, 0, 0, 20, 0),
(2, 1039, '2019-05-06', 10, 190, 0, 0, 180, 0),
(3, 1040, '2019-05-06', 10, 50, 0, 0, 40, 0),
(4, 1041, '2019-05-06', 10, 90, 0, 0, 80, 0),
(5, 1042, '2019-05-06', 10, 140, 0, 0, 130, 0),
(6, 1047, '2019-05-06', 10, 30, 0, 0, 30, 0),
(7, 1048, '2019-05-06', 10, 30, 1, 10, 28, 0),
(8, 1050, '2019-05-06', 10, 40, 1, 10, 37, 0),
(9, 1051, '2019-05-06', 10, 283, 1, 10, 255.7, 0),
(10, 1058, '2019-05-06', 10, 40, 1, 10, 37, 0),
(11, 1064, '2019-05-06', 10, 40, 1, 10, 37, 0),
(12, 1085, '2019-05-07', 10, 70, 1, 10, 64, 0),
(13, 1087, '2019-05-07', 10, 30, 1, 10, 28, 0),
(14, 1098, '2019-05-07', 10, 70, 1, 10, 54, 0),
(15, 1117, '2019-05-07', 10, 30, 1, 10, 18, 0),
(16, 1119, '2019-05-07', 10, 30, 1, 10, 18, 0),
(17, 1130, '2019-05-07', 10, 210, 1, 10, 180, 0),
(18, 1131, '2019-05-07', 10, 60, 1, 10, 45, 0),
(19, 1135, '2019-05-07', 10, 30, 1, 10, 18, 0),
(20, 1142, '2019-05-07', 10, 50, 1, 10, 36, 0),
(21, 1142, '2019-05-08', 10, 30, 1, 10, 18, 0),
(22, 1143, '2019-05-08', 10, 30, 1, 10, 18, 0),
(23, 1149, '2019-05-08', 10, 30, 1, 10, 18, 0),
(24, 1150, '2019-05-08', 10, 40, 1, 10, 27, 0),
(25, 1159, '2019-05-08', 10, 30, 1, 10, 18, 0);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `cus_id` int(11) NOT NULL,
  `user_name` varchar(45) NOT NULL,
  `mobile` varchar(11) NOT NULL,
  `address` varchar(300) NOT NULL,
  `password` varchar(45) NOT NULL,
  `first_time` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`cus_id`, `user_name`, `mobile`, `address`, `password`, `first_time`) VALUES
(2, 'fatma', '01126772117', 'mmmm1', '123', 0),
(3, 'sara', '01126772117', '21--', '123', 0),
(5, 'menna', '01126772117', '21-elfaramawy', '123', 1),
(6, 'menna', '01126772117', '21-elfaramawy', '123', 1),
(7, 'menna', '01126772117', '21-elfarmaway', '123', 1),
(8, 'Name', 'Phone', 'Address', 'Password', 1),
(9, 'sara', '0111', '21-h', '123', 1),
(10, 'fatma', '01111', '31-el', '456', 1);

-- --------------------------------------------------------

--
-- Table structure for table `delivery_boy`
--

CREATE TABLE `delivery_boy` (
  `delivery_id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `working_hours` int(11) NOT NULL,
  `num_of_orders` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `delivery_boy`
--

INSERT INTO `delivery_boy` (`delivery_id`, `name`, `working_hours`, `num_of_orders`) VALUES
(1, 'omar', 10, 2),
(2, 'mohamed', 10, 0);

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

CREATE TABLE `item` (
  `item_id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `rate` int(11) DEFAULT NULL,
  `price` float NOT NULL,
  `photo` varchar(50) NOT NULL,
  `discount` float DEFAULT NULL,
  `category_name` varchar(45) NOT NULL,
  `quantity` int(11) DEFAULT NULL,
  `original_quantity` int(11) DEFAULT NULL,
  `offer_message` varchar(50) DEFAULT NULL,
  `checked` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `item`
--

INSERT INTO `item` (`item_id`, `name`, `rate`, `price`, `photo`, `discount`, `category_name`, `quantity`, `original_quantity`, `offer_message`, `checked`) VALUES
(7, 'Cafe Latte', 4, 30, 'rgggg', 0, 'Hot Drink', 49, 100, 'hgghghhgh', 1),
(11, 'Vienna Coffee', 4, 30, 'sdsvvsv', NULL, 'Hot Drink', 50, 100, 'vvvrggg', 1),
(12, 'Short Black', 4, 50, 'zvsfdfdhh', NULL, 'Hot Drink', 50, 100, 'asdfdfgh', 1),
(13, 'Ristretto', 4, 50, 'dffdfhdghdg', NULL, 'Hot Drink', 50, 100, 'ffbfbggbggb', 1),
(14, 'Piccolo Latte', 4, 30, 'sdsdsdgr', NULL, 'Hot Drink', 50, 100, 'fbbdnyjns', 1),
(15, 'Hot Chocolate', 4, 30, 'ddxdfddhf', NULL, 'Hot Drink', 50, 100, 'ffbfdfdfbbf', 1),
(16, 'Cappuccino', 4, 50, 'cxvbfhhjh', NULL, 'Hot Drink', 50, 100, 'sdfbbbfdbdd', 1),
(17, 'Flat White', 4, 50, 'sdgffthy', NULL, 'Hot Drink', 50, 100, 'zvsfbbddgng', 1),
(25, 'Coca-Cola', 4, 20, '', NULL, 'Cold Drink', 48, 100, NULL, 1),
(26, 'Lemonade', 4, 15, '', NULL, 'Cold Drink', 50, 100, NULL, 1),
(27, 'Pepsi', 4, 20, '', NULL, 'Cold Drink', 50, 100, NULL, 1),
(28, 'Beer', 4, 50, '', NULL, 'Cold Drink', 50, 100, NULL, 1),
(29, 'Sprite', 4, 20, '', NULL, 'Cold Drink', 50, 100, NULL, 1),
(30, 'Cocktail', 4, 30, '', NULL, 'Cold Drink', 50, 100, NULL, 1),
(31, 'Milkshake', 4, 40, '', NULL, 'Cold Drink', 50, 100, NULL, 1),
(32, 'Fruit Juice', 4, 40, '', NULL, 'Cold Drink', 50, 100, NULL, 1),
(33, 'Carbonated water', 4, 15, '', NULL, 'Cold Drink', 50, 100, NULL, 1),
(34, 'Iced tea', 4, 30, '', 0, 'Cold Drink', 50, 100, NULL, 1),
(35, 'Aam Ras', 4, 65, '', NULL, 'Cold Drink', 50, 100, NULL, 1),
(36, 'Berry Khatta', 4, 50, '', NULL, 'Cold Drink', 50, 100, NULL, 1),
(37, 'Virgin Punch', 4, 80, '', NULL, 'Cold Drink', 50, 100, NULL, 1),
(38, 'Grape Nectar', 4, 55, '', NULL, 'Cold Drink', 50, 100, NULL, 1),
(39, 'Plum-ness', 4, 30, '', NULL, 'Cold Drink', 50, 100, NULL, 1),
(40, 'Basil Juice', 4, 33, '', NULL, 'Cold Drink', 50, 100, NULL, 1),
(42, 'Pomegranate Juice', 4, 40, '', NULL, 'Cold Drink', 50, 100, NULL, 1),
(43, 'Apple cider', 4, 30, '', NULL, 'Hot Drink', 50, 100, NULL, 1),
(44, 'Asiático', 4, 52, '', NULL, 'Hot Drink', 50, 100, NULL, 1),
(45, 'Atole', 4, 15, '', NULL, 'Hot Drink', 50, 100, NULL, 1),
(46, 'Bandrek', 4, 20, '', NULL, 'Hot Drink', 50, 100, NULL, 1),
(47, 'Butter tea', 4, 50, '', NULL, 'Hot Drink', 50, 100, NULL, 1),
(48, 'hhhh', 4, 50, 'jTextField4', NULL, 'Hot Drink', 50, 100, NULL, 1),
(52, 'pp', NULL, 40, '', NULL, 'Hot Drink', 50, 100, NULL, NULL),
(53, 'www', NULL, 10, '', NULL, 'Hot Drink', 50, 100, NULL, NULL),
(55, 'meee', NULL, 40, '', NULL, 'Hot Drink', 50, 100, NULL, NULL),
(61, ',m', NULL, 11, '', NULL, 'Hot Drink', 2, 2, NULL, NULL),
(62, 'm', NULL, 4, '', NULL, 'Hot Drink', 4, 4, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `order_`
--

CREATE TABLE `order_` (
  `order_id` int(11) NOT NULL,
  `complain_message` varchar(300) DEFAULT NULL,
  `time` time DEFAULT NULL,
  `cus_id` int(11) NOT NULL,
  `delivery_charge` float DEFAULT NULL,
  `delivery_id` int(11) DEFAULT NULL,
  `total` float DEFAULT NULL,
  `balance` float DEFAULT NULL,
  `feed_back` varchar(300) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `order_`
--

INSERT INTO `order_` (`order_id`, `complain_message`, `time`, `cus_id`, `delivery_charge`, `delivery_id`, `total`, `balance`, `feed_back`) VALUES
(1085, 'Bad', '01:00:36', 2, 10, 1, 42, 52, NULL),
(1087, NULL, '01:04:25', 2, 10, 1, 20, 30, NULL),
(1098, NULL, '01:35:53', 2, 10, 2, 60, 70, NULL),
(1131, NULL, '11:38:10', 2, 10, 2, 50, 60, NULL),
(1142, NULL, '15:53:53', 5, 10, 1, 14, 24, NULL),
(1143, NULL, '15:54:10', 5, 10, 2, 20, 30, NULL),
(1149, NULL, '16:44:37', 5, 10, 2, 20, 30, NULL),
(1150, NULL, '16:45:26', 5, 10, 1, 30, 40, NULL),
(1159, NULL, '20:13:26', 5, 10, 1, 20, 30, 'good'),
(1172, NULL, NULL, 5, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `order_item`
--

CREATE TABLE `order_item` (
  `order_id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `order_item`
--

INSERT INTO `order_item` (`order_id`, `item_id`, `quantity`) VALUES
(1085, 7, 2),
(1087, 25, 1),
(1098, 25, 3),
(1131, 36, 1),
(1142, 25, 1),
(1143, 25, 1),
(1149, 25, 1),
(1150, 7, 1),
(1159, 25, 1);

-- --------------------------------------------------------

--
-- Table structure for table `promotion`
--

CREATE TABLE `promotion` (
  `promo_id` int(11) NOT NULL,
  `itemid` int(11) NOT NULL,
  `disscount` float NOT NULL,
  `message_offer` varchar(300) NOT NULL,
  `end_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `promotion`
--

INSERT INTO `promotion` (`promo_id`, `itemid`, `disscount`, `message_offer`, `end_date`) VALUES
(1, 11, 0.3, 'Discount 30%', '2019-05-22'),
(2, 7, 0.4, 'Discount 40% ', '2019-05-15'),
(3, 12, 0.1, 'Discount 10%', '2019-05-08');

-- --------------------------------------------------------

--
-- Table structure for table `promotion2`
--

CREATE TABLE `promotion2` (
  `id` int(6) NOT NULL,
  `discount` int(11) NOT NULL,
  `release_date` date NOT NULL,
  `expiration_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `promotion2`
--

INSERT INTO `promotion2` (`id`, `discount`, `release_date`, `expiration_date`) VALUES
(1, 10, '2019-05-06', '2019-05-15'),
(2, 30, '2019-05-06', '2019-05-08'),
(3, 30, '2019-05-08', '2019-05-02');

-- --------------------------------------------------------

--
-- Table structure for table `rates`
--

CREATE TABLE `rates` (
  `itemid` int(11) NOT NULL,
  `customerid` int(11) NOT NULL,
  `rate` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rates`
--

INSERT INTO `rates` (`itemid`, `customerid`, `rate`) VALUES
(0, 9, 3),
(25, 9, 4),
(33, 9, 3),
(7, 3, 2),
(8, 3, 1),
(9, 3, 5),
(10, 3, 3),
(25, 3, 3),
(26, 3, 1),
(27, 3, 3),
(28, 3, 2),
(30, 3, 3),
(32, 3, 3),
(31, 3, 4),
(33, 3, 3),
(45, 4, 2),
(44, 4, 4),
(8, 4, 4),
(14, 4, 3),
(13, 4, 2),
(16, 4, 4),
(17, 4, 2),
(47, 4, 3),
(44, 3, 4),
(50, 2, 5),
(32, 2, 2),
(31, 2, 5),
(30, 2, 2),
(8, 2, 4),
(42, 2, 3),
(35, 2, 4),
(43, 2, 5),
(7, 2, 5),
(16, 2, 4),
(26, 2, 3),
(37, 2, 4),
(35, 3, 3),
(33, 5, 4),
(35, 5, 3),
(34, 5, 5),
(11, 5, 4);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`bill_id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`cus_id`);

--
-- Indexes for table `delivery_boy`
--
ALTER TABLE `delivery_boy`
  ADD PRIMARY KEY (`delivery_id`);

--
-- Indexes for table `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`item_id`);

--
-- Indexes for table `order_`
--
ALTER TABLE `order_`
  ADD PRIMARY KEY (`order_id`),
  ADD KEY `cus_id` (`cus_id`),
  ADD KEY `delivery_id` (`delivery_id`);

--
-- Indexes for table `order_item`
--
ALTER TABLE `order_item`
  ADD KEY `order_id` (`order_id`),
  ADD KEY `item_id` (`item_id`);

--
-- Indexes for table `promotion`
--
ALTER TABLE `promotion`
  ADD PRIMARY KEY (`promo_id`),
  ADD KEY `itemid` (`itemid`);

--
-- Indexes for table `promotion2`
--
ALTER TABLE `promotion2`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rates`
--
ALTER TABLE `rates`
  ADD KEY `itemid` (`itemid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bill`
--
ALTER TABLE `bill`
  MODIFY `bill_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `cus_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `delivery_boy`
--
ALTER TABLE `delivery_boy`
  MODIFY `delivery_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `item`
--
ALTER TABLE `item`
  MODIFY `item_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=63;

--
-- AUTO_INCREMENT for table `order_`
--
ALTER TABLE `order_`
  MODIFY `order_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1173;

--
-- AUTO_INCREMENT for table `promotion`
--
ALTER TABLE `promotion`
  MODIFY `promo_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `promotion2`
--
ALTER TABLE `promotion2`
  MODIFY `id` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `order_`
--
ALTER TABLE `order_`
  ADD CONSTRAINT `order__ibfk_1` FOREIGN KEY (`cus_id`) REFERENCES `customer` (`cus_id`),
  ADD CONSTRAINT `order__ibfk_2` FOREIGN KEY (`delivery_id`) REFERENCES `delivery_boy` (`delivery_id`);

--
-- Constraints for table `order_item`
--
ALTER TABLE `order_item`
  ADD CONSTRAINT `order_item_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `order_` (`order_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `order_item_ibfk_2` FOREIGN KEY (`item_id`) REFERENCES `item` (`item_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `promotion`
--
ALTER TABLE `promotion`
  ADD CONSTRAINT `promotion_ibfk_1` FOREIGN KEY (`itemid`) REFERENCES `item` (`item_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
