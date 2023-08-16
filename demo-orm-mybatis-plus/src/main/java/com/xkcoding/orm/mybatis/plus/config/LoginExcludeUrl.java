package com.xkcoding.orm.mybatis.plus.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "mj.test")
@Component
@Data
public class LoginExcludeUrl {

    private Map<String, List<String>> exclude = new HashMap<>();

    public List<String> getExclude(String appPrev) {
        return exclude.get(appPrev);
    }

}
