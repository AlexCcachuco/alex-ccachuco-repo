import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Path myPath = Paths.get("C:/Users/robertoalexander.cca/FormacionJava/alex-ccachuco-repo/block1-process-file-and-streams/src/people.csv");
        try {
            read_File(myPath);
        } catch (InvalidLineFormatException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void read_File(Path ruta) throws InvalidLineFormatException, IOException {

        BufferedReader reader = Files.newBufferedReader(ruta);
        String line = reader.readLine();

        ArrayList<Person> listaPersonas = new ArrayList<Person>();

        while (line != null) {
            listaPersonas.add(checkLine(line));
            line = reader.readLine();
        }
        // Imprime lista normal de las persona
        // listaPersonas.forEach(System.out::println);

        System.out.println("FILTRO MENOR DE 25");
        filterPersonByAge(listaPersonas);
        System.out.println("FILTRO LETRA A");
        deleteByLetter(listaPersonas);
        System.out.println("FILTRO DE MADRID");
        filterByMadrid(listaPersonas);
        System.out.println("FILTRO DE BARCELONA");
        filterByBarcelona(listaPersonas);

    }

    public static Person checkLine(String line) throws InvalidLineFormatException {

        long count = line.chars().filter(ch -> ch == ':').count();

        if (count == 2) {
            String[] datas = line.split(":");

            if (datas[0].isBlank() || datas[0].isEmpty()) {
                throw new InvalidLineFormatException("El nombre es obligatorio");
            } else if (datas[2].isBlank() || datas[2].isEmpty()) {
                datas[2] = "0";
            }

            Person persona = new Person();
            persona.setName(datas[0]);
            persona.setTown((datas[1].isBlank()) ? "unknown": datas[1]);
            persona.setAge(Integer.parseInt(datas[2]));

            return persona;

        } else {
            throw new InvalidLineFormatException("Formato no aceptado");
        }

    }

    public static void filterPersonByAge(ArrayList<Person> listaPersonas) {
        List<Person> listPersonFiltred = listaPersonas.stream()
                .filter(e -> e.getAge() < 25 && e.getAge() > 0).collect(Collectors.toList());
        // Imprime lista solo menores de 25
        listPersonFiltred.forEach(System.out::println);

    }
    public static void deleteByLetter(ArrayList<Person> listaPersonas){
            List<Person> listPersonFiltred = listaPersonas.stream()
                    .filter(e -> !e.getName().startsWith("A")).collect(Collectors.toList());
            listPersonFiltred.forEach(System.out::println);
    }

    public static void filterByMadrid(ArrayList<Person> listaPersonas){
        Optional<Person> persona = listaPersonas.stream().filter(e -> e.getTown().equals("Madrid")).findFirst();
         System.out.println(persona.toString());
    }

    public static void filterByBarcelona(ArrayList<Person> listaPersonas){
        Optional<Person> persona = listaPersonas.stream().filter(e -> e.getTown().equals("Barcelona")).findFirst();
        System.out.println(persona.toString());
    }
}

