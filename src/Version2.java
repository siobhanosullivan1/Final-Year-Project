

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
import java.util.Random;

public class Version2 {
	
	File fXmlFile;
	
	public Version2(File fXmlFile, ArrayList<String> event_ids, ArrayList<String> durations, ArrayList<String> times, ArrayList<String> rooms){
		this.fXmlFile = fXmlFile;
		

   try {

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		doc.getDocumentElement().normalize();
		
			NodeList HighSchoolTimetableArchive = doc.getElementsByTagName("HighSchoolTimetableArchive");
			
			for (int i = 0; i < HighSchoolTimetableArchive.getLength(); i++) {
				NodeList Instances = ((Element)HighSchoolTimetableArchive.item(0)).getElementsByTagName("Instances");
				NodeList Instance = ((Element)Instances.item(0)).getElementsByTagName("Instance");
				NodeList Times = ((Element)Instance.item(0)).getElementsByTagName("Times");
				NodeList TimeGroups = ((Element)Times.item(0)).getElementsByTagName("TimeGroups");
				NodeList Day = ((Element)TimeGroups.item(0)).getElementsByTagName("Day");
				NodeList Time = ((Element)Times.item(0)).getElementsByTagName("Time");
				NodeList Resources = ((Element)Instance.item(0)).getElementsByTagName("Resources");
				NodeList Resource = ((Element)Resources.item(0)).getElementsByTagName("Resource");
				NodeList Events = ((Element)Instance.item(0)).getElementsByTagName("Events");
				NodeList Event = ((Element)Instance.item(0)).getElementsByTagName("Event");
				NodeList SolutionGroups = ((Element)HighSchoolTimetableArchive.item(0)).getElementsByTagName("SolutionGroups");
				NodeList SolutionGroup = ((Element)SolutionGroups.item(0)).getElementsByTagName("SolutionGroup");

				String instance_id = ((Element)Instance.item(0)).getAttribute("Id");
				
				Text a = doc.createTextNode("Siobhan");
				
				//creating the "header" 
				Element solGroup = doc.createElement("SolutionGroup");
				solGroup.setAttribute("Id", "Siobhan-2019");
				//solGroup.appendChild(a);
				SolutionGroup.item(0).getParentNode().insertBefore(solGroup, SolutionGroup.item(0));
				
				Element metadata = doc.createElement("MetaData");
				solGroup.appendChild(metadata);
				
				Element contributor = doc.createElement("Contributor");
				metadata.appendChild(contributor);
				Node contName = doc.createTextNode("Siobhan O Sullivan");
				contributor.appendChild(contName);
						
				Element date = doc.createElement("Date");
				metadata.appendChild(date);	
				String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
				Node nodeDate = doc.createTextNode(timeStamp);
				date.appendChild(nodeDate);
				
				Element description = doc.createElement("Description");
				metadata.appendChild(description);			
				Node nodeDescription = doc.createTextNode("Produced by Siobhan O Sullivan, UCD");
				description.appendChild(nodeDescription);
			
				
				//the actual solution
				Element solution = doc.createElement("Solution");
				solGroup.appendChild(solution);
				solution.setAttribute("Reference", instance_id);

				//adds events attribute
				Element events = doc.createElement("Events");
				solution.appendChild(events);
			
				
				for(int j=0; j<event_ids.size(); j++){ 

					Element event = doc.createElement("Event");
					events.appendChild(event);
					event.setAttribute("Reference", event_ids.get(j));
					Element duration = doc.createElement("Duration");
					event.appendChild(duration);
					Node duration_names = doc.createTextNode(durations.get(j));
					duration.appendChild(duration_names);
					
					Element time = doc.createElement("Time");
					event.appendChild(time);				
					Random rand = new Random();
					int n = rand.nextInt(times.size());
					time.setAttribute("Reference", times.get(n));
					
					
					Element resources = doc.createElement("Resources");
					event.appendChild(resources);				
					Element resource = doc.createElement("Resource");
					resources.appendChild(resource);
					Random rand2 = new Random();
					int n2 = rand.nextInt(rooms.size());
					resource.setAttribute("Reference", rooms.get(n2));
					}
			
			}
						
			Transformer transformer = TransformerFactory.newInstance().newTransformer(); 
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			
			DOMSource source = new DOMSource(doc);
			
			//write to file
			// StreamResult console = new StreamResult(System.out);
			 StreamResult result = new StreamResult(new FileWriter("SA.xml")); 
			 
			 //write data
		    transformer.transform(source, result);
		   // transformer.transform(source, console);
		    System.out.println("File saved!");		
		
	}catch (Exception e) {
	    e.printStackTrace();
		}		
	}	
		
}

