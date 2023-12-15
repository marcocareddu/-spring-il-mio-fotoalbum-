package org.java.spring;

import org.java.spring.photo.auth.Role;
import org.java.spring.photo.auth.User;
import org.java.spring.photo.auth.config.AuthConfiguration;
import org.java.spring.photo.pojo.Photo;
import org.java.spring.photo.services.PhotoService;
import org.java.spring.photo.services.RoleService;
import org.java.spring.photo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringIlMioFotoalbumApplication implements CommandLineRunner {

	@Autowired
	private PhotoService photoService;

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringIlMioFotoalbumApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		photoService.save(new Photo("Giardino", "Foto di un giardino", "https://www.dubai.it/wp-content/uploads/sites/32/dubai-miracle-garden.jpg", true));
		photoService.save(new Photo("Montagna", "Foto di una montagna", "https://www.liveinup.it/thumbs/luoghi/esperienze-in-montagna-copertina.webp", true));
		photoService.save(new Photo("Spiaggia", "Foto di una spiaggia", "https://staticfanpage.akamaized.net/wp-content/uploads/sites/33/2023/05/spiaggia-villasimius.jpg", true));
		photoService.save(new Photo("Città", "Foto di una città", "https://i0.wp.com/osservatorioglobalizzazione.it/wp-content/uploads/2020/05/pechino1.jpg?w=1080&ssl=1", true));
		photoService.save(new Photo("Foresta", "Foto di una foresta", "https://staticfanpage.akamaized.net/wp-content/uploads/sites/12/2018/07/640px-es2110009-gorbea_hayedo_de_otxarreta_aga7421.jpg", true));
		photoService.save(new Photo("Deserto", "Foto di un deserto", "https://www.skuola.net/news_foto/2018/deserto-sahara-descrizione.jpg", true));
		photoService.save(new Photo("Fiume", "Foto di un fiume", "https://www.wildecobeach.com/cdn/shop/articles/Reka_Soca_175c8d63-3feb-49c4-b602-9886e9dc4fb9_1000x.jpg?v=1587734159", true));
		photoService.save(new Photo("Lago", "Foto di un lago", "https://tourismmedia.italia.it/is/image/mitur/20210331103222-20-lago-di-scanno-cesidio-silla?wid=1080&hei=660&fit=constrain,1&fmt=webp", true));
		photoService.save(new Photo("Cascata", "Foto di una cascata", "https://sb.ecobnb.net/app/uploads/sites/2/2017/03/robert-lukeman-150146.jpg.webp", true));
		photoService.save(new Photo("Paesaggio urbano", "Foto di un paesaggio urbano", "https://www.diventaunfotografo.com/wp-content/uploads/2018/10/fotografia-paesaggio-urbano.jpg", true));
		
		Role user = new Role("USER");
		Role admin = new Role("ADMIN");
		Role superadmin = new Role("SUPERADMIN");
	
		roleService.save(user);
		roleService.save(admin);
		roleService.save(superadmin);
		
		String pass = AuthConfiguration.passwordEncoder().encode("password");

		User testUser = new User("TestUser", pass, user);
		User testAdmin = new User("TestAdmin", pass, admin);
		User testsuperadmin = new User("SuperAdmin", pass, superadmin);

		userService.save(testUser);
		userService.save(testAdmin);
		userService.save(testsuperadmin);
	}
}
