package com.atsz.qtd.config.sharding;

import io.shardingsphere.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.PreciseShardingAlgorithm;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

/**
 * @author : Jerry_Zheng
 * @pakcageName :com.atsz.qtd.config.sharding
 * @project : shardingTest
 * @date : 2019/7/22 16:05
 * @description : TODO
 */
public class TableShardingByYearAlgorithm implements PreciseShardingAlgorithm<LocalDateTime> {


    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<LocalDateTime> shardingValue) {
        String tb_name = shardingValue.getLogicTableName() + "_";
        String year = shardingValue.getValue().format(DateTimeFormatter.ofPattern("yyyy"));
        return tb_name + year;
    }
}
