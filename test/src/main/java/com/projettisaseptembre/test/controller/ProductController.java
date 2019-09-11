package com.projettisaseptembre.test.controller;

import com.projettisaseptembre.test.dao.ProcuctDao;
import com.projettisaseptembre.test.exceptions.ProduitIntouvableException;
import com.projettisaseptembre.test.model.Product;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
@Api(value = "gestion des produits")
@RestController
public class ProductController {
    /***************************attributs***********************/
    @Autowired
    ProcuctDao procuctDao;
    /**************************méthodes***********************/
    @RequestMapping("/swagger")
    public String greeting() {
        return "redirect:/swagger-ui.html";
    }
    @GetMapping(value = "Produits")
    public List<Product> afficherListeProduits()
    {
        return procuctDao.findAll();
    }
    @GetMapping(value = "Produits/{id}")
    public Product afficherProduit(@PathVariable int id) throws ProduitIntouvableException {
        Product product=procuctDao.findById(id);
        if(product==null) throw new ProduitIntouvableException("le produit avec l'id "+id+" n'existe pas");
        return product;
    }
    @PostMapping(value = "Produits")
    public ResponseEntity<Void> enregitrer(@Valid @RequestBody  Product product)
    {
        Product product1=procuctDao.save(product);
        if (product1==null)
            return ResponseEntity.noContent().build();
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(product1.getId()).toUri();
        return ResponseEntity.created(location).build();
    }


}
