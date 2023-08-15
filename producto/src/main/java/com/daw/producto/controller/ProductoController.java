package com.daw.producto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.daw.producto.dao.ProductoService;
import com.daw.producto.model.Producto;

@Controller
public class ProductoController {

	@Autowired
	private ProductoService productoService ;
	
	
	@GetMapping("/")
	private String listaProducto (Model model) {
		
		List<Producto> lista = productoService.listar();
		
		model.addAttribute("listaProducto",lista);
		
		return "index";
	}
	
	@GetMapping("/agregar")
	private String agregarProducto (Model model) {
		
		model.addAttribute("producto",new Producto());
		
		return "guardarProducto";
	}
	
	@GetMapping("/actualizarProducto{id}")
	private String actualizarProdcuto (@PathVariable(name="id") int id,Model model) {
		
		Producto producto= productoService.buscar(id);
		
		model.addAttribute("producto", producto);
		
		return "guardarProducto";
	}
	
	@GetMapping("/eliminarProducto{id}")
	private String eliminarProdcuto (@PathVariable(name="id") int id,Model model,
			RedirectAttributes flash) {
		
		productoService.eliminar(id);
		flash.addFlashAttribute("mensaje","producto " + id + " eliminado correctamente");
		
		return "redirect:/";
	}
	
	@PostMapping("/guardar")
	private String agregarProducto (@ModelAttribute("producto") Producto producto ,Model model) {
		
		String mensaje ="";
		productoService.grabar(producto);
		mensaje = "Se guardó " + producto.getNombre() + " correctamente";
		model.addAttribute("mensaje", mensaje);
		
		return "guardarProducto";
	}
	
	
	
	
}
