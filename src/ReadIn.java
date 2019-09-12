

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.xml.transform.dom.DOMSource; 
import java.util.Date;
import org.w3c.dom.*; 
import javax.xml.parsers.*; 
import javax.xml.transform.*; 
import javax.xml.transform.stream.*;

public class ReadIn {
	
	File fXmlFile;
	ArrayList<String> times = new ArrayList<String>();	
	ArrayList<String> resources = new ArrayList<String>();
	ArrayList<String> teachers = new ArrayList<String>();
	ArrayList<String> classes = new ArrayList<String>();
    ArrayList<String> rooms = new ArrayList<String>();
    ArrayList<String> courses = new ArrayList<String>();
    ArrayList<String> durations = new ArrayList<String>();
    ArrayList<ArrayList<String>> event_group = new ArrayList<ArrayList<String>>();
    ArrayList<ArrayList<String>> event_group2 = new ArrayList<ArrayList<String>>();
	
	public ReadIn(File fXmlFile){
		this.fXmlFile = fXmlFile;

    try {

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		doc.getDocumentElement().normalize();
		
		Element root = doc.getDocumentElement();
		
			NodeList HighSchoolTimetableArchive = doc.getElementsByTagName("HighSchoolTimetableArchive");
		
			for (int i = 0; i < HighSchoolTimetableArchive.getLength(); i++) { //get all the HighSchoolTimetableArchive list and loop over them
			
			NodeList Instances = ((Element)HighSchoolTimetableArchive.item(0)).getElementsByTagName("Instances");
			NodeList Instance = ((Element)Instances.item(0)).getElementsByTagName("Instance");
			NodeList Times = ((Element)Instance.item(i)).getElementsByTagName("Times");
			NodeList TimeGroups = ((Element)Times.item(0)).getElementsByTagName("TimeGroups");
			NodeList Day = ((Element)TimeGroups.item(0)).getElementsByTagName("Day");
			NodeList Time = ((Element)Times.item(0)).getElementsByTagName("Time");
			NodeList Resources = ((Element)Instance.item(0)).getElementsByTagName("Resources");
			NodeList Resource = ((Element)Resources.item(0)).getElementsByTagName("Resource");
			NodeList Events = ((Element)Instance.item(0)).getElementsByTagName("Events");
			NodeList Event = ((Element)Instance.item(0)).getElementsByTagName("Event");
		
			
			for(int j=0; j<Time.getLength(); j++){ //puts all the times into an arraylist called "times"
				String temp = ((Element)Time.item(j)).getAttribute("Id");
				times.add(temp);
			}
			
			for(int j=0; j<Resource.getLength(); j++){  //reads in resources and separates them into teachers, rooms, classes, times
				String temp = ((Element)Resource.item(j)).getAttribute("Id");
				resources.add(temp);
				
				
				NodeList ResourceType = ((Element)Resource.item(j)).getElementsByTagName("ResourceType");
				for(int k=0; k<ResourceType.getLength(); k++){
					String resource_type = ((Element)ResourceType.item(k)).getAttribute("Reference");
					if(resource_type.equals("Teacher")){
						teachers.add(temp);
					}
					if(resource_type.equals("Room")){
						rooms.add(temp);
					}
					if(resource_type.equals("Class")){
						classes.add(temp);
					}
				}	
			}
			
			for(int j=0; j<Event.getLength(); j++){ //reads in the events
				   ArrayList<String> event = new ArrayList<String>();
				String temp = ((Element)Event.item(j)).getAttribute("Id");
				event.add(temp);
				
				
				NodeList EventResource = ((Element)Event.item(j)).getElementsByTagName("Resource");
				
				NodeList Duration = ((Element)Event.item(j)).getElementsByTagName("Duration");	//reads durations of each event into arraylist
				for(int n=0; n<Duration.getLength(); n++){
					Node current = Duration.item(n);
					String temp1 = current.getTextContent();
					durations.add(temp1);
					event.add(temp1);
				}
				
				NodeList Course = ((Element)Event.item(j)).getElementsByTagName("Course"); //reads courses into arraylist
				for(int l=0; l<Course.getLength(); l++){
					String course = ((Element)Course.item(l)).getAttribute("Reference");
					event.add(course);
					courses.add(course);
					for(int k=0; k<EventResource.getLength(); k++){
						String event_resource = ((Element)EventResource.item(k)).getAttribute("Reference");
						event.add(event_resource);				
					}
				}
			
				if(event.get(0).isEmpty()){
				event_group2.add(event);}
				else{
				event_group.add(event);
				}
			}			
		}

		
	}catch (Exception e) {
	    e.printStackTrace();
		}		
	}
	
	public ArrayList<String> getTimes(){
		return times;
	}
	
	public ArrayList<String> getResources(){
		return resources;
	}
	
	public ArrayList<String> getTeachers(){
		return teachers;
	}
	
	public ArrayList<String> getRooms(){
		return rooms;
	}
	
	public ArrayList<String> getClasses(){
		return classes;
	}
	
	public ArrayList<ArrayList<String>> getEvents(){
		return event_group;
	}
	
	public ArrayList<String> getCourses(){
		return courses;
	}
	
	public ArrayList<String> getDurations(){
		return durations;
	}
		
}


