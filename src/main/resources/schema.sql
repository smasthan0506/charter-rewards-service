CREATE TABLE customers(
	customer_id BIGINT PRIMARY KEY,
	customer_name VARCHAR(100) NOT NULL
);

CREATE TABLE transactions(
	transaction_id BIGINT PRIMARY KEY,
	amount DOUBLE,
	transaction_date DATE,
	customer_id BIGINT,
	FOREIGN KEY (customer_id)
	REFERENCES customers(customer_id)
);