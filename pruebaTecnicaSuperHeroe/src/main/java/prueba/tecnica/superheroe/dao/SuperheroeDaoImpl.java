package prueba.tecnica.superheroe.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prueba.tecnica.superheroe.exception.DatabaseException;
import prueba.tecnica.superheroe.exception.NotFoundException;
import prueba.tecnica.superheroe.model.Superheroe;
import prueba.tecnica.superheroe.repository.SuperheroeRepository;

@Service
public class SuperheroeDaoImpl implements SuperheroeDao {

	@Autowired
	SuperheroeRepository superheroeRepository;
	
	@Override
	public Superheroe findSuperheroeById(Integer id) {
		Superheroe superheroe = null;
		try {
			superheroe = superheroeRepository.findById(id).orElse(null);
		}catch(Exception ex) {
			throw new DatabaseException("Error: Fallo acceso a los datos");
		}
		if (superheroe == null) {
			throw new NotFoundException("Error: Superheroe con id: " + id + " no existe");
		}
		return superheroe;
	}

	@Override
	public List<Superheroe> findAllSuperheroe() {
		List<Superheroe> superheroes = superheroeRepository.findAll();
		try {
			superheroes = superheroeRepository.findAll();
		}catch(Exception ex) {
			throw new DatabaseException("Error: Fallo acceso a los datos");
		}
		return superheroes;
	}

	@Override
	public Superheroe saveSuperheroe(Superheroe superheroe) {
		Superheroe superheroeresp = null;
		try {
			superheroeresp = superheroeRepository.save(superheroe);
		}catch(Exception ex) {
			throw new DatabaseException("Error: Fallo acceso a los datos");
		}
		return superheroeresp;
	}

	@Override
	public void deleteSuperheroe(Integer id) {
		try {
			superheroeRepository.deleteById(id);
		}catch(Exception ex) {
			throw new DatabaseException("Error: Fallo acceso a los datos");
		}
	}

	@Override
	public List<Superheroe> findSuperheroeContains(String nombre) {
		List<Superheroe> superheroes = null;
			try {
				superheroes = superheroeRepository.findByNombreContains(nombre.toLowerCase());
			}catch(Exception ex) {
				throw new DatabaseException("Error: Fallo acceso a los datos");
			}
		return superheroes;
	}

	
}
