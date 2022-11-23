package haagahelia.fi.mobileDatabase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import haagahelia.fi.mobileDatabase.domain.Mobile;
import haagahelia.fi.mobileDatabase.domain.MobileRepository;
import haagahelia.fi.mobileDatabase.domain.Type;
import haagahelia.fi.mobileDatabase.domain.TypeRepository;



@SpringBootApplication
public class mobileDatabaseApplication {
	private static final Logger log = LoggerFactory.getLogger(mobileDatabaseApplication.class);

	
	public static void main(String[] args) {
		SpringApplication.run(mobileDatabaseApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner mobileDemo(MobileRepository srepository, TypeRepository drepository) {
		return (args) -> {
			log.info("save a type of device");
			drepository.save(new Type("Samsung"));
			drepository.save(new Type("iPhone"));

			
			srepository.save(new Mobile("Samsung", "S22", "5G", "8/128GB", "Punainen", drepository.findByName("Samsung").get(0)));
			srepository.save(new Mobile("iPhone", "14", "5G", "8/128GB", "Sininen", drepository.findByName("iPhone").get(0)));	
			
			
			log.info("fetch all device");
			for (Mobile mobile: srepository.findAll()) {
				log.info(mobile.toString());
			}

		};
	}
}
