package modelo;

import javax.swing.JOptionPane;

public class clsCliente {

    ///---------Info Personal------
    private String nombreC;
    private String identificacion;
    private String sexo;
    private int edad;
    private String telefono;
    private String tipoDePase;
    private String entrenador;
    int contadorC = 0;
    private float pago;
    ///---------------------Contadores----------------------///
    public static int contCC;
    public static int contEcto;
    public static int contMeso;
    public static int contEndo;
    public static int contSubir;
    public static int contMantener;
    public static int contBajar;
    public static int contBasico;
    public static int contMax;
    public static int contUltra;
    public static int contHombres;
    public static int contMujeres;
    /*  
        Basico [] solo acceso a gym || no ucpa ningun calculo pago=10000
        Max [] pichudo pero ocupa entrenado ||  no ocupa ningun calculo pago=15000
        Ultra []  0 pichudo ocupa entrenar y rutina || si ocupatodo pago 20000    private float pago; //Predeterminado lee tipo de pase

    //----------INFO GYM---------------------
    private String somatotipo; //Eptomorfo-Mesomorfo-Endomorfo
    private String objetivo; //SubirPerso-bajarPeso-manternerPeso
    /*
        Formula hom= ((10*kg)+(6.25*alturacm)-(5*edad)+5)*1.5
        Formula muj= ((10*kg)+(6.25*alturacm)-(5*edad)+161)*1.5
     */
    private String somatotipo;
    private float caloriasDiarias;
    private float caloriasObjetivo;
    private float pesoKg; //input
    private float estaturaMts; //input
    private String objetivo;
    private int IMC; // HAY UN METODO PARA CALCULARLA TE FALTA ESTO DEREKKKKKKKKKKKKKKK
    /////
    ////
    ///

    //private float pesoIdeal; FUTURA EMPLEMETACION
    //----------INSTANCIAS-------------------
    public clsRutina clsR = new clsRutina();
    clsRutina rutina;
    cls_funciones clsF = new cls_funciones();
    clsEmpleados clsE = new clsEmpleados();

    //-------------BASE DE DATOS CLIENTES----------------------/
    clsCliente bdClientes[] = new clsCliente[9999999];

    public clsCliente() {
    }

    public clsCliente(String nombreC, String identificacion, String sexo, int edad, String telefono, String tipoDePase, String entrenador, float pago, String somatotipo, String objetivo, float caloriasDiarias, float caloriasObjetivo, float pesoKg, float estaturaCm, clsRutina rutina, int IMC) {
        this.nombreC = nombreC;
        this.identificacion = identificacion;
        this.sexo = sexo;
        this.edad = edad;
        this.telefono = telefono;
        this.tipoDePase = tipoDePase;
        this.entrenador = entrenador;
        this.pago = pago;
        this.somatotipo = somatotipo;
        this.objetivo = objetivo;
        this.caloriasDiarias = caloriasDiarias;
        this.caloriasObjetivo = caloriasObjetivo;
        this.pesoKg = pesoKg;
        this.estaturaMts = estaturaCm;
        this.rutina = rutina;
        this.IMC = IMC;
    }

    public float getIMC() {
        return IMC;
    }

    ////------------------------GETTERS AND SETTER------------------------------------------
    public void setIMC(int IMC) {
        this.IMC = IMC;
    }

    public String getNombreC() {
        return nombreC;
    }

