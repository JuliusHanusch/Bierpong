package WG.Bierpong.Bierpong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
@RestController
public class DemoApplication {

    private static final String LOGIN_ROUTE = "/login";

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	// @Configuration
	// static class WebConfiguration implements WebMvcConfigurer{


	// 	@Override
	// 	public void addViewController(ViewControllerRegistry registry) {
	// 		registry.addViewController(LOGIN_ROUTE).setViewName("login");
	// 	}
		
//}


}
