import java.util.ArrayList;
import java.util.Arrays;

public class Room {

	private int rooms_array[][];
	private boolean found = false;	
	private ArrayList<String> times;
	private ArrayList<String> rooms;	
	private int xcoord = 0;
	private int ycoord = 0;

	
	public Room(ArrayList<String> times, ArrayList<String> rooms){	
		this.times = times;
		this.rooms = rooms;
		rooms_array = new int[times.size()][rooms.size()];
		for (int i=0; i<times.size(); i++){
		    for (int j=0; j<rooms.size(); j++){ 
		        rooms_array[i][j] = 0;
		    }
		}
	}	
	
	
	public void fillRoomArray(int xcoord, int ycoord, int a){ //fills the 2d array
		for (int i=0; i<times.size(); i++){
		    for (int j=0; j<rooms.size(); j++){ 
	    		 rooms_array[xcoord][ycoord] = a;	       
		    }
		}
	}
	
	public boolean check(int x){ //checks if x is in the array 
		
		boolean found = false;
		int found1=0, found2=0;
		
		for(int i=0; i<times.size(); i++){
			for(int j=0; j<rooms.size(); j++){
				if(rooms_array[i][j] == x){
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
		    for (int j=0; j<rooms.size(); j++){ 
		        str += rooms_array[i][j] + " ";
		    }
		    str += "\n";
		}
		return str;
	}
	
	public int getXcoord(){
		return xcoord;
	}
	
	public int whichRoom(String event_room, ArrayList<String> allRooms){ //finds out the location of the room in the room array list
		for(int i=0; i<allRooms.size(); i++){
			if((event_room).equals(allRooms.get(i))){
				ycoord = i;
				break;			
			}
		}
		return ycoord;
	}
	
	 
}
