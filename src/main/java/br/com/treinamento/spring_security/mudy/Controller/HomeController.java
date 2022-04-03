package br.com.treinamento.spring_security.mudy.Controller;

import br.com.treinamento.spring_security.mudy.Modelo.Pedido;
import br.com.treinamento.spring_security.mudy.Repository.HomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private HomeRepository repository;

    @GetMapping(value = "/home")
    public String hello(Model model) {
        List<Pedido> pedidos = repository.findAll();
        model.addAttribute("pedidos", pedidos);
        return "home";
    }
}
