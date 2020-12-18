package com.soaint.apirest.controlador;

import java.text.MessageFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.soaint.apirest.exception.ValidacionException;
import com.soaint.apirest.modelo.Cliente;
import com.soaint.apirest.servicio.ClienteService;
import com.soaint.apirest.util.Constante;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@CrossOrigin(origins="*")
@RestController
@RequestMapping(value="cliente")
public class ClienteController extends BaseController{
	
  Logger logger = LogManager.getLogger(ClienteController.class);
	
	@Autowired
	ClienteService clienteService;
	
	@PostMapping("/")
	public ResponseEntity<?> crearCliente(@RequestBody Cliente cliente){
		
		logger.info("===CREAR CLIENTE==== INICIO ====");
		if( cliente.getNombre() ==null ) {
	    	throw new ValidacionException(Constante.CODIGOS_ERRORES.CAMPOS_OBLIGATORIOS,MessageFormat.format(Constante.MENSAJE_ERRORES.CAMPOS_OBLIGATORIOS,"nombre"));	
		}
		
	    if( cliente.getApellido() ==null ) {
	    	throw new ValidacionException(Constante.CODIGOS_ERRORES.CAMPOS_OBLIGATORIOS,MessageFormat.format(Constante.MENSAJE_ERRORES.CAMPOS_OBLIGATORIOS,"apellido"));	
		}
	    
	    if( cliente.getDni() ==null ) {
	    	throw new ValidacionException(Constante.CODIGOS_ERRORES.CAMPOS_OBLIGATORIOS,MessageFormat.format(Constante.MENSAJE_ERRORES.CAMPOS_OBLIGATORIOS,"apellido"));	
		}
	    
	    if( cliente.getTelefono() ==null ) {
	    	throw new ValidacionException(Constante.CODIGOS_ERRORES.CAMPOS_OBLIGATORIOS,MessageFormat.format(Constante.MENSAJE_ERRORES.CAMPOS_OBLIGATORIOS,"telefono"));	
		}
	    
	    if( cliente.getEmail() ==null ) {
	    	throw new ValidacionException(Constante.CODIGOS_ERRORES.CAMPOS_OBLIGATORIOS,MessageFormat.format(Constante.MENSAJE_ERRORES.CAMPOS_OBLIGATORIOS,"email"));	
		}
		
		
		
		Cliente clienteNuevo = clienteService.guardarCliente(cliente);
		logger.info("===CREAR CLIENTE==== FIN ====");
		return ResponseEntity.status(HttpStatus.OK).body(clienteNuevo);
	}

}
