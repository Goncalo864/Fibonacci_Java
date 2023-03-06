import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
public class Main {

    public static ArrayList<Integer> numRandoms(int numIntervalos, ArrayList<Integer> intervalos ){
        ArrayList<Integer> numRandom = new ArrayList<>();
        Random rand = new Random();
        for(int i=0; i < numIntervalos; i++){
            int randomNum = rand.nextInt(intervalos.get(i * 2 + 1) - intervalos.get(i * 2)) + intervalos.get(i * 2);
            numRandom.add(randomNum);
        }
        return numRandom;

    }

    public static ArrayList<Integer> seq_fibonacci(int num_random){
        int intervalos = num_random;

        ArrayList<Integer> seq_fib = new ArrayList<Integer>();
        seq_fib.add(0);
        seq_fib.add(1);

        for(int i =2;i <intervalos; i ++){
            int fib = seq_fib.get(i-1) + seq_fib.get(i - 2);
            seq_fib.add(fib);
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.addAll(seq_fib);
        return result;
    }

    public static ArrayList<Integer> num_impares(ArrayList<Integer> seq_fibonacci) {
        ArrayList<Integer> num_impares = new ArrayList<Integer>();
        for (int x : seq_fibonacci) {
            if (x % 2 == 1) {
                num_impares.add(x);
            }
        }
        return num_impares;
    }
    public static void main(String[] args) {
        int num_intervalos;
        int primeiro_num, segundo_num;
        ArrayList<Integer> intervalos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quantos intervalos quer introduzir? ");
        num_intervalos = scanner.nextInt();

        for(int i=0;i<num_intervalos;i++)
        {
            System.out.printf("Introduza o limite inferior do intervalo %d:  ", i + 1);
            primeiro_num = scanner.nextInt();
            System.out.printf("Introduza o limite superior do intervalo %d: ", i + 1);
            segundo_num = scanner.nextInt();
            if(primeiro_num > segundo_num)
            {
                System.out.println("O segundo numero tem de ser superior ao limite inferior!");
                System.exit(0);
            }
            intervalos.add(primeiro_num);
            intervalos.add(segundo_num);

        }
        System.out.println("Numeros introduzidos: " + intervalos.toString());
        ArrayList<Integer> num_randoms = numRandoms(num_intervalos, intervalos);
        ArrayList<Integer> result = seq_fibonacci(num_randoms.get(0));

        System.out.println("Numeros random dos intervalos: "+ num_randoms);
        result.addAll(num_randoms.subList(1, num_randoms.size()));
        for (int num : num_randoms) {
            ArrayList<Integer> fib_seq = seq_fibonacci(num);
            System.out.printf("Sequencia de fibonacci de %d: %s\n", num, fib_seq.toString());
            ArrayList<Integer> q_impares = num_impares(fib_seq);
            System.out.printf("Numero de impares: %s\n", q_impares);


        }

    }
}
