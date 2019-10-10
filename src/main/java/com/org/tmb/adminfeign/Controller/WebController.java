package com.org.tmb.adminfeign.Controller;

import com.org.tmb.adminfeign.model.Product;
import com.org.tmb.adminfeign.feign.FeignInterface;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


@Controller
public class WebController {
    @Resource
    private FeignInterface feignInterface;
    @GetMapping("/index")
    public String home(Product product){
        return "index";
    }
    @GetMapping("/Products")
    public String bags(ModelMap Map, Model model){
        List<Product> products = feignInterface.getProducts();
        Map.addAttribute("products",products);
//        Map.addAttribute("repository",feignInterface);

        model.addAttribute("product", new Product());
        return "Products";
    }

        @GetMapping("/Add")
      public String forms(Product product){
            return "Add";
    }
    @PostMapping("/Add")
    public String Add(Product product){
        feignInterface.insertProduct(product);
        System.out.println(product.getProduct_name());
        return "redirect:/Products";
    }
    @PostMapping("/update")
    public String update(@RequestParam(name="id" , required=false) int id,String image,Integer price,String name, String description, int total, int stock, ModelMap modelmap,Model model){
//        System.out.println(image);
//        System.out.println("it is price :"+price);
        List<Product> select = Arrays.asList( new Product(id,image,price,name,description,total,stock));
//        model.addAttribute("product", select);
//       modelmap.addAttribute("selected",select);
        return "redirect:/Add";
    }

//    @PostMapping("/single")
//    public String showMethod(@RequestParam(name="image" , required=false) String image, Integer price, String name, ModelMap modelmap)
//    {
//
//        System.out.println(image);
//        List<Product> select = Arrays.asList( new Product( name , 1, image
//                , 01, price,"slim fit"   ));
//
//        modelmap.addAttribute("selected",select);
//
//        return "single";
//    }


}
