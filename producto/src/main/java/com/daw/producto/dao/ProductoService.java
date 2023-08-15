package com.daw.producto.dao;

import java.util.List;

import com.daw.producto.model.Producto;


public interface ProductoService {
	
	public List<Producto> listar ();
	public Producto buscar(int id);
	public void grabar(Producto model);
	public void eliminar (int id);
	
}
