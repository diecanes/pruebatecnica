package prueba.tecnica.superheroe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import prueba.tecnica.superheroe.model.Superheroe;

@Repository
public interface SuperheroeRepository extends JpaRepository<Superheroe, Integer> {

	@Query("Select * from superheroe s where lower(s.nombre) like %:nombre%")
	public List<Superheroe> findByNombreContains(@Param("nombre") String nombre);
}
