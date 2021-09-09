package co.com.tiopepe.tiendacontroller.response;

import co.com.tiopepe.model.carta.Carta;
import co.com.tiopepe.model.factura.Factura;
import co.com.tiopepe.model.factura.ProductoFactura;
import co.com.tiopepe.model.producto.Producto;
import co.com.tiopepe.model.tienda.Tienda;
import co.com.tiopepe.tiendacontroller.response.carta.JsonCartaResponse;
import co.com.tiopepe.tiendacontroller.response.carta.JsonListasProductosCartaResponse;
import co.com.tiopepe.tiendacontroller.response.carta.JsonProductoCartaResponse;
import co.com.tiopepe.tiendacontroller.response.factura.JsonFacturaResponse;
import co.com.tiopepe.tiendacontroller.response.factura.JsonProductoFacturaResponse;
import co.com.tiopepe.tiendacontroller.response.producto.JsonListaProductosResponse;
import co.com.tiopepe.tiendacontroller.response.producto.JsonProductoResponse;
import co.com.tiopepe.tiendacontroller.response.tienda.JsonListaTiendasResponse;
import co.com.tiopepe.tiendacontroller.response.tienda.JsonTiendaResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ResponseMapping {

    public JsonListaTiendasResponse getListaTiendasResponse(List<Tienda> listaTiendas) {
        JsonListaTiendasResponse response = new JsonListaTiendasResponse();
        JsonTiendaResponse jsonTiendaResponse;
        for (Tienda t : listaTiendas) {
            jsonTiendaResponse = new JsonTiendaResponse();
            jsonTiendaResponse.setCodigo(t.getCodigo());
            jsonTiendaResponse.setCiudad(t.getCiudad());
            jsonTiendaResponse.setDepartamento(t.getDepartamento());
            jsonTiendaResponse.setNombre(t.getNombre());
            response.getTiendas().add(jsonTiendaResponse);
        }
        return response;
    }

    public JsonCartaResponse getCartaResponse(Carta carta, String idTienda) {
        JsonCartaResponse response = new JsonCartaResponse();
        JsonListasProductosCartaResponse jsonListasProductos = new JsonListasProductosCartaResponse();
        JsonProductoCartaResponse jsonProducto;

        if(carta.getPlatosPreparados() != null && carta.getPlatosPreparados().size() > 0) {
            List<JsonProductoCartaResponse> platosPreparados = new ArrayList<>();
            for (Producto p : carta.getPlatosPreparados()) {
                jsonProducto = new JsonProductoCartaResponse();
                jsonProducto.setNombre(p.getNombre());
                jsonProducto.setPrecio(p.getPrecio());
                jsonProducto.setIngredientes(p.getIngredientes() != null ? p.getIngredientes() : null);
                platosPreparados.add(jsonProducto);
            }
            jsonListasProductos.setPlatosPreparados(platosPreparados);
        }

        if(carta.getPlatosEspeciales() != null && carta.getPlatosEspeciales().size() > 0) {
            List<JsonProductoCartaResponse> platosEspeciales = new ArrayList<>();
            for (Producto p : carta.getPlatosEspeciales()) {
                jsonProducto = new JsonProductoCartaResponse();
                jsonProducto.setNombre(p.getNombre());
                jsonProducto.setPrecio(p.getPrecio());
                jsonProducto.setIngredientes(p.getIngredientes() != null ? p.getIngredientes() : null);
                platosEspeciales.add(jsonProducto);
            }
            jsonListasProductos.setPlatosEspeciales(platosEspeciales);
        }

        if(carta.getIngredientes() != null && carta.getIngredientes().size() > 0) {
            List<JsonProductoCartaResponse> insumos = new ArrayList<>();
            for (Producto p : carta.getIngredientes()) {
                jsonProducto = new JsonProductoCartaResponse();
                jsonProducto.setNombre(p.getNombre());
                jsonProducto.setPrecio(p.getPrecio());
                jsonProducto.setIngredientes(p.getIngredientes() != null ? p.getIngredientes() : null);
                insumos.add(jsonProducto);
            }
            jsonListasProductos.setIngredientes(insumos);
        }

        if(carta.getBebidas() != null && carta.getBebidas().size() > 0) {
            List<JsonProductoCartaResponse> bebidas = new ArrayList<>();
            for (Producto p : carta.getBebidas()) {
                jsonProducto = new JsonProductoCartaResponse();
                jsonProducto.setNombre(p.getNombre());
                jsonProducto.setPrecio(p.getPrecio());
                jsonProducto.setIngredientes(p.getIngredientes() != null ? p.getIngredientes() : null);
                bebidas.add(jsonProducto);
            }
            jsonListasProductos.setBebidas(bebidas);
        }

        response.setIdTienda(idTienda);
        response.setPlatos(jsonListasProductos);

        return response;
    }

    public JsonListaProductosResponse getListaProductosResponse(List<Producto> listaProductos, String idTienda) {
        JsonListaProductosResponse response = new JsonListaProductosResponse();
        JsonProductoResponse jsonProductoResponse;
        for (Producto p : listaProductos) {
            jsonProductoResponse = new JsonProductoResponse();
            jsonProductoResponse.setIdProducto(p.getId());
            jsonProductoResponse.setTipo(p.getTipo());
            jsonProductoResponse.setNombre(p.getNombre());
            jsonProductoResponse.setPrecio(p.getPrecio());
            jsonProductoResponse.setEspecial(p.isEspecial() ? "SI" : "NO");
            jsonProductoResponse.setIngredientes(p.getIngredientes() != null ? p.getIngredientes() : null);
            response.getListaProductos().add(jsonProductoResponse);
        }
        response.setIdTienda(idTienda);
        return response;
    }

    public JsonFacturaResponse getFacturaResponse(Factura factura) {
        JsonFacturaResponse jsonFacturaResponse = new JsonFacturaResponse();
        JsonProductoFacturaResponse jsonProductoFacturaResponse;
        jsonFacturaResponse.setIdTienda(factura.getIdTienda());
        jsonFacturaResponse.setConsecutivo(factura.getConsecutivo());
        jsonFacturaResponse.setIdCliente(factura.getIdCliente());
        jsonFacturaResponse.setTipoVenta(factura.getTipoVenta());
        jsonFacturaResponse.setValorTotal(factura.getValorTotal());
        for (ProductoFactura p : factura.getProductosVendidos()) {
            jsonProductoFacturaResponse = new JsonProductoFacturaResponse();
            jsonProductoFacturaResponse.setId(p.getId());
            jsonProductoFacturaResponse.setTipo(p.getTipo());
            jsonProductoFacturaResponse.setNombre(p.getNombre());
            jsonProductoFacturaResponse.setValorUnitario(p.getValorUnitario());
            jsonProductoFacturaResponse.setCantidad(p.getCantidad());
            jsonProductoFacturaResponse.setValorTotal(p.getValorTotal());
            jsonFacturaResponse.getProductosVendidos().add(jsonProductoFacturaResponse);
        }
        return jsonFacturaResponse;
    }
}
