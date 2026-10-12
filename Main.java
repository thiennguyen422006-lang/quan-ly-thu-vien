
import java.util.ArrayList;
import java.util.Scanner;

// ================= LOP CHA =================
abstract class TaiLieu {
    private String maTaiLieu;
    private String nhaXuatBan;
    private int soBanPhatHanh;

    public TaiLieu(String maTaiLieu, String nhaXuatBan,
                   int soBanPhatHanh) {
        this.maTaiLieu = maTaiLieu;
        this.nhaXuatBan = nhaXuatBan;
        this.soBanPhatHanh = soBanPhatHanh;
    }

    // Getter
    public String getMaTaiLieu() {
        return maTaiLieu;
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }

    public int getSoBanPhatHanh() {
        return soBanPhatHanh;
    }

    // Setter
    public void setMaTaiLieu(String maTaiLieu) {
        this.maTaiLieu = maTaiLieu;
    }

    public void setNhaXuatBan(String nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

    public void setSoBanPhatHanh(int soBanPhatHanh) {
        this.soBanPhatHanh = soBanPhatHanh;
    }

    // Phuong thuc chung
    public String getThongTin() {
        return "Ma tai lieu: " + maTaiLieu
             + "\nNha xuat ban: " + nhaXuatBan
             + "\nSo ban phat hanh: " + soBanPhatHanh;
    }

    // Moi loai tai lieu tu xac dinh ten loai
    public abstract String getLoai();
}


// ================= LOP SACH =================
class Sach extends TaiLieu {
    private String tenTacGia;
    private int soTrang;

