package com.utn.logistics.wms;

import java.util.HashMap;
import java.util.Map;

// Sistema de Gestion de Deposito (WMS)
public class WarehouseService {
    private Map<String, Integer> stock = new HashMap<>();

    // Registrar ingreso de mercaderia
    public void recibirProducto(String sku, int cantidad) {
        int actual = stock.getOrDefault(sku, 0);
        stock.put(sku, actual + cantidad);
    }

    // Despachar mercaderia
    public boolean despacharProducto(String sku, int cantidad) {
        int disponible = stock.getOrDefault(sku, 0);
        if (disponible >= cantidad) {
            stock.put(sku, disponible - cantidad);
            return true;
        }
        return false;
    }

    // Consultar stock actual
    public int getStock(String sku) {
        return stock.getOrDefault(sku, 0);
    }
}
