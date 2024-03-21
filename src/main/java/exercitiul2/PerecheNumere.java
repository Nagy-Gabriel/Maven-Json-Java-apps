package exercitiul2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class PerecheNumere {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int opt;
        String a;
        do {
            System.out.println("1. Citire din fișier JSON");
            System.out.println("2. Salvare în fișier JSON");
            System.out.println("0. Ieșire");

            a = in.readLine();
            opt = Integer.parseInt(a);

            switch (opt) {
                case 1:
                    List<PerecheNumere> listaCitita = citire();
                    if (listaCitita != null) {
                        System.out.println("Lista citita din fișier JSON:");
                        for (PerecheNumere pereche : listaCitita) {
                            System.out.println(pereche);
                            System.out.println("Sunt consecutive in Fibonacci: " + pereche.suntConsecutiveInFibonacci());
                            System.out.println("Cel mai mic multiplu comun: " + pereche.celMicMultipluComun());
                            System.out.println("Suma cifrelor egala: " + pereche.sumaCifrelorEgala());
                            System.out.println("Numar cifre pare egale: " + pereche.numarCifrePareEgale());
                            System.out.println();
                        }
                    }
                    break;
                case 2:
                    List<PerecheNumere> lista = new ArrayList<>();
                    lista.add(new PerecheNumere(2,3));
                    scriere(lista);
                    break;
                case 0:
                    System.out.println("Optiunea nu exista sau ai inchis programul!");
                    break;
                default:
                    System.out.println("Optiune invalida!");
            }
        } while (opt != 0);
    }
    private int numar1;
    private int numar2;



    public PerecheNumere() {
    }

    public PerecheNumere(int numar1, int numar2) {
        this.numar1 = numar1;
        this.numar2 = numar2;
    }

    public int getNumar1() {
        return numar1;
    }

    public void setNumar1(int numar1) {
        this.numar1 = numar1;
    }

    public int getNumar2() {
        return numar2;
    }

    public void setNumar2(int numar2) {
        this.numar2 = numar2;
    }

    @Override
    public String toString() {
        return "(" + numar1 + ", " + numar2 + ")";
    }

    public boolean suntConsecutiveInFibonacci() {
        if (Math.abs(numar1 - numar2) != 1) {
            return false;
        }

        int minNumar = Math.min(numar1, numar2);
        int maxNumar = Math.max(numar1, numar2);

        int fib1 = 0;
        int fib2 = 1;
        while (fib2 < maxNumar) {
            int nextFib = fib1 + fib2;
            fib1 = fib2;
            fib2 = nextFib;
        }

        // Dacă cel mai mare numar este un numar Fibonaccisi diferenta dintre cele două numere este 1,
        // atunci cele doua numere sunt consecutive in sirul lui Fibonacci
        return fib2 == maxNumar;
    }

    public int celMicMultipluComun() {
        int a = numar1;
        int b = numar2;
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return numar1 * (numar2 / a);
    }

    public boolean sumaCifrelorEgala() {
        int suma1 = 0, suma2 = 0;
        int n = numar1, m = numar2;
        while (n > 0) {
            suma1 += n % 10;
            n =n/ 10;
        }
        while (m > 0) {
            suma2 += m % 10;
            m=m/ 10;
        }
        return suma1 == suma2;
    }

    public boolean numarCifrePareEgale() {
        int cifrePareNumar1 = 0, cifrePareNumar2 = 0;
        int n = numar1, m = numar2;
        while (n > 0) {
            if ((n % 10) % 2 == 0) {
                cifrePareNumar1++;
            }
            n = n / 10;
        }
        while (m > 0) {
            if ((m % 10) % 2 == 0) {
                cifrePareNumar2++;
            }
            m = m / 10;
        }
        return cifrePareNumar1 == cifrePareNumar2;
    }


    public static void scriere(List<PerecheNumere> lista) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File("src\\main\\resources\\perechiNumere.json");
            mapper.writeValue(file, lista);
            System.out.println("Lista perechilor de numere a fost salvata in fisierul JSON.");
        } catch (IOException e) {
            System.err.println("Eroare la scrierea in fisierul JSON: " + e.getMessage());
        }
    }

    public static List<PerecheNumere> citire() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File("src\\main\\resources\\perechiNumere.json");
            List<PerecheNumere> lista = mapper.readValue(file, new TypeReference<List<PerecheNumere>>() {});
            System.out.println("Lista perechilor de numere a fost incarcata din fisierul JSON.");
            return lista;
        } catch (IOException e) {
            System.err.println("Eroare la citirea din fisierul JSON: " + e.getMessage());
            return null;
        }
    }
}
