
--Creo un usuario de cada tipo para la tabla
insert into users (user_id , password, role, user_name ) values ( nextval('erp.USER_ID_SEQ') , '0000', 'USER', 'Usuario1');
insert into users (user_id , password, role, user_name ) values ( nextval('erp.USER_ID_SEQ') , '0000', 'ADMIN', 'Admin1');
--Usuario ficticio para cuando eliminamos un usuario que es creador de algún/os prodcto/s
insert into users (user_id , password, role, user_name ) values (0 , '0000', 'USER', 'Usuario ficticio');

--Creo un supplier para pruebas
insert into suppliers (supplier_id, country, name) values (nextval('erp.SUPPLIER_ID_SEQ') , 'Spain', 'empresa s.l.');
--Supplier ficticio para cuando eliminamos un supplier que está en la lista de algún producto
insert into suppliers (supplier_id, country, name) values (0 , 'Sin País', 'Empresa Ficticia');

----Creo un producto para pruebas
insert into products (IDPRODUCT, CREATION_DATE, DESCRIPTION, ITEM_CODE, PRICE, REASON_DEACTIVATION, STATE, CREATOR)
values (nextval('erp.PRODUCT_ID_SEQ'), now(), 'producto de prueba', '0001', 22.95, null, 0, 1);
----Creo relación suppliers-products
insert into SUPPLIERS_PRODUCTS (ID_PRODUCT , ID_SUPPLIER) values (1, 1);

----Creo un PriceReduction para pruebas
insert into PRICE_REDUCTIONS (PRICE_REDUCTION_ID, DESCRIPTION, END_DATE, REDUCED_PRICE, START_DATE)
values(nextval('erp.PRICEREDUCTIONS_ID_SEQ'), 'descuento de prueba', '2030-01-01', 15.25, now());
----Creo relación products-priceReductions
insert into PRICE_REDUCTIONS_PRODUCTS (ID_PRODUCT, ID_PRICE_REDUCTION ) values (1,1);

--Price reduction ficticio para cuando eliminamos un supplier que está en la lista de algún producto
insert into PRICE_REDUCTIONS (PRICE_REDUCTION_ID, DESCRIPTION, END_DATE, REDUCED_PRICE, START_DATE)
values(0, 'descuento ficticio', '2030-01-01', 0.00, now());
