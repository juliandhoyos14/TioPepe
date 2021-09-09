package co.com.tiopepe.usecase.listaproductos;

import co.com.tiopepe.model.producto.Producto;
import co.com.tiopepe.model.producto.gateways.ProductoRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ListaProductosUseCase {

    private final ProductoRepository productoRepository;

    public List<Producto> obtenerProductosPorTienda(String idTienda) {
        return productoRepository.obtenerProductosPorTienda(idTienda);
    }

    public List<Producto> obtenerPlatosPreparadosPorTienda(String idTienda) {
        return productoRepository.obtenerPlatosPreparadosPorTienda(idTienda);
    }

    public List<Producto> obtenerPlatosEspecialesPorTienda(String idTienda) {
        return productoRepository.obtenerPlatosEspecialesPorTienda(idTienda);
    }

    public List<Producto> obtenerBebidasPorTienda(String idTienda) {
        return productoRepository.obtenerBebidasPorTienda(idTienda);
    }

    public List<Producto> obtenerIngredientesPorTienda(String idTienda) {
        return productoRepository.obtenerIngredientesPorTienda(idTienda);
    }
}
