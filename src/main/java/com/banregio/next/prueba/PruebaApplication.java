package com.banregio.next.prueba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.banregio.next.common.NextConfiguration;

/**
 * Clase main que inicia el despliegue del proyecto.
 * La anotación {@link NextConfiguration} permite iniciar en el orden correspondiente 
 * las configuraciones y beans requeridos para el funcionamiento del módulo.
 * 
 * @author ${user}
 * @since ${date}
 */
@SpringBootApplication
@NextConfiguration
public class PruebaApplication {

    public static void main(String[] args) {
        SpringApplication.run(PruebaApplication.class, args);
    }
}
