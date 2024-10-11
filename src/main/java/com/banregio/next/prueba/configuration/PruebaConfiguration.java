package com.banregio.next.prueba.configuration;

import com.banregio.next.base.properties.NextProperties;
import com.banregio.next.security.service.interfaces.ExcludeSecurityServices;
import com.banregio.next.security.util.ServiciosContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * En este archivo se crean los beans requeridos para el proyecto, hay que tomar en cuenta
 * que por default cada dependencia de Next carga beans requeridos y pueden ser usados como
 * cualquier otro bean usando
 * <pre>
 * 		@Autowired
 * 		private {@link FoliosGenerator} folios;
 * </pre> 
 *    
 * @author ${user}
 * @since ${date}
 */
@Configuration
public class PruebaConfiguration {

	/**
	 * Este bean sirve para configurar servicios muy particulares, ejemplo:
	 * <p>
	 *  * Servicios que deben ser accedidos con el token de seguridad, solo desde cualquier módulo de Next
	 * </p>
	 * <p>
	 *  * Servicios que deben ser accedidos con el token de seguridad, desde cualquier aplicación externa a Next
	 * </p>
	 * <p>
	 *  * Servicios que deben ser accedidos sin el token de seguridad, solo desde cualquier módulo de Next
	 * </p>
	 * <p>
	 * 	* Servicios que deben ser accedidos sin el token de seguridad, desde cualquier aplicación externa a Next
	 * </p>
	 * <pre>
	 * 	return new ExcludeSecurityServices() {
	 *		@Override
	 *  	public void addServices(ServiciosContainer services) {
	 *		services.serviciosConTokenAccesoExterno("/login");
	 *		services.serviciosConTokenAccesoExterno(HttpMethod.POST, "/login");
	 *		services.serviciosConTokenAccesoInterno("/login");
	 *		services.serviciosConTokenAccesoInterno(HttpMethod.POST, "/login");
	 *		services.serviciosSinTokenAccesoExterno("/login");
	 *		services.serviciosSinTokenAccesoExterno(HttpMethod.POST, "/login");
	 *		services.serviciosSinTokenAccesoInterno("/login");
	 *		services.serviciosSinTokenAccesoInterno(HttpMethod.POST, "/login");
	 *	 	}
     *  };
	 * <pre>
 	 * 
 	 * 
 	 * 
	 * @param props
	 * @return Objeto con una colección de servicios personalizados. 
	 */
    @Bean
    public ExcludeSecurityServices excludeSecurityServices(NextProperties props) {
        return new ExcludeSecurityServices() {

            @Override
            public void addServices(ServiciosContainer services) {
            	services.serviciosSinTokenAccesoExterno("/ejemplos/**"); //Esta configuración permite consumir los servicios de ejemplo sin seguridad
            	services.serviciosSinTokenAccesoExterno("/remoto-venta/**"); //Esta configuración permite consumir los servicios de ejemplo sin seguridad
            }

        };
    }
}
