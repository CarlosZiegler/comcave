import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Client {
    
    private JTextArea incoming;
    private JTextField outgoing;
    private PrintWriter writer;
    private Socket socket;
    private BufferedReader reader;
    
    public void go() {
        JFrame frame = new JFrame("Chat");
        JPanel mainPanel = new JPanel();
        
        incoming = new JTextArea(15,31);
        incoming.setLineWrap(true);
        incoming.setWrapStyleWord(true);
        incoming.setEditable(false);
        
        JScrollPane qScroller = new JScrollPane(incoming);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        qScroller.setSize(350, 400);
        
        outgoing = new JTextField(20);
        JButton sendButton = new JButton("Send");
        frame.getRootPane().setDefaultButton(sendButton);
        sendButton.addActionListener(new SendButtonListener());
        JButton retryConnection = new JButton("Connect");
        retryConnection.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setUpNetworking();
                Thread readerThread = new Thread(new IncomingReader());
                readerThread.start();
            }
        });
        
        mainPanel.add(qScroller);
        mainPanel.add(outgoing);
        mainPanel.add(sendButton);
        mainPanel.add(retryConnection);
        
        setUpNetworking();
        
        Thread readerThread = new Thread(new IncomingReader());
        readerThread.start();
        
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(400,330);
        frame.setVisible(true);
    }
    
    private void setUpNetworking() {
        try {
            socket = new Socket("10.0.1.138", 5000);
            InputStreamReader streamReader = new InputStreamReader(socket.getInputStream());
            reader = new BufferedReader(streamReader);
            writer = new PrintWriter(socket.getOutputStream());
            incoming.append("networking established\n");
        }
        catch(IOException ex) {
            ex.printStackTrace();
            incoming.append("network establishment failed..\n");
        }
    }
    
    public class SendButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                writer.println(outgoing.getText());
                writer.flush();
            }
            catch(Exception ex) {
                ex.printStackTrace();
            }
            outgoing.setText("");
            outgoing.requestFocus();
        }
    }
    
    public class IncomingReader implements Runnable {
        public void run() {
            String message;
            try {
                while((message = reader.readLine()) != null) {
                    incoming.append(message + "\n");
                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Client().go();
    }
        
}