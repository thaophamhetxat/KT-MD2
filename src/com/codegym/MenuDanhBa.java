package com.codegym;

import java.io.IOException;
import java.util.Scanner;

public class MenuDanhBa {
  static  ManagerDanhBa managerDanhBa = new ManagerDanhBa();
    static Scanner scanner = new Scanner(System.in);
    static DocGhiFile docGhiFile = new DocGhiFile();

    public void menu() throws IOException {
        while (true){
            System.out.println("CHUONG TRINH QUAN LY  DANH BA");
            System.out.println("Chọn chức năng theo số");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhập");
            System.out.println("4. Xóa");
            System.out.println("5. Tìm kiếm");
            System.out.println("6. Đọc từ file");
            System.out.println("7. Ghi từ file");
            System.out.println("8. Thoát");
            System.out.println("chọn chức năng");
            int choise = Integer.parseInt(scanner.nextLine());
            switch (choise){
                case 1: managerDanhBa.hienThi();break;
                case 2: managerDanhBa.themDanhBa("DanhBa");break;
                case 3: managerDanhBa.suaDanhBa();break;
                case 4: managerDanhBa.xoaDanhBa();break;
                case 5: managerDanhBa.timKiem();break;
                case 6:{
                    managerDanhBa.ghiFile();
                    System.out.println("Đã ghi");
                }break;
                case 7:{
                    managerDanhBa.docFile();
                    System.out.println("Đã đọc");
                }break;
                case 8: System.exit(0);

            }
        }
    }
}
