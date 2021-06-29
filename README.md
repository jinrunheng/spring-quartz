# spring-quartz-demo

this demo shows the basic usage for how to use spring integrates quartz

## Init

use docker start mysql service
```bash
docker run --name my-mysql -e MYSQL_ROOT_PASSWORD=123 -e MYSQL_DATABASE=test -p 3306:3306 -d mysql
```
use flyway migration init DB and data
```bash
mvn flyway:clean flyway:migrate
```

