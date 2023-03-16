package model;

public class students implements Comparable<students> {
    private long masv;
    private String tensv;
    private  String gioitinh;
    private  String ngaysinh;
    private  String diachi;
    private  String sdt;
    private  String email;
    private double diemGPA;

    public students() {
    }

    public students(String tensv, String gioitinh, String ngaysinh, String diachi, String sdt, String email, double diemGPA) {
        this.tensv = tensv;
        this.gioitinh = gioitinh;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
        this.sdt = sdt;
        this.email = email;
        this.diemGPA = diemGPA;
    }

    public long getMasv() {
        return masv;
    }

    public void setMasv(long masv) {
        this.masv = masv;
    }

    public String getTensv() {
        return tensv;
    }

    public void setTensv(String tensv) {
        this.tensv = tensv;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getDiemGPA() {
        return diemGPA;
    }

    public void setDiemGPA(double diemGPA) {
        this.diemGPA = diemGPA;
    }

    @Override
    public String toString() {
        return "students[" +
                "masv=" + masv +
                ", tensv='" + tensv + '\'' +
                ", gioitinh='" + gioitinh + '\'' +
                ", ngaysinh='" + ngaysinh + '\'' +
                ", diachi='" + diachi + '\'' +
                ", sdt='" + sdt + '\'' +
                ", email='" + email + '\'' +
                ", diemGPA=" + diemGPA +
                ']';
    }

    @Override
    public int compareTo(students o) {
        if (this.diemGPA - o.diemGPA > 0){
            return 1;
        }else if (this.diemGPA - o.diemGPA < 0){
            return -1;
        }
        return 0;
    }


}
