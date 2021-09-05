package com.vc.model.dto;

import java.util.List;

public class PaginationResponse {

    int page;
    int pages;
    List<ProductDto> products;

    public PaginationResponse(int page, int pages, List<ProductDto> products) {
        this.page = page;
        this.pages = pages;
        this.products = products;
    }

    public int getPage() {
        return page;
    }

    public int getPages() {
        return pages;
    }

    public List<ProductDto> getProducts() {
        return products;
    }
}
