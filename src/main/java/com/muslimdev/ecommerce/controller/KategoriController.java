package com.muslimdev.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muslimdev.ecommerce.entity.Kategori;
import com.muslimdev.ecommerce.service.KategoriService;

@RestController
@RequestMapping(path = "/api")
public class KategoriController {

    @Autowired
    private KategoriService kategoriService;

    @GetMapping("/kategoris")
    public List<Kategori> findAll() {
        return kategoriService.findAll();
    }
}
