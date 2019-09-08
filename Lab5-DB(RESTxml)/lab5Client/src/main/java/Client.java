

import com.eshop.backend.services.Item;
import com.eshop.backend.services.ListofItem;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXB;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lorenzo
 */
public class Client {
     final static private String BaseUrl = "http://localhost:8080/shop";
     private static int  idClient =0;
   
     private static String Username="";
     
    static  boolean ready=false;
    
     private final static Object lock=new Object();
     
     
     
    public static void main(String[] args) throws IOException {
         String nome_pass = JOptionPane.showInputDialog("Nome-Password");
         if(nome_pass.equals("")){
             nome_pass = "Pino-Dio44";
         }
         try {
             HttpPost httpPost = new HttpPost(BaseUrl + "/login/"+nome_pass.split("-")[0]+"/"+nome_pass.split("-")[1]);
             
             HttpResponse response = HttpClients.createDefault().execute(httpPost);
             String resp = response.getStatusLine().toString();
             System.out.println(resp);
             if(resp.contains("200 OK")){
                 Username+= nome_pass.split("-")[0];
                 URL urla = new URL(BaseUrl+"/sendId/"+Username); 
                 InputStream in = urla.openStream();
                 idClient = new Integer(convert(in,Charset.defaultCharset()));
                 System.out.println(idClient);
                
                 menuOnline();
                     
                
                
             }
             else{
                 System.out.println("Riprova con credenziali giuste/crea nuovo utente da sqlite");
             }
             
             
         } catch (MalformedURLException ex) {
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    public static void menuOnline() throws MalformedURLException, IOException{
        while(true){ 
        ready=false;
        RabbitMqClient t1 = new RabbitMqClient(idClient,"ORDER");
        RabbitMqClient t2 = new RabbitMqClient(idClient,"NEWITEM");
        t1.run();t2.run();
        URL u = new URL(BaseUrl+"/showItems");
        InputStream input = u.openStream();
        String itemi = "";
        ListofItem l = JAXB.unmarshal(new InputStreamReader(input), ListofItem.class);
        for(Item i:l.getItems()){
           itemi+=i.toString()+"\n";
           
        }
        MessageDialogFrame mainFrame = new MessageDialogFrame();
        
        JFrame f = mainFrame.createFrame(1500, 1000, "Menu");
        JButton b =mainFrame.createButton(100, 40, 10, 10, "aggiungi al carrello");
        f.add(b);
        f.add(mainFrame.createTextArea(300, 400, 500, 100,itemi));
        JButton b1 = mainFrame.createButton(120, 40, 10, 10, "salva aggiunta");b1.setVisible(false);
        JTextArea orderid =mainFrame.createTextArea2(100,50,100, 100, "Inserisci gli Id degli item da comprare\n ID1-ID2-ID3...."); orderid.setVisible(false);
        JButton b4 = mainFrame.createButton(200,20,10,10,"RicaricaItem");f.add(b4);b4.setVisible(true);
        
        f.setVisible(true);
        JButton b2 = mainFrame.createButton(12,40,10,10,"reset Basket");b2.setVisible(false);
        String basketItems=getBasketItems();
        
        JButton b3 = mainFrame.createButton(12,40,10,10,"Ordina");b3.setVisible(false);
         
        JTextArea BasketArea = mainFrame.createTextArea(100,50,100, 100, ""); BasketArea.setVisible(false);
        if(basketItems == null|| basketItems.equals("")){}
        else{
            BasketArea.setText(basketItems);
            f.add(BasketArea);
            BasketArea.setVisible(true);
            f.add(b2);
            f.add(b3);
            b2.setVisible(true);
            b3.setVisible(true);
        }
        b.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
               
                f.setVisible(false);
                
                f.add(orderid);
                
                b.setVisible(false);
                b4.setVisible(false);
                f.add(b1);
                orderid.setVisible(true);
                b1.setVisible(true);
                f.setVisible(true);
              
          
              
                
            }
            
        });
        
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("pressato2");
                String getIds = orderid.getText();
                try {
                    effettuaAggiuntaCarrello(getIds);
                } catch (IOException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                JOptionPane.showMessageDialog(null, "BRAVOH-CarrelloAggiornato");
                
              synchronized(lock){
                 ready=true;
                 f.setVisible(false);
                 lock.notifyAll();
             }
            }
        });
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
             
             HttpPost httpPost = new HttpPost(BaseUrl +"/deleteBasket/"+idClient );
             
             HttpResponse response = HttpClients.createDefault().execute(httpPost);
             String resp = response.getStatusLine().toString();
                    System.out.println(resp);
            
             synchronized(lock){
                 ready=true;
                 f.setVisible(false);
                 lock.notifyAll();
             }
        }
        catch(Exception ex){
            
        }
                
            }
        });
        
        b3.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent e){
                 try {
             
             HttpPost httpPost = new HttpPost(BaseUrl +"/newOrder/"+idClient );
             
             HttpResponse response = HttpClients.createDefault().execute(httpPost);
             String resp = response.getStatusLine().toString();
                    System.out.println(resp);
             
             synchronized(lock){
                 ready=true;
                 f.setVisible(false);
                 lock.notifyAll();
             }
        }
        catch(Exception ex){
            
        }
                 
             }
        });
        b4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                synchronized(lock){
                 ready=true;
                 f.setVisible(false);
                 lock.notifyAll();
             }
            }
        });
        
        f.addWindowListener(new java.awt.event.WindowAdapter() {
    @Override
    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
        if (JOptionPane.showConfirmDialog(f, 
            "Are you sure you want to close this window?", "Close Window?", 
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
            logout();
            System.exit(0);
        }
       }
     });
        
        synchronized(lock){
            while(!ready){
                try {
                    lock.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        }
        
        //back to menu
        
        
}  
    
      
        
    
        
    
    private static String getBasketItems() throws MalformedURLException, IOException{
        String r = "";
        URL urla = new URL(BaseUrl+"/getBasket/"+idClient);
        InputStream input = urla.openStream();
        r=convert(input,Charset.defaultCharset());
        return r;
    }
    
    public static void effettuaAggiuntaCarrello(String idItemstoBasket) throws IOException{
        try {
             System.out.println(idItemstoBasket);
             HttpPost httpPost = new HttpPost(BaseUrl +"/addtoBasket/"+idClient+"/"+idItemstoBasket );
             
             HttpResponse response = HttpClients.createDefault().execute(httpPost);
             String resp = response.getStatusLine().toString();
        }
        catch(MalformedURLException ex){
            
        }
        
        
    }
    
    public static void logout(){
         HttpGet httpGet = new HttpGet(BaseUrl +"/logout/"+idClient );
             
             HttpResponse response=null;
         try {
             response = HttpClients.createDefault().execute(httpGet);
         } catch (IOException ex) {
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         }
             String resp = response.getStatusLine().toString();
        
    }
    private static String convert(InputStream inputStream, Charset charset) throws IOException {
 
	try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, charset))) {
		return br.lines().collect(Collectors.joining(System.lineSeparator()));
	}
}
    
}
