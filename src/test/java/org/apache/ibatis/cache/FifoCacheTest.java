package org.apache.ibatis.cache;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.apache.ibatis.cache.decorators.FifoCache;
import org.apache.ibatis.cache.impl.PerpetualCache;
import org.junit.jupiter.api.Test;

class FifoCacheTest {

  @Test
  void shouldRemoveFirstItemInBeyondFiveEntries() {
    FifoCache cache = new FifoCache(new PerpetualCache("default"));
    cache.setSize(5);
    for (int i = 0; i < 5; i++) {
      cache.putObject(i, i);
    }
    assertEquals(0, cache.getObject(0));
    cache.putObject(5, 5);
    assertNull(cache.getObject(0));
    assertEquals(5, cache.getSize());
  }

  @Test
  void shouldRemoveItemOnDemand() {
    FifoCache cache = new FifoCache(new PerpetualCache("default"));
    cache.putObject(0, 0);
    assertNotNull(cache.getObject(0));
    cache.removeObject(0);
    assertNull(cache.getObject(0));
  }

  @Test
  void shouldFlushAllItemsOnDemand() {
    FifoCache cache = new FifoCache(new PerpetualCache("default"));
    for (int i = 0; i < 5; i++) {
      cache.putObject(i, i);
    }
    assertNotNull(cache.getObject(0));
    assertNotNull(cache.getObject(4));
    cache.clear();
    assertNull(cache.getObject(0));
    assertNull(cache.getObject(4));
  }

  @Test
  void shouldRiseConflictInBeyondFiveEntries() {
    FifoCache cache = new FifoCache(new PerpetualCache("default"));
    cache.setSize(5);
    for (int i = 0; i < 5; i++) {
      cache.putObject(i, i);
    }
    cache.removeObject(1);
    cache.putObject(1, 1);
    assertNotNull(cache.getObject(0));
  }

}
