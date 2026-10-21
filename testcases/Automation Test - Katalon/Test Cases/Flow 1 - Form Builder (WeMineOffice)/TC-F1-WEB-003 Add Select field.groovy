// Preconditions: signed in as a WeMineOffice editor; use a new, empty draft form unless the case states otherwise.
CustomKeywords.'wemine.WeMineKeywords.startWeb'()
try {
    CustomKeywords.'wemine.WeMineKeywords.tapWeb'('Form Builder')
    CustomKeywords.'wemine.WeMineKeywords.tapWeb'('Input Select')
    String fieldSelector = CustomKeywords.'wemine.WeMineKeywords.requiredEnvironment'('WEMINE_WEB_FIELD_XPATH')
    CustomKeywords.'wemine.WeMineKeywords.verifyLastWebFieldType'(fieldSelector, 'Input Select', 1, 10)
} finally { CustomKeywords.'wemine.WeMineKeywords.closeWeb'() }
