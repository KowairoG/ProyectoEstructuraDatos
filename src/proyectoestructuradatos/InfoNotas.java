package proyectoestructuradatos;


public class InfoNotas extends ListaS {
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
}
