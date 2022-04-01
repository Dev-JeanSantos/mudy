package br.com.treinamento.spring_security.mudy.Controller;

import br.com.treinamento.spring_security.mudy.Modelo.Pedido;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping(value = "/home")
    public String hello(Model model) {
        Pedido pedido = new Pedido();
        pedido.setNomeProduto("Console PlayStation 4 1TB Bundle Hits 9" +
                " - GTA V, Death Stranding, The Last Of Us - PlayStation 4");
        //pedido.setValorNegociado(4999.00);
        pedido.setUrlImagem("https://m.media-amazon.com/images/I/81f+53WaIPL._AC_UL480_QL65_.jpg");
        pedido.setUrlProduto("https://www.amazon.com.br/Console-PlayStation-1TB-Bundle-Hits/dp/B08458VCZ1/ref=lp_16253334011_1_2?ufe=app_do%3Aamzn1.fos.25548f35-0de7-44b3-b28e-0f56f3f96147");
        pedido.setDescricao("Combina conteúdo sem igual, experiências de jogos imersivas, todos os seus aplicativos favoritos de entretenimento digital e recursos exclusivos do playstation");

        List<Pedido> pedidos = Arrays.asList(pedido);
        model.addAttribute("pedidos", pedidos);
        return "home";
    }
}
