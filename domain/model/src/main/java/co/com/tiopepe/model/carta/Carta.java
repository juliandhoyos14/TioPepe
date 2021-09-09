package co.com.tiopepe.model.carta;

import co.com.tiopepe.model.producto.Producto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Carta {

    private List<Producto> platosPreparados;
    private List<Producto> platosEspeciales;
    private List<Producto> ingredientes;
    private List<Producto> bebidas;

    public Carta() {
        this.platosPreparados = new ArrayList<>();
        this.platosEspeciales = new ArrayList<>();
        this.ingredientes = new ArrayList<>();
        this.bebidas = new ArrayList<>();
    }
}
