package dev.jgunsett.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

/*
Una entidad representa una tabla en la base de datos.
Cada atributo es una columna y se mapea automaticamente con JPA/Hibernate.
Cuando se ejecuta la app, Hibernate crea esta tabla automaticamente si es que no existe.
* */

@Entity //Marca la clase como una entidad JPA (Mapeada a una tabla SQL)
@Table(name = "usuarios") //Define el nombre de la tabla, esto es opcional. Por defecto seria el nombre de la clase.
@Data //Lombok Genera automaticamente los getters, setters, equals(), hashCode() y toString()
@NoArgsConstructor //Genera un constructor vacio. Esto es requerido po JPA
@AllArgsConstructor //Genera un constructor con todos los campos.
@Builder //Permite construir objetos de forma fluida: Usuario.builder().nombre("Juan").email("...").build()
public class Usuario {
	
	@Id //Indica la clave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Delega al motor de base de datos la generacion automatica del ID (autoincremental)
	private Long id;
	
	@NotBlank(message = "El nombre es obligatorio")
	private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    private String apellido;
	
	@Email(message = "El correo debe tener el formato valido")
	@NotBlank(message = "El correo es obligatorio")
	private String email;

    @Pattern(regexp = "\\d{10,15}", message = "El teléfono debe tener entre 10 y 15 dígitos")
    private String telefono;

    @NotBlank
    private String password;

    @NotBlank(message = "El rol es obligatorio")
    private String rol;
}
