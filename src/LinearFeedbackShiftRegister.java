import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LinearFeedbackShiftRegister {
    private static void inicializar(boolean[] registrador, String chave) {
        // pegar uma letra de cada vez ( 32 bits = 4 bytes)
        for (int i = 0; i < 4; i++) {
            int decimal = chave.charAt(i);
            String binario = Integer.toBinaryString(decimal);

            // Alinhamento do binario ( 8 bits exatos)
            for (int j = 0; j < (8 - binario.length()); j++) {
                binario = ( "0" + binario);
            }
            //Percorre os 8 bits da string binario
            for (int j = 0; j < 8; j++) {
                // posição exata no registrador usando: j + (8 * i)
                registrador[j + (8 * i)] = (binario.charAt(j) == '1');
            }
        }
    }
    private static boolean rotacionar(boolean[] registrador, boolean tipo) {
        boolean retorno = registrador[0];
        boolean novoBit = retorno;
        if (! tipo) {
            novoBit = (novoBit ^ registrador[31] ^ registrador[6] ^
                                 registrador[4] ^ registrador[2] ^
                                 registrador[1] ^ registrador[0]);
        } else {
            novoBit = (novoBit ^ registrador[31] ^ registrador[6] ^
                                 registrador[5] ^ registrador[1]);
        }
        for (int i = 0; i < (registrador.length - 1); i++) {
            registrador[i] = registrador[i + 1];
        }
        registrador[31] = novoBit;

        return retorno;
    }

    public static void main(String[] args) {
        BufferedReader leitor = new BufferedReader(
                                new InputStreamReader(System.in));
        boolean[] cabeca = new boolean[32];
        boolean[] registrador0 = new boolean[32];
        boolean[] registrador1 = new boolean[32];

        try {
            System.out.print("Digite 4 letras da chave: ");
            inicializar(cabeca, leitor.readLine());

            System.out.print("Digite 4 letras da chave: ");
            inicializar(registrador0, leitor.readLine());

            System.out.print("Digite 4 letras da chave: ");
            inicializar(registrador1, leitor.readLine());

        } catch (Exception e) {}

        String letra = "";
        while (true) {
            boolean bit0 = registrador0[0];
            boolean bit1 = registrador1[0];
            if ( ! rotacionar(cabeca, false)) {
                bit0 = rotacionar(registrador0, false);
            } else {
                bit1 = rotacionar(registrador1, true);
            }
            letra += ((bit0 ^ bit1) ? "1" : "0");

            if (letra.length() == 8) {
                System.out.print((char) Integer.parseInt(letra, 2));
                letra = "";
            }
        }
    }
}
