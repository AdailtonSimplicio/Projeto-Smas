package adailton.dev.rmg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//não executar a class security
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class RmgApplication {

	public static void main(String[] args) {
		SpringApplication.run(RmgApplication.class, args);
	}

	@Bean
	public PasswordEncoder getPasswordEncoder(){
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	return encoder;
	}
}
