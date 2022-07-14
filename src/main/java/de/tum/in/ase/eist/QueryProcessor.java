package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class QueryProcessor {

    public String process(String query) {
		query = query.toLowerCase();
        if (query.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.contains("name")) {
           return "MyTeam";
        } else if(query.contains("flo")) {
            return "wild";
        } else if (query.contains("what is") && query.contains("plus")) {
            String[] parts = query.split(" ");
            for(int i = 0; i < parts.length; i++) {
                if(parts[i].equals("plus")) {
                    int a = Integer.parseInt(parts[i-1]);
                    int b = Integer.parseInt(parts[i+1]);
                    return String.valueOf(a+b);
                }
            }
            return "";
        } else if(query.contains("which of the following numbers is the largest:")) {
            //Exampe string: which of the following numbers is the largest: 10, 11, 33, 45
            String[] parts = query.split(" ");
            for(int i = 0; i < parts.length; i++) {
                if(parts[i].equals("largest:")) {
                    ArrayList<Integer> numbers = new ArrayList<>();
                    for(int j = i+1; j < parts.length; j++) {
                        //Trim all the whitespaces and commas
                        parts[j] = parts[j].replaceAll("\\s", "");
                        parts[j] = parts[j].replaceAll(",", "");
                        numbers.add(Integer.parseInt(parts[j]));
                    }
                    //Find the largest number
                    int largest = numbers.get(0);
                    for(int j = 1; j < numbers.size(); j++) {
                        if(numbers.get(j) > largest) {
                            largest = numbers.get(j);
                        }
                    }
                    return String.valueOf(largest);
                }
            }
            return "";
        }else {
            return "";
        }
    }
}
