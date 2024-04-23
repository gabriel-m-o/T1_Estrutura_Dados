
public class TesteInsertion {
    public static void main(String[] args) {
        MeuVetor vet = new MeuVetor(100);
        vet.preencheVetor();
        System.out.println("vetor desordenado: " + "[" + vet + "]");
        MeuVetor.insertionSort(100, vet);
        
        
        
    }
}
