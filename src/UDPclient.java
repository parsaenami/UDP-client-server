import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by eisak on 2018-12-17.
 */
public class UDPclient {

    private DatagramSocket ds;

    public UDPclient(int port) {
        try {
            ds = new DatagramSocket(port);
            ds.setBroadcast(true);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        byte[] buf = new byte[1024];
        DatagramPacket dp = new DatagramPacket(buf, 1024);
        try {

            boolean a = ds.getBroadcast();
            System.out.println("laksjdh" + a);
            ds.receive(dp);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String str = new String(dp.getData(), 0, dp.getLength());
        System.out.println(dp);
        ds.close();
    }


    public static void main(String[] args) throws Exception {
        UDPclient u = new UDPclient(4444);

    }
}

