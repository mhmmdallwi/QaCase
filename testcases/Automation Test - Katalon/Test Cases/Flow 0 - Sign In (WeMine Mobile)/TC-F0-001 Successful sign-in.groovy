// Preconditions: dedicated valid user; Microsoft test-tenant authentication is available.
CustomKeywords.'wemine.WeMineKeywords.assertEnvironment'('WEMINE_TEST_USERNAME')
CustomKeywords.'wemine.WeMineKeywords.startMobile'()
try {
    CustomKeywords.'wemine.WeMineKeywords.setMobileField'('Username', System.getenv('WEMINE_TEST_USERNAME'))
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'('Continue')
    CustomKeywords.'wemine.WeMineKeywords.verifyMobileText'('Microsoft')
    CustomKeywords.'wemine.WeMineKeywords.completeMicrosoftSignIn'()
    String homeMarker = System.getenv('WEMINE_MOBILE_HOME_MARKER')
    if (!homeMarker) com.kms.katalon.core.util.KeywordUtil.markFailedAndStop('Set WEMINE_MOBILE_HOME_MARKER to a stable label visible after mobile sign-in.')
    CustomKeywords.'wemine.WeMineKeywords.verifyMobileText'(homeMarker, 60)
} finally { CustomKeywords.'wemine.WeMineKeywords.closeMobile'() }
