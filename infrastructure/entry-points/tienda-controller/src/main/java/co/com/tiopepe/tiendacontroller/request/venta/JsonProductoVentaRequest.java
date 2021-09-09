package co.com.tiopepe.tiendacontroller.request.venta;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class JsonProductoVentaRequest {

    @JsonProperty("idProducto")
    private String idProducto;

    @JsonProperty("cantidad")
    private int cantidad;
}
