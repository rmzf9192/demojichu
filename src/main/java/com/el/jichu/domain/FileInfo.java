package com.el.jichu.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Comparator;

public class FileInfo implements Comparable<FileInfo> {
    //文件名
    private String fileName;
    //当前出牌人的手中的牌
    private int currentNum;
    //类似于文件指针
    private BufferedReader bufferedReader;

    public void readNext() throws IOException {
        String data = bufferedReader.readLine();
        if (data != null)
            this.currentNum = Integer.valueOf(data);
        else
            //代表当前出牌人手中无牌
            this.currentNum = -1;
    }

    public BufferedReader getBufferedReader() {
        return bufferedReader;
    }

    public void setBufferedReader(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getCurrentNum() {
        return currentNum;
    }

    public void setCurrentNum(int currentNum) {
        this.currentNum = currentNum;
    }


    @Override
    public int compareTo(FileInfo fileInfo) {
        if (fileInfo.getCurrentNum() != currentNum) {
            return currentNum - fileInfo.currentNum;
        } else {
            return fileName.compareTo(fileInfo.getFileName());
        }
    }
}
