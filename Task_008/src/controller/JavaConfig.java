package controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Astafyev Igor
 *         11-405
 */

@Configuration
public class JavaConfig {
    final static int PORT = 3456;

    @Bean
    public Socket socket(){
        return new Socket();
    }

    @Bean
    public Socket s(){
        return new Socket();
    }

    @Bean
    public ServerSocket serverSocket() throws IOException {
        return new ServerSocket(PORT);
    }

    @Bean
    public Server server() throws IOException {
        return new Server();
    }

    @Bean
    public Scanner scanner(){
        return new Scanner(System.in);
    }

}
