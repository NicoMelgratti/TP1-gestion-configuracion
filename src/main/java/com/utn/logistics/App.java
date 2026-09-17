package com.utn.logistics;

import com.utn.logistics.wms.WarehouseService;
import com.utn.logistics.tms.TransportService;

public class App {
    public static void main(String[] args) {
        System.out.println("=== Iniciando Sistema WMS y TMS ===");

        WarehouseService wms = new WarehouseService();
        TransportService tms = new TransportService();

        // 1. Recepcion en deposito
        wms.recibirProducto("PROD-1", 100);
        System.out.println("Stock disponible PROD-1: " + wms.getStock("PROD-1"));

        // 2. Despacho y Envio
        if (wms.despacharProducto("PROD-1", 5)) {
            String envioId = tms.crearEnvio("PED-001", "Santa Fe 123");
            tms.actualizarEstado(envioId, "EN_CAMINO");
            System.out.println("Envio " + envioId + " estado: " + tms.getEstado(envioId));
        }

        System.out.println("=== Operacion finalizada exitosamente ===");
    }
}
