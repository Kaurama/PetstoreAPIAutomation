
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import groovy.json.JsonSlurper

def response = WS.sendRequest(
    findTestObject('Petstore/PUT_UpdatePet')
)

WS.verifyResponseStatusCode(response, 200)

def body = new JsonSlurper().parseText(
    response.getResponseBodyContent()
)

assert body.id.toString() == '987654321'

assert body.name == 'KatalonBuddyUpdated'

assert body.status == 'sold'

assert body.category.name == 'Dogs'

println('PASS: Update Pet berhasil')
