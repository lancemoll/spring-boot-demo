package com.xkcoding.sharding.jdbc.config;

import com.xkcoding.sharding.jdbc.utils.ConsistentHashUtils;
import com.xkcoding.sharding.jdbc.utils.MD5Utils;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.sharding.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.RangeShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.StandardShardingAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Properties;

/**
 * ShardingAlgorithm
 *
 * <p>
 * <a href="CapitalAccountingRecordTableShardingAlgorithm.java"><i>View Source</i></a>
 *
 * @author zhaoxy
 * Date: 11/12/2022 9:42 PM
 */
@Component
@Slf4j
public class ConsistentShardingLongAlgorithm implements StandardShardingAlgorithm<Long> {
    @Getter
    private Properties props;
    private final static int VIRTUAL_NODE_NUMS = 50;

    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Long> shardingValue) {
        if (log.isDebugEnabled()) {
            log.debug("===>collection: {}, shardingVal: {}", collection, shardingValue);
        }

        Long id = shardingValue.getValue();

        return ConsistentHashUtils.getCollection(collection, MD5Utils.encode32(String.valueOf(id)), VIRTUAL_NODE_NUMS);
    }

    @Override
    public Collection<String> doSharding(Collection<String> collection, RangeShardingValue<Long> rangeShardingValue) {
        return null;
    }


    @Override
    public String getType() {
        return "CONSISTENT_HASH_LONG";
    }



    @Override
    public void init(Properties properties) {
        this.props=properties;
    }
}
