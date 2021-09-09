package co.com.tiopepe.usecase.realizaventa;

import co.com.tiopepe.model.factura.Factura;
import co.com.tiopepe.model.factura.ProductoFactura;
import co.com.tiopepe.model.factura.gateways.FacturaRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RealizaVentaUseCase {

    private final FacturaRepository facturaRepository;

    public Factura generarFacturaVenta(Factura factura) {
        factura = facturaRepository.generarFacturaVenta(factura);
        if(factura != null) {
            return calcularValoresVenta(factura);
        } else {
            return null;
        }
    }

    private Factura calcularValoresVenta(Factura factura) {
        double totalFactura = 0;
        double valorTotal;
        for (ProductoFactura p : factura.getProductosVendidos()) {
            valorTotal = p.getValorUnitario() * p.getCantidad();
            totalFactura += valorTotal;
            p.setValorTotal(valorTotal);
        }
        factura.setValorTotal(totalFactura);
        return factura;
    }
}
