package com.example.demo.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.annotation.Resource;
import javax.sql.DataSource;


@Configuration
@MapperScan(basePackages = {"com.example.demo.dao.write"},sqlSessionFactoryRef = "writeSqlSessionFactory")
public class MyBatisWriterConfig {
    @Resource(name = "writeDataSource")
    private DataSource dataSource;
    @Bean("writeSqlSessionFactory")
    public SqlSessionFactory writeSqlSessionFactory() throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/write/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }
    @Bean("writeSqlSessionTemplate")
    public SqlSessionTemplate writeSqlSessionTemplate() throws Exception{
        SqlSessionTemplate sqlSessionTemplate=new SqlSessionTemplate(writeSqlSessionFactory());
        return sqlSessionTemplate;
    }

}
