package WG.Bierpong.Bierpong.player;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Player {
    private String name;
    private Integer gamesCount;
    private Integer gamesWon;
    private Integer gamesLoss;
    private Double winrate;

    private @Id @GeneratedValue Long id;

    public Player(){

    }

    public Player(String name){
        super();
        this.name = name;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Integer getGamesCount() {
        return gamesCount;
    }

    public void setGamesCount(Integer gamesCount) {
        this.gamesCount = gamesCount;
    }


    public Integer getGamesWon() {
        return gamesWon;
    }

    public void setGamesWon(Integer gamesWon) {
        this.gamesWon = gamesWon;
    }


    public Integer getGamesLoss() {
        return gamesLoss;
    }

    public void setGamesLoss(Integer gamesLoss) {
        this.gamesLoss = gamesLoss;
    }


    public void setWinrate(Double winrate) {
        this.winrate = winrate;
    }

    public Double calculateWinrate() {
        winrate = ((double) gamesWon/(double) gamesCount);
        return winrate * 100;

    }

    public Long getId(){
        return id;
    }

    public void win(){
        gamesCount++;
        gamesWon++;
    }

    public void lose(){
        gamesCount--;
        gamesWon--;
    }

    
}
