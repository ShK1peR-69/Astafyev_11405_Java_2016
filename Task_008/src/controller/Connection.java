package controller;

import view.Balda;

import java.io.*;
import java.net.Socket;

/**
 * @author Astafyev Igor
 *         11-405
 *         for Balda
 */

class Connection implements Runnable {
    Socket socket;
    Thread thread;
    Server server;

    public Connection(Server server, Socket socket) {
        this.socket = socket;
        this.server = server;

        thread = new Thread(this);
        thread.start();
    }

    public void run() {
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);

            String start = Balda.startWord();
            Server.panel = Balda.newGame(start, pw);
            pw.println(start);

            while (true) {
                String slovo = bf.readLine();
                int x = Integer.parseInt(bf.readLine());
                int y = Integer.parseInt(bf.readLine());
                String ch = bf.readLine();

                System.out.println(slovo);
                System.out.println(x);
                System.out.println(y);
                System.out.println(ch);

                Server.point++;
                System.out.println();
                System.out.println(Server.point);
                System.out.println();

                Balda.addChar(Server.panel, x, y, ch);
                Balda.gameWords.add(slovo);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}