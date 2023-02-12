package prueba.tecnica.superheroe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import prueba.tecnica.superheroe.model.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Integer>{

	Usuario findByNombre(String nombre);
	
	
}
