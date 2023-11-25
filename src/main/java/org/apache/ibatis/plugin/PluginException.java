package org.apache.ibatis.plugin;

import org.apache.ibatis.exceptions.PersistenceException;

/**
 * @author Clinton Begin
 */
public class PluginException extends PersistenceException {

  private static final long serialVersionUID = 8548771664564998595L;

  public PluginException() {
  }

  public PluginException(String message) {
    super(message);
  }

  public PluginException(String message, Throwable cause) {
    super(message, cause);
  }

  public PluginException(Throwable cause) {
    super(cause);
  }
}
