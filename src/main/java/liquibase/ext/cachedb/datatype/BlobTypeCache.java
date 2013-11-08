package liquibase.ext.cachedb.datatype;

import liquibase.database.Database;
import liquibase.datatype.DatabaseDataType;
import liquibase.datatype.core.BlobType;
import liquibase.ext.cachedb.database.CacheDatabase;

public class BlobTypeCache extends BlobType {

    @Override
    public boolean supports(Database database) {
        return database instanceof CacheDatabase;
    }

    @Override
    public int getPriority() {
        return PRIORITY_DATABASE;
    }

    @Override
    public DatabaseDataType toDatabaseDataType(Database database) {
        return new DatabaseDataType("LONGVARBINARY");
    }
}
