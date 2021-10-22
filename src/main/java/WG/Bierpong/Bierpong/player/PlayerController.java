package WG.Bierpong.Bierpong.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;

import WG.Bierpong.Bierpong.game.GameForm;
import WG.Bierpong.Bierpong.game.Game;
import WG.Bierpong.Bierpong.game.GameManagement;

@Controller
public class PlayerController {
    
    @Autowired
	private PlayerManagement playerManagement;
    @Autowired
	private GameManagement gameManagement;

  

    @GetMapping("/bierpong")
    public String showOverview(Model model, PlayerForm playerForm, GameForm gameForm){

        model.addAttribute("players", playerManagement.getAllPlayers());
        model.addAttribute("games", gameManagement.getAllGames());
        model.addAttribute("playerForm", playerForm);
        model.addAttribute("gameForm", gameForm);
        return "bierpong";
    }

    @PostMapping("/bierpong/newPlayer")
    public String handleNewPlayer(@ModelAttribute("form") PlayerForm playerForm){
        if(playerForm == null) throw new NullPointerException();
                
        playerManagement.createNewPlayer(playerForm);
        return "redirect:/bierpong";
    }

    @PostMapping("/bierpong/newGame")
    public String handleNewGame(@ModelAttribute("form") GameForm gameForm){
        if(gameForm == null) throw new NullPointerException();

        System.out.println(gameForm.getWinner());
        System.out.println(gameForm.getLoser());

        gameManagement.createNewGame(gameForm);
        System.out.println("Check5");
        return "redirect:/bierpong";
    }
    



    // @GetMapping("/bierpong/newPlayer")
    // public String showSiteNewPlayer(Model model, PlayerForm form){
        
    //     model.addAttribute("playerForm", playerForm);
    //     return "bierpong_newPlayer";
    // }

    
   

    // @PostMapping("/bierpong/increment/{pid}")
    // public String handleWinStats(@PathVariable Long pid){

    //     System.out.println("Check");
        
    //     if (playerRepository.findById(pid).isEmpty()) {
	// 		return "redirect:/bierpong_newGame";
	// 	}
    //     Player p = playerManagement.getPlayerById(pid);
    //     playerManagement.increment(p);
    //     playerRepository.save(p);

    //     System.out.println("Check1");


    //     return "redirect:/bierpong/newGame";
    // }

    // @PostMapping("/bierpong/decrement/{pid}")
    // public String handleLoseStats(@PathVariable Long pid){
        
    //     if (playerRepository.findById(pid).isEmpty()) {
	// 		return "redirect:/bierpong_newGame";
	// 	}
    //     Player p = playerManagement.getPlayerById(pid);
    //     playerManagement.decrement(p);
    //     playerRepository.save(p);


    //     return "redirect:/bierpong/newGame";
    // }



    


}
