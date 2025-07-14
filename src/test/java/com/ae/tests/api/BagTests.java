package com.ae.tests.api;

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

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BagTests {

    CartApi cartApi = new CartApi();

    @Test
    void validateBagSummaryAfterAddToCart() {
        String token = Allure.step("Get access token", AuthApi::getAccessToken);
        AllureUtils.attachText("Access Token", token);

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
        AllureUtils.attachText("Cart ID", cartId);
        System.out.println("cartId = " + cartId);

        Response summaryResponse = cartApi.getBagSummary(token, cartId);
        AllureUtils.attachJson("Bag Summary", summaryResponse.asString());

        List<String> skusInBag = summaryResponse.jsonPath().getList("data.items.sku");
        assertNotNull(skusInBag);
        assertTrue(skusInBag.contains(fallbackSku), "Expected SKU not found in bag summary");
    }
}
