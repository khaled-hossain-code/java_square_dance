import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		PriorityQueue<String> maleDancers = new PriorityQueue<String>();
		PriorityQueue<String> femaleDancers = new PriorityQueue<String>();
		String line = null;
		String sex = "";
		BufferedReader input;
		
		try {
			input = new BufferedReader(new FileReader("dancerList.txt"));
			while( (line = input.readLine()) != null ) {
				sex = line.substring(0, 1);
				if(sex.equals("M")) {
					maleDancers.add(line.substring(2));
				}else {
					femaleDancers.add(line.substring(2));
				}
			}
			input.close();
		}
		catch (IOException except) {
			System.out.println(except);
		}
		
		while(!maleDancers.isEmpty() && !femaleDancers.isEmpty()) {
			System.out.println("Dance Parter: " + maleDancers.poll() + " & " + femaleDancers.poll());
		}
		
		if( maleDancers.isEmpty()) {
			System.out.println(femaleDancers.size() + " Female Dancers are Waiting");
			System.out.println(femaleDancers.peek() + " is first in line");
		}
		
		if( femaleDancers.isEmpty()) {
			System.out.println(maleDancers.size() + " Male Dancers are Waiting");
			System.out.println(maleDancers.peek() + " is first in line");
		}
		
	}

}
