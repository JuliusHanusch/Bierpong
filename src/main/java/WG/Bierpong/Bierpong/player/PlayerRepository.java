package WG.Bierpong.Bierpong.player;

import org.springframework.data.repository.CrudRepository;


public interface PlayerRepository extends CrudRepository<Player, Long> {
    
  default Player findByName(String name) {
    if (name == null) {
        throw new NullPointerException();
    }

    for (Player p : findAll()) {
        if (p.getName().equals(name)) {
            return p;
        }
    }
    return null;
}


}
