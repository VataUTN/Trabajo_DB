package com.example.ejer03;

import com.example.ejer03.entities.*;
import com.example.ejer03.repositories.*;
import com.example.ejer03.utils.Estado;
import com.example.ejer03.utils.FormaPago;
import com.example.ejer03.utils.Tipo;
import com.example.ejer03.utils.TipoEnvio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

@SpringBootApplication
public class Ejer03Application {

    @Autowired
    private ClienteRepository ClienteRepository;

    @Autowired
    private UsuarioRepository UsuarioRepository;

    @Autowired
    private PedidoRepository PedidoRepository;

    @Autowired
    private DetallePedidoRepository DetallePedidoRepository;

    @Autowired
    private RubroRepository RubroRepository;

    @Autowired
    private ProductoRepository ProductoRepository;

    @Autowired
    private FacturaRepository FacturaRepository;

    @Autowired
    private DomicilioRepository DomicilioRepository;

    public static void main(String[] args) {
        SpringApplication.run(Ejer03Application.class, args);
    }

    @Bean
    CommandLineRunner demo() {
        return args -> {
            try {

                Factura factura = Factura.builder()
                        .numero(0012)
                        .descuento(0.20)
                        .total(500)
                        .fecha(LocalDateTime.now().toString())
                        .formaPago(FormaPago.EFECTIVO)
                        .build();
                FacturaRepository.save(factura);

                Producto producto = Producto.builder()
                        .denominacion("Pizza")
                        .precioVenta(1500.9)
                        .precioCompra(1000.0)
                        .foto("imagen.png")
                        .receta("Ingredientes: [Masa, Salsa, Queso, Jamón]")
                        .stockActual(20)
                        .stockMinimo(1)
                        .tiempoEstimadoCocina(20)
                        .tipo(Tipo.MANUFACTURADO)
                        .unidadMedida("gr")
                        .build();
                ProductoRepository.save(producto);

                DetallePedido detallePedido = DetallePedido.builder()
                        .producto(producto)
                        .cantidad(1)
                        .subtotal(1500.9)
                        .build();
                DetallePedidoRepository.save(detallePedido);

                Rubro rubro = Rubro.builder()
                        .denominacion("Gastronomico")
                        .productos(new ArrayList<>())
                        .build();
                rubro.getProductos().add(producto);
                RubroRepository.save(rubro);

                Pedido pedido = Pedido.builder()
                        .fecha(LocalDate.now().toString())
                        .total(1200.32)
                        .tipoEnvio(TipoEnvio.DELIVERY)
                        .estado(Estado.PREPARADO)
                        .horaEstimadaEntrega("22:45")
                        .factura(factura)
                        .detallesPedidos(new ArrayList<>())
                        .build();
                pedido.getDetallesPedidos().add(detallePedido);
                PedidoRepository.save(pedido);

                Usuario usuario = Usuario.builder()
                        .nombre("Marco")
                        .pedidos(new ArrayList<>())
                        .rol("usuario")
                        .password("Marco123")
                        .build();
                usuario.getPedidos().add(pedido);
                UsuarioRepository.save(usuario);

                Cliente cliente = Cliente.builder()
                        .nombre("Marco")
                        .apellido("Vieri")
                        .email("MarcoVieri@gmail.com")
                        .telefono("2616103045")
                        .pedidos(new ArrayList<>())
                        .build();
                ClienteRepository.save(cliente);

                Domicilio domicilio = Domicilio.builder()
                        .calle("West Eclipse Boulevard")
                        .localidad("Vinewood Oeste")
                        .numero("103")
                        .pedidos(new ArrayList<>())
                        .cliente(cliente)
                        .build();
                domicilio.getPedidos().add(pedido);
                DomicilioRepository.save(domicilio);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        };
    }
}