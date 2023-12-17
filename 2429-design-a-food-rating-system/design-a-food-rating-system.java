class FoodRatings {
    public class Info {
        String foods;
        String cuisines;
        int rating;

        public Info(String foods, String cuisines, int rating) {
            this.foods = foods;
            this.cuisines = cuisines;
            this.rating = rating;
        }
    }

    Map<String, PriorityQueue<Info>> cuisineMap;
    Map<String, Info> foodMap;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        cuisineMap = new HashMap<>();
        foodMap = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            Info combo = new Info(foods[i], cuisines[i], ratings[i]);
            foodMap.put(foods[i], combo);

            if (cuisineMap.containsKey(cuisines[i])) {
                cuisineMap.get(cuisines[i]).add(combo);
            } else {
                PriorityQueue<Info> pq = new PriorityQueue<>(new Comparator<Info>() {
                    @Override
                    public int compare(Info a, Info b) {
                        int result = Integer.compare(b.rating, a.rating);
                        if (result == 0) {
                            return a.foods.compareTo(b.foods);
                        }
                        return result;
                    }
                });
                pq.add(combo);
                cuisineMap.put(cuisines[i], pq);
            }
        }
    }

    public void changeRating(String food, int newRating) {
        Info pre = foodMap.get(food);
        Info curr = new Info(food, pre.cuisines, newRating);
        foodMap.put(food, curr);
        pre.foods = "";
        cuisineMap.get(pre.cuisines).add(curr);
    }

    public String highestRated(String cuisine) {
        while (cuisineMap.get(cuisine).peek().foods.equals("")) {
            cuisineMap.get(cuisine).remove();
        }
        return cuisineMap.get(cuisine).peek().foods;
    }
}