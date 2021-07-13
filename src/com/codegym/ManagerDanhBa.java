package com.codegym;

import com.codegym.validate.Validate;
import com.codegym.validate.ValidateDate;
import com.codegym.validate.ValidateEmail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerDanhBa {
    static List<DanhBa> list = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static Validate validate = new Validate();
    static ValidateDate validateDate = new ValidateDate();
    static ValidateEmail validateEmail = new ValidateEmail();
    static DocGhiFile docGhiFile = new DocGhiFile();
    MenuDanhBa menuDanhBa = new MenuDanhBa();

    public void themDanhBa(String DB) {
        DanhBa danhBa = create(DB);
        list.add(danhBa);
    }

    public DanhBa create(String DB) {

        System.out.println("Số điện thoại:");
        String soDienThoai;
        while (true) {
            soDienThoai = scanner.nextLine();
            if (!soDienThoai.isEmpty()) {
                if (validate.validateSDT(soDienThoai)) {
                    break;
                } else {
                    System.out.println(">>>>[CHÚ Ý]: Số điện thoại gồm các ký tự từ 0-9 [ví dụ: 0123456789");
                }
            } else {
                System.out.println("Không được để trống");
            }
        }

        System.out.println("Nhóm danh bạ:");
        String nhomDanhBa = scanner.nextLine();
        System.out.println("Họ tên:");
        String hoTen = scanner.nextLine();
        System.out.println("Giới tính:");
        String gioiTinh= scanner.nextLine();;
        System.out.println("Địa chỉ:");
        String diaChi = scanner.nextLine();
        System.out.println("Ngày sinh:");
        String ngaySinh ;
        while (true) {
            ngaySinh = scanner.nextLine();
            if (!ngaySinh.isEmpty()) {
                if (validateDate.validateDate(ngaySinh)) {
                    break;
                } else {
                    System.out.println(">>>>[CHÚ Ý]: Ngày sinh gồm các ký tự từ 0-9 [ví dụ: 13/13/1999");
                }
            } else {
                System.out.println("Không được để trống");
            }
        }

        System.out.println("Email:");
        String email;
        while (true) {
            email = scanner.nextLine();
            if (!email.isEmpty()) {
                if (!validate.validateSDT(email)) {
                    break;
                } else {
                    System.out.println(">>>>[CHÚ Ý]: Email gồm các ký tự từ 0-9,a-z,@ [ví dụ: thao@gmail.com");
                }
            } else {
                System.out.println("Không được để trống");
            }
        }
        if (DB == "DanhBa") {
            return new DanhBa(soDienThoai, nhomDanhBa, hoTen, gioiTinh, diaChi, ngaySinh, email);
        }

        return null;
    }

    public void suaDanhBa() throws IOException {
        System.out.println("Tìm Số điện thoại: ");
        String index;
        while (true) {
            index = scanner.nextLine();
            if (!index.isEmpty()) {
                if (validate.validateSDT(index)) {
                    break;
                } else {
                    System.out.println(">>>>[CHÚ Ý]: Số điện thoại gồm các ký tự từ 0-9 [ví dụ: 0123456789");
                }
            } else {
                menuDanhBa.menu();
            }
        }

        System.out.println("fix Số điện thoại:");
        String soDienThoai;
        while (true) {
            soDienThoai = scanner.nextLine();
            if (!soDienThoai.isEmpty()) {
                if (validate.validateSDT(soDienThoai)) {
                    break;
                } else {
                    System.out.println(">>>>[CHÚ Ý]: Số điện thoại gồm các ký tự từ 0-9 [ví dụ: 0123456789");
                }
            } else {
                System.out.println("Không được để trống");
            }
        }
        System.out.println("fix Nhóm danh bạ:");
        String nhomDanhBa = scanner.nextLine();
        System.out.println("fix Họ tên:");
        String hoTen = scanner.nextLine();
        System.out.println("fix Giới tính:");
        String gioiTinh = scanner.nextLine();
        System.out.println("fix Địa chỉ:");
        String diaChi = scanner.nextLine();
        System.out.println("fix Ngày sinh:");
        String ngaySinh ;
        while (true) {
            ngaySinh = scanner.nextLine();
            if (!ngaySinh.isEmpty()) {
                if (validateDate.validateDate(ngaySinh)) {
                    break;
                } else {
                    System.out.println(">>>>[CHÚ Ý]: Ngày sinh gồm các ký tự từ 0-9 [ví dụ: 13/13/1999");
                }
            } else {
                System.out.println("Không được để trống");
            }
        }

        System.out.println("fix Email:");
        String email;
        while (true) {
            email = scanner.nextLine();
            if (!email.isEmpty()) {
                if (!validate.validateSDT(email)) {
                    break;
                } else {
                    System.out.println(">>>>[CHÚ Ý]: Email gồm các ký tự từ 0-9,a-z,@ [ví dụ: thao@gmail.com");
                }
            } else {
                System.out.println("Không được để trống");
            }
        }


        for (DanhBa sv : list) {
            if (sv.getSoDienThoai().equals(index)) {
                sv.setSoDienThoai(soDienThoai);
                sv.setNhomDanhBa(nhomDanhBa);
                sv.setHoTen(hoTen);
                sv.setGioiTinh(gioiTinh);
                sv.setDiaChi(diaChi);
                sv.setNgaySinh(ngaySinh);
                sv.setEmail(email);
            }
        }


    }

    public void hienThi() {

        if (list.isEmpty()) {
            System.out.println("Danh sách trống");
        }
        for (DanhBa danhBa : list) {
            System.out.println(danhBa);
        }
    }

    public void xoaDanhBa() throws IOException {

        System.out.println("Nhập số điện thoại cần xóa");
        String soDT = scanner.nextLine();

        if(soDT.isEmpty()){
            menuDanhBa.menu();
        }
        for(DanhBa danhBa:list){
            if(danhBa.getSoDienThoai().equals(soDT)){
                System.out.println("Xác nhận cần xóa");
                String check = scanner.nextLine();;
                if(check == "Y"){
                    list.remove(soDT);
                }else {
                    menuDanhBa.menu();
                }

            }else {
                System.out.println("không có sdt trong danh sách");
            }
        }


    }

    public void timKiem() {

        System.out.println("Nhập số điện thoại cần tìm kiếm");
        String soDT1 = scanner.nextLine();
        if(soDT1.isEmpty()){
            System.out.println("Mời nhập thông tin");
        }
        for (DanhBa danhBa : list) {
            if (danhBa.getSoDienThoai().equals(soDT1)) {
                System.out.println(danhBa);
            }else {
                System.out.println("không có sdt");
            }
        }

    }

    public void docFile() throws IOException{
        MenuDanhBa.docGhiFile.docFile();
    }

    public void ghiFile() throws IOException {
        MenuDanhBa.docGhiFile.ghiFile();
    }
}
