insert into user_details(id,birth_date,name)
values(10001,current_date(),'deb');

insert into user_details(id,birth_date,name)
values(10002,current_date(),'jithin');

insert into user_details(id,birth_date,name)
values(10003,current_date(),'nitha');

insert into post(id,description,user_id)
values(20001,'learning microservice',10001);

insert into post(id,description,user_id)
values(2000,'learning GCP',10002);

insert into post(id,description,user_id)
values(20003,'learning AWS',10003);