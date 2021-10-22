package WG.Bierpong.Bierpong.game;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import WG.Bierpong.Bierpong.player.Player;

@Entity
public class Game {

    private @Id @GeneratedValue Long id;

    private Date date;
    @Column
    @ElementCollection(targetClass=String.class)
    private List<String> winner;
    @Column
    @ElementCollection(targetClass=String.class)
    private List<String> loser;
    private Integer remainingCups;


    public Game(){

    }
    public Game(Date date){
        super();
        this.date = date;
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


    public void addWinner(String p){
        if(p == null) throw new NullPointerException();
        if(winner == null){
            winner = new ArrayList<String>();
            this.winner.add(p);
            }
        else{
            this.winner.add(p);
        }
    }

    public void addLoser(String p){
        if(p == null) throw new NullPointerException();
        if(loser == null){
            loser = new ArrayList<String>();
            this.loser.add(p);
            }
        else{
            this.loser.add(p);
        }
    }

    public List<String> getWinner() {
        return winner;
    }

    public List<String> getLoser() {
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
        for(String name : winner){
            allWinner = allWinner + " " + name;
        }
        return allWinner;
    }

    public String getAllLoserNames(){
        String allLoser = "";
        for(String name: loser){
            allLoser = allLoser + " " + name;
        }
        return allLoser;
    }
   

}