Delete from customer;
Delete from account;

INSERT INTO customer
(`cpf`, `name`)
VALUES
("07698187487", "Ricardo de Melo");

INSERT INTO account
(`balance`, `number`, `customer_id`)
VALUES
(0, "123", (select id from `webbank`.`customer` where name = "Ricardo de Melo"));