package com.atsz.qtd.config.mybatis;

/**
 * @author : Jerry_Zheng
 * @pakcageName :com.atsz.qtd.config
 * @project : shardingTest
 * @date : 2019/7/23 14:33
 * @description : TODO
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
public class CommonConfig {

    @Bean
    public PathMatchingResourcePatternResolver resourcePatternResolver(){
        return new PathMatchingResourcePatternResolver();
    }
}