    public Sach(String ma, String nxb, int soBan,
                String tacGia, int soTrang) {
        super(ma, nxb, soBan);
        this.tenTacGia = tacGia;
        this.soTrang = soTrang;
    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    public int getSoTrang() {
        return soTrang;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    public void setSoTrang(int soTrang) {
        this.soTrang = soTrang;
    }

    @Override
    public String getLoai() {
        return "Sach";
    }

    @Override
    public String getThongTin() {
        return super.getThongTin()
             + "\nTac gia: " + tenTacGia
             + "\nSo trang: " + soTrang;
    }
}


// ================= LOP TAP CHI =================
class TapChi extends TaiLieu {
    private int soPhatHanh;
    private int thangPhatHanh;

    public TapChi(String ma, String nxb, int soBan,
                  int soPhatHanh, int thangPhatHanh) {
        super(ma, nxb, soBan);
        this.soPhatHanh = soPhatHanh;
        this.thangPhatHanh = thangPhatHanh;
    }

    public int getSoPhatHanh() {
        return soPhatHanh;
    }

    public int getThangPhatHanh() {
        return thangPhatHanh;
    }

    public void setSoPhatHanh(int soPhatHanh) {
        this.soPhatHanh = soPhatHanh;
    }

    public void setThangPhatHanh(int thangPhatHanh) {
        this.thangPhatHanh = thangPhatHanh;
    }

    @Override
    public String getLoai() {
        return "Tap chi";
    }

    @Override
    public String getThongTin() {
        return super.getThongTin()
             + "\nSo phat hanh: " + soPhatHanh
             + "\nThang phat hanh: " + thangPhatHanh;
    }
}


// ================= LOP BAO =================
class Bao extends TaiLieu {
    private String ngayPhatHanh;

    public Bao(String ma, String nxb, int soBan,
               String ngayPhatHanh) {
        super(ma, nxb, soBan);
        this.ngayPhatHanh = ngayPhatHanh;
    }

    public String getNgayPhatHanh() {
        return ngayPhatHanh;
    }

    public void setNgayPhatHanh(String ngayPhatHanh) {
        this.ngayPhatHanh = ngayPhatHanh;
    }

    @Override
    public String getLoai() {
        return "Bao";
    }

    @Override
    public String getThongTin() {
        return super.getThongTin()
             + "\nNgay phat hanh: " + ngayPhatHanh;
    }
}


// ================= CHUONG TRINH CHINH =================
public class Main {
    static Scanner sc = new Scanner(System.in);

    // Danh sach chua sach, tap chi va bao
    static ArrayList<TaiLieu> danhSach = new ArrayList<>();

    // Nhap so nguyen
    public static int nhapSo(String thongBao) {
        while (true) {
            try {
                System.out.print(thongBao);
                int so = Integer.parseInt(sc.nextLine());

                if (so < 0) {
                    System.out.println("Vui long nhap so khong am!");
                } else {
                    return so;
                }
            } catch (NumberFormatException e) {
                System.out.println("Du lieu khong hop le, hay nhap so!");
            }
        }
    }

    // Kiem tra ma tai lieu da ton tai chua
    public static boolean trungMa(String ma) {
        for (TaiLieu tl : danhSach) {
            if (tl.getMaTaiLieu().equalsIgnoreCase(ma)) {
                return true;
            }
        }
        return false;
    }

    // Nhap ma khong trung
    public static String nhapMaMoi() {
        while (true) {
            System.out.print("Nhap ma tai lieu: ");
            String ma = sc.nextLine().trim();

            if (ma.isEmpty()) {
                System.out.println("Ma khong duoc de trong!");
            } else if (trungMa(ma)) {
                System.out.println("Ma da ton tai, hay nhap ma khac!");
            } else {
                return ma;
            }
        }
    }

    // 1. Them tai lieu
    public static void themTaiLieu() {
        System.out.println("\n--- THEM TAI LIEU ---");
        System.out.println("1. Sach");
        System.out.println("2. Tap chi");
        System.out.println("3. Bao");

        int loai = nhapSo("Chon loai tai lieu: ");

        if (loai < 1 || loai > 3) {
            System.out.println("Loai tai lieu khong hop le!");
            return;
        }

        String ma = nhapMaMoi();

        System.out.print("Nha xuat ban: ");
        String nxb = sc.nextLine();

        int soBan = nhapSo("So ban phat hanh: ");

        if (loai == 1) {
            System.out.print("Ten tac gia: ");
            String tacGia = sc.nextLine();

            int soTrang = nhapSo("So trang: ");

            danhSach.add(new Sach(ma, nxb, soBan,
                                  tacGia, soTrang));
        } else if (loai == 2) {
            int soPhatHanh = nhapSo("So phat hanh: ");

            int thang;
            do {
                thang = nhapSo("Thang phat hanh (1-12): ");
                if (thang < 1 || thang > 12) {
                    System.out.println("Thang phai tu 1 den 12!");
                }
            } while (thang < 1 || thang > 12);

            danhSach.add(new TapChi(ma, nxb, soBan,
                                     soPhatHanh, thang));
        } else {
            System.out.print("Ngay phat hanh (dd/MM/yyyy): ");
            String ngay = sc.nextLine();

            danhSach.add(new Bao(ma, nxb, soBan, ngay));
        }

        System.out.println("Them tai lieu thanh cong!");
    }

    // Tim vi tri tai lieu theo ma
    public static int timViTri(String ma) {
        for (int i = 0; i < danhSach.size(); i++) {
            if (danhSach.get(i).getMaTaiLieu()
                    .equalsIgnoreCase(ma)) {
                return i;
            }
        }
        return -1;
    }

    // 2. Xoa tai lieu
    public static void xoaTaiLieu() {
        System.out.print("Nhap ma tai lieu can xoa: ");
        String ma = sc.nextLine().trim();

        int viTri = timViTri(ma);

        if (viTri == -1) {
            System.out.println("Khong tim thay tai lieu!");
        } else {
            TaiLieu tl = danhSach.get(viTri);

            System.out.println("Tai lieu se xoa:");
            System.out.println("Loai: " + tl.getLoai());
            System.out.println(tl.getThongTin());

            System.out.print("Xac nhan xoa? (y/n): ");
            String chon = sc.nextLine();

            if (chon.equalsIgnoreCase("y")) {
                danhSach.remove(viTri);
                System.out.println("Da xoa tai lieu!");
            } else {
                System.out.println("Da huy thao tac xoa.");
            }
        }
    }

    // 3. Hien thi danh sach
    public static void hienThi() {
        System.out.println("\n--- DANH SACH TAI LIEU ---");

        if (danhSach.isEmpty()) {
            System.out.println("Thu vien chua co tai lieu.");
            return;
        }

        for (TaiLieu tl : danhSach) {
            System.out.println("\nLoai: " + tl.getLoai());
            System.out.println(tl.getThongTin());
            System.out.println("--------------------------");
        }
    }

    // 4. Tim kiem theo loai
    public static void timKiem() {
        System.out.println("\n--- TIM KIEM THEO LOAI ---");
        System.out.println("1. Sach");
        System.out.println("2. Tap chi");
        System.out.println("3. Bao");

        int loai = nhapSo("Chon loai can tim: ");

        String tenLoai;
        if (loai == 1) {
            tenLoai = "Sach";
        } else if (loai == 2) {
            tenLoai = "Tap chi";
        } else if (loai == 3) {
            tenLoai = "Bao";
        } else {
            System.out.println("Lua chon khong hop le!");
            return;
        }

        boolean timThay = false;

        for (TaiLieu tl : danhSach) {
            if (tl.getLoai().equals(tenLoai)) {
                System.out.println("\nLoai: " + tl.getLoai());
                System.out.println(tl.getThongTin());
                System.out.println("--------------------------");
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Khong co tai lieu thuoc loai nay.");
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== QUAN LY THU VIEN =====");
            System.out.println("1. Them moi tai lieu");
            System.out.println("2. Xoa tai lieu theo ma");
            System.out.println("3. Hien thi tai lieu");
            System.out.println("4. Tim kiem theo loai");
            System.out.println("5. Thoat chuong trinh");

            int chon = nhapSo("Chon chuc nang: ");

            switch (chon) {
                case 1:
                    themTaiLieu();
                    break;

                case 2:
                    xoaTaiLieu();
                    break;

                case 3:
                    hienThi();
                    break;

                case 4:
                    timKiem();
                    break;

                case 5:
                    System.out.println("Da thoat chuong trinh!");
                    sc.close();
                    return;

                default:
                    System.out.println("Vui long chon tu 1 den 5!");
            }
        }
    }
}
