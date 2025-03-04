package com.muslimdev.ecommerce.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Kategori implements Serializable {

    @Id
    private String id;
    private String nama;
}
