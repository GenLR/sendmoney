-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 16, 2024 at 05:51 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sendmoneydbs`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_customer`
--

CREATE TABLE `tbl_customer` (
  `cu_id` int(20) NOT NULL,
  `cu_name` varchar(100) NOT NULL,
  `cu_moreinfo` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_customer`
--

INSERT INTO `tbl_customer` (`cu_id`, `cu_name`, `cu_moreinfo`) VALUES
(1, 'Princess Nacua', 1),
(2, 'Heath Caparas', 2);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_customermore`
--

CREATE TABLE `tbl_customermore` (
  `more_id` int(20) NOT NULL,
  `cu_gender` varchar(100) NOT NULL,
  `cu_nationality` varchar(200) NOT NULL,
  `cu_address` varchar(100) NOT NULL,
  `cu_birthdate` date NOT NULL,
  `cu_birthplace` varchar(100) NOT NULL,
  `cu_marital` varchar(100) NOT NULL,
  `cu_occupation` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_customermore`
--

INSERT INTO `tbl_customermore` (`more_id`, `cu_gender`, `cu_nationality`, `cu_address`, `cu_birthdate`, `cu_birthplace`, `cu_marital`, `cu_occupation`) VALUES
(1, 'Female', 'Filipino', 'Bacay, Tulay, Minglanilla, Cebu', '2002-08-22', 'Cebu City', 'Single', 'Student'),
(2, 'Male', 'Filipino', 'Lower Calajoan, Minglanilla, Cebu', '2000-04-01', 'Cebu City', 'Single', 'Manager');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_loyaltycard`
--

CREATE TABLE `tbl_loyaltycard` (
  `lo_cardno.` varchar(20) NOT NULL,
  `lo_name` int(20) NOT NULL,
  `lo_sent` int(20) NOT NULL,
  `lo_recieved` int(20) NOT NULL,
  `lo_total` int(20) NOT NULL,
  `lo_points` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_loyaltycard`
--

INSERT INTO `tbl_loyaltycard` (`lo_cardno.`, `lo_name`, `lo_sent`, `lo_recieved`, `lo_total`, `lo_points`) VALUES
('AA-001-00001', 2, 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_receiver`
--

CREATE TABLE `tbl_receiver` (
  `re_id` int(20) NOT NULL,
  `re_name` int(100) NOT NULL,
  `re_contact` varchar(100) NOT NULL,
  `re_card` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_sender`
--

CREATE TABLE `tbl_sender` (
  `se_id` int(20) NOT NULL,
  `se_name` int(100) NOT NULL,
  `se_contact` varchar(100) NOT NULL,
  `se_card` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_transactions`
--

CREATE TABLE `tbl_transactions` (
  `tr_id` int(20) NOT NULL,
  `tr_senderinfo` int(20) NOT NULL,
  `tr_receiverinfo` int(20) NOT NULL,
  `tr_location` varchar(100) NOT NULL,
  `tr_amount` decimal(10,0) NOT NULL,
  `tr_charge` decimal(10,0) NOT NULL,
  `tr_code` varchar(100) NOT NULL,
  `tr_datesent` datetime(6) NOT NULL,
  `tr_datereceived` datetime(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_user`
--

CREATE TABLE `tbl_user` (
  `employeeid` varchar(100) NOT NULL,
  `fullname` varchar(100) NOT NULL,
  `acctype` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `status` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_user`
--

INSERT INTO `tbl_user` (`employeeid`, `fullname`, `acctype`, `username`, `password`, `status`) VALUES
('MR-123-001', 'Genesis S. La Rosa', 'admin', 'genlarosa', 'HEqF5sl2sliei9w5669BmaNUYIgN5JsKNMwjhMnD8l8=', 'active'),
('MR-123-002', 'Jamaica Anuba', 'teller', 'jamanuba', 'aYIFyGVe9Vw+7V5JX1jmsuHUB2e3ESxv3z2tSUpbGlk=', 'active'),
('MR-123-003', 'James Arpilang', 'admin', 'jamarpilang', 'fMpImDcinlAm2EZ/FETVdN1ON+xYXvdGV+HYCCEDODk=', 'onhold'),
('MR-123-004', 'Angel Cañete', 'teller', 'gelcañete', 'aZ4tnKqCLHHUSoBkD4GVSFAZ7FvxnTJWOWdPGNYjFPs=', 'onhold');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_customer`
--
ALTER TABLE `tbl_customer`
  ADD PRIMARY KEY (`cu_id`),
  ADD KEY `cu_moreinfo` (`cu_moreinfo`);

--
-- Indexes for table `tbl_customermore`
--
ALTER TABLE `tbl_customermore`
  ADD PRIMARY KEY (`more_id`);

--
-- Indexes for table `tbl_loyaltycard`
--
ALTER TABLE `tbl_loyaltycard`
  ADD PRIMARY KEY (`lo_cardno.`),
  ADD KEY `lo_name` (`lo_name`);

--
-- Indexes for table `tbl_receiver`
--
ALTER TABLE `tbl_receiver`
  ADD PRIMARY KEY (`re_id`),
  ADD KEY `re_name` (`re_name`);

--
-- Indexes for table `tbl_sender`
--
ALTER TABLE `tbl_sender`
  ADD PRIMARY KEY (`se_id`),
  ADD KEY `se_name` (`se_name`);

--
-- Indexes for table `tbl_transactions`
--
ALTER TABLE `tbl_transactions`
  ADD PRIMARY KEY (`tr_id`),
  ADD KEY `tr_senderinfo` (`tr_senderinfo`),
  ADD KEY `tr_receiverinfo` (`tr_receiverinfo`);

--
-- Indexes for table `tbl_user`
--
ALTER TABLE `tbl_user`
  ADD PRIMARY KEY (`employeeid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_customer`
--
ALTER TABLE `tbl_customer`
  MODIFY `cu_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `tbl_customermore`
--
ALTER TABLE `tbl_customermore`
  MODIFY `more_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbl_receiver`
--
ALTER TABLE `tbl_receiver`
  MODIFY `re_id` int(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_sender`
--
ALTER TABLE `tbl_sender`
  MODIFY `se_id` int(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbl_transactions`
--
ALTER TABLE `tbl_transactions`
  MODIFY `tr_id` int(20) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_customer`
--
ALTER TABLE `tbl_customer`
  ADD CONSTRAINT `tbl_customer_ibfk_1` FOREIGN KEY (`cu_moreinfo`) REFERENCES `tbl_customermore` (`more_id`);

--
-- Constraints for table `tbl_loyaltycard`
--
ALTER TABLE `tbl_loyaltycard`
  ADD CONSTRAINT `tbl_loyaltycard_ibfk_1` FOREIGN KEY (`lo_name`) REFERENCES `tbl_customer` (`cu_id`);

--
-- Constraints for table `tbl_receiver`
--
ALTER TABLE `tbl_receiver`
  ADD CONSTRAINT `tbl_receiver_ibfk_1` FOREIGN KEY (`re_name`) REFERENCES `tbl_customer` (`cu_id`);

--
-- Constraints for table `tbl_sender`
--
ALTER TABLE `tbl_sender`
  ADD CONSTRAINT `tbl_sender_ibfk_1` FOREIGN KEY (`se_name`) REFERENCES `tbl_customer` (`cu_id`);

--
-- Constraints for table `tbl_transactions`
--
ALTER TABLE `tbl_transactions`
  ADD CONSTRAINT `tbl_transactions_ibfk_1` FOREIGN KEY (`tr_senderinfo`) REFERENCES `tbl_sender` (`se_id`),
  ADD CONSTRAINT `tbl_transactions_ibfk_2` FOREIGN KEY (`tr_receiverinfo`) REFERENCES `tbl_receiver` (`re_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
