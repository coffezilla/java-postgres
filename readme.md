## postgresql
```create table if not exists users (
id serial primary key,
name varchar(255) not null,
email varchar(255) not null,
created_at TIMESTAMP default current_timestamp
)
```
## Docker compose
```version: '3'
services:
  db:
    image: postgres:13
    container_name: my-postgres
    environment:
      - POSTGRES_DB=postgres
      - POSTGRES_USER=root
      - POSTGRES_PASSWORD=root
    ports:
      - "5433:5432"
    volumes:
      - postgres-data:/var/lib/postgresql/data

volumes:
  postgres-data:
    name: java-exercises
```
Estas são as configurações básicas para rodar a aplicação

