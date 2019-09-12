import java.util.ArrayList;

public class Teacher {

	private int teachers_array[][];
	private boolean found = false;	
	private ArrayList<String> times;
	private ArrayList<String> teachers;	
	private int xcoord = 0;
	private int ycoord = 0;

	
	public Teacher(ArrayList<String> times, ArrayList<String> teachers){	
		this.times = times;
		this.teachers = teachers;
		teachers_array = new int[times.size()][teachers.size()];
		for (int i=0; i<times.size(); i++){
		    for (int j=0; j<teachers.size(); j++){ 
		        teachers_array[i][j] = 0;
		    }
		}
	}	
	
	public void fillTeacherArray(int xcoord, int ycoord, int a){ //fills the 2d array
		for (int i=0; i<times.size(); i++){
		    for (int j=0; j<teachers.size(); j++){ 
		    	
		        teachers_array[xcoord][ycoord] = a;
		        
		    }
		}
	}	
	
	public String toString(){
		String str = "";
		for (int i=0; i<times.size(); i++){
		    for (int j=0; j<teachers.size(); j++){ 
		        str += teachers_array[i][j] + " ";
		    }
		    str += "\n";
		}
		return str;
	}
	
	public int getXcoord(){
		return xcoord;
	}
	
	
	public String findTeacher(int y){
		return teachers.get(y);
	}
	
	public String findTime(int x){
		return times.get(x);
	}
	
	public ArrayList<String> getTimes(){
		return times;
	}
	
	public ArrayList<String> getTeachers(){
		return teachers;
	}
	
	public int whichTeacher(String event_teacher, ArrayList<String> allTeachers){
		for(int i=0; i<allTeachers.size(); i++){
			if((event_teacher).equals(allTeachers.get(i))){
				ycoord = i;
				break;			
			}
		}
		return ycoord;
	}
	

	public boolean check(int x){ //checks if x is in the array
		
		boolean found = false;
		int found1=0, found2=0;
		
		for(int i=0; i<times.size(); i++){
			for(int j=0; j<teachers.size(); j++){
				if(teachers_array[i][j] == x){
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

	 
}
