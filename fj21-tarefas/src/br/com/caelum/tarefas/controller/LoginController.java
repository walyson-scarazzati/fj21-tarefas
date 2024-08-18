package br.com.caelum.tarefas.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.tarefas.dao.JdbcUsuarioDao;
import br.com.caelum.tarefas.model.Usuario;

/**
 * A Hello World Java application
 * 
 * @author test
 *
 */
@Controller
public class LoginController {
    /** 
     * Retorna para o menu caso senha incorreta
     *
     */
    @RequestMapping("loginForm")
    public String loginForm() {
        return "formulario-login";
    }

    /** 
     * Validação do usuário e senha
     *
     */
    @RequestMapping("efetuaLogin")
    public String efetuaLogin(Usuario usuario, HttpSession session) {
        if (new JdbcUsuarioDao().existeUsuario(usuario)) {
            session.setAttribute("usuarioLogado", usuario);
            return "menu";
        }
        return "/usuario-senha-incorreta";
        /* return "redirect:loginForm"; */
    }

}
