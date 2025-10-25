package dev.jgunsett.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.*;


@Entity
@Table(name="pacientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "El nombre es obligatorio")
	@Column(nullable = false)
	private String nombre;
	
	@NotBlank(message = "El apellido es obligatorio")
	@Column(nullable = false)
	private String apellido;
	
	@Pattern(regexp="\\d{8, 9}", message="Ingrese un documento valido")
	@Column(unique=true, nullable=false)
	private Integer documento;
	
	@Email(message="Debe ser un correo valido")
	@Column(unique=true, nullable=false)
	private String email;
	
	@Pattern(regexp="\\d{10, 15}", message="El numero de telefono debe contener entre10 y 15 digitos")
	private String telefono;
	
	@PastOrPresent(message="La fecha de alta no debe ser futura.")
	private LocalDate fechaAlta = LocalDate.now();
	
    // Si luego queremos relacionar con turnos, se haría algo así:
    // @OneToMany(mappedBy = "paciente")
    // private List<Turno> turnos;
}
