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
    private Integer remainingCups;


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

    public Long getId() {
        return id;
    }


    public void addWinner(Player p){
        if(p == null) throw new NullPointerException();
        if(winner == null){
            winner = new ArrayList<Player>();
            this.winner.add(p);
            return;
        }
        this.winner.add(p);
    }

    public void addLoser(Player p){
        if(p == null) throw new NullPointerException();
        if(loser == null){
            loser = new ArrayList<Player>();
            this.loser.add(p);
            return;
        }
        this.loser.add(p);
    }

    public List<Player> getWinner() {
        return winner;
    }

    public List<Player> getLoser() {
        return loser;
    }
    
    public Integer getRemainingCups() {
        return remainingCups;
    }
    public void setRemainingCups(Integer remainingCups) {
        this.remainingCups = remainingCups;
    }

    public String getAllWinnerNames(){
        String allWinner = "";
        for(Player p : winner){
            String name = p.getName();
            allWinner = allWinner + " " + name;
        }
        return allWinner;
    }

    public String getAllLoserNames(){
        String allLoser = "";
        for(Player p : loser){
            String name = p.getName();
            allLoser = allLoser + " " + name;
        }
        return allLoser;
    }
   

}