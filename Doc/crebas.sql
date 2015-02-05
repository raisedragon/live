/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2015/1/22 17:27:35                           */
/*==============================================================*/


drop table if exists USR_ACCOUNT;

drop table if exists USR_ACCOUNT_ROLE;

drop table if exists USR_CONTACT;

drop table if exists USR_ROLE;

drop table if exists USR_USER;

/*==============================================================*/
/* Table: USR_ACCOUNT                                           */
/*==============================================================*/
create table USR_ACCOUNT
(
   ID_                  bigint not null comment 'ID',
   ACCOUNT_             varchar(64) not null comment '账号',
   PASSWORD_            varchar(64) not null comment '密码',
   STATUS_              char(8) comment '状态',
   primary key (ID_)
);

alter table USR_ACCOUNT comment '账号信息';

/*==============================================================*/
/* Table: USR_ACCOUNT_ROLE                                      */
/*==============================================================*/
create table USR_ACCOUNT_ROLE
(
   ID_                  bigint not null comment 'ID',
   ACCOUNT_ID_          bigint comment '账号ID',
   ROLE_ID_             bigint not null comment '角色ID',
   STATUS_              char(8) not null comment '状态',
   primary key (ID_)
);

alter table USR_ACCOUNT_ROLE comment '账号角色关系';

/*==============================================================*/
/* Table: USR_CONTACT                                           */
/*==============================================================*/
create table USR_CONTACT
(
   ID_                  bigint not null comment 'ID',
   FIRST_NAME_          varchar(64) not null comment '用户ID',
   COUNTRY_             varchar(64) comment '国家',
   STATE_               varchar(64) comment '省份',
   CITY_                varchar(64) comment '城市',
   ADDRESS1_            varchar(64) comment '地址1',
   ADDRESS2_            varchar(64) comment '地址2',
   ADDRESS3_            varchar(64) comment '地址3',
   HOUSE_NO_            varchar(64) comment '门牌号',
   PHONE_               varchar(64) comment '电话',
   EMAIL_               varchar(64) comment '邮件',
   FAX_                 varchar(64) comment '传真',
   primary key (ID_)
);

alter table USR_CONTACT comment '联系信息';

/*==============================================================*/
/* Table: USR_ROLE                                              */
/*==============================================================*/
create table USR_ROLE
(
   ID_                  bigint not null comment 'ID',
   NAME_                varchar(64) not null comment '角色名',
   DESCRIPTION_         varchar(64) comment '描述',
   STATUS_              char(8) not null comment '状态',
   primary key (ID_)
);

alter table USR_ROLE comment '角色信息';

/*==============================================================*/
/* Table: USR_USER                                              */
/*==============================================================*/
create table USR_USER
(
   ID_                  bigint not null comment 'ID',
   FIRST_NAME_          varchar(64) not null comment '名字',
   LAST_NAME_           varchar(64) not null comment '姓',
   BIRTHDAY_            date comment '出生日期',
   GENDER_              char(1) comment '性别',
   ACCOUNT_ID_          bigint comment '账号ID',
   primary key (ID_)
);

alter table USR_USER comment '用户信息';

alter table USR_ACCOUNT_ROLE add constraint FK_FK_ACC_ROLE_ROLE foreign key (ACCOUNT_ID_)
      references USR_ACCOUNT (ID_) on delete restrict on update restrict;

alter table USR_ACCOUNT_ROLE add constraint FK_FK_ACC_ROLE_ROLE foreign key (ROLE_ID_)
      references USR_ROLE (ID_) on delete restrict on update restrict;

alter table USR_CONTACT add constraint FK_FK_CONTACT_USER foreign key (FIRST_NAME_)
      references USR_USER (ID_) on delete restrict on update restrict;

alter table USR_USER add constraint FK_FK_USER_ACC foreign key (ACCOUNT_ID_)
      references USR_ACCOUNT (ID_) on delete restrict on update restrict;

