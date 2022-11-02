
--Creo un usuario de cada tipo para la tabla
insert into users (user_id , password, role, user_name ) values ( nextval('erp.USER_ID_SEQ') , '0000', 'USER', 'Usuario1');
insert into users (user_id , password, role, user_name ) values ( nextval('erp.USER_ID_SEQ') , '0000', 'ADMIN', 'Admin1');

--Creo un supplier para pruebas
insert into suppliers (supplier_id, country, name) values (nextval('erp.SUPPLIER_ID_SEQ') , 'Spain', 'empresa s.l.');

----Creo un producto para pruebas
insert into products (IDPRODUCT, CREATION_DATE, DESCRIPTION, ITEM_CODE, PRICE, REASON_DEACTIVATION, STATE, CREATOR)
values (nextval('erp.PRODUCT_ID_SEQ'), now(), 'producto de prueba', '0001', 22.95, null, 0, 1);
--
----Creo relación suppliers-products
insert into SUPPLIERS_PRODUCTS (ID_PRODUCT , ID_SUPPLIER) values (1, 1);