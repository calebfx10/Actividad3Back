package com.banregio.next.prueba.util;

import com.banregio.next.base.exception.NextAbtractException;
import com.banregio.next.base.exception.NextError200;
import com.banregio.next.base.exception.NextError401;
import com.banregio.next.base.exception.NextError403;
import com.banregio.next.base.exception.NextError404;
import com.banregio.next.base.exception.NextError500;
import com.banregio.next.base.interfaces.NextException;

/**
 * Enunmerador de errores para el m&oacute;dulo de Ejemplo.
 * Se recomienda manterner en esta clase todos los erroes que genera el módulo.
 * ver {@link NextException}, {@link NextError200}, {@link NextError401}, {@link NextError403},
 * {@link NextError404}, {@link NextError500}, {@link NextAbtractException}
 * @author ${user} 
 * @since ${date}
 */
public enum EjemploError implements NextException {
	ERROR_DE_EJEMPLO("Sucedión un error en el módulo de ejemplo.");

	private EjemploError(String message) {
		this.message = message;
	}

	private String message;

	@Override
	public String getMessage() {
		return message;
	}
}