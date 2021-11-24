/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jurnal;

import java.io.File;
import java.util.List;
import com.mycompany.jurnal.db.Users;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


/**
 *
 * @author ilyaevgenevi4
 */
public class UserFunction { 
     public static void exportUsers(File outputFile, List<Users> userList)
        throws IOException {
        FileWriter fr = new FileWriter(outputFile);
        BufferedWriter bw = new BufferedWriter(fr);
       
        for (Users u : userList) {
            String login    = u.getUserName();
            String password = u.getUserPassword();
            String name     = u.getName();
            String role     = u.getUserRole();
            String userGroup    = u.getUserGroup();            
            // Формат данных:
            // login,password,name,role,group
            bw.write(login + "," 
                    + password + "," 
                    + name + "," 
                    + role + "," 
                    + userGroup + "\n");
        }
        
        bw.close();
    }
}
