/**
 * 
 * HeartTransplant class
 * 
 * @author Ana Paula Centeno
 * @author Haolin (Daniel) Jin
 *  
 *   Ayush Gupta
 *   ag2049@scarletmail.rutgers.edu
 *   ag2049
 * 
 * 
 */
public class HeartTransplant {

    // patient array, each Patient is read from the data file
    private Patient[] patients;

    // SurvivabilityByAge array, each rate is read from data file
    private SurvivabilityByAge survivabilityByAge;

    // SurvivabilityByCause array, each rate is read from data file
    private SurvivabilityByCause survivabilityByCause;

    /*
     * Default constructor
     * Initializes patients to null.
     * Initializes survivabilityByAge to null.
     * Initializes survivabilityByCause to null. 
     */
    public HeartTransplant() {
        // WRITE YOUR CODE HERE
        patients = null;
        survivabilityByAge = null; 
        survivabilityByCause = null; 
    }

    /*
     * Returns patients
     */
    public Patient[] getPatients() {
        // WRITE YOUR CODE HERE
        return patients; 

     } 

    /*
     * Returns survivabilityByAge
     */
    public SurvivabilityByAge getSurvivabilityByAge() {
        // WRITE YOUR CODE HERE
        return survivabilityByAge; 
    }

    /*
     * Returns survivabilityByCause
     */
    public SurvivabilityByCause getSurvivabilityByCause() {
        // WRITE YOUR CODE HERE
        return survivabilityByCause; 
    }

    /*
     * 1) Initialize the instance variable patients array with numberOfLines length.
     * 
     * 2) Reads from the command line data file, use StdIn.readInt() to read an integer.
     *    File Format: 
     *      ID, ethnicity, Gender, Age, Cause, Urgency, State of health
     * 
     *    Each line refers to one Patient, all values are integers.
     * 
     */
    public void readPatients (int numberOfLines) {
        // WRITE YOUR CODE HERE
        patients = new Patient[numberOfLines];
        int id = 0, ethnicity = 0, gender = 0, age = 0, cause = 0, urgency = 0, stateOfHealth = 0;

         for(int i = 0; i<patients.length; i++){  
            id = 0; 
            ethnicity = 0; 
            gender = 0; 
            age = 0; 
            cause = 0;
            urgency = 0; 
            stateOfHealth = 0;

            for (int j = 0; j < 7; j++){
                if (j== 0)
                    id = StdIn.readInt();
                else if (j == 1)
                    ethnicity = StdIn.readInt();
                else if (j == 2)
                    gender = StdIn.readInt();
                else if (j == 3)
                    age = StdIn.readInt();
                else if (j == 4)
                    cause = StdIn.readInt();
                else if (j == 5)
                    urgency = StdIn.readInt();
                else if (j == 6)
                    stateOfHealth = StdIn.readInt();
            }
            patients[i] = new Patient (id, ethnicity, gender, age, cause, urgency, stateOfHealth);
             
         }

    }

    /*
     * 1) Initialize the instance variable survivabilityByAge with a new survivabilityByAge object.
     * 
     * 2) Reads from the command line file to populate the object. 
     *    Use StdIn.readInt() to read an integer and StdIn.readDouble() to read a double.
     * 
     *    File Format: Age YearsPostTransplant Rate
     *    Each line refers to one survivability rate by age.
     * 
     */
    public void readSurvivabilityByAge (int numberOfLines) {
        // WRITE YOUR CODE HERE
        survivabilityByAge = new SurvivabilityByAge();
    
        int age = 0; 
        int year = 0; 
        double rate = 0.0; 

        for(int i = 0; i<numberOfLines; i++){
            age = 0; 
            year = 0; 
            rate = 0.0; 

            for (int j = 0; j<3; j++){
                if (j == 0)
                    age = StdIn.readInt();
                else if (j == 1)
                    year = StdIn.readInt();
                else if (j == 2)
                    rate =  StdIn.readDouble();
            }
            survivabilityByAge.addData(age, year, rate);
        }

    }

    /*
     * 1) Initialize the instance variable survivabilityByCause with a new survivabilityByCause object.
     * 
     * 2) Reads from the command line file to populate the object. Use StdIn.readInt() to read an 
     *    integer and StdIn.readDouble() to read a double.
     * 
     *    File Format: Cause YearsPostTransplant Rate
     *    Each line refers to one survivability rate by cause.
     * 
     */
    public void readSurvivabilityByCause (int numberOfLines) {
        // WRITE YOUR CODE HERE
        survivabilityByCause = new SurvivabilityByCause();

        int cause = 0; 
        int year = 0; 
        double rate = 0.0; 

        for(int i = 0; i<numberOfLines; i++){
            cause = 0; 
            year = 0; 
            rate = 0.0; 
            
            for (int j = 0; j<3; j++){
                if (j == 0)
                    cause =  StdIn.readInt();
                else if (j == 1)
                    year =  StdIn.readInt();
                else if (j == 2)
                    rate = StdIn.readDouble();
            }

            survivabilityByCause.addData(cause, year, rate);
        }

    }
    
