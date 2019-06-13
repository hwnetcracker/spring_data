INSERT INTO customers(last_name, district, sale) VALUES('Куликов', 'Нижегородский', 0.1);
INSERT INTO customers(last_name, district, sale) VALUES('Лапин', 'Канавинский', 0);
INSERT INTO customers(last_name, district, sale) VALUES('Мымрин', 'Ленинский', 0.1);
INSERT INTO customers(last_name, district, sale) VALUES('Макаров', 'Сормово', 0);


INSERT INTO shops(name, district, commission) VALUES('Дирижабль', 'Нижегородский', 4);
INSERT INTO shops(name, district, commission) VALUES('Дирижабль', 'Канавинский', 10);
INSERT INTO shops(name, district, commission) VALUES('Дирижабль', 'Ленинский', 5);
INSERT INTO shops(name, district, commission) VALUES('Дирижабль', 'Сормово', 5);

INSERT INTO books (name, price, storage, count) VALUES('искусство программирования. том 1', 1000, 'Нижегородский', 10);
INSERT INTO books (name, price, storage, count) VALUES('искусство программирования. том 2', 1000, 'Канавинский', 10);
INSERT INTO books (name, price, storage, count) VALUES('искусство программирования. том 3', 1000, 'Ленинский', 10);
INSERT INTO books (name, price, storage, count) VALUES('искусство программирования. том 4', 1000, 'Сормово', 10);


INSERT INTO orders(date, seller, customer, book, count, cost) VALUES('2019-01-01', 1, 1, 1, 1, 1000);
INSERT INTO orders(date, seller, customer, book, count, cost) VALUES('2019-02-02', 4, 2, 2, 1, 1000);
INSERT INTO orders(date, seller, customer, book, count, cost) VALUES('2019-03-03', 1, 3, 3, 1, 1000);
INSERT INTO orders(date, seller, customer, book, count, cost) VALUES('2019-04-04', 2, 3, 4, 1, 1000);