package co.com.tiopepe.model.factura;

import lombok.Data;

@Data
public class ProductoFactura {

    private String id;
    private String tipo;
    private String nombre;
    private Double valorUnitario;
    private int cantidad;
    private Double valorTotal;

}
