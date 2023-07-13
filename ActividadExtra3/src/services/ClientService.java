package services;

import entities.Client;
import entities.Routine;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ClientService {
    RoutineService rService = new RoutineService();
    Scanner read = new Scanner(System.in);
    public ArrayList<Client> createClient (ArrayList<Client> cList,  ArrayList<Routine> rList){

        String input = "a";
        int cont = cList.size();

        while (!input.equalsIgnoreCase("q")){

            Client client = new Client();

            System.out.println("in [String] name:");
            System.out.println("Press 'Q' to exit");
            input = read.nextLine();
            if(exit(input)){
                break;
            }
            client.setName(input);

            System.out.println("in [int] Age:");
            input = read.nextLine();
            if(exit(input)){
                break;
            }
            client.setAge(Integer.parseInt(input));

            System.out.println("in [double] height: ");
            input = read.nextLine();
            if(exit(input)){
                break;
            }
            client.setHeight(Double.parseDouble(input));

            System.out.println("in [double] weight: ");
            input = read.nextLine();
            if(exit(input)){
                break;
            }
            client.setWeight(Double.parseDouble(input));

            System.out.println("in [String] objective: ");
            input = read.nextLine();
            if(exit(input)){
                break;
            }
            client.setObjective(input);

            System.out.println("in [int] routineID (0 - 4): ");
            input = read.nextLine();
            if(exit(input)){
                break;
            }
            client.setRoutine(rList.get(Integer.parseInt(input)));

            client.setIdClient(cont);
            client.setActiveClient(true);

            cont++;
            cList.add(client);
            waitKey();
        }

        return cList;
    }
    public void showClients(ArrayList<Client> cList){
        System.out.println("-----------------------------------------");
        System.out.println("=*=*=*=*=*=*=*=*=CLIENTS=*=*=*=*=*=*=*=*=");

        for(int i = 0; i < cList.size(); i++) {
            if(cList.get(i).isActiveClient()){
                System.out.println("-Client Code |-----------Client Name------");
                System.out.println("\t"+cList.get(i).getIdClient() +"\t\t |\t" + cList.get(i).getName());
                System.out.println("----------------DETAILS------------------");
                System.out.println("Height:\t\t |\t\t" +cList.get(i).getHeight());
                System.out.println("Weight:\t\t |\t\t" +cList.get(i).getWeight());
                System.out.println("Age:\t\t |\t\t" +cList.get(i).getAge());
                System.out.println("Objective:\t |\t\t" +cList.get(i).getObjective());
                System.out.println("Routine name:|\t\t" + cList.get(i).getRoutine().getRoutineName());
                System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
            }
        }
    }
    public ArrayList<Client> deleteClient (ArrayList<Client> cList){
        showClients(cList);
        String input;
        int clientId;

        System.out.println("in [int] Client Code that you wish to delete");
        input = read.nextLine();
        clientId = Integer.parseInt(input);
        /*TODO: Validate clientID*/
        System.out.println("Are you sure you want to delete '"+ cList.get(clientId).getName() +"'s details?");
        System.out.println("Y - Yes");
        System.out.println("N - No");
        input = read.nextLine();

        //If your ID is set to the person's ID and not an automatic one, use this.
        //clientList.removeIf(client -> client.getClientId() == clientId)
        //:D

        if (input.equalsIgnoreCase("y")){
            cList.get(clientId).setActiveClient(false);
        } else if (input.equalsIgnoreCase("n")) {
            System.out.println("The client has NOT been deleted.");
        } else {
            System.out.println("Incorrect option.");
        }

        return cList;
    }
    public ArrayList<Client> updateClient (ArrayList<Client> cList, ArrayList<Routine> rList){
        String input;
        int clientID;

        showClients(cList);
        System.out.println("Which client do you wish to update?");
        System.out.println("Select an ID...");
        input = read.nextLine();
        clientID = Integer.parseInt(input);

//    private String name;
//    private int age;
//    private double height;
//    private double weight;
//    private String objective;
//    private boolean isActiveClient;
//    private Routine routine;

        System.out.println("Do you wish to modify:");
        System.out.println("1 - Name");
        System.out.println("2 - Height");
        System.out.println("3 - Weight");
        System.out.println("4 - Objective");
        System.out.println("5 - Is an active client?");
        System.out.println("6 - routine");
        System.out.println("0 - Cancel");
        input = read.nextLine();

        switch (Integer.parseInt(input)){
            case 1 -> {
                System.out.println("Input new name:");
                input = read.nextLine();
                String newName = input;

                if (confirm(cList.get(clientID).getName())) {
                    cList.get(clientID).setName(newName);
                }
            }
            case 2 ->{
                System.out.println("Input new height:");
                input = read.nextLine();
                double newHeight = Double.parseDouble(input);

                if (confirm(cList.get(clientID).getName())) {
                    cList.get(clientID).setHeight(newHeight);
                }
            }
            case 3 ->{
                System.out.println("Input new height:");
                input = read.nextLine();
                double newWeight = Double.parseDouble(input);

                if (confirm(cList.get(clientID).getName())) {
                    cList.get(clientID).setWeight(newWeight);
                }
            }
            case 4 ->{
                System.out.println("Input new objective:");
                input = read.nextLine();
                String newObjective = input;

                if (confirm(cList.get(clientID).getName())) {
                    cList.get(clientID).setName(newObjective);
                }
            }
            case 5 ->{
                System.out.println("(de)activate membership?");
                cList.get(clientID).setActiveClient(confirm(cList.get(clientID).getName()));
            }
            case 6 ->{
                System.out.println("Assign new routine:");
                rService.listRoutines(rList);

                input = read.nextLine();
                int newRoutineID = Integer.parseInt(input);

                if (confirm(cList.get(clientID).getName())) {
                    cList.get(clientID).setRoutine(rList.get(newRoutineID));
                }

            }
            case 0 -> {
                return cList;
            }
            default -> System.out.println("Incorrect option");
        }
        return cList;
    }
    private boolean exit(String e){
        if(e.equalsIgnoreCase("Q")){
            return true;
        }
       return false;
    }
    public void waitKey(){
        String opt;
        System.out.println("Press 'enter' to continue...");
        opt = read.nextLine();
    }
    private boolean confirm(String name){
        String input;
        System.out.println("Are you sure you want to delete '"+ name +"'s details?");
        System.out.println("Y - Yes");
        System.out.println("N - No");
        input = read.nextLine();

        if (input.equalsIgnoreCase("y")){
            System.out.println("The client's info has been updated");
            return true;
        } else if (input.equalsIgnoreCase("n")) {
            System.out.println("The client has NOT been modified.");
            return false;
        } else {
            System.out.println("Incorrect option.");
            return false;
        }
    }
}
