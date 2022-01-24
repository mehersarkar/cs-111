/**
 * 
 * HeartTransplant class
 * 
 * @author Ana Paula Centeno
 * @author Haolin (Daniel) Jin
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
        this.patients = new Patient[0] ;
        this.survivabilityByAge = new SurvivabilityByAge() ;
        this.survivabilityByCause = new SurvivabilityByCause() ;
    }

    /*
     * Returns patients
     */
    public Patient[] getPatients() {
        return patients ;
     } 

    /*
     * Returns survivabilityByAge
     */
    public SurvivabilityByAge getSurvivabilityByAge() {
        return survivabilityByAge ;
    }

    /*
     * Returns survivabilityByCause
     */
    public SurvivabilityByCause getSurvivabilityByCause() {
        return survivabilityByCause ;
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
        this.patients = new Patient[numberOfLines] ;
        int id = 0 ;
        int ethnicity = 0 ;
        int gender = 0 ;
        int age = 0 ;
        int cause = 0 ;
        int urgency = 0 ;
        int stateOfHealth = 0 ;
        int m = 0 ;
        int[] p = new int[7*numberOfLines] ;

        for(int i = 0; i < patients.length; i++) {
            for(int n = 0; n < p.length; n++) {
                p[n] = StdIn.readInt() ;
            }
            m = i*7 ;
            id = p[0+m] ;
            ethnicity = p[1+m] ;
            gender = p[2+m] ;
            age = p[3+m] ;
            cause = p[4+m] ;
            urgency = p[5+m] ;
            stateOfHealth = p[6+m] ;
            Patient a = new Patient(id, ethnicity, gender, age, cause, urgency, stateOfHealth) ; 
            patients[i] = a ;
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
        this.survivabilityByAge = new SurvivabilityByAge() ;
        int m = 0 ;
        int m1 = 0 ;
        int[] aAndYpt = new int[numberOfLines*2] ;
        int[] a = new int[numberOfLines] ;
        int[] ypt = new int[numberOfLines] ;
        double[] r = new double[numberOfLines] ;

        for(int i = 0; i < numberOfLines*2; i++) {
            aAndYpt[i] = StdIn.readInt() ;
        }
        for(int i = 0; i < numberOfLines; i++) {
            r[i] = StdIn.readDouble() ;
            m = i*2 ;
            m1 = m+1 ;
            a[i] = aAndYpt[m] ;
            ypt[i] = aAndYpt[m1] ;
        }
        for(int i = 0; i < numberOfLines; i++) {
            survivabilityByAge.addData(a[i],ypt[i],r[i]) ;
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
        this.survivabilityByCause = new SurvivabilityByCause() ;
        int m = 0 ;
        int m1 = 0 ;
        int[] cAndYpt = new int[numberOfLines*2] ;
        int[] c = new int[numberOfLines] ;
        int[] ypt = new int[numberOfLines] ;
        double[] r = new double[numberOfLines] ;

        for(int i = 0; i < numberOfLines*2; i++) {
            cAndYpt[i] = StdIn.readInt() ;
        }
        for(int i = 0; i < numberOfLines; i++) {
            r[i] = StdIn.readDouble() ;
            m = i*2 ;
            m1 = m+1 ;
            c[i] = cAndYpt[m] ;
            ypt[i] = cAndYpt[m1] ;
        }
        for(int i = 0; i < numberOfLines; i++) {
            survivabilityByCause.addData(c[i],ypt[i],r[i]) ;
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
        int pAge = 0 ;
        int count = 0 ;

        for(int i = 0; i < patients.length; i++) {
            Patient a = patients[i] ;
            pAge = a.getAge() ;
            if(pAge != 0) {
                if(pAge > age) {
                    count++ ;
                }
            }
        }
        if(count != 0) {
            Patient[] p = new Patient[count] ;
            for(int i = 0; i < patients.length; i++) {
                Patient a = patients[i] ;
                pAge = a.getAge() ;
                for(int n = 0; pAge > age; n++) {
                    p[n] = a ;
                }
            }
            return p ;
        }
  
        return null;
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
        int pCause= 0 ;
        int count = 0 ;

        for(int i = 0; i < patients.length; i++) {
            Patient a = patients[i] ;
            pCause = a.getAge() ;
            if(pCause == cause) {
                count++;
            }
        }
        if(count != 0) {
            Patient[] p = new Patient[count] ;
            for(int i = 0; i < patients.length; i++) {
                Patient a = patients[i] ;
                pCause = a.getCause() ;
                for(int n = 0; pCause == cause; n++) {
                    p[n] = a ;
                }
            }
            return p ;
        }
        return null;
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
        int pUrgency = 0 ;
        int count = 0 ;

        for(int i = 0; i < patients.length; i++) {
            Patient a = patients[i] ;
            pUrgency = a.getCause() ;
            if(pUrgency == urgency) {
                count++ ;
            }
        }
        if(count != 0) {
            Patient[] p = new Patient[count] ;
            for(int i = 0; i < patients.length; i++) {
                Patient a = patients[i] ;
                pUrgency = a.getCause() ;
                for(int n = 0; pUrgency == urgency; n++) {
                    p[n] = a ;
                }
            }
            return p ;
        }
	    return null;
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
        int cause = 0 ;
        int age = 0 ;
        boolean needHeart = true ;
        int year = 5 ;
        int urgency = 0 ;
        double sByCause = 0.0 ;
        double sByAge = 0.0 ;
        double aveSurvivability;
        int countPrimary = 0 ;
        int countSecond = 0 ; 

        for(int i = 0; i < patients.length; i++) {
            Patient a = patients[i] ;
            urgency = a.getUrgency() ;
            needHeart = a.getNeedHeart() ;

            if(needHeart = true) {
                if(urgency == 8) {
                    countPrimary++ ;
                }
                else{
                    countSecond++ ;
                }
            }
        }
        double[] primarySurvivability = new double[countPrimary] ;
        double[] secondSurvivability = new double[countSecond] ;
        int[] primaryAge = new int[countPrimary] ;
        int[] secondAge = new int[countSecond] ;
        int [] sumAge = new int[countPrimary+countSecond] ;

        for(int i = 0; i < patients.length; i++) {
            Patient a = patients[i] ;
            cause = a.getCause() ;
            age = a.getAge() ;
            urgency = a.getUrgency() ;
            needHeart = a.getNeedHeart() ;
            if(age >= 1 && age < 6) {
                age = 1;
            }
            else if(age >= 6 && age < 11) {
                age = 6 ;
            }
            else if(age >= 11 && age < 18) {
                age = 11 ;
            }
            else if(age >= 18 && age < 35) {
                age = 18 ;
            }
            else if(age >= 35 && age < 50) {
                age = 35 ;
            }
            else if(age >= 50 && age < 65) {
                age = 50 ;
            }
            else if(age >= 65 && age < 120) {
                age = 65 ;
            }
            else if(age >= 120) {
                age = 120 ;
            }

            sByCause = survivabilityByCause.getRate(cause,year) ;
            sByAge =survivabilityByAge.getRate(age,year) ;
            aveSurvivability = (sByCause+sByAge)/2 ;

            if(needHeart = true) {
                age = a.getAge() ;
                for(int n = 0; urgency == 8; n++) {
                    primarySurvivability[n] = aveSurvivability ;
                    primaryAge[n] = age ; 
                }
                for(int m = 0; urgency != 8; m++) {
                    secondSurvivability[m] = aveSurvivability ;
                    secondAge[m] = age ;
                }
            }

        }

        int storageAge = 0 ;
        double storageSur = 0.0 ;

        for(int i = 0; i < countPrimary; i++) {
            for(int n = 1; n < countPrimary; n++) {
                if(primarySurvivability[i] < primarySurvivability[n]){
                    storageAge = primaryAge[i] ;
                    storageSur = primarySurvivability[i] ;
                    primaryAge[i] = primaryAge[n] ;
                    primarySurvivability[i] = primarySurvivability[n] ;
                    primarySurvivability[n] = storageSur ;
                    primaryAge[n] = storageAge ;
                }
            }
        }

        for(int i = 0; i < countSecond; i++) {
            for(int n = 1; n < countSecond; n++) {
                if(secondSurvivability[i] < secondSurvivability[n]) {
                    storageAge = secondAge[i] ;
                    storageSur = secondSurvivability[i] ;
                    secondAge[i] = secondAge[n] ;
                    secondSurvivability[i] = secondSurvivability[n] ;
                    secondSurvivability[n] = storageSur ;
                    secondAge[n] = storageAge ;
                }
            }
        }

        for(int i = 0; i < sumAge.length; i++) {
            if(i < countPrimary) {
                sumAge[i] = primaryAge[i] ;
            }
            else{
                sumAge[i] = secondAge[i-countPrimary] ;
            }
        }

        for(int i = 0; i < patients.length; i++) {
            Patient a = patients[i] ;
            age = a.getAge() ;
            if(age == sumAge[0]) {
                a.setNeedHeart(false) ;
                return a ;
            }
        }
	return null;
    }
}