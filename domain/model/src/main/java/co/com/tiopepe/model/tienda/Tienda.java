package co.com.tiopepe.model.tienda;
import co.com.tiopepe.model.carta.Carta;
import lombok.Builder;
import lombok.Data;

@Data
public class Tienda {

    public Tienda(String codigo, String departamento, String ciudad, String nombre) {
        this.codigo = codigo;
        this.departamento = departamento;
        this.ciudad = ciudad;
        this.nombre = nombre;
        this.carta = new Carta();
    }

    private String codigo;
    private String departamento;
    private String ciudad;
    private String nombre;
    private Carta carta;
}
