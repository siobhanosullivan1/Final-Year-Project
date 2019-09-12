import java.util.ArrayList;

public class Constraint {
	
	private Teacher teachers;
	private Room rooms;
	private Group classes;
	private Event event;
	private boolean satisfied = false;
	
	Constraint(Teacher teachers, Room rooms, Group classes /*Event event*/){
		this.teachers = teachers;
		this.rooms = rooms;
		this.classes = classes;	
		//this.event = event;
	}
	
		
	public boolean assignResourceConstraint(int index, Group group, Teacher teacher, Room room){

		if((group.check(index) == true)&&(teacher.check(index) == true)&&(room.check(index) == true))
			satisfied = true;
		else
			satisfied = false;
		
		return satisfied;
	}
	
	public boolean assignTimeConstraint(Event event){
		String str = "";
		if((event.getEventTeacher() != null) && (event.getEventClass() != null) && ((event.getEventTime() != null)&&(event.getEventTime() != str)))
			satisfied = true;
		else 
			satisfied = false;
		return satisfied;	
	}
	
	public boolean spreadEventsConstraint(Event event){
			
		String temp_course = event.getCourse();
	
		return satisfied; 
	}
	

}