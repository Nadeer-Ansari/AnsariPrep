package collections_framework;

import java.util.ArrayList;
import java.util.List;

public class RecipeMain {

	public static void main(String[] args) {
		List<String> saladIngredients = new ArrayList<>();
		saladIngredients.add("Pineapple");
		saladIngredients.add("Mayonese");
		saladIngredients.add("Cherries");
		saladIngredients.add("Sugar");
		saladIngredients.add("Lettuce");
		
		Recipe rc = 
				new Recipe("Russian Salad", 45, saladIngredients);
		
		Recipe rc2 = new Recipe();
		rc2.setName("Garlic Bread with Cheese");
		rc2.setPreparationTime(30);
		rc2.addIngredient("Bread");
		rc2.addIngredient("Garlic");
		rc2.addIngredient("Cheese");
		rc2.addIngredient("Herbs");
		rc2.addIngredient("Chilli Flakes");
		
		System.out.println("Recipe Details: ");
		System.out.println("Name: " + rc.getName());
		System.out.println("Time for Preparation " + rc.getPreparationTime() + " Minutes");
		System.out.println("List of ingredients: ");
		List<String> rcIngredients = rc.getIngredients();
		for(String ing : rcIngredients)
			System.out.println(ing);
		

	}

}





