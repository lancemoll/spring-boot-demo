package com.xkcoding.orm.mybatis.plus.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@ConfigurationProperties
@PropertySource(value = "classpath:my.yml", factory = YamlPropertySourceFactory.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class YamlConfig {

  private Map<String, HashMap<String, List<String>>> map = new HashMap<>();
}
