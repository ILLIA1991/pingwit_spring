package Product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootFirstApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootFirstApplication.class);

	public static void main(String[] args) {
		LOGGER.info("Я сказал стартуем, у меня Джип в Польше!!!!");
		SpringApplication.run(SpringBootFirstApplication.class, args);
		LOGGER.trace("Увидим мы эту писанину?");
		LOGGER.info("Бонжур, Севупле!");
	}

}
