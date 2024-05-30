-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 30, 2024 at 04:35 PM
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
(1, '09456916230'),
(2, '09456891230'),
(3, '09456365981'),
(4, '09295621923'),
(5, '09048621236'),
(6, '09397891010');

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
(6, 'Peritos', 'Jeralyn', '', 6, 'Male', 'Filipino', 'Bacay, Tulay, Minglanilla, Cebu', '2004-08-12', 'Minglanilla, Cebu', 'Married', 'Manager');

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
-- Table structure for table `tbl_transactions`
--

CREATE TABLE `tbl_transactions` (
  `tr_id` int(20) NOT NULL,
  `tr_sender` int(20) NOT NULL,
  `tr_senderno` int(20) NOT NULL,
  `tr_sendercard` varchar(20) NOT NULL,
  `tr_receiver` int(20) NOT NULL,
  `tr_receiverno` int(20) NOT NULL,
  `tr_receivercard` varchar(20) NOT NULL,
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
-- Indexes for table `tbl_contact`
--
ALTER TABLE `tbl_contact`
  ADD PRIMARY KEY (`co_id`);

--
-- Indexes for table `tbl_customer`
--
ALTER TABLE `tbl_customer`
  ADD PRIMARY KEY (`cu_id`),
  ADD KEY `cu_contact` (`cu_contact`);

--
-- Indexes for table `tbl_loyaltycard`
--
ALTER TABLE `tbl_loyaltycard`
  ADD PRIMARY KEY (`lo_cardno.`),
  ADD KEY `lo_name` (`lo_name`);

--
-- Indexes for table `tbl_transactions`
--
ALTER TABLE `tbl_transactions`
  ADD PRIMARY KEY (`tr_id`),
  ADD KEY `tr_senderinfo` (`tr_sender`),
  ADD KEY `tr_receiverinfo` (`tr_receiver`);

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
  MODIFY `co_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `tbl_customer`
--
ALTER TABLE `tbl_customer`
  MODIFY `cu_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

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
  ADD CONSTRAINT `tbl_customer_ibfk_1` FOREIGN KEY (`cu_contact`) REFERENCES `tbl_contact` (`co_id`);

--
-- Constraints for table `tbl_loyaltycard`
--
ALTER TABLE `tbl_loyaltycard`
  ADD CONSTRAINT `tbl_loyaltycard_ibfk_1` FOREIGN KEY (`lo_name`) REFERENCES `tbl_customer` (`cu_id`);

--
-- Constraints for table `tbl_transactions`
--
ALTER TABLE `tbl_transactions`
  ADD CONSTRAINT `tbl_transactions_ibfk_1` FOREIGN KEY (`tr_sender`) REFERENCES `tbl_customer` (`cu_id`),
  ADD CONSTRAINT `tbl_transactions_ibfk_2` FOREIGN KEY (`tr_receiver`) REFERENCES `tbl_customer` (`cu_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
