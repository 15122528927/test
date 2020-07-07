package com.utils.file.zip;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.InflaterInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

//java 解析 压缩包

/**
 * java 解析
 * 压缩包
 * */
public class ZipAndRarTools {

    /**
     * 向file文件写入字节
     *
     * @param ins
     * @param file
     */
    public static void toWrite(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取条目byte[]字节
     *
     * @param zis
     * @return
     */
    public static byte[] getByte(InflaterInputStream zis) {
        try {
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            byte[] temp = new byte[1024];
            byte[] buf = null;
            int length = 0;

            while ((length = zis.read(temp, 0, 1024)) != -1) {
                bout.write(temp, 0, length);
            }

            buf = bout.toByteArray();
            bout.close();
            return buf;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    /* *
    * InputStream转换为File
    * */
    public static void inputstreamtofile(InputStream ins,File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    //File 文件保存
    public static void savePic(InputStream inputStream, String fileName) {



        OutputStream os = null;

        try {

            String path = "F:\\test\\";

            // 2、保存到临时文件

            // 1K的数据缓冲

            byte[] bs = new byte[1024];

            // 读取到的数据长度

            int len;

            // 输出的文件流保存到本地文件



            File tempFile = new File(path);

            if (!tempFile.exists()) {

                tempFile.mkdirs();

            }

            os = new FileOutputStream(tempFile.getPath() + File.separator + fileName);

            // 开始读取

            while ((len = inputStream.read(bs)) != -1) {

                os.write(bs, 0, len);

            }



        } catch (IOException e) {

            e.printStackTrace();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            // 完毕，关闭所有链接

            try {

                os.close();

                inputStream.close();

            } catch (IOException e) {

                e.printStackTrace();

            }

        }

    }

    // 读取 压缩包 里面 所有文件
    public static void main(String[] args) throws IOException {

        // 获取文件输入流
        FileInputStream input = new FileInputStream("F:\\版本.zip");

        // 获取ZIP输入流(一定要指定字符集Charset.forName("GBK")否则会报java.lang.IllegalArgumentException:
        // MALFORMED)
        ZipInputStream zipInputStream = new ZipInputStream(
                new BufferedInputStream(input), Charset.forName("GBK"));

        // 定义ZipEntry置为null,避免由于重复调用zipInputStream.getNextEntry造成的不必要的问题
        ZipEntry ze = null;

        List<File> list_file = new ArrayList<File>();

        // 循环遍历
        while ((ze = zipInputStream.getNextEntry()) != null) {
            System.out.println("文件名" + ze.getName() + "文件大小" + ze.getSize()
                    + " bytes");

            // 判断是否为文件夹
            if (!ze.isDirectory()) {
                String[] names = ze.getName().split("/");
                // 显示文件名称
                System.out.println("-----------------"
                        + names[names.length - 1]);

                byte[] data = getByte(zipInputStream);
                InputStream is = new ByteArrayInputStream(data);

                /*File file = new File("F:/test/sd/" + names[names.length - 1]);
                if (!file.exists()) {
                    file.createNewFile();
                    toWrite(is, file);
                }*/

                // 流转化成 文件
                File file = new File( names[names.length - 1]);
                inputstreamtofile( is , file);
                list_file.add(file);
            }

        }

        // 一定记得关闭流
        zipInputStream.closeEntry();
        input.close();



        for (File file :  list_file){
            InputStream inputStream  = new FileInputStream(file);
            savePic(inputStream ,file.getName());
        }

    }

}
