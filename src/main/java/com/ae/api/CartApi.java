package com.ae.api;

import com.ae.config.Config;
import com.ae.models.request.AddToCartRequest;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CartApi {

    public Response addItem(String token, AddToCartRequest request) {
        return given()
                .baseUri("https://www.ae.com")
                .header("authorization", "Bearer " + token)
                .header("aesite", "AEO_US")
                .header("aelang", "en_US")
                .header("aecountry", "US")
                .header("origin", "https://www.ae.com")
                .header("referer", "https://www.ae.com/us/en/cart")
                .header("User-Agent", "Mozilla/5.0")
                .header("accept", "application/json")
                .header("content-type", "application/json")
                .body(request)
                .when()
                .post("/bag/v1/items")
                .then()
                .extract().response();
    }

    public Response getBagSummary(String token, String cartId) {
        return given()
                .baseUri(Config.get("baseUrl"))
                .basePath("/ugp-api/bag/v1")
                .header("authorization", "Bearer " + token)
                .header("aesite", "AEO_US")
                .header("aelang", "en_US")
                .header("origin", "https://www.ae.com")
                .header("Content-Type", "application/json")
                .header("aecountry", "US")
                .cookie("optimizelyEndUserId", cartId)
                .queryParam("couponErrorBehavior", "cart")
                .queryParam("inventoryCheck", "true")
                .when()
                .get();
    }

}
