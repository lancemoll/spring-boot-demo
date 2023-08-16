package com.xkcoding.orm.mybatis.plus.config;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

import java.io.IOException;
import java.util.Properties;

/**
 * <p>
 * <a href="YamlPropertySourceFactory.java"><i>View Source</i></a>
 *
 * @author elin.zhou
 * Date: 2023/4/21 16:56
 */
public class YamlPropertySourceFactory implements PropertySourceFactory {
  @Override
  public PropertySource<?> createPropertySource(String name, EncodedResource encodedResource) throws IOException {
    YamlPropertiesFactoryBean factory = new YamlPropertiesFactoryBean();
    factory.setResources(encodedResource.getResource());
    Properties properties = factory.getObject();
    return new PropertiesPropertySource(encodedResource.getResource().getFilename(), properties);
  }
}
