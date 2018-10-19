import java.sql.*;

public class Student {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://app-replatform-test-db-master.cvlvbu3tfq9g.ap-south-1.rds.amazonaws.com:3306/DART_CM";

   //  Database credentials
   static final String USER = "sbikkasani";
   static final String PASS = "sbikkasani";
   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      String sql;
      sql = "SELECT UserRegistrationID, FirstName, LastName, Email_UID FROM DARTRegistration";
      ResultSet rs = stmt.executeQuery(sql);

      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
         int id  = rs.getInt("UserRegistrationID");
         String firstname = rs.getString("FirstName");
         String lastname = rs.getString("LastName");
         String email = rs.getString("Email_UID");

         //Display values
         System.out.print("ID: " + id);
         System.out.print(", First Name: " + firstname);
         System.out.print(", Last Name: " + lastname);
         System.out.println(", Email: " + email);
      }
      //STEP 6: Clean-up environment
      rs.close();
      stmt.close();
      conn.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
}//end main
}//end FirstExample
