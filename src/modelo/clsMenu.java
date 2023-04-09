package modelo;

import javax.swing.JOptionPane;
import vista.JF_menuPrincipal;

public class clsMenu {

    //------INSTANCIAS-------
    clsCliente clsC = new clsCliente();
    clsEmpleados clsE = new clsEmpleados();
    clsInfoGym clsI = new clsInfoGym();

    /*
        añadir comprobar si usario tiene acceso al gym
     */
    public void menuPrincipal(String opcion) { //Luciana

        if ("A".equals(opcion)) {
            do {
                opcion = JOptionPane.showInputDialog("Digite la opción que desea: \nA. Añadir cliente \nB. Editar cliente \nC. Eliminar cliente "
                        + "\nD. Buscar cliente \nE. Ver lista de clientes \nF.Ver estadistícas de los clientes \nG.Volver al menú principal ");
                if (null != opcion) {
                    opcion = opcion.toUpperCase();
                    switch (opcion) {
                        case "A":
                            clsC.agregarCliente();
                            break;
                        case "B":
                            clsC.editarCliente();
                            break;
                        case "C":
                            clsC.eliminarCliente();
                            break;
                        case "D":
                            clsC.BuscarCliente();
                            break;
                        case "E":
                            clsC.listarClientes();
                            break;
                        case "F":
                            clsI.estadisticasClientes();
                            break;
                        case "G":
                            JF_menuPrincipal JFMP = new JF_menuPrincipal();
                            JFMP.setVisible(true);
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opción no válida");
                            break;
                    }//fin de switch Clientes
                } else {
                    opcion = "G";
                    JF_menuPrincipal JFMP = new JF_menuPrincipal();
                    JFMP.setVisible(true);
                }

            } while (!opcion.equals("G"));
        } else {//----empleados
            do {
                opcion = JOptionPane.showInputDialog("Digite la opción que desea: \nA. Agregar empleado \nB. Editar editar \nC. Eliminar empleado "
                        + "\nD. Buscar empleado \nE. Ver lista de empleados \nF. Volver al menú principal");
                if (null != opcion) {
                    opcion = opcion.toUpperCase();
                    switch (opcion) {
                        case "A":
                            clsE.AgregarEmpleado();
                            break;
                        case "B":
                            clsE.editarEmpleado();
                            break;
                        case "C":
                            clsE.eliminarEmpleado();
                            break;
                        case "D":
                            clsE.BuscarEmpleado();
                            break;
                        case "E":
                            clsE.ListaEmpleados();
                            break;
                        case "F":
                            JF_menuPrincipal JFMP = new JF_menuPrincipal();
                            JFMP.setVisible(true);
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opción no válida");
                            break;
                    }//fin de switch Empleados
                } else {
                    opcion = "F";
                    JF_menuPrincipal JFMP = new JF_menuPrincipal();
                    JFMP.setVisible(true);
                }
            } while (!opcion.equals("F"));
        }//fin else

    }//fin método
}
