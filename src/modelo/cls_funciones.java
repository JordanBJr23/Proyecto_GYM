package modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class cls_funciones {

    //----Inicio Cadena 
    public String cadena(String dato) {
        String cad = JOptionPane.showInputDialog(dato);
        return cad;
    }//fin cadena 

    //----Inicio Char
    public char caracter(String dato) {
        String carac = JOptionPane.showInputDialog(dato).toUpperCase();
        char caracter = carac.charAt(0);
        return caracter;
    }

    public int numeros(String dato) {
        String cadena = JOptionPane.showInputDialog(dato);
        int num = Integer.parseInt(cadena);
        return num;
    }

    //----Validacion de numero-----
    public boolean esNumero(String dato) {
        try {
            Float.parseFloat(dato);
            return true;
        } catch (NumberFormatException datofe) {
            return false;
        }
    }

    //-----IMPRIMIR MENSAJE------
    public void imprimeMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public int PesoIdeal(float altura, String sexo) {
        float p = 0;
        int pesoIdeal = 0;
        if (sexo.equalsIgnoreCase("Masculino")) {
            p = (altura * altura) * (float) 22.5;
            pesoIdeal = (int) Math.floor(p);
        } else if (sexo.equalsIgnoreCase("Femenino")) {
            p = (altura * altura) * (float) 21.5;
            pesoIdeal = (int) Math.floor(p);
        }
        return pesoIdeal;
    }

    public float CaloriasDiarias(float peso, float altura, int edad, String sexo) {
        int caloriasDiarias = 0;
        if (sexo.equalsIgnoreCase("Masculino")) {
            caloriasDiarias = (int) (((10 * peso) + (6.25 * altura) - (5 * edad) + 5) * 1.55);
        } else if (sexo.equalsIgnoreCase("Femenino")) {
            caloriasDiarias = (int) (((10 * peso) + (6.25 * altura) - (5 * edad) - 161) * 1.55);
        }
        return caloriasDiarias;
    }

    public float CaloriasObjetivo(String objetivo, float caloriasDiarias) {
        float caloriasObjetivo = 0;
        if (objetivo.equalsIgnoreCase("Subir de peso")) {
            caloriasObjetivo = caloriasDiarias + 250;
        } else if (objetivo.equalsIgnoreCase("Bajar de peso")) {
            caloriasObjetivo = caloriasDiarias - 250;
        } else if (objetivo.equalsIgnoreCase("Mantener peso")) {
            caloriasObjetivo = caloriasDiarias;
        }
        return caloriasObjetivo;
    }

    public int IMC(float altura, float peso) {

        float imc = 0;
        imc = (float) (peso / Math.pow(altura, 2));

        int IMC = Math.round(imc);

        return IMC;
    }

    //--METODO LISTAR 'bdCLIENTES'---
    public void impListaClientes(clsCliente bdClientes[], int v, String pase) {

        if (pase.equals("Basico")) {
            JOptionPane.showMessageDialog(null, "Nombre Cliente: " + bdClientes[v].getNombreC()
                    + "\nIdentificacion Cliente: " + bdClientes[v].getIdentificacion()
                    + "\nTelefono Cliente: " + bdClientes[v].getTelefono()
                    + "\nSexo Cliente: " + bdClientes[v].getSexo()
                    + "\nEdad Cliente: " + bdClientes[v].getEdad()
                    + "\nTipo de Pase: " + bdClientes[v].getTipoDePase()
                    + "\nCantidad de Pago: " + bdClientes[v].getPago() + " colones");
        } else if (pase.equals("Max")) {
            JOptionPane.showMessageDialog(null, "Nombre Cliente: " + bdClientes[v].getNombreC()
                    + "\nIdentificacion Cliente: " + bdClientes[v].getIdentificacion()
                    + "\nTelefono Cliente: " + bdClientes[v].getTelefono()
                    + "\nSexo Cliente: " + bdClientes[v].getSexo()
                    + "\nEdad Cliente: " + bdClientes[v].getEdad()
                    + "\nTipo de Pase: " + bdClientes[v].getTipoDePase()
                    + "\nCantidad de Pago: " + bdClientes[v].getPago() + " colones"
                    + "\nEntrenador: " + bdClientes[v].getEntrenador());
        } else {
            JOptionPane.showMessageDialog(null, "Nombre Cliente: " + bdClientes[v].getNombreC()
                    + "\nIdentificacion Cliente: " + bdClientes[v].getIdentificacion()
                    + "\nTelefono Cliente: " + bdClientes[v].getTelefono()
                    + "\nSexo Cliente: " + bdClientes[v].getSexo()
                    + "\nEdad Cliente: " + bdClientes[v].getEdad()
                    + "\nTipo de Pase: " + bdClientes[v].getTipoDePase()
                    + "\nCantidad de Pago: " + bdClientes[v].getPago() + " colones"
                    + "\nEntrenador: " + bdClientes[v].getEntrenador()
                    + "\nSomatotipo del Cliente: " + bdClientes[v].getSomatotipo()
                    + "\nObjetivo del Cliente: " + bdClientes[v].getObjetivo()
                    + "\nPeso del Cliente: " + bdClientes[v].getPesoKg() + " kg"
                    + "\nEstatura del Cliente: " + bdClientes[v].getEstaturaMts() + " cm"
                    + "\nCalorias Diarias: " + bdClientes[v].getCaloriasDiarias() + " kcal"
                    + "\nCalorias Objetivo: " + bdClientes[v].getCaloriasObjetivo() + " kcal"
                    + "\nIMC del Cliente: " + bdClientes[v].getIMC()
                    + "\nDIAS PARA EJERCITARSE: " + bdClientes[v].rutina.getDiasEjercicio()
                    + "\nDIAS DESCANSO: " + bdClientes[v].rutina.getDiasDescanso()
                    + "\n-----------------------RUTINA-----------------------------\n"
                    + bdClientes[v].rutina.getEjercicios());
        }

        //return imp;
    }

    public File correo(clsCliente bdClientes[], int v, String pase) {
        String correo = "";

        File archivo = new File("C:/Users/DellLatE5470/Desktop/WordSpace/Proyecto_GYM/file/informacion.txt");

        if (pase.equals("Basico")) {
            correo = "Nombre Cliente: " + bdClientes[v].getNombreC()
                    + "\nIdentificacion Cliente: " + bdClientes[v].getIdentificacion()
                    + "\nTelefono Cliente: " + bdClientes[v].getTelefono()
                    + "\nSexo Cliente: " + bdClientes[v].getSexo()
                    + "\nEdad Cliente: " + bdClientes[v].getEdad()
                    + "\nTipo de Pase: " + bdClientes[v].getTipoDePase()
                    + "\nCantidad de Pago: " + bdClientes[v].getPago() + " colones";

        } else if (pase.equals("Max")) {
            correo = "Nombre Cliente: " + bdClientes[v].getNombreC()
                    + "\nIdentificacion Cliente: " + bdClientes[v].getIdentificacion()
                    + "\nTelefono Cliente: " + bdClientes[v].getTelefono()
                    + "\nSexo Cliente: " + bdClientes[v].getSexo()
                    + "\nEdad Cliente: " + bdClientes[v].getEdad()
                    + "\nTipo de Pase: " + bdClientes[v].getTipoDePase()
                    + "\nCantidad de Pago: " + bdClientes[v].getPago() + " colones"
                    + "\nEntrenador: " + bdClientes[v].getEntrenador();
        } else {
            correo = "Nombre Cliente: " + bdClientes[v].getNombreC()
                    + "\nIdentificacion Cliente: " + bdClientes[v].getIdentificacion()
                    + "\nTelefono Cliente: " + bdClientes[v].getTelefono()
                    + "\nSexo Cliente: " + bdClientes[v].getSexo()
                    + "\nEdad Cliente: " + bdClientes[v].getEdad()
                    + "\nTipo de Pase: " + bdClientes[v].getTipoDePase()
                    + "\nCantidad de Pago: " + bdClientes[v].getPago() + " colones"
                    + "\nEntrenador: " + bdClientes[v].getEntrenador()
                    + "\nSomatotipo del Cliente: " + bdClientes[v].getSomatotipo()
                    + "\nObjetivo del Cliente: " + bdClientes[v].getObjetivo()
                    + "\nPeso del Cliente: " + bdClientes[v].getPesoKg() + " kg"
                    + "\nEstatura del Cliente: " + bdClientes[v].getEstaturaMts() + " cm"
                    + "\nCalorias Diarias: " + bdClientes[v].getCaloriasDiarias() + " kcal"
                    + "\nCalorias Objetivo: " + bdClientes[v].getCaloriasObjetivo() + " kcal"
                    + "\nIMC del Cliente: " + bdClientes[v].getIMC()
                    + "\nDIAS PARA EJERCITARSE: " + bdClientes[v].rutina.getDiasEjercicio()
                    + "\nDIAS DESCANSO: " + bdClientes[v].rutina.getDiasDescanso()
                    + "\n-----------------------RUTINA-----------------------------\n"
                    + bdClientes[v].rutina.getEjercicios();
        }
         try ( BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            bw.write(correo);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return archivo;
    }

    // Metodo  validar cedula
    public boolean verificarCedula(String identificacion, String origen) {
        boolean correcto = false;
        switch (origen) {
            case "Nacional":
                if (identificacion.length() == 9 && ((int) identificacion.charAt(0) > 48 && (int) identificacion.charAt(0) < 58)) {
                    for (int j = 1; j < identificacion.length(); j++) {
                        if (((int) identificacion.charAt(j) > 47 && (int) identificacion.charAt(j) < 58)) {
                            correcto = true;
                        } else {
                            correcto = false;
                            break;
                        }
                    }
                }
                break;
            case "Extranjero":
                if (identificacion.length() == 12 && ((int) identificacion.charAt(0) > 48 && (int) identificacion.charAt(0) < 58)) {
                    for (int j = 1; j < identificacion.length(); j++) {
                        if (((int) identificacion.charAt(j) > 47 && (int) identificacion.charAt(j) < 58)) {
                            correcto = true;
                        } else {
                            correcto = false;
                            break;
                        }
                    }
                }
                break;
            case "Otro":
                correcto = true;
                break;
            default:
                break;

        }
        return correcto;
    }

    // fin verificar cedula
    //Verificar que no existan cedulas repetidas
    public boolean verificarbdEmpleados(clsEmpleados bd[], String identificacion, int contador) {
        boolean correcto = false;
        if (contador == 0) {
            correcto = true;
        } else {
            for (int k = 0; k < contador; k++) {
                if (!identificacion.equals(bd[k].getIdentificacion())) {
                    correcto = true;
                } else {
                    correcto = false;
                    break;
                }

            }
        }
        return correcto;

    }

    public boolean verificarbdClientes(clsCliente bd[], String identificacion, int contador) {
        boolean correcto = false;
        if (contador == 0) {
            correcto = true;
        } else {
            for (int k = 0; k < contador; k++) {
                if (!identificacion.equals(bd[k].getIdentificacion())) {
                    correcto = true;
                } else {
                    correcto = false;
                    break;
                }

            }
        }
        return correcto;

    }
    // Fin de verificar cedulas repeidas
    // INICIO VERIFICAR TELEFONO

}//----fin cls_funciones------
