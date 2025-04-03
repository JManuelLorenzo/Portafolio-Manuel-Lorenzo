package ejercicio1;


public class ContadorDePalabraEnum {
    public enum estados {
        vocal(0), consonante(0), simbolo(0);

        estados(int i) {
        }
    }

    public void contarVocales(String string) {
        char[] ejemplo = string.toCharArray();
        int counterVocal = 0;
        int counterConsonante = 0;
        estados estadoActual = null;
        String vocales = "aeiuo"; // This could be  an Enum
        for (char letra : ejemplo) {
            estadoActual = null;
            letra = Character.toLowerCase(letra);
            if (Character.isLetter(letra) && vocales.contains(String.valueOf(letra))) {
                estadoActual = estados.vocal;
            } else {
                if (Character.isLetter(letra)) {
                    estadoActual = estados.consonante;
                } else {
                    estadoActual = estados.simbolo;
                }
            }
            if (estadoActual == estados.consonante){counterConsonante ++;}
            if (estadoActual == estados.vocal){counterVocal++;}
            if (estadoActual == estados.simbolo){}// En este caso no nos interesa.
        }
        System.out.println("vocales: "  + counterVocal + " " + "consonantes: " + counterConsonante);
        }

    public static void main(String[] args) {
        ContadorDePalabraEnum contadorDePalabraEnum = new ContadorDePalabraEnum();
        contadorDePalabraEnum.contarVocales("aaa A C cafe"); // 6 vocales y 3 consonantes.
    }
}


