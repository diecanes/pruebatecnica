package prueba.tecnica.superheroe.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import prueba.tecnica.superheroe.model.Superheroe;

@RequestMapping("/superheroe")
public interface SuperheroeControllerInterface {

	@GetMapping
	public List<Superheroe> getAllSuperheroe();
	
	@GetMapping(path = "/{id}")
	public Superheroe getSuperheroe(@PathVariable int id);
	
	@GetMapping(params = "nombre")
	public List<Superheroe> getSuperheroeByName(@RequestParam("nombre") String nombre);
	
	@DeleteMapping(path = "/{id}")
	@PreAuthorize("isAuthenticated()")
	public void deleteSuperheroe(@PathVariable int id);
	
	@PatchMapping(path = "/{id}")
	@PreAuthorize("isAuthenticated()")
	public Superheroe patchSuperheroe(@PathVariable int id,
				@RequestParam("nombre") String nombre);
	
	
}
