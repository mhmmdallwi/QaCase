// Preconditions: signed in as a known test reporter whose display name is configured in WEMINE_TEST_REPORTER_NAME.
CustomKeywords.'wemine.WeMineKeywords.startMobile'()
try {
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'('Hazard')
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'('Report Hazard')
    String reporter = System.getenv('WEMINE_TEST_REPORTER_NAME')
    if (!reporter) com.kms.katalon.core.util.KeywordUtil.markFailedAndStop('Set WEMINE_TEST_REPORTER_NAME to the display name of the signed-in test reporter.')
    CustomKeywords.'wemine.WeMineKeywords.verifyMobileText'(reporter, 10)
} finally { CustomKeywords.'wemine.WeMineKeywords.closeMobile'() }
