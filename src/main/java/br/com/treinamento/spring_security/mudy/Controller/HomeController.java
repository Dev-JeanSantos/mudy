package br.com.treinamento.spring_security.mudy.Controller;

import br.com.treinamento.spring_security.mudy.Enum.StatusPedido;
import br.com.treinamento.spring_security.mudy.Modelo.Pedido;
import br.com.treinamento.spring_security.mudy.Repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping(value = "/home")
public class HomeController {

    @Autowired
    private PedidoRepository repository;

    @GetMapping()
    public String hello(Model model) {
        List<Pedido> pedidos = repository.findAll();
        model.addAttribute("pedidos", pedidos);
        return "home";
    }
    @GetMapping(value = "/{status}")
    public String porStatus(@PathVariable("status") String status, Model model) {
        List<Pedido> pedidos = repository.findByStatus(StatusPedido.valueOf(status.toUpperCase(Locale.ROOT)));
        model.addAttribute("pedidos", pedidos);
        model.addAttribute(status, status);
        return "home";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String onError(){
        return "redirect:/home";
    }
}
