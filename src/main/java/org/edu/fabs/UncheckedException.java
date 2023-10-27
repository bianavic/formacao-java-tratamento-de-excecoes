package org.edu.fabs;

import javax.swing.*;

public class UncheckedException {

    public static void main(String[] args) {

        /**
         * de acordo com stack trace, erro estourou na linha 17
         * onde farei o try catch
         */

        String a = JOptionPane.showInputDialog("Numerador: ");
        String b = JOptionPane.showInputDialog("Denominador: ");

        try {
            int resultado = dividir(Integer.parseInt(a), Integer.parseInt(b));
            System.out.println("Resultado: "+ resultado);
        } catch (NumberFormatException e) {
            // esta msg para o usuario é só como exe, nao uma recomendacao
            JOptionPane.showMessageDialog(null, "entrada inválida, informe um numero inteiro " + e.getMessage());
//            e.printStackTrace(); // -> pede para imprimir o erro
        } catch (ArithmeticException e) {
            JOptionPane.showMessageDialog(null, "impossivel dividir um numero por zero " + e.getMessage());
        }
        finally {
            System.out.println("chegou no finally...");
        }

        System.out.println("o código continua... ");
    }

    // static: podem ser acessados diretamente da definição da classe, sem precisar instanciar nenhum objeto
    public static int dividir(int a, int b) {
        return a / b;
    }

}
