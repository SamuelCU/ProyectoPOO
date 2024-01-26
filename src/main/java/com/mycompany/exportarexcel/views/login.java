package com.mycompany.exportarexcel.views;

import com.mycompany.exportarexcel.principal;

import javax.swing.*;
import java.awt.*;
import java.security.Principal;

public class login extends javax.swing.JFrame {

    // Agrega los componentes necesarios para el formulario de inicio de sesión

    public login() {
        initComponents();
        this.setSize(500,240);
        this.setTitle("Iniciar Sesion");
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
        // Lógica para verificar el inicio de sesión

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);


        JLabel titleLabel = new JLabel("LOG IN");
        //JLabel userLabel = new JLabel("Usuario:");
        //JTextField usuarioField = new JTextField(10);
        //JLabel passwordLabel = new JLabel("Contraseña:");
        //JPasswordField contrasenaField = new JPasswordField(10);

        Font fontTitle = new Font("Centhuric Gotic", Font.PLAIN, 20);
        Font fontlabel = new Font("Centhuric Gotic", Font.PLAIN, 15);

        titleLabel.setFont(fontTitle);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);


        panel.add(titleLabel, gbc);
        //panel.add(userLabel);
        //panel.add(usuarioField);
        //panel.add(passwordLabel);
        //panel.add(contrasenaField);

        gbc.gridwidth = 1;
        gbc.gridy = 1;

        JLabel userLabel = new JLabel("Usuario:");
        gbc.gridx = 0;
        panel.add(userLabel, gbc);
        userLabel.setFont(fontlabel);

        JTextField usuarioField = new JTextField(10);
        gbc.gridx = 1;
        panel.add(usuarioField, gbc);
        usuarioField.setFont(fontlabel);

        gbc.gridy = 2;

        JLabel passwordLabel = new JLabel("Contraseña:");
        gbc.gridx = 0;
        panel.add(passwordLabel, gbc);
        passwordLabel.setFont(fontlabel);

        JPasswordField contrasenaField = new JPasswordField(10);
        gbc.gridx = 1;
        panel.add(contrasenaField, gbc);
        contrasenaField.setFont(fontlabel);

        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.gridwidth = 2;


        int result = JOptionPane.showConfirmDialog(this, panel, "Inicio de Sesión",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String usuario = usuarioField.getText();
            String contrasena = new String(contrasenaField.getPassword());

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
    }


    private boolean iniciarSesion(String usuario, String contrasena) {
        // Lógica de inicio de sesión (puedes personalizarla según tus necesidades)
        // En este ejemplo, simplemente verificamos si el usuario y la contraseña son válidos
        return usuario.equals("admin") && contrasena.equals("admin123");
    }
}
