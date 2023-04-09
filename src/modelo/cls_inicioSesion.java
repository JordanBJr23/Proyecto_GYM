
package modelo;

import javax.swing.JOptionPane;
import vista.JF_inicioSesion;


public class cls_inicioSesion {

    //------instancias-----
    JF_inicioSesion JFIS = new JF_inicioSesion();

    //--------Atributos------
    private String usuario = "admin";
    private String contrasena = "admin";

    //-------Constructures----
    public cls_inicioSesion(String usernameIni, String passwordIni) {

        this.usuario = usernameIni;
        this.contrasena = passwordIni;

    }

    //-------GETTERS y SETTERS
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usernameIni) {
        this.usuario = usernameIni;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String passwordIni) {
        this.contrasena = passwordIni;
    }

    //metodo para inicio de sesion en la vista 
    public boolean inicioSesion() {
        boolean iniEstado = false;

        if (usuario.isEmpty() || contrasena.isEmpty()) {
            iniEstado = false;
            JOptionPane.showMessageDialog(null, "Debe rellenar los espacios vacios");
        } else if (usuario.equals("admin") && contrasena.equals("admin")) {
            iniEstado = true;

        } else {
            iniEstado = false;
            JOptionPane.showMessageDialog(null, "Credenciales Incorrectas");
            
        }
        return iniEstado;
    }//fin inicioSesion

}//fin cls_inicioSesion
