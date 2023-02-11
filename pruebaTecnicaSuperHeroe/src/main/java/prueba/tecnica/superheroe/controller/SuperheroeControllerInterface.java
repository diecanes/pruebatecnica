package prueba.tecnica.superheroe.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import prueba.tecnica.superheroe.model.Superheroe;

@RequestMapping("/superheroe")
public interface SuperheroeControllerInterface {

	@GetMapping(path = "/")
	public List<Superheroe> getAllSuperheroe();
	
	@GetMapping(path = "/{id}")
	public Superheroe getSuperheroe(@PathVariable int id);
	
	@GetMapping(path= "/", params = "nombre")
	public List<Superheroe> getSuperheroeByName(@RequestParam("nombre") String nombre);
	
	@DeleteMapping
	public void deleteSuperheroe(@PathVariable int id);
	
	@PatchMapping
	public void patchSuperheroe(@PathVariable int id,
				@RequestParam("nombre") String nombre);
	
	
}
