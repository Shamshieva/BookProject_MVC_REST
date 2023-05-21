insert into users (id,email, password, role, first_name, last_name, phone_number)
values (1, 'admin@gmai.com', '$2a$12$rDjMLuLWSLuVwHGXjH5G8ulw/JlMR9mZxK2ejPPryiyFz9mYhpMeW', 'ADMIN',    'Админ', 'Админов', '+996708281123'),
       (2, 'burulai@gmai.com', '$2a$12$m49jDeGHD.NgLjV8QvvRFOOIPSukF/..fjTn582XV5.MF3cYNexAC', 'ADMIN',  'Burulai', 'Urbaeva', '+996990550724'),
       (3, 'eliza@gmai.com', '$2a$12$QqvBUCA9tHjBBZ6wcALb9epDUEZYAJEUlh5c8.BuRkE4j4LsxG3Z6', 'CUSTOMER', 'Элиза', 'Аширалиева', '+996708281789'),
       (4, 'ishkak@gmai.com', '$2a$12$77UEkv8SDulio8t6Wkjz4Owpy7jCYrjScQULwLWo/Ck4CKAO02uIS', 'CUSTOMER', 'Исхак', 'Абдухамидов', '+996708281312'),
       (5, 'uluk@gmai.com', '$2a$12$gd.MYsPeoBxGsiCqpCJGcOSsPN00bIgMpAd0VfOtWzLDx./M.LIFy', 'CUSTOMER',  'Улук', 'Исманов', '+996708281334'),
       (6, 'kulen@gmai.com', '$2a$12$2Yvz76h6ipGW5y9ekz8vL.b2JvgCzCjwX7Fu56JFYnjMvrGqsqmPy', 'CUSTOMER', 'Kulen', 'Urbaeva', '+996708281123');


insert into applications (id, date, phone_number, accepted, user_id)
VALUES (1, '2023-04-15', '+996709990099', true, 1),
       (2, '2023-04-16', '+996709990099', false, 2);


insert into vendor (id, first_name, last_name, description, image, is_active, created_at)
values (1, 'Titus', 'Camilletti', 'Macaca nemestrina', 'Bupropion hydrochloride', false, '2023-05-11'),
       (2, 'Merissa', 'Roles', 'Laniarius ferrugineus', 'HOMOSALATENE, OCTOCRYLENE', false, '2023-05-11'),
       (3, 'Bowie', 'Maypother', 'Cervus duvauceli', ' CRUDE, GOLDENSEAL,SALIX NIGRA BARK', true, '2023-05-11'),
       (4, 'Edgar', 'Gorvette', 'Egretta thula', 'Treatment Set TS332487', false, '2023-05-11'),
       (5, 'Vivien', 'Guinness', 'Iguana iguana', 'Mirtazapine', true, '2023-05-11');

insert into book (id, title, author, description, price, image, published_date, owner_id)
values (1, 'Cairistiona', 'Kassel', 'Monkey, rhesus', 51, 'Snake (unidentified)', '2023-05-11', 1),
       (2, 'Jakie', 'Carbery', 'Black-tailed tree creeper', 94, 'Otter, oriental short-clawed', '2023-05-11', 2),
       (3, 'Bruno', 'Langforth', 'Boar, wild', 70, 'Australian masked owl', '2023-05-11', 3),
       (4, 'Nixie', 'Colomb', 'Square-lipped rhinoceros', 43, 'Rattlesnake, horned', '2023-05-11', 4),
       (5, 'Elicia', 'Creaney', 'Wallaby, euro', 83, 'Frilled dragon', '2023-05-11', 5);



insert into transactions (id, buyer_id, vendor_id, book_id, transaction_date)
values (1, 1, 1, 1, '2023-05-11'),
       (2, 2, 2, 2, '2023-05-11'),
       (3, 3, 3, 3, '2023-05-11'),
       (4, 4, 4, 4, '2023-05-11'),
       (5, 5, 5, 5, '2023-05-11');




