package com.ae.api;

import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class BrowseApi {

    private static final String BASE_URI = "https://www.ae.com/ugp-api";

    public Response getCategoryProducts(String token, String categoryId) {
        return given()
                .baseUri(BASE_URI)
                .header("authorization", "Bearer " + token)
                .header("aesite", "AEO_US")
                .header("aelang", "en_US")
                .header("accept", "application/vnd.api+json")
                .header("channeltype", "WEB")
                .header("referer", "https://www.ae.com/us/en/cart")
                .header("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:139.0) Gecko/20100101 Firefox/139.0")
                .header("content-type", "application/json")
                .when()
                .get("/browse/v1/category/" + categoryId)
                .then()
                .extract().response();
    }


    public List<String> getProductIds(String token, String categoryId) {
        Response response = getCategoryProducts(token, categoryId);
        return response.jsonPath().getList("data.relationships.products.data.id");
    }
}
