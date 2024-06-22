-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 22, 2024 at 05:24 PM
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
-- Table structure for table `tbl_contact`
--

CREATE TABLE `tbl_contact` (
  `co_id` int(20) NOT NULL,
  `co_number` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_contact`
--

INSERT INTO `tbl_contact` (`co_id`, `co_number`) VALUES
(7, ''),
(5, '09048621236'),
(17, '09123123123'),
(8, '09123456789'),
(12, '0912456789'),
(18, '09147147147'),
(4, '09295621923'),
(6, '09397891010'),
(16, '09456123789'),
(3, '09456365981'),
(2, '09456891230'),
(1, '09456916230'),
(13, '09789456123'),
(19, '09789456124'),
(9, '09789456132'),
(10, '0978945623'),
(11, '0987654321'),
(14, '09963852741'),
(15, '09987654321');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_customer`
--

CREATE TABLE `tbl_customer` (
  `cu_id` int(20) NOT NULL,
  `cu_lname` varchar(100) NOT NULL,
  `cu_fname` varchar(100) NOT NULL,
  `cu_mname` varchar(100) NOT NULL,
  `cu_contact` int(20) NOT NULL,
  `cu_gender` varchar(100) NOT NULL,
  `cu_nationality` varchar(100) NOT NULL,
  `cu_address` varchar(100) NOT NULL,
  `cu_birthdate` date NOT NULL,
  `cu_birthplace` varchar(100) NOT NULL,
  `cu_marital` varchar(100) NOT NULL,
  `cu_occupation` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_customer`
--

INSERT INTO `tbl_customer` (`cu_id`, `cu_lname`, `cu_fname`, `cu_mname`, `cu_contact`, `cu_gender`, `cu_nationality`, `cu_address`, `cu_birthdate`, `cu_birthplace`, `cu_marital`, `cu_occupation`) VALUES
(1, 'Nacua', 'Princess', 'none', 1, 'Female', 'Filipino', 'Lower Calajo-an, Minglanilla, Cebu', '2003-03-12', 'Minglanilla, Cebu', 'Single', 'student'),
(2, 'Caparas', 'Heath', 'none', 2, 'Male', 'Filipino', 'Cadulawan, Minglanilla, Cebu', '2024-05-29', 'Cebu, City', 'Single', 'Photographer'),
(3, 'Anuba', 'Jamaica', 'none', 3, 'female', 'Spy', 'City of Talisay', '2003-11-05', 'City of Talisay', 'Single', 'Student'),
(4, 'Arpilang', 'James', 'none', 4, 'Male', 'Filipino', 'Tabunok, City of Talisay, Cebu', '2000-08-12', 'Mindanao', 'Separated', 'Janitor'),
(5, 'Cañete', 'Angel', 'Ibalarrosa', 5, 'female', 'Filipino', 'Cogon, City of Naga, Cebu', '2003-04-27', 'Minglanilla District Hospital', 'Married', 'Housewife'),
(6, 'Peritos', 'Jeralyn', '', 6, 'Male', 'Filipino', 'Bacay, Tulay, Minglanilla, Cebu', '2004-08-12', 'Minglanilla, Cebu', 'Married', 'Manager'),
(9, 'Tulfo', 'Raffy', 'temp', 12, 'temp', 'temp', 'temp', '1111-11-11', 'temp', 'temp', 'temp'),
(10, 'Sedicol', 'Glezeil', 'temp', 14, 'temp', 'temp', 'temp', '1111-11-11', 'temp', 'temp', 'temp'),
(11, 'Franza', 'Erwin', 'temp', 15, 'temp', 'temp', 'temp', '1111-11-11', 'temp', 'temp', 'temp'),
(12, 'La Rosa', 'Genesis', 'temp', 8, 'temp', 'temp', 'temp', '1111-11-11', 'temp', 'temp', 'temp'),
(13, 'larosa', 'gen', 'null', 8, 'null', 'null', 'null', '0111-11-11', 'null', 'null', 'null'),
(15, 'Clamonte', 'Jimuel', 'null', 17, 'null', 'null', 'null', '0111-11-11', 'null', 'null', 'null'),
(16, 'Laparan', 'John Dave', '', 18, '', '', '', '0111-11-11', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_transactions`
--

CREATE TABLE `tbl_transactions` (
  `tr_id` int(20) NOT NULL,
  `tr_type` varchar(20) NOT NULL,
  `tr_code` varchar(100) NOT NULL,
  `tr_customer` int(20) NOT NULL,
  `tr_customerno` int(20) NOT NULL,
  `tr_counterparty` int(20) NOT NULL,
  `tr_counterpartyno` int(20) NOT NULL,
  `tr_location` varchar(100) NOT NULL,
  `tr_relation` varchar(100) NOT NULL,
  `tr_purpose` varchar(100) NOT NULL,
  `tr_amount` decimal(10,0) NOT NULL,
  `tr_fee` decimal(10,0) NOT NULL,
  `tr_total` decimal(10,0) NOT NULL,
  `tr_when` datetime(6) DEFAULT NULL,
  `tr_teller` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_transactions`
--

INSERT INTO `tbl_transactions` (`tr_id`, `tr_type`, `tr_code`, `tr_customer`, `tr_customerno`, `tr_counterparty`, `tr_counterpartyno`, `tr_location`, `tr_relation`, `tr_purpose`, `tr_amount`, `tr_fee`, `tr_total`, `tr_when`, `tr_teller`) VALUES
(11, 'Send', 'PGB-509-211', 16, 13, 4, 14, 'Anywhere in the Philippines', 'agawg', 'fgaweg', 3000, 60, 3060, '2024-06-06 13:47:49.000000', 'MR-123-002'),
(13, 'Send', 'LGZ-420-463', 12, 13, 4, 8, 'Anywhere in the Philippines', 'Classmate', 'Tuition', 2000, 40, 2040, '2024-06-16 15:50:47.000000', 'MR-123-002'),
(16, 'Send', 'YKM-886-550', 12, 13, 13, 8, 'Anywhere in the Philippines', 'Brother', 'credit', 1000, 20, 1020, '2024-06-16 21:08:39.000000', 'MR-123-002'),
(17, 'Receive', 'LGZ-420-463', 12, 13, 4, 8, 'Anywhere in the Philippines', 'Classmate', 'Tuition', 2000, 40, 2040, '2024-06-22 17:06:17.000000', 'MR-123-002'),
(18, 'Receive', 'LGZ-420-463', 4, 8, 12, 13, 'Anywhere in the Philippines', 'Classmate', 'Tuition', 2000, 40, 2040, '2024-06-22 17:19:38.000000', 'MR-123-002'),
(19, 'Receive', 'LGZ-420-463', 4, 8, 12, 13, 'Anywhere in the Philippines', 'Classmate', 'Tuition', 2000, 40, 2040, '2024-06-22 17:19:47.000000', 'MR-123-002'),
(20, 'Receive', 'YKM-886-550', 13, 8, 12, 13, 'Anywhere in the Philippines', 'Brother', 'credit', 1000, 20, 1020, '2024-06-22 17:55:07.000000', 'MR-123-002'),
(21, 'Send', 'OWF-081-799', 3, 13, 6, 19, 'Anywhere in the Philippines', 'Sisters', 'Lending', 1000, 20, 1020, '2024-06-22 19:45:32.000000', 'MR-123-002'),
(22, 'Receive', 'OWF-081-799', 6, 19, 3, 13, 'Anywhere in the Philippines', 'Sisters', 'Lending', 1000, 20, 1020, '2024-06-22 19:48:33.000000', 'MR-123-002');

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
('MR-123-004', 'Angel Cañete', 'teller', 'gelcañete', 'aZ4tnKqCLHHUSoBkD4GVSFAZ7FvxnTJWOWdPGNYjFPs=', 'active');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_contact`
--
ALTER TABLE `tbl_contact`
  ADD PRIMARY KEY (`co_id`),
  ADD UNIQUE KEY `co_number` (`co_number`);

--
-- Indexes for table `tbl_customer`
--
ALTER TABLE `tbl_customer`
  ADD PRIMARY KEY (`cu_id`),
  ADD KEY `cu_contact` (`cu_contact`);

--
-- Indexes for table `tbl_transactions`
--
ALTER TABLE `tbl_transactions`
  ADD PRIMARY KEY (`tr_id`),
  ADD KEY `tr_senderinfo` (`tr_customer`),
  ADD KEY `tr_receiverinfo` (`tr_counterparty`),
  ADD KEY `tr_teller` (`tr_teller`);

--
-- Indexes for table `tbl_user`
--
ALTER TABLE `tbl_user`
  ADD PRIMARY KEY (`employeeid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_contact`
--
ALTER TABLE `tbl_contact`
  MODIFY `co_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `tbl_customer`
--
ALTER TABLE `tbl_customer`
  MODIFY `cu_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `tbl_transactions`
--
ALTER TABLE `tbl_transactions`
  MODIFY `tr_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_customer`
--
ALTER TABLE `tbl_customer`
  ADD CONSTRAINT `tbl_customer_ibfk_1` FOREIGN KEY (`cu_contact`) REFERENCES `tbl_contact` (`co_id`);

--
-- Constraints for table `tbl_transactions`
--
ALTER TABLE `tbl_transactions`
  ADD CONSTRAINT `tbl_transactions_ibfk_1` FOREIGN KEY (`tr_customer`) REFERENCES `tbl_customer` (`cu_id`),
  ADD CONSTRAINT `tbl_transactions_ibfk_2` FOREIGN KEY (`tr_counterparty`) REFERENCES `tbl_customer` (`cu_id`),
  ADD CONSTRAINT `tbl_transactions_ibfk_3` FOREIGN KEY (`tr_teller`) REFERENCES `tbl_user` (`employeeid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
