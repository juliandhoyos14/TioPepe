package co.com.tiopepe.model.tienda.gateways;

import co.com.tiopepe.model.tienda.Tienda;

import java.util.List;

public interface TiendaRepository {

    List<Tienda> obtenerListaTiendas();

    List<Tienda> obtenerTiendasPorDepartamento(String departamento);

    List<Tienda> obtenerTiendasPorCiudad(String ciudad);
}
