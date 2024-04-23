
import java.util.Random;

public class MeuVetor {
    private double[] v;
    private int ultimaPos;

    public MeuVetor (int capacidade) {
        v = new double[capacidade];
        ultimaPos = -1;
    }
    //métodos de acesso
    public int getUltimaPos() {
        return ultimaPos;
    }
    public double[] getV() {
        return v;
    }
    //métodos modificadores
    public void setUltimaPosicao(int pos) {
        if (pos >= 0 && pos < v.length) {
            ultimaPos = pos;
        }
        else {
            ultimaPos = v.length - 1;
        }
    }

    public boolean estaCheio () {
        return ultimaPos == v.length-1;
    }

    public boolean estaVazio () {
        return ultimaPos == -1;
    }

    public void resetVetor() {
        ultimaPos = -1;
    }

    public void adiciona(int elemento) {
        if (estaCheio()) {
            redimensiona(v.length*2);
        }
        v[++ultimaPos] = elemento;
    }
    public void adiciona (double elemento) {
        if (estaCheio()) {
            redimensiona(v.length*2);
        }
        v[++ultimaPos] = elemento;
    }
    public void adiciona ( double elemento, int posicao) {
        if (estaCheio())
            redimensiona(v.length*2);
        if (posicao > ultimaPos)
            v[++ultimaPos] = elemento;
        else {
            //deslocar elementos
            int i;
            for (i=ultimaPos + 1; i > posicao; i--){
                v[i] = v[i-1];
            }
            v[i] = elemento;
            ultimaPos++;
        }
    }
    public double remove() {
        if (estaVazio()) return 0;
        double aux = v[ultimaPos--];
        if (v.length >= 10 && ultimaPos <= v.length / 4) {
            redimensiona(v.length/2);
        }
        return aux;
    }
    public double remove (int posicao) {
        if (estaVazio() || posicao > ultimaPos) return 0;
        double aux = v[posicao];
        int i;
        for (i = posicao; i > ultimaPos; i++)
            v[i] = v[i+1];
        ultimaPos--;
        if (v.length >= 10 && ultimaPos <= v.length / 4) {
            redimensiona(v.length/2);
        }
        return aux;
    }
    public int remove (double elemento) {
        if (estaVazio()) return 0;
        int cont = 0;
        for (int i=ultimaPos; i>=0; i--){
            if (v[i] == elemento) {
                //remover os elementos da ultima posicao até a primeira
                //arrastar os elementos
                for (int j=i; j<ultimaPos; j++)
                    v[j] = v[j+1];
                ultimaPos--;
                cont++;
            }

        }
        return cont;
    }

    private void redimensiona(int novaCapacidade) {
        double[] temp = new double[novaCapacidade];
        for (int i = 0; i <= ultimaPos; i++) {
            temp[i] = v[i];
        }
        v = temp;
    }

    @Override
    public String toString() {
        String s = "";
        if (estaVazio()) {
            s = s + "vetor vazio";
        }
        else {
            for (int i=0; i <= ultimaPos; i++) {
                s = s + String.format("%.0f ", v[i]);
            }
        }
        s = s + "\n";
        return s;
    }

    public void preencheVetor () {
        Random r = new Random();
        for (int i=0; i<v.length; i++) {
            adiciona(r.nextInt(v.length*10)+1);
        }
    }
    public void preencheVetor (int limite) {
        Random r = new Random();
        for (int i = 0; i<v.length; i++) {
            adiciona(r.nextInt(limite));
        }
    }
    public int bubbleSort() {
        int cont = 0;
        for (int i=1; i<v.length; i++) {
            cont++;
            for (int j=0; j<v.length-i; j++) {
                if (v[j]>v[j+1]) {
                    double aux = v[j+1];
                    v[j] = v[j+1];
                    v[j+1] = aux;
                }
            }
        }
        return cont;
    }
    int partition (int p, int r){
        double x = v[r]; /* O pivô é o último elemento do vetor */
        int i = p-1;
        for(int j = p; j < r; j++){
            if (v[j] <= x){
                i = i + 1;
                double aux = v[i];
                v[i] = v[j];
                v[j] = aux;
            }
        }
        i = i + 1;
        double aux = v[r];
        v[r] = v[i];
        v[i] = aux;
        return i;
    }

    public void quickSort (int p, int r) {
        if (p < r) {
            int q = partition (p, r);
            quickSort(p, q-1);
            quickSort(q+1, r);
        }
    }

    public void insertionSort (int n){
        int j;
        double aux;
        for(int i=1; i < v.length; i++){
            aux = v[i];
            j = i-1; 
            while(j >= 0 && v[j] > aux){
                v[j+1] = v[j];
                j--;
            }
            v[j+1] = aux;
        }
    }
    public static void main(String[] args) {
        int[] vetor = new int[10];
        
        //preenche o vetor com números aleatórios
        for(int i=0; i < vetor.length; i++){
            vetor[i] = (int) (Math.random() * vetor.length);
        }
        
        System.out.println("Desordenado");
        for(int i=0; i < vetor.length; i++){
            System.out.print(vetor[i]);
        }
        
        int aux, j;
        for(int i=1; i < vetor.length; i++){
            aux = vetor[i];
            j = i-1; 
            while(j >= 0 && vetor[j] > aux){
                vetor[j+1] = vetor[j];
                j--;
            }
            vetor[j+1] = aux;
        }
                
        System.out.println("\n\nOrdenado");
        for(int i=0; i < vetor.length; i++){
            System.out.print(vetor[i]);
        }
    }
}
















