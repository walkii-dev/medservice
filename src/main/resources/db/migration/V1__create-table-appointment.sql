CREATE TABLE consultas (
  id INT NOT NULL AUTO_INCREMENT,
  medico VARCHAR(100) NOT NULL,
  paciente VARCHAR(100) NOT NULL,
  data_consulta DATE NOT NULL,
  clima VARCHAR(100),
  observacao VARCHAR(100)

  PRIMARY_KEY(id)

);