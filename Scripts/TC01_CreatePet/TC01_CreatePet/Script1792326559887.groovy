
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import groovy.json.JsonSlurper

def response = WS.sendRequest(
    findTestObject('Petstore/POST_CreatePet')
)

WS.verifyResponseStatusCode(response, 200)

def body = new JsonSlurper().parseText(
    response.getResponseBodyContent()
)

assert body.id.toString() == '987654321'
assert body.name == 'KatalonBuddy'
assert body.category.name == 'Dogs'
assert body.status == 'available'
assert body.photoUrls.contains(
    'https://contoh.com/pet.jpg'
)
assert body.tags[0].name == 'automation'

println('PASS: Create Pet berhasil')
