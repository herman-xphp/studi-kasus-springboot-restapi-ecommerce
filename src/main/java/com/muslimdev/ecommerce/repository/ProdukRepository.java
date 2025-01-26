package com.muslimdev.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.muslimdev.ecommerce.entity.Produk;

public interface ProdukRepository extends JpaRepository<Produk, String> {

}
