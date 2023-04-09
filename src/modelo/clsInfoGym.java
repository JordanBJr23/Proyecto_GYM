
package modelo;

import javax.swing.JOptionPane;

public class clsInfoGym {

    //----------Se crea la clase pública para la informaciónd el gimnacio--------------//
    public clsInfoGym() {
    }

    //--------Método Estadísticas Clientes--------//
    public void estadisticasClientes() {
        clsCliente Ccliente = new clsCliente();
        JOptionPane.showMessageDialog(null, "La cantidad total de clientes es: " + Ccliente.contCC
                + "\n La cantidad total de clientes de sexo Masculino: " + Ccliente.contHombres
                + "\n La cantidad total de clientes de sexo Femenino: " + Ccliente.contMujeres
                + "\n La cantidad total de clientes con el Somatipo de Ectomorfo es : " + Ccliente.contEcto
                + "\n La cantidad total de clientes con el Somatipo de Mesomorfo es : " + Ccliente.contMeso
                + "\n La cantidad total de clientes con el Somatipo de Endomorfo es : " + Ccliente.contEndo
                + "\n La cantidad total de clientes desean subir de peso es : " + Ccliente.contSubir
                + "\n La cantidad total de clientes desean bajar de peso es : " + Ccliente.contBajar
                + "\n La cantidad total de clientes desean mantener el peso es : " + Ccliente.contMantener
                + "\n La cantidad total de clientes que eligieron pase basico: " + Ccliente.contBasico
                + "\n La cantidad total de clientes que eligieron pase Max: " + Ccliente.contMax
                + "\n La cantidad total de clientes que eligieron pase Ultra: " + Ccliente.contUltra);
        //----------Ganancias del Gimnasio--------//
        int ingresos = (Ccliente.contBasico * 10000) + (Ccliente.contMax * 15000) + (Ccliente.contUltra * 20000);
        JOptionPane.showMessageDialog(null, "La ganancia total del gimnasio es: " + ingresos);
    }

}
