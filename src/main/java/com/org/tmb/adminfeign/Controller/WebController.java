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
    public String index() {


        return "index";
    }


    @GetMapping("/Products")
    public String bags(ModelMap Map, Model model) {
        List<Product> products = feignInterface.getProducts();
        Map.addAttribute("products", products);
//        Map.addAttribute("repository",feignInterface);


        return "Products";
    }


    @GetMapping("/Add")
    public String forms(Model model) {

        model.addAttribute("product",new Product());
        return "Add";
    }




        @PostMapping("/update")
    public String abc(@RequestParam(name="image" , required=false) String image,int id,int parent_id,Integer price,String name, String description, int total, int stock, ModelMap modelmap,Model model){

        List<Product> product = Arrays.asList(
        new Product(id,name,description,image,stock,total,parent_id,0,0,0,price)
        );

          modelmap.addAttribute("pro",product);
         return "update";
   }
    @PostMapping("/Add")
    public String Add(Product product) {
        feignInterface.insertProduct(product);
        System.out.println(product.getProduct_name());
        return "redirect:/Products";
    }
    @PostMapping("/updateProduct")
    public String updateProduct(Product product) {
        System.out.println("this is update");
         feignInterface.updateProduct(product);
return "redirect:/Products";
    }

    @GetMapping("/update")
    public String update() {
        return "update";
    }
}


//    @GetMapping("/update")
//    public String update(@RequestParam(name="id" , required=false) int id,String image,Integer price,String name, String description, int total, int stock, ModelMap modelmap,Model model){
////        System.out.println(image);
//        System.out.println("it is price :"+price);
//        List<Product> product = Arrays.asList( new Product(id,image,price,name,description,total,stock));
//
////        model.addAttribute("product", select);
//        modelmap.addAttribute("product",product);
////        feignInterface.updateProduct(product);
//        return "update";
//
//    }
