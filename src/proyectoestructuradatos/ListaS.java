package proyectoestructuradatos;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Node;

public class ListaS  {
    private Nodo primero;
    private Nodo ultimo;
    private int tamano;
    private static String datos, nombre, info, nota, str;
    
    public ListaS() {
        this.primero = null;
        this.ultimo = null;
        this.tamano = 0;
    }

    public boolean siVacio() {
        if (this.primero == null) {
            return true;
        } else {
            return false;
        }
    }

    public int agregarAlumno(String datos) 
    {
        if (siVacio()) 
        {
            Nodo nuevo = new Nodo(datos);
            primero = nuevo;
            ultimo = nuevo;
            nuevo.nodoDer = nuevo;
        } else {
            Nodo nuevo = new Nodo(datos);
            nuevo.nodoDer = null;
            ultimo.nodoDer = nuevo;
            ultimo = nuevo;
        }
        tamano++;
        return tamano;
    }

    public void eliminarAlumno(String ID) {
        if (tamano != 0) {
            Nodo indice = primero;
            Nodo anterior = null;
            String[] datosIndice = indice.dato.split(" ");
            String[] datosUltimo = ultimo.dato.split(" ");
            if (datosIndice[0].equals(ID)) {
                anterior = indice.nodoDer;
                primero = anterior;
                tamano -= 1;
            } else {
                for (int i = 0; i < tamano; i++) {
                    if (datosIndice[0].equals(ID)) {
                        if (datosIndice[0].equals(ID) && datosUltimo[0].equals(ID)) {
                            anterior.nodoDer = null;
                            ultimo = anterior;
                        } else {
                            anterior.nodoDer = indice.nodoDer;
                        }
                        this.tamano -= 1;
                        break;
                    } else {
                        anterior = indice;
                        indice = indice.nodoDer;
                        datosIndice = indice.dato.split(" ");
                    }
                }
                System.out.println("No se encontro alumno");
            }
        } else {
            System.out.println("No existe ningún alumno\n");
        }
    }

    public String DevolverNotaMasAlta(String [] notas){
        String NotaMasAlta=" ";
        int NotaGuia=0;
        for (int i = 0; i < notas.length; i++) {
            int Nota1 = Integer.parseInt(notas[i]);
            if(NotaGuia<Nota1){
                NotaMasAlta=Integer.toString(Nota1); //se le asigna la nota mas alta
                NotaGuia=Nota1;
            }  
        }
        return NotaMasAlta;
    }
    public String DevolverNotaMasBaja(String [] notas){
        String NotaMasBaja=" ";
        int NotaGuia=100;
        for (int i = 0; i < notas.length; i++) {
            int Nota1 = Integer.parseInt(notas[i]);
            if(NotaGuia>Nota1){
                NotaMasBaja=Integer.toString(Nota1); //se le asigan al mas baja
                NotaGuia=Nota1;
            }  
        }
        return NotaMasBaja;
    }
    public String PromedioNotas(String [] notas){
        String PromedioNotas=" ";
        int Div=0;
        int SumaNotas=0;
        for (int i = 0; i < notas.length; i++) {
            SumaNotas += Integer.parseInt(notas[i]);//Va sumando las notas
            Div=Div+1; // el divisor que va contando cuantas notas hay en la lista
        }
        PromedioNotas=Integer.toString(SumaNotas / Div);//Se le asigna el promedio
        return PromedioNotas;
    }
    public String consultarNota(String ID){
        if (tamano != 0) {
            Nodo temp = primero;
            String[] datosAlumno = temp.dato.split(" ");
            
            for (int i = 0; i < tamano; i++) {
                if (ID.equals(datosAlumno[0])) {
                    return datosAlumno[3];//Nota del alumno
                } else{
                    temp = temp.nodoDer;
                    datosAlumno = temp.dato.split(" ");
                }
            }
        } else{
            return "Lista vacia";
        }
        return "No existe ese ID";
    }

    public Nodo[] Completar(String dato) {
        Nodo[] nodos = new Nodo[4];
        Nodo indice = primero;
        int contador = 0;
        
        while (indice != null && contador < 4) {
            String[] datosIndice = indice.dato.split(" ");
            
            if (datosIndice[0].equals(dato)) {
                nodos[0] = indice;
                
                for (int i = 1; i < 4 && indice.nodoDer != null; i++) {
                    indice = indice.nodoDer;
                    nodos[i] = indice;
                }
                String[] datos = nodos[0].dato.split(" ");
                nombre = datos[1] + " " + datos[2];
                nota = datos[3];
                return nodos;
            }
            
            indice = indice.nodoDer;
            contador++;
        }
        
        return null;
    }

    public String imprimir() {
        Nodo temp = primero;
        String str = "";
        if (tamano != 0) {
            for (int i = 0; i < tamano; i++) {
                str = str + temp.dato + "\n";
                temp = temp.nodoDer;
            }

            //JOptionPane.showMessageDialog(null, str);
            
            System.out.println(str);

        }
        return str;
    }
    public static String nombre()
    {
        return nombre;
    }
    public static String nota()
    {
        return nota;
    }
    

    public String[][] obtenerAlumnos(){
        Nodo temp = primero;
        String[][] alumnos = new String[tamano][];

        for (int i = 0; i < tamano; i++) {
            String[] todosLosDatos = temp.dato.split(" ");
            String [] datosEspecificos = {todosLosDatos[0], todosLosDatos[1], todosLosDatos[2]};

            alumnos[i] = datosEspecificos;
            temp = temp.nodoDer;
        }

        return alumnos;
    }

    public String [] nomAlumn()
    {
        String [][] alumnos = obtenerAlumnos();
        String[] nomAlumn = new String[alumnos.length];

        for (int i = 0; i < alumnos.length;i++)
        {
            nomAlumn[i] = alumnos[i][1] + " " + alumnos[i][2];
        }
        return nomAlumn;
    }
    public String [] idAlumn()
    {
        String [][] datos = obtenerAlumnos();
        String[] idAlumn = new String[datos.length];

        for (int i = 0; i < datos.length;i++)
        {
            idAlumn[i] = datos[i][0];
        }
        return idAlumn;
    }

    
}
