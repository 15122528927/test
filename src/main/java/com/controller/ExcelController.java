package com.controller;


import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.alibaba.fastjson.JSONObject;
import com.entity.Student;
import com.utils.Excel.DownloadExcel;
import com.utils.Excel.ExportExcelUtil;
import com.utils.file.MultipartFileToFile;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.ss.usermodel.Sheet;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@RestController
@RequestMapping("/Excel")
public class ExcelController {

    /**
     *  excel 导入功能测试
     * @param file
     * @return
     * @throws Exception
     */
    @PostMapping("fileUpload")
    public JSONObject fileUpload2(@RequestParam("file") MultipartFile file) throws Exception {

        JSONObject json = new JSONObject();
        try {
            File dir =  MultipartFileToFile.multipartFileToFile(file);
            ExcelReader excelReader = ExcelUtil.getReader(dir);
            List<Sheet> sheets = excelReader.getSheets();
            List<Map<String, Object>> maps=new LinkedList<>();
            for (int i = 0; i <sheets.size() ; i++) {
                Sheet sheet=sheets.get(i);
                ExcelReader reader=ExcelUtil.getReader(dir,i);
                List<Map<String, Object>> read =reader.read(0,1,sheet.getLastRowNum());
                maps.addAll(read);
                reader.close(); //关闭流
            }

            excelReader.close(); //关闭流
            json.put("massage","成功");
            json.put("结果",maps.toString());
            return json;
        }catch (Exception  e){
            json.put("massage","失败");
            return json;
        }
    }


    /**
     * Excel导出(单实体类)
     **/
    @GetMapping("/download")
    public void download(HttpServletResponse response) {


        // 表格标题，就是模型的属性名
        String[] titles = { "顾客ID", "顾客姓名", "顾客职业", "顾客电话", "顾客邮箱" };

        // 将list集合数据变成String类型二维的数组，行数+列数
        String[][] datas = new String[1][titles.length];
        for (int i = 0 ; i  == 0; i++) {
            // 赋值
            datas[i][0] = "1";
            datas[i][1] = "2";
            datas[i][2] = "3";
            datas[i][3] = "4";
            datas[i][4] = "5";
        }

        // 表格sheet名
        String sheetName = "员工信息表";

        // 调用common下的Excel导出方法，导出Excel
        HSSFWorkbook workbook = DownloadExcel.downloadExcel(sheetName, titles,
                datas);

        try {
            // 文件名，需要编码成ISO8859-1
            String fileName = new String("员工信息表.xls".getBytes("UTF-8"),
                    "ISO8859-1");
            // 设置响应头，返回前端下载文件
            response.setHeader("content-Disposition", "attachment;filename="
                    + fileName);
            workbook.write(response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Excel导出(单实体类) x
     **/
    @GetMapping("/downloadx")
    public void downloadx(HttpServletResponse response) {


        // 表格标题，就是模型的属性名
        String[] titles = { "顾客ID", "顾客姓名", "顾客职业", "顾客电话", "顾客邮箱" };

        // 将list集合数据变成String类型二维的数组，行数+列数
        String[][] datas = new String[1][titles.length];
        for (int i = 0 ; i  == 0; i++) {
            // 赋值
            datas[i][0] = "1";
            datas[i][1] = "2";
            datas[i][2] = "3";
            datas[i][3] = "4";
            datas[i][4] = "5";
        }

        // 表格sheet名
        String sheetName = "员工信息表";

        // 调用common下的Excel导出方法，导出Excel
        XSSFWorkbook workbook = DownloadExcel.downloadExcelX(sheetName, titles,
                datas);

        try {
            // 文件名，需要编码成ISO8859-1
            String fileName = new String("员工信息表.xls".getBytes("UTF-8"),
                    "ISO8859-1");
            // 设置响应头，返回前端下载文件
            response.setHeader("content-Disposition", "attachment;filename="
                    + fileName);
            workbook.write(response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Excel导出(通用实体类)
     **/
    @GetMapping("/download2")
    public void download2(HttpServletResponse response) {
        ExportExcelUtil<Student> util = new ExportExcelUtil<Student>();
        // 准备数据
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Student(111,"张三asdf","男"));
            list.add(new Student(111,"李四","男"));
            list.add(new Student(111,"王五","女"));

        }

        //设置属性展示
        int[]  ints ={0 ,1 ,2 };
        String[] columnNames = { "ID", "姓名", "性别" };
       // HSSFWorkbook workbook = (HSSFWorkbook)util.exportExcel("用户导出", columnNames, ints, list, ExportExcelUtil.EXCEL_FILE_2003);
        XSSFWorkbook workbook = (XSSFWorkbook)util.exportExcel("用户导出", columnNames, ints, list, ExportExcelUtil.EXCEl_FILE_2007);

        try {
            // 文件名，需要编码成ISO8859-1
            String fileName = new String("员工信息表.xlsx".getBytes("UTF-8"),
                    "ISO8859-1");
            // 设置响应头，返回前端下载文件
            response.setHeader("content-Disposition", "attachment;filename="
                    + fileName);
            workbook.write(response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Excel导出(通用实体类)
     **/
    @GetMapping("/download_zip")
    public void download_zip(HttpServletResponse response) {

      //  File file = new File("F:\\java\\utils\\utils-demo\\zip\\20200505171654884.zip");
        File file = new File("F:\\java\\utils\\utils-demo\\zip");


        String downloadName = "下载文件名称.zip";

        //将文件进行打包下载
        try {
            OutputStream out = response.getOutputStream();
            byte[] data = createZip(file);//服务器存储地址
            response.reset();
            response.setHeader("Content-Disposition","attachment;fileName=asd.zip");
            response.addHeader("Content-Length", ""+data.length);
            response.setContentType("application/octet-stream;charset=UTF-8");
            IOUtils.write(data, out);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public byte[] createZip(File file) throws Exception{
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);
        //将目标文件打包成zip导出
        a(zip,file,"");
        IOUtils.closeQuietly(zip);
        return outputStream.toByteArray();
    }

    public void a(ZipOutputStream zip, File file, String dir) throws Exception {
        //如果当前的是文件夹，则进行进一步处理
        if (file.isDirectory()) {
            //得到文件列表信息
            File[] files = file.listFiles();
            //将文件夹添加到下一级打包目录
            zip.putNextEntry(new ZipEntry(dir + "/"));
            dir = dir.length() == 0 ? "" : dir + "/";
            //循环将文件夹中的文件打包
            for (int i = 0; i < files.length; i++) {
                a(zip, files[i], dir + files[i].getName());         //递归处理
            }
        } else {   //当前的是文件，打包处理
            //文件输入流
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            ZipEntry entry = new ZipEntry(dir);
            zip.putNextEntry(entry);
            zip.write(FileUtils.readFileToByteArray(file));
            IOUtils.closeQuietly(bis);
            zip.flush();
            zip.closeEntry();
        }
    }


}
