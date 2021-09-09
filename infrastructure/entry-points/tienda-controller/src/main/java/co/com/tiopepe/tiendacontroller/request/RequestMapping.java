package co.com.tiopepe.tiendacontroller.request;

import co.com.tiopepe.model.factura.Factura;
import co.com.tiopepe.model.factura.ProductoFactura;
import co.com.tiopepe.tiendacontroller.request.venta.JsonProductoVentaRequest;
import co.com.tiopepe.tiendacontroller.request.venta.JsonVentaRequest;
import org.springframework.stereotype.Component;

@Component
public class RequestMapping {

    public Factura getFacturaRequest(JsonVentaRequest ventaRequest) {
        Factura response = new Factura();
        ProductoFactura productoFactura;
        for (JsonProductoVentaRequest p : ventaRequest.getListaProductos()) {
            productoFactura = new ProductoFactura();
            productoFactura.setId(p.getIdProducto());
            productoFactura.setCantidad(p.getCantidad());

            response.getProductosVendidos().add(productoFactura);
        }
        response.setIdCliente(ventaRequest.getIdCliente());
        response.setTipoVenta(ventaRequest.getTipoVenta());
        response.setIdTienda(ventaRequest.getIdTienda());

        return response;
    }
}
