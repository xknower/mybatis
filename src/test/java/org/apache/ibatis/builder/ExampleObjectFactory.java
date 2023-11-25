package org.apache.ibatis.builder;

import java.util.List;
import java.util.Properties;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

public class ExampleObjectFactory extends DefaultObjectFactory {
  private static final long serialVersionUID = 1L;
  private Properties properties;

  @Override
  public <T> T create(Class<T> type) {
    return super.<T>create(type);
  }

  @Override
  public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
    return super.<T>create(type, constructorArgTypes, constructorArgs);
  }

  @Override
  public void setProperties(Properties properties) {
    super.setProperties(properties);
    this.properties = properties;
  }

  public Properties getProperties() {
    return properties;
  }

}
