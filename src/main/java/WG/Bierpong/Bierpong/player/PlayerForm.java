package WG.Bierpong.Bierpong.player;


public class PlayerForm {

    private String name;
    private Integer gamesCount;
    private Integer gamesWon;
    private Integer gamesLoss;

    public PlayerForm(String name, Integer gamesCount, Integer gamesWon, Integer gamesLoss){
        this.name = name;
        this.gamesCount = gamesCount;
        this.gamesWon = gamesWon;
        this.gamesLoss = gamesLoss;
    }

    public String getName() {
        return name;
    }

    public Integer getGamesCount() {
        return gamesCount;
    }

    public Integer getGamesWon() {
        return gamesWon;
    }

    public Integer getGamesLoss() {
        return gamesLoss;
    }

    public Double calculateWinrate(){
        if(gamesCount == 0){
            return 0.0;
        }
        return (double) (gamesWon/gamesCount);
    }
    
    
}
