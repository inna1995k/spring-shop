drop table if exists products cascade;
create table products (id bigserial, title varchar(255), description varchar(5000), price numeric(8, 2), primary key(id));
insert into products
(title, description, price) values
('Cheese', 'Fresh cheese', 320.0),
('Milk', 'Fresh milk', 80.0),
('Apples', 'Fresh apples', 80.0),
('Bread', 'Fresh bread', 30.0);

drop table if exists users;
create table users (
  id                    bigserial,
  phone                 VARCHAR(30) not null UNIQUE,
  password              VARCHAR(80) not null,
  PRIMARY KEY (id)
);

insert into users (phone, password)
values
('user','$2y$12$/9FHG0ExQCtTfuUdABy8PetuRy5HhTAvt6AsiCIoy5aU7.Kl6YpoO');


drop table if exists orders cascade;
create table orders (id bigserial, user_id bigint not null, primary key(id), constraint fk_user_id foreign key (user_id) references users (id));

drop table if exists items cascade;
create table items (id bigserial, product_id bigint not null, quantity int, price numeric(8, 2), primary key(id), constraint fk_prod_id foreign key (product_id) references products (id));

drop table if exists orders_items cascade;
create table order_items(id bigserial, order_id bigint not null, item_id bigint not null, primary key(id), constraint fk_order_items_id foreign key(order_id) references orders(id), constraint fk_item_id foreign key (item_id) references items(id));

alter table users add column age integer;

