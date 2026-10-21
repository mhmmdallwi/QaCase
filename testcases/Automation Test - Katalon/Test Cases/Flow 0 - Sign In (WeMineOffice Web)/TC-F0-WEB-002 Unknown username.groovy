// Preconditions: use a username that is not registered to any configured tenant.
String unknownUser = System.getenv('WEMINE_UNKNOWN_USERNAME')
if (!unknownUser) com.kms.katalon.core.util.KeywordUtil.markFailedAndStop('Set WEMINE_UNKNOWN_USERNAME to a value that is not registered in the test environment.')
CustomKeywords.'wemine.WeMineKeywords.openWebApp'()
try {
    CustomKeywords.'wemine.WeMineKeywords.setWebField'('Username', unknownUser)
    try { CustomKeywords.'wemine.WeMineKeywords.tapWeb'('Continue', 5) } catch (Exception ignored) { CustomKeywords.'wemine.WeMineKeywords.tapWeb'('Next', 5) }
    CustomKeywords.'wemine.WeMineKeywords.verifyWebFieldPresent'('Username', 10)
    CustomKeywords.'wemine.WeMineKeywords.verifyWebFieldNotPresent'('Email', 3)
} finally { CustomKeywords.'wemine.WeMineKeywords.closeWeb'() }
