CREATE TABLE Pessoa (
    cpf integer NOT NULL PRIMARY KEY,
    nome varchar(70) NOT NULL,
    data_nascimento date NULL,
    telefone integer NULL,
);

create table Funcionario (
funcionarioID integer IDENTITY (1 , 1)  PRIMARY KEY,
cpf integer FOREIGN KEY REFERENCES Pessoa(cpf),
data_entrada date NOT NULL,
);

create table Produto (
ProdutoID integer IDENTITY (1 , 1)  PRIMARY KEY,
nome varchar(70) NOT NULL,
preco float NOT NULL,
);

create table Quarto (
quartoID integer IDENTITY (1 , 1)  PRIMARY KEY,
estrelas integer NOT NULL,
preco float NOT NULL,
produtos integer FOREIGN KEY REFERENCES Produto(ProdutoID),
quantidade integer NOT NULL,
);


create table Cliente (
clienteID integer IDENTITY (1 , 1)  PRIMARY KEY,
cpf integer FOREIGN KEY REFERENCES Pessoa(cpf),
entrada date NOT NULL,
saida date NOT NULL,
suite integer FOREIGN KEY REFERENCES Quarto(quartoID),
);


