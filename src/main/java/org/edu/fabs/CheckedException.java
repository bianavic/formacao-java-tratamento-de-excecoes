package org.edu.fabs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

// o compilador indica que só conseguiremos rodar a classe se resolvermos essas exceptions
public class CheckedException {

    // imprimir arquivo no console
    public static void main(String[] args) {

        String nomeDoArquivo = "romances-blake-crouch.txt";
        try {
            imprimirArquivoNoConsole(nomeDoArquivo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("apesar da exception ou não, o programa continua...");
    }

    // lanca a exception na assinatura do metodo, mas ainda nao resolveu
    // sera resolvido no metodo main, pq é quem chama o metodo que resolve a exception
    public static void imprimirArquivoNoConsole(String nomeDoArquivo) throws IOException {
        File file = new File(nomeDoArquivo);

        // padrao decorator
        BufferedReader br = new BufferedReader(new FileReader(file.getName()));
        String line = br.readLine();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        do {
            bw.write(line);
            bw.newLine();
            line = br.readLine();
        } while (line != null);
        bw.flush(); // pede para descarregar no console, pq esta armazenado num buffer
        br.close();
    }

}
