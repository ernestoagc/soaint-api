package com.soaint.apirest.controlador;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.soaint.apirest.modelo.Producto;
import com.soaint.apirest.servicio.ProductoService;
import com.soaint.apirest.util.Constante;

@CrossOrigin(origins="*")
@RestController
@RequestMapping(value="producto")
public class ProductoController extends BaseController{
	Logger logger = LogManager.getLogger(ProductoController.class);
	
	@Autowired
	ProductoService productoService;
	
	@GetMapping("/listar")	
	@ResponseBody
	public ResponseEntity<?> listar(@RequestParam Map<String,String> parametros) {

		logger.info("===LISTAR PRODUCTO==== INICIO ====");	   		
		List<Producto> productos =productoService.listarProductos();
		
		if(productos.size()==0) {
			throw new ValidacionException(Constante.CODIGOS_ERRORES.NO_DEVOLVIO_RESULTADO_OK, new Object[]{});
		}
		
		logger.info("===LISTAR PRODUCTO==== FIN ====");
		return ResponseEntity.status(HttpStatus.OK).body(productos);
	}
	
	
	@GetMapping("/{id}")	
	@ResponseBody
	public ResponseEntity<?> obtener(@PathVariable Long id) throws Exception{

		logger.info("===OBTENER PRODUCTO==== INICIO ====");	   		
		Producto producto =productoService.obtenerProducto(id);
		
		if(producto==null) {
			throw new ValidacionException(Constante.CODIGOS_ERRORES.NO_DEVOLVIO_RESULTADO_OK, new Object[]{});			
		}
		
		logger.info("===OBTENER PRODUCTO==== FIN ====");
		return ResponseEntity.status(HttpStatus.OK).body(producto);
	}
	
	@PostMapping("/")
	public ResponseEntity<?> crearProducto(@RequestBody Producto producto){
		
		logger.info("===CREAR PRODUCTO==== INICIO ====");	   		
		
		if(producto.getNombre()==null)  {
			
			throw new ValidacionException(Constante.CODIGOS_ERRORES.CAMPOS_OBLIGATORIOS,MessageFormat.format(Constante.MENSAJE_ERRORES.CAMPOS_OBLIGATORIOS,"nombre"));
		}
		
		Producto productoNuevo = productoService.guardarProducto(producto);
		logger.info("===CREAR PRODUCTO==== FIN ====");
		return ResponseEntity.status(HttpStatus.OK).body(producto);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> modificarProducto(@PathVariable Long id,@RequestBody Producto producto){
		
		logger.info("===ACTUALIZAR PRODUCTO==== INICIO ====");	
		Producto productoRepositorio = productoService.obtenerProducto(id);
		
		if(productoRepositorio==null) {
			
			throw new ValidacionException(Constante.CODIGOS_ERRORES.BAD_REQUEST,"El producto ingresado no existe");
		}

		
		productoRepositorio.setNombre(producto.getNombre());
		productoRepositorio.setPrecio(producto.getPrecio());
		
		productoService.guardarProducto(productoRepositorio);
		logger.info("===ACTUALIZAR PRODUCTO==== FIN ====");
		return ResponseEntity.status(HttpStatus.OK).body(productoRepositorio);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarProducto(@PathVariable long id) 
	{
		logger.info("===ELIMINAR PRODUCTO==== INICIO ====");
		Producto productoRepositorio = productoService.obtenerProducto(id);
		
		if(productoRepositorio==null) {
			
			throw new ValidacionException(Constante.CODIGOS_ERRORES.BAD_REQUEST,"El producto ingresado no existe");
		}
		
		productoService.eliminarProducto(productoRepositorio.getId());
		logger.info("===ELIMINAR PRODUCTO==== INICIO ====");
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	
}
