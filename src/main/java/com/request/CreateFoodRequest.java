package com.request;

import java.util.List;
import java.util.Locale.Category;

import com.milind.model.IngredientsItem;

import lombok.Data;


@Data

public class CreateFoodRequest {
    private String name;
    private String description;
    private Long price;

    private Category category;
    private List<String> images;

    private Long restaurantId;
    private boolean vegetarin;
    private boolean seasional;
    private List<IngredientsItem> ingredients;
}
