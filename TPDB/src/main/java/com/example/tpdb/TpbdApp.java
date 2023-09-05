package com.example.tpdb;

import com.example.tpdb.Entidades.*;
import com.example.tpdb.Entidades.Usuario;
import com.example.tpdb.Repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TpbdApp {
	public static void main(String[] args) {
		SpringApplication.run(TpbdApp.class, args);
	}
	@Autowired
	UsuarioR usuarioRepository;
	@Autowired
	PedidoR pedidoRepository;
	@Autowired
	FacturaR facturaRepository;
	@Autowired
	DetallePedidoR detallePedidoRepository;
	@Autowired
	DomicilioR domicilioRepository;
	@Autowired
	ClienteR clienteRepository;
	@Autowired
	ProductoR productoRepository;
	@Autowired
	RubroR rubroRepository;
	@Bean
	public CommandLineRunner demo(){
		return (args) -> {
			// Crear y guardar ejemplos de datos en las entidades

			// Ejemplo de Usuario
			Usuario usuario = new Usuario();
			usuario.setNombre("usuario1");
			usuario.setPassword("password1");
			usuario.setRol("rol1");
			usuarioRepository.save(usuario);

			// Ejemplo de Pedido
			Pedido pedido = new Pedido();
			pedido.setFecha("2023-09-05");
			pedido.setEstado("En proceso");
			pedido.setHoraEstimadaDeEntrega("14:00");
			pedido.setTipoEnvio("Delivery");
			pedido.setTotal(25.0);
			pedido.setUsuario(usuario); // Asociar el pedido con el usuario
			pedidoRepository.save(pedido);

			// Continúa creando y guardando datos en las otras entidades

			// Ejemplo de Producto
			Rubro rubro = new Rubro();
			rubro.setDenominacion("Alimentos");
			rubroRepository.save(rubro);

			Producto producto = new Producto();
			producto.setTipo("Comida");
			producto.setTiempoEstimadoCocina(30);
			producto.setDenominacion("Pizza");
			producto.setPrecioVenta(10.0);
			producto.setPrecioCompra(5.0);
			producto.setStockActual(50);
			producto.setStockMinimo(10);
			producto.setUnidadMedida("unidad");
			producto.setRubro(rubro); // Asociar el producto con el rubro
			productoRepository.save(producto);
		};
	}
}
