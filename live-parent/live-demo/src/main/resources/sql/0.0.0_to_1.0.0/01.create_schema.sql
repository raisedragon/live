/*==============================================================*/
/* Database name:  VMS                                          */
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2015/1/29 16:09:16                           */
/*==============================================================*/


drop database if exists VMS;

/*==============================================================*/
/* Database: VMS                                                */
/*==============================================================*/
create database VMS;

use VMS;

/*==============================================================*/
/* Table: VMS_AD_SING_POST_SHIPPING_NO                          */
/*==============================================================*/
create table VMS_AD_SING_POST_SHIPPING_NO
(
   ID                   bigint not null auto_increment comment 'ID',
   SHIPPING_NO          varchar(16) comment '快递单号',
   IS_VALID             char(1) comment '是否可用',
   ORGANIZATION_ID      bigint not null comment '组织ID',
   CREATED              timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   CREATEDBY            char(32) not null default '0' comment '创建人',
   UPDATED              timestamp not null comment '更新时间',
   UPDATEDBY            char(32) not null comment '更新人',
   IS_ACTIVE            char(1) not null default 'Y' comment '是否有效',
   IS_DELETE            char(1) not null default 'N' comment '是否删除',
   primary key (ID)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

alter table VMS_AD_SING_POST_SHIPPING_NO comment '新邮快递单号';

/*==============================================================*/
/* Table: VMS_SHM_MANIFEST                                      */
/*==============================================================*/
create table VMS_SHM_MANIFEST
(
   ID                   bigint(20) not null auto_increment comment 'ID',
   MANIFEST_NO          varchar(32) not null comment '发货单号',
   VENDOR_CODE          varchar(32) comment '供应商代码',
   PRODUCT_CODE         varchar(32) comment '供应商产品代码',
   VENDER_MANIFEST_NO   varchar(32) comment '供应商发货单号',
   PATH                 varchar(256) comment '路径',
   STATUS               char(8) not null comment '状态',
   ORGANIZATION_ID      bigint not null comment '组织ID',
   CREATED              timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   CREATEDBY            char(32) not null default '0' comment '创建人',
   UPDATED              timestamp not null comment '更新时间',
   UPDATEDBY            char(32) not null comment '更新人',
   IS_ACTIVE            char(1) not null default 'Y' comment '是否有效',
   IS_DELETE            char(1) not null default 'N' comment '是否删除',
   primary key (ID)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

alter table VMS_SHM_MANIFEST comment '运输发货单';

/*==============================================================*/
/* Index: IDX_MANIFEST_NO                                       */
/*==============================================================*/
create unique index IDX_MANIFEST_NO on VMS_SHM_MANIFEST
(
   MANIFEST_NO
);

/*==============================================================*/
/* Table: VMS_SHM_ORDER                                         */
/*==============================================================*/
create table VMS_SHM_ORDER
(
   ID                   bigint(20) not null auto_increment comment 'ID',
   DOCUMENT_NO          varchar(32) comment '订单流水号',
   ORDER_NO             varchar(32) not null comment '运输单号',
   VENDOR_ORDER_NO      varchar(32) comment '供应商运输单号',
   ORDER_STATUS         varchar(16) not null comment 'INI:初始状态,
            LGF:面单抓取失败,
            LGC:面单抓取成功,
            PSF:交接清单发送失败,
            PSC:交接清单发送成功,
            DLI:派送中,
            HPO:移交邮局,
            LLM:海外派送单品丢失,
            DLC:派送完成,
            VO:作废',
   VENDOR_CODE          varchar(32) comment '供应商代码',
   PRODUCT_CODE         varchar(32) comment '供应商产品代码',
   REAL_LENGTH          decimal(12,2) comment '实际长',
   REAL_WIDTH           decimal(12,2) comment '实际宽',
   REAL_HEIGHT          decimal(12,2) comment '实际高',
   REAL_VOLUME          decimal(19,9) comment '实际体积',
   REAL_WEIGHT          decimal(14,4) comment '实际重量',
   MANIFEST_NO          varchar(32) comment '发货单号',
   PRE_ADVICE_PATH      varchar(256) comment '预报路径',
   NAME                 varchar(64) not null comment '姓名',
   COUNTRY_CODE         varchar(2) not null comment '国家代码',
   STATE                varchar(64) comment '洲',
   CITY                 varchar(64) not null comment '城市',
   POSTCODE             varchar(16) comment '邮编',
   ADDRESS1             varchar(128) not null comment '地址1',
   ADDRESS2             varchar(128) comment '地址2',
   ADDRESS3             varchar(128) comment '地址3',
   HOUSE_NUMBER         varchar(50) comment '门牌号',
   PHONE                varchar(32) comment '电话号码',
   EMAIL                varchar(64) comment '邮箱地址',
   VENDOR_MANIFEST_NO   varchar(32) comment '供应商发货单号',
   LOGISTICS_DIST       varchar(32) comment '物流分区',
   IS_CALLBACK          char(1) default 'N' comment '是否反写',
   CALC_PAYABLE_STATUS  VARCHAR(8) not null comment 'INI:未计算,
            RDY:就绪,
            CAF:计算成本失败,
            CAC:计算成本成功',
   ACCOUNTING_DATE      timestamp default '0000-00-00 00:00:00' comment '记账日期',
   ORGANIZATION_ID      bigint not null comment '组织ID',
   CREATED              timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   CREATEDBY            char(32) not null default '0' comment '创建人',
   UPDATED              timestamp not null comment '更新时间',
   UPDATEDBY            char(32) not null comment '更新人',
   IS_ACTIVE            char(1) not null default 'Y' comment '是否有效',
   IS_DELETE            char(1) not null default 'N' comment '是否删除',
   primary key (ID)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

alter table VMS_SHM_ORDER comment '运输订单';

/*==============================================================*/
/* Index: IDX_ORDER_DOCUMENTNO                                  */
/*==============================================================*/
create unique index IDX_ORDER_DOCUMENTNO on VMS_SHM_ORDER
(
   DOCUMENT_NO
);

/*==============================================================*/
/* Index: IDX_ORDER_NO                                          */
/*==============================================================*/
create unique index IDX_ORDER_NO on VMS_SHM_ORDER
(
   ORDER_NO
);

/*==============================================================*/
/* Table: VMS_SHM_ORDER_PARCEL                                  */
/*==============================================================*/
create table VMS_SHM_ORDER_PARCEL
(
   ID                   bigint(20) not null auto_increment comment 'ID',
   ORDER_NO             varchar(32) not null comment '运输订单号',
   PARCEL_NO            varchar(32) not null comment '包裹号',
   PRODUCT_CODE         varchar(32) not null comment '产品代码',
   VENDER_SHIPPING_NO   varchar(32) comment '供应商运单号',
   LENGTH               decimal(12,2) comment '长',
   WIDTH                decimal(12,2) comment '宽',
   HEIGHT               decimal(12,2) comment '高',
   WEIGHT               decimal(14,4) comment '重量',
   REAL_LENGTH          decimal(12,2) comment '实际长',
   REAL_WIDTH           decimal(12,2) comment '实际宽',
   REAL_VOLUME          decimal(19,9) comment '实际体积',
   REAL_HEIGHT          decimal(12,2) comment '实际高',
   REAL_WEIGHT          decimal(14,4) comment '实际重量',
   DECLARE_NAME         varchar(256) comment '申报名称',
   VALUE                decimal(12,2) comment '申报价值',
   CURRENCY_UNIT        varchar(8) comment '货币单位',
   DESCRIPTION          varchar(128) comment '描述',
   STATUS               varchar(16) comment '状态',
   ORGANIZATION_ID      bigint not null comment '组织ID',
   CREATED              timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   CREATEDBY            char(32) not null default '0' comment '创建人',
   UPDATED              timestamp not null comment '更新时间',
   UPDATEDBY            char(32) not null comment '更新人',
   IS_ACTIVE            char(1) not null default 'Y' comment '是否有效',
   IS_DELETE            char(1) not null default 'N' comment '是否删除',
   primary key (ID)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

alter table VMS_SHM_ORDER_PARCEL comment '运输订单包裹';

/*==============================================================*/
/* Index: IDX_PARCEL_ORDERNO_PARCELNO                           */
/*==============================================================*/
create unique index IDX_PARCEL_ORDERNO_PARCELNO on VMS_SHM_ORDER_PARCEL
(
   ORDER_NO,
   PARCEL_NO
);

/*==============================================================*/
/* Table: VMS_SHM_ORDER_PARCEL_ITEM                             */
/*==============================================================*/
create table VMS_SHM_ORDER_PARCEL_ITEM
(
   ID                   bigint(20) not null auto_increment comment 'ID',
   ORDER_NO             varchar(32) not null comment '订单号',
   PARCEL_NO            varchar(32) not null comment '包裹号',
   NAME                 varchar(256) not null comment '名称',
   SKU                  varchar(32) not null comment 'SKU码',
   LENGTH               decimal(12,2) comment '长',
   WIDTH                decimal(12,2) comment '宽',
   HEIGHT               decimal(12,2) comment '高',
   WEIGHT               decimal(14,4) comment '重量',
   VALUE                decimal(12,2) comment '申报价值',
   CURRENCY_UNIT        varchar(8) comment '货币单位',
   DESCRIPTION          varchar(128) comment '描述',
   QUANTITY             int(11) not null comment '数量',
   ORGANIZATION_ID      bigint not null comment '组织ID',
   CREATED              timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   CREATEDBY            char(32) not null default '0' comment '创建人',
   UPDATED              timestamp not null comment '更新时间',
   UPDATEDBY            char(32) not null comment '更新人',
   IS_ACTIVE            char(1) not null default 'Y' comment '是否有效',
   IS_DELETE            char(1) not null default 'N' comment '是否删除',
   primary key (ID)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

alter table VMS_SHM_ORDER_PARCEL_ITEM comment '运输订单包裹明细';

/*==============================================================*/
/* Table: VMS_SHM_ORDER_PARCEL_LABEL                            */
/*==============================================================*/
create table VMS_SHM_ORDER_PARCEL_LABEL
(
   ID                   bigint(20) not null auto_increment comment 'ID',
   LABEL_NO             varchar(32) comment '面单号',
   ORDER_NO             varchar(32) not null comment '订单号',
   PARCEL_NO            varchar(32) not null comment '包裹号',
   VENDOR_SHIPPING_NO   varchar(32) comment '供应商运输订单号',
   PATH                 varchar(256) comment '路径',
   STATUS               varchar(8) not null comment 'INI:未抓取,
            LGC:面单抓取成功,
            LGF:面单上传成功,
            LUF:面单上传失败',
   MESSAGE              varchar(512) comment '错误消息',
   ORGANIZATION_ID      bigint not null comment '组织ID',
   CREATED              timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   CREATEDBY            char(32) not null default '0' comment '创建人',
   UPDATED              timestamp not null comment '更新时间',
   UPDATEDBY            char(32) not null comment '更新人',
   IS_ACTIVE            char(1) not null default 'Y' comment '是否有效',
   IS_DELETE            char(1) not null default 'N' comment '是否删除',
   primary key (ID)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

alter table VMS_SHM_ORDER_PARCEL_LABEL comment '面单';

/*==============================================================*/
/* Table: VMS_SHM_ORDER_PARCEL_TRACKING                         */
/*==============================================================*/
create table VMS_SHM_ORDER_PARCEL_TRACKING
(
   ID                   bigint(20) not null auto_increment comment 'ID',
   ORDER_NO             varchar(32) not null comment '订单号',
   PARCEL_NO            varchar(32) not null comment '包裹号',
   PRODUCT_CODE         varchar(32) not null comment '供应商产品代码',
   VENDOR_SHIPPING_NO   varchar(32) not null comment '供应商运输订单号',
   TIME                 timestamp default '0000-00-00 00:00:00' comment '时间',
   LOCATION             varchar(64) comment '位置',
   OPERATOR             varchar(64) comment '操作人',
   RECEIVED_BY          varchar(64) comment '签收人',
   MESSAGE              varchar(128) comment '消息',
   STATUS               varchar(16) comment '状态',
   VENDOR_STATUS        varchar(16) comment '供应商自定义状态',
   SOURCE               varchar(8) not null comment '数据来源',
   ORGANIZATION_ID      bigint not null comment '组织ID',
   CREATED              timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   CREATEDBY            char(32) not null default '0' comment '创建人',
   UPDATED              timestamp not null comment '更新时间',
   UPDATEDBY            char(32) not null comment '更新人',
   IS_ACTIVE            char(1) not null default 'Y' comment '是否有效',
   IS_DELETE            char(1) not null default 'N' comment '是否删除',
   primary key (ID)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

alter table VMS_SHM_ORDER_PARCEL_TRACKING comment '派送轨迹';

/*==============================================================*/
/* Table: VMS_SHM_PAYABLE                                       */
/*==============================================================*/
create table VMS_SHM_PAYABLE
(
   ID                   bigint(20) not null auto_increment comment 'ID',
   PARTNER_ID           bigint(20) not null comment '业务伙伴ID',
   PARTNER_NAME         VARCHAR(64) comment '业务伙伴',
   DOCUMENT_NO          VARCHAR(32) not null comment '订单流水号',
   ORDER_NO             VARCHAR(32) not null comment '运输订单号',
   CHARGE_CODE          VARCHAR(32) not null comment '费用编码',
   EXCHANGE_RATE        decimal(14,4) comment '汇率',
   AMOUNT               decimal(12,2) not null comment '金额',
   CURRENCY_UNIT        varchar(8) not null comment '币种',
   DATE                 timestamp default '0000-00-00 00:00:00' comment '帐户日期',
   QUANTITY             int comment '数量',
   STATUS               varchar(8) not null comment 'INI:初始状态,
            FCF:向账务发送成本成功,
            FCS:向账务发送成本失败',
   ORGANIZATION_ID      bigint not null comment '组织ID',
   CREATED              timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   CREATEDBY            char(32) not null default '0' comment '创建人',
   UPDATED              timestamp not null comment '更新时间',
   UPDATEDBY            char(32) not null comment '更新人',
   IS_ACTIVE            char(1) not null default 'Y' comment '是否有效',
   IS_DELETE            char(1) not null default 'N' comment '是否删除',
   primary key (ID)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

alter table VMS_SHM_PAYABLE comment '应付费用';

/*==============================================================*/
/* Table: VMS_SYS_CONFIG                                        */
/*==============================================================*/
create table VMS_SYS_CONFIG
(
   ID                   bigint(20) not null auto_increment comment 'ID',
   NAME                 varchar(64) not null comment '名称',
   VALUE                varchar(256) comment '值',
   DESCRIPTION          varchar(256) comment '描述',
   ORGANIZATION_ID      bigint not null comment '组织ID',
   CREATED              timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   CREATEDBY            char(32) not null default '0' comment '创建人',
   UPDATED              timestamp not null comment '更新时间',
   UPDATEDBY            char(32) not null comment '更新人',
   IS_ACTIVE            char(1) not null default 'Y' comment '是否有效',
   IS_DELETE            char(1) not null default 'N' comment '是否删除',
   primary key (ID)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

alter table VMS_SYS_CONFIG comment '系统配置项';

/*==============================================================*/
/* Index: IDX_SYS_CONFIG_ORDER_NO                               */
/*==============================================================*/
create unique index IDX_SYS_CONFIG_ORDER_NO on VMS_SYS_CONFIG
(
   NAME
);

/*==============================================================*/
/* Table: VMS_SYS_MAIL_QUEUE                                    */
/*==============================================================*/
create table VMS_SYS_MAIL_QUEUE
(
   ID                   bigint(20) not null auto_increment comment 'ID',
   MANIFEST_NO          varchar(32) comment '万邑通发货单号',
   SUBJECT              varchar(128) not null comment '邮件标题',
   CONTENT              varchar(256) comment '邮件内容',
   ATTACHMENT           varchar(128) comment '邮件附件',
   SEND_TO              varchar(256) not null comment '收件人',
   CC                   varchar(256) comment '抄送',
   BCC                  varchar(256) comment '密抄',
   STATUS               varchar(8) not null comment '状态',
   ORGANIZATION_ID      bigint not null comment '组织ID',
   CREATED              timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   CREATEDBY            char(32) not null default '0' comment '创建人',
   UPDATED              timestamp not null comment '更新时间',
   UPDATEDBY            char(32) not null comment '更新人',
   IS_ACTIVE            char(1) not null default 'Y' comment '是否有效',
   IS_DELETE            char(1) not null default 'N' comment '是否删除',
   primary key (ID)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

alter table VMS_SYS_MAIL_QUEUE comment '邮件队列';

/*==============================================================*/
/* Table: VMS_SYS_SCHEDULER                                     */
/*==============================================================*/
create table VMS_SYS_SCHEDULER
(
   ID                   bigint(20) not null auto_increment comment '主键ID',
   JOB_NAME             varchar(32) not null comment '定时任务名称',
   BEAN_CLASS           varchar(128) not null comment '定时任务类',
   METHOD_NAME          varchar(32) not null comment '定时任务方法名',
   CRON_EXPRESSION      varchar(128) default '0' comment '定时任务时间表达式',
   IP_ADDRESS           varchar(16) default NULL comment '哪台服务器使用,为空则全部服务器都可执行',
   JOB_STATUS           varchar(1) not null default '0' comment '任务状态:0不启用，1启用',
   CODE                 varchar(32) default NULL comment '定时任务编码',
   JOB_GROUP            varchar(64) default NULL comment '任务分组',
   SPRING_ID            varchar(32) default NULL comment 'SPRING配置文件中引入BEAN的声明式ID',
   IS_CONCURRENT        varchar(1) default '1' comment '工作状态:0异步，1同步',
   ORGANIZATION_ID      bigint not null comment '组织ID',
   CREATED              timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   CREATEDBY            char(32) not null default '0' comment '创建人',
   UPDATED              timestamp not null comment '更新时间',
   UPDATEDBY            char(32) not null comment '更新人',
   IS_ACTIVE            char(1) not null default 'Y' comment '是否有效',
   IS_DELETE            char(1) not null default 'N' comment '是否删除',
   primary key (ID)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

alter table VMS_SYS_SCHEDULER comment '定时作业';

/*==============================================================*/
/* Table: VMS_VE_PRODUCT_ATTR                                   */
/*==============================================================*/
create table VMS_VE_PRODUCT_ATTR
(
   ID                   bigint(20) not null auto_increment comment 'ID',
   PRODUCT_CODE         varchar(32) not null comment '产品代码',
   IS_BUTT_JOIN_LABEL   char(1) not null comment '是否对接面单',
   IS_BUTT_JOIN_MANIFEST char(1) not null comment '是否对接发货单',
   IS_BUTT_JOIN_PREADVICE char(1) not null comment '是否对接交接单',
   IS_BUTT_JOIN_TRACKING char(1) not null comment '是否对接轨迹',
   LABEL_FILE_EXTENSIOIN varchar(8) not null comment '面单文件扩展名',
   MANIFEST_FILE_EXTENSIOIN varchar(8) not null comment '发货文件单扩展名',
   LABEL_IMPL_CLASS     varchar(128) comment '面单对接实现类',
   MANIFEST_IMPL_CLASS  varchar(128) comment '发货单对接实现类',
   PREADVICE_IMPL_CLASS varchar(128) comment '交接清单对接实现类',
   IS_OPEN_FTP_TRACK_FETCH char(1) not null comment '是否开启FTP轨迹抓取',
   IS_OPEN_API_TRACK_FETCH char(1) not null comment '是否开启API轨迹抓取',
   IS_OPEN_WEB_TRACK_FETCH char(1) not null comment '是否开启网页轨迹抓取',
   TRACK_STATUS_CATEGORY_CODE varchar(32) comment '轨迹状态分类代码',
   ORGANIZATION_ID      bigint not null comment '组织ID',
   CREATED              timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   CREATEDBY            char(32) not null default '0' comment '创建人',
   UPDATED              timestamp not null comment '更新时间',
   UPDATEDBY            char(32) not null comment '更新人',
   IS_ACTIVE            char(1) not null default 'Y' comment '是否有效',
   IS_DELETE            char(1) not null default 'N' comment '是否删除',
   primary key (ID)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

alter table VMS_VE_PRODUCT_ATTR comment '供应商产品属性';

/*==============================================================*/
/* Table: VMS_VE_SHIPMENT_CONFIG                                */
/*==============================================================*/
create table VMS_VE_SHIPMENT_CONFIG
(
   ID                   bigint(20) not null auto_increment comment 'ID',
   PRODUCT_CODE         varchar(32) not null comment '产品代码',
   NAME                 varchar(64) not null comment '名称',
   VALUE                varchar(256) comment '值',
   DESCRIPTION          varchar(256) comment '描述',
   ORGANIZATION_ID      bigint not null comment '组织ID',
   CREATED              timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   CREATEDBY            char(32) not null default '0' comment '创建人',
   UPDATED              timestamp not null comment '更新时间',
   UPDATEDBY            char(32) not null comment '更新人',
   IS_ACTIVE            char(1) not null default 'Y' comment '是否有效',
   IS_DELETE            char(1) not null default 'N' comment '是否删除',
   primary key (ID)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

alter table VMS_VE_SHIPMENT_CONFIG comment '供应商产品对接配置项';

/*==============================================================*/
/* Index: IDX_SHIP_CONF_CODE_NAME                               */
/*==============================================================*/
create unique index IDX_SHIP_CONF_CODE_NAME on VMS_VE_SHIPMENT_CONFIG
(
   PRODUCT_CODE,
   NAME
);

/*==============================================================*/
/* Table: VMS_VE_SHIPMENT_STAUTS_MAPPING                        */
/*==============================================================*/
create table VMS_VE_SHIPMENT_STAUTS_MAPPING
(
   ID                   bigint(20) not null auto_increment comment 'ID',
   CATEGORY_CODE        varchar(32) not null comment '分类代码',
   VENDOR_CODE          varchar(16) comment '供应商状态码',
   VENDOR_DESCRIPTION   varchar(256) comment '供应商状态描述',
   WINIT_CODE           varchar(16) not null comment 'WINIT状态码',
   WINIT_DESCRIPTION    varchar(256) comment 'WINIT状态描述',
   ORGANIZATION_ID      bigint not null comment '组织ID',
   CREATED              timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   CREATEDBY            char(32) not null default '0' comment '创建人',
   UPDATED              timestamp not null comment '更新时间',
   UPDATEDBY            char(32) not null comment '更新人',
   IS_ACTIVE            char(1) not null default 'Y' comment '是否有效',
   IS_DELETE            char(1) not null default 'N' comment '是否删除',
   primary key (ID)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

alter table VMS_VE_SHIPMENT_STAUTS_MAPPING comment '轨迹状态映射';

