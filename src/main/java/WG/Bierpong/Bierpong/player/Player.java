package WG.Bierpong.Bierpong.player;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import WG.Bierpong.Bierpong.game.Game;
import net.bytebuddy.asm.Advice.Return;

import java.util.*;

@Entity
public class Player {
    private String name;

    @OneToMany
    private List<Game> games;

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

    public Integer calculateGamesCount() {
        if(games == null){
            return 0;
        }
        return games.size();

    }

    public Integer calculateGamesWon(){
        Integer gamesWon = 0;
        if(games == null){
            return gamesWon;
        }
        for(Game g: games){
            for(Player p: g.getWinner()){
                if(p.getId().equals(id)){
                    gamesWon++;
                }
            }
        }
        return gamesWon;
    }

    public Integer calculateGamesLose(){
        Integer gamesLose = 0;
        if(games == null){
            return gamesLose;
        }
        for(Game g: games){
            for(Player p: g.getLoser()){
                if(p.getId().equals(id)){
                    gamesLose++;
                }
            }
        }
        return gamesLose;
    }


    public Double calculateWinrate(){
        if(calculateGamesCount() == 0){
            return 0.0;
        }
        return (double) calculateGamesWon() / (double) calculateGamesCount();
    }



    public void addGame(Game g){
        if(g == null) throw new NullPointerException();
        if(games == null){
            games = new ArrayList<Game>();
            games.add(g);
        }
        games.add(g);
    }

    
}










    // public void getGamesCount() {
    //     return gamesCount;
    // }

    // public void setGamesCount(Integer gamesCount) {
    //     this.gamesCount = gamesCount;
    // }


    // public Integer getGamesWon() {
    //     return gamesWon;
    // }

    // public void setGamesWon(Integer gamesWon) {
    //     this.gamesWon = gamesWon;
    // }


    // public Integer getGamesLoss() {
    //     return gamesLoss;
    // }

    // public void setGamesLoss(Integer gamesLoss) {
    //     this.gamesLoss = gamesLoss;
    // }


    // public void setWinrate(Double winrate) {
    //     this.winrate = winrate;
    // }

    // public Double calculateWinrate() {
    //     if(gamesCount == 0){
    //         return 0.0;
    //     }
    //     winrate = ((double) gamesWon/(double) gamesCount);
    //     return winrate * 100;

    // }
     

    // public void win(){
    //     gamesCount++;
    //     gamesWon++;
    // }

    // public void lose(){
    //     gamesCount--;
    //     gamesWon--;
    // }
