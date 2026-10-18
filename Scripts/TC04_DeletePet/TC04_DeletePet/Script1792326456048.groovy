
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import groovy.json.JsonSlurper

def response = WS.sendRequest(
    findTestObject('Petstore/DELETE_PetByID')
)

WS.verifyResponseStatusCode(response, 200)

def body = new JsonSlurper().parseText(
    response.getResponseBodyContent()
)

assert body.code.toString() == '200'
assert body.message.toString() == '987654321'

println('PASS: Delete Pet berhasil')

def getResponse = WS.sendRequest(
    findTestObject('Petstore/GET_PetByID')
)

WS.verifyResponseStatusCode(getResponse, 404)

println('PASS: Pet tidak dapat diakses setelah delete')
