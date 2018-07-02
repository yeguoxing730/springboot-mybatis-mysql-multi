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
@MapperScan(basePackages = {"com.example.demo.dao.read"},sqlSessionFactoryRef = "readSqlSessionFactory")
public class MyBatisReaderConfig {

    @Resource(name = "readDataSource")
    private DataSource dataSource;
    @Bean("readSqlSessionFactory")
    public SqlSessionFactory readSqlSessionFactory() throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/read/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean("readSqlSessionTemplate")
    public SqlSessionTemplate readSqlSessionTemplate() throws Exception{
        SqlSessionTemplate sqlSessionTemplate=new SqlSessionTemplate(readSqlSessionFactory());
        return sqlSessionTemplate;
    }

}
