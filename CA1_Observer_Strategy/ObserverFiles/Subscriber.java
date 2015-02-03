import java.util.ArrayList;
import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
public class Subscriber extends JFrame implements Subscription, Serializable
{
   private String subscriberName;
   private Socket socket;
   
   public Subscriber(Socket remoteSocket)
   {
      super("News Reader");
      this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
      this.setSize(700, 350);
      //buildUI
      /*do connection
      socket = new Socket(localhost, 8080);
      socket.open();
      */
      //register with server
      //Subscript
      this.setVisible(true);
   }
   
   public void update(Object arg)
   {
      
   }
   
   private void buildUI()
   {
           
   }
}