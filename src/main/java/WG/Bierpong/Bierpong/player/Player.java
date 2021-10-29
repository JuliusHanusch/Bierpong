package WG.Bierpong.Bierpong.player;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Player {
    private String name;

    private Integer gamesWon;
    private Integer gamesLoss;

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

    public Long getId(){
        return id;
    }
    public Integer getGamesWon() {
        return gamesWon;
    }

    public void setGamesWon(Integer gamesWon) {
        this.gamesWon = gamesWon;
    }

    public void incrementGamesWon(){
        gamesWon++;
    }


    public Integer getGamesLoss() {
         return gamesLoss;
    }

    public void setGamesLoss(Integer gamesLoss) {
        this.gamesLoss = gamesLoss;
    }

    public void incrementGamesLoss(){
        gamesLoss++;
        
    }
    public Integer calculateGamesCount() {
        return gamesLoss + gamesWon;
       
    }

    public Double calculateWinrate(){
        if(calculateGamesCount() == 0){
            return 0.0;
        }
        return (double) gamesWon/((double) calculateGamesCount()) * (double) 100;
        
    }


    
}








