drop table if exists Administrator cascade;
drop table if exists Doctor cascade;
drop table if exists MedicalProcedure cascade;
drop table if exists Patient cascade;
drop table if exists MedicalInformation cascade;
drop table if exists Receptionist cascade;
drop table if exists Appointment cascade;
drop table if exists HealthInsuranceCheck cascade;
drop table if exists TransactionConfirmation cascade;

create table Administrator (
    AdminID int primary key,
    FirstName text not null,
    LastName text not null,
    SSN decimal(9,0) not null,
    DateOfBirth date not null,
    StreetAddress text not null,
    City text not null,
    State char(2) not null,
    ZipCode decimal(5,0) not null,
    PhoneNumber decimal(10,0) not null
);

create table Doctor (
    DoctorID int primary key,
    FirstName text not null,
    LastName text not null,
    SSN decimal(9,0) not null,
    DateOfBirth date not null,
    StreetAddress text not null,
    City text not null,
    State char(2) not null,
    ZipCode decimal(5,0) not null,
    PhoneNumber decimal(10,0) not null,
    AdminID int not null,
    constraint DoctorFK foreign key (AdminID) references 
    	Administrator(AdminID)
);

create table MedicalProcedure (
    ProcedureCode int primary key,
    ProcedureName text not null,
    CostOfProcedure decimal(5,2) not null,
    DoctorID int not null,
    constraint MedicalProcedureFK foreign key (DoctorID) references
    	Doctor(DoctorID)
);

create table Patient (
    PatientID int primary key,
    FirstName text not null,
    LastName text not null,
    SSN decimal(9,0) not null,
    DateOfBirth date not null,
    StreetAddress text not null,
    City text not null,
    State char(2) not null,
    ZipCode decimal(5,0) not null,
    PhoneNumber decimal(10,0) not null,
    InsuranceProvider text not null,
    DoctorID int not null,
    constraint PatientFK foreign key (DoctorID) references
    	Doctor(DoctorID)
);

create table MedicalInformation (
    MedicalInfoNumber int primary key,
    PastProcedure text not null,
    Symptom text not null,
    Prescription text not null,
    PatientID int not null,
    constraint MedicalInfoFK foreign key (PatientID) references
    	Patient(PatientID)
);

create table Receptionist (
    ReceptionistID int primary key,
    FirstName text not null,
    LastName text not null,
    SSN decimal(9,0) not null,
    DateOfBirth date not null,
    StreetAddress text not null,
    City text not null,
    State char(2) not null,
    ZipCode decimal(5,0) not null,
    PhoneNumber decimal(10,0) not null
);

create table Appointment (
    AppointmentID int primary key,
    AppointmentDate date not null,
    AppointmentTime time not null,
    ReceptionistID int not null,
    PatientID int not null,
    DoctorID int not null,
    ProcedureCode int not null,
    constraint AppointmentFK1 foreign key (ReceptionistID) references
    	Receptionist(ReceptionistID),
    constraint AppointmentFK2 foreign key (PatientID) references 
    	Patient(PatientID),
    constraint AppointmentFK3 foreign key (DoctorID) references 
    	Doctor(DoctorID),
    constraint AppointmentFK4 foreign key (ProcedureCode) references
    	MedicalProcedure(ProcedureCode)
);

create table HealthInsuranceCheck (
    CheckNumber bigint not null,
    RoutingNumber bigint not null,
    CheckDate date not null,
    CheckTotal decimal(5,2) not null,
    InsuranceProvider text not null,
    AmountRemaining decimal(5,2) not null,
    ReceptionistID int not null,
    constraint HealthCheckPK primary key (CheckNumber, RoutingNumber),
    constraint HealthCheckFK1 foreign key (ReceptionistID) references
    	Receptionist(ReceptionistID)
);

create table TransactionConfirmation (
    TransactionNumber int primary key,
    PaymentMethod text not null,
    Change decimal(5,2) not null,
    AmountRemaining decimal(5,2) not null,
    DateOfService date not null,
    Adjustment decimal(5,2) not null,
    InsuranceProvider text not null,
    PatientID int not null,
    ProcedureCode int not null,
    ReceptionistID int not null,
    CheckNumber bigint not null,
    RoutingNumber bigint not null,
    constraint TransactionFK1 foreign key (PatientID) references
    	Patient(PatientID),
    constraint TransactionFK2 foreign key (ProcedureCode) references
    	MedicalProcedure(ProcedureCode),
    constraint TransactionFK3 foreign key (ReceptionistID) references 
    	Receptionist(ReceptionistID),
    constraint TransactionFK4 foreign key (CheckNumber, RoutingNumber) references
    	HealthInsuranceCheck(CheckNumber, RoutingNumber)
);

select * from Administrator;
select * from Doctor;
select * from Patient;
select * from Receptionist;
select * from MedicalProcedure;
select * from MedicalInformation;
select * from Appointment;
select * from HealthInsuranceCheck;
select * from TransactionConfirmation;


