### 整合swagger框架

**心法：** Swagger是一款Restful接口的文档在线自动生成以及功能测试功能软件：
- `@Api(tags = "")`：标记在控制类上，可以对控制类进行描述。
- `@ApiOperation(value = "", notes = "")`：标记在方法上，可以对控制方法进行描述。
  
- `@ApiModel(value = "", description = "")`：标记在实体类上，对实体类进行描述。
- `@ApiModelProperty(value = "主键", required = true, example = "1")`：标记在实体类上，对实体类进行描述。

**武技：** 配置swagger文档：
- 添加依赖：
    - `io.springfox:springfox-boot-starter:3.0.0`
- 开发 `config.SwaggerConfig` 配置类：
    - 类上标记 `@Configuration` 以声明为配置类。
    - 类上标记 `@EnableSwagger2` 以启动swagger功能。
- 在配置类中开发 `ApiInfo getSwaggerInfo()` 方法：用于设置一个通用的swagger信息展板：
    - `new ApiInfoBuilder().build()` 建造者模式创建swagger信息展板。
    - `.title("SpringBoot项目接口文档")`：设置大标题。
    - `.description("SpringBoot项目接口文档描述")`：设置小标题。
    - `.version("1.0.1")`：设置项目版本。
    - `.contact(new Contact("JoeZhou", "http://localhost:8081", "yy06200210@163.com"))`：设置链接。
- 在配置类中开发 `Docket docketA()` 方法：用于对swagger进行分组：
    - `new Docket(DocumentationType.SWAGGER_2).build()`：建造者模式创建Docket分组。
    - `.groupName("docket-a")`：设置swagger分组名。
    - `.apiInfo(getSwaggerInfo())`：设置swagger信息展板。
    - `.select().apis(RequestHandlerSelectors.basePackage("包名"))`：扫描指定包。
    - `.paths(PathSelectors.ant("/api/v1/**"))`：设置请求规则。
- 在配置类中限定环境：swagger仅建议在测试环境下使用，生产环境下使用会影响效率：
    - 类上标记 `@PropertySource("application.properties")` 以读取主配。
    - 开发 `int port` 属性，标记 `@Value("${server.port}")` 以读取主配中的端口号。
    - 在 `docketA()` 方法中判断当前端口号，仅为测试端口5279时创建Docket分组。
- 在VideoBannerController中添加swagger相关注解后测试：
    - cli: `localhost:5279/swagger-ui/index.html` 

***************************************

**武技：** 开发User表控制层代码：用户注册：
- UserController接口：`Result register(@RequestBody User user)`：
  - 方法标记 `@PostMapping("/register")` 以设置URL接口地址和请求类型限制。
  - 参数标记 `@RequestBody` 表示仅接收JSON格式的参数。
  - 调用业务层方法进行用户注册并响应。
- cli: 使用swagger测试。
- `@ApiModel(value = "简单描述", description = "详细描述")`：标记实体类。
- `@ApiModelProperty(value = "简单描述", required = true, example = "示例值")`：标记实体类属性。 

@JsonProperty("real-name")
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")




/**
* 当实体参数未通过HibernateValidated校验时，记录日志并抛出运行时异常
*
* @param bindingResult 校验错误实例
*/
private void throwValidationException(BindingResult bindingResult) {
for (FieldError error : bindingResult.getFieldErrors()) {
String errorMsg = String.format("%s 参数的 %s 属性爆发错误：%s",
error.getObjectName(),
error.getField(),
error.getDefaultMessage());
log.info(errorMsg);
// 手动抛出异常，被全局异常处理捕获
throw new RuntimeException(errorMsg);
}
} 
