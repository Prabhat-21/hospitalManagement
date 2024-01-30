CREATE DATABASE hospital_management;

create table users (
    id bigint not null AUTO_INCREMENT,
    username varchar(64) not null,
    password varchar(256) not null,
    primary key(id)
);

create table hospitals (
    id bigint not null AUTO_INCREMENT,
    external_id varchar(100) not null,
    name varchar(100) not null,
    primary key(id),
    UNIQUE KEY `hospitals_external_id_idx` (`external_id`)
);

create table rooms (
    id bigint not null AUTO_INCREMENT,
    external_id varchar(100) not null,
    name varchar(100) not null,
    hospital_id varchar(100) not null,
    primary key(id),
    UNIQUE KEY `rooms_external_id_idx` (`external_id`)
);

create table doctors (
    id bigint not null AUTO_INCREMENT,
    external_id varchar(100) not null,
    name varchar(100) not null,
    hospital_id varchar(100) not null,
    primary key(id),
    UNIQUE KEY `doctors_external_id_idx` (`external_id`)
);

create table patients (
    id bigint not null AUTO_INCREMENT,
    external_id varchar(100) not null,
    name varchar(100) not null,
    dob date not null,
    hospital_id varchar(100) not null,
    status varchar(20) not null,
    primary key(id),
    UNIQUE KEY `patients_external_id_idx` (`external_id`)
);

create table admissions (
    id bigint not null AUTO_INCREMENT,
    external_id varchar(100) not null,
    patient_id varchar(100) not null,
    room_id varchar(100) not null,
    doctor_id varchar(100) not null,
    admission_date date not null,
    discharge_date date default null,
    expense int not null,
    primary key(id),
    UNIQUE KEY `admissions_external_id_idx` (`external_id`)
);
