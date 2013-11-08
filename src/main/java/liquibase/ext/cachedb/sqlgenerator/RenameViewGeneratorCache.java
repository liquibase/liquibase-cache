package liquibase.ext.cachedb.sqlgenerator;

import liquibase.database.Database;
import liquibase.exception.ValidationErrors;
import liquibase.ext.cachedb.database.CacheDatabase;
import liquibase.sqlgenerator.SqlGeneratorChain;
import liquibase.sqlgenerator.core.RenameViewGenerator;
import liquibase.statement.core.RenameViewStatement;

public class RenameViewGeneratorCache extends RenameViewGenerator {
    @Override
    public boolean supports(RenameViewStatement statement, Database database) {
        return database instanceof CacheDatabase;
    }

    @Override
    public int getPriority() {
        return PRIORITY_DATABASE;
    }

    @Override
    public ValidationErrors validate(RenameViewStatement renameColumnStatement, Database database, SqlGeneratorChain sqlGeneratorChain) {
        ValidationErrors errors = new ValidationErrors();
        errors.addError("Rename view not supported on Cache");

        return errors;
    }
}
