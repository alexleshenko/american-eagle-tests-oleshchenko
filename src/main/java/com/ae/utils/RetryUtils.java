package com.ae.utils;

import com.ae.api.CartApi;
import com.ae.models.request.AddToCartRequest;
import com.ae.models.request.AddToCartRequest.Item;
import io.restassured.response.Response;

import java.util.List;

public class RetryUtils {

    public static Response tryAddWithFallback(CartApi cartApi, String token, AddToCartRequest original, String fallbackSku) {
        Response response = cartApi.addItem(token, original);
        AllureUtils.attachJson("Response (Attempt 1)", response.asString());

        if (response.getStatusCode() == 422) {
            AddToCartRequest fallback = new AddToCartRequest(List.of(new Item(fallbackSku, 1)));
            AllureUtils.logCurlStep("Retry with fallback SKU", fallback, token);
            response = cartApi.addItem(token, fallback);
            AllureUtils.attachJson("Response (Attempt 2)", response.asString());
        }

        return response;
    }
}