    /*
     * Returns a Patient array containing the patients, 
     * from the patients array, that have age above the parameter age.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of Patients with age above the parameter age.
     * 
     * Return null if there is no Patient with age above the 
     * parameter age.
     */ 
    public Patient[] getPatientsWithAgeAbove(int age) {
        // WRITE YOUR CODE HERE
        int numOfPatientsWithGreaterAge = 0; 
        for (int i = 0; i<patients.length; i++){
            if (patients[i].getAge() >= age){
                numOfPatientsWithGreaterAge++;
            }
        }

        if (numOfPatientsWithGreaterAge == 0)
            return null;

        Patient [] newP = new Patient[numOfPatientsWithGreaterAge];
        int counter = 0; 
            for (int x = 0; x<patients.length; x++){
                if (patients[x].getAge() > age){
                    newP[counter] = patients[x];
                    counter++;
                }
            }
            return newP;

    }

    

    /*
     * Returns a Patient array containing the patients, from the patients array, 
     * that have the heart condition cause equal to the parameter cause.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of Patients with the heart condition cause equal to the parameter cause.
     * 
     * Return null if there is no Patient with the heart condition cause 
     * equal to the parameter cause.
     */ 
    public Patient[] getPatientsByHeartConditionCause(int cause) {

        // WRITE YOUR CODE HERE
        int numOfPatientsWithCause = 0; 
        for (int i = 0; i<patients.length; i++){
            if (patients[i].getCause() == cause){
                numOfPatientsWithCause++;
            }
        }

        if (numOfPatientsWithCause == 0)
            return null;

        Patient [] newP = new Patient[numOfPatientsWithCause];
        int counter = 0; 
            for (int x = 0; x<patients.length; x++){
                if (patients[x].getCause() == cause){
                    newP[counter] = patients[x];
                    counter++;
                }
            }
            return newP;
    }
    

    /*
     * Returns a Patient array containing patients, from the patients array,
     * that have the state of health equal to the parameter state.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of Patients with the state of health equal to the parameter state.
     * 
     * Return null if there is no Patient with the state of health 
     * equal to the parameter state.
     */ 
    public Patient[] getPatientsByUrgency(int urgency) {

        // WRITE YOUR CODE HERE
        int numOfPatientsWithUregency = 0; 
        for (int i = 0; i<patients.length; i++){
            if (patients[i].getUrgency() == urgency){
                numOfPatientsWithUregency++;
            }
        }

        if (numOfPatientsWithUregency == 0)
            return null;
        
        Patient [] newP = new Patient[numOfPatientsWithUregency];
        int counter = 0; 
            for (int x = 0; x<patients.length; x++){
                if (patients[x].getUrgency() == urgency){
                    newP[counter] = patients[x];
                    counter++;  
                }
            }
            return newP;
	
    }

    /*
     * Assume there is a heart available for transplantation surgery.
     * Also assume that the heart is of the same blood type as the
     * Patients on the patients array.
     * This method finds the Patient to be the recepient of this
     * heart.
     * 
     * The method returns a Patient from the patients array with
     * he highest potential for survivability after the transplant.
     * 
     * Assume the patient returned by this method will receive a heart,
     * therefore the Patient will no longer need a heart.
     * 
     * There is no correct solution, you may come up with any 
     * function to find the patient with the highest potential 
     * for survivability after the transplant.
     */ 
    public Patient getPatientForTransplant () {
	// WRITE YOUR CODE HERE
        int [] scaleOfCriticalness = new int[patients.length];
        
        //adding 1 to scale if urgency is 9 compared to 8 
        for (int x = 0; x< patients.length; x++){
            if(patients[x].getNeedHeart() ==true){
             //adding a number if they urgency is extreme
            if (patients[x].getUrgency() ==9)
                scaleOfCriticalness[x] += 1; 
               
            //adding corresponding number to scale if based on cause number (1-4)
            scaleOfCriticalness[x] += patients[x].getCause(); 

            //adding corresponding number (1-3) based on their health
            if (patients[x].getStateOfHealth()== 5) //poor health
                scaleOfCriticalness[x] += 3; 
            else if (patients[x].getStateOfHealth()== 6) //good health
                scaleOfCriticalness[x] += 2; 
            else //excellent health
                scaleOfCriticalness[x] += 1; 
        }


    }
        int max = scaleOfCriticalness[0]; 
        int maxIndex = 0;
        for (int i = 1; i<scaleOfCriticalness.length; i++){
            if (scaleOfCriticalness[i]>max){
                max = scaleOfCriticalness[i];
                maxIndex = i; 
            }
        }
        patients[maxIndex].setNeedHeart(false);
        return patients[maxIndex];
    }
}
