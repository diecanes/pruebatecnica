package prueba.tecnica.superheroe.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prueba.tecnica.superheroe.model.Superheroe;
import prueba.tecnica.superheroe.repository.SuperheroeRepository;

@Service
public class SuperheroeDaoImpl implements SuperheroeDao {

	@Autowired
	SuperheroeRepository superheroeRepository;
	
	@Override
	public Superheroe findSuperheroeById(Integer id) {
		Superheroe superheroe = superheroeRepository.findById(id).orElse(null);
		return superheroe;
	}

	@Override
	public List<Superheroe> findAllSuperheroe() {
		List<Superheroe> superheroes = superheroeRepository.findAll();
		return superheroes;
	}

	@Override
	public Superheroe saveSuperheroe(Superheroe superheroe) {
		Superheroe superheroeresp = superheroeRepository.save(superheroe);
		return superheroeresp;
	}

	@Override
	public void deleteSuperheroe(Integer id) {
		superheroeRepository.deleteById(id);
	}

	@Override
	public List<Superheroe> findSuperheroeContains(String nombre) {
		List<Superheroe> superheroes = superheroeRepository.findByNombreContains(nombre.toLowerCase());
		return superheroes;
	}

}
