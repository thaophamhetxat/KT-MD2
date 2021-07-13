package com.codegym;

import java.io.*;


public class DocGhiFile {

    public void docFile()  {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("danhBa.csv"));
            String tieuDe = "soDienThoai,nhomDanhBa,hoTen,gioiTinh,diaChi,ngaySinh,email";
            bufferedWriter.write(tieuDe);
            for (DanhBa sv : ManagerDanhBa.list) {
                bufferedWriter.newLine();
                bufferedWriter.write(sv.list());
            }
            bufferedWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void ghiFile() throws IOException {
        BufferedReader bufferedReader = null;
        try {
            FileReader fileReader = new FileReader("danhBa.csv");
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] str = line.split(", ");
                if (str.length >= 7) {
                    ManagerDanhBa.list.add(new DanhBa(str[0], str[1], str[2],str[3],str[4],str[5],str[6]));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bufferedReader.close();
        }
    }
}
