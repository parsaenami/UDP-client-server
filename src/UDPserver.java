import java.io.IOException;
import java.net.*;

/**
 * Created by eisak on 2018-12-17.
 */
public class UDPserver {

    private DatagramSocket ds;

    public UDPserver(int port1, int port2) {

        try {
            ds = new DatagramSocket(port1);
        } catch (SocketException e) {
            e.printStackTrace();
        }

        String str = "Welcome java";
        InetAddress ip = null;
        try {
            ip = InetAddress.getByName("127.0.0.1");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        DatagramPacket dp = new DatagramPacket(str.getBytes(), str.length(), ip, port2);
        try {
            ds.send(dp);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ds.close();
    }

    public static void main(String[] args) throws Exception {

    }
}

