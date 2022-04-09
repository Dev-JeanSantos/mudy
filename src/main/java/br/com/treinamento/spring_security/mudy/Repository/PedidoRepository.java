package br.com.treinamento.spring_security.mudy.Repository;

import br.com.treinamento.spring_security.mudy.Enum.StatusPedido;
import br.com.treinamento.spring_security.mudy.Modelo.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findByStatus(StatusPedido status);
}
