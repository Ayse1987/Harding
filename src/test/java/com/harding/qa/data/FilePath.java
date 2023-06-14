package com.harding.qa.data;

public class FilePath {
    public static String CvWordPath = System.getProperty("user.dir") + "\\src\\test\\java\\com\\harding\\qa\\data\\CV.docx";
    public static String CvPngPath = System.getProperty("user.dir") + "\\src\\test\\java\\com\\harding\\qa\\data\\CV_PNG.png";
    public static String CvPdfPath = System.getProperty("user.dir") + "\\src\\test\\java\\com\\harding\\qa\\data\\Cv PDF.pdf";

    public static String getFilePath(String fileFormat) {
        String filePath = "";
        switch (fileFormat) {
            case "WORD":
                filePath = System.getProperty("user.dir") + "\\src\\test\\java\\com\\harding\\qa\\data\\CV.docx";
                break;
            case "PNG":
                filePath = System.getProperty("user.dir") + "\\src\\test\\java\\com\\harding\\qa\\data\\CV_PNG.png";
                break;
            case "PDF":
                filePath = System.getProperty("user.dir") + "\\src\\test\\java\\com\\harding\\qa\\data\\Cv PDF.pdf";
                break;
            case "BAT":
                filePath = System.getProperty("user.dir") + "\\src\\test\\java\\com\\harding\\qa\\data\\CoverLetterBat.bat";
                break;
            case "EXE":
                filePath = System.getProperty("user.dir") + "\\src\\test\\java\\com\\harding\\qa\\data\\CoverLetterExe.exe";
                break;
            case "CoverLetterPNG":
                filePath = System.getProperty("user.dir") + "\\src\\test\\java\\com\\harding\\qa\\data\\CoverLetterPng.png";
                break;
            default:
                System.out.println("We have different format. Just use valid format");
        }
        return filePath;
    }
}
