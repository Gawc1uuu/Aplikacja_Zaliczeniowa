import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class DBManager {

    DefaultComboBoxModel comboBoxModel1 = new DefaultComboBoxModel();
    DefaultComboBoxModel comboBoxModel2 = new DefaultComboBoxModel();


   ArrayList<String> results;


    public void delete(String sqlDelete){
        try{
            Connection conn = getConnection();
            PreparedStatement delete = conn.prepareStatement(sqlDelete);
            delete.executeUpdate();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public void select(String sqlSelect,String columnLabel1,String columnLabel2){
        int i=0;
        try{
            Connection conn = getConnection();
            PreparedStatement select = conn.prepareStatement(sqlSelect);
            ResultSet result = select.executeQuery();
            while(result.next()){
                comboBoxModel2.addElement( result.getString(columnLabel1)+" "+result.getString(columnLabel2));
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public void select(String sqlSelect,String columnLabel1,String columnLabel2,String columnLabel3){
        int i=0;
        try{
            Connection conn = getConnection();
            PreparedStatement select = conn.prepareStatement(sqlSelect);
            ResultSet result = select.executeQuery();
            while(result.next()){
                comboBoxModel1.addElement(result.getString(columnLabel1)+" "+result.getString(columnLabel2)+" "+result.getString(columnLabel3));
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public void selectAll(String sqlSelect,String columnLabel1,String columnLabel2,String columnLabel3,String columnLabel4,String columnLabel5){
        results = new ArrayList<>();
        try{
            Connection conn = getConnection();
            PreparedStatement select = conn.prepareStatement(sqlSelect);
            ResultSet result = select.executeQuery();
            while(result.next()){
                System.out.println(result.getString(columnLabel1)+" "+result.getString(columnLabel2)+" "+result.getString(columnLabel3)+" "+result.getString(columnLabel4)+" "+result.getString(columnLabel5));
                results.add(result.getString(columnLabel1)+" "+result.getString(columnLabel2)+" "+result.getString(columnLabel3)+" "+result.getString(columnLabel4)+" "+result.getString(columnLabel5));
            }
            System.out.println(results);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public void insert(String sqlInsertStatement){
        try{
            Connection conn = getConnection();
            PreparedStatement insert = conn.prepareStatement(sqlInsertStatement);
            insert.executeUpdate();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public Connection getConnection(){
        try{

            String driver = "com.mysql.cj.jdbc.Driver";
            String databaseurl="jdbc:mysql://localhost:3307/ksiegarnia";
            String username="root";
            String password="";
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(databaseurl,username,password);
            System.out.println("Database connected");
            return conn;
        }
        catch(Exception e){
            System.out.println(e);
            System.out.println("Error");
        }
        return null;
    }
    public void createTable(String sqlQuery){
        try {
            Connection conn = getConnection();
            conn.setAutoCommit(false);
            Statement create = conn.createStatement();
            create.executeUpdate(sqlQuery);
            conn.commit();
        }
        catch (Exception e){
            System.out.println(e);
            System.out.println("oh no error!");
        }
    }

    public void useDatabase(){
        try{
            Connection conn = getConnection();
            PreparedStatement use = conn.prepareStatement("use ksiegarnia");
            use.executeUpdate();
        }
        catch (Exception e){
            System.out.println(e);
            System.out.println("oh no error!");
        }

    }


}
