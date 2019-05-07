package com.el.springboot.configure;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: roman.zhang
 * @Date: 2019/4/29 11:07
 * @Version:V1.0
 * @Description:MapperScanConfigure
 */
@Configuration
@MapperScan(value = {
        "com.el.springboot.mapper",
        "com.el.springboot.*.mapper",
        "com.el.springboot.*.*.mapper",
})
public class MapperScanConfigure {
}
