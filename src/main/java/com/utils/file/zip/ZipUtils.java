package com.utils.file.zip;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipUtils {

    /**
     * 文件打压缩包
     *
     * @param files
     * @param Name
     * @return
     * @throws Exception
     */
    public static String zipFile(List<File> files, String Name)
            throws Exception {
        ZipOutputStream zipOut = null;
        FileOutputStream fous = null;
        /**创建一个临时压缩文件,我们会把文件流全部注入到这个文件中, 这里的文件你可以自定义是.rar还是.zip*/
        File temp = new File(Name);
        try {
            //创建文件输出流
            fous = new FileOutputStream(temp);
            zipOut = new ZipOutputStream(fous);
            //压缩打包
            zipFileToOutputStream(files, zipOut);
            return temp.getPath();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (zipOut != null) {
                zipOut.close();
            }
            if (fous != null) {
                fous.close();
            }
        }
        return null;
    }

    /**
     * 把接受的全部文件打成压缩包
     *
     * @param files<File>;
     * @param outputStream
     */
    public static void zipFileToOutputStream(List<File> files, ZipOutputStream outputStream) {
        int size = files.size();
        for (int i = 0; i < size; i++) {
            File file = (File) files.get(i);
            inputFile(file, outputStream);
        }
    }


    /**
     * 根据输入的文件与输出流对文件进行打包
     *
     * @param inputFile
     * @param ouputStream
     */
    public static void inputFile(File inputFile, ZipOutputStream ouputStream) {
        try {
            if (inputFile.exists()) {
                /**如果是目录的话这里是不采取操作的*/
                if (inputFile.isFile()) {
                    FileInputStream IN = new FileInputStream(inputFile);
                    BufferedInputStream bins = new BufferedInputStream(IN, 512);
                    //org.apache.tools.zip.ZipEntry
                    ZipEntry entry = new ZipEntry(inputFile.getName());
                    ouputStream.putNextEntry(entry);
                    // 向压缩文件中输出数据
                    int nNumber;
                    byte[] buffer = new byte[512];
                    while ((nNumber = bins.read(buffer)) != -1) {
                        ouputStream.write(buffer, 0, nNumber);
                    }
                    // 关闭创建的流对象
                    bins.close();
                    IN.close();
                } else {
                    try {
                        File[] files = inputFile.listFiles();
                        for (int i = 0; i < files.length; i++) {
                            inputFile(files[i], ouputStream);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception {

        //获取项目的路径 并把二维码存储起来
        /*String path = System.getProperty("user.dir") + "\\zip";
        CreateFileUtil.createDir(path);  //创建二维码 临时存储文件 临时路径
        String filename = path + "\\" + (new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())) + ".zip";
        File file = new File("F:\\test\\版本\\1588227374217版本信息.xlsx");
        File file2 = new File("F:\\java\\utils\\utils-demo\\pom.xml");

        List<File> list = new ArrayList<File>();
        list.add(file);
        list.add(file2);

        String str = zipFile(list, filename);

        File file_zip = new File(str);

        System.out.println(str);*/

      /*/ String str = "http://123.56.204.70:8080/profile/2020/04/22/3536123456788787878787.box";
        String[] strs = str.split("profile");
*/




    }
}