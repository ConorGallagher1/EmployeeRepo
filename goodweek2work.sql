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


DROP TABLE IF EXISTS sales_employees;
CREATE TABLE sales_employees (
	EmployeeID int PRIMARY KEY AUTO_INCREMENT,
    FOREIGN KEY(EmployeeID) REFERENCES employee_info(EmployeeID), 
    CommissionRate decimal(5,2) NOT NULL, 
    TotalSales decimal(10,2) NOT NULL
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

INSERT INTO department (DepartmentName) VALUES 
    ('Finance'),
    ('Sales'),
    ('Manager'),
    ('HR'),
    ('Employee');
    
    
INSERT INTO employee_info (Name, Address, NIN, BAN, StartingSalary, CurrentSalary, DepartmentID) VALUES 
    ('Bob Joe', '747 Evergreen Terrace', 012345678, 7474838294, 08000, 12000, 1),
    ('Bob John', '70 Uppa Terrace', 93848555, 47446294, 91000, 120000, 2),
    ('John Smith', '7 Terrace', 01345678, 838294, 83450, 12500, 3),
    ('John Doe', '747 Evergreen Terrace', 018255678, 747138293, 08000, 12000, 4),
    ('Bubba Jabba', '747 Evergreen Terrace', 054345678, 7474678294, 09000, 12900, 5);
    
    
        
    INSERT INTO sales_employees (CommissionRate, TotalSales) VALUES 
    (12000, 250000),
    (08000, 20000),
    (10000, 80000),
    (15000, 10000),
    ('Employee', 50000);
    
        
    INSERT INTO project (ProjectID, ProjectName) VALUES 
    (1, 'The Kainos project'),
    (2, 'The super Kainos project'),
    (3, 'The kainos project that remains unfinished'),
    (4, 'The ultra hyper kainos project'),
    (5, 'The dead mans land Kainos project, good luck');
    
    INSERT INTO employee_projects (ProjectID, EmployeeID) VALUES
		(1, 1),
        (2, 2),
        (3, 3),
        (4, 4),
        (5, 5);
    
    SELECT * FROM employee_info;
    SELECT * FROM department;
    SELECT * FROM sales_employees;
    SELECT * FROM project;
    SELECT * FROM employee_projects;
