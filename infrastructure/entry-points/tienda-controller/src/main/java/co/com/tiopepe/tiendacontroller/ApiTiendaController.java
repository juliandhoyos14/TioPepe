package co.com.tiopepe.tiendacontroller;

import co.com.tiopepe.model.carta.Carta;
import co.com.tiopepe.model.factura.Factura;
import co.com.tiopepe.model.producto.Producto;
import co.com.tiopepe.model.tienda.Tienda;
import co.com.tiopepe.tiendacontroller.request.RequestMapping;
import co.com.tiopepe.tiendacontroller.request.venta.JsonVentaRequest;
import co.com.tiopepe.tiendacontroller.response.carta.JsonCartaResponse;
import co.com.tiopepe.tiendacontroller.response.factura.JsonFacturaResponse;
import co.com.tiopepe.tiendacontroller.response.producto.JsonListaProductosResponse;
import co.com.tiopepe.tiendacontroller.response.tienda.JsonListaTiendasResponse;
import co.com.tiopepe.tiendacontroller.response.ResponseMapping;
import co.com.tiopepe.usecase.listaproductos.ListaProductosUseCase;
import co.com.tiopepe.usecase.listatiendas.ListaTiendasUseCase;
import co.com.tiopepe.usecase.realizaventa.RealizaVentaUseCase;
import co.com.tiopepe.usecase.visualizacarta.VisualizaCartaUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
public class ApiTiendaController {

    private final ListaTiendasUseCase listaTiendasUseCase;
    private final ListaProductosUseCase listaProductosUseCase;
    private final VisualizaCartaUseCase visualizaCartaUseCase;
    private final RealizaVentaUseCase realizaVentaUseCase;

    private final ResponseMapping responseMapping;
    private final RequestMapping requestMapping;

    @GetMapping(path = "/tienda/lista")
    public ResponseEntity<JsonListaTiendasResponse> getListaTiendas() {

        List<Tienda> listaTiendas = listaTiendasUseCase.obtenerListaTiendas();
        JsonListaTiendasResponse response;

        if(listaTiendas != null && listaTiendas.size() > 0) {
            response = responseMapping.getListaTiendasResponse(listaTiendas);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping(path = "/tienda/lista/departamento/{departamento}")
    public ResponseEntity<JsonListaTiendasResponse> getListaTiendasPorDepartamento(@PathVariable String departamento) {

        List<Tienda> listaTiendas = listaTiendasUseCase.obtenerTiendasPorDepartamento(departamento);
        JsonListaTiendasResponse response;

        if(listaTiendas != null && listaTiendas.size() > 0) {
            response = responseMapping.getListaTiendasResponse(listaTiendas);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping(path = "/tienda/lista/ciudad/{ciudad}")
    public ResponseEntity<JsonListaTiendasResponse> getListaTiendasPorCiudad(@PathVariable String ciudad) {

        List<Tienda> listaTiendas = listaTiendasUseCase.obtenerTiendasPorCiudad(ciudad);
        JsonListaTiendasResponse response;

        if(listaTiendas != null && listaTiendas.size() > 0) {
            response = responseMapping.getListaTiendasResponse(listaTiendas);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping(path = "/tienda/carta/{idTienda}")
    public ResponseEntity<JsonCartaResponse> getCartaPorTienda(@PathVariable String idTienda) {

        Carta carta = visualizaCartaUseCase.obtenerCartaPorTienda(idTienda);
        JsonCartaResponse response;

        if(carta != null) {
            response = responseMapping.getCartaResponse(carta, idTienda);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping(path = "/tienda/listaproductos/{idTienda}")
    public ResponseEntity<JsonListaProductosResponse> getProductosPorTienda(@PathVariable String idTienda) {

        List<Producto> listaProductos = listaProductosUseCase.obtenerProductosPorTienda(idTienda);

        JsonListaProductosResponse response;

        if(listaProductos != null && listaProductos.size() > 0) {
            response = responseMapping.getListaProductosResponse(listaProductos, idTienda);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping(path = "/tienda/preparados/{idTienda}")
    public ResponseEntity<JsonListaProductosResponse> getPlatosPreparadosPorTienda(@PathVariable String idTienda) {

        List<Producto> listaProductos = listaProductosUseCase.obtenerPlatosPreparadosPorTienda(idTienda);

        JsonListaProductosResponse response;

        if(listaProductos != null && listaProductos.size() > 0) {
            response = responseMapping.getListaProductosResponse(listaProductos, idTienda);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping(path = "/tienda/especiales/{idTienda}")
    public ResponseEntity<JsonListaProductosResponse> getPlatosEspecialesPorTienda(@PathVariable String idTienda) {
        List<Producto> listaProductos = listaProductosUseCase.obtenerPlatosEspecialesPorTienda(idTienda);

        JsonListaProductosResponse response;

        if(listaProductos != null && listaProductos.size() > 0) {
            response = responseMapping.getListaProductosResponse(listaProductos, idTienda);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping(path = "/tienda/bebidas/{idTienda}")
    public ResponseEntity<JsonListaProductosResponse> getBebidasPorTienda(@PathVariable String idTienda) {
        List<Producto> listaProductos = listaProductosUseCase.obtenerBebidasPorTienda(idTienda);

        JsonListaProductosResponse response;

        if(listaProductos != null && listaProductos.size() > 0) {
            response = responseMapping.getListaProductosResponse(listaProductos, idTienda);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping(path = "/tienda/ingredientes/{idTienda}")
    public ResponseEntity<JsonListaProductosResponse> getIngredientesPorTienda(@PathVariable String idTienda) {
        List<Producto> listaProductos = listaProductosUseCase.obtenerIngredientesPorTienda(idTienda);

        JsonListaProductosResponse response;

        if(listaProductos != null && listaProductos.size() > 0) {
            response = responseMapping.getListaProductosResponse(listaProductos, idTienda);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(path = "/tienda/venta")
    public ResponseEntity<JsonFacturaResponse> realizarVenta(@Valid @RequestBody JsonVentaRequest jsonVentaRequest) {
        Factura factura = requestMapping.getFacturaRequest(jsonVentaRequest);
        factura = realizaVentaUseCase.generarFacturaVenta(factura);

        JsonFacturaResponse response;

        if(factura != null) {
            response = responseMapping.getFacturaResponse(factura);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

}
