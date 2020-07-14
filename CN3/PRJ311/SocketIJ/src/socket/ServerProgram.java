/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerProgram {

    public static void main(String[] args) throws IOException {
        ServerSocket listener = null;
        int clientNumber = 0;
// Mở một ServerSocket tại cổng 7777.
        try {
            listener = new ServerSocket(7777);
            System.out.println("Server is waiting to accept user...");
        } catch (IOException e) {
            System.out.println(e);
            System.exit(1);
        }
        try {
            while (true) {
// Chấp nhận một yêu cầu kết nối từ phía Client.
// Đồng thời nhận được một đối tượng Socket tại server.
                ServiceThread st = new ServiceThread(listener.accept(), clientNumber++);
                st.start();
            }
        } finally {
            listener.close();
        }
    }

}
