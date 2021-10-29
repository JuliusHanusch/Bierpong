package WG.Bierpong.Bierpong.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import WG.Bierpong.Bierpong.player.Player;
import WG.Bierpong.Bierpong.player.PlayerManagement;
import WG.Bierpong.Bierpong.player.PlayerRepository;


@Service
public class GameManagement {

    @Autowired
    GameRepository gameRepository;
    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    PlayerManagement playerManagement;




    public Iterable<Game> getAllGames(){
        return gameRepository.findAll();
    }

    public Game createNewGame(GameForm form){
        if(form == null) throw new NullPointerException();

        gameRepository.save(new Game(form.getDate()));
        Game g = gameRepository.findByDate(form.getDate());


        g.setRemainingCups(form.getRemainingCups());


        for(String name : form.getWinner()){
            System.out.println(name);
            Player p = playerRepository.findByName(name);
            g.addWinner(name);
        
            playerManagement.addWinToPlayer(p);
            
        }

        for(String name : form.getLoser()){
            System.out.println(name);
            Player p = playerRepository.findByName(name);
            g.addLoser(name);

            playerManagement.addLoseToPlayer(p);
        }

    return gameRepository.save(g);

    }


    
    public Game getGameById(Long gid){
        if(gid == null){
            throw new NullPointerException();
        }
        if(gameRepository.findById(gid).isPresent()){
            return gameRepository.findById(gid).get();
        }
        return null;
    }
}
