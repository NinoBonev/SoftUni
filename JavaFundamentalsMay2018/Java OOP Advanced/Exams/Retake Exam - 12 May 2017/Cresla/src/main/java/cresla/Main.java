package cresla;

import cresla.interfaces.InputReader;
import cresla.interfaces.Manager;
import cresla.interfaces.OutputWriter;
import cresla.io.ConsoleReader;
import cresla.io.ConsoleWriter;
import cresla.manager.Engine;
import cresla.manager.ManagerImpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        OutputWriter writer = new ConsoleWriter();
        InputReader reader = new ConsoleReader(new BufferedReader(new InputStreamReader(System.in)));
        Manager manager = new ManagerImpl();
        Engine engine = new Engine(writer, reader, manager);

        engine.run();
    }
}
