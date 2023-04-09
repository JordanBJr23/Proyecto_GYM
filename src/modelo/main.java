package modelo;

import vista.JF_inicioSesion;


public class main {

    public static void main(String[] args) {

        JF_inicioSesion JFIS = new JF_inicioSesion();

        //---INICIAR DIRECTAMENTE EL PROGRAMA
        //clsM.menuPrincipal();
        //Pruebas calculos--
        //clsCalculos c = new clsCalculos();
        //float calorias =c.CaloriasDiarias(93, 1.83f, 19,"Masculino");
        //System.out.println(calorias);
        //---INCIAR PROGRAMA CON INCIO SESION
        JFIS.setVisible(true);

        //---------RUTINAS----------
        //clsRutina clsr = new clsRutina();
        //JOptionPane.showMessageDialog(null, clsr.rutina6);
        //----entrenado
        //clsE.asignarEntrenador();
        //---PRUEBA MENUJF
        //JFMP.setVisible(true);
    }

}
