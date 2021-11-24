-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Nov 23, 2021 at 11:30 AM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `flightreservation`
--

-- --------------------------------------------------------

--
-- Table structure for table `Flight`
--

CREATE TABLE `Flight` (
  `flightId` int(11) NOT NULL,
  `flightNumber` varchar(20) NOT NULL,
  `operatingAirlines` varchar(20) NOT NULL,
  `departureCity` varchar(20) NOT NULL,
  `arrivalCity` varchar(20) NOT NULL,
  `dateOfDeparture` date NOT NULL,
  `estimatedDepartureTime` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Flight`
--

INSERT INTO `Flight` (`flightId`, `flightNumber`, `operatingAirlines`, `departureCity`, `arrivalCity`, `dateOfDeparture`, `estimatedDepartureTime`) VALUES
(1, 'AA1', 'American Airlines', 'AUS', 'NYC', '2018-02-05', '2018-02-04 22:14:07'),
(2, 'AA2', 'American Airlines', 'AUS', 'NYC', '2018-02-05', '2018-02-05 00:14:07'),
(3, 'AA3', 'American Airlines', 'AUS', 'NYC', '2018-02-05', '2018-02-05 01:14:07'),
(4, 'SW1', 'South West', 'AUS', 'NYC', '2018-02-05', '2018-02-05 02:14:07'),
(5, 'UA1', 'United Airlines', 'NYC', 'DAL', '2018-02-05', '2018-02-05 05:14:07'),
(6, 'UA1', 'United Airlines', 'NYC', 'DAL', '2018-02-05', '2018-02-05 05:14:07'),
(7, 'SW1', 'South West', 'AUS', 'NYC', '2018-02-06', '2018-02-06 02:14:07'),
(8, 'SW2', 'South West', 'AUS', 'NYC', '2018-02-06', '2018-02-06 03:14:07'),
(9, 'SW3', 'South West', 'NYC', 'DAL', '2018-02-06', '2018-02-06 05:14:07'),
(10, 'UA1', 'United Airlines', 'NYC', 'DAL', '2018-02-06', '2018-02-06 05:14:07');

-- --------------------------------------------------------

--
-- Table structure for table `Passenger`
--

CREATE TABLE `Passenger` (
  `passengerId` int(11) NOT NULL,
  `passengerFirstName` varchar(256) DEFAULT 'none',
  `passengerLastName` varchar(256) DEFAULT 'none',
  `passengerMiddleName` varchar(256) DEFAULT 'none',
  `passengerEmail` varchar(50) NOT NULL,
  `passengerPhone` varchar(15) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Passenger`
--

INSERT INTO `Passenger` (`passengerId`, `passengerFirstName`, `passengerLastName`, `passengerMiddleName`, `passengerEmail`, `passengerPhone`) VALUES
(1, 'Mohammad Fawad', 'Bhatti', 'none', 'm.mohammadfawad@gmail.com', '03000874407'),
(2, 'Mohammad Fawad', 'Bhatti', 'none', 'm.mohammadfawad@gmail.com', '03000874407'),
(3, 'Mohammad Fawad', 'Bhatti', 'none', 'm.mohammadfawad@gmail.com', '00923000874407'),
(4, 'Mohammad Fawad', 'Bhatti', 'none', 'm.mohammadfawad@gmail.com', '00923000874407'),
(5, 'Mohammad Fawad', 'Bhatti', 'none', 'm.mohammadfawad@gmail.com', '00923000874407'),
(6, 'Mohammad Junaid', 'Bhatti', 'none', 'm.mohammadfawad@gmail.com', '00923000874407'),
(7, 'Mohammad Junaid', 'Bhatti', 'none', 'm.mohammadfawad@gmail.com', '00923000874407'),
(8, 'Mohammad Junaid', 'Bhatti', 'none', 'm.mohammadfawad@gmail.com', '00923000874407'),
(9, 'Mohammad Asif', 'rana', 'none', 'm.mohammadfawad@gmail.com', '03000874407'),
(10, 'Mohammad Asif', 'rana', 'none', 'm.mohammadfawad@gmail.com', '03000874407'),
(11, 'Mohammad Jawad', 'Bhatti', 'none', 'm.mohammadfawad@gmail.com', '03000874407'),
(12, 'raja raiz ', 'Kundi', 'none', 'm.mohammadfawad@gmail.com', '03000874407'),
(13, 'Mohammad Ali', 'Shah', 'none', 'm.mohammadfawad@gmail.com', '03000874407'),
(14, 'Mohammad Ali', 'Shah', 'none', 'm.mohammadfawad@gmail.com', '03000874407'),
(15, 'Rana Tanveer', 'Anwar', 'none', 'm.mohammadfawad@gmail.com', '0300874407'),
(16, 'Ahmad khan', 'Tareen', 'none', 'm.mohammadfawad@gmail.com', '03000874407'),
(17, 'Ajmal Khattak', 'Ahmadzai', 'none', 'm.mohammadfawad@gmail.com', '03000874407'),
(18, 'Ajmal Khattak', 'Ahmadzai', 'none', 'm.mohammadfawad@gmail.com', '03000874407'),
(19, 'Ajmal Kaka', 'Ahmadzai', NULL, 'm.mohammadfawad@gmail.com', '03000874407'),
(20, 'Raja Maan', 'Jorge', NULL, 'm.mohammadfawad@gmail.com', '03000874407'),
(21, 'Mohammad Ali', 'Bhatti', NULL, 'm.mohammadfawad@gmail.com', '03000874407'),
(22, 'Rana Ijaz', 'Tanoli', NULL, 'm.mohammadfawad@gmail.com', '03000874407'),
(23, 'Mir Afzal', 'Ahmadzai', NULL, 'm.mohammadfawad@gmail.com', '03000874407'),
(24, 'Ali Hassan', 'Chuhaan', NULL, 'm.mohammadfawad@gmail.com', '03000874407'),
(25, 'Rizwan Ali', 'khan', NULL, 'm.mohammadfawad@gmail.com', '03000874407');

-- --------------------------------------------------------

--
-- Table structure for table `Reservation`
--

CREATE TABLE `Reservation` (
  `reservationId` int(11) NOT NULL,
  `reservationCheckedIn` tinyint(1) DEFAULT NULL,
  `reservationNumberOfBags` int(11) DEFAULT 0,
  `reservationPassengerId` int(11) DEFAULT NULL,
  `reservationFlightId` int(11) DEFAULT NULL,
  `CREATED` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Reservation`
--

INSERT INTO `Reservation` (`reservationId`, `reservationCheckedIn`, `reservationNumberOfBags`, `reservationPassengerId`, `reservationFlightId`, `CREATED`) VALUES
(1, 1, 3, 2, 4, '2021-10-31 07:38:55'),
(2, 1, 5, 3, 2, '2021-10-31 07:50:07'),
(3, 1, 6, 4, 2, '2021-10-31 07:54:20'),
(4, 1, 3, 5, 2, '2021-10-31 07:57:03'),
(5, 1, 5, 6, 3, '2021-10-31 13:52:12'),
(6, 0, 0, 7, 3, '2021-10-31 14:10:16'),
(7, 0, 0, 8, 3, '2021-10-31 14:12:44'),
(8, 0, 0, 9, 4, '2021-10-31 14:15:50'),
(9, 0, 0, 10, 4, '2021-10-31 14:22:46'),
(10, 0, 0, 11, 2, '2021-11-05 02:32:14'),
(11, 0, 0, 12, 2, '2021-11-05 04:59:21'),
(12, 0, 0, 13, 1, '2021-11-06 03:45:00'),
(13, 0, 0, 14, 1, '2021-11-06 03:45:33'),
(14, 0, 0, 15, 10, '2021-11-06 03:49:01'),
(15, 0, 0, 16, 9, '2021-11-06 04:06:52'),
(16, 0, 0, 17, 1, '2021-11-12 04:08:10'),
(17, 0, 0, 18, 1, '2021-11-12 04:10:18'),
(18, 0, 0, 19, 1, '2021-11-12 04:20:32'),
(19, 1, 6, 20, 4, '2021-11-12 04:37:17'),
(20, 0, NULL, 21, 4, '2021-11-15 15:20:53'),
(21, 0, NULL, 22, 2, '2021-11-15 15:27:31'),
(22, 0, NULL, 23, 2, '2021-11-15 15:35:45'),
(23, 0, NULL, 24, 2, '2021-11-17 05:51:46'),
(24, 1, 5, 25, 3, '2021-11-20 04:43:44');

-- --------------------------------------------------------

--
-- Table structure for table `User`
--

CREATE TABLE `User` (
  `userId` int(11) NOT NULL,
  `userFirstName` varchar(50) DEFAULT NULL,
  `userLastName` varchar(50) DEFAULT NULL,
  `userEmail` varchar(50) DEFAULT NULL,
  `userPassword` varchar(256) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `User`
--

INSERT INTO `User` (`userId`, `userFirstName`, `userLastName`, `userEmail`, `userPassword`) VALUES
(3, 'Mohammad Waqas', 'Mirza', 'waqas@gmail.com', '123456'),
(4, 'Mohammad Fawad', 'Bhatti', 'm.mohammadfawad@gmail.com', 'test'),
(6, 'Mohammad Fawad', 'Bhatti', 'fawad@gmail.com', 'test123'),
(7, 'Mohammad Fawad', 'Bhatti', 'mfawad@gmail.com', '123456'),
(8, 'Mohammad Ramzan', 'Sargohda', 'ramzan@gmail.com', 'test123'),
(9, 'Mohammad Mustehsan', 'Bhatti', 'mustehsan@gmail.com', 'fawad123'),
(10, 'Mohammad Ali', 'junajo', 'junajo@gmail.com', 'junajo@@'),
(11, 'Rana Tanveer', 'Anwar', 'tanveer@gmail.com', '1234tanveer');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Flight`
--
ALTER TABLE `Flight`
  ADD PRIMARY KEY (`flightId`);

--
-- Indexes for table `Passenger`
--
ALTER TABLE `Passenger`
  ADD PRIMARY KEY (`passengerId`);

--
-- Indexes for table `Reservation`
--
ALTER TABLE `Reservation`
  ADD PRIMARY KEY (`reservationId`),
  ADD KEY `reservationPassengerId` (`reservationPassengerId`),
  ADD KEY `reservationFlightId` (`reservationFlightId`);

--
-- Indexes for table `User`
--
ALTER TABLE `User`
  ADD PRIMARY KEY (`userId`),
  ADD UNIQUE KEY `userEmail` (`userEmail`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Flight`
--
ALTER TABLE `Flight`
  MODIFY `flightId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `Passenger`
--
ALTER TABLE `Passenger`
  MODIFY `passengerId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `Reservation`
--
ALTER TABLE `Reservation`
  MODIFY `reservationId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `User`
--
ALTER TABLE `User`
  MODIFY `userId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Reservation`
--
ALTER TABLE `Reservation`
  ADD CONSTRAINT `Reservation_ibfk_1` FOREIGN KEY (`reservationPassengerId`) REFERENCES `Passenger` (`passengerId`) ON DELETE CASCADE,
  ADD CONSTRAINT `Reservation_ibfk_2` FOREIGN KEY (`reservationFlightId`) REFERENCES `Flight` (`flightId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
