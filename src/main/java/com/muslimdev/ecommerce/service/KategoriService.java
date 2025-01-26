package com.muslimdev.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muslimdev.ecommerce.entity.Kategori;
import com.muslimdev.ecommerce.exception.ResourceNotFoundException;
import com.muslimdev.ecommerce.repository.KategoriRepository;

@Service
public class KategoriService {

    @Autowired
    private KategoriRepository kategoriRepository;

    public Kategori findById(String id) {
        return kategoriRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Kategori dengan id " + id + " tidak ditemukan."));
    }

    public List<Kategori> findAll() {
        return kategoriRepository.findAll();
    }
}
