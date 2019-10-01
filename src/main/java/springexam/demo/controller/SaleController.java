package springexam.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springexam.demo.entity.Product;
import springexam.demo.entity.Sale;
import springexam.demo.service.ProductService;
import springexam.demo.service.SaleService;

@Controller
@RequestMapping(value = "product")
public class SaleController {
    @Autowired
    SaleService saleService;

    @Autowired
    ProductService productService;

    @RequestMapping(method = RequestMethod.GET, value = "/detail")
    public String get(Model model) {
        Sale sale = saleService.getSaleById(1);
        model.addAttribute("sale", sale);
        model.addAttribute("product", sale.getProduct());
        return "detail";
    }


    @RequestMapping(method = RequestMethod.GET, value = "/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "form";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public String store(Product product) {
        Sale sale = saleService.getSaleById(1);
        product.setSale(sale);
        sale.setProduct(product);
        productService.saveProduct(product);
        return "detail";
    }
}
