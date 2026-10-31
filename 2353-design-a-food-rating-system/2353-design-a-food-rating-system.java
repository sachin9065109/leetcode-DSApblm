class FoodRatings {

    class Food {
        String name;
        int rating;

        Food(String name, int rating) {
            this.name = name;
            this.rating = rating;
        }
    }

    Map<String, String> foodCuisine = new HashMap<>();
    Map<String, Integer> foodRating = new HashMap<>();
    Map<String, TreeSet<Food>> cuisineFoods = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {

        for (int i = 0; i < foods.length; i++) {

            foodCuisine.put(foods[i], cuisines[i]);
            foodRating.put(foods[i], ratings[i]);

            cuisineFoods.putIfAbsent(cuisines[i], new TreeSet<>((a, b) -> {
                if (a.rating != b.rating) {
                    return Integer.compare(b.rating, a.rating);
                }
                return a.name.compareTo(b.name);
            }));

            cuisineFoods.get(cuisines[i]).add(new Food(foods[i], ratings[i]));
        }
    }

    public void changeRating(String food, int newRating) {

        String cuisine = foodCuisine.get(food);

        TreeSet<Food> set = cuisineFoods.get(cuisine);

        set.remove(new Food(food, foodRating.get(food)));

        foodRating.put(food, newRating);

        set.add(new Food(food, newRating));
    }

    public String highestRated(String cuisine) {

        return cuisineFoods.get(cuisine).first().name;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */