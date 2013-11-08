package liquibase.ext.cachedb.datatype;

import liquibase.database.Database;
import liquibase.datatype.DatabaseDataType;
import liquibase.datatype.core.BooleanType;
import liquibase.ext.cachedb.database.CacheDatabase;

public class BooleanTypeCache extends BooleanType {

    @Override
    public int getPriority() {
        return PRIORITY_DATABASE;
    }

    @Override
    public boolean supports(Database database) {
        return database instanceof CacheDatabase;
    }

    @Override
    protected boolean isNumericBoolean(Database database) {
        return true;
    }

    @Override
    public DatabaseDataType toDatabaseDataType(Database database) {
        return new DatabaseDataType("INT");
    }
}
