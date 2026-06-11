INSERT INTO customers(customer_id, customer_name)
VALUES (101,'Masthan');

INSERT INTO customers(customer_id, customer_name)
VALUES (102,'Suresh');

INSERT INTO customers(customer_id, customer_name)
VALUES (103,'John');


INSERT INTO transactions
(transaction_id, amount, transaction_date, customer_id)
VALUES (1,120,'2026-03-15',101);

INSERT INTO transactions
(transaction_id, amount, transaction_date, customer_id)
VALUES (2,90,'2026-04-11',101);

INSERT INTO transactions
(transaction_id, amount, transaction_date, customer_id)
VALUES (3,180,'2026-05-10',101);


INSERT INTO transactions
(transaction_id, amount, transaction_date, customer_id)
VALUES (4,110,'2026-03-20',102);

INSERT INTO transactions
(transaction_id, amount, transaction_date, customer_id)
VALUES (5,95,'2026-04-15',102);

INSERT INTO transactions
(transaction_id, amount, transaction_date, customer_id)
VALUES (6,160,'2026-05-20',102);


INSERT INTO transactions
(transaction_id, amount, transaction_date, customer_id)
VALUES (7,220,'2026-03-25',103);

INSERT INTO transactions
(transaction_id, amount, transaction_date, customer_id)
VALUES (8,75,'2026-04-18',103);

INSERT INTO transactions
(transaction_id, amount, transaction_date, customer_id)
VALUES (9,130,'2026-05-28',103);