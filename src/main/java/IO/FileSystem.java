package IO;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

public class FileSystem {
    // Constructor privado para prevenir la instanciación de la clase
    private FileSystem() {
        throw new IllegalStateException("Clase de utilidad");
    }

    // Método para obtener la URL dentro de la carpeta de recursos dado su ruta relativa
    public static URL getResourceURL(String relativePath) {
        return FileSystem.class.getResource(relativePath);
    }

    // Método para obtener un inputStream a partir de un fichero dentro de la carpeta de recursos dado su ruta relativa
    public static InputStream getResourceStream(String relativePath) {
        return FileSystem.class.getResourceAsStream(relativePath);
    }

    // Método para obtener un inputStream a partir de un fichero dentro de la carpeta de recursos dado su ruta absoluta
    public static InputStream getFicheroArchivoAbsoluto(String absPath) throws FileNotFoundException {
        return new FileInputStream(absPath);
    }

    // Método para obtener un BufferedReader dentro de la carpeta de recursos dado su ruta relativa
    public static BufferedReader getResourceBReader(String relativePath) {
        return new BufferedReader(new InputStreamReader(FileSystem.class.getResourceAsStream(relativePath)));
    }

    // Método para obtener las rutas de los archivos dentro de la carpeta de recursos dado su ruta relativa
    public static Path[] getFPathsFromResourceFolder(String folderRelPath) {
        Path[] paths = null;

        try {
            String[] stringPaths = getResourceURL(folderRelPath).toURI().toString().split("!");
            URI uri = URI.create(stringPaths[0]);
            Path folder;
            folder = Path.of(uri);
            paths = getFolderPaths(folder);
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }

        return paths;
    }

    // Método privado para obtener las rutas de los archivos de un directorio dado su Path
    private static Path[] getFolderPaths(Path folder) throws IOException {
        Path[] finalPaths;

        try (Stream<Path> paths = Files.list(folder)) {
            Path[] temporalPaths = paths.sorted().toArray(Path[]::new);
            finalPaths = new Path[temporalPaths.length];

            for (int i = 0; i < temporalPaths.length; i++) {
                String temporalPathAsString = temporalPaths[i].toString();
                String finalPathAsString = temporalPathAsString;
                int index = temporalPathAsString.lastIndexOf("/classes");

                if (temporalPathAsString.contains("/classes")) {
                    finalPathAsString = temporalPathAsString.substring(index + 8);
                }

                finalPaths[i] = Path.of(finalPathAsString);
            }
        }

        return finalPaths;
    }

    public static void writeToFile(String path, String[] lines) {
        try (FileWriter myWriter = new FileWriter(path)) {
            for (String line : lines) myWriter.write(line + "\n");
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

