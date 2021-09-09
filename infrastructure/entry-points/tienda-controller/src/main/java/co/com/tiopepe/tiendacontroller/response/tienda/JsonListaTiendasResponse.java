package co.com.tiopepe.tiendacontroller.response.tienda;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class JsonListaTiendasResponse {

    @JsonProperty("tiendas")
    private List<JsonTiendaResponse> tiendas = new ArrayList<>();

}
