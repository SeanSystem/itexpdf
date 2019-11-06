package com.example.itextpdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileOutputStream;
import java.util.List;

@SpringBootTest
class ItextpdfApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void test1() throws Exception {
        BaseFont bfChinese = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        Font font = new Font(bfChinese, 14, Font.NORMAL);
        // 1.新建document对象
        Document document = new Document();
        // 2.建立一个书写器(Writer)与document对象关联，通过书写器(Writer)可以将文档写入到磁盘中。
        // 创建 PdfWriter 对象 第一个参数是对文档对象的引用，第二个参数是文件的实际名称，在该名称中还会给出其输出路径。
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("F:/excel/test.pdf"));
        // 3.打开文档
        document.open();
        // 4.添加一个内容段落
        Font titleFont = new Font(bfChinese, 20, Font.BOLD);
        Paragraph elements = new Paragraph("土地整治项目分析报告", titleFont);
        elements.setAlignment(Element.ALIGN_CENTER);
        document.add(elements);
        //添加列表
        com.itextpdf.text.List orderList = new com.itextpdf.text.List(com.itextpdf.text.List.ORDERED);
        ListItem item1 = new ListItem("用途管制区分析",font);
        Paragraph paragraph1 = new Paragraph("导入红线范围总面积1374.28平方米，占用建设用地空间管制区情况如下：占用允许建设区1008.31平方米，占用有条件建设区0平方米，占用限制建设用地区365.96平方米，占用禁止建设用地区0平方米。", font);
        paragraph1.setFirstLineIndent(30);
        item1.add(paragraph1);
        Paragraph littleP = new Paragraph("明细列表", font);
        littleP.setSpacingBefore(20f);
        item1.add(littleP);
        //创建2行的表格
        PdfPTable table = new PdfPTable(6);
        table.setWidthPercentage(100); // 宽度100%填充
        table.setSpacingBefore(10f); // 前间距
        table.setSpacingAfter(10f); // 后间距
        List<PdfPRow> listRow = table.getRows();
        //设置列宽
        float[] columnWidths = { 1f, 2f, 2f, 2f, 2f,2f };
        table.setWidths(columnWidths);
//行1
        PdfPCell cells1[]= new PdfPCell[6];
        PdfPRow row1 = new PdfPRow(cells1);

        //单元格
        cells1[0] = new PdfPCell(new Paragraph("序号",font));//单元格内容
        //cells1[0].setBorderColor(BaseColor.BLUE);//边框验证
       // cells1[0].setPaddingLeft(20);//左填充20
        cells1[0].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
        cells1[0].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中

        cells1[1] = new PdfPCell(new Paragraph("行政区代码",font));
        cells1[1].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
        cells1[1].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中

        cells1[2] = new PdfPCell(new Paragraph("行政区名称",font));
        cells1[2].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
        cells1[2].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中

        cells1[3] = new PdfPCell(new Paragraph("管制区代码",font));
        cells1[3].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
        cells1[3].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中

        cells1[4] = new PdfPCell(new Paragraph("管制区名称",font));
        cells1[4].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
        cells1[4].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中

        cells1[5] = new PdfPCell(new Paragraph("占用面积（平方米）",font));
        cells1[5].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
        cells1[5].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中
        listRow.add(row1);

        //第二行
        PdfPCell cells2[]= new PdfPCell[6];
        PdfPRow row2 = new PdfPRow(cells2);
        cells2[0] = new PdfPCell(new Paragraph("1",font));//单元格内容
        //cells1[0].setBorderColor(BaseColor.BLUE);//边框验证
        // cells1[0].setPaddingLeft(20);//左填充20
        cells2[0].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
        cells2[0].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中

        cells2[1] = new PdfPCell(new Paragraph("330502",font));
        cells2[1].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
        cells2[1].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中

        cells2[2] = new PdfPCell(new Paragraph("某某县",font));
        cells2[2].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
        cells2[2].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中

        cells2[3] = new PdfPCell(new Paragraph("330502",font));
        cells2[3].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
        cells2[3].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中

        cells2[4] = new PdfPCell(new Paragraph("某某管制区",font));
        cells2[4].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
        cells2[4].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中

        cells2[5] = new PdfPCell(new Paragraph("21.3333",font));
        cells2[5].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
        cells2[5].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中
        listRow.add(row2);
        item1.add(table);
        orderList.add(item1);
        document.add(orderList);
        // 5.关闭文档
        document.close();
    }

    @Test
    public void test2() throws Exception {
        //创建文件
        Document document = new Document();
        //建立一个书写器
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("F:/excel/test2.pdf"));
        //打开文件
        document.open();
        Paragraph title = new Paragraph("你好");
        title.setAlignment(Element.ALIGN_CENTER);
        //添加内容
        document.add(title);
        // 3列的表.
        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100); // 宽度100%填充
        table.setSpacingBefore(10f); // 前间距
        table.setSpacingAfter(10f); // 后间距

        List<PdfPRow> listRow = table.getRows();
        //设置列宽
        float[] columnWidths = {1f, 2f, 3f};
        table.setWidths(columnWidths);

        //行1
        PdfPCell cells1[] = new PdfPCell[3];
        PdfPRow row1 = new PdfPRow(cells1);

        //单元格
        cells1[0] = new PdfPCell(new Paragraph("111"));//单元格内容
        // cells1[0].setBorderColor(BaseColor.BLUE);//边框验证
        cells1[0].setPaddingLeft(20);//左填充20
        cells1[0].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
        cells1[0].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中

        cells1[1] = new PdfPCell(new Paragraph("222"));
        cells1[2] = new PdfPCell(new Paragraph("333"));

        //行2
        PdfPCell cells2[] = new PdfPCell[3];
        PdfPRow row2 = new PdfPRow(cells2);
        cells2[0] = new PdfPCell(new Paragraph("444"));

        //把第一行添加到集合
        listRow.add(row1);
        listRow.add(row2);
        //把表格添加到文件中
        document.add(table);
        //关闭文档
        document.close();
        //关闭书写器
        writer.close();
    }
}
