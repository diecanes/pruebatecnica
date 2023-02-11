package prueba.tecnica.superheroe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prueba.tecnica.superheroe.dao.SuperheroeDaoImpl;
import prueba.tecnica.superheroe.model.Superheroe;

@Service
public class SuperheroeServiceImpl implements SuperheroeServiceInterface {

	@Autowired
	SuperheroeDaoImpl superheroeDao;
	
	@Override
	public List<Superheroe> getSuperheroes() {
		List<Superheroe> superheroes = superheroeDao.findAllSuperheroe();
		return superheroes;
	}

	@Override
	public List<Superheroe> getSuperheroes(String nombre) {
		List<Superheroe> superheroes = superheroeDao.findSuperheroeContains(nombre.toLowerCase());
		return superheroes;
	}

	@Override
	public Superheroe getSuperheroe(int id) {
		Superheroe superheroe = superheroeDao.findSuperheroeById(id);
		return superheroe;
	}

	@Override
	public void deleteSuperheroe(int id) {
		superheroeDao.deleteSuperheroe(id);
	}

	@Override
	public Superheroe modifySuperheroe(int id, String nombre) {
		Superheroe superheroe = superheroeDao.findSuperheroeById(id);
		superheroe.setNombre(nombre);
		return superheroeDao.saveSuperheroe(superheroe);
	}

}
