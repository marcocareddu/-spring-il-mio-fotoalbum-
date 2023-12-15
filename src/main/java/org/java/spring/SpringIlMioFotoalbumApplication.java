package org.java.spring;


import org.java.spring.photo.pojo.Photo;
import org.java.spring.photo.services.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringIlMioFotoalbumApplication implements CommandLineRunner {

	@Autowired
	private PhotoService photoService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringIlMioFotoalbumApplication.class, args);
	}


	
	
	@Override
	public void run(String... args) throws Exception {
		photoService.save(new Photo("Giardino", "Foto di un giardino", "Link", true));
		photoService.save(new Photo("Giardino", "Foto di un giardino", "Link1", true));
		photoService.save(new Photo("Montagna", "Foto di una montagna", "Link2", true));
		photoService.save(new Photo("Spiaggia", "Foto di una spiaggia", "Link3", true));
		photoService.save(new Photo("Città", "Foto di una città", "Link4", true));
		photoService.save(new Photo("Foresta", "Foto di una foresta", "Link5", true));
		photoService.save(new Photo("Deserto", "Foto di un deserto", "Link6", true));
		photoService.save(new Photo("Fiume", "Foto di un fiume", "Link7", true));
		photoService.save(new Photo("Lago", "Foto di un lago", "Link8", true));
		photoService.save(new Photo("Cascata", "Foto di una cascata", "Link9", true));
		photoService.save(new Photo("Paesaggio urbano", "Foto di un paesaggio urbano", "Link10", true));
	}
}
