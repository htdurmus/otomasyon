
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class veritabani {
    static String url="jdbc:sqlite:db/bilgiler.db";
    static Connection conn=null;
    
    static boolean baglan(){
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Veritabanına bağlanıldı!");
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(veritabani.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    static ResultSet listele(String sorgu){
        Statement st;
        ResultSet rs;
        
        try {
            st=conn.createStatement();
            rs=st.executeQuery(sorgu);
            return rs;
            
        } catch (SQLException ex) {
            Logger.getLogger(veritabani.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    static void kaydet(String sorgu){
    
        Statement st;
        
        try {
            st=conn.createStatement();
            st.executeUpdate(sorgu);
            
            System.out.println("Kayıt başarılı!");
        } 
        catch (SQLException ex) {
            Logger.getLogger(veritabani.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static void sil(String sorgu){
        
        Statement st;
        
        try {
            st=conn.createStatement();
            st.executeUpdate(sorgu);
        } catch (SQLException ex) {
            Logger.getLogger(veritabani.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    
    static ResultSet ara(String sorgu){
        Statement st;
        ResultSet rs;
        
        try {
            st=conn.createStatement();
            rs=st.executeQuery(sorgu);           
        } catch (SQLException ex) {
            Logger.getLogger(veritabani.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return rs;
    }
    
    static void guncelle(String sorgu){
        Statement st;
        
        try {
            st=conn.createStatement();
            st.executeUpdate(sorgu);
        } catch (SQLException ex) {
            Logger.getLogger(veritabani.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
