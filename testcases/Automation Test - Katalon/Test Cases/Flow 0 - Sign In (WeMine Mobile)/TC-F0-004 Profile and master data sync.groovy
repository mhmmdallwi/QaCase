// Preconditions: valid account; tenant master-data endpoints are available; clean app state if needed.
CustomKeywords.'wemine.WeMineKeywords.assertEnvironment'('WEMINE_TEST_USERNAME')
CustomKeywords.'wemine.WeMineKeywords.startMobile'()
try {
    CustomKeywords.'wemine.WeMineKeywords.setMobileField'('Username', System.getenv('WEMINE_TEST_USERNAME'))
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'('Continue')
    CustomKeywords.'wemine.WeMineKeywords.verifyMobileText'('Microsoft', 20)
    CustomKeywords.'wemine.WeMineKeywords.completeMicrosoftSignIn'()
    String homeMarker = System.getenv('WEMINE_MOBILE_HOME_MARKER')
    if (!homeMarker) com.kms.katalon.core.util.KeywordUtil.markFailedAndStop('Set WEMINE_MOBILE_HOME_MARKER to a stable label visible after mobile sign-in.')
    CustomKeywords.'wemine.WeMineKeywords.verifyMobileText'(homeMarker, 60)
    CustomKeywords.'wemine.WeMineKeywords.verifyMobileTextNotPresent'('Syncing', 3)
} finally { CustomKeywords.'wemine.WeMineKeywords.closeMobile'() }
// UI assertions confirm the app reaches the authenticated screen; endpoint-level verification requires server/network logs.
