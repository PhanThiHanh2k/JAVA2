package dao;

import connection.MyConnection;
import jdk.internal.icu.text.UnicodeSet;

import model.students;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class studentDAO {
    public static List<students> getALL() {
        final String sql = "SELECT * FROM `students`";
        List<students> studentsList = new ArrayList<>();

        students s = null;
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                s = new students();
                s.setMasv(rs.getLong("masv"));
                s.setTensv(rs.getString("tensv"));
                s.setGioitinh(rs.getString("gioitinh"));
                s.setNgaysinh(rs.getString("ngaysinh"));
                s.setDiachi(rs.getString("diachi"));
                s.setSdt(rs.getString("sdt"));
                s.setEmail(rs.getString("email"));


                studentsList.add(s);
            }


            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentsList;
    }

    public students getById(long id) {
        final String sql = "SELECT * FROM `students` WHERE  `id` = " + id;
        students s = null;

        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                s = new students();
                s.setMasv(rs.getLong("masv"));
                s.setTensv(rs.getString("tensv"));
                s.setGioitinh(rs.getString("gioitinh"));
                s.setNgaysinh(rs.getString("ngaysinh"));
                s.setDiachi(rs.getString("diachi"));
                s.setSdt(rs.getString("sdt"));
                s.setEmail(rs.getString("email"));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    public void insert(students s) {
        final String sql = String.format("INSERT  INTO `students` VALUES ( NULL,'%s','%s','%s','%s','%s','%s','%f' ) ",
                s.getTensv(), s.getGioitinh(), s.getNgaysinh(), s.getDiachi(), s.getSdt(), s.getEmail(), s.getDiemGPA()
        );
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            long rs = stmt.executeUpdate(sql);

            if (rs == 0) {
                System.out.println("them that bai ");
            }

            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}










