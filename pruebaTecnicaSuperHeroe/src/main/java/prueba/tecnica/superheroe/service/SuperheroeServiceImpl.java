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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Superheroe> getSuperheroes(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Superheroe getSuperheroe(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteSuperheroe(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Superheroe modifySuperheroe(int id, String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

}
