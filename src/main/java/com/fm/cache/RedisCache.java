package com.fm.cache;

import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import redis.clients.jedis.exceptions.JedisConnectionException;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created on 2018/10/21.
 *
 * @author guochangji
 */
// 基于Redis的MyBatis二级缓存的实现

public class RedisCache implements Cache {


        // 需要中间类对其进行静态注

        private static JedisConnectionFactory jedisConnectionFactory;

        private final String id;

        private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);


        public static void setJedisConnectionFactory(JedisConnectionFactory jedisConnectionFactory) {
            RedisCache.jedisConnectionFactory = jedisConnectionFactory;
        }

        // 根据标识构造缓存对象

        public RedisCache(String id) {
            if (id == null){
                // 抛出非法参数异常
                throw new IllegalArgumentException("缓存id不能为空");
            }
            this.id = id;
        }
        /**
         * 获取缓存对象的唯一标准
         *
         */
        @Override
        public String getId() {
            return this.id;
        }
        /**
         * 把key/value保存到缓存对象中
         */
        @Override
        public void putObject(Object key, Object value) {

            JedisConnection jedisConnection = null;
            try {
                //操作readis进行保存
                jedisConnection = (JedisConnection) jedisConnectionFactory.getConnection();
                //创建一个序列化工具
                RedisSerializer<Object> serializer = new JdkSerializationRedisSerializer();

                // 创建连接,保存key的value
                jedisConnection.set(serializer.serialize(key),serializer.serialize(value));
            }catch (JedisConnectionException e){
                e.printStackTrace();
            }finally {
                if (jedisConnection != null){
                    jedisConnection.close();
                }
            }

        }
        @Override
        public Object getObject(Object key) {
            // 通过key从缓存对象中获取value

            Object result = null;
            JedisConnection jedisConnection = null;
            try {
                // 建立连接
                jedisConnection = (JedisConnection) jedisConnectionFactory.getConnection();

                RedisSerializer<Object> serializer= new JdkSerializationRedisSerializer();

                byte[] bytes = jedisConnection.get(serializer.serialize(key));

                // 1. 将key序列化
                // 2. 通过connection获取序列化的value
                // 3. 将序列化的value反序列化

                result = serializer.deserialize(bytes);


                /**
                 * 序列化的是数据
                 * 不会序列化类结构
                 * 但会序列化关系(数据对应的类结构)
                 */


            }catch (JedisConnectionException e){
                e.printStackTrace();
            }finally {
                if (jedisConnection != null){
                    jedisConnection.close();
                }
            }
            return result;
        }

        /**
         * 不是需要实现的方法,没有被核心框架调用
         * 方法作用: 根据key移除对应的value
         */
        @Override
        public Object removeObject(Object key) {

            Object result = null;
            JedisConnection jedisConnection = null;
            try {
                // 建立连接
                jedisConnection = (JedisConnection) jedisConnectionFactory.getConnection();

                RedisSerializer<Object> serializer= new JdkSerializationRedisSerializer();

                // 移除保存到的值
                result = jedisConnection.expire(serializer.serialize(key),0);

            }catch (JedisConnectionException e){
                e.printStackTrace();
            }finally {
                if (jedisConnection != null){
                    jedisConnection.close();
                }
            }
            return result;
        }

        // 清除缓存(操作影响性能,效率低,不建议经常清除)

        @Override
        public void clear() {
            JedisConnection jedisConnection = null;
            try {
                jedisConnection = (JedisConnection) jedisConnectionFactory.getConnection();
                // 清除缓存
                jedisConnection.flushDb();
                // 清除设置
                jedisConnection.flushAll();

            }catch (JedisConnectionException e){

            }finally {
                if (jedisConnection != null){
                    jedisConnection.close();
                }
            }
        }

        /**
         * 获取缓存对象中存取的key/value的数量
         * @return
         */
        @Override
        public int getSize() {
            Integer count = 0;
            JedisConnection jedisConnection = null;
            try {
                jedisConnection = (JedisConnection) jedisConnectionFactory.getConnection();

                count = Integer.valueOf(jedisConnection.dbSize().toString());

            }catch (JedisConnectionException e){

            }finally {
                if (jedisConnection != null){
                    jedisConnection.close();
                }
            }
            return count;
        }

        // 获取读写锁
        // 从mybatis的3.2.6版本,这个方法不再被框架核心调用
        // 所有需要的锁,都必须由缓存供应商来提供

        @Override
        public ReadWriteLock getReadWriteLock() {
            return this.readWriteLock;
        }
    }
