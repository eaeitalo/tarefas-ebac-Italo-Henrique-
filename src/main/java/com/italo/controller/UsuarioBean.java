package com.controller;

import com.Usuario;
import com.italo.service.UsuarioService;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class UsuarioBean implements Serializable {

    private Usuario usuario = new Usuario();
    private List<Usuario> usuarios;

    @Inject
    private UsuarioService usuarioService;

    public void cadastrar() {
        try {
            usuarioService.cadastrarUsuario(usuario);
            usuario = new Usuario();
            usuarios = usuarioService.listarUsuarios();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public List<Usuario> getUsuarios() {
        if (usuarios == null) {
            usuarios = usuarioService.listarUsuarios();
        }
        return usuarios;
    }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}
