## database

create database lesson character set utf8mb4;
use lesson;
CREATE USER 'lesson'@'localhost' IDENTIFIED BY 'lesson';
GRANT ALL PRIVILEGES ON lesson.* TO 'lesson'@'localhost';
flush privileges;

## table

drop table if exists lesson.user;
create table lesson.user
(
    id          int(11) unsigned auto_increment comment '主键',
    username    varchar(128) not null default '' comment '账号',
    password    varchar(128) not null default '' comment '密码',
    real_name   varchar(128) not null default '' comment '真实姓名',
    gender      tinyint(2)   not null default 2 comment '性别，0女，1男，2保密',
    avatar      varchar(512) not null default '' comment '头像图片地址',
    phone       char(11)     not null default '' comment '手机号',
    create_time datetime     not null default now() comment '创建时间',
    primary key (id),
    unique (username)
) comment '用户表';

drop table if exists lesson.video;
create table lesson.video
(
    id          int(11) unsigned auto_increment comment '主键',
    title       varchar(128)  not null default '' comment '视频标题',
    summary     varchar(1024) not null default '' comment '视频概述',
    cover_img   varchar(512)  not null default '' comment '视频封面图',
    price       decimal(8, 2) not null default 0.00 comment '视频价格，单位元',
    point       decimal(4, 2) not null default 7.00 comment '视频评分，默认7.0，最高10分',
    create_time datetime      not null default now() comment '视频创建时间',
    primary key (id)
) comment '视频表';

drop table if exists lesson.chapter;
create table lesson.chapter
(
    id             int(11) unsigned auto_increment comment '主键',
    title          varchar(128)     not null default '' comment '章的标题',
    order_in_video int(11) unsigned not null default 0 comment '视频内第几章',
    video_id       int(11) unsigned not null default 0 comment 'video表外键',
    create_time    datetime         not null default now() comment '章的创建时间',
    primary key (id),
    unique (title)
) comment '视频-章表';

drop table if exists lesson.episode;
create table lesson.episode
(
    id               int(11) unsigned auto_increment comment '主键',
    title            varchar(128)     not null default '' comment '集的标题',
    free             tinyint(2)       not null default 1 comment '0免费，1付费',
    play_url         varchar(512)     not null default '' comment '视频播放地址',
    order_in_video   int(11)          not null default 0 comment '视频内第几集',
    order_in_chapter int(11)          not null default 0 comment '章内第几集',
    chapter_id       int(11) unsigned not null default 0 comment 'chapter表外键',
    video_id         int(11) unsigned not null default 0 comment 'video表外键',
    create_time      datetime         not null default now() comment '集的创建时间',
    primary key (id),
    unique (title)
) comment '视频-集表';

drop table if exists lesson.video_banner;
create table lesson.video_banner
(
    id          int(11) unsigned auto_increment comment '主键',
    url         varchar(512) not null default '' comment '跳转地址',
    src         varchar(512) not null default '' comment '图片地址',
    weight      int(11)      not null default 0 comment '数字越小排越前',
    create_time datetime     not null default now() comment '创建时间',
    primary key (id)
) comment '视频轮播图表';

drop table if exists lesson.play_record;
create table lesson.play_record
(
    id          int(11) unsigned auto_increment comment '主键',
    user_id     int(11) unsigned not null default 0 comment '用户表外键',
    video_id    int(11) unsigned not null default 0 comment '视频表外键',
    current_num int(11)          not null default 0 comment '当前播放第几集',
    episode_id  int(11)          not null default 0 comment '当前播放第几集视频的id',
    create_time datetime         not null default now() comment '创建时间',
    primary key (id)
) comment '播放记录表';

drop table if exists lesson.video_order;
create table lesson.video_order
(
    id          int(11) unsigned auto_increment comment '主键',
    order_no    varchar(64)      not null default '' comment '订单流水号',
    state       int(11)          not null default 0 comment '0未支付，1已支付',
    total_fee   decimal(8, 2)    not null default 0.00 comment '支付金额',
    video_id    int(11) unsigned not null default 0 comment '视频表外键',
    video_title varchar(128)     not null default '' comment '视频标题，冗余字段',
    video_img   varchar(512)     not null default '' comment '视频图片，冗余字段',
    user_id     int(11) unsigned not null default 0 comment '用户表外键',
    create_time datetime         not null default now() comment '订单生成时间',
    primary key (id),
    unique (order_no)
) comment '视频订单表';

