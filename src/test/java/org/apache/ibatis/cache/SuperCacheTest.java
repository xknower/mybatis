package org.apache.ibatis.cache;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.ibatis.cache.decorators.FifoCache;
import org.apache.ibatis.cache.decorators.LruCache;
import org.apache.ibatis.cache.decorators.ScheduledCache;
import org.apache.ibatis.cache.decorators.SerializedCache;
import org.apache.ibatis.cache.decorators.SoftCache;
import org.apache.ibatis.cache.decorators.SynchronizedCache;
import org.apache.ibatis.cache.decorators.TransactionalCache;
import org.apache.ibatis.cache.decorators.WeakCache;
import org.apache.ibatis.cache.impl.PerpetualCache;
import org.junit.jupiter.api.Test;

class SuperCacheTest {

  @Test
  void shouldDemonstrate5LevelSuperCacheHandlesLotsOfEntriesWithoutCrashing() {
    final int N = 100000;
    Cache cache = new PerpetualCache("default");
    cache = new LruCache(cache);
    cache = new FifoCache(cache);
    cache = new SoftCache(cache);
    cache = new WeakCache(cache);
    cache = new ScheduledCache(cache);
    cache = new SerializedCache(cache);
    // cache = new LoggingCache(cache);
    cache = new SynchronizedCache(cache);
    cache = new TransactionalCache(cache);
    for (int i = 0; i < N; i++) {
      cache.putObject(i, i);
      ((TransactionalCache) cache).commit();
      Object o = cache.getObject(i);
      assertTrue(o == null || i == (Integer) o);
    }
    assertTrue(cache.getSize() < N);
  }

}
