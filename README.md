# FlywayDbMigrationOracle

This project introduces the basics of data migration using Flyway, Maven, SQL and Jenkins.

> flyway [options] baseline - Baselines an existing database, excluding all migrations up to and including baselineVersion.

> mvn flyway:migrate - Migrates the schema to the latest version. Flyway will create the schema history table automatically if it doesn’t exist.

> mvn flyway:clean - Drops all objects (tables, views, procedures, triggers, …) in the configured schemas.

> mvn flyway:repair - Repairs the Flyway schema history table by removing any failed migrations on databases without DDL transactions
(User objects left behind must still be cleaned up manually), realigning the checksums, descriptions and types of the applied migrations with the ones of the available migrations<

> mvn flyway:info - Prints the details and status information about all the migrations.

> mvn flyway:baseline - Baselines an existing database, excluding all migrations up to and including baselineVersion.


Jenkins environment variables

To create a new environment variable at Jenkins:

1- Jenkins -> Manage Jenkins -> Configure System -> Environment Variables


