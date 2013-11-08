package liquibase.ext.cachedb.sqlgenerator;

import liquibase.database.Database;
import liquibase.exception.ValidationErrors;
import liquibase.ext.cachedb.database.CacheDatabase;
import liquibase.sqlgenerator.SqlGeneratorChain;
import liquibase.sqlgenerator.core.RenameColumnGenerator;
import liquibase.sqlgenerator.core.RenameTableGenerator;
import liquibase.statement.core.RenameColumnStatement;
import liquibase.statement.core.RenameTableStatement;

public class RenameTableGeneratorCache extends RenameTableGenerator {
    @Override
    public boolean supports(RenameTableStatement statement, Database database) {
        return database instanceof CacheDatabase;
    }

    @Override
    public int getPriority() {
        return PRIORITY_DATABASE;
    }

    @Override
    public ValidationErrors validate(RenameTableStatement renameColumnStatement, Database database, SqlGeneratorChain sqlGeneratorChain) {
        ValidationErrors errors = new ValidationErrors();
        errors.addError("Rename table not supported on Cache");

        return errors;
    }
}
