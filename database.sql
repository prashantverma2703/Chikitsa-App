/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.0.45-community-nt : Database - team1
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`team1` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_general_ci */;

USE `team1`;

/*Table structure for table `basic_detail` */

DROP TABLE IF EXISTS `basic_detail`;

CREATE TABLE `basic_detail` (
  `Aadhar_Id` int(12) NOT NULL,
  `Password` varchar(20) collate latin1_general_ci NOT NULL,
  `Name` varchar(30) collate latin1_general_ci default NULL,
  `DOB` date default NULL,
  `Gender` varchar(6) collate latin1_general_ci default NULL,
  `Address` varchar(100) collate latin1_general_ci default NULL,
  `Contact` int(12) default NULL,
  `usertype` varchar(15) collate latin1_general_ci default NULL,
  `City` varchar(20) collate latin1_general_ci default NULL,
  `Emp_Id` varchar(12) collate latin1_general_ci default NULL,
  `Experience` int(2) default NULL,
  `Status` varchar(10) collate latin1_general_ci default NULL,
  PRIMARY KEY  (`Aadhar_Id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

/*Data for the table `basic_detail` */

insert  into `basic_detail`(`Aadhar_Id`,`Password`,`Name`,`DOB`,`Gender`,`Address`,`Contact`,`usertype`,`City`,`Emp_Id`,`Experience`,`Status`) values (1234567,'123','Ravi','2018-10-01','male','4A 104 New Mahada colony, Nr. Union Bank, Powai',1234567,'admin',NULL,NULL,NULL,NULL),(1234569,'123','prashant','2018-10-01','male','4A 104 New Mahada colony, Nr. Union Bank, Powai',1234567,'doctor',NULL,NULL,NULL,NULL);

/*Table structure for table `task_manager` */

DROP TABLE IF EXISTS `task_manager`;

CREATE TABLE `task_manager` (
  `Task_No` varchar(10) collate latin1_general_ci default NULL,
  `Assignee_DoctorId` varchar(20) collate latin1_general_ci default NULL,
  `Status` varchar(10) collate latin1_general_ci default NULL,
  `Registration_Date` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `Resolved_Date` datetime default NULL,
  `Description` varchar(50) collate latin1_general_ci default NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

/*Data for the table `task_manager` */

insert  into `task_manager`(`Task_No`,`Assignee_DoctorId`,`Status`,`Registration_Date`,`Resolved_Date`,`Description`) values ('CHK01','1234567','in contact','2018-10-13 13:36:08','2018-10-18 22:39:21','priscription added'),('CHK02','1234569','pending','2018-10-13 13:36:30','2018-10-25 22:40:29','NA');

/*Table structure for table `ticket` */

DROP TABLE IF EXISTS `ticket`;

CREATE TABLE `ticket` (
  `Doctor_Aadhar_ID` int(12) NOT NULL,
  `Patient_Aadhar_ID` int(12) NOT NULL,
  `Task_ID` varchar(10) collate latin1_general_ci NOT NULL,
  `Illeness_Type` varchar(20) collate latin1_general_ci default NULL,
  `Symptoms` varchar(50) collate latin1_general_ci default NULL,
  `Duration` int(5) default NULL,
  `Medication` varchar(70) collate latin1_general_ci default NULL,
  `Medical Histrory` varchar(200) collate latin1_general_ci default NULL,
  `Generic History` varchar(200) collate latin1_general_ci default NULL,
  `Severity` varchar(200) collate latin1_general_ci default NULL,
  `Regoistration_Date` timestamp NULL default NULL,
  PRIMARY KEY  (`Task_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

/*Data for the table `ticket` */

insert  into `ticket`(`Doctor_Aadhar_ID`,`Patient_Aadhar_ID`,`Task_ID`,`Illeness_Type`,`Symptoms`,`Duration`,`Medication`,`Medical Histrory`,`Generic History`,`Severity`,`Regoistration_Date`) values (1234567,0,'CHK01','ABC','ABC',5,'NA','NA','Na','ABC','2018-10-11 22:41:59'),(1234569,0,'CHK02','ABC','ABC',5,'Na','NA','Na','ABC','2018-10-12 22:42:02');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
