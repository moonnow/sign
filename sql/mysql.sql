/*==============================================================*/
/* Name:<用户> Table: PRO_USER                                  */
/*==============================================================*/
/*
mysqldump -hlocalhost -P3306 -uroot -pmoonnow empirecs PRO_USER > PRO_USER.sql
*/
drop table if exists PRO_USER;
create table PRO_USER (
  USER_ID                         varchar(36)         character set utf8 collate utf8_bin  not null comment '用户编号',
  USER_KEY                        varchar(64)         character set utf8 collate utf8_bin  not null comment '用户标识',
  USER_NAME                       varchar(64)         character set utf8 collate utf8_bin  not null comment '用户名称',
  primary key (USER_ID),
  unique key (USER_KEY)
)ENGINE=INNODB DEFAULT CHARSET=utf8 comment '用户';

/*==============================================================*/
/* Name:<账号> Table: PRO_ACCOUNT                               */
/*==============================================================*/
/*
mysqldump -hlocalhost -P3306 -uroot -pmoonnow empirecs PRO_ACCOUNT > PRO_ACCOUNT.sql
*/
drop table if exists PRO_ACCOUNT;
create table PRO_ACCOUNT (
  ACCOUNT_ID                      varchar(36)         character set utf8 collate utf8_bin  not null comment '账号编号',
  ACCOUNT                         varchar(64)         character set utf8 collate utf8_bin  not null comment '账号',
  PASSWORD                        varchar(64)         character set utf8 collate utf8_bin  not null comment '密码',
  LOGIN_KEY                       varchar(64)         character set utf8 collate utf8_bin      null comment '登录标识',
  PERMISSION_KEY                  varchar(32)         character set utf8 collate utf8_bin      null comment '权限标识',

  USER_ID                         varchar(36)         character set utf8 collate utf8_bin      null comment '用户编号',
  primary key (ACCOUNT_ID),
  unique key (ACCOUNT)
)ENGINE=INNODB DEFAULT CHARSET=utf8 comment '账号';
alter table PRO_ACCOUNT add constraint FK_PRO_ACCOUNT_USER_ID foreign key (USER_ID) references PRO_USER(USER_ID);

/*==============================================================*/
/* Name:<用户信息> Table: PRO_USER_INFO                          */
/*==============================================================*/
/*
mysqldump -hlocalhost -P3306 -uroot -pmoonnow empirecs PRO_USER_INFO > PRO_USER_INFO.sql
*/
drop table if exists PRO_USER_INFO;
create table PRO_USER_INFO (
  USER_INFO_ID                    varchar(36)         character set utf8 collate utf8_bin  not null comment '用户信息编号',
  LABEL_NAME                      varchar(64)         character set utf8 collate utf8_bin  not null comment '标签',
  CONTENT                         varchar(255)        character set utf8 collate utf8_bin  not null comment '内容',

  USER_ID                         varchar(36)         character set utf8 collate utf8_bin  not null comment '用户编号',
  primary key (USER_INFO_ID)
)ENGINE=INNODB DEFAULT CHARSET=utf8 comment '用户信息';
alter table PRO_USER_INFO add constraint FK_PRO_USER_INFO_USER_ID foreign key (USER_ID) references PRO_USER(USER_ID);

/*==============================================================*/
/* Name:<组> Table: PRO_GROUPS                                  */
/*==============================================================*/
/*
mysqldump -hlocalhost -P3306 -uroot -pmoonnow empirecs PRO_GROUPS > PRO_GROUPS.sql
*/
drop table if exists PRO_GROUPS;
create table PRO_GROUPS (
  GROUPS_ID                       varchar(36)         character set utf8 collate utf8_bin  not null comment '组编号',
  GROUPS_KEY                      varchar(64)         character set utf8 collate utf8_bin  not null comment '组标识',
  GROUPS_NAME                     varchar(64)         character set utf8 collate utf8_bin  not null comment '组名称',
  DESCRIPTION                     varchar(255)        character set utf8 collate utf8_bin      null comment '描述',
  primary key (GROUPS_ID),
  unique key (GROUPS_KEY)
)ENGINE=INNODB DEFAULT CHARSET=utf8 comment '组';

/*==============================================================*/
/* Name:<用户组关系> Table: PRO_USER_GROUPS_NEXUS                */
/*==============================================================*/
/*
mysqldump -hlocalhost -P3306 -uroot -pmoonnow empirecs PRO_USER_GROUPS_NEXUS > PRO_USER_GROUPS_NEXUS.sql
*/
drop table if exists PRO_USER_GROUPS_NEXUS;
create table PRO_USER_GROUPS_NEXUS (
  NEXUS_ID                        varchar(36)         character set utf8 collate utf8_bin  not null comment '用户组关系编号',
  USER_ID                         varchar(36)         character set utf8 collate utf8_bin  not null comment '用户编号',
  GROUPS_ID                       varchar(36)         character set utf8 collate utf8_bin  not null comment '组编号',
  primary key (NEXUS_ID)
)ENGINE=INNODB DEFAULT CHARSET=utf8 comment '用户组关系';
alter table PRO_USER_GROUPS_NEXUS add constraint FK_PRO_USER_GROU_NEXUS_USER_ID foreign key (USER_ID) references PRO_USER(USER_ID);
alter table PRO_USER_GROUPS_NEXUS add constraint FK_PRO_USER_GROU_NEXUS_GROU_ID foreign key (GROUPS_ID) references PRO_GROUPS(GROUPS_ID);

/*==============================================================*/
/* Name:<登录日志> Table: PRO_LOGIN_LOG                          */
/*==============================================================*/
/*
mysqldump -hlocalhost -P3306 -uroot -pmoonnow empirecs PRO_LOGIN_LOG > PRO_LOGIN_LOG.sql
*/
drop table if exists PRO_LOGIN_LOG;
create table PRO_LOGIN_LOG (
  LOG_ID                          varchar(36)         character set utf8 collate utf8_bin  not null comment '登录日志编号',
  ACCOUNT_ID                      varchar(36)         character set utf8 collate utf8_bin  not null comment '账号编号',
  ACCOUNT                         varchar(64)         character set utf8 collate utf8_bin  not null comment '账号',
  LOGIN_TIMES                     bigint(20)                                               not null comment '登录时间',
  primary key (LOG_ID)
)ENGINE=INNODB DEFAULT CHARSET=utf8 comment '登录日志';

/*==============================================================*/
/* Name:<会话> Table: PRO_SESSION                               */
/*==============================================================*/
/*
mysqldump -hlocalhost -P3306 -uroot -pmoonnow empirecs PRO_SESSION > PRO_SESSION.sql
*/
drop table if exists PRO_SESSION;
create table PRO_SESSION (
  SESSION_ID                      varchar(36)         character set utf8 collate utf8_bin  not null comment '会话编号',
  ACCOUNT_ID                      varchar(36)         character set utf8 collate utf8_bin  not null comment '账号编号',
  LOGIN_KEY                       varchar(64)         character set utf8 collate utf8_bin  not null comment '登录标识',
  CURRENT_TIMES                   bigint(20)                                               not null comment '当前时间',
  primary key (SESSION_ID),
  unique key (ACCOUNT_ID, LOGIN_KEY)
)ENGINE=INNODB DEFAULT CHARSET=utf8 comment '会话';
alter table PRO_SESSION add constraint FK_PRO_SESSION_ACCOUNT_ID foreign key (ACCOUNT_ID) references PRO_ACCOUNT(ACCOUNT_ID);
