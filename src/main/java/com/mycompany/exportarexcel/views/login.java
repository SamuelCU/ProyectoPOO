package com.mycompany.exportarexcel.views;

import com.mycompany.exportarexcel.principal;

import javax.swing.*;
import java.security.Principal;

public class login extends javax.swing.JFrame {

    // Agrega los componentes necesarios para el formulario de inicio de sesión

    public login() {
        initComponents();
    }

    private void initComponents() {
        // Inicializa los componentes del formulario de inicio de sesión

        // Agrega un JMenu para el inicio de sesión
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menuInicio = new JMenu("Inicio");
        menuBar.add(menuInicio);

        JMenuItem menuItemLogin = new JMenuItem("Iniciar Sesión");
        menuItemLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                realizarInicioSesion();
            }
        });
        menuInicio.add(menuItemLogin);
    }

    private void realizarInicioSesion() {
        // Lógica para verificar el inicio de sesión (similar a lo que hicimos en la clase principal)
        String usuario = JOptionPane.showInputDialog(this, "Ingrese usuario:");
        String contrasena = JOptionPane.showInputDialog(this, "Ingrese contraseña:");

        if (iniciarSesion(usuario, contrasena)) {
            JOptionPane.showMessageDialog(this, "Inicio de sesión exitoso");
            // Abre la pantalla principal después de iniciar sesión
            new principal().setVisible(true);
            // Cierra la pantalla de inicio de sesión
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Inicio de sesión fallido");
        }
    }

    private boolean iniciarSesion(String usuario, String contrasena) {
        // Lógica de inicio de sesión (puedes personalizarla según tus necesidades)
        // En este ejemplo, simplemente verificamos si el usuario y la contraseña son válidos
        return usuario.equals("admin") && contrasena.equals("admin123");
    }
}
