package liquibase.ext.cachedb.sqlgenerator;

import liquibase.database.Database;
import liquibase.database.core.CacheDatabase;
import liquibase.sqlgenerator.core.ModifyDataTypeGenerator;
import liquibase.statement.core.ModifyDataTypeStatement;

public class ModifyDataTypeGeneratorCache extends ModifyDataTypeGenerator {

    @Override
    public boolean supports(ModifyDataTypeStatement statement, Database database) {
        return database instanceof CacheDatabase;
    }

    @Override
    public int getPriority() {
        return PRIORITY_DATABASE;
    }

    @Override
    protected String getPreDataTypeString(Database database) {
        return " ";
    }
}
