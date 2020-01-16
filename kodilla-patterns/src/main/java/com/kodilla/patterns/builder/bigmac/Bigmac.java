package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public class Bigmac {
    private final Bun bun;
    private final int burgers;
    private final Sauce sauce;
    private final List<Ingredient> ingredients;
    private static final int MAX_QUANTITY_OF_INGREDIENTS = 10;
    private static final int MAX_QUANTITY_OF_BURGERS = 5;

    private Bigmac(Bun bun, int burgers, Sauce sauce, List<Ingredient> ingredients) {
        this.bun = bun;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = ingredients;
    }

    public static class BigMacBuilder {
        private Bun bun;
        private int burgers;
        private Sauce sauce;
        private List<Ingredient> ingredients = new ArrayList<>();
        private boolean areBasicIngredientsInBurger = false;

        public BigMacBuilder bun(Bun bun) {
            this.bun = bun;
            return this;
        }

        public BigMacBuilder burgers(int burgers) {
            if (burgers > 0 && burgers <= MAX_QUANTITY_OF_BURGERS) {
                this.burgers = burgers;
            } else {
                throw new IllegalStateException("You've probably given wrong number of burgers, maximum Value is: "
                        + MAX_QUANTITY_OF_BURGERS);
            }
            return this;
        }

        public BigMacBuilder sauce(Sauce sauce) {
            this.sauce = sauce;
            return this;
        }

        public BigMacBuilder ingredients(Ingredient... ingredients) {
            if (!areBasicIngredientsInBurger) {
                addBasicIngredients();
                areBasicIngredientsInBurger = true;
            }
            for (Ingredient ingredient : ingredients) {
                if (this.ingredients.size() < MAX_QUANTITY_OF_INGREDIENTS) {
                    this.ingredients.add(ingredient);
                }
            }
            return this;
        }

        public void addBasicIngredients() {
            ingredients.add(Ingredient.GOUDA);
            ingredients.add(Ingredient.ONION);
            ingredients.add(Ingredient.TOMATO);
        }

        public Bigmac build() {
            return new Bigmac(bun, burgers, sauce, ingredients);
        }
    }

    public Bun getBun() {
        return bun;
    }

    public int getBurgers() {
        return burgers;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public static int getMaxQuantityOfIngredients() {
        return MAX_QUANTITY_OF_INGREDIENTS;
    }
}
