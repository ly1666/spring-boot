package cn.zhangxd.registry;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.*;

import ly.entity.TableColumn;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ImportWord {
    public List<TableColumn> testReadByDoc(String path) throws Exception {
        File f = new File(path);
        InputStream is = new FileInputStream(f);
        HWPFDocument doc = new HWPFDocument(is);
        //输出书签信息
        //  this.printInfo(doc.getBookmarks());
        //输出文本
        //  System.out.println(doc.getDocumentText());
        Range range = doc.getRange();
        //   this.printInfo(range);
        //读表格
        List<TableColumn> tableColumns = this.readTable(range);
        //读列表
        //  this.readList(range);
        //把当前HWPFDocument写到输出流中
        // doc.write(new FileOutputStream("D:\\temp\\test.doc"));
        is.close();
        return tableColumns;
    }

    /**
     * 输出书签信息
     * @param bookmarks
     */
    private void printInfo(Bookmarks bookmarks) {
        int count = bookmarks.getBookmarksCount();
        System.out.println("书签数量：" + count);
        Bookmark bookmark;
        for (int i=0; i<count; i++) {
            bookmark = bookmarks.getBookmark(i);
            System.out.println("书签" + (i+1) + "的名称是：" + bookmark.getName());
            System.out.println("开始位置：" + bookmark.getStart());
            System.out.println("结束位置：" + bookmark.getEnd());
        }
    }

    /**
     * 读表格
     * 每一个回车符代表一个段落，所以对于表格而言，每一个单元格至少包含一个段落，每行结束都是一个段落。
     * @param range
     */
    private List<TableColumn> readTable(Range range) {
        List<TableColumn> tableColumns = new ArrayList<>();
        //遍历range范围内的table。
        TableIterator tableIter = new TableIterator(range);
        Table table;
        TableRow row;
        TableCell cell;
        int i=0;
        int k=0;
        while (tableIter.hasNext()&&i<=1) {

            table = tableIter.next();
            int rowNum = table.numRows();
            for (int j=0; j<rowNum; j++) {
                TableColumn tableColumn = new TableColumn();
                row = table.getRow(j);
                int cellNum = row.numCells();
//                for (int k=0; k<cellNum; k++) {
//                    cell = row.getCell(k, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
//
//                    //输出单元格的文本
//                    System.out.println(cell.text().trim());
//                }
                k++;
                if(9==cellNum){
                    tableColumn.setId(row.getCell(0).text().trim());
                    tableColumn.setAssetType(row.getCell(1).text().trim());
                    tableColumn.setAssetName(row.getCell(2).text().trim());
                    tableColumn.setAssetBalanc(row.getCell(3).text().trim());
                    tableColumn.setProportion(row.getCell(4).text().trim());
                    tableColumn.setTerm(row.getCell(5).text().trim());
                    tableColumn.setWhether(row.getCell(6).text().trim());
                    tableColumn.setGrade(row.getCell(7).text().trim());
                    tableColumn.setMainGrade(row.getCell(8).text().trim());
                    tableColumn.setRatingGencies(row.getCell(9).text().trim());
//                tableColumn.setBz(row.getCell(12).text().trim());
                    tableColumns.add(tableColumn);


                    if(679==k){
                        System.out.println(k  +" " +row.getCell(0).text().trim()+" " +row.getCell(3).text().trim());
                    }
//                    System.out.println(k +" " +row.getCell(0).text().trim()+" "+row.getCell(3).text().trim());
                }else {
                    System.out.println(k);
                }

            }
            i++;
        }
        return tableColumns;
    }

    /**
     * 读列表
     * @param range
     */
    private void readList(Range range) {
        int num = range.numParagraphs();
        Paragraph para;
        for (int i=0; i<num; i++) {
            para = range.getParagraph(i);
            if (para.isInList()) {
                System.out.println("list: " + para.text());
            }
        }
    }

    /**
     * 输出Range
     * @param range
     */
    private void printInfo(Range range) {
        //获取段落数
        int paraNum = range.numParagraphs();
        System.out.println(paraNum);
        for (int i=0; i<paraNum; i++) {
            System.out.println("段落" + (i+1) + "：" + range.getParagraph(i).text());
        }
        int secNum = range.numSections();
        System.out.println(secNum);
        Section section;
        for (int i=0; i<secNum; i++) {
            section = range.getSection(i);
            System.out.println(section.getMarginLeft());
            System.out.println(section.getMarginRight());
            System.out.println(section.getMarginTop());
            System.out.println(section.getMarginBottom());
            System.out.println(section.getPageHeight());
            System.out.println(section.text());
        }
    }
}


