package generics;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel 
{
    public static int getRowCount(String path,String sheet)
    {
        int r=0;
        try{
            
            r=WorkbookFactory.create(new FileInputStream(path)).getSheet(sheet).getLastRowNum();
        }
        catch(Exception e)
        {
            //e.printStackTrace();
        }
        return r;
    }
    
    public static String getCellValue(String path,String sheet,int r,int c)
    {
        String v="";
        try{
            
            v=WorkbookFactory.create(new FileInputStream(path)).getSheet(sheet).getRow(r).getCell(c).toString();
        }
        catch(Exception e)
        {
            //e.printStackTrace();
        }
        return v;
    }
    public void writeExcelData(String path,String sheet,int row,int cell,String data){
    	try{
    		FileInputStream fis=new FileInputStream(path);
    		Workbook wb=WorkbookFactory.create(fis);
    		Sheet s=wb.getSheet(sheet);
    		Row r=s.createRow(row);
    		Cell c=r.createCell(cell);
    		c.setCellValue(data);
    		FileOutputStream fos=new FileOutputStream(path);
    		wb.write(fos);
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    }
}