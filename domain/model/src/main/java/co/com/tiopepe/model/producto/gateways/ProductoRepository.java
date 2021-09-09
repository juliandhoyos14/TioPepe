package co.com.tiopepe.model.producto.gateways;

import co.com.tiopepe.model.producto.Producto;

import java.util.List;

public interface ProductoRepository {

    List<Producto> obtenerProductosPorTienda(String idTienda);

    List<Producto> obtenerPlatosPreparadosPorTienda(String idTienda);

    List<Producto> obtenerPlatosEspecialesPorTienda(String idTienda);

    List<Producto> obtenerBebidasPorTienda(String idTienda);

    List<Producto> obtenerIngredientesPorTienda(String idTienda);
}
