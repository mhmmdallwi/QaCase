// Preconditions: Chromium with CDP support; login page is loaded before network is disabled.
CustomKeywords.'wemine.WeMineKeywords.assertEnvironment'('WEMINE_TEST_USERNAME')
CustomKeywords.'wemine.WeMineKeywords.openWebApp'()
try {
    CustomKeywords.'wemine.WeMineKeywords.setWebOffline'(true)
    CustomKeywords.'wemine.WeMineKeywords.setWebField'('Username', System.getenv('WEMINE_TEST_USERNAME'))
    try { CustomKeywords.'wemine.WeMineKeywords.tapWeb'('Continue', 5) } catch (Exception ignored) { CustomKeywords.'wemine.WeMineKeywords.tapWeb'('Next', 5) }
    CustomKeywords.'wemine.WeMineKeywords.verifyWebFieldPresent'('Username', 5)
    CustomKeywords.'wemine.WeMineKeywords.verifyWebFieldNotPresent'('Email', 3)
} finally {
    try { CustomKeywords.'wemine.WeMineKeywords.setWebOffline'(false) } catch (Exception ignored) {}
    CustomKeywords.'wemine.WeMineKeywords.closeWeb'()
}
