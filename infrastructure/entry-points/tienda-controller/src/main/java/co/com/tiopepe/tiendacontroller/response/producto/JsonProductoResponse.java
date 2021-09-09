package co.com.tiopepe.tiendacontroller.response.producto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class JsonProductoResponse {

    @JsonProperty("idProducto")
    private String idProducto;

    @JsonProperty("tipo")
    private String tipo;

    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("precio")
    private Double precio;

    @JsonProperty("especial")
    private String especial;

    @JsonProperty("ingredientes")
    private List<String> ingredientes;
}
