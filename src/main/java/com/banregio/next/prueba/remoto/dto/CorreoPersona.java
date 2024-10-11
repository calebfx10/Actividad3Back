package com.banregio.next.prueba.remoto.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Modelo de datos para otro recurso externo, puede solo agregar los atributos que desea.
 * @author ${user}
 * @since ${date}
 */
@Getter
@Setter
public class CorreoPersona {
    private Integer idPersona;
    private Integer idCliente;
    private Integer tipoCorreo;
    private String correo;
    private String status;
}
