package pl.oszewczak;

import pl.oszewczak.problemsolving.magicsquare.MagicSquareGeneratorImpl;
import pl.oszewczak.problemsolving.magicsquare.MagicSquareSerializer;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<List<Integer>>> magicSquares = MagicSquareGeneratorImpl.generateAllValidSquares();
        new MagicSquareSerializer().serialize(magicSquares);
    }
}