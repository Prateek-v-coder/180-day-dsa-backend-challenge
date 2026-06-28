package sql;

import java.sql.*;

public class StudentCRUD {
    public static void main(String[] args) {
//        insertStudent("prateek",20,85);
//        insertStudent("vikash",21,85.8);
//        insertStudent("vishal",19,86);
        //deleteStudent("prateek");
        printAllStudent();
     //   updateStudentAge(21,"vishal");


    }
    public static void insertStudent(String name,int age,double marks){
        String query = "INSERT INTO student (name,age,marks) values(?,?,?)";
        try(Connection con = DBConnection2.getConnection();
            PreparedStatement ps = con.prepareStatement(query)){
            ps.setString(1,name);
            ps.setInt(2,age);
            ps.setDouble(3,marks);
            int row = ps.executeUpdate();
            if (row>0){
                System.out.println(row+" rows effected");
            }else{
                System.out.println("error occurs.....");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static void updateStudentName(String setName,String ifName){
        String query = "UPDATE student set name = ? where name = ?";
        try(Connection con = DBConnection2.getConnection();
        PreparedStatement ps = con.prepareStatement(query)){
            ps.setString(1,setName);
            ps.setString(2,ifName);
            int row = ps.executeUpdate();
            if (row>0){
                System.out.println(row+" rows effected");
            }else{
                System.out.println("error occurs.....");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static void updateStudentAge(int setAge,String ifName){
        String query = "UPDATE student SET age = ? WHERE name = ?";
        try(Connection con = DBConnection2.getConnection();
        PreparedStatement ps = con.prepareStatement(query)){
            ps.setInt(1,setAge);
            ps.setString(2,ifName);
            int row = ps.executeUpdate();
            if (row>0){
                System.out.println(row+" rows effected");
            }else{
                System.out.println("error occurs.....");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static void updateStudentMarks(double setMarks,String ifName){
        String query = "UPDATE student SET marks = ? WHERE name = ?";
        try(Connection con = DBConnection2.getConnection();
            PreparedStatement ps = con.prepareStatement(query)){
            ps.setDouble(1,setMarks);
            ps.setString(2,ifName);
            int row = ps.executeUpdate();
            if (row>0){
                System.out.println(row+" rows effected");
            }else{
                System.out.println("error occurs.....");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static void deleteStudent(String name){
        String query = "DELETE FROM student WHERE name=?";
        try(Connection con = DBConnection2.getConnection();
        PreparedStatement ps = con.prepareStatement(query)){
            ps.setString(1,name);
            int row = ps.executeUpdate();
            if (row>0){
                System.out.println(row+" rows effected");
            }else{
                System.out.println("error occurs.....");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static void printAllStudent(){
        String query = " SELECT * FROM student";
        try(Connection con = DBConnection2.getConnection();
        PreparedStatement ps = con.prepareStatement(query)){
            System.out.println("========================================================");
            ResultSet rs = ps.executeQuery();
            System.out.println("Id | Name | Age | Marks");
            while(rs.next()){
                System.out.println(rs.getInt("id")+" | "
                        +rs.getString("name")+" | "+
                        rs.getInt("age")+" | "+
                        rs.getDouble("marks"));
            }
            System.out.println("=========================================================");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static void searchByName(String name){
        String query = "SELECT * FROM student WHERE name = ?";
        try(Connection con = DBConnection2.getConnection();
        PreparedStatement ps = con.prepareStatement(query)){
            ps.setString(1,name);
            System.out.println("========================================================");
            ResultSet rs = ps.executeQuery();
            System.out.println("Id | Name | Age | Marks");
            while(rs.next()){
                System.out.println(rs.getInt("id")+" | "
                        +rs.getString("name")+" | "+
                        rs.getInt("age")+" | "+
                        rs.getDouble("marks"));
            }
            System.out.println("=========================================================");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static void searchByMarks(double marks){
        String query = "SELECT * FROM student WHERE marks = ?";
        try(Connection con = DBConnection2.getConnection();
            PreparedStatement ps = con.prepareStatement(query)){
            ps.setDouble(1,marks);
            System.out.println("========================================================");
            ResultSet rs = ps.executeQuery();
            System.out.println("Id | Name | Age | Marks");
            while(rs.next()){
                System.out.println(rs.getInt("id")+" | "
                        +rs.getString("name")+" | "+
                        rs.getInt("age")+" | "+
                        rs.getDouble("marks"));
            }
            System.out.println("=========================================================");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static void searchByAge(int age){
        String query = "SELECT * FROM student WHERE age = ?";
        try(Connection con = DBConnection2.getConnection();
            PreparedStatement ps = con.prepareStatement(query)){
            ps.setInt(1,age);
            System.out.println("========================================================");
            ResultSet rs = ps.executeQuery();
            System.out.println("Id | Name | Age | Marks");
            while(rs.next()){
                System.out.println(rs.getInt("id")+" | "
                        +rs.getString("name")+" | "+
                        rs.getInt("age")+" | "+
                        rs.getDouble("marks"));
            }
            System.out.println("=========================================================");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
class DBConnection2 {
    private static final String URL = "jdbc:mysql://localhost:3306/Student";
    private static final String User_Name = "root";
    private static final String PassWord = "Rat*#9653";
    public static Connection getConnection () throws SQLException {
        return DriverManager.getConnection(URL,User_Name,PassWord);
    }

}
