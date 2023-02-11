package prueba.tecnica.superheroe.dao;

import java.util.List;

import prueba.tecnica.superheroe.model.Superheroe;

public interface SuperheroeDao {

	public Superheroe findSuperheroeById(Integer id);
	public List<Superheroe> findAllSuperheroe();
	public List<Superheroe> findSuperheroeContains(String nombre);
	public Superheroe saveSuperheroe(Superheroe superheroe);
	public void deleteSuperheroe(Integer id);
	
}
