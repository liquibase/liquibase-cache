package liquibase.ext.cachedb.datatype;

import liquibase.database.Database;
import liquibase.datatype.DatabaseDataType;
import liquibase.datatype.core.ClobType;
import liquibase.ext.cachedb.database.CacheDatabase;

public class ClobTypeCache extends ClobType {
    @Override
    public int getPriority() {
        return PRIORITY_DATABASE;
    }

    @Override
    public boolean supports(Database database) {
        return database instanceof CacheDatabase;
    }

    @Override
    public DatabaseDataType toDatabaseDataType(Database database) {
        return new DatabaseDataType("LONGVARCHAR");
    }
}
