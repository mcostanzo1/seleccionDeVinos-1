package com.dp3;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.dp3.dao.CellarRepository;
import com.dp3.dao.WineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.dp3.dao.UserRepository;
import com.dp3.domain.Cellar;
import com.dp3.domain.User;
import com.dp3.domain.Wine;

@Component
public class DbSeeder implements CommandLineRunner {
	
	private UserRepository usersRepository;
    private CellarRepository cellarRepository;
    private WineRepository wineRepository;
    @Autowired
    private ApplicationContext context;

	public DbSeeder(UserRepository usersRepository, WineRepository wineRepository, CellarRepository cellarRepository) {
		this.usersRepository = usersRepository;
        this.cellarRepository = cellarRepository;
        this.wineRepository = wineRepository;
    }
	
	@Override
	public void run(String... arg0) throws Exception {

        usersRepository.deleteAll();
        cellarRepository.deleteAll();
        wineRepository.deleteAll();

		List<User> users = new ArrayList<>();
		
		User user = new User();
		
		user.setUsername("nico@nico.com");
		user.setPassword("casheja");
		user.setFirstname("Nicolás");
		user.setLastname("Osowski");
		user.setRol("ACTUATOR");
		
		users.add(user);
		
		user = new User();
		user.setUsername("cuki@cuki.com");
		user.setPassword("casheja");
		user.setFirstname("Ariel");
		user.setLastname("Cukierkorm");
		user.setRol("SELLER");
		users.add(user);
		
		this.usersRepository.save(users);

		List<Cellar> cellarList = new ArrayList<>();

		Cellar cel = new Cellar();
		cel.setCellarName("Lopez");
		cel.setLocation("Mendoza");
		cel.setDescription("Representa un caso excepcional dentro de la industria vitivinícola argentina iniciada en 1898 continúa hoy en manos de la familia fundadora. Más de 118 años de tradición ofreciendo la misma calidad de siempre, labrando una historia desde el trabajo y el amor al detalle. Su fundador José López Rivas llegó en 1886 proveniente del pueblo de Algarrobo en Málaga, España, donde cultivaba junto a su familia predios con viñas y olivos. Decidió instalar sus viñedos en el país y escapar así de una devastadora plaga, la filoxera, que afectaba a las vides en Europa.");
		cellarList.add(cel);

		cel = new Cellar();
		cel.setCellarName("Catena Zapata");
		cel.setLocation("Lujan de Cuyo, Mendoza");
		cel.setDescription("Fundada en 1902, Bodega Catena Zapata es reconocida por su rol pionero en haber hecho resurgir la variedad Malbec y haber descubierto los terroirs de altura extrema al pie de los Andes.");
		cellarList.add(cel);

		cellarRepository.save(cellarList);

		List<Wine> wineList = new ArrayList<>();
		wineList.add(new Wine("Toro Viejo", 12, "Malbec", cellarList.get(0), new BigDecimal("150")));
        wineList.add(new Wine("Toro Viejo", 9, "Cabernet", cellarList.get(0), new BigDecimal("179.50")));
        wineList.add(new Wine("Lopez", 6, "Chardonnay", cellarList.get(0), new BigDecimal("60.75")));
        wineList.add(new Wine("Termidor", 6, "Syrah", cellarList.get(1), new BigDecimal("88.25")));
        wineList.add(new Wine("Uvita",12 , "Malbec", cellarList.get(1), new BigDecimal("400")));

		wineRepository.save(wineList);
	}
}
