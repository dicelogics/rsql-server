DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS orders;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(250) NOT NULL,
    age INT NOT NULL
);
CREATE TABLE orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(250) NOT NULL,
    price INT NOT NULL,
    order_date TIMESTAMP NOT NULL,
    user_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id)
);


INSERT INTO users(id, name, age)
VALUES
    (1, 'John', 20),
    (2, 'Steve', 25),
    (3, 'Joe', 18),
    (4, 'Daniel', 56);

INSERT INTO orders (id, title, price, order_date, user_id)
VALUES
    (11, 'Order 1. User 1', 110, '2020-01-12', 1),
    (12, 'Order 2. User 1', 210, '2020-02-10', 1),
    (13, 'Order 3. User 1', 1010, '2020-01-01', 1),
    (21, 'Order 1. User 2', 300, '2020-03-10', 2),
    (22, 'Order 2. User 2', 300, '2020-02-10', 2),
    (31, 'Order 1. User 3', 1010, '2020-04-01',3),
    (32, 'Order 2. User 3', 110, '2020-02-14', 3),
    (41, 'Order 1. User 4', 333, '2020-01-01', 4);

