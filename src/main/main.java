package main;

import obj.equip;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class main {
    static File registre = new File("registre_equips.txt");
    static File bkp = new File(".registre_equips.bkp");
    static HashMap<String, equip> allEquip = new HashMap<String, equip>();


    public static void main(String[] args) {
        int opcion = 0;
        try {
            insertTextToHash(registre);
            while (opcion != 6) {
                BufferedReader brr = new BufferedReader(new InputStreamReader(System.in));
                showMenu();
                opcion = Integer.parseInt(brr.readLine());
                menuOption(opcion);
            }
        } catch (Exception e) {
        }
    }

    //Ensenya tot el menu principal
    public static void showMenu() {
        System.out.println("-----Menu Principal-----");
        System.out.println("1-Registrar nou equip en ficher");
        System.out.println("2-Mostrar tots els equips registrats");
        System.out.println("3-Mostrar un equip concret per id");
        System.out.println("4-Fer copia seguridad");
        System.out.println("5-Eliminar ficher");
        System.out.println("6-Sortida del programa");
    }

    //Al rebre la opcio seleccionara la opcio y el metode corresponent
    public static void menuOption(int opcion) {
        switch (opcion) {
            case 1:
                System.out.println("1-Registrar nou equip en ficher");
                registerPC();
                insertAllInHash(registre);
                insertTextToHash(registre);
                break;
            case 2:
                System.out.println("2-Mostrar tots els equips registrats");
                showAll();
                break;
            case 3:
                System.out.println("3-Mostrar un equip concret per id");
                showById();
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                System.out.println("Sortida del programa, adeu");
                break;

        }
    }

    //Registre el equip al Hashmap allEquip
    public static void registerPC() {
        try {
            BufferedReader rpc = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Nou Equip:");
            System.out.println("Identificador(alfanumeric):");
            String id = rpc.readLine();
            System.out.println("Sistema operatiu:");
            String so = rpc.readLine();
            System.out.println("Processador");
            String processador = rpc.readLine();
            System.out.println("RAM(en GB):");
            double ram = Double.parseDouble(rpc.readLine());
            System.out.println("Tamany disc dur(en GB):");
            double hdd = Double.parseDouble(rpc.readLine());
            System.out.println("Estat (funciona/fora de servei)");
            String status = rpc.readLine();

            equip n = new equip(id, so, processador, ram, hdd, status);
            allEquip.put(id, n);

            System.out.println(n);

        } catch (Exception e) {

        }
    }

    //Inserta tot lo que esta en el Hashmap allEquip al txt registre_equips
    public static void insertAllInHash(File doc) {
        try {
            FileWriter fw = new FileWriter(doc);
            BufferedWriter bw = new BufferedWriter(fw);

            boolean emp = allEquip.isEmpty();
            System.out.println(emp);
            if(emp == false){
                for (Map.Entry<String,equip> entry : allEquip.entrySet()) {
                    String finalText =
                                    entry.getValue().getId()+System.getProperty("line.separator")+
                                    entry.getValue().getSistema()+System.getProperty("line.separator")+
                                    entry.getValue().getProcessador()+System.getProperty("line.separator")+
                                    entry.getValue().getRam()+System.getProperty("line.separator")+
                                    entry.getValue().getHardDisk()+System.getProperty("line.separator")+
                                    entry.getValue().getEstat()+System.getProperty("line.separator");
                    bw.write(finalText);
                }
                bw.close();
            }
            else{

            }
        }catch (Exception e){

        }

    }

    //Inserta tot lo que esta en el document de txt registre_equips al Hashmap allEquip
    public static void insertTextToHash(File doc) {
        try {
            FileReader fr = new FileReader(doc);
            BufferedReader br = new BufferedReader(fr);
            String linea1;
            int counter = 0;

            String id="";
            String sistema="";
            String processador="";
            double ram=0;
            double hardDisk=0;
            String estat="";

            while ((linea1 = br.readLine()) != null) {
                switch (counter){
                    case 0:
                        id=linea1;
                        break;
                    case 1:
                        sistema=linea1;
                        break;
                    case 2:
                        processador=linea1;
                        break;
                    case 3:
                        ram=Double.parseDouble(linea1);
                        break;
                    case 4:
                        hardDisk=Double.parseDouble(linea1);
                        break;
                    case 5:
                        estat=linea1;
                        equip n = new equip(id,sistema,processador,ram,hardDisk,estat);
                        allEquip.put(id,n);
                        break;
                }
                if(counter != 5){
                    counter++;
                }else{
                    counter=0;
                }
            }
            br.close();
        }
        catch (Exception e){

        }
    }

    //Ensenya tot lo que estigui en el Hashmap de allEquip
    public static void showAll(){
        for (Map.Entry<String,equip> entry : allEquip.entrySet()){
            String finalText =
                    "---------------------------------------------------------------"+System.getProperty("line.separator")+
                    entry.getValue().getId()+System.getProperty("line.separator")+
                            entry.getValue().getSistema()+System.getProperty("line.separator")+
                            entry.getValue().getProcessador()+System.getProperty("line.separator")+
                            entry.getValue().getRam()+System.getProperty("line.separator")+
                            entry.getValue().getHardDisk()+System.getProperty("line.separator")+
                            entry.getValue().getEstat()+System.getProperty("line.separator")+
                            "---------------------------------------------------------------";
            System.out.println(finalText);
        }
    }

    //Demana la entrada del identificador, busca aquet en el Hashmap i mostra tot si el troba
    public static void showById() {
        try {
            BufferedReader sbi = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Identificador(alfanumeric):");
            String id = sbi.readLine();

            for (Map.Entry<String,equip> entry : allEquip.entrySet()){
                if(id.equals(entry.getValue().getId())){
                    String finalText =
                            "---------------------------------------------------------------"+System.getProperty("line.separator")+
                                    entry.getValue().getId()+System.getProperty("line.separator")+
                                    entry.getValue().getSistema()+System.getProperty("line.separator")+
                                    entry.getValue().getProcessador()+System.getProperty("line.separator")+
                                    entry.getValue().getRam()+System.getProperty("line.separator")+
                                    entry.getValue().getHardDisk()+System.getProperty("line.separator")+
                                    entry.getValue().getEstat()+System.getProperty("line.separator")+
                                    "---------------------------------------------------------------";
                    System.out.println(finalText);
                }
                else {
                    System.out.println("No s'ha encontrat ningun equip amb el id:"+id);
                }
            }
        }
        catch (Exception e){

        }
    }

    //Metodo no acabat
    public static void copySecret() {

    }

    //Metodo no acabat
    public static void removeFichero() {

    }
}
