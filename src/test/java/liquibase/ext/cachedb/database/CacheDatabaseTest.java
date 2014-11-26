package liquibase.ext.cachedb.database;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CacheDatabaseTest {


    @Test
    public void getShortName() {
        assertEquals("cache", new CacheDatabase().getShortName());
    }
}
