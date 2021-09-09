package co.com.tiopepe.tiendacontroller.response.factura;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class JsonProductoFacturaResponse {

    @JsonProperty("idProducto")
    private String id;

    @JsonProperty("tipoProducto")
    private String tipo;

    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("valorUnitario")
    private Double valorUnitario;

    @JsonProperty("cantidad")
    private int cantidad;

    @JsonProperty("valorTotal")
    private Double valorTotal;
}
