package com.projettisaseptembre.test.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
//@JsonIgnoreProperties(value = {"nom","prix"})
public class Product {
    /***********************attributs******************************/
    @Id
    @GeneratedValue
    private int id;
    @Length(min=3,max=20)
    private String nom;
    private int prix;
    /***********************méthodes********************************/

    //constructeur avec paramètre
    public Product(int id, String nom, int prix) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
    }
    //constructeur sans paramètre
    public Product() {
    }
    //toString
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prix=" + prix +
                '}';
    }
    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
}
