/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texteditorwithcompiler;
import javax.swing.*;
import java.awt.*;  
import java.awt.event.*;  
import java.io.*;   
import java.lang.Runtime;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author pengcheng
 */
public class Texteditorwithcompiler extends JFrame{
    public JTextPane textPane = new JTextPane();   
    public JFileChooser filechooser = new JFileChooser(); 
    String s = textPane.getText();
    
    public Texteditorwithcompiler(){
        super("Text Editor"); 
        Action[] a = {new NAction(), new SaveAction(), new OpenAction(), new QuizAction(),
        new CompileAction(), new RunAction()};  
        setJMenuBar(createJMenuBar(a));    
        Container c = getContentPane();         
        c.add(textPane, BorderLayout.CENTER);   
        setSize(600,400);  
        setVisible(true);
    }
    
    private JMenuBar createJMenuBar(Action[] a){  
        JMenuBar d = new JMenuBar();  
        JMenu e = new JMenu("Files");  
        JMenu f = new JMenu("Build");
        e.add(new JMenuItem(a[0]));
        e.add(new JMenuItem(a[1]));  
        e.add(new JMenuItem(a[2]));    
        e.add(new JMenuItem(a[3]));  
        f.add(new JMenuItem(a[4]));  
        f.add(new JMenuItem(a[5]));    
        d.add(e);  
        d.add(f);  
        return d;  
    }  
    
    class NAction extends AbstractAction{  
        public NAction(){  
            super("New");  
        }  
        public void actionPerformed(ActionEvent e){  
            textPane.setText(" ");  
        }  
    } 
    
   
    class SaveAction extends AbstractAction{  
        public SaveAction() {  
            super("Save");  
        }  
        public void actionPerformed(ActionEvent e){  
            int i = filechooser.showSaveDialog(Texteditorwithcompiler.this);  
            if(i == JFileChooser.APPROVE_OPTION){  
                File f = filechooser.getSelectedFile();  
                try{  
                    FileOutputStream out=new FileOutputStream(f);  
                    out.write(textPane.getText().getBytes());  
                }  
                catch(Exception ex){  
                    ex.printStackTrace();  
                }  
            }  
        }  
    }  
     
    class OpenAction extends AbstractAction{  
        public OpenAction(){  
            super("Open");  
        }  
        public void actionPerformed(ActionEvent e){  
            int i = filechooser.showOpenDialog(Texteditorwithcompiler.this);        
            if(i == JFileChooser.APPROVE_OPTION){  
                File f = filechooser.getSelectedFile();   
                try{  
                    InputStream a = new FileInputStream(f);  
                    textPane.read(a, "d");  
                }  
                catch(Exception ex){  
                    ex.printStackTrace();  
                }  
            }  
        }  
    }  
    
    class QuizAction extends AbstractAction{  
        public QuizAction(){  
            super("Exit");  
        }  
        public void actionPerformed(ActionEvent e){  
            dispose();  
        }  
    }  
  
    class CompileAction extends AbstractAction{  
        public CompileAction(){  
            super("Compile");  
        }  
        public void actionPerformed(ActionEvent e){  
            try {
            Runtime r = Runtime.getRuntime();
            Process p = r.exec("javac test.java");

        } catch (IOException iox) {
            //do stuff with exception
            iox.printStackTrace();
        }  
    }  
    }  
    class RunAction extends AbstractAction{  
        public RunAction(){  
            super("Run");  
        }  
        public void actionPerformed(ActionEvent e){  
            
        }  
    }  

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
