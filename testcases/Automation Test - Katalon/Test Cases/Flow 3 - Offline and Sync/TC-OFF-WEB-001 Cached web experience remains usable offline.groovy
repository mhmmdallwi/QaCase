// Preconditions: WeMineOffice session and relevant master/form data have been loaded online first.
CustomKeywords.'wemine.WeMineKeywords.startWeb'()
try {
    CustomKeywords.'wemine.WeMineKeywords.verifyWebText'('Equipment Inspection', 30)
    CustomKeywords.'wemine.WeMineKeywords.setWebOffline'(true)
    // This checks cached app availability only; exact offline submission behavior must be confirmed for the deployed web client.
    CustomKeywords.'wemine.WeMineKeywords.verifyWebText'('Equipment Inspection', 10)
    boolean offlineIndicator = WebUI.verifyElementPresent(CustomKeywords.'wemine.WeMineKeywords.webText'('offline'), 3, com.kms.katalon.core.model.FailureHandling.OPTIONAL) || WebUI.verifyElementPresent(CustomKeywords.'wemine.WeMineKeywords.webText'('connection'), 3, com.kms.katalon.core.model.FailureHandling.OPTIONAL)
    if (!offlineIndicator) com.kms.katalon.core.util.KeywordUtil.logInfo('No explicit offline indicator found; validate cached interactions and queued writes with the actual product behavior.')
} finally {
    try { CustomKeywords.'wemine.WeMineKeywords.setWebOffline'(false) } catch (Exception ignored) {}
    CustomKeywords.'wemine.WeMineKeywords.closeWeb'()
}
