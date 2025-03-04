package com.muslimdev.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muslimdev.ecommerce.entity.Kategori;
import com.muslimdev.ecommerce.service.KategoriService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping(path = "/api")
public class KategoriController {

    @Autowired
    private KategoriService kategoriService;

    @GetMapping("/kategoris")
    public List<Kategori> findAll() {
        return kategoriService.findAll();
    }

    @GetMapping("/kategoris/{id}")
    public Kategori findById(@PathVariable("id") String id) {
        return kategoriService.findById(id);
    }

    @PostMapping("/kategoris")
    public Kategori create(@RequestBody Kategori kategori) {
        return kategoriService.create(kategori);
    }

    @PutMapping("/kategoris")
    public Kategori edit(@RequestBody Kategori kategori) {
        return kategoriService.edit(kategori);
    }

    @DeleteMapping("/kategoris/{id}")
    public void deleteById(@PathVariable("id") String id) {
        kategoriService.deleteById(id);
    }
}
