package co.com.tiopepe.model.producto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class Producto {

    private String idTienda;
    private String id;
    private String tipo;
    private String nombre;
    private Double precio;
    private boolean isEspecial;
    private List<String> ingredientes;

    public Producto(String idTienda, String id, String tipo, String nombre, Double precio, boolean isEspecial, List<String> ingredientes) {
        this.idTienda = idTienda;
        this.id = id;
        this.tipo = tipo;
        this.nombre = nombre;
        this.precio = precio;
        this.isEspecial = isEspecial;
        this.ingredientes = ingredientes;
    }
}
