package colaPrioridad;

import java.util.Date;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        Date f1 = new Date(30, 10, 2015, 15, 30, 00);
        Date f2 = new Date(31, 10, 2015, 15, 30, 00);
        Date f3 = new Date(29, 10, 2015, 15, 30, 00);

        System.out.println("f1 c f2: " + f1.compareTo(f2));
        System.out.println("f1 c f3: " + f1.compareTo(f3));
        System.out.println("f1 c f1: " + f1.compareTo(f1));
        
        DateFormat formato = new SimpleDateFormat("dd/MM/yyy HH:mm");
        try {
            colaP.insertarFechaPrincipio((Date) formato.parse("30/10/2015 15:30"));
            colaP.insertarFechaFinal((Date) formato.parse("31/10/2015 15:30"));
            colaP.insertarFechaFinal((Date) formato.parse("01/11/2015 15:30"));
        } catch (ParseException ex) {
            System.out.println("ex:" + ex);
        }


        ColaPrioridad colaP = new ColaPrioridad();
        boolean salir = false;
        while (salir != true) {
            try {
                int op = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1.Agregar tarea\n"
                        + "2.Consultar el primer dato\n"
                        + "3.Extraer primer dato y aplazarlo antes de insertarlo\n"
                        + "4.Guardar\n"
                        + "5.Leer\n------------------------------------\n"
                        + "6.Imprimir Tareas de todas las fechas\n"
                        + "7.Imprimir Tareas de una fecha en especifico\n"
                        + "8.Salir\n", "Cola de prioridad v1.1", 3));
                switch (op) {
                    case 1:
                        try {
                            colaP.agregarTarea();
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                        break;
                    case 2:
                        colaP.consultarPrimerDato();
                        break;
                    case 3:
                        colaP.actualizarPrimerDato();
                        break;
                    case 4:

                        break;
                    case 5:

                        break;
                    case 6:
                        JOptionPane.showMessageDialog(null, colaP.imprimirListaTareas(), "Lista de todas las tareas", 1);
                        break;
                    case 7:
                        Date fechaAux = new Date();
                        //ParseException ex
                        DateFormat.getInstance().parse(JOptionPane.showInputDialog(null, "Ingrese la fecha", "Imprimir Lista de tareas de una fecha", 3));
                        JOptionPane.showMessageDialog(null, colaP.imprimirListaTareas(), "Lista de todas las tareas", 1);
                        break;
                    case 8:
                        salir = true;
                        break;
                    default:
                        break;
                }
            } catch (java.lang.NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Solo numeros enteros", "Error", 0);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, ex, "Error", 0);
            }
        }
    }
}