insert into lesson.video (id, title, summary, cover_img, price, point)
values (1, 'java第0阶-新手村', 'video-default.jpg', 'javabook-0.jpg', 5000.00, 9.50),
       (2, 'java第1阶-基础篇', 'video-default.jpg', 'javabook-1.jpg', 7000.00, 9.60),
       (3, 'java第2阶-数据篇', 'video-default.jpg', 'javabook-2.jpg', 8000.00, 9.90),
       (4, 'java第3阶-应用篇', 'video-default.jpg', 'javabook-3.jpg', 7999.00, 8.90),
       (5, 'java第4阶-前端篇', 'video-default.jpg', 'javabook-4.jpg', 5500.00, 8.90),
       (6, 'java第5阶-中间件', 'video-default.jpg', 'javabook-5.jpg', 6700.00, 9.20),
       (7, 'java第6阶-微服务', 'video-default.jpg', 'javabook-6.jpg', 4300.00, 9.60),
       (8, 'java第7阶-专题篇', 'video-default.jpg', 'javabook-7.jpg', 2600.00, 9.90),
       (9, 'java第8阶-面试篇', 'video-default.jpg', 'javabook-8.jpg', 1600.00, 9.10);
commit;

insert into lesson.chapter (id, title, order_in_video, video_id)
values (1, '课前预热', 1, 1),
       (2, '何为Java', 2, 1),
       (3, '使用Java', 3, 1),
       (4, '运行Java', 4, 1),
       (5, '集成开发环境', 5, 1),
       (6, '使用Maven', 6, 1),
       (7, '使用Git', 7, 1),
       (8, '使用Markdown', 8, 1),
       (9, '基础语法', 1, 2),
       (10, '流程控制', 2, 2),
       (11, '线性结构', 3, 2),
       (12, '面向对象', 4, 2),
       (13, '异常处理', 5, 2),
       (14, '泛型容器', 6, 2),
       (15, '常用工具', 7, 2),
       (16, '反射机制', 8, 2),
       (17, '流类操作', 9, 2);
commit;

insert into lesson.episode (id, title, free, play_url, order_in_video, order_in_chapter, chapter_id, video_id)
values (1, '如何成为大神', 0, '如何成为大神.mp4', 1, 1, 1, 1),
       (2, '我为何选择Java', 0, '我为何选择Java.mp4', 2, 1, 2, 1),
       (3, '我该如何学Java', 0, '我该如何学Java.mp4', 3, 2, 2, 1),
       (4, '何时开始学Java', 0, '何时开始学Java.mp4', 4, 3, 2, 1),
       (5, '到底什么是Java', 0, '到底什么是Java.mp4', 5, 4, 2, 1),
       (6, '配置Path变量', 0, '配置Path变量.mp4', 6, 1, 3, 1),
       (7, '配置JAVA_HOME变量', 0, '配置JAVA_HOME变量.mp4', 7, 2, 3, 1),
       (8, '开发HelloWorld', 0, '开发HelloWorld.mp4', 8, 1, 4, 1),
       (9, '详解HelloWorld', 0, '详解HelloWorld.mp4', 9, 2, 4, 1),
       (10, 'IDEA卸载', 1, 'IDEA卸载.mp4', 10, 1, 5, 1),
       (11, 'IDEA安装', 1, 'IDEA安装.mp4', 11, 2, 5, 1),
       (12, 'IDEA破解', 1, 'IDEA破解.mp4', 12, 3, 5, 1),
       (13, 'IDEA配置', 1, 'IDEA配置.mp4', 13, 4, 5, 1),
       (14, 'IDEA插件', 1, 'IDEA插件.mp4', 14, 5, 5, 1),
       (15, '安装maven', 1, '安装maven.mp4', 15, 1, 6, 1),
       (16, '搭建maven仓库', 1, '搭建maven仓库.mp4', 16, 2, 6, 1),
       (17, '整合maven到IDEA', 1, '整合maven到IDEA.mp4', 17, 3, 6, 1),
       (18, '创建maven父子项目', 1, '创建maven父子项目.mp4', 18, 4, 6, 1),
       (19, '使用Junit单元测试', 1, '使用Junit单元测试.mp4', 19, 5, 6, 1),
       (20, '本地jar包导入仓库', 1, '本地jar包导入仓库.mp4', 20, 6, 6, 1),
       (21, '整合git和gitee', 1, '整合git和gitee.mp4', 21, 1, 7, 1),
       (22, '赵四分享项目到gitee', 1, '赵四分享项目到gitee.mp4', 22, 2, 7, 1),
       (23, '赵四邀请刘能加入团队', 1, '赵四邀请刘能加入团队.mp4', 23, 3, 7, 1),
       (24, '刘能克隆项目到本地', 1, '刘能克隆项目到本地.mp4', 24, 4, 7, 1),
       (25, '刘能修改代码并push', 1, '刘能修改代码并push.mp4', 25, 5, 7, 1),
       (26, 'Markdown手册', 1, 'Markdown手册.mp4', 26, 1, 8, 1);
commit;

insert into lesson.video_banner (id, url, src, weight)
values (1, 'url-banner-01', 'banner-01.jpg', 2),
       (2, 'url-banner-02', 'banner-02.jpg', 1),
       (3, 'url-banner-03', 'banner-03.jpg', 3);
commit;







