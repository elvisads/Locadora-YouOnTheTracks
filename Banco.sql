CREATE DATABASE locadora; 

USE locadora;

CREATE TABLE veiculos 
  ( 
     placa     VARCHAR(8) PRIMARY KEY NOT NULL, 
     marca     VARCHAR(25) NOT NULL, 
     cor       VARCHAR(10) NOT NULL, 
     portas    VARCHAR(1) NOT NULL, 
     ano       VARCHAR(4) NOT NULL, 
     preco     INT (10) NOT NULL, 
     categoria VARCHAR (5) NOT NULL, 
     classe    VARCHAR(1) NOT NULL, 
     alugado   VARCHAR(1) DEFAULT 'N' 
  ); 

INSERT INTO veiculos 
            (placa, 
             marca, 
             cor, 
             portas, 
             ano, 
             preco, 
             categoria, 
             classe, 
             alugado) 
VALUES      ('1234', 
             'Gol', 
             'Cinza', 
             '4', 
             '2020', 
             100.00, 
             'Sedan', 
             'A', 
             'N'); 