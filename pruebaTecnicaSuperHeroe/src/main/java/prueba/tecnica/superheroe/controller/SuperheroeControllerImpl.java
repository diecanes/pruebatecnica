package prueba.tecnica.superheroe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import prueba.tecnica.superheroe.model.Superheroe;
import prueba.tecnica.superheroe.service.SuperheroeServiceImpl;

@RestController
public class SuperheroeControllerImpl implements SuperheroeControllerInterface {

	@Autowired
	SuperheroeServiceImpl superheroeService;
	
	@Override
	public List<Superheroe> getAllSuperheroe() {
		return superheroeService.getSuperheroes();
	}

	@Override
	public Superheroe getSuperheroe(int id) {
		return superheroeService.getSuperheroe(id);
	}

	@Override
	public List<Superheroe> getSuperheroeByName(String nombre) {
		return superheroeService.getSuperheroes(nombre);
	}

	@Override
	public void deleteSuperheroe(int id) {
		superheroeService.deleteSuperheroe(id);	
	}

	@Override
	public Superheroe patchSuperheroe(int id, String nombre) {
		return superheroeService.modifySuperheroe(id, nombre);	
	}

}
