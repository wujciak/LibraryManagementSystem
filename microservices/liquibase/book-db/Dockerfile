FROM liquibase/liquibase
ADD changelog /liquibase/changelog
WORKDIR /liquibase/changelog

CMD ["liquibase", "--url=jdbc:postgresql://book-db:5432/patient-db", "--username=admin", "--password=admin", "--changeLogFile=db.changelog.yaml", "update"]