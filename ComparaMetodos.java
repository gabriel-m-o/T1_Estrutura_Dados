import java.util.Date;
import java.util.Scanner;
public class ComparaMetodos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MeuVetor v;
        long ini, fim;
        System.out.print("escolha o tamanho do vetor: ");
        int tamanho = scanner.nextInt();

        v = new MeuVetor(tamanho);
        v.preencheVetor(tamanho * 10);
        ini = new Date().getTime();
        v.bubbleSort();
        fim = new Date().getTime();
        System.out.println("bubble demorou " + (fim-ini)*1000 + " ms");

        v.preencheVetor(tamanho);
        ini = new Date().getTime();
        v.insertionSort(tamanho);
        fim = new Date().getTime();
        System.out.println("insertion demorou " + (fim-ini) + " ms");
        System.out.println("escolha o tamanho do vetor: ");
        tamanho = scanner.nextInt(); 
        scanner.close();
    }
}
