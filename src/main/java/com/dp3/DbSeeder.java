package com.dp3;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.dp3.dao.CellarRepository;
import com.dp3.dao.WineRepository;
import com.dp3.domain.Stock;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.dp3.dao.StockRepository;
import com.dp3.dao.UserRepository;
import com.dp3.domain.Cellar;
import com.dp3.domain.Usuario;
import com.dp3.domain.Wine;

@Component
public class DbSeeder implements CommandLineRunner {
	
	private UserRepository usersRepository;
    private CellarRepository cellarRepository;
    private WineRepository wineRepository;
    private StockRepository stockRepository;

	public DbSeeder(StockRepository stockRepository, UserRepository usersRepository, WineRepository wineRepository, CellarRepository cellarRepository) {
		this.usersRepository = usersRepository;
        this.cellarRepository = cellarRepository;
        this.wineRepository = wineRepository;
        this.stockRepository = stockRepository;
    }
	
	@Override
	public void run(String... arg0) throws Exception {

		List<Usuario> users = new ArrayList<>();
		
		Usuario user = new Usuario();
		
		user.setUsername("nico@nico.com");
		user.setPassword("casheja");
		user.setNombre("Nicolás");
		user.setApellido("Osowski");
		user.setRol("ADMIN");
		
		users.add(user);
		
		user = new Usuario();
		user.setUsername("cuki@cuki.com");
		user.setPassword("casheja");
		user.setNombre("Ariel");
		user.setApellido("Cukierkorm");
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
        cellarList = cellarRepository.findAll();
		List<Wine> wineList = new ArrayList<>();
		wineList.add(new Wine("Toro Viejo", 12, "Malbec", cellarList.get(0).getCellarId()));
        wineList.add(new Wine("Toro Viejo", 9, "Cabernet", cellarList.get(0).getCellarId()));
        wineList.add(new Wine("Lopez", 6, "Chardonnay", cellarList.get(0).getCellarId()));
        wineList.add(new Wine("Termidor", 6, "Syrah", cellarList.get(0).getCellarId()));
        wineList.add(new Wine("Uvita",12 , "Malbec", cellarList.get(0).getCellarId()));

		wineRepository.save(wineList);
        wineList = wineRepository.findAll();

        List<Stock> stocks = new ArrayList<>();
		Stock stock = new Stock();
		stock.setProduct(wineList.get(0));
		stock.setPrice(new BigDecimal(150));
		stocks.add(stock);

		stock = new Stock();
        stock.setProduct(wineList.get(1));
        stock.setPrice(new BigDecimal(250));
        stocks.add(stock);

        stock = new Stock();
        stock.setProduct(wineList.get(2));
        stock.setPrice(new BigDecimal(59));
        stocks.add(stock);

        stock = new Stock();
        stock.setProduct(wineList.get(3));
        stock.setPrice(new BigDecimal(200));
        stocks.add(stock);

        stock = new Stock();
        stock.setProduct(wineList.get(4));
        stock.setPrice(new BigDecimal(95));
        stocks.add(stock);

		this.stockRepository.save(stocks);
	}
}
