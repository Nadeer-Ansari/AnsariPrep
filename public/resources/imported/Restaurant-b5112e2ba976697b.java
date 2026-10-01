package example.spring.rest.entities;

public class Restaurant {
	private Integer restaurantId;
	private String name;
	private String cuisine;
	private int branches;
	public Restaurant() {
		restaurantId = 101;
		name = "Kamat";
		cuisine = "Indian";
		branches = 25;
	}
	public Restaurant(Integer restaurantId, String name, String cuisine, int branches) {
		super();
		this.restaurantId = restaurantId;
		this.name = name;
		this.cuisine = cuisine;
		this.branches = branches;
	}
	public Integer getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCuisine() {
		return cuisine;
	}
	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}
	public int getBranches() {
		return branches;
	}
	public void setBranches(int branches) {
		this.branches = branches;
	}
	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", name=" + name + ", cuisine=" + cuisine + ", branches="
				+ branches + "]";
	}

}
