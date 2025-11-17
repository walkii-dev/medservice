create table patients(
    id VARCHAR(50) PRIMARY KEY UNIQUE NOT NULL,
    firstName VARCHAR(50) NOT NULL,
    lastName VARCHAR(100) NOT NULL,
    cpf VARCHAR(15) NOT NULL
)