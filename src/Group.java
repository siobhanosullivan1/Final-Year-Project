import java.util.ArrayList;

public class Group {

	private int groups_array[][];
	private boolean found = false;	
	private ArrayList<String> times;
	private ArrayList<String> groups;	
	private int xcoord = 0;
	private int ycoord = 0;

	
	public Group(ArrayList<String> times, ArrayList<String> groups){	
		this.times = times;
		this.groups = groups;
		groups_array = new int[times.size()][groups.size()];
		for (int i=0; i<times.size(); i++){
		    for (int j=0; j<groups.size(); j++){ 
		        groups_array[i][j] = 0;
		    }
		}
	}	

	
	public void fillGroupArray(int xcoord, int ycoord, int a){ //fills the 2d array
		for (int i=0; i<times.size(); i++){
		    for (int j=0; j<groups.size(); j++){ 
		    	if(xcoord == 0 && ycoord == 0)    //not that important because it would never happen
		    		groups_array[xcoord][ycoord] = 0;
		    	else
		        groups_array[xcoord][ycoord] = a;
		    }
		}
	}
	
	public boolean check(int x){ //checks if x is in the array
		
		boolean found = false;
		int found1=0, found2=0;
		
		for(int i=0; i<times.size(); i++){
			for(int j=0; j<groups.size(); j++){
				if(groups_array[i][j] == x){
					found = true;
					found1 = i;
					found2 =j;
					break;
					}
			}
		}
				
			
		System.out.println(found1 + " " + found2);
		return found;
	}
	
	public String toString(){
		String str = "";
		for (int i=0; i<times.size(); i++){
		    for (int j=0; j<groups.size(); j++){ 
		        str += groups_array[i][j] + " ";
		    }
		    str += "\n";
		}
		return str;
	}
	
	public String findClass(int y){
		return groups.get(y);
	}
	
	public String findTime(int x){
		return times.get(x);
	}
	
	public int whichClass(String event_class, ArrayList<String> allClasses){
		for(int i=0; i<allClasses.size(); i++){
			if((event_class).equals(allClasses.get(i))){
				ycoord = i;
				break;			
			}
		}
		return ycoord;
	}

	
}




