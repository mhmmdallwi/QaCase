// Preconditions: username belongs to a tenant configured for Microsoft authentication.
CustomKeywords.'wemine.WeMineKeywords.assertEnvironment'('WEMINE_TEST_USERNAME')
CustomKeywords.'wemine.WeMineKeywords.openWebApp'()
try {
    CustomKeywords.'wemine.WeMineKeywords.setWebField'('Username', System.getenv('WEMINE_TEST_USERNAME'))
    try { CustomKeywords.'wemine.WeMineKeywords.tapWeb'('Continue', 5) } catch (Exception ignored) { CustomKeywords.'wemine.WeMineKeywords.tapWeb'('Next', 5) }
    CustomKeywords.'wemine.WeMineKeywords.verifyWebFieldPresent'('Email', 20)
} finally { CustomKeywords.'wemine.WeMineKeywords.closeWeb'() }
