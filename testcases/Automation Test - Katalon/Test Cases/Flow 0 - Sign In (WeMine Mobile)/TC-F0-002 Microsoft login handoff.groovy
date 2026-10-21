// Preconditions: username maps to a tenant configured for Microsoft authentication.
CustomKeywords.'wemine.WeMineKeywords.assertEnvironment'('WEMINE_TEST_USERNAME')
CustomKeywords.'wemine.WeMineKeywords.startMobile'()
try {
    CustomKeywords.'wemine.WeMineKeywords.setMobileField'('Username', System.getenv('WEMINE_TEST_USERNAME'))
    CustomKeywords.'wemine.WeMineKeywords.tapMobile'('Continue')
    CustomKeywords.'wemine.WeMineKeywords.verifyMobileText'('Microsoft', 20)
} finally { CustomKeywords.'wemine.WeMineKeywords.closeMobile'() }
