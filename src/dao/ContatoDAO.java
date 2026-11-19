/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexao.Conexao;
import model.Contato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class ContatoDAO {

    public void cadastrar(Contato c) throws SQLException {
        String sql = "INSERT INTO contatos (nome, telefone, email, categoria) VALUES (?, ?, ?, ?)";

        try (Connection con = Conexao.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, c.getNome());
            ps.setString(2, c.getTelefone());
            ps.setString(3, c.getEmail());
            ps.setString(4, c.getCategoria());
            ps.executeUpdate();
        }
    }

    public List<Contato> listar() throws SQLException {
        List<Contato> lista = new ArrayList<>();
        String sql = "select * from contatos";  // SELECT

        try (Connection con = Conexao.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Contato c = new Contato();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setTelefone(rs.getString("telefone"));
                c.setEmail(rs.getString("email"));
                c.setCategoria(rs.getString("categoria"));
                lista.add(c);
            }
        }
        return lista;
    }

    public List<Contato> pesquisar(String nome) throws SQLException {
        List<Contato> lista = new ArrayList<>();
        String sql = "SELECT * FROM contatos WHERE nome LIKE ?";  // SELECT com LIKE ?

        try (Connection con = Conexao.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, "%" + nome + "%");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Contato c = new Contato();
                    c.setId(rs.getInt("id"));
                    c.setNome(rs.getString("nome"));
                    c.setTelefone(rs.getString("telefone"));
                    c.setEmail(rs.getString("email"));
                    c.setCategoria(rs.getString("categoria"));
                    lista.add(c);
                }
            }
        }
        return lista;
    }

    public void atualizar(Contato c) throws SQLException {
        String sql = "UPDATE contatos SET nome = ?, telefone = ?, email = ?, categoria = ?  WHERE id = ?";  // UPDATE

        try (Connection con = Conexao.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, c.getNome());
            ps.setString(2, c.getTelefone());
            ps.setString(3, c.getEmail());
            ps.setString(4, c.getCategoria());
            ps.setInt(5, c.getId());
            ps.executeUpdate();
        }
    }

    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM contatos WHERE id = ?";  // UPDATE
        try (Connection con = Conexao.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

}
