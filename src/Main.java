import javax.xml.parsers.DocumentBuilderFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

public class Main {
	public static void main(String argv[]) {
	
	File fXmlFile = new File("UK_1.xml");
	ReadIn xml = new ReadIn(fXmlFile);
	
	ArrayList<String> times = xml.getTimes();
	ArrayList<String> teachers = xml.getTeachers();
	ArrayList<String> classes = xml.getClasses();
	ArrayList<String> rooms = xml.getRooms();
	ArrayList<String> courses = xml.getCourses();
	ArrayList<String> durations = xml.getDurations();
	ArrayList<ArrayList<String>> event_group = xml.getEvents();
	
	Teacher t = new Teacher(times, teachers);
	Group g = new Group(times, classes);
	Room r = new Room(times, rooms);	
	
	

	System.out.println(times.size() + " times:" + times + "\n");
	System.out.println(classes.size() + " classes:" + classes + "\n");
	System.out.println(teachers.size() + " teachers:" + teachers + "\n");
	System.out.println(rooms.size() + " rooms:" + rooms + "\n");
	System.out.println(courses.size() + " courses:" + courses + "\n");
	System.out.println("durations: " + durations + "\n");
	System.out.println(event_group.size()+ " events");
	//System.out.println(event_group);
	
	
	//example of adding event to teacher array
	System.out.println(t.toString());
	t.fillTeacherArray(10, 3, 21);
	System.out.println(t.toString());
	
	
	
	
	//creates arraylist of all event ids
	ArrayList<String> event_ids = new ArrayList<String>();
	for(int a=0; a<event_group.size(); a++) {
		event_ids.add(event_group.get(a).get(0));
	}
	
	

	//any of these three versions can be run to produce different solutions
	
	Version1 test1 = new Version1(fXmlFile, event_ids, durations, times, rooms);
	//Version2 test2 = new Version2(fXmlFile, event_ids, durations, times, rooms);
	//Version3 test3 = new Version3(fXmlFile, event_ids, durations, times, rooms);
	
	}
}