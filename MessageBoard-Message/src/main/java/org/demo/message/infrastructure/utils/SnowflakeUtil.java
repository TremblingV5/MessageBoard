package org.demo.message.infrastructure.utils;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.id.IdentifierGenerator;

import javax.annotation.PostConstruct;
import java.io.Serializable;

@Slf4j
public class SnowflakeUtil implements IdentifierGenerator {
    public static long WORKER_ID = 1;
    public static long DATACENTER_ID = 1;

    private Snowflake snowflake = IdUtil.getSnowflake(WORKER_ID, DATACENTER_ID);

    @PostConstruct
    public void init() {
        WORKER_ID = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
    }

    public synchronized long snowflakeId() {
        return snowflake.nextId();
    }

    public synchronized long snowflakeId(long workerId, long datacenterId) {
        return IdUtil.getSnowflake(workerId, datacenterId).nextId();
    }

    @Override
    public void configure(org.hibernate.type.Type type, java.util.Properties properties, org.hibernate.service.ServiceRegistry serviceRegistry) throws org.hibernate.MappingException {

    }

    @Override
    public Serializable generate(org.hibernate.engine.spi.SharedSessionContractImplementor session, Object object) throws org.hibernate.HibernateException {
        return snowflakeId(WORKER_ID, DATACENTER_ID);
    }
}
