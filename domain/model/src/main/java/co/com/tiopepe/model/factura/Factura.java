package co.com.tiopepe.model.factura;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Factura {

    private static int consecutivoGenerado = 100;
    private String idTienda;
    private String consecutivo;
    private String idCliente;
    private String tipoVenta;
    private List<ProductoFactura> productosVendidos = new ArrayList<>();
    private Double valorTotal;

    public Factura() {
        this.consecutivo = String.valueOf(consecutivoGenerado++);
    }

}
