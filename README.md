# Product Service Middleman Service (master branch)

This branch (master) will serve as a basic clone-able Spring Boot project. This code was generated using the Spring 
Boot Initializr ([start.spring.io](https://start.spring.io/)).

Clone this repo and import as a Gradle or Spring Boot project in Eclipse/IntelliJ.

Requirements:
- Java 8
- Gradle (like 5.2+ probably)

Feel free to make a new branch for yourself and use it to create your own solution:

```bash
git checkout -b david
git add --all
git commit -m "initialize branch 'david'"
git push -u origin david
```

## Build/Deploy

Build:

```bash
./gradlew assemble
```
 
Run:

```bash
java -jar build/libs/ps-middleman-1.0.0.jar
```
 
Deploy to Cloud Foundry:

```bash
cf login -a api.sys.apbg.apcf.io -u username -p password
cf target -o myorg -s myspace
cf push ps-middleman -p build/libs/ps-middleman-1.0.0.jar --random-route
```

## API

Forward all products (name and price)
```bash
GET /products
```

Forward closest 3 products to some price (price as double, returns name and price)
```bash
GET /products/closest-to/{price}
```
