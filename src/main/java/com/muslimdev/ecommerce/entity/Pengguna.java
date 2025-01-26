package com.muslimdev.ecommerce.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Pengguna implements Serializable {

    @Id
    private String id;
    private String nama;
    private String email;
    private String password;
    private String alamat;
    private String hp;
    private String roles;
    private Boolean isAktif;

}
