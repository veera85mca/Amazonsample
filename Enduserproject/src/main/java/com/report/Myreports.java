package com.report;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import com.relevantcodes.extentreports.*;

public class Myreports {

	private static ExtentReports extend=null;
	private static ExtentTest test=null;
	private static Date dat;
	private static SimpleDateFormat simple;
	private static String da, reportpath, extendreportfolder, extendreportname;
	private static Map<Integer, ExtentTest> TestState=new HashMap<Integer, ExtentTest>();
		
	public synchronized static ExtentReports startreport(String suitename)
	{
		try {
		simple = new SimpleDateFormat("MMM_hh-mm-ss");
		dat=new Date();
		da=simple.format(dat);
		Properties prob=new Properties();
		prob.load(new FileInputStream(new File("./Myproperty/env.properties")));
		reportpath = prob.getProperty("Extendreportpath");
		extendreportfolder = suitename+"_"+da;
		extendreportname = reportpath+"/"+extendreportfolder+"/"+suitename+"_Report_"+da+".html";
		extend =new ExtentReports(extendreportname);
		prob.clear();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return extend;
	}
	public synchronized static ExtentTest starttest(String scena)
	{
		test = extend.startTest(scena);
		TestState.put((int)(long) (Thread.currentThread().getId()), test);
		return test;
	}
	public synchronized static void closereport()
	{
		extend.endTest((ExtentTest) gettest());
		extend.flush();
	}
	public synchronized static void addlogs(String desc, String status)
	{
		if(status.equalsIgnoreCase("Pass"))
		{
			gettest().log(LogStatus.PASS, desc);
			//test.log(LogStatus.PASS, stepname);
		}else if (status.equalsIgnoreCase("Fail")) {
			gettest().log(LogStatus.FAIL, desc);		
		}else if (status.equalsIgnoreCase("Info")) {
			gettest().log(LogStatus.INFO, desc);		
		}
	}
	private synchronized static ExtentTest gettest()
	{
		return (ExtentTest) TestState.get((int) (long) (Thread.currentThread().getId()));
	}
	public static synchronized int getTestId() {
		return (int) (long) (Thread.currentThread().getId());
	}
}

