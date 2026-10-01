package example.hibernate.associations.main;

import java.util.Arrays;
import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import example.hibernate.associations.one_to_many.unidirectional.entity.IplPlayer;
import example.hibernate.associations.one_to_many.unidirectional.entity.IplTeam;
import example.hibernate.associations.utils.HibernateUtils;

public class TeamPlayerLinkerMain {

	public static void main(String[] args) {
		try(
				SessionFactory factory = HibernateUtils.getSessionFactory();
				Session session = factory.openSession()
				){
			//Find the players to be linked
			IplPlayer player1 = session.find(IplPlayer.class, 1);
			IplPlayer player2 = session.find(IplPlayer.class, 2);
			IplPlayer player3 = session.find(IplPlayer.class, 3);
			IplPlayer player4 = session.find(IplPlayer.class, 4);
			IplPlayer player5 = session.find(IplPlayer.class, 5);
			IplPlayer player6 = session.find(IplPlayer.class, 6);
			IplPlayer player7 = session.find(IplPlayer.class, 7);
			//Find the teams to which players are to be linked
			IplTeam teamRcb = session.find(IplTeam.class, "RCB");
			IplTeam teamSrh = session.find(IplTeam.class, "SRH");
			//Link them
			Transaction tx = session.beginTransaction();
				Collection<IplPlayer> rcbPlayers =
				Arrays.asList(player1, player2, player3, player4);
				teamRcb.setPlayers(rcbPlayers);
				
				teamSrh.addPlayer(player5);
				teamSrh.addPlayer(player6);
				teamSrh.addPlayer(player7);							
			tx.commit();
			System.out.println("IPL players linked to IPL teams");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}

	}

}
