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


    public Double getWinrate() {
        return winrate;
    }

    public void setWinrate(Double winrate) {
        this.winrate = winrate;
    }

    public long getId(){
      return id;
    }



    
}
