// Preconditions: use a signed-out test app and a valid username; the Android device must allow network control through ADB.
CustomKeywords.'wemine.WeMineKeywords.assertEnvironment'('WEMINE_TEST_USERNAME')
CustomKeywords.'wemine.WeMineKeywords.startMobile'()
try {
    CustomKeywords.'wemine.WeMineKeywords.setAndroidNetworkEnabled'(false)
    CustomKeywords.'wemine.WeMineKeywords.setMobileField'('Username', System.getenv('WEMINE_TEST_USERNAME'))
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'('Continue')
    CustomKeywords.'wemine.WeMineKeywords.verifyMobileFieldPresent'('Username', 10)
    String homeMarker = System.getenv('WEMINE_MOBILE_HOME_MARKER')
    if (homeMarker) CustomKeywords.'wemine.WeMineKeywords.verifyMobileTextNotPresent'(homeMarker, 3)
} finally {
    try { CustomKeywords.'wemine.WeMineKeywords.setAndroidNetworkEnabled'(true) } catch (Exception ignored) {}
    CustomKeywords.'wemine.WeMineKeywords.closeMobile'()
}
