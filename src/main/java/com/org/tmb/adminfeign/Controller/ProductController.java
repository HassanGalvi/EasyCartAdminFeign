//package com.org.tmb.adminfeign.Controller;
//
//import com.org.tmb.adminfeign.model.Product;
//import com.org.tmb.adminfeign.feign.FeignInterface;
//import org.springframework.web.bind.annotation.*;
//
//import javax.annotation.Resource;
//import java.util.List;
//
//@RestController
//public class ProductController {
//    @Resource
//    private FeignInterface feignInterface;
//
//    @GetMapping("/getAll")
//    public List<Product> getAll() {
//        return feignInterface.getAll();
//    }
//
//    @GetMapping("/getProducts")
//    public List<Product> getProducts() {
//        return feignInterface.getProducts();
//    }
//
//    @GetMapping("/getCategories")
//    public List<Product> getCategories() {
//        return feignInterface.getCategories();
//    }
//
//    @RequestMapping(value = "/insertProduct", method = RequestMethod.POST)
//    public int insertProduct(@RequestBody Product product) {
//        return feignInterface.insertProduct(product);
//    }
//
//    @RequestMapping(value = "/updateProduct", method = RequestMethod.PUT)
//    public int updateProduct(@RequestBody Product product) {
//        return feignInterface.updateProduct(product);
//    }
//
////    @RequestMapping(value = "/deleteProduct", method = RequestMethod.DELETE)
////    public int deleteProduct(@RequestBody Product product) {
////        return feignInterface.deleteProduct(product);
////    }
//
//}
//
//
