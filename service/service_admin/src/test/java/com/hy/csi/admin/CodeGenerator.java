package com.gyf.guli.service.edu;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CodeGenerator {

    @Test
    public void genCode() {

        String prefix = "csi_";
        String moduleName = "admin";

        // 1、创建代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 2、全局配置GlobalConfig
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");//当前项目所在路径
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("gyf");
        gc.setOpen(false); //生成后是否打开资源管理器
        gc.setFileOverride(false); //重新生成时文件是否覆盖
        gc.setServiceName("%sService");	//去掉Service接口的首字母I
        // gc.setIdType(IdType.ASSIGN_ID); //主键策略
        gc.setDateType(DateType.ONLY_DATE);//定义生成的实体类中日期类型 java.util.data
        gc.setSwagger2(true);//开启Swagger2模式
        mpg.setGlobalConfig(gc);// 设置给代码生成器

        // 3、数据源配置DataSourceConfig
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/" + prefix + "home_" + moduleName + "?serverTimezone=GMT%2B8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("1234");
        dsc.setDbType(DbType.MYSQL);//数据库的版本
        mpg.setDataSource(dsc); // 设置给代码生成器

        // 4、包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(moduleName); //模块名
        pc.setParent("com.hy.csi.home.service");
        pc.setController("controller"); // web层
        pc.setEntity("entity");         // 实体层
        pc.setService("service");       // 业务层
        pc.setMapper("mapper");         // mapper层
        mpg.setPackageInfo(pc); // 设置给代码生成器

        // 5、生成策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);//数据库表映射到实体的命名策略
        strategy.setTablePrefix(moduleName + "_");//设置表前缀不生成

        strategy.setColumnNaming(NamingStrategy.underline_to_camel);//数据库表字段映射到实体的命名策略
        strategy.setEntityLombokModel(true); // lombok 模型 @Accessors(chain = true) setter链式操作

        strategy.setLogicDeleteFieldName("is_deleted");//逻辑删除字段名
        strategy.setEntityBooleanColumnRemoveIsPrefix(true);//去掉布尔值的is_前缀

        //自动填充
        TableFill gmtCreate = new TableFill("gmt_create", FieldFill.INSERT);
        TableFill gmtModified = new TableFill("gmt_modified", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(gmtCreate);
        tableFills.add(gmtModified);
        strategy.setTableFillList(tableFills);

        strategy.setRestControllerStyle(true); //restful api风格控制器
        strategy.setControllerMappingHyphenStyle(true); //url中驼峰转连字符

        mpg.setStrategy(strategy); // 设置给代码生成器

        // 设置BaseEntity
        strategy.setSuperEntityClass("com.hy.csi.home.service.base.model.BaseEntity");
        // 填写BaseEntity中的公共字段,公共字段直接extends
        strategy.setSuperEntityColumns("id", "gmt_create", "gmt_update");

        // 6、执行
        mpg.execute();
    }
}
