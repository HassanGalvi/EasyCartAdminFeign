package com.org.tmb.adminfeign.feign;

import com.org.tmb.adminfeign.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "PRODUCTSERVICE")
public interface FeignInterface {

    @RequestMapping(value = "/getAll" , method = RequestMethod.GET)
    List<Product> getAll();

    @RequestMapping(value = "/getProducts" , method = RequestMethod.GET)
    List<Product> getProducts();

    @RequestMapping(value = "/getCategories" , method = RequestMethod.GET)
    List<Product> getCategories();

    @RequestMapping(value = "/insertProduct" , method = RequestMethod.POST)
    int insertProduct(Product product);

    @RequestMapping(value = "/updateProduct" , method = RequestMethod.PUT)
    int updateProduct(Product product);

}
