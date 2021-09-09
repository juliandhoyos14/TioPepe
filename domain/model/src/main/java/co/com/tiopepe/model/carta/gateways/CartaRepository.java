package co.com.tiopepe.model.carta.gateways;

import co.com.tiopepe.model.carta.Carta;

public interface CartaRepository {

    Carta obtenerCartaPorTienda(String idTienda);
}
