/**
 *  <pre>
 *  Project Name:ScorePlatform .</br>
 *  File: a.java .</br>
 *  Package Name:com.imobpay.commons.utils.excel .</br>
 *  Date      Author       Changes .</br>
 *  2017年6月26日   Harrison Jiang     Create  .</br>
 *  Description: .</br>
 *  Copyright 2014-2015 Harrison Jiang  FINANCE Services Co.,Ltd. All rights reserved..</br>
 *  <pre>
 */



package com.imobpay.base.commons.utils.excel;

import java.io.FileInputStream;

import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * <pre>
 * 【类型】: a <br/>
 * 【作用】: TODO ADD FUNCTION. <br/>
 * 【时间】：2017年6月26日 上午10:39:45 <br/>
 * 【作者】：Harrison Jiang <br/>
 * </pre>
 */
public class PoiExcel2k3Helper extends PoiExcelHelper {

    /** 读取Excel文件内容 */
    public ArrayList<ArrayList<String>> readExcel(String filePath, int sheetIndex, String rows, int[] cols) {
        ArrayList<ArrayList<String>> dataList = new ArrayList<ArrayList<String>>();

        try {
            HSSFWorkbook wb    = new HSSFWorkbook(new FileInputStream(filePath));
            HSSFSheet    sheet = wb.getSheetAt(sheetIndex);

            dataList = readExcel(sheet, rows, cols);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataList;
    }

    /** 读取Excel文件内容 */
    public ArrayList<ArrayList<String>> readExcel(String filePath, int sheetIndex, String rows, String columns) {
        ArrayList<ArrayList<String>> dataList = new ArrayList<ArrayList<String>>();

        try {
            HSSFWorkbook wb    = new HSSFWorkbook(new FileInputStream(filePath));
            HSSFSheet    sheet = wb.getSheetAt(sheetIndex);

            dataList = readExcel(sheet, rows, getColumnNumber(sheet, columns));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataList;
    }

    /** 获取sheet列表 */
    public ArrayList<String> getSheetList(String filePath) {
        ArrayList<String> sheetList = new ArrayList<String>(0);

        try {
            HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(filePath));
            int          i  = 0;

            while (true) {
                try {
                    String name = wb.getSheetName(i);

                    sheetList.add(name);
                    i++;
                } catch (Exception e) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sheetList;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
