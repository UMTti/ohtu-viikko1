/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.data_access;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import ohtu.domain.User;
import org.springframework.stereotype.Component;

/**
 *
 * @author pihla
 */
public class FileUserDAO implements UserDao {

    private String filename;

    public FileUserDAO(String filename) throws FileNotFoundException {
        this.filename = filename;
    }

    @Override
    public List<User> listAll() {
        List<User> lista = new ArrayList<User>();
        Scanner lukija;
        try {
            lukija = new Scanner(new File(filename));
            while (lukija.hasNextLine()) {
                String rivi = lukija.nextLine();
                String[] t = rivi.split(" ");
                User uusi = new User(t[0], t[1]);
                lista.add(uusi);
            }
            return lista;
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileUserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public User findByName(String name) {
        Scanner lukija;
        try {
            lukija = new Scanner(new File(filename));
            while (lukija.hasNextLine()) {
                String rivi = lukija.nextLine();
                String[] t = rivi.split(" ");
                if (t[0].equals(name)) {
                    User uusi = new User(t[0], t[1]);
                    return uusi;
                }
            }
            lukija.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileUserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public void add(User user) {
        try {
            PrintWriter out = new PrintWriter(new FileWriter(this.filename, true));
            out.append(user.getUsername() + " " + user.getPassword() + "\n");
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(FileUserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
