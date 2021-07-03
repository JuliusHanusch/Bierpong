package WG.Bierpong.Bierpong.player;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerManagement {

    @Autowired
    private PlayerRepository playerRepository;


    public Iterable <Player> getAllPlayers() {
        return  playerRepository.findAll();
    }

    public Player createNewPlayer(PlayerForm form){
        if(form == null) throw new NullPointerException();

        playerRepository.save(new Player(form.getName()));
        Player p = playerRepository.findByName(form.getName());
        p.setGamesCount(form.getGamesCount());
        p.setGamesWon(form.getGamesWon());
        p.setGamesLoss(form.getGamesLoss());
        p.setWinrate(form.calculateWinrate());

        return playerRepository.save(p);
    }

    
}