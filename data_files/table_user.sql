-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jan 11, 2023 at 03:07 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.0.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `test`
--

-- --------------------------------------------------------

--
-- Table structure for table `table_user`
--

CREATE TABLE `table_user` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL,
  `image` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `table_user`
--

INSERT INTO `table_user` (`id`, `name`, `image`) VALUES
(1, 'Prasanth', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ7qzIoa5pSr-SFUeHM57UpGfWxZXrz3zTIB5vdIeEHh88gcms1SLF0-jEMhS0xuOoAfF0&usqp=CAU'),
(2, 'Prasanth', 'https://1000logos.net/wp-content/uploads/2016/10/Android-Logo-500x313.png'),
(3, 'Prasanth', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ7qzIoa5pSr-SFUeHM57UpGfWxZXrz3zTIB5vdIeEHh88gcms1SLF0-jEMhS0xuOoAfF0&usqp=CAU'),
(4, 'Prasanth', 'https://1000logos.net/wp-content/uploads/2016/10/Android-Logo-500x313.png'),
(5, 'Prasanth', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ7qzIoa5pSr-SFUeHM57UpGfWxZXrz3zTIB5vdIeEHh88gcms1SLF0-jEMhS0xuOoAfF0&usqp=CAU'),
(6, 'Prasanth', 'https://1000logos.net/wp-content/uploads/2016/10/Android-Logo-500x313.png'),
(7, 'Prasanth', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ7qzIoa5pSr-SFUeHM57UpGfWxZXrz3zTIB5vdIeEHh88gcms1SLF0-jEMhS0xuOoAfF0&usqp=CAU'),
(8, 'Prasanth', 'https://1000logos.net/wp-content/uploads/2016/10/Android-Logo-500x313.png'),
(9, 'Prasanth', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ7qzIoa5pSr-SFUeHM57UpGfWxZXrz3zTIB5vdIeEHh88gcms1SLF0-jEMhS0xuOoAfF0&usqp=CAU'),
(10, 'Prasanth', 'https://1000logos.net/wp-content/uploads/2016/10/Android-Logo-500x313.png'),
(11, 'Prasanth', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ7qzIoa5pSr-SFUeHM57UpGfWxZXrz3zTIB5vdIeEHh88gcms1SLF0-jEMhS0xuOoAfF0&usqp=CAU'),
(12, 'Prasanth', 'https://1000logos.net/wp-content/uploads/2016/10/Android-Logo-500x313.png'),
(13, 'Prasanth', 'https://1000logos.net/wp-content/uploads/2016/10/Android-Logo-500x313.png'),
(14, 'Prasanth', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ7qzIoa5pSr-SFUeHM57UpGfWxZXrz3zTIB5vdIeEHh88gcms1SLF0-jEMhS0xuOoAfF0&usqp=CAU'),
(15, 'Prasanth', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ7qzIoa5pSr-SFUeHM57UpGfWxZXrz3zTIB5vdIeEHh88gcms1SLF0-jEMhS0xuOoAfF0&usqp=CAU');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `table_user`
--
ALTER TABLE `table_user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `table_user`
--
ALTER TABLE `table_user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
