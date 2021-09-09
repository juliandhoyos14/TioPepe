package co.com.tiopepe.tiendacontroller.response.carta;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class JsonCartaResponse {

    @JsonProperty("idTienda")
    private String idTienda;

    @JsonProperty("productos")
    private JsonListasProductosCartaResponse platos;

}
