package com.ae.tests;

import com.ae.api.AuthApi;
import com.ae.api.BrowseApi;
import com.ae.config.Config;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BrowseTests {

    @Test
    void getSkuIdsFromCategory() {
        String token = AuthApi.getAccessToken();
        BrowseApi browseApi = new BrowseApi();

        String categoryId = Config.get("category.dresses");
        Response response = browseApi.getCategoryProducts(token, categoryId);

        assertEquals(200, response.getStatusCode());

        JsonPath json = response.jsonPath();
        List<String> skuIds = json.getList("data.relationships.products.data.id");

        assertNotNull(skuIds);
        assertFalse(skuIds.isEmpty());

        System.out.println("Found skuIds:");
        skuIds.forEach(System.out::println);
    }

}
