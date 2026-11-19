/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package agendatelefonica;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import dao.ContatoDAO;
import model.Contato;

/**
 *
 * @author rpdop
 */
public class AgendaTelefonica {

  public static void main(String[] args) {
    java.awt.EventQueue.invokeLater(() -> {
        new view.TelaPrincipal().setVisible(true);
    });
}

}
