-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 19, 2024 at 08:47 PM
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
-- Database: `aimee_mizero_uwase_ams_grpb`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `fname` varchar(255) DEFAULT NULL,
  `lname` varchar(255) DEFAULT NULL,
  `id_number` varchar(20) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `martial_status` varchar(29) DEFAULT NULL,
  `DOB` varchar(30) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`fname`, `lname`, `id_number`, `phone`, `gender`, `martial_status`, `DOB`, `email`, `password`) VALUES
('WERTYUU', 'KLIHJYGFR', '123456', '9876543', 'Female', 'SINGLE', '18999', 'WW@gmail.com', '9876'),
('UWASE Mizero ', 'Aimee', '1200270176189174', '0789831553', 'Female', 'single', '2002-02-18', 'uwasemizeroaimee@gmail.com', 'mizero@1'),
('diane ', 'uwamahoro', '12368909876543', '078953667', 'Female', 'SINGLE', '23-7-2001', 'dianeuw@gmail.com', '6565');

-- --------------------------------------------------------

--
-- Table structure for table `artifact`
--

CREATE TABLE `artifact` (
  `Artifact_id` int(10) NOT NULL,
  `Name` varchar(150) DEFAULT NULL,
  `Description` varchar(290) DEFAULT NULL,
  `Artifactdate` datetime DEFAULT NULL,
  `Orgin` varchar(290) DEFAULT NULL,
  `Materials` varchar(190) DEFAULT NULL,
  `CultureSignificance` varchar(290) DEFAULT NULL,
  `Site_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `artifact`
--

INSERT INTO `artifact` (`Artifact_id`, `Name`, `Description`, `Artifactdate`, `Orgin`, `Materials`, `CultureSignificance`, `Site_id`) VALUES
(1, 'nyabubugog', 'bus place', '1987-08-09 00:00:00', 'hgh', 'fdg House', 'hfdd', 1);

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

CREATE TABLE `booking` (
  `Booking_id` int(10) NOT NULL,
  `SiteName` varchar(140) DEFAULT NULL,
  `CheckinDate` datetime DEFAULT NULL,
  `CheckoutDate` datetime DEFAULT NULL,
  `TotalPrice` decimal(65,0) DEFAULT NULL,
  `visitor_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `booking`
--

INSERT INTO `booking` (`Booking_id`, `SiteName`, `CheckinDate`, `CheckoutDate`, `TotalPrice`, `visitor_id`) VALUES
(1, 'Genocide memorial site', '2011-09-09 00:00:00', '2011-09-11 00:00:00', 3000, 3);

-- --------------------------------------------------------

--
-- Table structure for table `conservationrecord`
--

CREATE TABLE `conservationrecord` (
  `ConservationRecord_id` int(10) NOT NULL,
  `Conservator` varchar(150) DEFAULT NULL,
  `Conservationdate` datetime DEFAULT NULL,
  `TreatmentDescription` varchar(500) DEFAULT NULL,
  `Artifact_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `conservationrecord`
--

INSERT INTO `conservationrecord` (`ConservationRecord_id`, `Conservator`, `Conservationdate`, `TreatmentDescription`, `Artifact_id`) VALUES
(2, 'Kanyana Anick', '2000-09-09 00:00:00', 'thfdvhjgej', 1);

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `Payment_id` int(10) NOT NULL,
  `Amount` decimal(50,0) DEFAULT NULL,
  `PaymentDate` datetime DEFAULT NULL,
  `PaymentMethod` varchar(150) DEFAULT NULL,
  `Booking_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`Payment_id`, `Amount`, `PaymentDate`, `PaymentMethod`, `Booking_id`) VALUES
(1, 333, '2000-06-07 00:00:00', 'AirtelMoney', 1);

-- --------------------------------------------------------

--
-- Table structure for table `site`
--

CREATE TABLE `site` (
  `Site_id` int(10) NOT NULL,
  `SiteName` varchar(150) DEFAULT NULL,
  `Location` varchar(180) DEFAULT NULL,
  `HistoricalPreiod` varchar(200) DEFAULT NULL,
  `Description` varchar(290) DEFAULT NULL,
  `PreservationStatus` varchar(190) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `site`
--

INSERT INTO `site` (`Site_id`, `SiteName`, `Location`, `HistoricalPreiod`, `Description`, `PreservationStatus`) VALUES
(1, 'nyabugog', 'nyarugenge', '2005', 'picking bus place', 'treatmentwell'),
(2, 'King palace(rukari)', 'sourth-Nyanza', '1845', 'this place hold an excellent history in rwanda for the king and inyambo', ' well treatment this place'),
(8, 'yttyt', 'ytrtytrty', '777', 'yuyu', 'kjhghj');

-- --------------------------------------------------------

--
-- Table structure for table `visitor`
--

CREATE TABLE `visitor` (
  `Visitor_id` int(10) NOT NULL,
  `VName` varchar(690) DEFAULT NULL,
  `Location` varchar(690) DEFAULT NULL,
  `Gender` varchar(150) DEFAULT NULL,
  `Email` varchar(190) DEFAULT NULL,
  `PhoneNumber` varchar(190) DEFAULT NULL,
  `Site_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `visitor`
--

INSERT INTO `visitor` (`Visitor_id`, `VName`, `Location`, `Gender`, `Email`, `PhoneNumber`, `Site_id`) VALUES
(2, 'Umuhoza corine', 'kigali-Rwanda', 'Female', 'corineu@gmail.com', '+250789544757', 2),
(3, 'Alvin Christian', 'Nairobi-Kenya', 'Male', 'chrisAlvin@gmail.com', '+2547856403223', 2),
(4, 'Rwamatwara Loic David', 'Musanze', 'Male', 'rwamatwarald@gmail.com', '0788883456', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `artifact`
--
ALTER TABLE `artifact`
  ADD PRIMARY KEY (`Artifact_id`),
  ADD KEY `Site_id` (`Site_id`);

--
-- Indexes for table `booking`
--
ALTER TABLE `booking`
  ADD PRIMARY KEY (`Booking_id`),
  ADD KEY `visitor_id` (`visitor_id`);

--
-- Indexes for table `conservationrecord`
--
ALTER TABLE `conservationrecord`
  ADD PRIMARY KEY (`ConservationRecord_id`),
  ADD KEY `Artifact_id` (`Artifact_id`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`Payment_id`),
  ADD KEY `Booking_id` (`Booking_id`);

--
-- Indexes for table `site`
--
ALTER TABLE `site`
  ADD PRIMARY KEY (`Site_id`);

--
-- Indexes for table `visitor`
--
ALTER TABLE `visitor`
  ADD PRIMARY KEY (`Visitor_id`),
  ADD KEY `Site_id` (`Site_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `artifact`
--
ALTER TABLE `artifact`
  MODIFY `Artifact_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `booking`
--
ALTER TABLE `booking`
  MODIFY `Booking_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `conservationrecord`
--
ALTER TABLE `conservationrecord`
  MODIFY `ConservationRecord_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `Payment_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `site`
--
ALTER TABLE `site`
  MODIFY `Site_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `visitor`
--
ALTER TABLE `visitor`
  MODIFY `Visitor_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `artifact`
--
ALTER TABLE `artifact`
  ADD CONSTRAINT `artifact_ibfk_1` FOREIGN KEY (`Site_id`) REFERENCES `site` (`Site_id`);

--
-- Constraints for table `booking`
--
ALTER TABLE `booking`
  ADD CONSTRAINT `booking_ibfk_1` FOREIGN KEY (`visitor_id`) REFERENCES `visitor` (`Visitor_id`);

--
-- Constraints for table `conservationrecord`
--
ALTER TABLE `conservationrecord`
  ADD CONSTRAINT `conservationrecord_ibfk_1` FOREIGN KEY (`Artifact_id`) REFERENCES `artifact` (`Artifact_id`);

--
-- Constraints for table `payment`
--
ALTER TABLE `payment`
  ADD CONSTRAINT `payment_ibfk_1` FOREIGN KEY (`Booking_id`) REFERENCES `booking` (`Booking_id`);

--
-- Constraints for table `visitor`
--
ALTER TABLE `visitor`
  ADD CONSTRAINT `visitor_ibfk_1` FOREIGN KEY (`Site_id`) REFERENCES `site` (`Site_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
