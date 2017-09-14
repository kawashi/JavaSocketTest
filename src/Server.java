import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;
import java.io.DataInputStream;
import java.io.OutputStream;
import java.io.DataOutputStream;

public class Server {
    public void echoAccept() {
        try {
            ServerSocket serverSocket = new ServerSocket(4545);

            while(true) {
                Socket socket = serverSocket.accept();

                // クライアントからの値を取得
                InputStream inputStream = socket.getInputStream();
                DataInputStream dataInputStream = new DataInputStream(inputStream);
                int responseNumber = dataInputStream.readInt();
                dataInputStream.close();

                // クライアントに値を返す
                OutputStream outputStream = socket.getOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
                dataOutputStream.writeInt(responseNumber);
                dataOutputStream.close();
            }

        } catch(Exception e) {
            System.out.println("エラー: " + e);
        }
    }

//    public static void main(String args[]) {
//        try {
//            int port = Integer.parseInt(args[0]); //サーバ側の待受ポート番号
//            ServerSocket ss = new ServerSocket(port);
//
//            while(true) {
//                Socket s = ss.accept(); //クライアントからの通信開始要求が来るまで待機
//
//                // 以下、クライアントからの要求発生後
//                InputStream is = s.getInputStream(); //クライアントから数値を受信
//                DataInputStream dis = new DataInputStream(is);
//                int req = dis.readInt();
//
//                OutputStream os = s.getOutputStream(); //二乗した結果を送信
//                DataOutputStream dos = new DataOutputStream(os);
//                dos.writeInt(req*req);
//
//                // ストリームを閉じる
//                dos.close();
//                dis.close();
//            }
//        }
//        catch(Exception e) {
//            System.out.println("Exception: " + e);
//        }
//    }
}
