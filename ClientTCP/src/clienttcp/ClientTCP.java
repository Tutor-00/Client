/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienttcp;
import java.io.*;
import java.net.*;
/**
 *
 * @author 18007
 */
public class ClientTCP {

   public static void main(String[] args) {
    String temp;
    String displayBytes;
    try {
      //create input stream
      BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
      //create client socket, connect to server
      Socket clientSocket = new Socket("localhost",5555);
      //create output stream attached to socket
      DataOutputStream outToServer =
      new DataOutputStream(clientSocket.getOutputStream());

      System.out.print("Command : ");

      //create input stream attached to socket
      BufferedReader inFromServer =
      new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

      temp = inFromUser.readLine();

      //send line to server
      outToServer.writeBytes(temp);

      //read line from server
      //displayBytes = inFromServer.readLine();

      while((displayBytes = inFromServer.readLine()) != null) {
        System.out.print(displayBytes);
      }
      //clientSocket.close();
    }
    catch(Exception ex) {
    }
  }
}
