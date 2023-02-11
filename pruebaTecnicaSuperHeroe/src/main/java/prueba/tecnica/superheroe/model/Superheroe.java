package prueba.tecnica.superheroe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="SUPERHEROE")
public class Superheroe {

	@Id @Column(name="id")
	private Integer id;
	
	@Column(name="nombre")
	private String nombre;
	
}
