package com.sein.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ldb on 2017/7/12.
 * 数据库接口扫描配置类
 */
@Configuration
@MapperScan(basePackages = "com.sein.dao")
public class MyBatisMapperScannerConfig {
}
