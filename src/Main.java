import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Converter converter = new Converter();

        System.out.println("Bem vindo ao conversor de moedas!");

        Scanner scanner = new Scanner(System.in);
        int operation = 0;
        String original = "";
        String goal = "";

        while (operation != 10){
            System.out.println("Escolha as opções de 1 a 10 para conversão");
            System.out.println("1) Real Brasileiro para Dólar Americano");
            System.out.println("2) Franco Suiço para Iene Japonês");
            System.out.println("3) Libra Esterlina para Euro");
            System.out.println("4) Dólar Australiano para Rúpia Indiana");
            System.out.println("5) Coroa Dinamarquesa para Coroa Norueguesa");
            System.out.println("6) Zloty para Rand");
            System.out.println("7) Dólar Neozelandês para Dólar Canadense");
            System.out.println("8) Peso Argentino para Peso Chileno");
            System.out.println("9) Dram Armênio para Dinar Argelino");
            System.out.println("10) Sair");

            try {
                operation = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Insira um número inteiro de 1 a 10.");
                scanner.next();
                continue;
            }

            if(operation >= 10){
                break;
            }

            switch(operation){
                case 1:
                    original = "BRL";
                    goal = "USD";
                    break;
                case 2:
                    original = "CHF";
                    goal = "JPY";
                    break;
                case 3:
                    original = "GBP";
                    goal = "EUR";
                    break;
                case 4:
                    original = "AUD";
                    goal = "INR";
                    break;
                case 5:
                    original = "DKK";
                    goal = "NOK";
                    break;
                case 6:
                    original = "PLN";
                    goal = "ZAR";
                    break;
                case 7:
                    original = "NZD";
                    goal = "CAD";
                    break;
                case 8:
                    original = "ARS";
                    goal = "CLP";
                    break;
                case 9:
                    original = "AMD";
                    goal = "DZD";
                    break;
                default:
                    System.out.println("Este não é um código válido, escolha de 1 a 10");
            }
            double conversionRate;
            double value;
            conversionRate = converter.getValue(original, goal);
                System.out.println("Digite o valor a ser convertido, usando vírgula para números decimais:");
            try {
                value = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Insira um valor número decimal, não esqueça de usar vírgula caso necessário.");
                scanner.next();
                continue;
            }
                System.out.println("O valor "+ value + " convertido de ["+original+"] para ["+goal+"] é " + (value*conversionRate));
                System.out.println();

        }

    }
}