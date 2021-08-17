package WG.Bierpong.Bierpong.game;

import java.util.*;

import WG.Bierpong.Bierpong.player.Player;


public class GameForm {
    private Date date;
    private List<Player> winner;
    private List<Player> loser;
    private Integer remainingCups;

    public GameForm(List<Player> Winner, List<Player> Loser, Integer remainingCups){     
        date = new Date();
        this.winner = winner;
        this.loser = loser;
        this.remainingCups = remainingCups;
    }

    public Date getDate() {
        return date;
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
    
    
}
