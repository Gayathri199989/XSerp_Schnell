package testSuite;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import category.HighPriorityTestCases;
import testCases.AccountDashTestCases;
import testCases.AccountsReportTestCases;
import testCases.AttendanceTestCases;
import testCases.BankReconTestCases;
import testCases.BillSettlementTestCases;
import testCases.DeliveryChallanTestCases;
import testCases.EmployeeTestCases;
import testCases.ExpenseTestCases;
import testCases.GeneralPOTestcases;
import testCases.ICDTestcases;
import testCases.IRTestCases;
import testCases.IndentTestCases;
import testCases.InvoiceTemplate;
import testCases.InvoiceTestCases;
import testCases.IssueTestCases;
import testCases.JobInReturnDC;
import testCases.LedgerTestCases;
import testCases.LoginTestCases;
import testCases.ManualNoteTestcases;
import testCases.MaterialTestCases;
import testCases.OATestCases;
import testCases.PartyTestCases;
import testCases.PayStructTestCases;
import testCases.PurchaseReportTestCases;
import testCases.QuickPOTestCases;
import testCases.ReceiptDCTestCases;
import testCases.ReceiptJOTestCases;
import testCases.ReceiptJobInTestCases;
import testCases.ReceiptOthersTestCases;
import testCases.ReceiptPOTestcases;
import testCases.ReceiptWithNWithoutJO;
import testCases.ReceiptWithWithoutPO;
import testCases.SalesEstimate;
import testCases.SalesReportTestCases;
import testCases.SalesReturnTestCases;
import testCases.StatementsTestCases;
import testCases.StoresDashTestCases;
import testCases.StoresReportTestCases;
import testCases.TaxTestCases;
import testCases.UserTestCases;
import testCases.VoucherTestcases;

@RunWith(Categories.class)
@Categories.IncludeCategory(HighPriorityTestCases.class)
@Suite.SuiteClasses({AccountDashTestCases.class, AccountsReportTestCases.class, AttendanceTestCases.class,
		BankReconTestCases.class, BillSettlementTestCases.class, DeliveryChallanTestCases.class,  EmployeeTestCases.class,
		ExpenseTestCases.class, GeneralPOTestcases.class, ICDTestcases.class, IndentTestCases.class,
		InvoiceTemplate.class, InvoiceTestCases.class, IRTestCases.class, IssueTestCases.class, JobInReturnDC.class,
		LedgerTestCases.class, LoginTestCases.class,  ManualNoteTestcases.class, MaterialTestCases.class, OATestCases.class,
		PartyTestCases.class, PayStructTestCases.class, PurchaseReportTestCases.class, QuickPOTestCases.class,
		ReceiptDCTestCases.class, ReceiptJobInTestCases.class, ReceiptJOTestCases.class, ReceiptOthersTestCases.class,
		ReceiptPOTestcases.class, ReceiptWithNWithoutJO.class, ReceiptWithWithoutPO.class, SalesEstimate.class,
		SalesReportTestCases.class, SalesReturnTestCases.class,  StatementsTestCases.class, StoresDashTestCases.class,
		StoresReportTestCases.class, TaxTestCases.class, UserTestCases.class, VoucherTestcases.class
		 })
public class HighPriorityTestSuite {

}
