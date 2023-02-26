public class Room {
    private String MaPhong;
    private Float GiaPhong;
    private String LoaiPhong;
    private String Mota;

    public Room(String maPhong, Float giaPhong, String loaiPhong, String mota) {
        MaPhong = maPhong;
        GiaPhong = giaPhong;
        LoaiPhong = loaiPhong;
        Mota = mota;
    }

    public Room() {
        MaPhong = null;
        GiaPhong= (float) 0;
        LoaiPhong = null;
        Mota = null;

    }

    public String getMaPhong() {
        return MaPhong;
    }

    public void setMaPhong(String maPhong) {
        MaPhong = maPhong;
    }

    public Float getGiaPhong() {
        return GiaPhong;
    }

    public void setGiaPhong(Float giaPhong) {
        GiaPhong = giaPhong;
    }

    public String getLoaiPhong() {
        return LoaiPhong;
    }

    public void setLoaiPhong(String loaiPhong) {
        LoaiPhong = loaiPhong;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String mota) {
        Mota = mota;
    }

}
