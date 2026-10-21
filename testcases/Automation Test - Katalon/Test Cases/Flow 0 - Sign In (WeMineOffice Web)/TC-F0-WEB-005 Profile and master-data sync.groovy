// Preconditions: valid test account; browser starts without a completed authenticated session.
CustomKeywords.'wemine.WeMineKeywords.assertEnvironment'('WEMINE_TEST_USERNAME')
CustomKeywords.'wemine.WeMineKeywords.startWeb'()
try {
    String homeMarker = System.getenv('WEMINEOFFICE_HOME_MARKER')
    if (!homeMarker) com.kms.katalon.core.util.KeywordUtil.markFailedAndStop('Set WEMINEOFFICE_HOME_MARKER to a stable label visible after sign-in.')
    CustomKeywords.'wemine.WeMineKeywords.verifyWebText'(homeMarker, 60)
    CustomKeywords.'wemine.WeMineKeywords.verifyWebRequestObserved'('/user/me', 15)
    CustomKeywords.'wemine.WeMineKeywords.verifyWebRequestObserved'('/tenant/master', 15)
    String syncText = System.getenv('WEMINE_SYNC_IN_PROGRESS_TEXT')
    if (!syncText) com.kms.katalon.core.util.KeywordUtil.markFailedAndStop('Set WEMINE_SYNC_IN_PROGRESS_TEXT to the progress label shown during master-data sync.')
    CustomKeywords.'wemine.WeMineKeywords.verifyWebTextNotPresent'(syncText, 10)
} finally { CustomKeywords.'wemine.WeMineKeywords.closeWeb'() }
