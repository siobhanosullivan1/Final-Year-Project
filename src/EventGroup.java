import java.util.ArrayList;

public class EventGroup {
	
	private ArrayList<String> event_group = new ArrayList<String>();
	
	public EventGroup(String index, String event_id, String course){
		
		event_group.add(index);
		event_group.add(event_id);
		event_group.add(course);
		
	}
	
	
	
}
