<h1 align="center">
  <img alt="" src="" width="224px"/><br/>
  Project Drone Feeder
</h1>


<p align="center">
  <img src="https://img.shields.io/badge/Quarkus-2.10+-4695EB?style=for-the-badge&logo=quarkus" alt="quarkus version" />
  <img src="https://img.shields.io/badge/JUnit_Cover-57.3%25-success?style=for-the-badge&logo=none" alt="JUnit cover" />
</p>
<!-- What is? -->

---

## Basic Overview

Drone Feeder is a project to training Java Web with Quarkus to solve a problem for FutuereH enterprise.

The company FutuereH obtained a new patent to delivery a packages with drones. Our team was a responsible to build a Back-end and we choice Java, MySQL and run the application with Docker.

## Main Stacks

- [Java](https://www.java.com/)
- [Quarkus](https://quarkus.io/)
- [MySQL](https://www.mysql.com/)
- [JUnit](https://junit.org/junit5/)
- [Docker](https://www.docker.com/)
- [Checkstyle](https://checkstyle.sourceforge.io/)

## Installation

Clone the project:

```bash
git clone git@github.com:cleytonoliveira/drone-feeder.git
```

Packaging the application without running a local tests:

```bash
mvn install -DskipTests
```

## Run Locally

Setting environment variable like [.env-example](./.env-example) file.

Start the container with:

```bash
docker-compose up
```

If you wish run without a container it will be necessary install MySQL in your machine. See more information [here](https://www.mysql.com/downloads/).

Another side, if you have MySQL in your machine, run with:

```bash
mvn compile quarkus:dev
```

## Usage

Check the documentation with [OpenAPI](./src/main/java/org/futuereh/openapi/openapi).

## Running Tests

Running the tests with:

```bash
mvn test
```

## Future work

- Custom and handle exceptions;
- Synchronize information always we have a internet connection;
- Create endpoints to insert, list and download a video delivery;
- Implement unit tests;
- Config documentation with Swagger.

## Lessons Learned

- Start multiple containers with docker compose;
- Checkstyle configuration;
- Practice Java skills to build the API;
- Database Modeling and relationship between entities; 
- Build end-to-end tests.
