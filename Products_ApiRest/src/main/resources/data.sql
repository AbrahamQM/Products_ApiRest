
--Creo un usuario de cada tipo para la tabla
insert into users (user_id , password, role, user_name ) values ( nextval('erp.USER_ID_SEQ') , '0000', 'USER', 'Usuario1');
insert into users (user_id , password, role, user_name ) values ( nextval('erp.USER_ID_SEQ') , '0000', 'ADMIN', 'Admin1');
