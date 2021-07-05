package WG.Bierpong.Bierpong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import WG.Bierpong.Bierpong.player.PlayerRepository;

@SpringBootApplication
@RestController
public class DemoApplication {

	@Autowired
	static PlayerRepository playerRepository;

	public static void main(String[] args) {
		System.out.println("Main");
		SpringApplication.run(DemoApplication.class, args);
	}

}
