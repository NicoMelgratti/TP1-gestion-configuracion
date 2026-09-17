package com.utn.logistics;

import com.utn.logistics.wms.WarehouseService;
import com.utn.logistics.tms.TransportService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    void testStockYDespacho() {
        WarehouseService wms = new WarehouseService();
        wms.recibirProducto("P1", 10);
        assertEquals(10, wms.getStock("P1"));

        boolean despachado = wms.despacharProducto("P1", 4);
        assertTrue(despachado);
        assertEquals(6, wms.getStock("P1"));
    }

    @Test
    void testCreacionYTrackingEnvio() {
        TransportService tms = new TransportService();
        String id = tms.crearEnvio("PED-1", "Calle 1");
        assertEquals("EN_PREPARACION", tms.getEstado(id));

        tms.actualizarEstado(id, "ENTREGADO");
        assertEquals("ENTREGADO", tms.getEstado(id));
    }
}
