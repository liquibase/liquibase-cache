package liquibase.ext.cachedb.sqlgenerator;

import liquibase.change.core.RenameColumnChange;
import liquibase.database.Database;
import liquibase.exception.ValidationErrors;
import liquibase.ext.cachedb.database.CacheDatabase;
import liquibase.sqlgenerator.SqlGeneratorChain;
import liquibase.sqlgenerator.core.RenameColumnGenerator;
import liquibase.statement.core.RenameColumnStatement;

public class RenameColumnGeneratorCache extends RenameColumnGenerator {
    @Override
    public boolean supports(RenameColumnStatement statement, Database database) {
        return database instanceof CacheDatabase;
    }

    @Override
    public int getPriority() {
        return PRIORITY_DATABASE;
    }

    @Override
    public ValidationErrors validate(RenameColumnStatement renameColumnStatement, Database database, SqlGeneratorChain sqlGeneratorChain) {
        ValidationErrors errors = new ValidationErrors();
        errors.addError("Rename column not supported on Cache");

        return errors;
    }
}
