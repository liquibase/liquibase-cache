package liquibase.ext.cachedb.datatype;

import liquibase.database.Database;
import liquibase.datatype.DatabaseDataType;
import liquibase.datatype.core.CurrencyType;
import liquibase.ext.cachedb.database.CacheDatabase;

import java.util.Currency;

public class CurrencyTypeCache extends CurrencyType {
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
        return new DatabaseDataType("MONEY");
    }

}
