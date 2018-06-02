-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jun 02, 2018 at 06:22 PM
-- Server version: 10.2.12-MariaDB
-- PHP Version: 7.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `id5856905_vizyan`
--

-- --------------------------------------------------------

--
-- Table structure for table `vizyan`
--

CREATE TABLE `vizyan` (
  `id` int(11) NOT NULL,
  `name` varchar(1024) COLLATE utf8_unicode_ci NOT NULL,
  `merk` varchar(1024) COLLATE utf8_unicode_ci NOT NULL,
  `model` varchar(1024) COLLATE utf8_unicode_ci NOT NULL,
  `year` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `vizyan`
--

INSERT INTO `vizyan` (`id`, `name`, `merk`, `model`, `year`) VALUES
(1, 'Brio', 'Honda', 'Sedan', '2012'),
(3, 'Civic', 'Honda', 'Sedan', '2016');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `vizyan`
--
ALTER TABLE `vizyan`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `vizyan`
--
ALTER TABLE `vizyan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
