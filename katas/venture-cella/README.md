# ![pageres](src/main/resources/VC-logo.png)
![Days](https://img.shields.io/static/v1?label=Working-Days&message=1&color=blue)
![Status](https://img.shields.io/static/v1?label=Done&message=100%&color=green)

CRUD with Spring.. and something more✨

*See [Challenge](src/main/resources/Challenge.md) for the details of the tasks.*

## Example implementation on localhost
##### Get all Users
```java
class VCProducts {

    private final String url = "http://localhost:8080/venture-cella";

    List<Products> getProducts() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity(url + "/products", String.class);
    }
}
```

## API Endpoints

Base path: `/venture-cella`


### Products
##### Get All
This is done sorting by name.
###### Params not required:
`page: Integer`
`size: Integer`

    /products/page?=#&size?=#

##### Get All by page
This is done sorting by name and using pagination.
###### Required params :
`page: Integer`
`size: Integer`

    /products/page?=#&size?=#

##### Get Product by name
###### Required params :
`name: String`

    /products/name/name?=#

##### Save Product
###### There is a @RequestBody expected

    /products

##### Update Product
###### There is a @RequestBody expected
###### Params required:
`id: Integer`

    /products/id?=#

##### Delete Product
###### Params required:
`id: Integer`

    /products/id?=#

Coded with ❤️ by Juan Patricio Doyle ✨2021