    public void setNombreC(String nombreC) {
        this.nombreC = nombreC;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getSomatotipo() {
        return somatotipo;
    }

    public void setSomatotipo(String somatotipo) {
        this.somatotipo = somatotipo;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getTipoDePase() {
        return tipoDePase;
    }

    public void setTipoDePase(String tipoDePase) {
        this.tipoDePase = tipoDePase;
    }

    public String getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(String entrenador) {
        this.entrenador = entrenador;
    }

    public float getCaloriasDiarias() {
        return caloriasDiarias;
    }

    public void setCaloriasDiarias(float caloriasDiarias) {
        this.caloriasDiarias = caloriasDiarias;
    }

    public float getCaloriasObjetivo() {
        return caloriasObjetivo;
    }

    public void setCaloriasObjetivo(float caloriasObjetivo) {
        this.caloriasObjetivo = caloriasObjetivo;
    }

    public float getPago() {
        return pago;
    }

    public void setPago(float pago) {
        this.pago = pago;
    }

    public float getPesoKg() {
        return pesoKg;
    }

    public void setPesoKg(float pesoKg) {
        this.pesoKg = pesoKg;
    }

    public float getEstaturaMts() {
        return estaturaMts;
    }

    public void setEstaturaCm(float estaturaCm) {
        this.estaturaMts = estaturaCm;
    }

    public clsRutina getRutina() {
        return rutina;
    }

    public void setRutina(clsRutina rutina) {
        this.rutina = rutina;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    //----------------------METODOS------------------------------------------------------
    public void agregarCliente() { // Derek

        //--------------------------Variables--------------------------
        String entrenador = "", nombre = "", identificacion = "", sexo = "", origen = "", edadS = "", telefono = "", tipoDePase = "", somatotipo = "", objetivo = "", caloriasDiariasS = "", pesoKgS = "", estaturaCmS = "", pagoS = "", controlador = "";
        int edad = 0, bandera = 0;
        float pago = 0, caloriasDiarias = 0, pesoKg = 0, estaturaCm = 0, caloriasObjetivo = 0;

        //-------Pide nombre del Cliente mientras sea menor que 5 caracteres--------
        while (nombre.length() < 5 || nombre.equals("")) {
            nombre = JOptionPane.showInputDialog("Digite el nombre completo del cliente");
            if (nombre.length() < 5 || nombre.equals("")) {
                //Si el nombre que se introdujo es menor a 5 caracteres se le muestra el siguiente mensaje 
                JOptionPane.showMessageDialog(null, "! Nombre invalido ¡\nDigite un nombre valido");
            }
        }//fin pedir nombre de Cliente

        //-INCIO CEDULA EMPLEADO  
        /*
                    Nacional[]
                    DIMEX []
                    OTRO []
         */
        bandera = 0;
        while (bandera != 1) {
            origen = JOptionPane.showInputDialog("A. Nacional\nB. Dimex\nC. otro").toUpperCase();
            switch (origen) {
                case "A":
                    bandera = 1;
                    origen = "Nacional";
                    break;
                case "B":
                    bandera = 1;
                    origen = "Extranjero";
                    break;
                case "C":
                    bandera = 1;
                    origen = "Otro";
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion invalida");
                    break;
            }
        }
        boolean correcto = false;
        while (!correcto) {
            identificacion
                    = JOptionPane.showInputDialog("Digite la identificacion del cliente");
            correcto = clsF.verificarCedula(identificacion, origen);
            if (correcto) {
                correcto = clsF.verificarbdClientes(bdClientes, identificacion, contadorC);
                if (!correcto) {
                    JOptionPane.showMessageDialog(null, "El numero de cedula ya fue registrado\n Verifiquelo eh intente de nuevo");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Numero de cedula invalido");
            }
        }
        //--fin cedula empleado

        //--------------------Pedir edad del cliente--------------------------
        while (!clsF.esNumero(edadS) || !(Integer.parseInt(edadS) >= 18 && Integer.parseInt(edadS) <= 100)) { //Se comprueba si es numero
            edadS = JOptionPane.showInputDialog("Digite su edad:");
            if (!clsF.esNumero(edadS) || !(Integer.parseInt(edadS) >= 18 && Integer.parseInt(edadS) <= 100)) {//Si no es numero muestra error
                JOptionPane.showMessageDialog(null, "EDAD INVALIDA");
            }
        }
        edad = Integer.parseInt(edadS); //la edadS se convierta a numero
        //------------------FIN edad-------------------------------------------

        //------------------SEXO DEL CLIENTE-------------------------
        while (sexo.equals("") || !sexo.equals("A") && !sexo.equals("B")) { //pide sexi del cleintes
            sexo = JOptionPane.showInputDialog("Digite el sexo del Cliente:\nA. Masculino\nB. Femenino").toUpperCase();
            if (sexo.equals("") || !sexo.equals("A") && !sexo.equals("B")) {// si es null o diferente a 'A o B' entonces da error
                JOptionPane.showMessageDialog(null, "SEXO INVALIDA");
            }
        }
        switch (sexo) {// se asigna el sexo dependiendo de lo que escogio el usuario
            case "A":
                sexo = "Masculino";
                contHombres++;
                break;
            case "B":
                sexo = "Femenino";
                contMujeres++;
                break;

        }

        //-----------------FIN SEXO CLIENTE--------------------------
        //------------------NUMERO TELEFONICO
        controlador = "";
        bandera = 0;
        do {
            do {
                telefono = JOptionPane.showInputDialog("Digite el numero de telefono del cliente: ");
                for (int j = 0; j < telefono.length(); j++) { // Ciclo para recorrer desde la posición 2
                    if ((int) telefono.charAt(j) > 47 && (int) telefono.charAt(j) < 58) {// Evaluar que esten entre el 0 al 9, ya que se hizo con código ASCII.
                        bandera = 1;
                    } else {
                        bandera = 0;
                        JOptionPane.showMessageDialog(null, "!Telefono invalido¡\nDigite un numero de telefono valido");
                        break;
                    }
                }

            } while (bandera != 1);
            if (contadorC == 0) {
                controlador = "Z";
            } else {
                for (int k = 0; k < contadorC; k++) { // Ciclo para recorrer las posiciones del arreglo.
                    if (!telefono.equals(bdClientes[k].getTelefono())) { // Evaluar si hay un numero telefonico igual en los empleados agregados.
                        controlador = "Z";
                    } else {
                        controlador = "";
                        JOptionPane.showMessageDialog(null, "! El numero de telefono ya fue registrado ¡\nVerifique eh intente de nuevo");
                        bandera = 0;
                        break;
                    }

                }
            }
        } while (!controlador.equals("Z"));
        //fin numero telefonico

        //---------------TIPO DE PASE-----------------------
        while (tipoDePase.equals("") || !tipoDePase.equals("A") && !tipoDePase.equals("B") && !tipoDePase.equals("C")) {
            tipoDePase = JOptionPane.showInputDialog("Selecciones su tipo de pase:"
                    + "\nA. Basico"
                    + "\nB. Max"
                    + "\nC. Ultra").toUpperCase();
            if (tipoDePase.equals("") || !tipoDePase.equals("A") && !tipoDePase.equals("B") && !tipoDePase.equals("C")) {
                clsF.imprimeMensaje("TIPO DE PASE INVALIDO");
            }
        }

        switch (tipoDePase) {
            case "A": //----PASE BASICO-------
                tipoDePase = "Basico";
                pago = 10000;
                contBasico++;
                //---Se crea el cliente-----
                bdClientes[contadorC] = new clsCliente(nombre, identificacion, sexo, edad, telefono, tipoDePase, null, pago, null, null, 0, 0, 0, 0, null, 0);
                JOptionPane.showMessageDialog(null, "Cliente agregado correctamente");
                contCC++;
                break;
            case "B": //----PASE MAX---------
                tipoDePase = "Max";
                pago = 15000;
                contMax++;
                //------ASIGNACION DE ENTRENADOR-----------
                int cont = clsE.contadorE;
                entrenador = clsE.asignarEntrenador();
                //----Se crea el cliente-----
                bdClientes[contadorC] = new clsCliente(nombre, identificacion, sexo, edad, telefono, tipoDePase, entrenador, pago, null, null, 0, 0, 0, 0, null, 0);
                JOptionPane.showMessageDialog(null, "Cliente agregado correctamente");
                break;

            case "C": //--------PASE ULTRA------------
                tipoDePase = "Ultra";
                pago = 20000;
                contUltra++;
                contCC++;
                //---------SOMATIPO------------------------------------
                while (somatotipo.equals("") || !somatotipo.equals("A") && !somatotipo.equals("B") && !somatotipo.equals("C")) {
                    somatotipo = clsF.cadena("Digite su tipo de Somatotipo"
                            + "\nA. Ectomorfo: Contextura delgada, extremidades largas, dificil ganar peso, poco porcentaje de grasa"
                            + "\nB. Mesomorfo: Cuerpo atletico, facil de ganar musculo, facil perder grasa(bendecido por los dioses) "
                            + "\nC. Endomorfo: Contextura gruesa, baja estatura, facil acumulamiento de grasa, dificil perder peso ").toUpperCase();
                    if (somatotipo.equals("") || !somatotipo.equals("A") && !somatotipo.equals("B") && !somatotipo.equals("C")) {
                        JOptionPane.showMessageDialog(null, "Opcion invalida");
                    }
                }
                switch (somatotipo) {
                    case "A":
                        somatotipo = "Ectomorfo";
                        contEcto++;
                        break;
                    case "B":
                        somatotipo = "Mesomorfo";
                        contMeso++;
                        break;
                    case "C":
                        somatotipo = "Endomorfo";
                        contEndo++;
                        break;
                }

                //---------OBJETIVO------------------------------------
                while (objetivo.equals("") || !objetivo.equals("A") && !objetivo.equals("B") && !objetivo.equals("C")) {
                    objetivo = clsF.cadena("Digite el obejtivo"
                            + "\nA. Subir de peso"
                            + "\nB. Bajar de peso"
                            + "\nC. Mantener peso").toUpperCase();
                    if (objetivo.equals("") || !objetivo.equals("A") && !objetivo.equals("B") && !objetivo.equals("C")) {
                        JOptionPane.showMessageDialog(null, "Opcion invalida");
                    }
                }
                switch (objetivo) {
                    case "A":
                        objetivo = "Subir de peso";
                        contSubir++;
                        break;
                    case "B":
                        objetivo = "Bajar de peso";
                        contBajar++;
                        break;
                    case "C":
                        objetivo = "Mantener de peso";
                        contMantener++;
                        break;
                }//----FIN OBJETIVO

                //-------PesoKg------------
                while (!clsF.esNumero(pesoKgS) || Float.parseFloat(pesoKgS) <= 0) {
                    pesoKgS = JOptionPane.showInputDialog("Digite su peso en Kg: ");
                    if (!clsF.esNumero(pesoKgS) || Float.parseFloat(pesoKgS) <= 0) {
                        JOptionPane.showMessageDialog(null, "PESO INVALIDO");
                    }
                }
                pesoKg = Float.parseFloat(pesoKgS);

                //----------------------FIN PESO----
                //-------EstaturaCm------------
                while (!clsF.esNumero(estaturaCmS) || Float.parseFloat(estaturaCmS) <= 0 && Float.parseFloat(pesoKgS) >= 500) {
                    estaturaCmS = JOptionPane.showInputDialog("Digite su estatura en cm: ");
                    if (!clsF.esNumero(estaturaCmS) || Float.parseFloat(estaturaCmS) <= 0) {
                        JOptionPane.showMessageDialog(null, "ESTATURA INVALIDA");
                    }
                }
                estaturaCm = (Float.parseFloat(estaturaCmS));

                //----------Calorias Diarias------------
                caloriasDiarias = clsF.CaloriasDiarias(pesoKg, estaturaCm, edad, sexo);
                caloriasObjetivo = clsF.CaloriasObjetivo(objetivo, caloriasDiarias);

                //--------CREACION IMC
                int IMC = clsF.IMC(estaturaCm / 100, pesoKg);

                //----ASIGNACION ENTRENADOR---
                entrenador = clsE.asignarEntrenador();

                //-----CREACION DE RUTINA-----
                rutina = new clsRutina();
                clsR.agregarRutina(rutina);

                //----CREACION DE CLIENTE----
                bdClientes[contadorC] = new clsCliente(nombre, identificacion, sexo, edad, telefono, tipoDePase, entrenador, pago, somatotipo, objetivo, caloriasDiarias, caloriasObjetivo, pesoKg, estaturaCm, rutina, IMC);
                JOptionPane.showMessageDialog(null, "Cliente agregado correctamente");
                contadorC++;
                break;
        }///--------------FIN PASES----------------
    }//fin agregar

    public void editarCliente() { //Luciana
        //------Variables------
        String mensaje = "", entrenador = "", nombre = "", identificacion = "", sexo = "", edadS = "", telefono = "", tipoDePase = "", somatotipo = "", objetivo = "", caloriasDiariasS = "", pesoKgS = "", estaturaCmS = "", pagoS = "", controlador = "";
        int edad = 0, bandera = 0, clienteSeleccionado = 0, j = 0, bandera2 = 0;
        float pago = 0, caloriasDiarias = 0, pesoKg = 0, estaturaCm = 0, caloriasObjetivo = 0;
        String origen = "";

        //------------PROGRAMA---------------
        if (contadorC == 0) {
            JOptionPane.showMessageDialog(null, "NO HAY CLIENTES EXISTENTES");
        } else {

            //Meter un while para que solanmente seleccione un numero de '1' al numero maximo de cleintes que hay registrados y no puede aceptar letras hacer el m,ismo while de edad
            //clienteSeleccionado=Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de cliente que desea editar"));
            //------Menú de opciones a editar------
            //en este menu debe aceptar en ves del contadorC debe ir el 'numero de cliente seleccionado'
            identificacion = JOptionPane.showInputDialog("Escriba el número de cédula del cliente a editar: ");//poner el en while con condiciones par que no acepte cualquier cosa
            for (int i = 0; i < contadorC; i++) {
                if (bdClientes[i].getIdentificacion().equals(identificacion)) {
                    j = i;
                    bandera = 1;
                    break;
                }
            }
            if (bandera == 1) {
                while (bandera2 != 1) {
                    switch (bdClientes[j].getTipoDePase()) {
                        case "Basico":
                            bandera = 0;
                            do {
                                mensaje = JOptionPane.showInputDialog(null, "A. Nombre = " + bdClientes[j].getNombreC()
                                        + "\nB. Identificacion = " + bdClientes[j].getIdentificacion()
                                        + "\nC. Sexo = " + bdClientes[j].getSexo()
                                        + "\nD. edad = " + bdClientes[j].getEdad()
                                        + "\nE. telefono = " + bdClientes[j].getTelefono()
                                        + "\nF. Tipo de Pase = " + bdClientes[j].getTipoDePase()
                                        + "\n    Pago = " + bdClientes[j].getPago() + " colones"
                                        + "\nS. Salir").toUpperCase();
                                switch (mensaje) {
                                    case "A":
                                        while (nombre.length() < 5 || nombre.equals("")) {
                                            nombre = JOptionPane.showInputDialog("Digite el nombre completo del cliente");
                                            bdClientes[j].setNombreC(nombre);
                                            if (nombre.length() < 5 || nombre.equals("")) {
                                                //Si el nombre que se introdujo es menor a 5 caracteres se le muestra el siguiente mensaje 
                                                JOptionPane.showMessageDialog(null, "! Nombre invalido ¡\nDigite un nombre valido");
                                            }
                                        }//fin pedir nombre de Cliente
                                        JOptionPane.showMessageDialog(null, "Nombre editado correctamente");
                                        break;
                                    case "B":
                                        bandera = 0;
                                        while (bandera != 1) {
                                            origen = JOptionPane.showInputDialog("A. Nacional\nB. Dimex\nC. otro").toUpperCase();
                                            switch (origen) {
                                                case "A":
                                                    bandera = 1;
                                                    origen = "Nacional";
                                                    break;
                                                case "B":
                                                    bandera = 1;
                                                    origen = "Extranjero";
                                                    break;
                                                case "C":
                                                    bandera = 1;
                                                    origen = "Otro";
                                                    break;
                                                default:
                                                    JOptionPane.showMessageDialog(null, "Opcion invalida");
                                                    break;
                                            }
                                        }
                                        boolean correcto = false;
                                        while (!correcto) {
                                            identificacion
                                                    = JOptionPane.showInputDialog("Digite la identificacion del empleado");
                                            correcto = clsF.verificarCedula(identificacion, origen);
                                            if (correcto) {
                                                correcto = clsF.verificarbdClientes(bdClientes, identificacion, contadorC);
                                                if (!correcto) {
                                                    JOptionPane.showMessageDialog(null, "El numero de cedula ya fue registrado\n Verifiquelo eh intente de nuevo");
                                                }
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Numero de cedula invalido");
                                            }
                                        }
                                        bdClientes[j].setIdentificacion(identificacion);
                                        bandera = 0;
                                        break;
                                    case "C":
                                        while (sexo.equals("") || !sexo.equals("A") && !sexo.equals("B")) { //pide edad empleado 
                                            sexo = JOptionPane.showInputDialog("Digite el sexo del Cliente:\nA. Masculino\nB. Femenino").toUpperCase();
                                            if (sexo.equals("") || !sexo.equals("A") && !sexo.equals("B")) {// si es null o diferente  a A,B,C entonces da error
                                                JOptionPane.showMessageDialog(null, "OPCION INVALIDA");
                                            }
                                        }
                                        switch (sexo) {
                                            case "A":
                                                sexo = "Masculino";
                                                bdClientes[j].setSexo(sexo);
                                                JOptionPane.showMessageDialog(null, "Sexo editado correctamente");
                                                contHombres++;
                                                contMujeres--;
                                                break;
                                            case "B":
                                                sexo = "Femenino";
                                                bdClientes[j].setSexo(sexo);
                                                JOptionPane.showMessageDialog(null, "Sexo editado correctamente");
                                                contMujeres++;
                                                contHombres--;
                                                break;

                                        }
                                        break;
                                    case "D":
                                        while (!clsF.esNumero(edadS) || !(Integer.parseInt(edadS) >= 18 && Integer.parseInt(edadS) <= 100)) { //Se comprueba si es numero
                                            edadS = JOptionPane.showInputDialog("Digite su edad:");
                                            if (!clsF.esNumero(edadS) || !(Integer.parseInt(edadS) >= 18 && Integer.parseInt(edadS) <= 100)) {
                                                JOptionPane.showMessageDialog(null, "EDAD INVALIDA");
                                            }
                                        }
                                        edad = Integer.parseInt(edadS); //la edadS se convierta a numero
                                        bdClientes[j].setEdad(edad);
                                        JOptionPane.showMessageDialog(null, "Edad editada correctamente");
                                        break;
                                    case "E":
                                        controlador = "";
                                        bandera = 0;
                                        do {
                                            do {
                                                telefono = JOptionPane.showInputDialog("Digite el numero de telefono del cliente: ");
                                                for (int k = 0; k < telefono.length(); k++) { // Ciclo para recorrer desde la posición 2
                                                    if ((int) telefono.charAt(k) > 47 && (int) telefono.charAt(k) < 58) {// Evaluar que esten entre el 0 al 9, ya que se hizo con código ASCII.
                                                        bandera = 1;
                                                    } else {
                                                        bandera = 0;
                                                        JOptionPane.showMessageDialog(null, "!Telefono invalido¡\nDigite un numero de telefono valido");
                                                        break;
                                                    }
                                                }

                                            } while (bandera != 1);
                                            if (contadorC == 0) {
                                                controlador = "Z";
                                            } else {
                                                for (int k = 0; k < contadorC; k++) { // Ciclo para recorrer las posiciones del arreglo.
                                                    if (!telefono.equals(bdClientes[k].getTelefono())) { // Evaluar si hay un numero telefonico igual en los empleados agregados.
                                                        controlador = "Z";
                                                    } else {
                                                        controlador = "";
                                                        JOptionPane.showMessageDialog(null, "! El numero de telefono ya fue registrado ¡\nVerifique eh intente de nuevo");
                                                        bandera = 0;
                                                        break;
                                                    }

                                                }
                                            }
                                        } while (!controlador.equals("Z"));
                                        bdClientes[j].setTelefono(telefono);
                                        bandera = 0;
                                        break;
                                    case "F":
                                        while (tipoDePase.equals("") || !tipoDePase.equals("A") && !tipoDePase.equals("B") && !tipoDePase.equals("C")) {
                                            tipoDePase = JOptionPane.showInputDialog("Selecciones su tipo de pase:"
                                                    + "\nA. Max"
                                                    + "\nB. Ultra").toUpperCase();
                                        }

                                        switch (tipoDePase) {
                                            case "A": //----PASE MAX---------
                                                tipoDePase = "Max";
                                                bdClientes[j].setTipoDePase(tipoDePase);
                                                pago = 15000;
                                                bdClientes[j].setPago(pago);
                                                //------ASIGNACION DE ENTRENADOR-----------

                                                //----Se crea el cliente-----
                                                bdClientes[j] = new clsCliente(bdClientes[j].getNombreC(), bdClientes[j].getIdentificacion(), bdClientes[j].getSexo(), bdClientes[j].getEdad(), bdClientes[j].getTelefono(), bdClientes[j].getTipoDePase(), bdClientes[j].getEntrenador(), bdClientes[j].getPago(), null, null, 0, 0, 0, 0, null, 0);
                                                JOptionPane.showMessageDialog(null, "Pase cambiado correctamente");
                                                bandera = 2;
                                                break;
                                            case "B": //--------PASE ULTRA------------
                                                tipoDePase = "Ultra";
                                                bdClientes[j].setTipoDePase(tipoDePase);
                                                pago = 20000;
                                                bdClientes[j].setPago(pago);
                                                //---------SOMATIPO------------------------------------
                                                while (somatotipo.equals("") || !somatotipo.equals("A") && !somatotipo.equals("B") && !somatotipo.equals("C")) {
                                                    somatotipo = clsF.cadena("Digite su tipo de Somatotipo"
                                                            + "\nA. Ectomorfo: Contextura delgada, extremidades largas, dificil ganar peso, poco porcentaje de grasa"
                                                            + "\nB. Mesomorfo: Cuerpo atletico, facil de ganar musculo, facil perder grasa(bendecido por los dioses) "
                                                            + "\nC. Endomorfo: Contextura gruesa, baja estatura, facil acumulamiento de grasa, dificil perder peso ").toUpperCase();
                                                    if (somatotipo.equals("") || !somatotipo.equals("A") && !somatotipo.equals("B") && !somatotipo.equals("C")) {
                                                        JOptionPane.showMessageDialog(null, "Opcion invalida");
                                                    }
                                                }
                                                switch (somatotipo) {
                                                    case "A":
                                                        somatotipo = "Ectomorfo";
                                                        bdClientes[j].setSomatotipo(somatotipo);
                                                        break;
                                                    case "B":
                                                        somatotipo = "Mesomorfo";
                                                        bdClientes[j].setSomatotipo(somatotipo);

                                                        break;
                                                    case "C":
                                                        somatotipo = "Endomorfo";
                                                        bdClientes[j].setSomatotipo(somatotipo);

                                                        break;
                                                    default:
                                                        break;
                                                }

                                                //---------OBJETIVO------------------------------------
                                                while (objetivo.equals("") || !objetivo.equals("A") && !objetivo.equals("B") && !objetivo.equals("C")) {
                                                    objetivo = clsF.cadena("Digite el obejtivo"
                                                            + "\nA. Subir de peso"
                                                            + "\nB. Bajar de peso"
                                                            + "\nC. Mantener peso").toUpperCase();
                                                    if (objetivo.equals("") || !objetivo.equals("A") && !objetivo.equals("B") && !objetivo.equals("C")) {
                                                        JOptionPane.showMessageDialog(null, "Opcion invalida");
                                                    }
                                                }
                                                switch (objetivo) {
                                                    case "A":
                                                        objetivo = "Subir de peso";
                                                        bdClientes[j].setObjetivo(objetivo);

                                                        break;
                                                    case "B":
                                                        objetivo = "Bajar de peso";
                                                        bdClientes[j].setObjetivo(objetivo);

                                                        break;
                                                    case "C":
                                                        objetivo = "Mantener de peso";
                                                        bdClientes[j].setObjetivo(objetivo);

                                                        break;
                                                    default:
                                                        break;
                                                }//----FIN OBJETIVO

                                                //-------PesoKg------------
                                                while (!clsF.esNumero(pesoKgS) || Float.parseFloat(pesoKgS) <= 0) {
                                                    pesoKgS = JOptionPane.showInputDialog("Digite su peso en Kg: ");
                                                    if (!clsF.esNumero(pesoKgS) || Float.parseFloat(pesoKgS) <= 0) {
                                                        JOptionPane.showMessageDialog(null, "Dato invalido");
                                                    }
                                                }
                                                pesoKg = Float.parseFloat(pesoKgS);
                                                bdClientes[j].setPesoKg(pesoKg);

                                                //----------------------FIN PESO----
                                                //-------EstaturaCm------------
                                                while (!clsF.esNumero(estaturaCmS) || Float.parseFloat(estaturaCmS) <= 0 && Float.parseFloat(pesoKgS) >= 500) {
                                                    estaturaCmS = JOptionPane.showInputDialog("Digite su estatura en cm: ");
                                                    if (!clsF.esNumero(estaturaCmS) || Float.parseFloat(estaturaCmS) <= 0) {
                                                        JOptionPane.showMessageDialog(null, "Dato invalido");
                                                    }
                                                }
                                                estaturaCm = (Float.parseFloat(estaturaCmS));
                                                bdClientes[j].setEstaturaCm(estaturaCm);

                                                //----------Calorias Diarias------------
                                                caloriasDiarias = clsF.CaloriasDiarias(bdClientes[j].getPesoKg(), bdClientes[j].getEstaturaMts(), bdClientes[j].getEdad(), bdClientes[j].getSexo());
                                                bdClientes[j].setCaloriasDiarias(caloriasDiarias);
                                                caloriasObjetivo = clsF.CaloriasObjetivo(objetivo, bdClientes[j].getCaloriasDiarias());
                                                bdClientes[j].setCaloriasObjetivo(caloriasObjetivo);

                                                //-----CREACION DE RUTINA-----
                                                rutina = new clsRutina();
                                                clsR.agregarRutina(rutina);
                                                bdClientes[j].setRutina(rutina);
                                                int IMC = clsF.IMC(estaturaCm / 100, pesoKg);
                                                bdClientes[j].setIMC(IMC);
                                                //--CALORIAS OBJETIVO
                                                bdClientes[j] = new clsCliente(bdClientes[j].getNombreC(), bdClientes[j].getIdentificacion(), bdClientes[j].getSexo(), bdClientes[j].getEdad(), bdClientes[j].getTelefono(), bdClientes[j].getTipoDePase(), bdClientes[j].getEntrenador(), bdClientes[j].getPago(), bdClientes[j].getSomatotipo(), bdClientes[j].getObjetivo(), bdClientes[j].getCaloriasDiarias(), bdClientes[j].getCaloriasObjetivo(), bdClientes[j].getPesoKg(), bdClientes[j].getEstaturaMts(), bdClientes[j].getRutina(), (int) bdClientes[j].getIMC());
                                                JOptionPane.showMessageDialog(null, "Pase cambiado correctamente");
                                                bandera = 2;
                                                break;
                                            default:
                                                break;

                                        } // Cambiar tipo de pase
                                        break;
                                    case "S":
                                        bandera = 2;
                                        bandera2 = 1;
                                        break;
                                    default:
                                        JOptionPane.showMessageDialog(null, "Opcion invalida");
                                        break;
                                }
                            } while (bandera != 2);
                            break;

                        //-------------------------------------------------------Editar pase max----------------------------------------------------------------------------------------------------------
                        case "Max":
                            bandera = 0;
                            do {
                                mensaje = JOptionPane.showInputDialog(null, "A. Nombre = " + bdClientes[j].getNombreC()
                                        + "\nB. Identificacion = " + bdClientes[j].getIdentificacion()
                                        + "\nC. Sexo = " + bdClientes[j].getSexo()
                                        + "\nD. edad = " + bdClientes[j].getEdad()
                                        + "\nE. telefono = " + bdClientes[j].getTelefono()
                                        + "\nF. Tipo de Pase = " + bdClientes[j].getTipoDePase()
                                        + "\nG. Entrenador = " + bdClientes[j].getEntrenador()
                                        + "\n   Pago = " + bdClientes[j].getPago() + " colones"
                                        + "\nS. Salir").toUpperCase();
                                switch (mensaje) {
                                    case "A":
                                        while (nombre.length() < 5 || nombre.equals("")) {
                                            nombre = JOptionPane.showInputDialog("Digite el nombre completo del cliente");
                                            bdClientes[j].setNombreC(nombre);
                                            if (nombre.length() < 5 || nombre.equals("")) {
                                                //Si el nombre que se introdujo es menor a 5 caracteres se le muestra el siguiente mensaje 
                                                JOptionPane.showMessageDialog(null, "! Nombre invalido ¡\nDigite un nombre valido");
                                            }
                                        }//fin pedir nombre de Cliente
                                        JOptionPane.showMessageDialog(null, "Nombre editado correctamente");
                                        break;
                                    case "B":
                                        bandera = 0;
                                        while (bandera != 1) {
                                            origen = JOptionPane.showInputDialog("A. Nacional\nB. Dimex\nC. otro").toUpperCase();
                                            switch (origen) {
                                                case "A":
                                                    bandera = 1;
                                                    origen = "Nacional";
                                                    break;
                                                case "B":
                                                    bandera = 1;
                                                    origen = "Extranjero";
                                                    break;
                                                case "C":
                                                    bandera = 1;
                                                    origen = "Otro";
                                                    break;
                                                default:
                                                    JOptionPane.showMessageDialog(null, "Opcion invalida");
                                                    break;
                                            }
                                        }
                                        boolean correcto = false;
                                        while (!correcto) {
                                            identificacion
                                                    = JOptionPane.showInputDialog("Digite la identificacion del empleado");
                                            correcto = clsF.verificarCedula(identificacion, origen);
                                            if (correcto) {
                                                correcto = clsF.verificarbdClientes(bdClientes, identificacion, contadorC);
                                                if (!correcto) {
                                                    JOptionPane.showMessageDialog(null, "El numero de cedula ya fue registrado\n Verifiquelo eh intente de nuevo");
                                                }
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Numero de cedula invalido");
                                            }
                                        }
                                        bdClientes[j].setIdentificacion(identificacion);
                                        bandera = 0;
                                        break;
                                    case "C":
                                        while (sexo.equals("") || !sexo.equals("A") && !sexo.equals("B")) { //pide edad empleado 
                                            sexo = JOptionPane.showInputDialog("Digite el sexo del Cliente:\nA. Masculino\nB. Femenino").toUpperCase();
                                            if (sexo.equals("") || !sexo.equals("A") && !sexo.equals("B")) {// si es null o diferente  a A,B,C entonces da error
                                                JOptionPane.showMessageDialog(null, "OPCION INVALIDA");
                                            }
                                        }
                                        switch (sexo) {
                                            case "A":
                                                sexo = "Masculino";
                                                bdClientes[j].setSexo(sexo);
                                                JOptionPane.showMessageDialog(null, "Sexo editado correctamente");
                                                contMujeres--;
                                                contHombres++;
                                                break;
                                            case "B":
                                                sexo = "Femenino";
                                                bdClientes[j].setSexo(sexo);
                                                JOptionPane.showMessageDialog(null, "Sexo editado correctamente");
                                                contMujeres++;
                                                contHombres--;
                                                break;

                                        }
                                        break;
                                    case "D":
                                        while (!clsF.esNumero(edadS) || !(Integer.parseInt(edadS) >= 18 && Integer.parseInt(edadS) <= 100)) { //Se comprueba si es numero
                                            edadS = JOptionPane.showInputDialog("Digite su edad:");
                                            if (!clsF.esNumero(edadS) || !(Integer.parseInt(edadS) >= 18 && Integer.parseInt(edadS) <= 100)) {
                                                JOptionPane.showMessageDialog(null, "EDAD INVALIDA");
                                            }
                                        }
                                        edad = Integer.parseInt(edadS); //la edadS se convierta a numero
                                        bdClientes[j].setEdad(edad);
                                        JOptionPane.showMessageDialog(null, "Edad editada correctamente");
                                        break;
                                    case "E":
                                        controlador = "";
                                        bandera = 0;
                                        do {
                                            do {
                                                telefono = JOptionPane.showInputDialog("Digite el numero de telefono del cliente: ");
                                                for (int k = 0; k < telefono.length(); k++) { // Ciclo para recorrer desde la posición 2
                                                    if ((int) telefono.charAt(k) > 47 && (int) telefono.charAt(k) < 58) {// Evaluar que esten entre el 0 al 9, ya que se hizo con código ASCII.
                                                        bandera = 1;
                                                    } else {
                                                        bandera = 0;
                                                        JOptionPane.showMessageDialog(null, "!Telefono invalido¡\nDigite un numero de telefono valido");
                                                        break;
                                                    }
                                                }

                                            } while (bandera != 1);
                                            if (contadorC == 0) {
                                                controlador = "Z";
                                            } else {
                                                for (int k = 0; k < contadorC; k++) { // Ciclo para recorrer las posiciones del arreglo.
                                                    if (!telefono.equals(bdClientes[k].getTelefono())) { // Evaluar si hay un numero telefonico igual en los empleados agregados.
                                                        controlador = "Z";
                                                    } else {
                                                        controlador = "";
                                                        JOptionPane.showMessageDialog(null, "! El numero de telefono ya fue registrado ¡\nVerifique eh intente de nuevo");
                                                        bandera = 0;
                                                        break;
                                                    }

                                                }
                                            }
                                        } while (!controlador.equals("Z"));
                                        bdClientes[j].setTelefono(telefono);
                                        bandera = 0;
                                        break;
                                    case "F":
                                        while (tipoDePase.equals("") || !tipoDePase.equals("A") && !tipoDePase.equals("B") && !tipoDePase.equals("C")) {
                                            tipoDePase = JOptionPane.showInputDialog("Selecciones su tipo de pase:"
                                                    + "\nA. Basico"
                                                    + "\nB. Ultra").toUpperCase();
                                        }

                                        switch (tipoDePase) {
                                            case "A": //----PASE BASICO-------
                                                tipoDePase = "Basico";
                                                bdClientes[j].setTipoDePase(tipoDePase);
                                                pago = 10000;
                                                bdClientes[j].setPago(pago);
                                                //---Se crea el cliente-----
                                                bdClientes[j] = new clsCliente(bdClientes[j].getNombreC(), bdClientes[j].getIdentificacion(), bdClientes[j].getSexo(), bdClientes[j].getEdad(), bdClientes[j].getTelefono(), bdClientes[j].getTipoDePase(), null, bdClientes[j].getPago(), null, null, 0, 0, 0, 0, null, 0);
                                                JOptionPane.showMessageDialog(null, "Pase editado correctamente");
                                                bandera = 2;
                                                break;

                                            case "B": //--------PASE ULTRA------------
                                                tipoDePase = "Ultra";
                                                bdClientes[j].setTipoDePase(tipoDePase);
                                                pago = 20000;
                                                bdClientes[j].setPago(pago);
                                                //---------SOMATIPO------------------------------------
                                                while (somatotipo.equals("") || !somatotipo.equals("A") && !somatotipo.equals("B") && !somatotipo.equals("C")) {
                                                    somatotipo = clsF.cadena("Digite su tipo de Somatotipo"
                                                            + "\nA. Ectomorfo: Contextura delgada, extremidades largas, dificil ganar peso, poco porcentaje de grasa"
                                                            + "\nB. Mesomorfo: Cuerpo atletico, facil de ganar musculo, facil perder grasa(bendecido por los dioses) "
                                                            + "\nC. Endomorfo: Contextura gruesa, baja estatura, facil acumulamiento de grasa, dificil perder peso ").toUpperCase();
                                                    if (somatotipo.equals("") || !somatotipo.equals("A") && !somatotipo.equals("B") && !somatotipo.equals("C")) {
                                                        JOptionPane.showMessageDialog(null, "Opcion invalida");
                                                    }
                                                }
                                                switch (somatotipo) {
                                                    case "A":
                                                        somatotipo = "Ectomorfo";
                                                        bdClientes[j].setSomatotipo(somatotipo);
                                                        break;
                                                    case "B":
                                                        somatotipo = "Mesomorfo";
                                                        bdClientes[j].setSomatotipo(somatotipo);

                                                        break;
                                                    case "C":
                                                        somatotipo = "Endomorfo";
                                                        bdClientes[j].setSomatotipo(somatotipo);

                                                        break;
                                                }

                                                //---------OBJETIVO------------------------------------
                                                while (objetivo.equals("") || !objetivo.equals("A") && !objetivo.equals("B") && !objetivo.equals("C")) {
                                                    objetivo = clsF.cadena("Digite el obejtivo"
                                                            + "\nA. Subir de peso"
                                                            + "\nB. Bajar de peso"
                                                            + "\nC. Mantener peso").toUpperCase();
                                                    if (objetivo.equals("") || !objetivo.equals("A") && !objetivo.equals("B") && !objetivo.equals("C")) {
                                                        JOptionPane.showMessageDialog(null, "Opcion invalida");
                                                    }
                                                }
                                                switch (objetivo) {
                                                    case "A":
                                                        objetivo = "Subir de peso";
                                                        bdClientes[j].setObjetivo(objetivo);

                                                        break;
                                                    case "B":
                                                        objetivo = "Bajar de peso";
                                                        bdClientes[j].setObjetivo(objetivo);

                                                        break;
                                                    case "C":
                                                        objetivo = "Mantener de peso";
                                                        bdClientes[j].setObjetivo(objetivo);

                                                        break;
                                                }//----FIN OBJETIVO

                                                //-------PesoKg------------
                                                while (!clsF.esNumero(pesoKgS) || Float.parseFloat(pesoKgS) <= 0) {
                                                    pesoKgS = JOptionPane.showInputDialog("Digite su peso en Kg: ");
                                                    if (!clsF.esNumero(pesoKgS) || Float.parseFloat(pesoKgS) <= 0) {
                                                        JOptionPane.showMessageDialog(null, "Dato invalido");
                                                    }
                                                }
                                                pesoKg = Float.parseFloat(pesoKgS);
                                                bdClientes[j].setPesoKg(pesoKg);

                                                //----------------------FIN PESO----
                                                //-------EstaturaCm------------
                                                while (!clsF.esNumero(estaturaCmS) || Float.parseFloat(estaturaCmS) <= 0 && Float.parseFloat(pesoKgS) >= 500) {
                                                    estaturaCmS = JOptionPane.showInputDialog("Digite su estatura en cm: ");
                                                    if (!clsF.esNumero(estaturaCmS) || Float.parseFloat(estaturaCmS) <= 0) {
                                                        JOptionPane.showMessageDialog(null, "Dato invalido");
                                                    }
                                                }
                                                estaturaCm = (Float.parseFloat(estaturaCmS));
                                                bdClientes[j].setEstaturaCm(estaturaCm);

                                                //----------Calorias Diarias------------
                                                caloriasDiarias = clsF.CaloriasDiarias(bdClientes[j].getPesoKg(), bdClientes[j].getEstaturaMts(), bdClientes[j].getEdad(), bdClientes[j].getSexo());
                                                bdClientes[j].setCaloriasDiarias(caloriasDiarias);
                                                caloriasObjetivo = clsF.CaloriasObjetivo(objetivo, bdClientes[j].getCaloriasDiarias());
                                                bdClientes[j].setCaloriasObjetivo(caloriasObjetivo);

                                                //-----CREACION DE RUTINA-----
                                                rutina = new clsRutina();
                                                clsR.agregarRutina(rutina);
                                                bdClientes[j].setRutina(rutina);
                                                int IMC = clsF.IMC(estaturaCm / 100, pesoKg);
                                                bdClientes[j].setIMC(IMC);
                                                //--CALORIAS OBJETIVO
                                                bdClientes[j] = new clsCliente(bdClientes[j].getNombreC(), bdClientes[j].getIdentificacion(), bdClientes[j].getSexo(), bdClientes[j].getEdad(), bdClientes[j].getTelefono(), bdClientes[j].getTipoDePase(), bdClientes[j].getEntrenador(), bdClientes[j].getPago(), bdClientes[j].getSomatotipo(), bdClientes[j].getObjetivo(), bdClientes[j].getCaloriasDiarias(), bdClientes[j].getCaloriasObjetivo(), bdClientes[j].getPesoKg(), bdClientes[j].getEstaturaMts(), bdClientes[j].getRutina(), (int) bdClientes[j].getIMC());
                                                JOptionPane.showMessageDialog(null, "Pase cambiado correctamente");
                                                bandera = 2;

                                                break;
                                        }
                                        break;
                                    case "S":
                                        bandera = 2;
                                        bandera2 = 1;
                                        break;
                                    default:
                                        JOptionPane.showMessageDialog(null, "Opcion invalida");
                                        break;
                                }
                            } while (bandera != 2);

                            break;
                        case "Ultra":
                            bandera = 0;
                            do {
                                mensaje = JOptionPane.showInputDialog(null, "A. Nombre = " + bdClientes[j].getNombreC()
                                        + "\nB. Identificacion = " + bdClientes[j].getIdentificacion()
                                        + "\nC. Sexo = " + bdClientes[j].getSexo()
                                        + "\nD. edad = " + bdClientes[j].getEdad()
                                        + "\nE. telefono = " + bdClientes[j].getTelefono()
                                        + "\nF. Tipo de Pase = " + bdClientes[j].getTipoDePase()
                                        + "\nG. Objetivo = " + bdClientes[j].getObjetivo()
                                        + "\nH. Peso Kg = " + bdClientes[j].getPesoKg() + " kg"
                                        + "\nI. Estatura  = " + bdClientes[j].getEstaturaMts() + " cm"
                                        + "\nJ. Rutina = " + bdClientes[j].rutina.getDiasEjercicio()
                                        + "\n   Somatipo = " + bdClientes[j].getSomatotipo()
                                        + "\n   Calorias Diarias = " + bdClientes[j].getCaloriasDiarias() + " kcal"
                                        + "\n   Calorias Objetivo  =" + bdClientes[j].getCaloriasObjetivo() + " kcal"
                                        + "\n   IMC: " + bdClientes[j].getIMC()
                                        + "\n   Pago = " + bdClientes[j].getPago() + " colones"
                                        + "\nS. Salir").toUpperCase();

                                switch (mensaje) {
                                    case "A":
                                        while (nombre.length() < 5 || nombre.equals("")) {
                                            nombre = JOptionPane.showInputDialog("Digite el nombre completo del cliente");
                                            bdClientes[j].setNombreC(nombre);
                                            if (nombre.length() < 5 || nombre.equals("")) {
                                                //Si el nombre que se introdujo es menor a 5 caracteres se le muestra el siguiente mensaje 
                                                JOptionPane.showMessageDialog(null, "! Nombre invalido ¡\nDigite un nombre valido");
                                            }
                                        }//fin pedir nombre de Cliente
                                        JOptionPane.showMessageDialog(null, "Nombre editado correctamente");
                                        break;
                                    case "B":
                                        bandera = 0;
                                        while (bandera != 1) {
                                            origen = JOptionPane.showInputDialog("A. Nacional\nB. Dimex\nC. otro").toUpperCase();
                                            switch (origen) {
                                                case "A":
                                                    bandera = 1;
                                                    origen = "Nacional";
                                                    break;
                                                case "B":
                                                    bandera = 1;
                                                    origen = "Extranjero";
                                                    break;
                                                case "C":
                                                    bandera = 1;
                                                    origen = "Otro";
                                                    break;
                                                default:
                                                    JOptionPane.showMessageDialog(null, "Opcion invalida");
                                                    break;
                                            }
                                        }
                                        boolean correcto = false;
                                        while (!correcto) {
                                            identificacion
                                                    = JOptionPane.showInputDialog("Digite la identificacion del empleado");
                                            correcto = clsF.verificarCedula(identificacion, origen);
                                            if (correcto) {
                                                correcto = clsF.verificarbdClientes(bdClientes, identificacion, contadorC);
                                                if (!correcto) {
                                                    JOptionPane.showMessageDialog(null, "El numero de cedula ya fue registrado\n Verifiquelo eh intente de nuevo");
                                                }
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Numero de cedula invalido");
                                            }
                                        }
                                        bdClientes[j].setIdentificacion(identificacion);
                                        bandera = 0;
                                        break;
                                    case "C":
                                        while (sexo.equals("") || !sexo.equals("A") && !sexo.equals("B")) { //pide edad empleado 
                                            sexo = JOptionPane.showInputDialog("Digite el sexo del Cliente:\nA. Masculino\nB. Femenino").toUpperCase();
                                            if (sexo.equals("") || !sexo.equals("A") && !sexo.equals("B")) {// si es null o diferente  a A,B,C entonces da error
                                                JOptionPane.showMessageDialog(null, "OPCION INVALIDA");
                                            }
                                        }
                                        switch (sexo) {
                                            case "A":
                                                sexo = "Masculino";
                                                bdClientes[j].setSexo(sexo);
                                                JOptionPane.showMessageDialog(null, "Sexo editado correctamente");
                                                contHombres++;
                                                contMujeres--;
                                                break;
                                            case "B":
                                                sexo = "Femenino";
                                                bdClientes[j].setSexo(sexo);
                                                JOptionPane.showMessageDialog(null, "Sexo editado correctamente");
                                                contHombres--;
                                                contMujeres++;
                                                break;

                                        }
                                        break;
                                    case "D":
                                        while (!clsF.esNumero(edadS) || !(Integer.parseInt(edadS) >= 18 && Integer.parseInt(edadS) <= 100)) { //Se comprueba si es numero
                                            edadS = JOptionPane.showInputDialog("Digite su edad:");
                                            if (!clsF.esNumero(edadS) || !(Integer.parseInt(edadS) >= 18 && Integer.parseInt(edadS) <= 100)) {
                                                JOptionPane.showMessageDialog(null, "EDAD INVALIDA");
                                            }
                                        }
                                        edad = Integer.parseInt(edadS); //la edadS se convierta a numero
                                        bdClientes[j].setEdad(edad);
                                        JOptionPane.showMessageDialog(null, "Edad editada correctamente");
                                        break;
                                    case "E":
                                        controlador = "";
                                        bandera = 0;
                                        do {
                                            do {
                                                telefono = JOptionPane.showInputDialog("Digite el numero de telefono del cliente: ");
                                                for (int k = 0; k < telefono.length(); k++) { // Ciclo para recorrer desde la posición 2
                                                    if ((int) telefono.charAt(k) > 47 && (int) telefono.charAt(k) < 58) {// Evaluar que esten entre el 0 al 9, ya que se hizo con código ASCII.
                                                        bandera = 1;
                                                    } else {
                                                        bandera = 0;
                                                        JOptionPane.showMessageDialog(null, "!Telefono invalido¡\nDigite un numero de telefono valido");
                                                        break;
                                                    }
                                                }

                                            } while (bandera != 1);
                                            if (contadorC == 0) {
                                                controlador = "Z";
                                            } else {
                                                for (int k = 0; k < contadorC; k++) { // Ciclo para recorrer las posiciones del arreglo.
                                                    if (!telefono.equals(bdClientes[k].getTelefono())) { // Evaluar si hay un numero telefonico igual en los empleados agregados.
                                                        controlador = "Z";
                                                    } else {
                                                        controlador = "";
                                                        JOptionPane.showMessageDialog(null, "! El numero de telefono ya fue registrado ¡\nVerifique eh intente de nuevo");
                                                        bandera = 0;
                                                        break;
                                                    }

                                                }
                                            }
                                        } while (!controlador.equals("Z"));
                                        bdClientes[j].setTelefono(telefono);
                                        bandera = 0;
                                        break;
                                    case "F":
                                        while (tipoDePase.equals("") || !tipoDePase.equals("A") && !tipoDePase.equals("B") && !tipoDePase.equals("C")) {
                                            tipoDePase = JOptionPane.showInputDialog("Selecciones su tipo de pase:"
                                                    + "\nA. Basico"
                                                    + "\nB. Ultra").toUpperCase();
                                        }

                                        switch (tipoDePase) {
                                            case "A": //----PASE BASICO-------
                                                tipoDePase = "Basico";
                                                bdClientes[j].setTipoDePase(tipoDePase);
                                                pago = 10000;
                                                bdClientes[j].setPago(pago);
                                                //---Se crea el cliente-----
                                                bdClientes[j] = new clsCliente(bdClientes[j].getNombreC(), bdClientes[j].getIdentificacion(), bdClientes[j].getSexo(), bdClientes[j].getEdad(), bdClientes[j].getTelefono(), bdClientes[j].getTipoDePase(), null, bdClientes[j].getPago(), null, null, 0, 0, 0, 0, null, 0);
                                                JOptionPane.showMessageDialog(null, "Pase editado correctamente");
                                                bandera = 2;
                                                contCC++;
                                                break;

                                            case "B": //--------PASE MAX------------
                                                tipoDePase = "Max";
                                                bdClientes[j].setTipoDePase(tipoDePase);
                                                pago = 15000;
                                                bdClientes[j].setPago(pago);
                                                //------ASIGNACION DE ENTRENADOR-----------

                                                //----Se crea el cliente-----
                                                bdClientes[j] = new clsCliente(bdClientes[j].getNombreC(), bdClientes[j].getIdentificacion(), bdClientes[j].getSexo(), bdClientes[j].getEdad(), bdClientes[j].getTelefono(), bdClientes[j].getTipoDePase(), bdClientes[j].getEntrenador(), bdClientes[j].getPago(), null, null, 0, 0, 0, 0, null, 0);
                                                JOptionPane.showMessageDialog(null, "Pase editado correctamente");
                                                bandera = 2;
                                                contCC++;
                                                break;
                                        }
                                        break;
                                    case "G":
                                        while (objetivo.equals("") || !objetivo.equals("A") && !objetivo.equals("B") && !objetivo.equals("C")) {
                                            objetivo = clsF.cadena("Digite el objetivo"
                                                    + "\nA. Subir de peso"
                                                    + "\nB. Bajar de peso"
                                                    + "\nC. Mantener peso").toUpperCase();
                                            if (objetivo.equals("") || !objetivo.equals("A") && !objetivo.equals("B") && !objetivo.equals("C")) {
                                                JOptionPane.showMessageDialog(null, "Opcion invalida");
                                            }
                                        }
                                        switch (objetivo) {
                                            case "A":
                                                objetivo = "Subir de peso";
                                                bdClientes[j].setObjetivo(objetivo);
                                                caloriasObjetivo = clsF.CaloriasObjetivo(objetivo, bdClientes[j].getCaloriasDiarias());
                                                bdClientes[j].setCaloriasObjetivo(caloriasObjetivo);

                                                break;
                                            case "B":
                                                objetivo = "Bajar de peso";
                                                bdClientes[j].setObjetivo(objetivo);
                                                caloriasObjetivo = clsF.CaloriasObjetivo(objetivo, bdClientes[j].getCaloriasDiarias());
                                                bdClientes[j].setCaloriasObjetivo(caloriasObjetivo);

                                                break;
                                            case "C":
                                                objetivo = "Mantener de peso";
                                                bdClientes[j].setObjetivo(objetivo);
                                                bdClientes[j].setCaloriasObjetivo(bdClientes[j].getCaloriasDiarias());

                                                break;
                                            default:
                                                break;
                                        }//----FIN OBJETIVO
                                        JOptionPane.showMessageDialog(null, "Objetivo editado correctamente");

                                        break;
                                    case "H":
                                        //-------PesoKg------------
                                        pesoKgS = "";
                                        while (!clsF.esNumero(pesoKgS) || Float.parseFloat(pesoKgS) <= 0) {
                                            pesoKgS = JOptionPane.showInputDialog("Digite su peso en Kg: ");
                                            if (!clsF.esNumero(pesoKgS) || Float.parseFloat(pesoKgS) <= 0) {
                                                JOptionPane.showMessageDialog(null, "Dato invalido");
                                            }
                                        }
                                        pesoKg = Float.parseFloat(pesoKgS);
                                        bdClientes[j].setPesoKg(pesoKg);
                                        caloriasDiarias = clsF.CaloriasDiarias(bdClientes[j].getPesoKg(), bdClientes[j].getEstaturaMts(), bdClientes[j].getEdad(), bdClientes[j].getSexo());
                                        bdClientes[j].setCaloriasDiarias(caloriasDiarias);
                                        bdClientes[j].setCaloriasObjetivo(clsF.CaloriasObjetivo(bdClientes[j].getObjetivo(), bdClientes[j].getCaloriasDiarias()));
                                        int IMC = clsF.IMC(bdClientes[j].getEstaturaMts() / 100, bdClientes[j].getPesoKg());
                                        bdClientes[j].setIMC(IMC);
                                        JOptionPane.showMessageDialog(null, "Peso editado correctamente");

                                        break;
                                    case "I":
                                        estaturaCmS = "";
                                        while (!clsF.esNumero(estaturaCmS) || Float.parseFloat(estaturaCmS) <= 0 && Float.parseFloat(pesoKgS) >= 500) {
                                            estaturaCmS = JOptionPane.showInputDialog("Digite su estatura en cm: ");
                                            if (!clsF.esNumero(estaturaCmS) || Float.parseFloat(estaturaCmS) <= 0) {
                                                JOptionPane.showMessageDialog(null, "Dato invalido");
                                            }
                                        }
                                        estaturaCm = (Float.parseFloat(estaturaCmS));
                                        bdClientes[j].setEstaturaCm(estaturaCm);
                                        caloriasDiarias = clsF.CaloriasDiarias(bdClientes[j].getPesoKg(), bdClientes[j].getEstaturaMts(), bdClientes[j].getEdad(), bdClientes[j].getSexo());
                                        bdClientes[j].setCaloriasDiarias(caloriasDiarias);
                                        bdClientes[j].setCaloriasObjetivo(clsF.CaloriasObjetivo(bdClientes[j].getObjetivo(), bdClientes[j].getCaloriasDiarias()));
                                        IMC = clsF.IMC(bdClientes[j].getEstaturaMts() / 100, bdClientes[j].getPesoKg());
                                        bdClientes[j].setIMC(IMC);
                                        JOptionPane.showInputDialog("Estatura editada correctamente");
                                        break;
                                    case "J":
                                        bandera = 0;
                                        while (bandera != 1) {
                                            mensaje = JOptionPane.showInputDialog("A. Ver rutina \nB. Cambiar Rutina\nS. Salir");
                                            switch (mensaje) {
                                                case "A":
                                                    JOptionPane.showMessageDialog(null, "\nDIAS PARA EJERCITARSE: " + bdClientes[j].rutina.getDiasEjercicio()
                                                            + "\nDIAS DESCANSO: " + bdClientes[j].rutina.getDiasDescanso()
                                                            + "\n---------------------------RUTINA------------------------------------------"
                                                            + "\n" + bdClientes[j].rutina.getEjercicios());
                                                    break;
                                                case "B":
                                                    rutina = new clsRutina();
                                                    clsR.agregarRutina(rutina);
                                                    bdClientes[j].setRutina(rutina);
                                                    JOptionPane.showInputDialog("Rutina editada correctamente");
                                                    break;
                                                case "S":
                                                    bandera = 1;
                                                    break;
                                                default:
                                                    JOptionPane.showMessageDialog(null, "Opcion invalida");
                                                    break;
                                            }
                                        }
                                        break;
                                    case "S":
                                        bandera = 2;
                                        bandera2 = 1;
                                        break;
                                    default:
                                        JOptionPane.showMessageDialog(null, "Opcion invalida");
                                        break;
                                }
                            } while (bandera != 2);
                            break;
                        default:
                            break;
                    }

                }

            } else {
                JOptionPane.showMessageDialog(null, "Cliente inexistente");
            }
        }//fin else

    }//fin editar clientes

    public void eliminarCliente() {
        if (contadorC > 0) {
            String valor = JOptionPane.showInputDialog("Digite la identificación de la persona a eliminar:");
            int posc = -1;
            for (int i = 0; i < contadorC; i++) {
                if (bdClientes[i].getIdentificacion().equalsIgnoreCase(valor)) {
                    posc = i;
                    break;
                }
            }
            if (posc == -1) {
                JOptionPane.showMessageDialog(null, "! No se encontro el numero de identificacion ¡");
            } else {
                String opcion = "";
                while (!opcion.equals("NO")) {
                    opcion = JOptionPane.showInputDialog(null, "Desea eliminar a: " + bdClientes[posc].getNombreC() + "\nSi\nNo").toUpperCase();
                    if (opcion.equals("SI")) {
                        for (int i = posc; i < contadorC - 1; i++) {
                            bdClientes[i] = bdClientes[i + 1];
                        }
                        bdClientes[contadorC] = null;
                        contadorC = contadorC - 1;
                        JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente");
                        opcion = "NO";
                    } //  if 
                }// WHILE 
            } // encontro la identificacion else
        } else {
            JOptionPane.showMessageDialog(null, "No hay empleados registrados");
        }
    } // fin del metodo eliminar cliente

    public void BuscarCliente() {
        String identificacion = "";
        String salir = "";
        int bandera = 0;
        int j = 0;
        String tipoPase = "";

        if (contadorC > 0) {
            do {
                identificacion = JOptionPane.showInputDialog("Digite la identificacion del cliente");

                for (int i = 0; i < contadorC; i++) {
                    if (bdClientes[i].getIdentificacion().equals(identificacion)) {
                        bandera = 1;
                        j = i;
                        tipoPase = bdClientes[j].getTipoDePase();

                    }
                }

                if (bandera == 1) {
                    String pase = bdClientes[j].getTipoDePase();//se copia el tipo de pase del cliente
                    switch (tipoPase) {

                        case "Basico":
                            /*se ejecuta la funcion eviando los parametros
                            bdCliente
                            el numero de cliente
                            tipo de pase
                             */

                            clsF.impListaClientes(bdClientes, j, pase);
                            break;
                        case "Max":
                            clsF.impListaClientes(bdClientes, j, pase);
                            break;
                        case "Ultra":
                            clsF.impListaClientes(bdClientes, j, pase);
                            break;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "! Identificacion no encontrada ¡");
                }

                do {
                    salir = JOptionPane.showInputDialog(" Desea buscar otro cliente:\nSi\nNo").toUpperCase();
                    if (salir.equals("NO") || salir.equals("SI")) {

                    } else {
                        JOptionPane.showMessageDialog(null, "! Opcion no valilda ¡\nDigite una opcion correcta");
                    }
                } while (!salir.equals("NO") && !salir.equals("SI"));

            } while (!salir.equals("NO"));
        } else {
            JOptionPane.showMessageDialog(null, "No hay empleados registrados");
        }//fin clsClientes
    }

    public void listarClientes() {

        //---comprobacion de cantidad de clientes
        if (contadorC > 0) {
            //-------MENSAJE QUE INDICA CUANTOS CLIENTES HAY
            clsF.imprimeMensaje("Se encuentran registrados: " + contadorC);

            //-------------LISTAR CLIENTES
            for (int v = 0; v < contadorC; v++) {

                //--SI EL CLIENTE ES PASE BASICO---------
                if (bdClientes[v].getTipoDePase().equals("Basico")) {
                    //-------se copia en variable tmp el tipo de pase del cliente
                    String pase = bdClientes[v].getTipoDePase();
                    /*------------------
                    SE EJECUTA LA FUNCION MANDANDO POR PARAMETROS
                    BDCleinte, el numero cliente y el tipo de pase*/
                    clsF.impListaClientes(bdClientes, v, pase);

                } //--SI EL CLIENTE ES PASE MAX-------
                else if (bdClientes[v].getTipoDePase().equals("Max")) {
                    String pase = bdClientes[v].getTipoDePase();
                    clsF.impListaClientes(bdClientes, v, pase);
                } //---SI EL CLIENTE ES PASE ULTRA-----
                else {
                    String pase = bdClientes[v].getTipoDePase();
                    clsF.impListaClientes(bdClientes, v, pase);
                }

            }//--FIN FOR LISTAR

        } else {
            clsF.imprimeMensaje("NO es posible crear una lista ya que no existen\nclientes creados");
        }

    }//---FIN LISTAR CLIENTES

}//FIN CLASE CLIENTES
