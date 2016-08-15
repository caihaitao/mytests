package com.cc.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;


/**
 * Created by Administrator on 2016/8/15.
 */
@Configuration
@MapperScan(basePackages = "com.cc.mapper")
public class MysqlConfig {

    @Value("${datasource.driver}")
    private String driverClass;
    @Value("${datasource.url}")
    private String jdbcUrl;
    @Value("${datasource.username}")
    private String username;
    @Value("${datasource.password}")
    private String password;
    @Value("${datasource.acquireIncrement}")
    private Integer acquireIncrement;
    @Value("${datasource.idleConnectionTestPeriod}")
    private Integer idleConnectionTestPeriod;
    @Value("${datasource.maxPoolSize}")
    private Integer maxPoolSize;
    @Value("${datasource.maxStatements}")
    private Integer maxStatements;
    @Value("${datasource.minPoolSize}")
    private Integer minPoolSize;

    @Bean
    public DataSource dataSource() throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(driverClass);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        dataSource.setAcquireIncrement(acquireIncrement);
        dataSource.setIdleConnectionTestPeriod(idleConnectionTestPeriod);
        dataSource.setMaxPoolSize(maxPoolSize);
        dataSource.setMaxStatements(maxStatements);
        dataSource.setMinPoolSize(minPoolSize);

        return dataSource;
    }

    @Bean
    public DataSourceTransactionManager transactionManager() throws Exception {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new ClassPathResource[]{new ClassPathResource("mysql/PersonMapper.xml"),
                new ClassPathResource("mysql/CandidateMapper.xml")});
        return sqlSessionFactoryBean.getObject();
    }
}
