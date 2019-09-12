import java.util.ArrayList;

public class Event {

	private ArrayList<String> event;
	private String event_time;
	private String event_room;
	private String event_teacher;
	private String event_class;
	private String course;
	private String id;
	
	public Event(ArrayList<String> event){   //structure of an event is: Id, Class, Teacher, Room and Time
		this.event = event;	

			id = event.get(0);
			course = event.get(1);
			event_class = event.get(2);
			event_teacher = event.get(3);
			event_room = event.get(4);
			//event_time = event.get(5);
	}
	
	public void changeRoom(String change_room){
		event_room = change_room;
		updateEvent();
	}

	public String getEventid(){
		return id;
	}
	
	public String getEventTime(){
		return event_time;
	}
	
	public String getEventRoom(){
		return event_room;
	}
	
	public String getEventTeacher(){
		return event_teacher;
	}
	
	public String getEventClass(){
		return event_class;
	}

	public String getCourse(){
		return course;
	}
	
	public ArrayList<String> getEvent(){
		return event;
	}
	
	public void updateEvent(){
		ArrayList<String> temp = new ArrayList<String>();
		temp.add(id);
		temp.add(course);
		temp.add(event_class);
		temp.add(event_teacher);
		temp.add(event_room);
		temp.add(event_time);
		
		event = temp;
	}

}
