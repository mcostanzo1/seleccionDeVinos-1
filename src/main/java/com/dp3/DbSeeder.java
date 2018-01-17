package com.dp3;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.dp3.dao.ProductRepository;
import com.dp3.dao.UserRepository;
import com.dp3.domain.Cellar;
import com.dp3.domain.Product;
import com.dp3.domain.Usuario;
import com.dp3.domain.Wine;

@Component
public class DbSeeder implements CommandLineRunner {
	
	private ProductRepository productRepository;
	private UserRepository usersRepository;
	
	public DbSeeder(ProductRepository productRepository, UserRepository usersRepository) {
		this.productRepository = productRepository;
		this.usersRepository = usersRepository;
	}
	
	@Override
	public void run(String... arg0) throws Exception {
		
		this.usersRepository.deleteAll();
		this.productRepository.deleteAll();
		
		List<Usuario> users = new ArrayList<Usuario>();
		
		Usuario user = new Usuario();
		
		user.setUsername("nico@nico.com");
		user.setPassword("casheja");
		user.setNombre("Nicolás");
		user.setApellido("Osowski");
		user.setRol("ADMIN");
		
		users.add(user);
<<<<<<< HEAD
=======
		
		user = new Usuario();
		user.setUsername("cuki@cuki.com");
		user.setPassword("casheja");
		user.setNombre("Ariel");
		user.setApellido("Cukierkorm");
		user.setRol("SELLER");
		users.add(user);
		
		this.usersRepository.save(users);
		
		List<Product> products = new ArrayList<Product>();
>>>>>>> c885f0c2656b8ce59f835f24e12ac74303215185
		
		user = new Usuario();
		user.setUsername("cuki@cuki.com");
		user.setPassword("casheja");
		user.setNombre("Ariel");
		user.setApellido("Cukierkorm");
		user.setRol("SELLER");
		users.add(user);
		
		this.usersRepository.save(users);
		
		List<Product> products = new ArrayList<Product>();
		/*
		Cellar cellar = new Cellar("Catena Zapata", "Lujan de Cuyo, Mendoza", 
				"Fundada en 1902, Bodega Catena Zapata es reconocida por su rol pionero en haber hecho resurgir la variedad Malbec y haber descubierto los terroirs de altura extrema al pie de los Andes.");
		products.add(new Wine(cellar , "Catena Alta", 6, "Malbec"));
		
		products.add(new Wine(cellar , "Catena Zapata", 12, "Nicasia Vineyard"));
		
		products.add(new Wine(cellar , "DV CATENA", 9, "Tinto Histórico"));
		
		cellar = new Cellar("López", "Mendoza", "Representa un caso excepcional dentro de la industria vitivinícola argentina iniciada en 1898 continúa hoy en manos de la familia fundadora. Más de 118 años de tradición ofreciendo la misma calidad de siempre, labrando una historia desde el trabajo y el amor al detalle. Su fundador José López Rivas llegó en 1886 proveniente del pueblo de Algarrobo en Málaga, España, donde cultivaba junto a su familia predios con viñas y olivos. Decidió instalar sus viñedos en el país y escapar así de una devastadora plaga, la filoxera, que afectaba a las vides en Europa.");
		
		products.add(new Wine(cellar, "López", 6, "Malbec"));
		products.add(new Wine(cellar, "López", 9, "Chardonnay"));
		*/
		this.productRepository.save(products);
	}
}