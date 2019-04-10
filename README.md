# Product Service Middleman

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
