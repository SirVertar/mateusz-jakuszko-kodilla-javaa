package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {
    @Test
    public void bigmacBuilderTest() {
        //Given
        Bigmac bigmac = new Bigmac.BigMacBuilder()
                .bun(Bun.WITH_SESAME)
                .burgers(2)
                .sauce(Sauce.BARBECUE)
                .ingredients(Ingredient.BACON, Ingredient.CAMEMBERT)
                .ingredients(Ingredient.CAMEMBERT, Ingredient.ONION, Ingredient.SALAD)
                .build();
        //When
        int quantityOfIngredients = bigmac.getIngredients().size();
        //Then
        Assert.assertEquals(8, quantityOfIngredients);
        Assert.assertEquals(Bun.WITH_SESAME, bigmac.getBun());
        Assert.assertEquals(2, bigmac.getBurgers());
        Assert.assertEquals(Sauce.BARBECUE, bigmac.getSauce());
    }

    @Test
    public void bigMacMaximumIngredientsTest() {
        //Given
        Bigmac bigmac = new Bigmac.BigMacBuilder()
                .bun(Bun.WITH_SESAME)
                .burgers(2)
                .sauce(Sauce.BARBECUE)
                .ingredients(Ingredient.BACON, Ingredient.CAMEMBERT)
                .ingredients(Ingredient.CAMEMBERT, Ingredient.ONION, Ingredient.SALAD)
                .ingredients(Ingredient.CAMEMBERT, Ingredient.ONION, Ingredient.SALAD)
                .ingredients(Ingredient.CAMEMBERT, Ingredient.CUCUMBER, Ingredient.CHILI_PEPPER)
                .ingredients(Ingredient.SHRIMP, Ingredient.SALAD, Ingredient.CHILI_PEPPER)
                .build();
        //When
        int quantityOfIngredients = bigmac.getIngredients().size();
        //Then
        Assert.assertEquals(10, quantityOfIngredients);
    }
}
