package pl.oszewczak.problemsolving.magicsquare;

import java.io.*;
import java.util.List;

public class MagicSquareSerializer {

    public void serialize(List<List<List<Integer>>> magicSquares) {
        String filePath = MagicSquareSerializer.class.getResource("/resources/magicSquares.txt").getPath();
//        String resourcesPath = MagicSquareGeneratorImpl.class.getClassLoader().getResource("").getPath();
//        String fileName = "magicSquares.txt";
//        String filePath = resourcesPath + File.separator + fileName;
        try (
                FileOutputStream fileOutputStream = new FileOutputStream(filePath);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        ) {
            objectOutputStream.writeObject(magicSquares);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
