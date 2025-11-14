package dev.jgunsett.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DireccionDTO {
    private String calle;
    private String numero;
    private String ciudad;
    private Long provinciaId;
    private Long paisId;
}
