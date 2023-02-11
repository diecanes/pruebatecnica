package prueba.tecnica.superheroe.service;

import java.util.List;

import prueba.tecnica.superheroe.model.Superheroe;

public interface SuperheroeServiceInterface {
 
	public List<Superheroe> getSuperheroes();
	public List<Superheroe> getSuperheroes(String nombre);
	public Superheroe getSuperheroe(int id);
	public void deleteSuperheroe(int id);
	public Superheroe modifySuperheroe(int id, String nombre);
	
}
