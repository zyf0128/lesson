项目简介:
项目名称: 在线课程视频交易平台. 主要用于课程视频的交易,包括管理员后台管理,用户后台管理,前端子项目.管理员可以通过管理员后台管理所有的表的CRUD,上传图片,视频,进行日志的查看备份等.用户可以购买视频,可以在线观看或下载课程视频
技术选型
1.	使用mysql 进行数据的存储, 使用触发器将所有被删除的数据进行备份。
2.	使用mybatis持久层框架的注解配置方式进行数据层开发
3.	使用springboot框架进行业务和控制层开发。
4.	使用@ControllerAdvice对全局异常进行统一处理。
5.	使用logback作为本项目的日志框架。
6.	使用@Async +@Scheduled对日志文件进行拆分并持久化到ElasticSearch搜索引擎。
7.	使用Jackson序列化框架进行控制层请求参数接收和响应数据格式化处理。
8.	使用AOP对全部业务进行前置校验参数，后置日志记录和返回后数据的脱敏和加密等功能。
9.	使用springboot拦截器进行CORS跨域处理。
10.	使用HibernateValidator对请求参数进行规则校验。
11.	使用Nginx对项目进行负载均衡处理以及虚拟媒体文件的上传路径。
12.	使用PageHelper对查询业务进行分页处理（轮播图除外）。
13.	使用Redis集群作为缓存中间件：开发购物车业务。
14.	使用ElasticSearch作为搜索引擎，使用Kibana作为ElasticSearch客户端。
15.	使用junit配合springboot-test对全部业务层和数据层接口方法进行单元测试。
16.	使用Swagger生成项目文档以及对项接口进行常规测试
17.	使用spring-cloud-alibaba技术栈进行全项目开发。
18.	使用nacos注册中心代替cloud中的eureka进行服务注册与发现。
19.	使用nacosConfig配置中心代替cloud中的config进行配置文件统一管理。
20.	使用gataway网关代替cloud中的zuul进行路由，限流和断言配置。
21.	使用sleuth + zipkin对整体项目服务的链路进行追踪和分析。
22.	使用openFeign代替ribbon进行微服务之间的远程调用。
23.	使用sentinel代替hystrix进行服务限流，降级，熔断等处理，以保证服务高可用。
24.	使用seata对服务进行分布式事务保护。
25.	使用rocketmq生产消费模型对服务进行削峰填谷，在下单后向用户微服务投递消息，发送通知邮件
26.	使用springboot拦截器进行CORS跨域处理	
管理员后台管理系统:
项目描述: lesson-admin子项目是lesson项目的管理员后台子项目，该项目不允许普通用户登录，仅允许管理员用户登录，以对用户，视频，订单，日志等数据进行操作和维护。
业务描述:
1.	用户注册：无需注册，只提供管理员内置账号，不允许普通用户登录。
2.	用户登录：配合JWT + 拦截器进行token校验，自封装注解，对所有标记了该注解的控制方法进行拦截与token校验。
3.	用户登出：退出登录，删除该管理员用户的sesson状态。
4.	用户管理：管理员可以对普通用户进行CRUD操作，数据导出和图形统计。
5.	全查轮播图：配合guava进行本地缓存，上传下载媒体数据。
6.	分页查询视频：配合guava进行本地缓存，上传下载媒体数据。
7.	视频管理：管理员可以对视频进行CRUD操作，数据导出和图形统计。
8.	订单管理：管理员可以对订单进行CRUD操作，数据导出和图形统计	
用户后台管理系统:
一、	用户模块
i.	用户注册：密码使用MD5加密后入库，除账号，密码，电话，姓名和身份证号外，其余字段皆使用自封装工具类生成固定或随机的默认值。
ii.	用户登录：配合JWT + 拦截器进行token校验，自封装注解，对所有标记了该注解的控制方法进行拦截与token校验。
iii.	用户登出：退出登录，从session和vuex状态管理中删除该用户信息
iv.	用户注销：真实删除数据库中的用户个人记录，但配合mysql触发器进行了数据备份。
v.	查询个人信息：手机号码和密码等敏感数据使用AOP返回后通知进行脱敏操作。
vi.	修改个人信息：修改个人信息，Mapper层使用动态标签进行选择性修改。
vii.	修改个人头像：使用nginx + fileupload开发上传头像，头像预览，下载头像等功能。
viii.	修改个人密码：修改密码设置为单独模块，修改后退出登录状态，提示重新登录。
二、	轮播图模块
i.	全查轮播图：配合guava进行本地缓存以提升查询效率，配合PageHelper进行分页处理。
三、	视频模块 
i.	分页查询视频：配合guava进行本地缓存以提升查询效率，使用分级菜单进行展示。
ii.	搜索指定视频：配合ElasticSearch完成视频分词搜索和展示。
iii.	展示视频详情：联查指定视频下所有章的信息和每一章中集的信息。
iv.	在线观看视频：配合xgplayer完成在线观看视频功能。
v.	发送弹幕功能：配合Websocket完成在线观看视频时发送弹幕功能（实时推送到其他客户端）。
四、	订单模块
i.	购买指定视频：下单业务添加本地事务保护，配合redis完成购物车业务，相同视频不允许重复购买。
ii.	查询个人订单：查询个人全部订单，配合PageHelper进行分页处理。
iii.	删除个人订单：删除个人指定订单，配合mysql触发器进行了数据备份。
五、	微服务模块:
a)	这个模块主要用来下单,订单微服务通过openFeigh远程调用用户微服务,来生成订单的,进行toke同时会进行重复购买的保护,如果已经购买过了,就提示用户不可重复购买;在用户购买成功之后,往消息队列(RocketMQ)中投递消息(给用户发邮件), 在用户视频订单中间中插入订单的记录,整个过程都进行了分布式的事务保护.
五、	日志模块
a)	日志模块-用户日志记录：使用@Async + @Scheduled对日志文件进行拆分并持久化到ElasticSearch搜索引擎，本业务为服务端业务，并不提供给客户端
六、	lesson-foreground子项目
项目描述: lesson-foreground子项目是lesson项目的普通用户前台子项目，使用前后端分离技术，使用node16 + vue3 + ElementPlus框架开发完成。
技术选型:
i.	使用node16作为前端项目服务器。
ii.	使用vue3.2.37 + vue-router4.0.16 + vue3脚手架开发前端界面。
iii.	使用element-plus2.2.6框架辅助开发前端界面。
iv.	使用axios0.27.2向后台进行发送同步/异步请求。
v.	使用vuex4.0.2进行前端数据的状态管理。
vi.	使用xgplayer2.31.6制作在线视频播放器