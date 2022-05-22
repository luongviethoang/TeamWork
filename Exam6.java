package bt;
import  java.util.Scanner;
import java.sql.*;
import  java.lang.String;
public class Exam6 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        try(
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","");
                        Statement stmt = conn.createStatement();
                ){
            //Update
            String strUpdate = "update musics" + " set  = '' where ID = ";
            System.out.println(strUpdate +"\n");
            stmt.executeUpdate(strUpdate);
//            //Delete
            int strDelete = stmt.executeUpdate(" delete from musics where author = ''");
            System.out.println(strDelete +"\n");
//            search
            System.out.println("nhap ten tac gia de tim kiem:");
            String name = in.next();
            ResultSet rs = stmt.executeQuery("select  * from musics where author = '"+ name +"'");
            int rowCount = 0;
            System.out.println("hang dc chon la:");
            while (rs.next()){
                System.out.println(rs.getInt("ID")+"," +rs.getString("name")+","+rs.getString("years"));
                rowCount++;
            }
            //Insert
            String strInsert = "Insert into musics(ID,name,author,years) values(,'','','')";
            int rowNum = stmt.executeUpdate(strInsert);
            System.out.println("\n Số bản ghi được thêm vào bảng : " +rowNum);
            //Select
            System.out.println("\n cac bai hat co chu : ");
            String strSelect = "select * from musics where name like '%...%'";
            ResultSet rset = stmt.executeQuery(strSelect);
            while (rset.next()){
                System.out.println(
                        rset.getString("name")+','+
                        rset.getString("author")+','+
                        rset.getString("years")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
