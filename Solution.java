import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
	
	static void compareArrays(ArrayList<ArrayList<Integer> > dataSets, int i, int j) {
		for (int k = 0; k < dataSets.get(j).size(); ++k) {
			if (!dataSets.get(i).contains(dataSets.get(j).get(k))) {
				// Move k from j to i
				System.out.println(dataSets.get(j).get(k) + " " + (j+1) + " " + (i+1));
				// Don't forget to actually do the copy!
				dataSets.get(i).add(dataSets.get(j).get(k));
			}
		}
	}
	
    public static void main(String args[] ) throws Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            String input = br.readLine();
            int numCenters = Integer.parseInt(input);
            
            ArrayList<Integer> numDataSets = new ArrayList<Integer>();
            ArrayList<ArrayList<Integer> > dataSets = new ArrayList<ArrayList<Integer> >();
            
            while (!(input = br.readLine()).isEmpty()) {
            	ArrayList<Integer> ds = new ArrayList<Integer>();
            	String[] tmp = input.split(" ");
            	numDataSets.add(Integer.parseInt(tmp[0]));
            	for (int i = 1; i < tmp.length; ++i) {
            		ds.add(Integer.parseInt(tmp[i]));
            	}
            	Collections.sort(ds);
            	dataSets.add(ds);
            }
            
            for (int i = 0; i < numCenters-1; ++i) {
            	for (int j = i+1; i < numCenters; ++i) {
            		if (dataSets.get(i) != dataSets.get(j)) {
            			compareArrays(dataSets, i, j);
            			compareArrays(dataSets, j, i);
            		}
            	}
            }
            
            System.out.println("done");
            
        } catch(IOException io) {
            io.printStackTrace();
        }
    }
}
