package DataProvider;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import Utility.*;

public class DataProviderHomePage {
	String path="F:\\MyFiles\\Selenium\\My Project\\simpleFramework\\src\\test\\java\\Resources\\TestData.xlsx";
	
	
	@DataProvider(name="getData")
	public String [][] getData() throws IOException
	{
		/*String loginData[][]= {
								{"admin@yourstore.com","admin","Valid"},
								{"admin@yourstore.com","adm","Invalid"},
								{"adm@yourstore.com","admin","Invalid"},
								{"adm@yourstore.com","adm","Invalid"}
							};*/
		
		//get the data from excel
		//String path="F:\\MyFiles\\Selenium\\My Project\\simpleFramework\\simpleFramework\\src\\test\\java\\Resources\\TestData.xlsx";
		ExcelUtility xlutil=new ExcelUtility(path);
		
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1",1);	
				
		String loginData[][]=new String[totalrows][totalcols];
			
		
		for(int i=1;i<=totalrows;i++) //1
		{
			for(int j=0;j<totalcols;j++) //0
			{
				loginData[i-1][j]=xlutil.getCellData("Sheet1", i, j);
			}
				
		}
		
		return loginData;
	}

	@DataProvider(name="getData2")
	public String [][] getData2() throws IOException
	{
		/*String loginData[][]= {
								{"admin@yourstore.com","admin","Valid"},
								{"admin@yourstore.com","adm","Invalid"},
								{"adm@yourstore.com","admin","Invalid"},
								{"adm@yourstore.com","adm","Invalid"}
							};*/
		
		//get the data from excel
		//String path="D:\\Selenium\\My selenium Projects\\SimpleFramework_CMS\\TestData.xlsx";
		ExcelUtility xlutil=new ExcelUtility(path);
		
		int totalrows=xlutil.getRowCount("Sheet2");
		int totalcols=xlutil.getCellCount("Sheet2",1);	
				
		String loginData[][]=new String[totalrows][totalcols];
			
		
		for(int i=1;i<=totalrows;i++) //1
		{
			for(int j=0;j<totalcols;j++) //0
			{
				loginData[i-1][j]=xlutil.getCellData("Sheet2", i, j);
			}
				
		}
		
		return loginData;
	}
	
	@DataProvider(name = "testData")
	public Object[][] getTestData(Method method) throws IOException {
	    String testName = method.getName();
	    String sheetName = "TestData";
	    ExcelUtility excel = new ExcelUtility(path);
	    int rows = excel.getRowCount(sheetName);
	    int cols = excel.getCellCount(sheetName, 0);
	    int startIndex = 0;
	    int endIndex = 0;
	    boolean flag = false;

	    // Find start and end index of rows for the test data
	    for (int i = 0; i < rows; i++) {
	        String value = excel.getCellData(sheetName, i, 0);
	        if (value.equalsIgnoreCase(testName)) {
	            if (!flag) {
	                startIndex = i;
	                flag = true;
	            }
	            endIndex = i;
	        }
	    }

	    // Extract the test data from the rows and columns in the sheet
	    Object[][] testData = new Object[endIndex - startIndex + 1][cols - 1];
	    int k = 0;
	    for (int i = startIndex + 1; i <= endIndex; i++) {
	        for (int j = 1; j < cols; j++) {
	            testData[k][j - 1] = excel.getCellData(sheetName, i, j);
	        }
	        k++;
	    }
	    return testData;
	}

}
