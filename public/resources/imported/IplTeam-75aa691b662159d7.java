package example.hibernate.associations.one_to_many.unidirectional.entity;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "ipl_teams")
public class IplTeam {
	@Id
	@Column(name = "team_id", length = 3)
	private String teamId;
	@Column(name = "team_name", length = 30)
	private String name;
	@Column(name = "team_titles")
	private int titleCount;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "team_id")//This is the foreign key column from Ipl_Players table that refers to the primary key of Ipl_Teams table
	private Collection<IplPlayer> players;
	public IplTeam() {
		players = new ArrayList<>();
	}
	public IplTeam(String teamId, String name, int titleCount, Collection<IplPlayer> players) {
		super();
		this.teamId = teamId;
		this.name = name;
		this.titleCount = titleCount;
		this.players = players;
	}
	public String getTeamId() {
		return teamId;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTitleCount() {
		return titleCount;
	}
	public void setTitleCount(int titleCount) {
		this.titleCount = titleCount;
	}
	public Collection<IplPlayer> getPlayers() {
		return players;
	}
	public void setPlayers(Collection<IplPlayer> players) {
		this.players = players;
	}
	
	public void addPlayer(IplPlayer player) {
		//This is a convenient method for adding a single player at a time.
		players.add(player);
	}
	
	@Override
	public String toString() {
		return "IplTeam [teamId=" + teamId + ", name=" + name + ", titleCount=" + titleCount + ", players=" + players
				+ "]";
	}

}





