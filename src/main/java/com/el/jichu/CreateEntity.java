//package com.el.jichu;
//
//import lombok.Data;
//import lombok.experimental.Accessors;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.List;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
///**
// * description: 创建实体类.
// *
// * @author zhao_qiao_gong
// * 2020-07-02
// */
//@Data
//@Accessors(chain = true)
//public class CreateEntity {
//
//  //项目的放置位置, 需要自己修改
//  private final static String PROJECT_DIRECTORY = "F:\\workspace\\2020\\yst-dch-score";
//
//  private final static String DEVELOPMENT = PROJECT_DIRECTORY + "\\yst-dch\\src\\main\\java\\com\\elitesland\\";
//
//  private String tableName;
//
//  private String comment;
//
//  public static void main(String[] args) {
//    List<CreateEntity> createEntities = List.of(
//        new CreateEntity().setTableName("SAS_TENANT").setComment("租户"),
//        new CreateEntity().setTableName("SYS_SETTING").setComment("设置项"),
//        new CreateEntity().setTableName("SYS_SETTING_VAL").setComment("设置值"),
//        new CreateEntity().setTableName("SYS_UDC").setComment("UDC"),
//        new CreateEntity().setTableName("USR_DPOWER").setComment("用户数据权限"),
//        new CreateEntity().setTableName("COM_CURR").setComment("币种"),
//        new CreateEntity().setTableName("COM_CURR_RATE").setComment("汇率"),
//        new CreateEntity().setTableName("COM_TAX_CODE").setComment("税码"),
//        new CreateEntity().setTableName("COM_TAX_RATE").setComment("税率"),
//        new CreateEntity().setTableName("COM_PAYMENT_TERM").setComment("支付条款"),
//        new CreateEntity().setTableName("COM_STDUOM_CONV").setComment("通用计量单位转换"),
//        new CreateEntity().setTableName("COM_REGION").setComment("区划"),
//        new CreateEntity().setTableName("COM_BANK").setComment("银行"),
//        new CreateEntity().setTableName("COM_ENTRY_REF").setComment("实体关联表"),
//        new CreateEntity().setTableName("COM_CAT").setComment("类目定义"),
//        new CreateEntity().setTableName("COM_CAT_D").setComment("类目明细"),
//        new CreateEntity().setTableName("COM_YEAR").setComment("年度"),
//        new CreateEntity().setTableName("COM_PERIOD").setComment("期间"),
//        new CreateEntity().setTableName("ORG_OU").setComment("公司"),
//        new CreateEntity().setTableName("ORG_BU").setComment("BU"),
//        new CreateEntity().setTableName("ORG_ADDR").setComment("地址号"),
//        new CreateEntity().setTableName("ORG_ADDR_ADDRESS").setComment("地址号地址信息"),
//        new CreateEntity().setTableName("ORG_ADDR_QUALIFY").setComment("地址号资质信息"),
//        new CreateEntity().setTableName("ORG_ADDR_BANKACC").setComment("地址号银行账号"),
//        new CreateEntity().setTableName("ORG_ADDR_PAYINFO").setComment("地址号支付信息"),
//        new CreateEntity().setTableName("ORG_ADDR_EXT").setComment("地址号扩展信息"),
//        new CreateEntity().setTableName("ORG_ADDR_LOG").setComment("地址号履历信息"),
//        new CreateEntity().setTableName("ORG_BD").setComment("事业部"),
//        new CreateEntity().setTableName("ORG_PROFCENTER").setComment("利润中心"),
//        new CreateEntity().setTableName("ORG_EMP").setComment("员工"),
//        new CreateEntity().setTableName("ORG_EMP_ORG").setComment("员工与所属组织"),
//        new CreateEntity().setTableName("ORG_EMP_POSI").setComment("员工与岗位"),
//        new CreateEntity().setTableName("ORG_POSI").setComment("岗位"),
//        new CreateEntity().setTableName("ORG_WH").setComment("仓库"),
//        new CreateEntity().setTableName("ORG_BUSI_REGION").setComment("业务区域"),
//        new CreateEntity().setTableName("ORG_REGION_BU").setComment("业务区域与BU"),
//        new CreateEntity().setTableName("ORG_REGION_SUPP").setComment("业务区域与供应商"),
//        new CreateEntity().setTableName("ORG_AGENT").setComment("业务员"),
//        new CreateEntity().setTableName("ORG_AGENT_SUPP").setComment("业务员与供应商"),
//        new CreateEntity().setTableName("ORG_AGENT_CUST").setComment("业务员与客户"),
//        new CreateEntity().setTableName("ORG_SUPP").setComment("供应商"),
//        new CreateEntity().setTableName("ORG_SUPP_PROPERTY").setComment("供应商属性"),
//        new CreateEntity().setTableName("ORG_CUST").setComment("客户"),
//        new CreateEntity().setTableName("ORG_CHANNELSET_A").setComment("渠道维护"),
//        new CreateEntity().setTableName("ITM_ITEM").setComment("品项"),
//        new CreateEntity().setTableName("ITM_ITEM_PKG").setComment("商品包装规格"),
//        new CreateEntity().setTableName("ITM_BRAND").setComment("品牌"),
//        new CreateEntity().setTableName("ITM_ITEM_CAT").setComment("品项与类目"),
//        new CreateEntity().setTableName("ITM_ITEMUOM_CONV").setComment("品项单位转换"),
//        new CreateEntity().setTableName("ITM_CROSSREF").setComment("品项交叉参考"),
//        new CreateEntity().setTableName("ITM_ITEM_REPL").setComment("品项替代关系"),
//        new CreateEntity().setTableName("ITM_ITEM_SUPP").setComment("品项与供应商"),
//        new CreateEntity().setTableName("ITM_ITEM_C1").setComment("品项大类定义"),
//        new CreateEntity().setTableName("ITM_ITEM_C2").setComment("品项中类定义"),
//        new CreateEntity().setTableName("ITM_ITEM_C3").setComment("品项小类定义"),
//        new CreateEntity().setTableName("ITM_AGENT_ITEMC3").setComment("业务员与品项小类"),
//        new CreateEntity().setTableName("ITM_SUPP_ITEMC3").setComment("供应商与品项小类"),
//        new CreateEntity().setTableName("ITM_SKU").setComment("SKU"),
//        new CreateEntity().setTableName("PRI_SALE_PRICE").setComment("品项采购价格表"),
//        new CreateEntity().setTableName("PRI_PURC_PRICE").setComment("品项销售价格表"),
//        new CreateEntity().setTableName("PRI_PRICE_GROUP").setComment("价格组")
//        );
//
//    System.out.println(createEntities.size());
//    for (CreateEntity createEntity : createEntities) {
//      String tableName = createEntity.getTableName();
//      String comment = createEntity.getComment();
//      CreateEntity.createEntity(tableName, comment);
//      CreateEntity.createService(tableName, comment);
//      CreateEntity.createServiceImpl(tableName, comment);
//      CreateEntity.createController(tableName, comment);
//      CreateEntity.createRepo(tableName, comment);
//      CreateEntity.createProc(tableName, comment);
//    }
//  }
//
//  /*-------------------------------创建controller---------------------------------*/
//
//  public static void createController(String tableName, String comment) {
//    //创建controller所在项目的目录位置
//    String dir = DEVELOPMENT +  tableName.substring(0, tableName.indexOf("_")).toLowerCase() +"\\controller";
//    //表名为COM_CURR格式为列，下划线前为其领域 小写
//    String field = tableName.substring(0, tableName.indexOf("_")).toLowerCase();
//    //实体类头小写
//    String entityNameTitleLower = lineToHump(tableName);
//    //实体类头大写
//    String entityName = titleCase(lineToHump(tableName));
//    //创建实体类 字符串
//    String entityTemplateStr = createControllerTemplateStr(field, entityNameTitleLower, entityName, comment);
//    System.out.println(entityTemplateStr);
//    //生成、写入文件
//    writeContent(entityTemplateStr, dir, entityName + "Controller.java");
//  }
//
//  public static String createControllerTemplateStr(String field, String entityNameTitleLower, String entityName, String comment) {
//    return "package com.elitesland."+field+".controller;\n" +
//        "\n" +
//        "import com.elitesland.core.base.ApiResult;\n" +
//        "import com.elitesland."+field+".service."+entityName+"Service;\n" +
//        "import io.swagger.annotations.Api;\n" +
//        "import io.swagger.annotations.ApiOperation;\n" +
//        "import lombok.RequiredArgsConstructor;\n" +
//        "import org.springframework.web.bind.annotation.PostMapping;\n" +
//        "import org.springframework.web.bind.annotation.RequestMapping;\n" +
//        "import org.springframework.web.bind.annotation.RestController;\n" +
//        "\n" +
//        "/**\n" +
//        " * <p>\n" +
//        " * 功能说明\n" +
//        " * </p>\n" +
//        " *\n" +
//        " * @author zhao_qiao_gong\n" +
//        " * @date 2020/7/2\n" +
//        " */\n" +
//        "@RestController\n" +
//        "@RequestMapping(\"/"+field+"/"+entityNameTitleLower+"\")\n" +
//        "@RequiredArgsConstructor\n" +
//        "@Api(value = \""+comment+"\", tags = {\""+comment+"\"})\n" +
//        "public class "+entityName+"Controller {\n" +
//        "\n" +
//        "    private final "+entityName+"Service "+entityNameTitleLower+"Service;\n" +
//        "\n" +
//        "    @PostMapping(\"/q\")\n" +
//        "    @ApiOperation(\"\")\n" +
//        "    public ApiResult<Object> search() {\n" +
//        "        return ApiResult.ok(null);\n" +
//        "    }\n" +
//        "}\n";
//  }
//
//  /*-------------------------------创建Service---------------------------------*/
//
//  public static void createService(String tableName, String comment) {
//    //创建controller所在项目的目录位置
//    String dir = DEVELOPMENT +  tableName.substring(0, tableName.indexOf("_")).toLowerCase() +"\\service";
//    //表名为COM_CURR格式为列，下划线前为其领域 小写
//    String field = tableName.substring(0, tableName.indexOf("_")).toLowerCase();
//    //实体类 以DO结尾
//    String entityName = titleCase(lineToHump(tableName));
//    //创建实体类 字符串
//    String serviceTemplateStr = createServiceTemplateStr(field, entityName);
//    //生成、写入文件
//    writeContent(serviceTemplateStr, dir, entityName + "Service.java");
//  }
//
//  public static String createServiceTemplateStr(String field, String entityName) {
//    return "package com.elitesland."+field+".service;\n" +
//        "\n" +
//        "/**\n" +
//        " * <p>\n" +
//        " * 功能说明\n" +
//        " * </p>\n" +
//        " *\n" +
//        " * @author zhao_qiao_gong\n" +
//        " * @date 2020/7/2\n" +
//        " */\n" +
//        "public interface "+entityName+"Service {\n" +
//        "\n" +
//        "}\n";
//  }
//
//  public static void createServiceImpl(String tableName, String comment) {
//    //创建controller所在项目的目录位置
//    String dir = DEVELOPMENT +  tableName.substring(0, tableName.indexOf("_")).toLowerCase() +"\\service\\impl";
//    //表名为COM_CURR格式为列，下划线前为其领域com小写
//    String field = tableName.substring(0, tableName.indexOf("_")).toLowerCase();
//    //实体类 以DO结尾
//    String entityName = titleCase(lineToHump(tableName));
//    //创建实体类 字符串
//    String entityTemplateStr = createServiceImplTemplateStr(field, entityName);
//    //生成、写入文件
//    writeContent(entityTemplateStr, dir, entityName + "ServiceImpl.java");
//  }
//
//  public static String createServiceImplTemplateStr(String field, String entityName) {
//    return "package com.elitesland."+field+".service.impl;\n" +
//        "\n" +
//        "import com.elitesland."+field+".service."+entityName+"Service;\n" +
//        "import lombok.RequiredArgsConstructor;\n" +
//        "import org.springframework.stereotype.Service;\n" +
//        "\n" +
//        "/**\n" +
//        " * <p>\n" +
//        " * 功能说明\n" +
//        " * </p>\n" +
//        " *\n" +
//        " * @author zhao_qiao_gong\n" +
//        " * @date 2020/7/2\n" +
//        " */\n" +
//        "@Service\n" +
//        "@RequiredArgsConstructor\n" +
//        "public class "+entityName+"ServiceImpl implements "+entityName+"Service {\n" +
//        "\n" +
//        "}\n";
//  }
//
//  /*-------------------------------创建Repo---------------------------------*/
//
//  public static void createRepo(String tableName, String comment) {
//    //创建controller所在项目的目录位置
//    String dir = DEVELOPMENT +  tableName.substring(0, tableName.indexOf("_")).toLowerCase() +"\\repo";
//    //表名为COM_CURR格式为列，下划线前为其领域 小写
//    String field = tableName.substring(0, tableName.indexOf("_")).toLowerCase();
//    //实体类 以DO结尾
//    String entityName = titleCase(lineToHump(tableName)) + "DO";
//    //Repo Dao层以Repo结尾
//    String classNmae = titleCase(lineToHump(tableName)) + "Repo";
//    //创建实体类 字符串
//    String repoTemplateStr = createRepoTemplateStr(field, classNmae, entityName);
//    //生成、写入文件
//    writeContent(repoTemplateStr, dir, classNmae + ".java");
//  }
//
//  public static String createRepoTemplateStr(String field, String classNmae, String entityName) {
//    return "package com.elitesland."+field+".repo;\n" +
//        "\n" +
//        "import com.elitesland."+field+".entity."+entityName+";\n" +
//        "import org.springframework.data.jpa.repository.JpaRepository;\n" +
//        "import org.springframework.data.querydsl.QuerydslPredicateExecutor;\n" +
//        "import org.springframework.stereotype.Repository;\n" +
//        "\n" +
//        "/**\n" +
//        " * <p>\n" +
//        " * 功能说明\n" +
//        " * </p>\n" +
//        " *\n" +
//        " * @author zhao_qiao_gong\n" +
//        " * @date 2020/7/2\n" +
//        " */\n" +
//        "@Repository\n" +
//        "public interface "+ classNmae +" extends JpaRepository<" + entityName+ ", Long>, QuerydslPredicateExecutor<" + entityName + "> {\n" +
//        "}\n";
//  }
//
//  /*-------------------------------创建Proc---------------------------------*/
//
//  public static void createProc(String tableName, String comment) {
//    //创建controller所在项目的目录位置
//    String dir = DEVELOPMENT +  tableName.substring(0, tableName.indexOf("_")).toLowerCase() +"\\repo";
//    //表名为COM_CURR格式为列，下划线前为其领域 小写
//    String field = tableName.substring(0, tableName.indexOf("_")).toLowerCase();
//    //实体类 以DO结尾
//    String entityName = titleCase(lineToHump(tableName));
//    //Repo Dao层以Repo结尾
//    String classNmae = titleCase(lineToHump(tableName)) + "Proc";
//    //创建实体类 字符串
//    String repoTemplateStr = createProcTemplateStr(field, entityName);
//    //生成、写入文件
//    writeContent(repoTemplateStr, dir, classNmae + ".java");
//  }
//
//  public static String createProcTemplateStr(String field, String entityName) {
//    return "package com.elitesland."+field+".repo;\n" +
//        "\n" +
//        "import com.querydsl.jpa.impl.JPAQueryFactory;\n" +
//        "import lombok.RequiredArgsConstructor;\n" +
//        "import org.springframework.stereotype.Component;\n"+
//        "\n" +
//        "/**\n" +
//        " * <p>\n" +
//        " * 功能说明\n" +
//        " * </p>\n" +
//        " *\n" +
//        " * @author zhao_qiao_gong\n" +
//        " * @date 2020/7/2\n" +
//        " */\n" +
//        "@Component\n" +
//        "@RequiredArgsConstructor\n"+
//        "public class "+entityName+"Proc {\n" +
//        " \n" +
//        "    private final JPAQueryFactory jpaQueryFactory;\n"+
//        " \n" +
//        "}\n";
//  }
//
//  /*-------------------------------创建实体类---------------------------------*/
//
//  /**
//   *创建实体类DO,并生成到指定目录下
//   * @param tableName 表名称
//   * @param comment   描述
//   **/
//  public static void createEntity(String tableName, String comment) {
//    //创建实体类所在项目的目录位置
//    String dir = DEVELOPMENT +  tableName.substring(0, tableName.indexOf("_")).toLowerCase() +"\\entity";
//    //表名为COM_CURR格式为列，下划线前为其领域 小写
//    String field = tableName.substring(0, tableName.indexOf("_")).toLowerCase();
//    //实体类 以DO结尾
//    String entityName = titleCase(lineToHump(tableName)) + "DO";
//    //创建实体类 字符串
//    String entityTemplateStr = createEntityTemplateStr(field, tableName.toLowerCase(), entityName, comment);
//    //生成、写入文件
//    writeContent(entityTemplateStr, dir, entityName + ".java");
//  }
//
//
//  /**
//   * 创建实体类 字符串
//   *
//   * @param field      领域
//   * @param tableName  表名
//   * @param entityName 实体类名称
//   * @param comment    描述
//   * @return 实体类 字符串
//   **/
//  public static String createEntityTemplateStr(String field, String tableName, String entityName, String comment) {
//    return "package com.elitesland." + field + ".entity;\n" +
//        "\n" +
//        "import io.swagger.annotations.ApiModel;\n" +
//        "import io.swagger.annotations.ApiModelProperty;\n" +
//        "import lombok.Data;\n" +
//        "import lombok.experimental.Accessors;\n" +
//        "import com.elitesland.core.base.BaseModel;\n" +
//        "\n" +
//        "import javax.persistence.Column;\n" +
//        "import javax.persistence.Entity;\n" +
//        "import javax.persistence.Table;\n" +
//        "import java.io.Serializable;\n" +
//        "import java.util.Objects;\n" +
//        "/**\n" +
//        " * <p>\n" +
//        " * 功能说明\n" +
//        " * </p>\n" +
//        " *\n" +
//        " * @author zhao_qiao_gong\n" +
//        " * @date 2020/7/2\n" +
//        " */\n" +
//        "@Entity\n" +
//        "@Table(name = \"" + tableName + "\")\n" +
//        "@org.hibernate.annotations.Table(appliesTo = \"" + tableName + "\", comment = \"" + comment + "\")\n" +
//        "@Data\n" +
//        "@Accessors(chain = true)\n" +
//        "@ApiModel(value = \"" + comment + "\", description = \"" + comment + "\")\n" +
//        "public class " + entityName + " extends BaseModel implements Serializable {\n" +
//        "\n" +
//        "    private static final long serialVersionUID = 1L;\n" +
//        "\n" +
//        "}\n";
//
//  }
//
//  /*-------------------------------其他工具---------------------------------*/
//
//  /**
//  * 生成文件，并写入内容
//  * @param entityTemplateStr 实体类字符串
//  * @param dir 目录
//  * @param fileName java文件名称
//  **/
//  public static void writeContent(String entityTemplateStr, String dir, String fileName) {
//    try {
//      Path rootLocation = Paths.get(dir);
//      if (Files.notExists(rootLocation)) {
//        Files.createDirectories(rootLocation);
//      }
//      Path path = rootLocation.resolve(fileName);
//      byte[] strToBytes = entityTemplateStr.getBytes();
//      Files.write(path, strToBytes);
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//
//  }
//
//  private static Pattern linePattern = Pattern.compile("_(\\w)");
//
//  //转驼峰方法
//  public static String lineToHump(String str) {
//    str = str.toLowerCase();
//    Matcher matcher = linePattern.matcher(str);
//    StringBuffer sb = new StringBuffer();
//    while (matcher.find()) {
//      matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
//    }
//    matcher.appendTail(sb);
//    return sb.toString();
//  }
//
//  //首字母大写
//  public static String titleCase(String str) {
//    return str.substring(0, 1).toUpperCase() + str.substring(1);
//  }
//}
