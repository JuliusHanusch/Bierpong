package WG.Bierpong.Bierpong.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WG.Bierpong.Bierpong.player.Player;


@Service
public class GameManagement {

    @Autowired
    GameRepository gameRepository;




    public Iterable<Game> getAllGames(){
        return gameRepository.findAll();
    }

    public Game createNewGame(GameForm form){
        if(form == null) throw new NullPointerException();

        gameRepository.save(new Game(form.getDate()));
        Game g = gameRepository.findByDate(form.getDate());
        for(Player p : form.getWinner()){
            g.addWinner(p);
        }
        for(Player p : form.getLoser()){
            g.addWinner(p);
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
