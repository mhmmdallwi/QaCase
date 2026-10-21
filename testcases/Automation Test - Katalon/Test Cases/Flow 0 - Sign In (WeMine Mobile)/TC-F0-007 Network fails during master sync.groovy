// Preconditions: valid user and controllable network; interrupt network during initial master-data synchronization.
CustomKeywords.'wemine.WeMineKeywords.assertEnvironment'('WEMINE_TEST_USERNAME')
CustomKeywords.'wemine.WeMineKeywords.startMobile'()
try {
    CustomKeywords.'wemine.WeMineKeywords.setMobileField'('Username', System.getenv('WEMINE_TEST_USERNAME'))
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'('Continue')
    CustomKeywords.'wemine.WeMineKeywords.verifyMobileText'('Microsoft', 20)
    CustomKeywords.'wemine.WeMineKeywords.completeMicrosoftSignIn'()
    CustomKeywords.'wemine.WeMineKeywords.verifyMobileText'('sync', 20)
    CustomKeywords.'wemine.WeMineKeywords.setAndroidNetworkEnabled'(false)
    CustomKeywords.'wemine.WeMineKeywords.verifyMobileText'('sync', 20)
    CustomKeywords.'wemine.WeMineKeywords.verifyMobileTextNotPresent'('restart', 3)
    String homeMarker = System.getenv('WEMINE_MOBILE_HOME_MARKER')
    if (homeMarker) CustomKeywords.'wemine.WeMineKeywords.verifyMobileTextNotPresent'(homeMarker, 3)
} finally {
    try { CustomKeywords.'wemine.WeMineKeywords.setAndroidNetworkEnabled'(true) } catch (Exception ignored) {}
    CustomKeywords.'wemine.WeMineKeywords.closeMobile'()
}
