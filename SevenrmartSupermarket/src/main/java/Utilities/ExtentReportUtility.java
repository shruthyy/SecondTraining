package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {
	public static final ExtentReports extentReports = new ExtentReports();

	public synchronized static ExtentReports createExtentReports() {
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");
		reporter.config().setReportName("SevenrmartSupermarket Automation Report");
		extentReports.attachReporter(reporter);
		extentReports.setSystemInfo("Tester", "SRUTHI");
		extentReports.setSystemInfo("Blog Name", "SevenrmartSupermarket");
		return extentReports;
	}
}
