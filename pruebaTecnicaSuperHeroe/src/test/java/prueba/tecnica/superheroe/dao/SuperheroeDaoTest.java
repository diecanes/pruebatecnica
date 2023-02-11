package prueba.tecnica.superheroe.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
		Optional<Superheroe> superheroe = Optional.of(new Superheroe(1,"heroe ejemplo"));
		when(superheroeRepository.findById(1)).thenReturn(superheroe);
		Superheroe supertest = superheroeDao.findSuperheroeById(1);
		assertEquals(supertest.getNombre(), "heroe ejemplo");
	}
	
	@Test
	public void test_findAllok() {
		ArrayList<Superheroe> superheroestest = new ArrayList<Superheroe>();
		superheroestest.add(new Superheroe(1,"heroe1"));
		superheroestest.add(new Superheroe(2,"heroe2"));
		superheroestest.add(new Superheroe(3,"heroe3"));
		when(superheroeRepository.findAll()).thenReturn(superheroestest);
		List<Superheroe> superheroes = superheroeDao.findAllSuperheroe();
		assertEquals(superheroes.size(), 3);
	}
	
	@Test
	public void test_findContainsok() {

		ArrayList<Superheroe> superheroestest = new ArrayList<Superheroe>();
		superheroestest.add(new Superheroe(1,"Spiderman"));
		superheroestest.add(new Superheroe(2,"Manin"));
		when(superheroeRepository.findByNombreContains("man")).thenReturn(superheroestest);
		List<Superheroe> superheroes = superheroeDao.findSuperheroeContains("man");
		assertEquals(superheroes.size(),2);
		assertEquals(superheroes.get(0).getNombre(),"Spiderman");
	}
	
	@Test
	public void test_deleteok() {
		superheroeDao.deleteSuperheroe(1);
		verify(superheroeRepository).deleteById(any());
	}
	
	@Test
	public void test_save() {
		superheroeDao.saveSuperheroe(new Superheroe(4, "Superejemplo"));
		verify(superheroeRepository).save(any());
	}
}
