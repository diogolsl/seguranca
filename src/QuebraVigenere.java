public class QuebraVigenere {

private static final String CRIPTOGRAMA = "";

    public static void main(String[] args) {
        for (int tamanhoChave = 1; tamanhoChave <= 20 ; tamanhoChave++ ) {
            System.out.println("===========================");
            System.out.println("Testando chave de tamanho: " + tamanhoChave);

            for (int numeroConjunto = 0; numeroConjunto < tamanhoChave; numeroConjunto++) {
                int[] vetorOcorrencias = new int[256];

                int letraMaior = 0;
                int ocorrenciaMaior = 0;
                for (int i = 0; i < CRIPTOGRAMA.length(); i+= 2) {

                    if (((i/2) % tamanhoChave) == numeroConjunto) {
                        int letra = Integer.parseInt(CRIPTOGRAMA.substring(i, i + 2), 16);
                        vetorOcorrencias[letra]++;
                        if (vetorOcorrencias[letra] > ocorrenciaMaior) {
                            letraMaior = letra;
                            ocorrenciaMaior = vetorOcorrencias[letra];
                        }
                    }
                }
                System.out.print((char) (letraMaior ^ 32));
            }
            System.out.println();
        }
    }
}
