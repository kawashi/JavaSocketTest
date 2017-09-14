import java.io.*;
import java.net.Socket;

public class Client {
    public void sendRequest() {
        try {
            Socket socket = new Socket("localhost", 4545);

            // サーバに値を送る
            OutputStream outputStream = socket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeInt(500);
            dataOutputStream.close();

            // サーバから値を受け取る
            InputStream inputStream = socket.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            System.out.println(dataInputStream.readInt());
            dataInputStream.close();
        } catch(Exception e) {
            System.out.println("エラー: " + e);
        }
    }
//
//    public static void main(String args[]) {
//        try {
//            String server = args[0];
//            int port = Integer.parseInt(args[1]); //サーバー側のポート番号
//            Socket s = new Socket(server, port);
//
//            // サーバーに数値を送信
//            OutputStream os = s.getOutputStream();
//            DataOutputStream dos = new DataOutputStream(os);
//            dos.writeInt(Integer.parseInt(args[2]));
//
//            // 演算結果を受信
//            InputStream is = s.getInputStream();
//            DataInputStream dis = new DataInputStream(is);
//            int res = dis.readInt();
//            System.out.println(res);
//
//            // ストリームを閉じる
//            dis.close();
//            dos.close();
//        }
//        catch (Exception e) {
//            System.out.println("Exception: " + e);
//        }
//    }
}
