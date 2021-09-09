package co.com.tiopepe.model.factura.gateways;

import co.com.tiopepe.model.factura.Factura;

public interface FacturaRepository {

    Factura generarFacturaVenta(Factura factura);
}
