 CREATE TABLE
  customer
  (
      id bigint DEFAULT
 '0' NOT NULL,
      name VARCHAR(30),
      balance DOUBLE,
      PRIMARY KEY (id)
  )
  ENGINE=InnoDB DEFAULT
 CHARSET=latin1;
 
 
 insert into customer values(1,'chris vugrinec',3000);
insert into customer values(2,'jos fonteyn',3000);
