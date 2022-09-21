package wordle;

import java.io.*;
import java.util.*;

public class wordle {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new FileReader("wordle/allowable.txt"));
        List<String> a = new ArrayList<String>();
        String line = null;

        while((line = read.readLine()) != null) {
            a.add(line);
        }
        read.close();

        BufferedReader r = new BufferedReader(new FileReader("wordle/wordlewords.txt"));
        List<String> w = new ArrayList<String>();
        String lines = null;

        while((lines = r.readLine()) != null) {
            w.add(lines);
        }
        r.close();

        String [] allowable = a.toArray(new String[a.size()]);
        String [] wordlewords = w.toArray(new String[w.size()]);
        
        Random rand = new Random();
        
        int randint = rand.nextInt(wordlewords.length - 1);
        
        String wordle = wordlewords[randint];
        String [] wordle_letters = wordle.split("");
        
        Scanner sc = new Scanner(System.in);
        boolean guessed = false;
        int tries = 6;
        
        
        while(!guessed && tries != 0) {
        	String guess = sc.nextLine();
        	String [] guess_letters = guess.split("");
        	
        	boolean check = false;
        	
        	for(int i = 0; i < allowable.length; i++) {
        		if(guess.equals(allowable[i])) {
        			check = true;
        		}	
        	}
        	
        	if(check == true) {
        		if(guess.equals(wordle)) {
            		guessed = true;
            		System.out.println(wordle + " is correct!");
            		break;
            	}
            	
            	for(int i = 0; i < guess_letters.length; i++) {
            		if(guess_letters[i].equals(wordle_letters[i])) {
            			System.out.println(guess_letters[i] + " is GREEN");
            		}
            		
            		else if(wordle.contains(guess_letters[i])) {
            			System.out.println(guess_letters[i] + " is YELLOW");
            		}
            	}

            	
            	
            	tries--;
        	}
        	
        	else {
        		System.out.println(guess + " is an invalid word. Please guess again:");
        	}
        }
        
        if(tries == 0) {
        	System.out.println(wordle + " is the correct word");
        }
        
        sc.close();
    }
}
