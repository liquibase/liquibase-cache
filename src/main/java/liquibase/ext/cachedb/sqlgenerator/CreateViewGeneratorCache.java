package liquibase.ext.cachedb.sqlgenerator;

import liquibase.database.Database;
import liquibase.database.core.*;
import liquibase.exception.ValidationErrors;
import liquibase.sqlgenerator.SqlGeneratorChain;
import liquibase.statement.core.CreateViewStatement;

public class CreateViewGeneratorCache extends liquibase.sqlgenerator.core.CreateViewGenerator {

    @Override
    public boolean supports(CreateViewStatement statement, Database database) {
        return database instanceof CacheDatabase;
    }

    @Override
    public int getPriority() {
        return PRIORITY_DATABASE;
    }

    @Override
    public ValidationErrors validate(CreateViewStatement createViewStatement, Database database, SqlGeneratorChain sqlGeneratorChain) {
        ValidationErrors errors = super.validate(createViewStatement, database, sqlGeneratorChain);

        if (createViewStatement.isReplaceIfExists()) {
            errors.checkDisallowedField("replaceIfExists", createViewStatement.isReplaceIfExists(), database, CacheDatabase.class);
        }
        return errors;
    }
}
