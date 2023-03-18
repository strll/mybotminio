
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

        // 1����������������
        AutoGenerator mpg = new AutoGenerator();

        // 2��ȫ������
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        // �˴�����д��Ŀ/src/main/javaԴ����ľ���·��
        gc.setOutputDir("E:\\IDEA-workspace\\mybotminio\\src\\main\\java");
        // ����ע��ʱ������
        gc.setAuthor("wxt");
        //���ɺ��Ƿ����Դ������
        gc.setOpen(false);
        gc.setFileOverride(false); //��������ʱ�ļ��Ƿ񸲸�
        gc.setServiceName("%sService");	//ȥ��Service�ӿڵ�����ĸI
        gc.setIdType(IdType.ID_WORKER_STR); //��������
        gc.setDateType(DateType.ONLY_DATE); //�������ɵ�ʵ��������������
        // �������Swagger,Ҫ������Ӧ�İ�
        gc.setSwagger2(true); //����Swagger2ģʽ

        mpg.setGlobalConfig(gc);

        // 3������Դ����

        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://:3307/qqrobot?useUnicode=true&useSSL=false&characterEncoding=utf8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("�û���");
        dsc.setPassword("����");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);
;

        // 4��������
        PackageConfig pc = new PackageConfig();
        // �˴�Ҫע�⣺parent + moduleName Ϊ�������֣���������£�������Ӧ��controller...
        pc.setParent("com.wxt");
        pc.setModuleName("myservice"); //ģ����
        pc.setController("controller");
        pc.setEntity("entity");
        pc.setService("service");
        pc.setMapper("mapper");
        mpg.setPackageInfo(pc);

        // 5����������
        StrategyConfig strategy = new StrategyConfig();
        // ���ݿ��б�����֣���ʾҪ����Щ������Զ�����controller service��mapper...
        strategy.setInclude("message","todayeat");
        // ���ݿ��ӳ�䵽ʵ�����������,�շ�������
        strategy.setNaming(NamingStrategy.underline_to_camel);
        // ����ʵ��ʱȥ����ǰ׺������edu_course���������������䣬���ɵ�ʵ�������־��ǣ�EduCourse
        strategy.setTablePrefix("");
        //����ʵ��ʱȥ����ǰ׺
        // strategy.setTablePrefix(pc.getModuleName() + "_");

        //���ݿ���ֶ�ӳ�䵽ʵ�����������
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true); // lombok ģ�� @Accessors(chain = true) setter��ʽ����

        strategy.setRestControllerStyle(true); //restful api��������
        strategy.setControllerMappingHyphenStyle(true); //url���շ�ת���ַ�

        mpg.setStrategy(strategy);

        // 6��ִ��
        mpg.execute();
    }
}
