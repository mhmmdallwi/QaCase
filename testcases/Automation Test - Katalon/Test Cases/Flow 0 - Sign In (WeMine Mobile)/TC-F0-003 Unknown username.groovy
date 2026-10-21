// Preconditions: network is available and WEMINE_UNKNOWN_USERNAME is not registered to a tenant.
if (!System.getenv('WEMINE_UNKNOWN_USERNAME')) com.kms.katalon.core.util.KeywordUtil.markFailedAndStop('Set WEMINE_UNKNOWN_USERNAME to a value that is not registered in the test environment.')
CustomKeywords.'wemine.WeMineKeywords.startMobile'()
try {
    CustomKeywords.'wemine.WeMineKeywords.setMobileField'('Username', System.getenv('WEMINE_UNKNOWN_USERNAME'))
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'('Continue')
    CustomKeywords.'wemine.WeMineKeywords.verifyMobileFieldPresent'('Username', 10)
    CustomKeywords.'wemine.WeMineKeywords.verifyMobileTextNotPresent'('Microsoft', 3)
} finally { CustomKeywords.'wemine.WeMineKeywords.closeMobile'() }
