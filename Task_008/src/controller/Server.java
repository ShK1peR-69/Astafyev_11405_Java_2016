package controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * @author Astafyev Igor
 *         11-405
 *         for Balda
 */

@Component
public class Server extends JFrame {
    static ApplicationContext ac = new AnnotationConfigApplicationContext(JavaConfig.class);

    public static JPanel panel;
    final static int PORT = 3456;
    ArrayList<Connection> connections;
    public static int point = 0;

    public Server() throws IOException {
        connections = new ArrayList<Connection>();
        go();
    }

    public void go() throws IOException {
        ServerSocket s1 = ac.getBean(ServerSocket.class);
        while (true) {
            System.out.println();
            System.out.println("Starting Server.");
            System.out.print("Waiting for connection..");
            Socket client = s1.accept();
            connections.add(new Connection(this, client));
            System.out.println("Success!");
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        Server serv = ac.getBean(Server.class);
    }
}