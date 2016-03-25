package controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import view.Balda;

import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Astafyev Igor
 *         11-405
 *         for Balda
 */

@Component
public class Client extends JFrame {
    static ApplicationContext ac = new AnnotationConfigApplicationContext(JavaConfig.class);
    static int port = 3456;
    public static JPanel panel;
    public static int point = 0;

    public static void main(String[] args) throws IOException {
        Scanner scan = ac.getBean(Scanner.class);
        System.out.print("Введите ip-адрес Сервера: ");
        String address = scan.nextLine();
        Socket s = new Socket(address, port);
        BufferedReader bf = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter pw = new PrintWriter(s.getOutputStream(), true);

        String starting = bf.readLine();
        panel = Balda.newGame(starting, pw);

        while (true) {
            String slovo = bf.readLine();
            int x = Integer.parseInt(bf.readLine());
            int y = Integer.parseInt(bf.readLine());
            String b = bf.readLine();

            System.out.println(slovo);
            System.out.println(x);
            System.out.println(y);
            System.out.println(b);

            Balda.addChar(panel, x, y, b);
            Balda.gameWords.add(slovo);

        }
    }
}