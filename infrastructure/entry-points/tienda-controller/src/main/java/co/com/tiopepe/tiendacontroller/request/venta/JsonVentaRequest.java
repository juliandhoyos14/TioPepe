package co.com.tiopepe.tiendacontroller.request.venta;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class JsonVentaRequest {

    @JsonProperty("idTienda")
    private String idTienda;

    @JsonProperty("idCliente")
    private String idCliente;

    @JsonProperty("tipoVenta")
    private String tipoVenta;

    @JsonProperty("productos")
    private List<JsonProductoVentaRequest> listaProductos;
}
