import java.util.Scanner;
import java.io.*;
import java.time.LocalDate;
public class Consultancy_test {

	public static void main(String[] args) throws IOException {
		
		Practice Hospital = new Practice(); // adds a new practice 
		
		Name alexName = new Name("Alex","buck");// sets up names needed for people
		Name jamesName = new Name("James","may");
		Name timName = new Name("Tim","Jacobs");
		Name jackName = new Name("Jack","may");
		Name fredName = new Name("Fred","Simmons");
		Name brendaName = new Name("Brenda","Murphy");
		
		
		Consultant jack = new Consultant(jackName,"R583","4023348512","cardiology");// sets up 3 consultants
		Consultant fred = new Consultant(fredName,"R648","4024755067","Anesthesiologist");
		Consultant brenda = new Consultant(brendaName,"R486","0874456717","Migrane Consult");
		
		Hospital.addConsultant(fred);// adds consultants to practice 
		Hospital.addConsultant(jack);
		Hospital.addConsultant(brenda);
		
		Patient alex = new Patient(alexName,"e621","0873365171","covid 19",5); // sets up 3 patients
		Patient james = new Patient(jamesName,"e563","3114472618","Stroke",3); 
		Patient tim = new Patient(timName,"e112","0314758174","Brething problems",2);
		
		
		
		Visit v1 = new Visit("everything fine");// sets up 5 visits
		Visit v2 = new Visit("drowsy");
		Visit v3 = new Visit("cough");
		Visit v4 = new Visit("sneeze");
		Visit v5 = new Visit("he was annoyed");


		

		james.addVisit(v1);// adds 1 visit to james
		
		tim.addVisit(v2);// adds 4 visits to tim
		tim.addVisit(v3);
		tim.addVisit(v4);
		tim.addVisit(v5);
		
		jack.addPatients(alex);// adds alex as a patient to jack
		jack.addPatients(james);// adds james as a patient to jack
		
		fred.addPatients(tim);// adds tim as a patient to fred
		

		
		Hospital.showConsultsPatientsVisits(); // shows everything
		
		
		int exit =0;// exit verable for menu
		Scanner reader = new Scanner(System.in);// sets up the scanner
		while (exit ==0) {//prints menu
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("Menu ");
			System.out.println("1. Record a Patient visit ");
			System.out.println("2. Display all patients of a patricular Consultant");
			System.out.println("3. Diplay all consultant followed by their patients and visits");
			System.out.println("4. Load information from a text file");
			System.out.println("5. Quit");
			System.out.println("Enter the number of function");
			
			int menuChoice = reader.nextInt();// asks which option the user wants to select
			String empty= reader.nextLine();// nextInt always acts weird for the next nextLine method so this just clears it
			
			while (menuChoice ==1) {// asks for the name of a patient and adds a visit
				System.out.println("Enter name of Patient you want to add a visit too");
				String choice1 = reader.nextLine();
				Patient foundPatient =Hospital.findPatient(choice1);
				
				System.out.println("Any notes for the visit?");
				String notes = reader.nextLine();
				Visit newvisit = new Visit(notes);
				foundPatient.addVisit(newvisit);
				menuChoice=0;
			}
			
			while (menuChoice ==2) {// asks for the name of a consultant and shows you all their patients
				System.out.println("What is the name of the consultant you want to see the patients off? ");
				String choice2 = reader.nextLine();
				Consultant foundConsult =Hospital.findConsultant(choice2);
				
				foundConsult.showPatients();
				menuChoice=0;
			}
			while (menuChoice ==3) {//shows everything
				Hospital.showConsultsPatientsVisits();
				menuChoice=0;
			}
			
			while (menuChoice ==4) { // adds the data from Practice.txt
				String consultName =null;
				
				String patientName =null;
				FileReader freader = new FileReader("Practice.txt");
				BufferedReader inputFile = new BufferedReader(freader);
				
				String str = inputFile.readLine();
				
				while (str!= null){
					
					
					String words[] = str.split(",");
					
					if ("Consultant".equals(words[0])) { 
						consultName = words[2];
						Name newName = new Name(words[2],words[1]);
						Consultant newconsult = new Consultant(newName,words[3],words[4],words[5]);
						Hospital.addConsultant(newconsult);

					}
					else if ("Patient".equals(words[0])) {
						patientName= words[2];
						int i = Integer.parseInt(words[6]);
						Name newName = new Name(words[2],words[1]);
						Patient newPatient = new Patient(newName,words[3],words[4],words[5],i);
						Consultant consult = Hospital.findConsultant(consultName);
						consult.addPatients(newPatient);
						
					}
					else if ("Visit".equals(words[0])) {
						Visit newvisit = new Visit(words[2]);
						Patient patient = Hospital.findPatient(patientName);
						patient.addVisit(newvisit);
					}
					
					str= inputFile.readLine();
					}
				inputFile.close();
				System.out.println("done");
				menuChoice=0;
				
				
			}
			if (menuChoice ==5) {//stops the menu loop
				exit=1;
			}
			
			
		}
				
	}

}
