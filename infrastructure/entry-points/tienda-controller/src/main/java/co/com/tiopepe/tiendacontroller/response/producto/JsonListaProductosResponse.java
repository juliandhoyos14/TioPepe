package co.com.tiopepe.tiendacontroller.response.producto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class JsonListaProductosResponse {

    @JsonProperty("idTienda")
    String idTienda;

    @JsonProperty("productos")
    private List<JsonProductoResponse> listaProductos = new ArrayList<>();
}
