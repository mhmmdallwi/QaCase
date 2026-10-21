// Preconditions: a valid test user is assigned to a configured tenant; Microsoft test sign-in is available.
CustomKeywords.'wemine.WeMineKeywords.assertEnvironment'('WEMINE_TEST_USERNAME')
CustomKeywords.'wemine.WeMineKeywords.openWebApp'()
try {
    CustomKeywords.'wemine.WeMineKeywords.setWebField'('Username', System.getenv('WEMINE_TEST_USERNAME'))
    try { CustomKeywords.'wemine.WeMineKeywords.tapWeb'('Continue', 5) } catch (Exception ignored) { CustomKeywords.'wemine.WeMineKeywords.tapWeb'('Next', 5) }
    CustomKeywords.'wemine.WeMineKeywords.verifyWebFieldPresent'('Email', 20)
    CustomKeywords.'wemine.WeMineKeywords.completeMicrosoftSignInWeb'()
    String homeMarker = System.getenv('WEMINEOFFICE_HOME_MARKER')
    if (!homeMarker) com.kms.katalon.core.util.KeywordUtil.markFailedAndStop('Set WEMINEOFFICE_HOME_MARKER to a stable label visible after sign-in.')
    CustomKeywords.'wemine.WeMineKeywords.verifyWebText'(homeMarker, 60)
} finally { CustomKeywords.'wemine.WeMineKeywords.closeWeb'() }
