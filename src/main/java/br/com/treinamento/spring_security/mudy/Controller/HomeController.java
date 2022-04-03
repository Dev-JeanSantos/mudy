package br.com.treinamento.spring_security.mudy.Controller;

import br.com.treinamento.spring_security.mudy.Modelo.Pedido;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @PersistenceContext
    private EntityManager manager;

    @GetMapping(value = "/home")
    public String hello(Model model) {
        Query query = manager.createQuery("SELECT p FROM Pedido p", Pedido.class);
        List<Pedido> pedidos = query.getResultList();
        model.addAttribute("pedidos", pedidos);
        return "home";
    }
}
