import connection.MyConnection;
import dao.studentDAO;
import model.students;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class main {
    private static studentDAO studentDao = new studentDAO();

    private static void mainMenu(){
        System.out.println("--QUAN LY SINH VIEN--");
        System.out.println("1. Danh sach sinh vien theo bang ");
        System.out.println("2. Nhap mot sinh vien moi ");
        System.out.println("3. Xoa mot sinh vien theo ma ");
        System.out.println("4. Cap nhat thong tin sinh vien ");
        System.out.println("5. Tim mot sinh vien theo ho ten hoac ma ");
        System.out.println("6. Sap xep sinh vien theo  diem so  GPA tang dan ");
        System.out.println("7. In ra tat ca cac sinh vien nu o HN co GPA tren 2.5");
        System.out.println("8. Sap xep sinh vien theo ho ten");
    }

    private static void option1(){
        List<students> studentList = studentDAO.getALL();
        System.out.printf("%-20s %-20s %-20s %-20s", "MÃ sinh viên", "Họ tên", "Giới tính", "Địa chỉ");
        System.out.println();
        for (int i = 0; i < studentList.size(); i++) {
            students s = studentList.get(i);
            System.out.printf("%-20d %-20s %-20s %-20s\n", (i+1), s.getTensv(), s.getGioitinh(),s.getDiachi());
        };
    }

    private static void option2(Scanner in){

        students s = new students();
        System.out.print("\t nhập id sinh viên: ");
        s.setMasv((long) Integer.parseInt(in.nextLine()));
        System.out.print("\tNhap ten:");
        s.setTensv(in.nextLine());
        System.out.print("\tNhap gioi tinh:");
        s.setGioitinh(in.nextLine());
        System.out.print("\tNhap ngay sinh:");
        s.setNgaysinh(in.nextLine());
        System.out.print("\tNhap dia chi:");
        s.setDiachi(in.nextLine());
        System.out.print("\tNhap sdt :");
        s.setSdt(in.nextLine());
        System.out.print("\tNhap email:");
        s.setEmail(in.nextLine());
        System.out.print("\tNhap điem GPA:");
        s.setDiemGPA(in.nextDouble());
        insert(s);
    }

    private static void option6() {
        List<students> studentList = studentDAO.getALL();

        Collections.sort(studentList);
        for (students s: studentList) {
            System.out.println("ID: " + s.getMasv() + " - NAME: "+ s.getTensv() + " - GPA: " + s.getDiemGPA());
        }
    }
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int option = -1;

        do {
            mainMenu();
            System.out.print("nhap lua chon: ");
            try {
                option = Integer.parseInt(in.nextLine());
            } catch (Exception e) {
                System.out.println("nhap sai dinh dang");
                
                continue;
            }
            if (option < 1 || option > 8) {
                System.out.println("lua chon khong hop le");
                continue;
            }
            switch (option) {
                case 1:
                    option1();
                    break;
                case 2:
                    option2(new Scanner(System.in));
                    break;
                case 3:

                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    option6();
                    break;
                case 7:
                    break;
                case 8:
                    break;
            }

        }

        while (option != 0) ;
        in.close();

    }


    public static void insert(students s) {
        final String sql = String.format("INSERT INTO `students` (`ma`,`ten`,`gioitinh`,`ngaysinh`,`diachi`,`sdt`,`email`,`GPA`) VALUES ('%d','%s','%s','%s','%s','%s','%s','%f')",
                s.getMasv(),
                s.getTensv(),
                s.getGioitinh(),
                s.getNgaysinh(),
                s.getDiachi(),
                s.getSdt(),
                s.getEmail(),
                s.getDiemGPA()
        );

        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();

            int rs = stmt.executeUpdate(sql);
            if (rs == 0) {
                System.out.println("them that bai");
            }
            stmt.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}