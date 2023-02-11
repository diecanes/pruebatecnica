package prueba.tecnica.superheroe.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import prueba.tecnica.superheroe.model.Superheroe;

@RestController
public class SuperheroeControllerImpl implements SuperheroeControllerInterface {

	@Override
	public List<Superheroe> getAllSuperheroe() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Superheroe getSuperheroe(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Superheroe> getSuperheroeByName(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteSuperheroe(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void patchSuperheroe(int id, String nombre) {
		// TODO Auto-generated method stub
		
	}

}
