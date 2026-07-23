package application;

import entities.SchoolSystem;


import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        SchoolSystem startingSystem = new SchoolSystem();

        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println("====================================");
        System.out.println(" SISTEMA DE GERENCIAMENTO ESCOLAR ");
        System.out.println("====================================");
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

        int confirmation = 0;

        do {
            System.out.println("\n========= Menu ===========: ");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Inserir notas");
            System.out.println("3 - Consultar boletim");
            System.out.println("4 - Listar alunos");
            System.out.println("5 - Estatísticas da turma");
            System.out.println("0 - Sair");
            System.out.println("\n===========================: ");
            confirmation = sc.nextInt();

            switch (confirmation) {
                case 1:
                    startingSystem.registerSudent();
                    break;
                case 2: 
                    startingSystem.insertGrades();
                    break;
                case 3:
                    startingSystem.schoolReport();
                    break;
                case 4: 
                    startingSystem.listStudents();
                    break;
                case 5:
                    startingSystem.showStatistics();
                    break;
                default:
                    if(confirmation != 0){
                        System.out.println("[ERRO] Essa opção não existe no sistema! ");
                    }
                    
                    break;
            }
        } while(confirmation != 0);

        

        System.out.println("\n Agradecemos por utilizar nosso programa! s2");
        
        
        sc.close();
    }
    
}