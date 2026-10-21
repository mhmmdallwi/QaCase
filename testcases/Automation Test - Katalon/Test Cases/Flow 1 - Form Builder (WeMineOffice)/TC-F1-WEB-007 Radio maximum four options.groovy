// Preconditions: signed in as a WeMineOffice editor; use a new, empty draft form unless the case states otherwise.
// Preconditions: authenticated editor and a draft form open.
CustomKeywords.'wemine.WeMineKeywords.startWeb'()
try {
    CustomKeywords.'wemine.WeMineKeywords.tapWeb'('Form Builder')
    CustomKeywords.'wemine.WeMineKeywords.tapWeb'('Input Radio')
    // Configure exactly four options; adjust this setup if the product initializes a different option count.
    String optionSelector = CustomKeywords.'wemine.WeMineKeywords.requiredEnvironment'('WEMINE_WEB_RADIO_OPTION_XPATH')
    def optionObject = new com.kms.katalon.core.testobject.TestObject('radioOptions')
    optionObject.addProperty('xpath', com.kms.katalon.core.testobject.ConditionType.EQUALS, optionSelector)
    int existingOptions = WebUI.findWebElements(optionObject, 3).size()
    for (int i = existingOptions; i < 4; i++) { CustomKeywords.'wemine.WeMineKeywords.tapWeb'('Add Option') }
    CustomKeywords.'wemine.WeMineKeywords.verifyWebCountByXPath'(optionSelector, 4, 10)
    try { CustomKeywords.'wemine.WeMineKeywords.tapWeb'('Add Option', 3) } catch (Exception ignored) { com.kms.katalon.core.util.KeywordUtil.logInfo('The builder may disable the add-option control at the four-option limit.') }
    CustomKeywords.'wemine.WeMineKeywords.verifyWebCountByXPath'(optionSelector, 4, 10)
} finally { CustomKeywords.'wemine.WeMineKeywords.closeWeb'() }
