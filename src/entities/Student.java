package entities;



public class Student {
    
    private int enrolment;
    private String name;
    // private LocalDate birthdayDate;
    private double[] grades = new double[4];

    // constructor 

    public Student(int enrolment, String name){
        this.enrolment = enrolment;
        this.name = name;
        this.grades = new double[4];
        // this.birthdayDate = birthDate;
    }

    public int getEnrolment(){
        return enrolment;
    }

    public String getName(){
        return name;
    }

    public double[] getGrades(){
        return grades;
    }
    public void setGrades(int indice, double grade){
        this.grades[indice] = grade;
    }

    // metodos para calcular media e verificar aprovação 

    public double averageCalculation(){
        
        double sumOfGrades = 0.00;

        for (int i = 0; i < grades.length; i++){
            sumOfGrades = sumOfGrades + grades[i];
        }   

        return sumOfGrades / 4;
    }
}
