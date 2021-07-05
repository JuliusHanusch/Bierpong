package WG.Bierpong.Bierpong.game;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import WG.Bierpong.Bierpong.player.Player;

@Entity
public class Game {

    private @Id @GeneratedValue Long id;

    private Date date;
    @OneToMany
    private List<Player> winner;
    @OneToMany
    private List<Player> loser;


    public Game(){

    }
    public Game(Date date){
        super();
        this.date=date;
    }

    public Date getDate(){
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public void addWinner(Player p){
        if(p == null) throw new NullPointerException();
        if(winner == null){
            winner = new LinkedList<Player>();
            winner.add(p);
        }
        winner.add(p);
    }

    public void addLoser(Player p){
        if(p == null) throw new NullPointerException();
        if(loser == null){
            loser = new LinkedList<Player>();
            loser.add(p);
        }
        loser.add(p);
    }

    public List<Player> getWinner() {
        return winner;
    }

    public List<Player> getLoser() {
        return loser;
    }

}