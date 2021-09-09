package co.com.tiopepe.utilcargadatos;

import co.com.tiopepe.model.producto.Producto;
import co.com.tiopepe.model.tienda.Tienda;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UtilCargaDatosHelper {

    public static final String ARCHIVO_TIENDAS = "Tiendas.txt";
    public static final String ARCHIVO_PRODUCTOS = "Productos.txt";

    public static List<Tienda> cargarTiendas() {
        List<Tienda> listaTiendas = new ArrayList<>();

        try {
            listaTiendas = Files
                    .lines(Paths.get(ResourceUtils.getFile(ARCHIVO_TIENDAS).toURI()))
                    .map(linea -> {
                        String[] values = linea.split(",");

                        return new Tienda(values[0], values[1], values[2], values[3]);
                    }).collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de tiendas");
        }

        return listaTiendas;
    }

    public static List<Tienda> cargarCartas(List<Tienda> listaTiendas) {
        List<Producto> listaProductos = new ArrayList<>();
        Optional<Tienda> tienda;

        try {
            listaProductos = Files
                    .lines(Paths.get(ResourceUtils.getFile(ARCHIVO_PRODUCTOS).toURI()))
                    .map(linea -> {
                        String[] values = linea.split(",");

                        return new Producto(values[0], values[1], values[2], values[3],
                                Double.parseDouble(values[4]),
                                Boolean.parseBoolean(values[5]),
                                Arrays.asList(values[6].split("-")));
                    }).collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de productos");
        }

        for(Producto producto : listaProductos) {
            tienda = listaTiendas.stream().filter(t -> t.getCodigo().equals(producto.getIdTienda())).findFirst();
            if(producto.getTipo().equals("preparado") && !producto.isEspecial()) {
                tienda.get().getCarta().getPlatosPreparados().add(producto);
            } else if(producto.getTipo().equals("preparado") && producto.isEspecial()) {
                tienda.get().getCarta().getPlatosEspeciales().add(producto);
            } else if(producto.getTipo().equals("ingredientes")) {
                tienda.get().getCarta().getIngredientes().add(producto);
            } else if(producto.getTipo().equals("bebida")) {
                tienda.get().getCarta().getBebidas().add(producto);
            }
        }

        return listaTiendas;
    }
}
