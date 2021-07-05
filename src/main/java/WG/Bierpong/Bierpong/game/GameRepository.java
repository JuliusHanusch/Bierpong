package WG.Bierpong.Bierpong.game;
import java.util.Date;

import org.springframework.data.repository.CrudRepository;


public interface GameRepository extends CrudRepository<Game, Long> {
        
  default Game findByDate(Date date) {
    if (date == null) {
        throw new NullPointerException();
    }

    for (Game g : findAll()) {
        if (g.getDate().equals(date)) {
            return g;
        }
    }
    return null;
}


}