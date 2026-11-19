/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author rpdop
 */
public class Contato {
    private int id;
    private String nome;
    private String telefone;
    private String email;
    private String categoria;
    
    public Contato(){}

    public Contato (int id ,String nome, String telefone, String email, String categoria) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    
}
