package liquibase.ext.cachedb.database;

import liquibase.sdk.supplier.database.ConnectionConfiguration;

public class CacheDatabaseConfigStandard extends ConnectionConfiguration {
    @Override
    public String getDatabaseShortName() {
        return CacheDatabase.PRODUCT_NAME;
    }

    @Override
    public String getConfigurationName() {
        return NAME_STANDARD;
    }

    @Override
    public String getUrl() {
        return "jdbc:Cache://"+ getHostname() +":1972/liquibase";
    }
}
