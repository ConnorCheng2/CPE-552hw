/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parsetext;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 *
 * @author pengcheng
 */
public class ParseText {

    /**
     * @param args the command line arguments
     */
    public static String readText(String filename) throws FileNotFoundException, IOException{
        String line;
        StringBuffer txt = new StringBuffer();
        File file = new File(filename);
        BufferedReader br = new BufferedReader(new FileReader(file) );
        while((line = br.readLine()) != null){
        txt.append(line);
        txt.append(" ");
      }
        String res0 = txt.toString().replaceAll("\\s+", " ").replaceAll("(^\\s*)|(\\s*$)","");
        String res = res0.replace(",","").replace(":", "").replace(".","").replace("!","").toLowerCase();
        return res;
    }
    public static Map readWords(String filename) throws FileNotFoundException, IOException{
        Map<String, Integer> sws = new HashMap<>();
        String line;
        int occurance = 0;
        BufferedReader br = new BufferedReader(new FileReader("shortwords.txt"));
        while((line = br.readLine()) != null){
            sws.put(line, occurance);
        }
        return sws;
    }
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
       String[] article= ParseText.readText("Frankenstein.txt").split(" ");
       Map<String, Integer> shortwords = ParseText.readWords("shortwords.txt");
       for(int i = 0; i< article.length; i++){
           if (shortwords.containsKey(article[i])){
               shortwords.put(article[i], shortwords.get(article[i])+1);  
       }    
       }
        Map<String, Integer> result = new HashMap<String, Integer>();

        for (Entry<String, Integer> entry : shortwords.entrySet()) {
            if (entry.getValue()>=50) {
                result.put(entry.getKey(), entry.getValue());
            }
        }
        
        System.out.print(result.toString());
    }
    
}
