package co.com.tiopepe.tiendaserviceimpl;

import co.com.tiopepe.model.carta.Carta;
import co.com.tiopepe.model.carta.gateways.CartaRepository;
import co.com.tiopepe.model.factura.Factura;
import co.com.tiopepe.model.factura.ProductoFactura;
import co.com.tiopepe.model.factura.gateways.FacturaRepository;
import co.com.tiopepe.model.producto.Producto;
import co.com.tiopepe.model.producto.gateways.ProductoRepository;
import co.com.tiopepe.model.tienda.Tienda;
import co.com.tiopepe.model.tienda.gateways.TiendaRepository;
import co.com.tiopepe.utilcargadatos.UtilCargaDatosHelper;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TiendaServiceImpl implements TiendaRepository, CartaRepository, FacturaRepository, ProductoRepository {

    private List<Tienda> listaTiendas = new ArrayList<>();

    @PostConstruct
    public void init() {
        listaTiendas = UtilCargaDatosHelper.cargarTiendas();
        listaTiendas = UtilCargaDatosHelper.cargarCartas(listaTiendas);
    }

    @Override
    public Carta obtenerCartaPorTienda(String idTienda) {
        Optional<Tienda> tienda = listaTiendas
                .stream()
                .filter(t -> t.getCodigo().equals(idTienda))
                .findFirst();

        if(!tienda.equals(Optional.empty())) {
            return tienda.get().getCarta();
        } else {
            return null;
        }
    }

    @Override
    public Factura generarFacturaVenta(Factura factura) {

        List<Producto> listaProductosTienda = obtenerProductosPorTienda(factura.getIdTienda());
        for(ProductoFactura productoFactura : factura.getProductosVendidos()) {
            Optional<Producto> producto = listaProductosTienda
                    .stream()
                    .filter(p -> p.getId().equals(productoFactura.getId()))
                    .findFirst();
            if(!producto.equals(Optional.empty())) {
                productoFactura.setNombre(producto.get().getNombre());
                productoFactura.setTipo(producto.get().getTipo());
                productoFactura.setValorUnitario(producto.get().getPrecio());
            } else {
                return null;
            }
        }

        return factura;
    }

    @Override
    public List<Producto> obtenerProductosPorTienda(String idTienda) {
        Optional<Tienda> tienda = listaTiendas
                .stream()
                .filter(t -> t.getCodigo().equals(idTienda))
                .findFirst();

        if(!tienda.equals(Optional.empty())) {
            List<Producto> result = new ArrayList<>();
            result.addAll(tienda.get().getCarta().getPlatosPreparados());
            result.addAll(tienda.get().getCarta().getPlatosEspeciales());
            result.addAll(tienda.get().getCarta().getBebidas());
            result.addAll(tienda.get().getCarta().getIngredientes());
            return result;
        } else {
            return null;
        }
    }

    @Override
    public List<Producto> obtenerPlatosPreparadosPorTienda(String idTienda) {
        Optional<Tienda> tienda = listaTiendas
                .stream()
                .filter(t -> t.getCodigo().equals(idTienda))
                .findFirst();

        if(!tienda.equals(Optional.empty())) {
            return tienda.get().getCarta().getPlatosPreparados();
        } else {
            return null;
        }
    }

    @Override
    public List<Producto> obtenerPlatosEspecialesPorTienda(String idTienda) {
        Optional<Tienda> tienda = listaTiendas
                .stream()
                .filter(t -> t.getCodigo().equals(idTienda))
                .findFirst();

        if(!tienda.equals(Optional.empty())) {
            return tienda.get().getCarta().getPlatosEspeciales();
        } else {
            return null;
        }
    }

    @Override
    public List<Producto> obtenerBebidasPorTienda(String idTienda) {
        Optional<Tienda> tienda = listaTiendas
                .stream()
                .filter(t -> t.getCodigo().equals(idTienda))
                .findFirst();

        if(!tienda.equals(Optional.empty())) {
            return tienda.get().getCarta().getBebidas();
        } else {
            return null;
        }
    }

    @Override
    public List<Producto> obtenerIngredientesPorTienda(String idTienda) {
        Optional<Tienda> tienda = listaTiendas
                .stream()
                .filter(t -> t.getCodigo().equals(idTienda))
                .findFirst();

        if(!tienda.equals(Optional.empty())) {
            return tienda.get().getCarta().getIngredientes();
        } else {
            return null;
        }
    }

    @Override
    public List<Tienda> obtenerListaTiendas() {
        return this.listaTiendas;
    }

    @Override
    public List<Tienda> obtenerTiendasPorDepartamento(String departamento) {
        return listaTiendas
                .stream()
                .filter(t -> t.getDepartamento().equalsIgnoreCase(departamento))
                .collect(Collectors.toList());
    }

    @Override
    public List<Tienda> obtenerTiendasPorCiudad(String ciudad) {
        return listaTiendas
                .stream()
                .filter(t -> t.getCiudad().equalsIgnoreCase(ciudad))
                .collect(Collectors.toList());
    }
}
