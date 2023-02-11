package prueba.tecnica.superheroe.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

import prueba.tecnica.superheroe.dao.SuperheroeDaoImpl;
import prueba.tecnica.superheroe.model.Superheroe;

@ExtendWith(MockitoExtension.class)
public class SuperheroeServiceTest {

	@InjectMocks
	private SuperheroeServiceImpl superheroeServiceImpl;
	
	@Mock
	private SuperheroeDaoImpl superheroeDaoImpl; 
	
	@Test
	public void testGetSuperheroes() {
		ArrayList<Superheroe> superheroestest = new ArrayList<Superheroe>();
		superheroestest.add(new Superheroe(1,"heroe1"));
		superheroestest.add(new Superheroe(2,"heroe2"));
		superheroestest.add(new Superheroe(3,"heroe3"));
		List<Superheroe> superheroes = superheroeServiceImpl.getSuperheroes();
		assertEquals(superheroes.size(), 3);	
	};
	
	@Test
	public void testGetSuperheroesFilter() {
		ArrayList<Superheroe> superheroestest = new ArrayList<Superheroe>();
		superheroestest.add(new Superheroe(1,"Spiderman"));
		superheroestest.add(new Superheroe(2,"Manin"));
		when(superheroeServiceImpl.getSuperheroes("man")).thenReturn(superheroestest);
		List<Superheroe> superheroes = superheroeServiceImpl.getSuperheroes("man");
		assertEquals(superheroes.size(),2);
		assertEquals(superheroes.get(0).getNombre(),"Spiderman");
	}
	
	@Test
	public void testgetSuperheroe() {
		Superheroe superheroe = new Superheroe(1,"heroe ejemplo");
		when(superheroeDaoImpl.findSuperheroeById(1)).thenReturn(superheroe);
		Superheroe supertest = superheroeServiceImpl.getSuperheroe(1);
		assertEquals(supertest.getNombre(), "heroe ejemplo");
	}
	
	@Test
	public void testdeleteSuperheroe() {
		superheroeServiceImpl.deleteSuperheroe(1);
		verify(superheroeDaoImpl).deleteSuperheroe(1);
	}
	
	@Test
	public void testmodifySuperheroe() {
		Superheroe supertest = new Superheroe(0,"ejemplo");
		superheroeServiceImpl.modifySuperheroe(0, "ejemplo");
		verify(superheroeDaoImpl).saveSuperheroe(supertest);
	}
	
}
