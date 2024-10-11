/*
 * package com.banregio.next.prueba.app.service;
 *

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.banregio.next.prueba.app.domain.entity.Ejemplo;
import com.banregio.next.prueba.app.exception.TestEjemploException;
import com.banregio.next.prueba.app.facade.EjemplosFacade;
import com.banregio.next.prueba.remoto.dto.CorreoPersona;
import com.banregio.next.prueba.remoto.dto.UsuarioSibamex;
import com.banregio.next.prueba.remoto.service.SibamexSoporteService;

import lombok.extern.log4j.Log4j2;

@Log4j2
class EjemplosServiceTest{
	
	@Mock
	private SibamexSoporteService usuariosService; 
	@Mock
	private EjemplosFacade facade;
	 
	@InjectMocks
	private EjemplosService ejemplosService;
	
	LocalDateTime dateTime;
	UsuarioSibamex usuarioSibamex;
	Ejemplo ejemplo;
	CorreoPersona correoPersona;

	 @BeforeEach
	 public void setup() {
		 dateTime = LocalDateTime.now();
		 log.info("Inicializando Mocks");
		 MockitoAnnotations.initMocks(this);
		 
		 usuarioSibamex = new UsuarioSibamex(){{
			  setNumero("10");
			  setClave("A2");
			  setStatus("Activo");
			  setActivo("true");
			  setEMail("prueba@banregio.com");
			  setNombre("Pedro Perez");
			 
		 }};
		 
        ejemplo = new Ejemplo() {{
       	 setId(1L);
      	  	 setFecha(new Date());
      	  	 setCampoString("campo1");
      	  	 setCampoEntero(123);
      	  	 setUsuario(usuarioSibamex);
      	  	 setCreatedBy("creadorPor");
      	  	 setCreatedDate(dateTime);
      	  	 setLastModifiedBy("usuario2");
      	  	 setLastModifiedDate(dateTime);
        }};
        
        correoPersona = new CorreoPersona() {{
       	 setIdPersona(1);
  		  	 setIdCliente(1);
  		     setTipoCorreo(1);
  		     setCorreo("pruebas@banregio.com");
  		     setStatus("Activo");
        }}; 
	 }
	 	  
    @Test
    @DisplayName("Test - FindAll")
    void testFindAll() {
        List<Ejemplo> ejemplos = Arrays.asList(ejemplo, ejemplo);

        // Configura el comportamiento del mock de la fachada (EjemplosFacade) para devolver los ejemplos ficticios
        when(facade.findAll()).thenReturn(ejemplos);
        
        // Llama al método bajo prueba
        List<Ejemplo> result = ejemplosService.findAll();

        // Verifica que el método de la fachada (EjemplosFacade) haya sido invocado una vez
        verify(facade, times(1)).findAll();

        // Verifica que el resultado coincida con los ejemplos ficticios
        assertEquals(ejemplos, result);
    }
	 
    @Test
    void testFindById() {
        Long id = 1L;

        // Configura el comportamiento del mock de la fachada (EjemplosFacade) para devolver el ejemplo ficticio
        when(facade.findById(id)).thenReturn(ejemplo);

        //usuariosService.consultaCorreos(correoPersona);
        // Llama al método bajo prueba
        Ejemplo result = ejemplosService.findById(id);

        // Verifica que el método de la fachada (EjemplosFacade) haya sido invocado una vez
        verify(facade, times(1)).findById(id);

        // Verifica que el método de usuariosService.consultaCorreos() haya sido invocado una vez
        verify(usuariosService, times(1)).consultaCorreos(Mockito.any(CorreoPersona.class));


        // Verifica que el resultado coincida con el ejemplo ficticio
        assertEquals(ejemplo, result);
    }
    
    @Test
    void testFindUsuario() {
        Long id = 1L;
        String brm = "123456";

        // Configura el comportamiento del mock de la fachada (EjemplosFacade) para devolver un ejemplo ficticio
        when(facade.findById(id)).thenReturn(ejemplo);

        // Configura el comportamiento del mock de usuariosService para devolver un usuario ficticio
        when(usuariosService.findByBrm(brm)).thenReturn(null);

        // Llama al método bajo prueba
        Ejemplo result = ejemplosService.findUsuario(id, brm);

        // Verifica que el método de la fachada (EjemplosFacade) haya sido invocado una vez
        verify(facade, times(1)).findById(id);

        // Verifica que el método de usuariosService.findByBrm() haya sido invocado una vez
        verify(usuariosService, times(1)).findByBrm(brm);

        // Verifica que el resultado coincida con el ejemplo ficticio
        assertEquals(ejemplo, result);
    }
    
    @Test
    void testFindUsuarioThrows() {
        Long id = 1L;
        String brm = "123456";

        // Configura el comportamiento del mock de la fachada (EjemplosFacade) para devolver un ejemplo ficticio
        when(facade.findById(id)).thenReturn(ejemplo);

        // Configura el comportamiento del mock de usuariosService para devolver un usuario ficticio
        when(usuariosService.findByBrm(brm)).thenReturn(usuarioSibamex);
    	
        // Verificar que se lance la excepción
        TestEjemploException exception = assertThrows(TestEjemploException.class, () -> {
            // Llamar al método que se espera que genere la excepción
        	ejemplosService.findUsuario(id, brm);
        });
    }
    
}
*/
