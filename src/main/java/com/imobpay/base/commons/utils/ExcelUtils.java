/**
 *  <pre>
 *  Project Name:ScorePlatform .</br>
 *  File: ExcelUtils.java .</br>
 *  Package Name:com.imobpay.commons.utils .</br>
 *  Date      Author       Changes .</br>
 *  2017年6月1日   Harrison Jiang     Create  .</br>
 *  Description: .</br>
 *  Copyright 2014-2015 Harrison Jiang  FINANCE Services Co.,Ltd. All rights reserved..</br>
 *  <pre>
 */



package com.imobpay.base.commons.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
    public static final String HEADERINFO = "headInfo";
    public static final String DATAINFON  = "dataInfo";


    public List<List<Cell>> readFromExcel(String fileAbsolutePath) throws IOException {

        /**
         * 读取Excel表中的所有数据
         */
        List<List<Cell>> list     = new ArrayList<List<Cell>>();
        Workbook         workbook = getWeebWork(fileAbsolutePath);

        // System.out.println("总表页数为：" + workbook.getNumberOfSheets());// 获取表页数
        Sheet sheet = workbook.getSheetAt(0);

        // Sheet sheet = workbook.getSheetAt(1);
        int rownum = sheet.getLastRowNum();    // 获取总行数

        for (int i = 0; i <= rownum; i++) {
            Row row = sheet.getRow(i);

            // Cell orderno = row.getCell(2);// 获取指定单元格中的数据
            //// System.out.println(orderno.getCellType());//这个打印的是cell的type
            // short cellnum = row.getLastCellNum(); // 获取单元格的总列数
            List<Cell> temp = new ArrayList<Cell>();

            for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
                Cell celldata = row.getCell(j);

                temp.add(celldata);
            }

            list.add(temp);
        }

        return list;

        /**
         * 读取指定位置的单元格
         */

        // Row row1 = sheet.getRow(1);
        // Cell cell1 = row1.getCell(2);
        // System.out.print("(1,2)位置单元格的值为："+cell1);
        // BigDecimal big = new
        // BigDecimal(cell1.getNumericCellValue());//将科学计数法表示的数据转化为String类型
        // System.out.print("\t"+String.valueOf(big));
    }

    /**
     *
     * @Title: readerExcelDemo
     * @Description: TODO(读取Excel表中的数据)
     * @throws IOException
     */

    // public void readFromExcelDemo() throws IOException {
    // /**
    // * 读取Excel表中的所有数据
    // */
    // Workbook workbook = getWeebWork("E:/test.xlsx");
    // System.out.println("总表页数为：" + workbook.getNumberOfSheets());// 获取表页数
    // Sheet sheet = workbook.getSheetAt(0);
    //// Sheet sheet = workbook.getSheetAt(1);
    // int rownum = sheet.getLastRowNum();// 获取总行数
    // for (int i = 0; i <= rownum; i++) {
    // Row row = sheet.getRow(i);
    // Cell orderno = row.getCell(2);// 获取指定单元格中的数据
    //// System.out.println(orderno.getCellType());//这个打印的是cell的type
    // short cellnum = row.getLastCellNum(); // 获取单元格的总列数
    // for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
    // Cell celldata = row.getCell(j);
    // System.out.print(celldata + "\t");
    // }
    // System.out.println();
    // }
    //
    // /**
    // * 读取指定位置的单元格
    // */
    //// Row row1 = sheet.getRow(1);
    //// Cell cell1 = row1.getCell(2);
    //// System.out.print("(1,2)位置单元格的值为："+cell1);
    //// BigDecimal big = new
    //// BigDecimal(cell1.getNumericCellValue());//将科学计数法表示的数据转化为String类型
    //// System.out.print("\t"+String.valueOf(big));
    //
    // }
    //
    // public void readFromExcelDemo1() throws IOException {
    // /**
    // * 读取Excel表中的所有数据
    // *
    // * Workbook: excel的文档对象 sheet: excel的表单 row: excel中的行 cell: excel中的单元格子
    // *
    // */
    // Workbook workbook = getWeebWork("E:/test.xlsx");
    // System.out.println("总表页数为：" + workbook.getNumberOfSheets());// 获取表页数
    //// Sheet sheet =workbook.getSheetAt(0);
    // Sheet sheet = workbook.getSheetAt(2);// 获取第二个表单
    // int rownum = sheet.getLastRowNum();// 获取总行数
    // for (int i = 0; i <= rownum; i++) {
    // Row row = sheet.getRow(i);// 获取表达的第i行
    //// Cell orderno =
    //// row.getCell(2);//获取指定单元格中的数据(获取一行中的第2列(这里的2指的是0,1,2.排在第三位))
    //// System.out.println(orderno.getCellType());//这个打印的是cell的type
    //// short cellnum=row.getLastCellNum();
    //// //获取单元格的总列数(获取一行中有多少个单元格(也就是多少列))
    //
    // /**
    // * row.getFirstCellNum(): 获取行的第一个单元格的位置 row.getLastCellNum():
    // * 获取行的最后一个单元格的位置
    // */
    // for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {//
    // 遍历一行中的所有列
    // Cell celldata = row.getCell(j);// 获取一行中的第j列返回Cell类型的数据
    // System.out.print(celldata + "\t");//
    // }
    //
    //// 打印指定列
    //// Cell celldata = row.getCell(4);//获取这一行中的第4列(在第5个位置上)
    //// System.out.print( "\"" + celldata+"\",");
    //
    // System.out.println();
    // }
    //
    // /**
    // * 读取指定位置的单元格
    // */
    //// Row row1 = sheet.getRow(1);
    //// Cell cell1 = row1.getCell(2);
    //// System.out.print("(1,2)位置单元格的值为："+cell1);
    //// BigDecimal big = new
    //// BigDecimal(cell1.getNumericCellValue());//将科学计数法表示的数据转化为String类型
    //// System.out.print("\t"+String.valueOf(big));
    //
    // }
    public Integer readFromExcelRowNum(String fileAbsolutePath) throws IOException {
        Workbook workbook = getWeebWork(fileAbsolutePath);

        // System.out.println("总表页数为：" + workbook.getNumberOfSheets());// 获取表页数
        Sheet sheet  = workbook.getSheetAt(0);
        int   rownum = sheet.getLastRowNum();    // 获取总行数

        return rownum;
    }

    /**
     *
     * @Title: writeExcel
     * @Description: TODO(导出Excel表)
     * @param pathname
     *            :导出Excel表的文件路径
     * @param map
     *            ：封装需要导出的数据(HEADERINFO封装表头信息，DATAINFON：封装要导出的数据信息,此处需要使用TreeMap )
     *            例如： map.put(ExcelUtil.HEADERINFO,List<String> headList);
     *            map.put(ExcelUtil.DATAINFON,List<TreeMap<String,Object>>
     *            dataList);
     * @param wb
     * @throws IOException
     */
    public void writeExcel(String pathname, Map<String, Object> map, Workbook wb) throws IOException {
        if ((null != map) && (null != pathname)) {
            List<Object>                  headList = (List<Object>) map.get(ExcelUtils.HEADERINFO);
            List<TreeMap<String, Object>> dataList = (List<TreeMap<String, Object>>) map.get(ExcelUtils.DATAINFON);
            CellStyle                     style    = getCellStyle(wb);
            Sheet                         sheet    = wb.createSheet();    // 在文档对象中创建一个表单..默认是表单名字是Sheet0、Sheet1....

            // Sheet sheet = wb.createSheet("hell poi");//在创建爱你表单的时候指定表单的名字

            /**
             * 设置Excel表的第一行即表头
             */
            Row row = sheet.createRow(0);

            for (int i = 0; i < headList.size(); i++) {
                Cell headCell = row.createCell(i);

                headCell.setCellType(Cell.CELL_TYPE_STRING);                     // 设置这个单元格的数据的类型,是文本类型还是数字类型
                headCell.setCellStyle(style);                                    // 设置表头样式
                headCell.setCellValue(String.valueOf(headList.get(i)));          // 给这个单元格设置值
            }

            if ((null != dataList) && (dataList.size() > 0)) {
                for (int i = 0; i < dataList.size(); i++) {
                    Row                     rowdata = sheet.createRow(i + 1);    // 创建数据行
                    TreeMap<String, Object> mapdata = dataList.get(i);
                    Iterator                it      = mapdata.keySet().iterator();
                    int                     j       = 0;

                    while (it.hasNext()) {
                        String strdata  = String.valueOf(mapdata.get(it.next()));
                        Cell   celldata = rowdata.createCell(j);                 // 在一行中创建某列..

                        celldata.setCellType(Cell.CELL_TYPE_STRING);
                        celldata.setCellValue(strdata);
                        j++;
                    }
                }
            }

            // 文件流
            File         file = new File(pathname);
            OutputStream os   = new FileOutputStream(file);

            os.flush();
            wb.write(os);
            os.close();
        }
    }

    public File writeToExcel(List headList, List dataList, String absoluteFileName) throws IOException {

        /**
         * HSSF: .xls XSSF: .xlsx 所以大家会在官网中看到Excel = HSSF+XSSF
         *
         * HSSF是POI工程对Excel 97(-2007)文件操作的纯Java实现 XSSF是POI工程对Excel 2007 OOXML
         * (.xlsx)文件操作的纯Java实现
         *
         * 从POI 3.8版本开始，提供了一种基于XSSF的低内存占用的API----SXSSF
         *
         */
        Workbook            wb  = new XSSFWorkbook();    // 创建一个新的excel的文档对象
        Map<String, Object> map = new HashMap<String, Object>();

        // List headList = new ArrayList();// 表头数据
        // headList.add("下单时间");
        // headList.add("结账时间");
        // headList.add("订单编号");
        // headList.add("订单金额");
        // headList.add("用户名");// excel的都

        // /**
        // * TreeMap基于红黑树实现
        // */
        // List dataList = new ArrayList();// 表格内的数据
        // for (int i = 0; i < 15; i++) {
        // TreeMap<String, Object> treeMap = new TreeMap<String, Object>();//
        // 此处的数据必须为有序数据，所以使用TreeMap进行封装
        // treeMap.put("m1", "2013-10-" + i + 1);
        // treeMap.put("m2", "2013-11-" + i + 1);
        // treeMap.put("m3", "20124" + i + 1);
        // treeMap.put("m4", 23.5 + i + 1);
        // treeMap.put("m5", "张三_" + i);
        // dataList.add(treeMap);
        // }

        /*
         * 先不要加上以下这一段,否则以下错误: Cannot get a numeric value from a text cell(不能从一个text
         * cell中获取数字类型的数据)
         *
         * 解决办法: http://blog.csdn.net/ysughw/article/details/9288307
         */

        // TreeMap<String,Object> treeMap1 = new TreeMap<String, Object>();
        // treeMap1.put("asd", null);
        // treeMap1.put("猪头", "zhutou");
        // dataList.add(treeMap1);
        map.put(ExcelUtils.HEADERINFO, headList);
        map.put(ExcelUtils.DATAINFON, dataList);
        writeExcel(absoluteFileName, map, wb);    // 往wb里面写map中内容，生成E:/test1.xlsx这个文件....

        File file = new File(absoluteFileName);

        return file;
    }

    /**
     *
     * @Title: getCellStyle
     * @Description: TODO（设置表头样式）
     * @param wb
     * @return
     */
    public CellStyle getCellStyle(Workbook wb) {
        CellStyle style = wb.createCellStyle();
        Font      font  = wb.createFont();

        font.setFontName("宋体");
        font.setFontHeightInPoints((short) 12);                // 设置字体大小
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);          // 加粗
        style.setFillForegroundColor(HSSFColor.LIME.index);    // 设置背景色
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setAlignment(HSSFCellStyle.SOLID_FOREGROUND);    // 让单元格居中

        // style.setWrapText(true);//设置自动换行
        style.setFont(font);

        return style;
    }

    /**
     *
     * @Title: getWeebWork
     * @Description: TODO(根据传入的文件名获取工作簿对象(Workbook))
     * @param filename
     * @return
     * @throws IOException
     */
    public Workbook getWeebWork(String filename) throws IOException {
        Workbook workbook = null;

        if (null != filename) {
            String          fileType   = filename.substring(filename.lastIndexOf("."), filename.length());
            FileInputStream fileStream = new FileInputStream(new File(filename));

            if (".xls".equals(fileType.trim().toLowerCase())) {
                workbook = new HSSFWorkbook(fileStream);    // 创建 Excel 2003 工作簿对象
            } else if (".xlsx".equals(fileType.trim().toLowerCase())) {
                workbook = new XSSFWorkbook(fileStream);    // 创建 Excel 2007 工作簿对象
            }
        }

        return workbook;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
