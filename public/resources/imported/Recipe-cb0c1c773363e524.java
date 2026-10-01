package collections_framework;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
	private String name;
	private int preparationTime;//Minutes
	private List<String> ingredients;
	public Recipe() {
		ingredients = new ArrayList<>();
	}
	public Recipe(String name, int preparationTime, List<String> ingredients) {
		super();
		this.name = name;
		this.preparationTime = preparationTime;
		this.ingredients = ingredients;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPreparationTime() {
		return preparationTime;
	}
	public void setPreparationTime(int preparationTime) {
		this.preparationTime = preparationTime;
	}
	public List<String> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}
	public void addIngredient(String ingredient) {
		ingredients.add(ingredient);
	}

}
