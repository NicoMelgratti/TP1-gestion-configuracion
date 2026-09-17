package com.utn.logistics.tms;

import java.util.HashMap;
import java.util.Map;

// Sistema de Gestion de Envios (TMS)
public class TransportService {
    private Map<String, String> envios = new HashMap<>();

    // Crear un nuevo envio
    public String crearEnvio(String pedidoId, String direccion) {
        String envioId = "ENV-" + pedidoId.toUpperCase();
        envios.put(envioId, "EN_PREPARACION");
        return envioId;
    }

    // Actualizar estado del envio (ej: EN_CAMINO, ENTREGADO)
    public void actualizarEstado(String envioId, String nuevoEstado) {
        if (envios.containsKey(envioId)) {
            envios.put(envioId, nuevoEstado);
        }
    }

    // Consultar estado del envio
    public String getEstado(String envioId) {
        return envios.getOrDefault(envioId, "NO_ENCONTRADO");
    }

    // Cancelacion de envio
    public boolean cancelarEnvio(String envioId) {
        if (envios.containsKey(envioId)) {
            envios.put(envioId, "CANCELADO");
            return true;
        }
        return false;
    }
}
