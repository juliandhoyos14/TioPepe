package co.com.tiopepe.usecase.visualizacarta;

import co.com.tiopepe.model.carta.Carta;
import co.com.tiopepe.model.carta.gateways.CartaRepository;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
public class VisualizaCartaUseCase {

    private final CartaRepository cartaRepository;

    public Carta obtenerCartaPorTienda(String idTienda) {
        return cartaRepository.obtenerCartaPorTienda(idTienda);
    }
}
