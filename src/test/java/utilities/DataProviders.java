package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
		//DataProvider 1
		
		@DataProvider(name="LoginData")
		public String [][] getData() throws IOException
		{
			String path="./testData/Opencart_Login_Test_Data.xlsx";//taking Excel file from testData
			
			ExcelUtillity xlutil=new ExcelUtillity(path);//creating an object for XLUtility
			
			int totalrows=xlutil.getRowCount("Logintestdata");	
			int totalcols=xlutil.getCellCount("Logintestdata",1);
					
			String logindata[][]=new String[totalrows][totalcols];//created for two dimension array which can store the data user and password
			
			for(int r=1;r<=totalrows;r++)  //1   //read the data from xl storing in two deminsional array
			{		
				for(int c=0;c<totalcols;c++)  //0    r is rows c is col
				{
					logindata[r-1][c]= xlutil.getCellData("Logintestdata",r, c);  //1,0
				}
			}
		return logindata;//returning two dimension array
					
		}
		
		//DataProvider 2
		
		//DataProvider 3
		
		//DataProvider 4
	}



