package co.com.tiopepe.usecase.listatiendas;

import co.com.tiopepe.model.tienda.Tienda;
import co.com.tiopepe.model.tienda.gateways.TiendaRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ListaTiendasUseCase {

    private final TiendaRepository tiendaRepository;

    public List<Tienda> obtenerListaTiendas() {
        return tiendaRepository.obtenerListaTiendas();
    }

    public List<Tienda> obtenerTiendasPorDepartamento(String departamento) {
        return tiendaRepository.obtenerTiendasPorDepartamento(departamento);
    }

    public List<Tienda> obtenerTiendasPorCiudad(String ciudad) {
        return tiendaRepository.obtenerTiendasPorCiudad(ciudad);
    }
}
