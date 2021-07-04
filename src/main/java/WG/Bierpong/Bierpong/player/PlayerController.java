package WG.Bierpong.Bierpong.player;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlayerController {
    
	private PlayerManagement playerManagement;
	// private PlayerRepository playerRepository;

    public PlayerController(PlayerManagement playerManagement){
        this.playerManagement = playerManagement;
    }


    @GetMapping("/bierpong/neuerSpieler")
    public String showSiteNewPlayer(Model model, PlayerForm form){
        
        model.addAttribute("form", form);
        return "bierpong_neuerSpieler";
    }

    @PostMapping("/bierpong/neuerSpieler")
    public String handleCreatePlayer(Model model, @ModelAttribute("form") PlayerForm form){
                
        playerManagement.createNewPlayer(form);
        return "redirect:/bierpong";
    }
    


}
