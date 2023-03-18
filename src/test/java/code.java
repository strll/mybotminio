
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class code {
    @Test
    public void run() {

        // 1、创建代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 2、全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        // 此处建议写项目/src/main/java源代码的绝对路径
        gc.setOutputDir("E:\\IDEA-workspace\\mybotminio\\src\\main\\java");
        // 生成注释时的作者
        gc.setAuthor("wxt");
        //生成后是否打开资源管理器
        gc.setOpen(false);
        gc.setFileOverride(false); //重新生成时文件是否覆盖
        gc.setServiceName("%sService");	//去掉Service接口的首字母I
        gc.setIdType(IdType.ID_WORKER_STR); //主键策略
        gc.setDateType(DateType.ONLY_DATE); //定义生成的实体类中日期类型
        // 如果开启Swagger,要引入相应的包
        gc.setSwagger2(true); //开启Swagger2模式

        mpg.setGlobalConfig(gc);

        // 3、数据源配置

        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://:3307/qqrobot?useUnicode=true&useSSL=false&characterEncoding=utf8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("用户名");
        dsc.setPassword("密码");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);
;

        // 4、包配置
        PackageConfig pc = new PackageConfig();
        // 此处要注意：parent + moduleName 为包的名字，在这个包下，创建对应的controller...
        pc.setParent("com.wxt");
        pc.setModuleName("myservice"); //模块名
        pc.setController("controller");
        pc.setEntity("entity");
        pc.setService("service");
        pc.setMapper("mapper");
        mpg.setPackageInfo(pc);

        // 5、策略配置
        StrategyConfig strategy = new StrategyConfig();
        // 数据库中表的名字，表示要对哪些表进行自动生成controller service、mapper...
        strategy.setInclude("message","todayeat");
        // 数据库表映射到实体的命名策略,驼峰命名法
        strategy.setNaming(NamingStrategy.underline_to_camel);
        // 生成实体时去掉表前缀，比如edu_course，如果不加下面这句，生成的实体类名字就是：EduCourse
        strategy.setTablePrefix("");
        //生成实体时去掉表前缀
        // strategy.setTablePrefix(pc.getModuleName() + "_");

        //数据库表字段映射到实体的命名策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true); // lombok 模型 @Accessors(chain = true) setter链式操作

        strategy.setRestControllerStyle(true); //restful api风格控制器
        strategy.setControllerMappingHyphenStyle(true); //url中驼峰转连字符

        mpg.setStrategy(strategy);

        // 6、执行
        mpg.execute();
    }
}
