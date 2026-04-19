import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.chrome.ChromeOptions as ChromeOptions

ChromeOptions options = new ChromeOptions()

options.addArguments('--incognito')

WebUI.openBrowser('https://www.saucedemo.com/')

def listProduk = ['add-to-cart-sauce-labs-backpack', 'add-to-cart-sauce-labs-bike-light', 'add-to-cart-sauce-labs-bolt-t-shirt']

WebUI.callTestCase(findTestCase('Auth/Login with valid credentials'), [:])

for (String idProduk : listProduk) {
    WebUI.comment('Sedang menambahkan produk: ' + idProduk)

    WebUI.click(findTestObject('Object Repository/Page_Swag Labs/btn_Dynamic_Add_to_Cart', [('ID_PRODUK') : idProduk]))
}

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Swag Labs/icon_CartBadge'), 5)

WebUI.comment('Skenario Berhasil: Produk sudah masuk ke keranjang!')

