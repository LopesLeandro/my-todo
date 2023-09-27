USE BancoFinanceiro;
CREATE TABLE Gastos (
    ID int AUTO_INCREMENT PRIMARY KEY,
    Data date,
    FormadePagamento varchar(255),
    TipoGasto varchar(255),
    Valor decimal(10,2)
);

SELECT * FROM Gastos;