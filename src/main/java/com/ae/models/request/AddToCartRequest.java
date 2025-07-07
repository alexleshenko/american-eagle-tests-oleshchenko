package com.ae.models.request;

import lombok.Data;

import java.util.List;

@Data
public class AddToCartRequest {
    private List<Item> items;

    public AddToCartRequest(List<Item> items) {
        this.items = items;
    }

    @Data
    public static class Item {
        private String skuId;
        private int quantity;

        public Item(String skuId, int quantity) {
            this.skuId = skuId;
            this.quantity = quantity;
        }
    }
}
