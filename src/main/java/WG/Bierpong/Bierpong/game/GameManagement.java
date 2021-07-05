package WG.Bierpong.Bierpong.game;

import org.springframework.beans.factory.annotation.Autowired;

public class GameManagement {

    @Autowired
    GameRepository gameRepository;




    public Iterable<Game> getAllGames(){
        return gameRepository.findAll();
    }

    public Game createGame(GameForm form){
        if(form == null) throw new NullPointerException();

        gameRepository.save(new Game(form.getDate()));
        Game g = gameRepository.findByDate(form.getDate());

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
