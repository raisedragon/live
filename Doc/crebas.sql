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
   ACCOUNT_             varchar(64) not null comment '�˺�',
   PASSWORD_            varchar(64) not null comment '����',
   STATUS_              char(8) comment '״̬',
   primary key (ID_)
);

alter table USR_ACCOUNT comment '�˺���Ϣ';

/*==============================================================*/
/* Table: USR_ACCOUNT_ROLE                                      */
/*==============================================================*/
create table USR_ACCOUNT_ROLE
(
   ID_                  bigint not null comment 'ID',
   ACCOUNT_ID_          bigint comment '�˺�ID',
   ROLE_ID_             bigint not null comment '��ɫID',
   STATUS_              char(8) not null comment '״̬',
   primary key (ID_)
);

alter table USR_ACCOUNT_ROLE comment '�˺Ž�ɫ��ϵ';

/*==============================================================*/
/* Table: USR_CONTACT                                           */
/*==============================================================*/
create table USR_CONTACT
(
   ID_                  bigint not null comment 'ID',
   FIRST_NAME_          varchar(64) not null comment '�û�ID',
   COUNTRY_             varchar(64) comment '����',
   STATE_               varchar(64) comment 'ʡ��',
   CITY_                varchar(64) comment '����',
   ADDRESS1_            varchar(64) comment '��ַ1',
   ADDRESS2_            varchar(64) comment '��ַ2',
   ADDRESS3_            varchar(64) comment '��ַ3',
   HOUSE_NO_            varchar(64) comment '���ƺ�',
   PHONE_               varchar(64) comment '�绰',
   EMAIL_               varchar(64) comment '�ʼ�',
   FAX_                 varchar(64) comment '����',
   primary key (ID_)
);

alter table USR_CONTACT comment '��ϵ��Ϣ';

/*==============================================================*/
/* Table: USR_ROLE                                              */
/*==============================================================*/
create table USR_ROLE
(
   ID_                  bigint not null comment 'ID',
   NAME_                varchar(64) not null comment '��ɫ��',
   DESCRIPTION_         varchar(64) comment '����',
   STATUS_              char(8) not null comment '״̬',
   primary key (ID_)
);

alter table USR_ROLE comment '��ɫ��Ϣ';

/*==============================================================*/
/* Table: USR_USER                                              */
/*==============================================================*/
create table USR_USER
(
   ID_                  bigint not null comment 'ID',
   FIRST_NAME_          varchar(64) not null comment '����',
   LAST_NAME_           varchar(64) not null comment '��',
   BIRTHDAY_            date comment '��������',
   GENDER_              char(1) comment '�Ա�',
   ACCOUNT_ID_          bigint comment '�˺�ID',
   primary key (ID_)
);

alter table USR_USER comment '�û���Ϣ';

alter table USR_ACCOUNT_ROLE add constraint FK_FK_ACC_ROLE_ROLE foreign key (ACCOUNT_ID_)
      references USR_ACCOUNT (ID_) on delete restrict on update restrict;

alter table USR_ACCOUNT_ROLE add constraint FK_FK_ACC_ROLE_ROLE foreign key (ROLE_ID_)
      references USR_ROLE (ID_) on delete restrict on update restrict;

alter table USR_CONTACT add constraint FK_FK_CONTACT_USER foreign key (FIRST_NAME_)
      references USR_USER (ID_) on delete restrict on update restrict;

alter table USR_USER add constraint FK_FK_USER_ACC foreign key (ACCOUNT_ID_)
      references USR_ACCOUNT (ID_) on delete restrict on update restrict;

