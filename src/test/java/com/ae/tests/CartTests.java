package com.ae.tests;

import com.ae.api.AuthApi;
import com.ae.api.BrowseApi;
import com.ae.api.CartApi;
import com.ae.config.Config;
import com.ae.models.request.AddToCartRequest;
import com.ae.models.request.AddToCartRequest.Item;
import com.ae.utils.AllureUtils;
import com.ae.utils.RetryUtils;
import io.qameta.allure.Allure;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class CartTests {

    CartApi cartApi = new CartApi();

    @Test
    void testAddRandomItemFromDressesCategory() {
        String token = Allure.step("Get access token", AuthApi::getAccessToken);

        String categoryId = Config.get("category.dresses");

        List<String> productIds = Allure.step("Get product list from category", () ->
                new BrowseApi().getProductIds(token, categoryId));

        String randomSku = productIds.get(new Random().nextInt(productIds.size()));
        AddToCartRequest request = new AddToCartRequest(List.of(new Item(randomSku, 1)));

        AllureUtils.logCurlStep("Attempt add to cart", request, token);

        String fallbackSku = Config.get("fallback.sku");
        Response response = RetryUtils.tryAddWithFallback(cartApi, token, request, fallbackSku);

        int statusCode = response.getStatusCode();
        assertTrue(statusCode >= 200 && statusCode < 300, "Add-to-cart request failed: status code " + statusCode);

        String cartId = response.jsonPath().getString("cartId");
        assertNotNull(cartId, "Cart ID is null after successful request");
        System.out.println("cartId = " + cartId);
    }

}
