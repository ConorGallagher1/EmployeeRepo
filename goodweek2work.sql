DROP DATABASE if exists employee_StuartA;

create database employee_StuartA;

USE employee_StuartA;

DROP TABLE IF EXISTS department;
CREATE TABLE department (
	DepartmentID tinyint PRIMARY KEY AUTO_INCREMENT,
    DepartmentName varchar(30) NOT NULL
);

DROP TABLE IF EXISTS employee_info;
CREATE TABLE employee_info(
	EmployeeID int PRIMARY KEY AUTO_INCREMENT,
    Name varchar(100) NOT NULL,
    Address varchar(100) NOT NULL,
    NIN varchar(20) NOT NULL,
    BAN varchar (20) NOT NULL,
    StartingSalary decimal(10,2) NOT NULL,
    CurrentSalary decimal(10,2) NOT NULL,
    DepartmentID tinyint NOT NULL,
    FOREIGN KEY(DepartmentID) REFERENCES department(DepartmentID)
);
CREATE UNIQUE INDEX uniq_employee_emp_NIN ON employee_info(NIN);
CREATE UNIQUE INDEX uniq_employee_emp_BAN ON employee_info(BAN);


DROP TABLE IF EXISTS Sales_Employees;
CREATE TABLE Sales_Employees (
	EmployeeID int PRIMARY KEY AUTO_INCREMENT,
    FOREIGN KEY(EmployeeID) REFERENCES employee_info(EmployeeID), 
    CommissionRate decimal(5,2) NOT NULL, 
    totalSales decimal(10,2) NOT NULL
);

DROP TABLE IF EXISTS project;
CREATE TABLE project (
	ProjectID tinyint primary key auto_increment,
    ProjectName varchar(30) NOT NULL
);

DROP TABLE IF EXISTS employee_projects;
CREATE TABLE employee_projects (
	ProjectID tinyint NOT NULL,
    EmployeeID int NOT NULL,
    FOREIGN KEY(ProjectID) REFERENCES project(ProjectID),
    FOREIGN KEY(EmployeeID) REFERENCES employee_info(EmployeeID)
);

