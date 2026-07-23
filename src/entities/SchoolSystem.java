package entities;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;


public class SchoolSystem {
    
    Scanner sc = new Scanner(System.in);

    private List<Student> list_of_students = new ArrayList<>();


    public void registerSudent(){

        boolean validData = false;

        int enrolment = 0;
        String enrolmentStr = " ";
        String name = " ";

        while (validData == false){
            System.out.println("\n====================================");
            System.out.println("CADASTRO DE ALUNOS");
            System.out.println("====================================\n");
            System.out.println(" > Matrícula: ");
            enrolmentStr = sc.nextLine();
            System.out.println(" > Nome do aluno(a): ");
            name = sc.nextLine();

            if (name == null || name.trim().isEmpty() || enrolmentStr == null || enrolmentStr.trim().isEmpty()){
                System.out.println("[ERRO] DADOS INVÁLIDOS. Permaneça no sistema de cadastro ou volte ao menu inicial. ");
            } else {
                enrolment = Integer.parseInt(enrolmentStr);
                validData = true;
            }
            
        }
           
        list_of_students.add(new Student(enrolment, name));
        System.out.println("\nSTATUS: Aluno cadastrado com sucesso! ");
        
    }
    
    public void insertGrades(){
        Student student = null;
        double[] grades = new double[4];
        System.out.println("\n====================================");
        System.out.println("INSERINDO NOTAS");
        System.out.println("====================================\n");
        System.out.println(" > Informe o número da matrícula do(a) aluno(a) para inserir as notas:");
        int enrolment_i = sc.nextInt();
        
        for (Student s : list_of_students) {
            if (s.getEnrolment() == enrolment_i) {
                student = s;
            }
        }

        for(int i = 0; i < 4; i++){
            System.out.println(" - Informe a " + (i + 1) + "° nota: ");
            grades[i] = sc.nextDouble();

            student.setGrades(i, grades[i]);
        }

        sc.nextLine();
    }

    public void schoolReport(){
        Student student = null;

        System.out.println("\n====================================");
        System.out.println("BOLETIM");
        System.out.println("====================================\n");

        System.out.println(" > Informe o número da matrícula do aluno: ");
        int enrolment_i = sc.nextInt();

        for(Student s : list_of_students){
            if(s.getEnrolment() == enrolment_i){
                student = s;
            }
        }

        System.out.println(" - Nome do aluno: " + student.getName() + "\n");

        for(int i = 0; i < 4; i++){
            System.out.println( (i + 1 ) + "° Nota: " + student.getGrades()[i]);
        }

        double average = student.averageCalculation();

         System.out.println("\n Média das Notas: " + average);    

            if(average >= 6){
                System.out.println("O ALUNO(A) " + student.getName() + " FOI APROVADO! ");
            } else{
                System.out.println("O ALUNO(A) " + student.getName() + " FOI REPROVADO! ");
            }
        

    }
   
    public void listStudents(){

        System.out.println("\n====================================");
        System.out.println("LISTA DE ALUNOS: ");
        System.out.println("====================================\n");

        for(int i = 0; i < list_of_students.size(); i++){
            Student student = list_of_students.get(i);
            System.out.println((i + 1) + " - " + student.getName());
            
        }
    }

    public void showStatistics(){

        int passed = 0;
        int failed = 0;
        double sumOfAllAverages = 0.00;
        double classAverage = 0.00;
        double highestAverage = 0.00;
        double lowestAverage = 10.0;
        String studentHighestAverage = "";
        String studentLowestAverage = "";

        System.out.println("====================================");
        System.out.println("ESTATÍSTICAS DA TURMA");
        System.out.println("===================================="); 

        System.out.println(" - Quantidade total de alunos: " + list_of_students.size() + "\n");

        for(int i = 0; i < list_of_students.size(); i++){
            Student student = list_of_students.get(i);
            if(student.averageCalculation() >= 6.00){
                passed += 1;
            } else{
                failed += 1;
            }
        }

        System.out.println(" - Quantidade de aprovados: " + passed + "\n");
        System.out.println(" - Quantidade de reprovados: " + failed + "\n");

        for(int i = 0; i < list_of_students.size(); i++){
            Student student = list_of_students.get(i);
            sumOfAllAverages += student.averageCalculation();
        }

        classAverage = sumOfAllAverages / list_of_students.size();

        System.out.println("Média da turma: " + classAverage + "\n");

        for(int i = 0; i < list_of_students.size(); i++){
            Student student = list_of_students.get(i);

            if (student.averageCalculation() > highestAverage){
                highestAverage = student.averageCalculation();
                studentHighestAverage = student.getName();
            }

            if(student.averageCalculation() < lowestAverage){
                lowestAverage = student.averageCalculation();
                studentLowestAverage = student.getName();
            }
        }

        System.out.println("Aluno(a) com maior média: " + studentHighestAverage + "\n");
        System.out.println("Maior média: " + highestAverage + "\n");
        System.out.println("Aluno com menor média: " + studentLowestAverage + "\n");
        System.out.println("Menor média: " + lowestAverage + "\n");
        

    }

}
