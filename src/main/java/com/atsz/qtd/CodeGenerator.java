package com.atsz.qtd;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * 执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
 *
 * @author Jerry
 */
public class CodeGenerator {

    private static String packageName = "com.atsz.qtd";
    private static String outDir = "E:\\Java\\code\\git\\shardingTest\\src\\main\\";
    private static String outDirStatic = outDir + "webapp\\templates\\";
    private static String outDirDTOs = outDir + "webapp\\templates\\";
    private static String entity = "entity";
    private static String mapper = "mapper";
    private static String service = "infratrucature";
    private static String impl = "infratrucature.impl";
    private static String controller = "controller";
    private static String xml = "mapper.xml";
    private static boolean isOverEntity = false;
    private static boolean isOverController = false;
    private static boolean isOverService = false;
    private static boolean isOverServiceImpl = false;
    private static boolean isOverMapper = false;
    private static boolean isOverXml = false;

    private static String superControllerClass = "com.atsz.qtd.pioneer.core.base.controller.BaseController";
    //private  static  String SuperControllerClassPackage="com.atsz.qtd.pioneer.core.base.controller.BaseController";


    //private static String getInputDtoVM = "/templates/request.java.vm";
    private static String controllerVM = "/templates/controller.java.vm";


    private static String mapperJava = "/templates/mapper.java.vm";
    private static String mapperXml = "/templates/mapper.xml.vm";

    private static String restcontrollerVM = "/templates/restcontroller.java.vm";
    private static String entityVM = "/templates/entity.java";
    private static String serviceVM = "/templates/service.java";
    private static String serviceImplVM = "/templates/serviceImpl.java";

    private static String xmlVM = "/templates/mapper.xml";
    private static String TablePrefix = "tb_";
    private static String[] baseDir = {entity, mapper, service, impl, controller};

    public static void main(String[] args) {
        boolean serviceNameStartWithI = true;
        // generateByTables(serviceNameStartWithI, packageName,TablePrefix,"ttf_project_version");
        generateByTables(false, packageName, TablePrefix,
                "tb_testinfo_2019");
        //                //"teifsinfo");
    }

    private static void generateByTables(boolean serviceNameStartWithI, String packageName, String TablePrefix, String... tableNames) {
        GlobalConfig config = new GlobalConfig();
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/ems_0?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true");
       config.setOpen(false);
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("display12#");
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
                .setCapitalMode(false)
                .setEntityLombokModel(true)
                //.setDbColumnUnderline(true)
                .setRestControllerStyle(true)
                //.setSuperControllerClass(superControllerClass)
                .entityTableFieldAnnotationEnable(false)
                .setNaming(NamingStrategy.underline_to_camel)
                .setTablePrefix(TablePrefix)
                //修改替换成你需要的表名，多个表名传数组
                .setInclude(tableNames);

        config.setActiveRecord(true)
                .setAuthor("Jerry")
                .setOutputDir(outDir + "java\\")
                .setBaseResultMap(true)
                .setBaseColumnList(true)
                .setFileOverride(true)
                .setEnableCache(false)
                .setSwagger2(true)
                // XML ResultMap
                .setBaseResultMap(true)
                // XML columList;
                .setBaseColumnList(true);
        if (!serviceNameStartWithI) {
            config.setServiceName("%sService");
        }
        PackageConfig pcf = initPackage();
        AutoGenerator generator = new AutoGenerator().setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setPackageInfo(pcf)
                .setStrategy(strategyConfig);

        generator.execute();
    }
    private static PackageConfig initPackage() {
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent(packageName);
        return packageConfig;
    }
}
