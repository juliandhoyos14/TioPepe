package co.com.tiopepe.tiendacontroller.response.carta;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class JsonListasProductosCartaResponse {

    @JsonProperty("platosPreparados")
    private List<JsonProductoCartaResponse> platosPreparados;

    @JsonProperty("platosEspeciales")
    private List<JsonProductoCartaResponse> platosEspeciales;

    @JsonProperty("insumos")
    private List<JsonProductoCartaResponse> ingredientes;

    @JsonProperty("bebidas")
    private List<JsonProductoCartaResponse> bebidas;

}
