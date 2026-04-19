import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// 1. Login
WebUI.callTestCase(findTestCase('Auth/Login with valid credentials'), [:])

// 2. Klik gambarnya (Panggil nama objeknya di sini)
WebUI.click(findTestObject('Object Repository/Page_Swag Labs/data_set'))

// 3. Verifikasi pindah halaman
String currentUrl = WebUI.getUrl()
WebUI.verifyMatch(currentUrl, '.*inventory-item.html\\?id=.*', true)

WebUI.comment("Skenario Click Picture Detail Berhasil!")