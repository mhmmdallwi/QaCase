// Preconditions: signed in as a WeMineOffice editor; use a new, empty draft form unless the case states otherwise.
// Preconditions: authenticated WeMineOffice editor; an empty draft form is selected.
CustomKeywords.'wemine.WeMineKeywords.startWeb'()
try {
    CustomKeywords.'wemine.WeMineKeywords.tapWeb'('Form Builder')
    for (int i = 0; i < 50; i++) { CustomKeywords.'wemine.WeMineKeywords.tapWeb'('Input Text') }
    String fieldSelector = CustomKeywords.'wemine.WeMineKeywords.requiredEnvironment'('WEMINE_WEB_FIELD_XPATH')
    CustomKeywords.'wemine.WeMineKeywords.verifyWebCountByXPath'(fieldSelector, 50, 10)
    try { CustomKeywords.'wemine.WeMineKeywords.tapWeb'('Input Text', 3) } catch (Exception ignored) { com.kms.katalon.core.util.KeywordUtil.logInfo('The field control may be disabled at the 50-field limit.') }
    CustomKeywords.'wemine.WeMineKeywords.verifyWebCountByXPath'(fieldSelector, 50, 10)
} finally { CustomKeywords.'wemine.WeMineKeywords.closeWeb'() }
