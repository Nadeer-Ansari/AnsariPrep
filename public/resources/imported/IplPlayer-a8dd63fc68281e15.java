package example.hibernate.associations.one_to_many.unidirectional.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ipl_players")
public class IplPlayer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "player_id")
	private Integer playerId;
	@Column(name = "player_name", length = 30)
	private String name;
	@Column(name = "player_age")
	private int age;
	public IplPlayer() {
		// TODO Auto-generated constructor stub
	}
	public IplPlayer(Integer playerId, String name, int age) {
		super();
		this.playerId = playerId;
		this.name = name;
		this.age = age;
	}
	public Integer getPlayerId() {
		return playerId;
	}
	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "IplPlayer [playerId=" + playerId + ", name=" + name + ", age=" + age + "]";
	}
	

}
