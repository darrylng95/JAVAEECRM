/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.singleton;

import entity.*;
import ejb.session.stateless.ItemEntityControllerLocal;
import ejb.session.stateless.OrderEntityControllerLocal;
import ejb.session.stateless.UserEntityControllerLocal;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Startup;
import util.exception.*;

/**
 *
 * @author darryl
 */
@Singleton
@LocalBean
@Startup
public class DataInitializationSessionBean {

    @EJB
    private OrderEntityControllerLocal orderEntityControllerLocal;

    @EJB
    private ItemEntityControllerLocal itemEntityControllerLocal;
    @EJB
    private UserEntityControllerLocal userEntityControllerLocal;

     @PostConstruct
    public void postConstruct() {
        try {
            System.out.println("Trying to retrieve Admin identity @ data initialization");
            userEntityControllerLocal.retrieveUserByUsername("admin");
        } catch (NoResultException ex) {
            initializeData();
        }
    }
    
        private void initializeData() {
        System.out.println("Starting up @ data initialization");
        List<ItemEntity> items;
        items = new ArrayList<>();
        Image image1 = null;
        
        try {
        URL url1 = new URL("https://sc01.alicdn.com/kf/HTB1dyr6GFXXXXc.XVXXq6xXFXXX1/222411160/HTB1dyr6GFXXXXc.XVXXq6xXFXXX1.jpg");
        byte[] data1 = imageToByteArray(url1);
        
        URL url2 = new URL("https://shop.usa.canon.com/wcsstore/ExtendedSitesCatalogAssetStore/EOS-M3-EF-M-18-55mm-IS-STM-Camera-Kit-Black_1_xl.jpg");
        byte[] data2 = imageToByteArray(url2);
        
        URL url3 = new URL("https://st.hzcdn.com/simgs/b181db24041202e4_4-2533/home-design.jpg");
        byte[] data3 = imageToByteArray(url3);
        
        URL url4 = new URL("https://zdnet2.cbsistatic.com/hub/i/r/2018/08/31/56500b34-1a2a-493e-b823-62db85d1d769/resize/470xauto/29c2c5a7c476e762d409002f08b2fb85/yoga-630.jpg");
        byte[] data4 = imageToByteArray(url4);
        
        ItemEntity item1 = new ItemEntity("tshirt", "A computing tshirt", 2, "Fashion", 5, data1);
        items.add(item1);
        ItemEntity item2 = new ItemEntity("camera", "An expensive camera", 1, "Hobbies", 1000, data2);
        items.add(item2);
        ItemEntity item3 = new ItemEntity("bed", "a very comfy bed", 5, "Home + Living", 500, data3);
        items.add(item3);
        ItemEntity item4 = new ItemEntity("laptop", "not as good as apple", 1, "Electronics", 2000, data4);
        items.add(item4);
        
        itemEntityControllerLocal.createItem(item4);
        itemEntityControllerLocal.createItem(item3);
        itemEntityControllerLocal.createItem(item2);
        itemEntityControllerLocal.createItem(item1);
        
        userEntityControllerLocal.createUser(new UserEntity("Admin", "123@gmail.com", "123 Computing Drive", 12345678, 1, "admin", "admin", null));
        userEntityControllerLocal.createUser(new UserEntity("Darryl", "321@gmail.com", "321 Computing Drive", 87654321, 0, "Darryl", "password", items));
        
        } catch (Exception e) {
      
            System.out.println("Error @ data initialization");
            System.out.println(e);
        }
    }
    
    private byte[] imageToByteArray(URL url) throws Exception {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try {
            byte[] chunk = new byte[4096];
            int bytesRead;
            InputStream stream = url.openStream();

            while ((bytesRead = stream.read(chunk)) > 0) {
                outputStream.write(chunk, 0, bytesRead);
            }

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return outputStream.toByteArray();
    }
}
