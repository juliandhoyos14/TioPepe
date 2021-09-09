package co.com.tiopepe.tiendacontroller.response.tienda;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
public class JsonTiendaResponse {

    @JsonProperty("codigo")
    private String codigo;

    @JsonProperty("departamento")
    private String departamento;

    @JsonProperty("ciudad")
    private String ciudad;

    @JsonProperty("nombre")
    private String nombre;
}
