package WG.Bierpong.Bierpong.game;

import java.util.*;


public class GameForm {
    
    private Date date;
    private List<String> winner;
    private List<String> loser;
    private Integer remainingCups;

    public GameForm(List<String> winner, List<String> loser, Integer remainingCups){     
        date = new Date();
        this.winner = winner;
        this.loser = loser;
        this.remainingCups = remainingCups;
    }


    public Date getDate() {
        return date;
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

    public void setDate(Date date) {
        this.date = date;
    }

    public void setWinner(List<String> winner) {
        this.winner = winner;
    }

    public void setLoser(List<String> loser) {
        this.loser = loser;
    }

    public void setRemainingCups(Integer remainingCups) {
        this.remainingCups = remainingCups;
    }
   
    
}
