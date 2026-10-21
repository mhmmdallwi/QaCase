// Preconditions: first-sync test profile and a controllable connection; interrupt sync while it is in progress.
CustomKeywords.'wemine.WeMineKeywords.assertEnvironment'('WEMINE_TEST_USERNAME')
CustomKeywords.'wemine.WeMineKeywords.openWebApp'()
try {
    CustomKeywords.'wemine.WeMineKeywords.setWebField'('Username', System.getenv('WEMINE_TEST_USERNAME'))
    try { CustomKeywords.'wemine.WeMineKeywords.tapWeb'('Continue', 5) } catch (Exception ignored) { CustomKeywords.'wemine.WeMineKeywords.tapWeb'('Next', 5) }
    CustomKeywords.'wemine.WeMineKeywords.completeMicrosoftSignInWeb'()
    String syncText = System.getenv('WEMINE_SYNC_IN_PROGRESS_TEXT')
    if (!syncText) com.kms.katalon.core.util.KeywordUtil.markFailedAndStop('Set WEMINE_SYNC_IN_PROGRESS_TEXT to the progress label shown during master-data sync.')
    CustomKeywords.'wemine.WeMineKeywords.verifyWebText'(syncText, 30)
    CustomKeywords.'wemine.WeMineKeywords.setWebOffline'(true)
    CustomKeywords.'wemine.WeMineKeywords.verifyWebText'(syncText, 10)
    CustomKeywords.'wemine.WeMineKeywords.verifyWebTextNotPresent'('restart', 3)
} finally {
    try { CustomKeywords.'wemine.WeMineKeywords.setWebOffline'(false) } catch (Exception ignored) {}
    CustomKeywords.'wemine.WeMineKeywords.closeWeb'()
}
