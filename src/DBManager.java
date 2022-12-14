import java.sql.*;

public class DBManager {


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
    public void select(String sqlSelect){
        try{
            Connection conn = getConnection();
            PreparedStatement select = conn.prepareStatement(sqlSelect);
            ResultSet result = select.executeQuery();
            while(result.next()){
                System.out.print("ID: " + result.getInt("id"));
                System.out.print(", Age: " + result.getString("first_name"));
                System.out.print(", First: " + result.getString("last_name"));
                System.out.println(", Last: " + result.getString("email"));
            }
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
            String databaseurl="jdbc:mysql://localhost:3306/ksiegarnia";
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
