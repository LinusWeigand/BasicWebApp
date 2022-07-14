package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

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
            return "";
        }else {
            return "";
        }
    }
}
