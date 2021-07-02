package WG.Bierpong.Bierpong.overview;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import WG.Bierpong.Bierpong.player.PlayerManagement;


@Controller
public class OverviewController {

    private PlayerManagement playerManagement;

    public OverviewController(PlayerManagement playerManagement){
        this.playerManagement = playerManagement;
    }

    @GetMapping("/bierpong")
    public String showSite(Model model){
        System.out.println("Check");

        model.addAttribute("players", playerManagement.getAllPlayers());
        return "bierpong";
       
    }
    
}
