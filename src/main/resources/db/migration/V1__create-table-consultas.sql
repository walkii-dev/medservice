CREATE TABLE consultas (
    id INT NOT NULL AUTO_INCREMENT,
    medic VARCHAR(100) NOT NULL,
    patient VARCHAR(100) NOT NULL,
    appointment_date_and_hour DATE NOT NULL,
    weather VARCHAR(100),
    observations VARCHAR(100),
    PRIMARY KEY (id)
);