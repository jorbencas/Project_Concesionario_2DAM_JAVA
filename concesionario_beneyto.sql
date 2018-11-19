CREATE TABLE empleado
(
    id integer(3) PRIMARY KEY NOT NULL,
    tipo varChar(15),
    nombre varChar(15),
    primer_apellido varChar(25),
    segundo_apellido varChar(255),
    dni varChar(8),
    letra varchar(2),
    movil_1 varchar(9),
    movil_2 varChar(9),
    fijo varChar(9),
    tarjeta varChar(58)
);

CREATE TABLE vehiculo
(
    matricula varChar(58) PRIMARY KEY NOT NULL,
    tipo varChar(15),
    kilometros Integer(35),
    precio Integer(10),
    anyo Integer (4),
    marca varChar(25),
    modelo varChar(25),
    id_empleado int(3)
);

ALTER TABLE vehiculo
ADD FOREIGN KEY (id_empleado) REFERENCES empleado(id);


INSERT INTO empleado VALUES (0,"director","Alonso","Túria","Requena",56891231,'R',667895645,658457815,962396541,1),
(1,"vendedor","Juan","Doria", "Calasparra",36550124,'S',670514852,0,962653397,2),
(2,"vendedor","Pedro","López","Moreno",21894577,'H',666822360,666822111,0,2),
(3,"macanido","Fernando","Benavent","Perea",40231192,'T',671226003,0,962358941,3),
(4,"vendedor","Alberto","Martinez","Gonzalez",51745875,'J',666822458,0,0,3);

INSERT INTO vehiculo VALUES("2156DVF","turismo",23568,14000,2006,"Peugeot",407,4),
("5589GBH","furgoneta",16966,24500,2010,"Mercedes","Vito",2),
("8879BSD","turismo",85662,9000,2000,"Citroen","Wolskvagen",4);
