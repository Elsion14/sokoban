package graphique;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.Image.*;
import java.awt.event.*;
import java.util.*;
import sokoban.*;
import java.io.*;

public class Login extends JFrame {

  private JList<String> list;
  private JTextField textRegister;

  public Login () {

    this.setTitle("Login");

    JPanel zoneLogin = new JPanel();
    JPanel zoneRegister = new JPanel();

    Vector<String> vect = new Vector<>();
    String[] players = new File("save/players").list();
    for (String s : players){
      vect.add(s.split("\\.")[0]);
    }
    this.list = new JList<>(vect);
    this.list.setPreferredSize(new Dimension(150,200));
    this.list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    this.list.setSelectedIndex(0);

    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setViewportView(this.list);

    JButton bLogin = new JButton("Login");
    bLogin.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) {
        Login.this.dispose();
        new Menu(Login.this.list.getSelectedValue());
      }
    });
    JButton bRegister = new JButton("Register");
    bRegister.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) {
        String newPlayer = Login.this.textRegister.getText();
        Login.this.dispose();
        new Menu(newPlayer);
      }
    });

    this.textRegister = new JTextField();
    this.textRegister.setHorizontalAlignment(JTextField.CENTER);
    this.textRegister.setPreferredSize(new Dimension(150,25));

    zoneLogin.setLayout(new GridBagLayout());
    GridBagConstraints gcg = new GridBagConstraints();

    gcg.gridx = 0;
    gcg.gridy = 0;
    zoneLogin.add(scrollPane,gcg);
    gcg.gridy = 1;
    zoneLogin.add(bLogin,gcg);

    zoneRegister.setLayout(new GridBagLayout());
    GridBagConstraints gcd = new GridBagConstraints();

    gcd.gridx = 0;
    gcd.gridy = 0;
    zoneRegister.add(this.textRegister,gcd);
    gcd.gridy = 1;
    zoneRegister.add(bRegister,gcd);

    this.setLayout(new GridLayout(1,2));
    this.add(zoneLogin);
    this.add(zoneRegister);

    pack();
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);

  }

}