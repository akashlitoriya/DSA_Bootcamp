package LeetcodeQuestions;
import java.util.*;
public class DesignFoodRatingSystem {
    class Pair{
        private String food;
        private String cuisines;
        private int rating;
        Pair(String food, String cuisines, int rating){
            this.food = food;
            this.rating = rating;
            this.cuisines = cuisines;
        }

    }
    HashMap<String, PriorityQueue<Pair>> food;
    HashMap<String, Pair> rating;

    public DesignFoodRatingSystem(String[] foods, String[] cuisines, int[] ratings) {
        this.food = new HashMap<>();
        this.rating = new HashMap<>();
        for(int i = 0; i < foods.length; i++){
            Pair foodObj = new Pair(foods[i], cuisines[i], ratings[i]);
            if(i != 0 && food.containsKey(cuisines[i])){
                food.get(cuisines[i]).add(foodObj);
            }else{
                food.put(cuisines[i], new PriorityQueue<>((a,b) -> b.rating == a.rating ? a.food.compareTo(b.food) : b.rating - a.rating));
                food.get(cuisines[i]).add(foodObj);
            }
            rating.put(foods[i],foodObj);
        }
    }

    public void changeRating(String foods, int newRating) {
        Pair foodChanged = rating.get(foods);
        PriorityQueue<Pair> pq = food.get(foodChanged.cuisines);
        pq.remove(foodChanged);
        foodChanged.rating = newRating;
        pq.add(foodChanged);

    }

    public String highestRated(String cuisine) {
        return food.get(cuisine).peek().food;

    }
}
