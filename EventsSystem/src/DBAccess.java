import java.rmi.RemoteException;
import java.sql.*;
import java.util.Date;

public class DBAccess {
    private static Connection conn;
    private	static Statement statement;
    private static String query;
    private static PreparedStatement ps;

    public static ResultSet selectUser(String tagId) {
        try {
            conn = DatabaseConnection.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        query = "SELECT * FROM customer where tag_id = ?";

        try {
            ps = conn.prepareStatement(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            ps.setString(1, tagId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            resultSet = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;

    }

    public static ResultSet selectEvent(String eventId) {
        try {
            conn = DatabaseConnection.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        query = "SELECT * FROM events where ID = ?";

        try {
            ps = conn.prepareStatement(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            ps.setString(1, eventId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            resultSet = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }

    public static boolean customerDoesEvents(String tagId, String eventId, String price) {
        try {
            conn = DatabaseConnection.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PreparedStatement ps = null;
        boolean resultSet = false;

        query = "INSERT INTO cus_does_e(tag_id, EID,Price) values(?,?,?)";

        try {
            ps = conn.prepareStatement(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            ps.setString(1, tagId);
            ps.setString(2, eventId);
            ps.setString(3, price);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            resultSet = ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }


    //Login for admin and cashier
//    public static boolean loginStatus(String userId, String password) {
//        try {
//            conn = DatabaseConnection.getInstance();
//            PreparedStatement ps = null;
//            ResultSet resultSet = null;
//            //if the user is an admin
//            if(userId.startsWith("A")){
//                query = "SELECT * FROM adminPark WHERE id = ? AND Password =?";
//                ps = conn.prepareStatement(query);
//                ps.setString(1, userId);
//                ps.setString(2, Encryption.md5(password));
//                resultSet  = ps.executeQuery();
//            }
//            //if the user is a cashier
//            else if(userId.startsWith("C")) {
//                query = "SELECT * FROM cashier WHERE id = ? AND Password =?";
//                ps = conn.prepareStatement(query);
//                ps.setString(1, userId);
//                ps.setString(2, Encryption.md5(password));
//                resultSet  = ps.executeQuery();
//                System.out.println(userId +" "+ Encryption.md5(password));
//            }
//            //returning whether the users credentials are corrrect
//            return resultSet.next();
//        } catch(SQLException ex) {
//            System.out.println("Database Connection Failed : " + ex.getMessage());
//            return false;
//        }
//        catch(RemoteException ex) {
//            System.err.println("Encryption error :");
//            return false;
//        }
//    }
//
//    //get customer list
//    public static ResultSet getCustomerList() {
//        try {
//            conn = DatabaseConnection.getInstance();
//            statement = conn.createStatement();
//            query = "SELECT * FROM customer";
//
//            return statement.executeQuery(query)	;
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    //get cashier list
//    public static ResultSet getCashierList() {
//        try {
//            conn = DatabaseConnection.getInstance();
//            statement = conn.createStatement();
//            query = "SELECT * FROM cashier";
//
//            return statement.executeQuery(query)	;
//
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    //Add customer
//    public static boolean addCustomer(String fname,String lname,String email,String phone,int numAdults,int numChildren,double avialableBalance,double ticketPrice,String cid) {
//        //Get a barcode
//        String barcode = "158941";
//
//        //Sql quaty excecution
//        try {
//            conn = DatabaseConnection.getInstance();
//            query = "INSERT INTO customer VALUES(?,?,?,?,?,?,?,?,?,?,?)";
//            ps = conn.prepareStatement(query);
//            ps.setString(1, barcode);
//            ps.setString(2, fname);
//            ps.setString(3, lname);
//            ps.setString(4, email);
//            ps.setString(5, phone);
//            ps.setInt(6, numAdults);
//            ps.setInt(7, numChildren);
//            ps.setDouble(8, avialableBalance);
//            ps.setDate(9,new java.sql.Date(0));
//            ps.setDouble(10, ticketPrice);
//            ps.setString(11, cid);
//
//            return (ps.executeUpdate()>= 0) ? true:false;
//
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            return false;
//        }
//
//    }
//
//    //add cashier
//    public static boolean addCashier(String cid,String fname,String lname,String contact,String nic) {
//        //quary
//        try {
//            conn = DatabaseConnection.getInstance();
//            query = "INSERT INTO cashier VALUES(?,?,?,?,?,?)";
//            ps = conn.prepareStatement(query);
//            ps.setString(1, cid);
//            ps.setString(2, fname);
//            ps.setString(3, lname);
//            ps.setString(4, contact);
//            ps.setString(5, nic);
//            ps.setString(6, Encryption.md5("123"));
//
//            ps.executeUpdate();
//            return true;
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            return false;
//        } catch (RemoteException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    //cashier change password
//    public static boolean changePasswordCashier(String cid,String pwd) {
//        try {
//            conn = DatabaseConnection.getInstance();
//            query = "UPDATE cashier SET Password=? WHERE ID=?";
//            ps = conn.prepareStatement(query);
//            ps.setString(1, Encryption.md5(pwd));
//            ps.setString(2, cid);
//
//            return (ps.executeUpdate()>=0)? true:false;
//
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            return false;
//        } catch (RemoteException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    //admin change password
//    public static boolean changePasswordAdmin(String aid,String pwd) {
//        try {
//            conn = DatabaseConnection.getInstance();
//            query = "UPDATE adminPark SET Password=? WHERE ID=?";
//            ps = conn.prepareStatement(query);
//            ps.setString(1, Encryption.md5(pwd));
//            ps.setString(2, aid);
//
//            return (ps.executeUpdate()>=0)? true:false;
//
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            return false;
//        } catch (RemoteException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    //edit Customer
//    public static boolean editCustomer(String barcode,String fname,String lname,String email,String phone) {
//        //Sql quaty excecution
//        try {
//            conn = DatabaseConnection.getInstance();
//            query = "UPDATE customer SET Fname=?,Lname=?,Email=?,Phone=? WHERE Tag_Id=?";
//            ps = conn.prepareStatement(query);
//            ps.setString(1, fname);
//            ps.setString(2, lname);
//            ps.setString(3, email);
//            ps.setString(4, phone);
//            ps.setString(5, barcode);
//
//            return (ps.executeUpdate()>= 0) ? true:false;
//
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            return false;
//        }
//
//    }
//
//    //edit Cashier
//    public static boolean editCashier(String cid,String fname,String lname,String contact,String nic) {
//        //quary
//        try {
//            conn = DatabaseConnection.getInstance();
//            query = "UPDATE cashier SET Fname =?,Lname=?,Contact_No=?,NIC=? WHERE ID=?";
//            ps = conn.prepareStatement(query);
//            ps.setString(1, fname);
//            ps.setString(2, lname);
//            ps.setString(3, contact);
//            ps.setString(4, nic);
//            ps.setString(5, cid);
//
//            return (ps.executeUpdate()>=0) ? true :false;
//
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    //edit admin
//    public static boolean editadmin(String aid,String fname,String lname,String contact,String nic) {
//        //query
//        try {
//            conn = DatabaseConnection.getInstance();
//            query = "UPDATE adminPark SET Fname =?,Lname=?,Contact_No=?,NIC=? WHERE ID=?";
//            ps = conn.prepareStatement(query);
//            ps.setString(1, fname);
//            ps.setString(2, lname);
//            ps.setString(3, contact);
//            ps.setString(4, nic);
//            ps.setString(5, aid);
//
//            return (ps.executeUpdate()>=0) ? true :false;
//
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    public static boolean editEvent(int eid,String name,String venue,String date,double price) {
//        //query
//        try {
//            conn = DatabaseConnection.getInstance();
//            query = "UPDATE events SET Name =?,Venue=?,Date=?,Price=? WHERE ID=?";
//            ps = conn.prepareStatement(query);
//            ps.setString(1, name);
//            ps.setString(2, venue);
//            ps.setString(3, date);
//            ps.setDouble(4,price);
//            ps.setInt(5, eid);
//
//            return (ps.executeUpdate()>=0) ? true :false;
//
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    //edit Restaurent
//    public static boolean editRestaurent(int rid,String name) {
//        //query
//        try {
//            conn = DatabaseConnection.getInstance();
//            query = "UPDATE restaurent SET Name =? WHERE ID=?";
//            ps = conn.prepareStatement(query);
//            ps.setString(1, name);
//            ps.setInt(2, rid);
//
//            return (ps.executeUpdate()>=0) ? true :false;
//
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    //edit Photo Booth
//    public static boolean editPhotoBooth(int pid,String name) {
//        //query
//        try {
//            conn = DatabaseConnection.getInstance();
//            query = "UPDATE Photo_Booth SET Name =? WHERE ID=?";
//            ps = conn.prepareStatement(query);
//            ps.setString(1, name);
//            ps.setInt(2, pid);
//
//            return (ps.executeUpdate()>=0) ? true :false;
//
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    //delete customer
//    public static boolean deleteCustomer(String tag_id) {
//        try {
//            conn = DatabaseConnection.getInstance();
//            query = "DELETE FROM customer WHERE Tag_Id=?";
//            ps = conn.prepareStatement(query);
//            ps.setString(1, tag_id);
//
//            return (ps.executeUpdate()>=0)? true:false;
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    //delete cashier
//    public static boolean deleteCashier(String cid) {
//        try {
//            conn = DatabaseConnection.getInstance();
//            query = "DELETE FROM cashier WHERE ID=?";
//            ps = conn.prepareStatement(query);
//            ps.setString(1, cid);
//
//            return (ps.executeUpdate()>=0)? true:false;
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    //delete event
//    public static boolean deleteEvent(int eid) {
//        try {
//            conn = DatabaseConnection.getInstance();
//            query = "DELETE FROM events WHERE ID=?";
//            ps = conn.prepareStatement(query);
//            ps.setInt(1, eid);
//
//            return (ps.executeUpdate()>=0)? true:false;
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//
//    //add events
//    public static boolean addEvents(String name ,String venue,String date,double price,String aid) {
//        try {
//            conn = DatabaseConnection.getInstance();
//            query = "INSERT INTO events (Name,Venue,Date,Price,aid) VALUES(?,?,?,?,?)";
//            ps = conn.prepareStatement(query);
//            ps.setString(1, name);
//            ps.setString(2, venue);
//            ps.setString(3, date);
//            ps.setDouble(4, price);
//            ps.setString(5, aid);
//
//            return (ps.executeUpdate()>=0)? true:false;
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    //add Restaurent
//    public static boolean addRestaurent(String resName,String aid) {
//        try {
//            conn = DatabaseConnection.getInstance();
//            query = "INSERT INTO restaurent(Name,AID) VALUES(?,?)";
//            ps = conn.prepareStatement(query);
//            ps.setString(1, resName);
//            ps.setString(2, aid);
//
//            return (ps.executeUpdate()>=0)? true:false;
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    //add photobooth
//    public static boolean addPhotoBooth(String boothName,String aid) {
//        try {
//            conn = DatabaseConnection.getInstance();
//            query = "INSERT INTO photo_booth(Name,AID) VALUES(?,?)";
//            ps = conn.prepareStatement(query);
//            ps.setString(1, boothName);
//            ps.setString(2, aid);
//
//            return (ps.executeUpdate()>=0)? true:false;
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    //delete Restaurant
//    public static boolean deleteRestaurent(int rid){
//        try {
//            conn = DatabaseConnection.getInstance();
//            query = "DELETE FROM restaurent WHERE ID = ?";
//            ps = conn.prepareStatement(query);
//            ps.setInt(1, rid);
//
//            return (ps.executeUpdate()>=0)? true:false;
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    //delete Photo Booth
//    public static boolean deletePhotoBooth(int pid){
//        try {
//            conn = DatabaseConnection.getInstance();
//            query = "DELETE FROM Photo_Booth WHERE ID = ?";
//            ps = conn.prepareStatement(query);
//            ps.setInt(1, pid);
//
//            return (ps.executeUpdate()>=0)? true:false;
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    public static ResultSet getEvents() {
//        try
//        {
//            conn = DatabaseConnection.getInstance();
//            statement = conn.createStatement();
//            query = "SELECT * FROM events";
//
//            return statement.executeQuery(query)	;
//
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    //get event by id
//    public static ResultSet getEventsById(int eid) {
//        try
//        {
//            conn = DatabaseConnection.getInstance();
//            statement = conn.createStatement();
//            query = "SELECT * FROM events WHERE ID = "+eid;
//
//            return statement.executeQuery(query)	;
//
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    //retrieve photo booths
//    public static ResultSet getPhotboothList(){
//        try
//        {
//            conn = DatabaseConnection.getInstance();
//            statement = conn.createStatement();
//            query = "SELECT * FROM photo_booth";
//
//            return statement.executeQuery(query)	;
//
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    //retrieve photo booths by id
//    public static ResultSet getPhotboothById(int pid){
//        try
//        {
//            conn = DatabaseConnection.getInstance();
//            statement = conn.createStatement();
//            query = "SELECT * FROM photo_booth WHERE ID ="+pid;
//
//            return statement.executeQuery(query)	;
//
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    //Retrieve Restaurent list
//    public static ResultSet getRestaurentList() {
//        try
//        {
//            conn = DatabaseConnection.getInstance();
//            statement = conn.createStatement();
//            query = "SELECT * FROM restaurent";
//
//            return statement.executeQuery(query)	;
//
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    //Retrieve Restaurent by id
//    public static ResultSet getRestaurentById(int rid) {
//        try
//        {
//            conn = DatabaseConnection.getInstance();
//            statement = conn.createStatement();
//            query = "SELECT * FROM restaurent WHERE ID ="+rid;
//
//            return statement.executeQuery(query)	;
//
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    //get Admin profile details
//    public static ResultSet getadminProfile(String id) {
//        try
//        {
//            conn = DatabaseConnection.getInstance();
//            statement = conn.createStatement();
//            query = "SELECT ID,Fname,Lname,NIC,Contact_No,Password FROM adminPark WHERE ID='"+id+"'";
//
//            return statement.executeQuery(query)	;
//
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    //get specific customer details
//    public static ResultSet getCustomerDetailsById(String id) {
//        try
//        {
//            conn = DatabaseConnection.getInstance();
//            statement = conn.createStatement();
//            query = "SELECT Fname,Lname,Email,Phone,Available_Balance FROM customer WHERE Tag_Id='"+id+"'";
//
//            return statement.executeQuery(query)	;
//
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//
//    //get Cashier profile details
//    public static ResultSet getCashierProfile(String id) {
//        try
//        {
//            conn = DatabaseConnection.getInstance();
//            statement = conn.createStatement();
//            query = "SELECT Fname,Lname,Contact_No,NIC FROM cashier WHERE ID='"+id+"'";
//
//            return statement.executeQuery(query);
//
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    //Add the events customer participated in
//    public static boolean addCustomerEvent(String tid,String eid,Double price) {
//        try {
//            conn = DatabaseConnection.getInstance();
//            query = "INSERT INTO cus_does_e VALUES(?,?,?,?)";
//            ps = conn.prepareStatement(query);
//            ps.setString(1, tid);
//            ps.setString(2, eid);
//            ps.setString(3, new java.util.Date().toString());
//            ps.setDouble(4, price);
//
//            return (ps.executeUpdate()>=0)? true:false;
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//
//
//    //Add the photos customer took
//    public static boolean addCustomerPhotos(String tid,String pid,String price) {
//        try {
//            conn = DatabaseConnection.getInstance();
//            query = "INSERT INTO cus_does_photo VALUES(?,?,?,?)";
//            ps = conn.prepareStatement(query);
//            ps.setString(1, tid);
//            ps.setString(2, pid);
//            ps.setString(3, new java.util.Date().toString());
//            ps.setString(4, price);
//
//            return (ps.executeUpdate()>=0)? true:false;
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    //Add restaurents customer visited
//    public static boolean addCustomerRestaurants(String tid,String rid,String price) {
//        try {
//            conn = DatabaseConnection.getInstance();
//            query = "INSERT INTO cus_does_photo VALUES(?,?,?,?)";
//            ps = conn.prepareStatement(query);
//            ps.setString(1, tid);
//            ps.setString(2, rid);
//            ps.setString(3, price);
//
//            return (ps.executeUpdate()>=0)? true:false;
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    //get total amounts a customer spend for restaurents phto booth and events
//    public static ResultSet getSummeryCustomer(String tid) {
//        try
//        {
//            conn = DatabaseConnection.getInstance();
//            statement = conn.createStatement();
//            query = "SELECT SUM(ce.Price) AS 'Event Price',SUM(cp.Price) AS 'Photo Price',SUM(cr.Price) AS 'Restaurant Price',SUM(cdr.Price) AS 'Ride Price'FROM ((((customer c INNER JOIN cus_does_e ce ON c.Tag_Id = ce.Tag_Id) INNER JOIN cus_does_photo cp ON c.Tag_Id = cp.Tag_Id) INNER JOIN cus_does_res cr ON c.Tag_Id = cr.Tag_Id) INNER JOIN cus_does_ride cdr ON c.Tag_Id = cdr.Tag_Id) WHERE c.Tag_Id "+tid+" GROUP BY c.Tag_Id";
//            return statement.executeQuery(query);
//
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            return null;
//        }
//
//    }
//
//    //get total amounts  customers spend for restaurents phto booth and events
//    public static ResultSet getSummery() {
//        try
//        {
//            conn = DatabaseConnection.getInstance();
//            statement = conn.createStatement();
//            query = "SELECT SUM(ce.Price) AS 'Event Price',SUM(cp.Price) AS 'Photo Price',SUM(cr.Price) AS 'Restaurant Price',SUM(cdr.Price) AS 'Ride Price'FROM ((((customer c INNER JOIN cus_does_e ce ON c.Tag_Id = ce.Tag_Id) INNER JOIN cus_does_photo cp ON c.Tag_Id = cp.Tag_Id) INNER JOIN cus_does_res cr ON c.Tag_Id = cr.Tag_Id) INNER JOIN cus_does_ride cdr ON c.Tag_Id = cdr.Tag_Id)";
//            return statement.executeQuery(query);
//
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            return null;
//        }
//
//    }
//
//    //top up
//    public static boolean topUp(String tid,Double amount) {
//        //first get the available balance in the wirst band
//        try {
//            conn = DatabaseConnection.getInstance();
//            statement = conn.createStatement();
//            query = "SELECT Available_Balance FROM customer WHERE Tag_Id='"+tid+"'";
//            ResultSet rs = statement.executeQuery(query);
//            if(rs.next()) {
//                amount += rs.getDouble(1);
//            }
//
//            //then update the value
//            query = "Update customer SET Available_Balance=? WHERE Tag_Id=?";
//            ps = conn.prepareStatement(query);
//            ps.setDouble(1, amount);
//            ps.setString(2, tid);
//            return (ps.executeUpdate()>=0) ? true:false;
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    //get the latest event. restaurent,photo booth and ride registration id
//    public static int getLatestId(String type) {
//        try
//        {
//            conn = DatabaseConnection.getInstance();
//            statement = conn.createStatement();
//            query = "CALL getCurrentIdValue('"+type+"')";
//            ResultSet set = statement.executeQuery(query);
//
//            return set.next() ? set.getInt("MAX(ID)")+1: -99;
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            return -99;
//        }
//    }
}
