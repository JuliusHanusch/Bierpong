package WG.Bierpong.Bierpong.player;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlayerController {
    
	private PlayerManagement playerManagement;
	private PlayerRepository playerRepository;

    public PlayerController(PlayerManagement playerManagement, PlayerRepository playerRepository){
        this.playerManagement = playerManagement;
        this.playerRepository = playerRepository;
    }

    @GetMapping("/bierpong")
    public String showOverview(Model model){

        model.addAttribute("players", playerManagement.getAllPlayers());
        return "bierpong";
    }
    



    @GetMapping("/bierpong/newPlayer")
    public String showSiteNewPlayer(Model model, PlayerForm form){
        
        model.addAttribute("form", form);
        return "bierpong_newPlayer";
    }

    @PostMapping("/bierpong/newPlayer")
    public String handleCreatePlayer(@ModelAttribute("form") PlayerForm form){
                
        playerManagement.createNewPlayer(form);
        return "redirect:/bierpong";
    }

    
    @GetMapping("/bierpong/newGame")
    public String showSiteNewGame(Model model){

        model.addAttribute("players", playerManagement.getAllPlayers());
        return "bierpong_newGame";
    }

    @PostMapping("/bierpong/increment/{pid}")
    public String handleWinStats(@PathVariable Long pid){

        System.out.println("Check");
        
        if (playerRepository.findById(pid).isEmpty()) {
			return "redirect:/bierpong_newGame";
		}
        Player p = playerManagement.getPlayerById(pid);
        playerManagement.increment(p);
        playerRepository.save(p);

        System.out.println("Check1");


        return "redirect:/bierpong/newGame";
    }

    @PostMapping("/bierpong/decrement/{pid}")
    public String handleLoseStats(@PathVariable Long pid){
        
        if (playerRepository.findById(pid).isEmpty()) {
			return "redirect:/bierpong_newGame";
		}
        Player p = playerManagement.getPlayerById(pid);
        playerManagement.decrement(p);
        playerRepository.save(p);


        return "redirect:/bierpong/newGame";
    }

    @PostMapping("/bierpong/newGame")
    public String returnToMainPage(Model model){
        return "redirect:/bierpong";
    }


    


}
