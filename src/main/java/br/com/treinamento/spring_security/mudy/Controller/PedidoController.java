package br.com.treinamento.spring_security.mudy.Controller;

import br.com.treinamento.spring_security.mudy.Modelo.Pedido;
import br.com.treinamento.spring_security.mudy.Repository.PedidoRepository;
import br.com.treinamento.spring_security.mudy.dto.PedidoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "pedido")
public class PedidoController {

    @Autowired
    private PedidoRepository repository;

    @GetMapping(value = "formulario")
    public String formulario(PedidoRequest request)
    {
        return "pedidos/formulario";
    }

    @PostMapping(value = "novo")
    public String novo(@Valid PedidoRequest request, BindingResult result) {

        if(result.hasErrors()){
            return "pedidos/formulario";
        }

        Pedido pedido = request.toPedido();
        repository.save(pedido);
        return "redirect:/home";
    }
}
