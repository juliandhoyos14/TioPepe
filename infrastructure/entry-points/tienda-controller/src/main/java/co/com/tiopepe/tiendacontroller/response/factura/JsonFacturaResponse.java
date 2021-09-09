package co.com.tiopepe.tiendacontroller.response.factura;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class JsonFacturaResponse {

    @JsonProperty("idTienda")
    private String idTienda;

    @JsonProperty("consecutivo")
    private String consecutivo;

    @JsonProperty("idCliente")
    private String idCliente;

    @JsonProperty("tipoVenta")
    private String tipoVenta;

    @JsonProperty("valorTotal")
    private Double valorTotal;

    @JsonProperty("productos")
    private List<JsonProductoFacturaResponse> productosVendidos = new ArrayList<>();
}
