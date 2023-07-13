package services;

import entities.Routine;

import java.util.ArrayList;
import java.util.Scanner;

public class RoutineService {
    Scanner read = new Scanner(System.in);
    public ArrayList<Routine> loadRoutines(ArrayList<Routine> rList){

        Routine r1 = new Routine(rList.size(), "Power Play Workout", 90, 5, "Is bery dificul", true);
        rList.add(r1);
        Routine r2 = new Routine(rList.size(), "Dynamic Fusion Fitness", 60, 4, "A mover la cola", true);
        rList.add(r2);
        Routine r3 = new Routine(rList.size(), "Total Body Blitz", 120, 3, "A chivar como loco", true);
        rList.add(r3);
        Routine r4 = new Routine(rList.size(), "Cardio Core Circuit", 60, 2, "A la cinta y a correr.", true);
        rList.add(r4);
        Routine r5 = new Routine(rList.size(), "Strength and Stamina Challenge", 180, 10, "Traete el bidón de agua.", true);
        rList.add(r5);

        return rList;
    }
    public ArrayList<Routine> createRoutines(ArrayList<Routine> rList){
        String input = "a";
        int cont = rList.size();

        while (!input.equalsIgnoreCase("q")) {
            Routine routine = new Routine();

            System.out.println("Press 'Q' at any time to exit");
            System.out.println("in [String] routineName: ");
            input = read.nextLine();
            if(exit(input)){
                break;
            }
            routine.setRoutineName(input);

            System.out.println("in [double] duration (in minutes): ");
            input = read.nextLine();
            if(exit(input)){
                break;
            }
            routine.setDuration(Double.parseDouble(input));

            System.out.println("in [int] difficultyLevel (1 to 10): ");
            input = read.nextLine();
            if(exit(input)){
                break;
            }
            routine.setDifficultyLevel(Integer.parseInt(input));

            System.out.println("in [String] description: ");
            input = read.nextLine();
            if(exit(input)){
                break;
            }
            routine.setDescription(input);

            routine.setIdRoutine(cont);
            routine.setActive(true);
            rList.add(routine);
        }
        return rList;
    }
    public void listRoutines(ArrayList<Routine> rList){
        System.out.println("-----------------------------------------");
        System.out.println("=*=*=*=*=*=*=*=*ROUTINES=*=*=*=*=*=*=*=*=");

        for(int i = 0; i < rList.size(); i++) {

            if(rList.get(i).isActive()){
                System.out.println("-Client Code-|-----------Client Name------");
                System.out.println("\t"+rList.get(i).getIdRoutine() +"\t\t |\t" + rList.get(i).getRoutineName());
                System.out.println("----------------DETAILS------------------");
                System.out.println("Duration:\t\t |\t" +rList.get(i).getDuration());
                System.out.println("Difficulty Level:|\t" +rList.get(i).getDifficultyLevel());
                System.out.println("Description:\t |\t" +rList.get(i).getDescription());
                System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
            }
        }

    }
    private boolean exit(String e){
        if(e.equalsIgnoreCase("Q")){
            return true;
        }
        return false;
    }

}
