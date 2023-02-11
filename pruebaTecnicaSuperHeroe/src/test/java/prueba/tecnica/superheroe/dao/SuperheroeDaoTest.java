package prueba.tecnica.superheroe.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import prueba.tecnica.superheroe.model.Superheroe;
import prueba.tecnica.superheroe.repository.SuperheroeRepository;

@ExtendWith(MockitoExtension.class)
public class SuperheroeDaoTest {

	@InjectMocks
	private SuperheroeDaoImpl superheroeDao;
	
	@Mock
	private SuperheroeRepository superheroeRepository; 
	
	@Test
	public void test_findok() {
		Superheroe supertest = superheroeDao.findSuperheroeById(1);
		assertEquals(supertest.getNombre(), "heroe ejemplo");
	}
	
	@Test
	public void test_findAllok() {
		List<Superheroe> superheroestest = superheroeDao.findAllSuperheroe();
		assertEquals(superheroestest.size(), 3);
	}
	
	@Test
	public void test_findContainsok() {
		List<Superheroe> superheroestest = superheroeDao.findSuperheroeContains("man");
		assertEquals(superheroestest.size(),2);
		assertEquals(superheroestest.get(0).getNombre(),"Spiderman");
	}
	
	@Test
	public void test_deleteok() {
		superheroeDao.deleteSuperheroe(1);
		verify(superheroeRepository).delete(any());
	}
	
	@Test
	public void test_save() {
		superheroeDao.saveSuperheroe(new Superheroe(4, "Superejemplo"));
		verify(superheroeRepository).save(any());
	}
}
