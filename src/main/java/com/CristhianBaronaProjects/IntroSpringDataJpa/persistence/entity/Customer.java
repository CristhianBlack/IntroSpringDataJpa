package com.CristhianBaronaProjects.IntroSpringDataJpa.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Cliente")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombre")
    private String name;

    @Column(unique= true)
    private String username;
    @Column(name = "contrasena")
    private String password;

    @OneToMany(targetEntity = Adress.class, cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "id_cliente")
    private List<Adress> adresses;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Adress> getAdresses() {
        return adresses;
    }

    public void setAdresses(List<Adress> adresses) {
        this.adresses = adresses;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
