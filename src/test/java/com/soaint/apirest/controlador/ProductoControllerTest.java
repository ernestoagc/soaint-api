package com.soaint.apirest.controlador;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.ByteStreams;
import com.soaint.apirest.modelo.Producto;
import com.soaint.apirest.servicio.ProductoService;

import org.springframework.test.web.servlet.MockMvc;
 
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
 

@WebMvcTest(ProductoController.class)
class ProductoControllerTest {
	
	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
	
	@MockBean
	ProductoService productoService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testEliminarProductoNoExiste() throws Exception {
		ObjectMapper objectMapper = getObjectMapper();	
		
		Mockito.when(productoService.obtenerProducto(1L)).thenReturn(null);		
		String uri="/producto/5";
		mockMvc.perform(delete(uri)).andExpect(status().isBadRequest());
	}
	
	@Test
	public void testModificarProductoNoExiste() throws Exception {
		ObjectMapper objectMapper = getObjectMapper();	
		
		Mockito.when(productoService.obtenerProducto(1L)).thenReturn(null);		
		String uri="/producto/5";
		mockMvc.perform(put(uri) .contentType(APPLICATION_JSON_UTF8).
				content("{ \"nombre\": \"pelota\", \"precio\":8.5}")).andExpect(status().isBadRequest());
	}
	
	@Test
	public void testCrearProductoCampoObligatorio() throws Exception {
		ObjectMapper objectMapper = getObjectMapper();	
		
		
	  Producto productoDb=	objectMapper.readValue("{\r\n" + 
				"    \"id\": 2,\r\n" + 
				"    \"nombre\": \"televisor\",\r\n" + 
				"    \"precio\": 0.0\r\n" + 
				"}",Producto.class); 
		
		Mockito.when(productoService.obtenerProducto(1L)).thenReturn( productoDb );		
		String uri="/producto/";
		mockMvc.perform(post(uri) .contentType(APPLICATION_JSON_UTF8).
				content("{\"precio\":15.0}")).andExpect(status().isBadRequest());
	}
 

	protected ObjectMapper getObjectMapper()
	  {

		ObjectMapper objectMapper = new ObjectMapper();
	    DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
	    objectMapper.setDateFormat(df);
	    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	    objectMapper.setSerializationInclusion(Include.NON_NULL);
	    return objectMapper;
	  }
	

	public String getJSON(String nameFile){
		try{
			InputStream is = new FileInputStream(new File("src/test/resources/"+nameFile));
			byte[] filedata = ByteStreams.toByteArray(is);
			String json = new String(filedata);
			return json;
		}catch (Exception e) {
			 
		}
		return null;
	}
	

}
