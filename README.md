# GraphQL Spring Boot + Angular example

This repository contains a working example of how to integrate GraphQL
with an existing Spring Boot server and Angular client.

## Start the server

### Prerequisites

Install the dependencies:

```
mvn clean install
```

### Run Spring Boot server

Run **GraphQLSpringBootApplication.java**

### Query GraphQL endpoints

Try out queries with Graph*i*QL:

```
localhost:8080/graphiql
```

Perform POST requests to the actual GraphQL endpoint:

```
localhost:8080/graphql
```


## Start the client

### Prerequisites

Install the dependencies:

```
npm install
```

Make sure you have the [Angular CLI](https://angular.io/cli):

```
npm install -g @angular/cli
```

### Run the Angular client

Start the client:

```
ng serve
```

and navigate to:

```
localhost:4200
```

## Blog Post

This repository is referenced in a blog post of mine. [Check it out here](https://alexandertang.github.io/blogs/dev/graphql).