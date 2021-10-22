package WG.Bierpong.Bierpong.player;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import WG.Bierpong.Bierpong.game.Game;
import java.util.*;

@Entity
public class Player {
    private String name;

/*     @OneToMany
    private List<Game> games;
 */
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
        /* if(games == null){
            return 0;
        }
        return games.size();
 */
    }

    /* public Integer calculateGamesWon(){
        return gamesWon;
        Integer gamesWon = 0;
        if(games == null){
            return gamesWon;
        }
        for(Game g: games){
            for(String playerName : g.getWinner()){
                if(playerName.equals(name)){
                    gamesWon++;
                }
            }
        }
        return gamesWon;
    } */

   /*  public Integer calculateGamesLose(){
        return gamesLoss;

        Integer gamesLose = 0;
        if(games == null){
            return gamesLose;
        }
        for(Game g: games){
            for(String playerName : g.getLoser()){
                if(playerName   .equals(name)){
                    gamesLose++;
                }
            }
        }
        return gamesLose;
    } */


    public Double calculateWinrate(){
        if(calculateGamesCount() == 0){
            return 0.0;
        }
        return (double) gamesWon/((double) calculateGamesCount()) * (double) 100;
        /* if(calculateGamesCount() == 0){
            return 0.0;
        }
        return (double) calculateGamesWon() / (double) calculateGamesCount() * (double) 100; */
    }



    /* public void addGame(Game g){
        if(g == null) throw new NullPointerException();
        if(games == null){
            games = new ArrayList<Game>();
            games.add(g);
            }
        else{
            games.add(g);
        }
    } */

    
}








