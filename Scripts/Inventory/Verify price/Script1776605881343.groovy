import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.WebElement as WebElement 

WebUI.callTestCase(findTestCase('Auth/Login with valid credentials'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl('https://www.saucedemo.com/inventory.html')

// 1. Ambil teks harga dari produk pertama
String teksHarga = WebUI.getText(findTestObject('Object Repository/Page_Swag Labs/txt_All_Product_Prices'))

// 2. Cek apakah teksnya mengandung atau dimulai dengan '$'
// Pakai verifyMatch dengan Regex (simbol '^\\$' artinya harus diawali tanda dollar)
WebUI.verifyMatch(teksHarga, '^\\$.*', true)

println("Ekspektasi Terpenuhi! Format harga adalah: " + teksHarga)
