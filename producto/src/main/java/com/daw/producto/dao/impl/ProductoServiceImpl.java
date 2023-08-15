package com.daw.producto.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.daw.producto.dao.ProductoService;
import com.daw.producto.model.Producto;
import com.daw.producto.repository.ProductoRepository;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class ProductoServiceImpl implements ProductoService {

	
	private ProductoRepository productoRepository ;
	
	@Override
	public List<Producto> listar() {
		return productoRepository.findAll();
	}

	@Override
	public Producto buscar(int id) {
		return productoRepository.findById(id).get();
	}

	@Override
	public void grabar(Producto model) {
		productoRepository.save(model);
	}

	@Override
	public void eliminar(int id) {
		productoRepository.deleteById(id);
	}
	
}
