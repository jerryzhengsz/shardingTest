package com.atsz.qtd.config;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author : Jerry_Zheng
 * @pakcageName :com.atsz.qtd.config
 * @project : shardingTest
 * @date : 2019/7/23 09:52
 * @description : TODO
 */
//@Configuration
//@Slf4j

@AutoConfigureAfter(DataSource.class)
public class MybatisplusConfiguration {
    private final DataSource dataSource;

    private DataSource shardingDataSource;

    @Autowired
    public MybatisplusConfiguration(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * /**
     * 设置数据源为sharding jdbc
     *
     * @return
     */
    @Bean
    public MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean() {
        MybatisSqlSessionFactoryBean mysqlplus = new MybatisSqlSessionFactoryBean();
        mysqlplus.setDataSource(this.getShardingDataSource());
        return mysqlplus;
    }

    public DataSource getShardingDataSource() {
        return this.shardingDataSource;
    }


}
