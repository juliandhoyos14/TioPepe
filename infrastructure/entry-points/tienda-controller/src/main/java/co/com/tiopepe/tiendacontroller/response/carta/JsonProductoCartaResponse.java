package co.com.tiopepe.tiendacontroller.response.carta;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class JsonProductoCartaResponse {

    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("precio")
    private Double precio;

    @JsonProperty("ingredientes")
    private List<String> ingredientes;
}
