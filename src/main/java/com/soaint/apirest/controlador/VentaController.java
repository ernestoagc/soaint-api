package com.soaint.apirest.controlador;

import java.text.MessageFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.soaint.apirest.exception.BaseException;
import com.soaint.apirest.exception.ValidacionException;
import com.soaint.apirest.modelo.Cliente;
import com.soaint.apirest.modelo.Venta;
import com.soaint.apirest.modelo.VentaDetalle;
import com.soaint.apirest.servicio.ClienteService;
import com.soaint.apirest.servicio.VentaService;
import com.soaint.apirest.util.Constante;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@CrossOrigin(origins="*")
@RestController
@RequestMapping(value="venta")
public class VentaController extends BaseController {
	
	Logger logger = LogManager.getLogger(ClienteController.class);
	
	@Autowired
	VentaService ventaService;
	
	@Autowired
	ClienteService clienteService;
	
	@PostMapping("/")
	public ResponseEntity<?> crearVenta(@RequestBody Venta venta)  throws ValidacionException,Exception{
		
		logger.info("===CREAR VENTA==== INICIO ====");
		if(venta.getCliente()==null) {
			
			throw new ValidacionException(Constante.CODIGOS_ERRORES.CAMPOS_OBLIGATORIOS,MessageFormat.format(Constante.MENSAJE_ERRORES.CAMPOS_OBLIGATORIOS,"cliente")  );
		}
		
		
		if(venta.getVentaDetalles()==null || venta.getVentaDetalles().size()==0) {
			
			throw new ValidacionException(Constante.CODIGOS_ERRORES.CAMPOS_OBLIGATORIOS,MessageFormat.format(Constante.MENSAJE_ERRORES.CAMPOS_OBLIGATORIOS,"venta"));
		}
		
		Cliente cliente = clienteService.obtenerCliente(venta.getCliente().getId());
		
		if(cliente==null) {
			
			throw new ValidacionException(Constante.CODIGOS_ERRORES.BAD_REQUEST,"El cliente ingresado no existe");
		}
		
		
		Venta ventaNuevo = ventaService.guardarVenta(venta);
		logger.info("===CREAR VENTA==== INICIO ====");
		
		return ResponseEntity.status(HttpStatus.OK).body(ventaNuevo);
	}
	
	@GetMapping("/{id}")	
	@ResponseBody
	public ResponseEntity<?> obtener(@PathVariable Long id) throws ValidacionException,Exception{

		logger.info("===OBTENER VENTA==== INICIO ====");		
		Venta venta =ventaService.obtenerVenta(id);
		
		if(venta==null) {
			throw new ValidacionException(Constante.CODIGOS_ERRORES.NO_DEVOLVIO_RESULTADO_OK, new Object[]{});
		}
		
		logger.info("===OBTENER VENTA==== INICIO ====");	
		return ResponseEntity.status(HttpStatus.OK).body(venta);
	}
	
}
