// Preconditions: app data cleared or a dedicated device/user has never completed initial master sync.
CustomKeywords.'wemine.WeMineKeywords.assertEnvironment'('WEMINE_TEST_USERNAME')
CustomKeywords.'wemine.WeMineKeywords.startMobile'()
try {
    CustomKeywords.'wemine.WeMineKeywords.setMobileField'('Username', System.getenv('WEMINE_TEST_USERNAME'))
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'('Continue')
    CustomKeywords.'wemine.WeMineKeywords.verifyMobileText'('Microsoft', 20)
    CustomKeywords.'wemine.WeMineKeywords.completeMicrosoftSignIn'()
    CustomKeywords.'wemine.WeMineKeywords.verifyMobileText'('restart', 60)
} finally { CustomKeywords.'wemine.WeMineKeywords.closeMobile'() }
