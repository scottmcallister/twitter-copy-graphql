# twitter-copy-graphql

A simple Twitter clone using React/Apollo to connect to a GraphQL Spring Boot API. This app supports viewing tweets made by other users, viewing user profiles, and creating new tweets. 
 
The purpose of this project is not to completely copy the functionality of Twitter. This project was created to explore how web applications built with Java and React can use GraphQL as an alternative to REST. 

## Screenshots

<img src="/screenshots/twitter-home.png" width="400px" height="330px" alt="Home Page" style="margin: auto;"> <img src="/screenshots/twitter-new-tweet.png" width="400px" height="330px" alt="New Tweet" style="margin: auto;"> <img src="/screenshots/twitter-profile.png" width="400px" height="330px" alt="Profile Page" style="margin: auto;">


## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

Ensure you have the following installed on your machine: 
- Java 8
- Maven
- Node JS & NPM
- Yarn

### Installing

The GraphQL API can be started like any other Maven project

```
$ cd /path/to/graphqldemo/graphql-service
$ mvn clean install
$ java -jar /target/graphql-service-0.0.1-SNAPSHOT.jar
```

Alternatively, you could compile the graphql-service project and run the `DemoApplication` main method in your IDE.

Once you have the API running, you should switch to another termial window before booting up the UI. To set up the React UI, you'll need to install your dependencies and run the `start` command through Yarn.

```
$ cd /path/to/graphqldemo/apollo-ui
$ yarn install
$ yarn run start
```

After both the UI and API are running, you should be able to see the app in your browser at [http://localhost:3000](http://localhost:3000).

## Built With

* [GraphQL](http://graphql.org/) - Back end service architecture
* [Apollo](https://www.apollographql.com/) - Front end tool for GraphQL interaction
* [Spring Boot](https://projects.spring.io/spring-boot/) - API framework used
* [Maven](https://maven.apache.org/) - Java Dependency Management
* [Yarn](https://yarnpkg.com/en/) - JS Dependency Management
* [React](https://reactjs.org/) - UI Library
