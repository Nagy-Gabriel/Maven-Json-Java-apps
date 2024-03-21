package org.example;

import java.io.File;

import java.io.IOException;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Main {
    public static void scriere(List<Persoana> lista) {
        try {
            ObjectMapper mapper=new ObjectMapper();
            File file=new File("src/main/resources/persoane.json");
            mapper.writeValue(file,lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Persoana> citire() {
        try {
            File file=new File("src/main/resources/persoane.json");
            ObjectMapper mapper=new ObjectMapper();
            List<Persoana> persoane = mapper
                    .readValue(file, new TypeReference<List<Persoana>>(){});
            return persoane;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        List<Persoana> persoane=citire();
        System.out.println(persoane);
        for(Persoana p:persoane){
            System.out.println(p);
        }
        persoane.add(new Persoana("Maria",33));
        scriere(persoane);
    }
}