package projects;

import java.io.*;

public class Student_record_system {
    public static void main(String[] args) {
        student_record record = new student_record();
//        record.addStudent("prateek verma",21,80);
//        record.addStudent("vikash",22,90);
//        record.addStudent("ratnesh",20,85);
        record.showAllStudent();
        record.searchStudent("vikash");
    }
}
class student_record{
    public void createFile(){
        try{
            File file = new File("src/projects/student_record.txt");
            if(file.createNewFile()){
                System.out.println("file created successfully");
            }else {
                System.out.println("file already exist");
            }
        }catch (Exception e){
            System.out.println(e);
        }

    }
    public void addStudent(String name,int age,float marks){

        try(BufferedWriter br = new BufferedWriter( new FileWriter(  new File("src/projects/student_record.txt"),true))){
            br.write(name+"," +age+","+marks);
            br.newLine();
            System.out.println("student "+name+ "added successfully");
        }
        catch (IOException e){
            System.out.println(e);
        }
    }
    public void showAllStudent(){
        try(BufferedReader br = new BufferedReader(new FileReader(new File("src/projects/student_record.txt")))){
            String line;
            System.out.println("All Student Details ");
            while((line=br.readLine())!=null){
                String[] data = line.split(",");
                System.out.println("Name: "+data[0]+" Age: "+ data[1]+" Marks: "+data[2]);
            }
        }
        catch (IOException e){
            System.out.println(e);
        }
    }
    public void searchStudent(String name){
        try( BufferedReader br = new BufferedReader(new FileReader(new File("src/projects/student_record.txt")))){
            boolean found = false;
            String line;
            while ((line=br.readLine())!=null){
                String[] data = line.split(",");
                if (data[0].equalsIgnoreCase(name)){
                    System.out.println(line);
                    found=true;
                }
            }
            if (!found) System.out.println("student not found....");
        }catch (IOException e){
            System.out.println(e);
        }
    }
}
