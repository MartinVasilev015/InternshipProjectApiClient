package restclient.main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan("restclient.main.services")
public class IntershipApiClientApplication 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(IntershipApiClientApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate() 
	{
	    return new RestTemplate();
	}

}
